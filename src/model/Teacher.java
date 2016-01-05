package model;


import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Object represent the teacher in our Model
 * Created by RekZidik on 01/12/2015.
 */
public class Teacher extends Model {
    public static ArrayList<String> GRADES;
    static {
        GRADES=new ArrayList<>();
        GRADES.add("Maître assistant");
        GRADES.add("Maître de conférence A");
        GRADES.add("Maître de conférence B");
        GRADES.add("Professeur");
    }
    private String id;
    private String name;
    private String firstName;
    private String grade;
    private ArrayList<String> taughtModules;

    public Teacher(String name, String firstName, String grade, ArrayList<String> taughtModules) {
        this.name = name;
        this.firstName = firstName;
        this.grade = grade;
        this.taughtModules = taughtModules;
    }

    public Teacher() {
        this.name = "John";
        this.firstName = "Do";
        this.grade = GRADES.get(0);
        this.taughtModules = new ArrayList<>();
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

    public ArrayList<String> getTaughtModules() {
        return taughtModules;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean fromJSON(JSONObject jsonObject) {
        return false;
    }

    @Override
    public JSONObject toJSON() {
        return null;
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
