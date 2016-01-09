package model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Level;

/**
 * Created by RekZidik on 01/12/2015.
 */
public abstract class Hall extends Model {
    private final int COUR_FLAG= 1;
    private final int TD_FLAG=10;
    private final int TP_FLAG=100;

    private  int seanceType;
    private boolean projector;
    private int capacity;
    private Floor localisation;

    public Hall(int seanceType, int capacity, boolean projector, Floor localisation) {
        this.seanceType = seanceType;
        this.projector = projector;
        this.capacity = capacity;
        this.localisation = localisation;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isProjector() {
        return projector;
    }

    public Floor getLocalisation() {
        return localisation;
    }

    public boolean isValidForTd(){
        return (seanceType & TD_FLAG) > 0;
    }

    public boolean isValidForTp(){
        return (seanceType & TP_FLAG) > 0;
    }

    public boolean isValidForCours(){
        return (seanceType & COUR_FLAG) > 0;
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
