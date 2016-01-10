package model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RekZidik on 01/12/2015.
 */
public class TPHall extends Hall{
    public static final int TPHALL_INFO = 0;
    public static final int TPHALL_CHEMISTRY = 1;
    private int outlets;

    public TPHall(int seanceType, int capacity, boolean projector, Floor localisation, int outlets) {
        super(seanceType, capacity, projector, localisation);
        this.outlets = outlets;
    }


    @Override
    public boolean fromJSON(JSONObject jsonObject) throws JSONException {
        super.fromJSON(jsonObject);
        outlets = getInt(jsonObject,"outlets",0);
        return true;
    }

    public TPHall() {
    }

    @Override
    public JSONObject toJSON() {
        JSONObject data = super.toJSON();
        data.put("outlets",outlets);
        return data;
    }

}
