package model;

import model.manager.FloorsHandler;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by RekZidik on 05/01/2016.
 */
public class Block extends Model {
    FloorsHandler floors ;

    public Block(String label) {
        this.label = label;
        this.floors = new FloorsHandler(this);
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
