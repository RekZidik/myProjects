package model;

import model.manager.ModuleHandler;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by RekZidik on 27/12/2015.
 */
public class Formation extends Model{
    private static final int MAX_SIZE_GROUP =20;
    private static int nbrInstances;
    private String id;
    private String nomination;
    private int students;
    private ModuleHandler modules;


    public Formation(String nomination, int students) {
        this.nomination = nomination;
        setStudents(students);
        this.modules = new ModuleHandler(this);
        this.label = generateLabel(nomination);
        this.id = generateId();
        nbrInstances++;
    }


    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setId(String id) {
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

    public Iterator<Module> getModules() {
        return modules.iterator();
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
