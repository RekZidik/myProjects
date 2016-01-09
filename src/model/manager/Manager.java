package model.manager;

import model.Model;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by RekZidik on 26/12/2015.
 */
public abstract class  Manager<T extends Model> extends Model{

    private ArrayList<T> list;

    public Manager() {
        list= new ArrayList<>();
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    protected boolean _add(T m){
        return list.add(m);
    }

    protected boolean _remove(T m){
        return list.remove(m);
    }

    /**
     *
     * @return Number of Model objects managed
     */
    public Iterator<T> iterator(){
        return list.iterator();
    }

    public int length(){
        return list.size();
    }

    public boolean fromJSONArray(JSONArray array){
        Iterator iterator = array.iterator();
        boolean result=true;
        while (iterator.hasNext()){
            T item = getModelInstance();
            result=result && item.fromJSON((JSONObject) iterator.next());
        }
        return result;
    }

    public JSONArray toJSONArray(){
        JSONArray array = new JSONArray();
        for (Model aList : list) {
            array.put(aList.toJSON());
        }
        return array;
    }

    public Stream<T> stream(){
        return list.stream();
    }

    public boolean contains(String id){
        return stream().filter(x->x.getId().equals(id)).count()>0;
    }

    public boolean contains(T model){
        return list.contains(model);
    }

    /**
     *@return an instance of Model object managed
     */
    public abstract T getModelInstance();

    /**
     * Add item to objects managed
     * @return Result of operation
     */
    public abstract boolean add(T m);

    /**
     * Remove item from objects managed
     * @return Result of operation
     */
    public abstract boolean remove(T m);

    @Override
    public boolean fromJSON(JSONObject jsonObject) {
        return false;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void printState() {
        System.out.println(getLabel());
        System.out.println(length()+" ".concat(getLabel()));

    }
}
