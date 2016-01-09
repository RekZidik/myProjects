package model.manager;

import model.Group;
import model.Slot;
import model.TDHall;
import model.Teacher;

/**
 * Created by RekZidik on 09/01/2016.
 */
public class SlotsManager extends Manager<Slot> {
    @Override
    public Slot getModelInstance() {
        return new Slot(new Slot.Duration(),new Group(),new Teacher(),new TDHall());
    }

    @Override
    public boolean add(Slot m) {
        return _add(m);
    }

    @Override
    public boolean remove(Slot m) {
        return _remove(m);
    }
}
