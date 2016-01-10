package model.manager;

import model.Block;
import model.Floor;
import model.Hall;

import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Stream;

/**
 * Created by RekZidik on 07/01/2016.
 */
public class FloorsHandler extends Manager<Floor> {
    private Block block;

    public FloorsHandler(Block block) {
        this.block = block;
    }

    public Stream<Hall> streamHalls(){
        return stream().flatMap(Floor::streamHalls);
    }

    public Optional<Hall> getHall(String id){
        return streamHalls().filter(x->x.getId().equals(id)).findFirst();
    }

    @Override
    public Floor getModelInstance() {
        return new Floor(block.getLabel().concat(String.valueOf(length())),block);
    }

    @Override
    public boolean add(Floor m) {
        return _add(m);
    }

    @Override
    public boolean remove(Floor m) {
        return _remove(m);
    }
}
