package model;

import org.json.JSONObject;

/**
 * Created by RekZidik on 01/12/2015.
 */
public class Student extends Model {
    @Override
    public JSONObject fromJSON() {
        return null;
    }

    @Override
    public boolean toJSON(JSONObject jsonObject) {
        return false;
    }

    @Override
    public void printState() {

    }
}
