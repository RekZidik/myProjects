package model;

import model.manager.HallsHandler;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by RekZidik on 05/01/2016.
 */
public class Floor extends Model {

    private Block block;
    private HallsHandler halls;

    public Floor(String label,Block block) {
        this.label = block.getLabel().concat("_").concat(label);
        this.block = block;
        this.halls = new HallsHandler(this);
    }

    public Floor() {
    }

    public Block getBlock() {
        return block;
    }

    public Stream<Hall> streamHalls(){
        return halls.stream();
    }

    public boolean containsHall(String id){
       return halls.contains(id);
    }

    public boolean containsHall(Hall hall){
       return halls.contains(hall);
    }

    public Iterator<Hall> hallIterator(){
        return halls.iterator();
    }
    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setId(String id) {
        while (University.getInstance().getBlocks().containsFloor(id))
            id=generateId();
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
