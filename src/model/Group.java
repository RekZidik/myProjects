package model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RekZidik on 06/01/2016.
 */
public class Group extends Model {
    public static final int COUR_GROUP = 0;
    public static final int TD_GROUP = 1;
    public static final int TP_GROUP = 2;

    private Module module;
    private int type;

    public Group(Module module, int type) {
        this.module = module;
        this.type = type;
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
        this.id = id;
    }

    @Override
    public boolean fromJSON(JSONObject jsonObject) throws JSONException {
        return false;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void printState() {

    }
}
