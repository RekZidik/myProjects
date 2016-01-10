package controler;

import model.manager.FormationsManager;

/**
 * Created by RekZidik on 08/01/2016.
 */
public class ManageFormationsController extends BaseController<FormationsManager> {
    public ManageFormationsController(Controller father, FormationsManager model) {
        super(father, model);
    }

    @Override
    protected void printMenu() {
        System.out.println("1: Add Formation.");
        System.out.println("2: Delete Formation.");
        System.out.println("3: Shows Formations.");
    }

    @Override
    protected boolean interact(String response) {
        switch (Integer.valueOf(response)){
            case 1:
                (new AddModelController<>(this,
                        getModel(),
                        new AddModelController.ConfigDisplay("^([\\w\\s]+/[\\d]+)|([\\d])$","Formation naming/Students","/"))
                ).interact();
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
