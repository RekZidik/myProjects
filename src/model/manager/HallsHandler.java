package model.manager;

import model.Floor;
import model.Hall;
import model.TDHall;

/**
 * Created by RekZidik on 09/01/2016.
 */
public class HallsHandler extends Manager<Hall> {
    private Floor floor;

    public HallsHandler(Floor floor) {
        this.floor = floor;
    }

    @Override
    public Hall getModelInstance() {
        return new TDHall();
    }

    @Override
    public boolean add(Hall m) {
        return false;
    }

    @Override
    public boolean remove(Hall m) {
        return false;
    }
}
