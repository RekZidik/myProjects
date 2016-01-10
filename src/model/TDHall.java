package model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RekZidik on 01/12/2015.
 */
public class TDHall extends Hall {

    public TDHall(int seanceType, int capacity, boolean projector, Floor localisation) {
        super(seanceType, capacity, projector, localisation);
    }

    public TDHall() {
    }


    @Override
    public boolean fromJSON(JSONObject jsonObject) throws JSONException {
        super.fromJSON(jsonObject);
        return false;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject data = super.toJSON();
        return data;
    }

    @Override
    public void printState() {
        super.printState();

    }
}
