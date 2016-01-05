package model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RekZidik on 05/01/2016.
 */
public class Floor extends Model {


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
