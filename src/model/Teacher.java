package model;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Object represent the teacher in our Model
 * Created by RekZidik on 01/12/2015.
 */
public class Teacher extends Model {
    public static ArrayList<String> GRADES;
    static {
        GRADES=new ArrayList<>();
        GRADES.add("Maitre assistant");
        GRADES.add("Maitre de conference A");
        GRADES.add("Maitre de conference B");
        GRADES.add("Professeur");
    }

    private String name;
    private String firstName;
    private String grade;
    private ArrayList<String> taughtModules;

    public Teacher(String name, String firstName, String grade) {
        this.name = name;
        this.firstName = firstName;
        this.grade = grade;
        this.taughtModules = new ArrayList<>();
    }

    public Teacher() {
        this.name = "John";
        this.firstName = "Do";
        this.grade = GRADES.get(0);
        this.taughtModules = new ArrayList<>();
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setId(String id) {
        while (University.getInstance().getTeachers().contains(id))
            id=generateId();
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGrade() {
        return grade;
    }

    public Iterator<String> getTaughtModulesID() {
        return taughtModules.iterator();
    }

    @Override
    public boolean fromJSON(JSONObject jsonObject) {
        setId(getString(jsonObject,"id",generateId()));
        setLabel(getString(jsonObject,"label",getLabel()));
        name = getString(jsonObject,"name","John");
        firstName = getString(jsonObject,"firstName","Do");
        grade = getString(jsonObject,"grade",GRADES.get(0));
        JSONArray array = getJSONArray(jsonObject,"taughtModules",new JSONArray());
        for (int i = 0; i < array.length(); i++) {
            taughtModules.add(i,getString(array.optJSONObject(i),"id",""));
        }
        return false;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject data = new JSONObject();
        data.put("label", getLabel());
        data.put("id",getId());
        data.put("name",name);
        data.put("firstName",firstName);
        data.put("grade",grade);
        JSONArray array = new JSONArray();
        for (int i = 0; i < taughtModules.size(); i++) {
            array.put(i,new JSONObject("{id:".concat(taughtModules.get(i)).concat("}")));
        }
        data.put("taughtModules",array);
        return data;
    }


    @Override
    public void printState() {
        System.out.print("Identifiant:");
        System.out.println(getId());
        System.out.print("Nom:");
        System.out.println(getName());
        System.out.print("Prenom:");
        System.out.println(getFirstName());
        System.out.print("Grade:");
        System.out.println(getGrade());
    }
}
