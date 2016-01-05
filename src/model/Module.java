package model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by RekZidik on 26/12/2015.
 */
public class Module extends Model implements ModuleOption {
    private static int nbrInstances;
    private String label;
    private String nomination;
    private String id;
    private boolean optional;
    private StudiesHours hours;
    private ArrayList<String> groupsTD;
    private ArrayList<String> groupsTP;

    public Module(String nomination, boolean optional, StudiesHours hours) {
        this.nomination = nomination;
        this.label = generateLabel(nomination);
        this.optional = optional;
        this.hours = hours;
        this.id = generateId();
        nbrInstances++;

    }

    @Override
    public String getId() {
        return id;
    }

    private void setId(String id){
        this.id = id;
    }

    private String generateLabel(String label){
        String[] tab = label.split(" ");
        String id= "";
        for (String st : tab){
            if (st.length()>1)
                id=id.concat(st.substring(0,2).toUpperCase()).concat("_");
            else
                id=id.concat(st.toUpperCase()).concat("_");
        }
        return id.concat(String.valueOf(nbrInstances));
    }

    public ArrayList<String> getGroupsTD() {
        return groupsTD;
    }

    public void setGroupsTD(ArrayList<String> groupsTD) {
        this.groupsTD = groupsTD;
    }

    public String getNomination() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
    }


    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    @Override
    public boolean fromJSON(JSONObject jsonObject) {
        try {

            setNomination(jsonObject.getString("nomination"));
            setId(jsonObject.getString("id"));
        }catch (JSONException e){
            return false;
        }

        return true;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject data = new JSONObject();
        data.put("label", getLabel());

        data.put("id",getId());
        return data;
    }

    @Override
    public void printState() {

    }

    class StudiesHours extends Model{

        private int TDHs;
        private int TPHs;
        private int CourHs;

        public StudiesHours(int TDHs, int TPHs, int courHs) {
            this.TDHs = TDHs;
            this.TPHs = TPHs;
            CourHs = courHs;
        }

        public int getTDHs() {
            return TDHs;
        }

        public void setTDHs(int TDHs) {
            this.TDHs = TDHs;
        }

        public int getTPHs() {
            return TPHs;
        }

        public void setTPHs(int TPHs) {
            this.TPHs = TPHs;
        }

        public int getCourHs() {
            return CourHs;
        }

        public void setCourHs(int courHs) {
            CourHs = courHs;
        }

        @Override
        public boolean fromJSON(JSONObject jsonObject) throws JSONException {
            setCourHs(getInt(jsonObject,"CourHs",6));
            setTDHs(getInt(jsonObject,"TDHs",3));
            setTPHs(getInt(jsonObject,"TPHs",3));
            return true;
        }

        @Override
        public JSONObject toJSON() {
            JSONObject data = new JSONObject();
            data.put("CourHs",getCourHs());
            data.put("TDHs",getTDHs());
            data.put("TPHs",getTPHs());
            return data;
        }

        @Override
        public void printState() {

        }
    }
}
