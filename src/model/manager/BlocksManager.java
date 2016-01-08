package model.manager;

import model.Block;

/**
 * Created by RekZidik on 07/01/2016.
 */
public class BlocksManager extends Manager<Block> {
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
