package model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Level;

/**
 * Created by RekZidik on 01/12/2015.
 */
public abstract class Hall extends Model {
    private static int nbrInstances = 1;
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
        this.label = localisation.getLabel().concat(String.valueOf(nbrInstances++));
    }

    public Hall() {
    }


    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setId(String id) {
        while (University.getInstance().getBlocks().containsHall(id))
            id=generateId();
        this.id = id;
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
        seanceType = getInt(jsonObject,"seanceType",COUR_FLAG);
        capacity = getInt(jsonObject,"capacity",0);
        localisation.fromJSON(getJSONObject(jsonObject,"localisation",new JSONObject()));
        projector = getBoolean(jsonObject,"projector",false);
        label = getString(jsonObject,"label",getLabel());
        return true;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject data = new JSONObject();
        data.put("seanceType",seanceType);
        data.put("capacity",capacity);
        data.put("projector",projector);
        data.put("label",label);
        data.put("localisation",localisation.toJSON());
        return data;
    }

    @Override
    public void printState() {
        System.out.println(getLabel());
    }
}
