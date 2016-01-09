package model.manager;

import model.Block;
import model.Floor;
import model.Hall;

/**
 * Created by RekZidik on 07/01/2016.
 */
public class BlocksManager extends Manager<Block> {

    public boolean containsHall(String id){
        return stream().filter(x->x.containsHall(id)).count()>0;
    }

    public boolean containsHall(Hall hall){
        return stream().filter(x->x.containsHall(hall)).count()>0;
    }

    public boolean containsFloor(String id){
        return stream().filter(x->x.containsFloor(id)).count()>0;
    }

    public boolean containsFloor(Floor floor){
        return stream().filter(x->x.containsFloor(floor)).count()>0;
    }

    @Override
    public Block getModelInstance() {
        return new Block(getLabel());
    }

    @Override
    public boolean add(Block m) {
        return _add(m);
    }

    @Override
    public boolean remove(Block m) {
        return _remove(m);
    }
}
