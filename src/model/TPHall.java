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
    private boolean projector;

    public TPHall(int seanceType, int capacity, boolean projector, Floor localisation, int outlets) {
        super(seanceType, capacity, projector, localisation);
        this.outlets = outlets;
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
