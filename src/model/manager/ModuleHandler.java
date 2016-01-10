package model.manager;

import model.Formation;
import model.Group;
import model.Module;

/**
 * Created by RekZidik on 05/01/2016.
 */
public class ModuleHandler extends Manager<Module>{

    private Formation formation;

    public ModuleHandler(Formation formation) {
        this.formation = formation;
    }

    public boolean contains(Group group){
        return stream().filter(x->x.contains(group)).count()>0;
    }

    public boolean containsGroup(String id){
        return stream().filter(x->x.containsGroup(id)).count()>0;
    }

    @Override
    public Module getModelInstance() {
        return new Module(formation,"Unknown",false,new Module.StudiesHours(6,6,6));
    }

    @Override
    public boolean add(Module m) {
        return _add(m);
    }

    @Override
    public boolean remove(Module m) {
        return _remove(m);
    }
}
