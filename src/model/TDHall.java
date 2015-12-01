package model;

import jdk.nashorn.internal.parser.JSONParser;

/**
 * Created by RekZidik on 01/12/2015.
 */
public class TDHall extends Hall {
    @Override
    public JSONParser fromJSON() {
        return null;
    }

    @Override
    public boolean toJSON(JSONParser jsonParser) {
        return false;
    }
}
