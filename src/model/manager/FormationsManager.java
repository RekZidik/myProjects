package model.manager;

import model.Formation;

/**
 * Created by RekZidik on 07/01/2016.
 */
public class FormationsManager extends Manager<Formation> {
    @Override
    public Formation getModelInstance() {
        return new Formation(getLabel(),-1);
    }

    @Override
    public boolean add(Formation m) {
        return _add(m);
    }

    @Override
    public boolean remove(Formation m) {
        return _remove(m);
    }
}
