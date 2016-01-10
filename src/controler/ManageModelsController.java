package controler;

import model.Model;
import model.manager.Manager;
import model.manager.TeachersManager;

/**
 * Created by RekZidik on 09/01/2016.
 */
public class ManageModelsController<T extends Model> extends BaseController<Manager<T>> {

    private AddModelController.ConfigDisplay config;

    public ManageModelsController(Controller father, Manager<T> model,AddModelController.ConfigDisplay configDisplay) {
        super(father, model);
        this.config = configDisplay;
    }

    @Override
    protected void printMenu() {
        String name = getNameModel(getModel());
        System.out.println("1: Add ".concat(name));
        System.out.println("2: Delete ".concat(name));
        System.out.println("3: Show ".concat(name).concat("s"));
    }

    @Override
    protected boolean interact(String response) {
        switch (Integer.valueOf(response)){
            case 1:
                (new AddModelController<>(this, getModel(), config)).interact();
                return true;

            case 2:
                (new RemoveModelController<>(this,getModel())).interact();
                return true;

            case 3:
                getModel().printState();
                interact();
                return true;
        }

        return false;
    }

    @Override
    protected void printStatModel() {
        getModel().printGlobalStat();
    }
}
