package model.manager;

import model.Teacher;

/**
 * Created by RekZidik on 27/12/2015.
 */
public class TeachersManager extends Manager<Teacher> {
    @Override
    public String getId() {
        return null;
    }

    public String getLabel() {
        return null;
    }

    @Override
    public Teacher getModelInstance() {
        return new Teacher();
    }

    @Override
    public boolean add(Teacher m) {
        return _add(m);
    }

    @Override
    public boolean remove(Teacher m) {
        return _remove(m);
    }
}
