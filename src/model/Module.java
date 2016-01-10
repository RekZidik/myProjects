package model;

import model.manager.GroupHandler;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by RekZidik on 26/12/2015.
 */
public class Module extends Model implements ModuleOption {
    private static int nbrInstances;
    private Formation formation;
    private String nomination;
    private boolean optional;
    private StudiesHours hours;
    private GroupHandler groups;
    private int students;

    public Module(Formation formation,String nomination, boolean optional, StudiesHours hours) {
        this.formation = formation;
        this.nomination = nomination;
        this.label = generateLabel(nomination);
        this.optional = optional;
        this.hours = hours;
        this.groups = new GroupHandler(this);
        nbrInstances++;
    }

    public Module() {
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setId(String id) {
        while (University.getInstance().getFormations().containsModule(id))
            id=generateId();
        this.id = id;
    }

    public boolean contains(Group group){
        return groups.contains(group);
    }

    public boolean containsGroup(String id){
        return groups.contains(id);
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

    public String getNomination() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
    }


    public boolean isOptional() {
        return optional;
    }

    public Stream<Group> stream(){
        return groups.stream();
    }

    public Iterator<Group > iterator(){
        return groups.iterator();
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public Formation getFormation() {
        return formation;
    }

    @Override
    public boolean fromJSON(JSONObject jsonObject) {
        setId(getString(jsonObject,"id",generateId()));
        setLabel(getString(jsonObject,"label",getLabel()));
        setNomination(getString(jsonObject,"nomination",getLabel()));
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

    public static class StudiesHours extends Model{

        private int TDHs;
        private int TPHs;
        private int CourHs;

        public StudiesHours(int TDHs, int TPHs, int courHs) {
            this.TDHs = TDHs;
            this.TPHs = TPHs;
            CourHs = courHs;
        }

        @Override
        public void setLabel(String label) {
            this.label = label;
        }

        @Override
        public void setId(String id) {
            this.id = id;
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
