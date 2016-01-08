package model.manager;

import model.Formation;
import model.Module;

/**
 * Created by RekZidik on 05/01/2016.
 */
public class ModuleHandler extends Manager<Module>{

    private Formation formation;

    public ModuleHandler(Formation formation) {
        this.formation = formation;
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
