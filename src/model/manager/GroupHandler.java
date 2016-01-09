package model.manager;

import model.Group;
import model.Module;

/**
 * Created by RekZidik on 07/01/2016.
 */
public class GroupHandler extends Manager<Group> {

    private Module module;

    public GroupHandler(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }

    @Override
    public Group getModelInstance() {
        return new Group(module,Group.COUR_GROUP);
    }

    @Override
    public boolean add(Group m) {
        return false;
    }

    @Override
    public boolean remove(Group m) {
        return false;
    }
}
