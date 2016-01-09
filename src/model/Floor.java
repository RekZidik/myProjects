package model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RekZidik on 05/01/2016.
 */
public class Floor extends Model {

    private Block block;

    public Floor(String label,Block block) {
        this.label = block.getLabel().concat("_").concat(label);
        this.block = block;
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
