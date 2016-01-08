package model;

import model.manager.BlocksManager;
import model.manager.FormationsManager;
import model.manager.TeachersManager;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RekZidik on 06/01/2016.
 */
public class University extends Model{

    static private University university;

    private BlocksManager blocks;
    private FormationsManager formations;
    private TeachersManager teachers;
    private String name;

    private University() {
        blocks = new BlocksManager();
        formations = new FormationsManager();
        teachers = new TeachersManager();
    }

    public BlocksManager getBlocks() {
        return blocks;
    }

    public FormationsManager getFormations() {
        return formations;
    }

    public TeachersManager getTeachers() {
        return teachers;
    }

    @Override
    public boolean fromJSON(JSONObject jsonObject) throws JSONException {
        label = getString(jsonObject,"name","UPEC");
        blocks.fromJSONArray(getJSONArray(jsonObject,"blocks",blocks.toJSONArray()));
        formations.fromJSONArray(getJSONArray(jsonObject,"formations",formations.toJSONArray()));
        teachers.fromJSONArray(getJSONArray(jsonObject,"teachers",teachers.toJSONArray()));
        return true;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject data = new JSONObject();
        data.put("name",label);
        data.put("blocks",blocks.toJSONArray());
        data.put("formations",formations.toJSONArray());
        data.put("teachers",teachers.toJSONArray());
        return data;
    }

    @Override
    public void printState() {

        System.out.println(getLabel());
        System.out.print("Formations : ");System.out.println(getFormations().length());
        System.out.print("Blocks : ");System.out.println(getBlocks().length());
        System.out.print("Teachers : ");System.out.println(getTeachers().length());
        System.out.print("Students : ");
        System.out.println(
                        getFormations()
                        .stream().mapToInt(Formation::getStudents)
                        .reduce(0,(x,y)-> x+y)
        );
    }

    static University getInstance(){
        if(university == null){
            university = new University();
            return university;
        }
        else
            return university;
    }
}
