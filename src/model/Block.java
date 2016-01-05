package model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by RekZidik on 05/01/2016.
 */
public class Block extends Model {
    String label;
    String id;
    ArrayList<String> floors = new ArrayList<>();

    public Block(String label, ArrayList<String> floors) {
        this.label = label;
        this.floors = floors;
        this.id = generateId();
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
