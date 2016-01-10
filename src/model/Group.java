package model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by RekZidik on 06/01/2016.
 */
public class Group extends Model {
    public static final int COUR_GROUP = 0;
    public static final int TD_GROUP = 1;
    public static final int TP_GROUP = 2;

    private Module module;
    private int type;
    private int index;

    public Group(Module module, int type, int index) {
        this.module = module;
        this.type = type;
        this.index = index;
    }

    public static String translateType(int type){
        switch (type){
            case COUR_GROUP:
                return "Cour";
            case TD_GROUP:
                return "TD";
            case TP_GROUP:
                return "TP";
            default:
                return "";
        }
    }

    public Group() {
    }

    public Module getModule() {
        return module;
    }

    public int getType() {
        return type;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setId(String id) {
        while (University.getInstance().getFormations().containsGroup(id))
            id=generateId();
        this.id = id;
    }

    public Formation getFormation(){
        return getModule().getFormation();
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean fromJSON(JSONObject jsonObject) throws JSONException {
        setId(getString(jsonObject,"id",generateId()));
        setLabel(getString(jsonObject,"label",getLabel()));
        module = University.getInstance().getFormations().getModule(getString(jsonObject,"module","")).get();
        type = getInt(jsonObject,"type",COUR_GROUP);
        index = getInt(jsonObject,"index",COUR_GROUP);
        return true;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject data = new JSONObject();
        data.put("label", getLabel());
        data.put("id",getId());
        data.put("module",module.toJSON());
        data.put("type",type);
        data.put("index",index);
        return data;
    }

    @Override
    public void printState() {
        if(type==COUR_GROUP)
            System.out.print("Cour Group");
        else
            System.out.print("Group".concat(String.valueOf(index)));
    }
}
