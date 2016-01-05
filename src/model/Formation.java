package model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by RekZidik on 27/12/2015.
 */
public class Formation extends Model{
    private static final int MAX_SIZE_GROUP =20;
    private static int nbrInstances;
    private String id;
    private String nomination;
    private int students;
    private ArrayList<String> modules;


    public Formation(String nomination, int students, ArrayList<String> modules) {
        this.nomination = nomination;
        setStudents(students);
        this.modules = modules;
        this.label = generateLabel(nomination);
        this.id = generateId();
        nbrInstances++;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        int temp = (students% MAX_SIZE_GROUP >0)?students/ MAX_SIZE_GROUP +1:students/ MAX_SIZE_GROUP;

        this.students = students;
    }

    public ArrayList<String> getModules() {
        return modules;
    }

    public void setModules(ArrayList<String> modules) {
        this.modules = modules;
    }


    private String generateLabel(String nomination){
        String[] tab = nomination.split(" ");
        String id= "";
        for (String st : tab){
                id=id.concat(String.valueOf(st.charAt(0)).toUpperCase()).concat("_");
        }
        return id.concat(String.valueOf(nbrInstances));
    }



    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean fromJSON(JSONObject jsonObject) throws JSONException {
        return false;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public void printState() {

    }
}
