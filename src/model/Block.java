package model;

import model.manager.FloorsHandler;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by RekZidik on 05/01/2016.
 */
public class Block extends Model {
    private FloorsHandler floors ;

    public Block(String label) {
        this.label = label;
        this.floors = new FloorsHandler(this);
    }

    public boolean containsHall(String id){
        return floors.stream().filter(x->x.containsHall(id)).count()>0;
    }
    public boolean containsHall(Hall hall){
        return floors.stream().filter(x->x.containsHall(hall)).count()>0;
    }

    public boolean containsFloor(String id){
        return floors.stream().filter(x->x.containsHall(id)).count()>0;
    }
    public boolean containsFloor(Floor floor){
        return floors.contains(floor);
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
