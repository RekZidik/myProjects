package model;

import org.json.JSONObject;

/**
 * Is the base classWork of our Model
 * Created by RekZidik on 01/12/2015.
 */
public abstract class Model {

    /**
     *
     * @return
     * JSON representation of Model Object
     */
    public abstract JSONObject fromJSON();


    /**
     *
     * @param jsonObject
     * JSON representation of Object Model
     * @return
     * boolean result of initialisation with parameter
     */
    public abstract boolean toJSON(JSONObject jsonObject);

    /**
     * Print in the standard Output state object
     */
    public abstract void printState();
}
