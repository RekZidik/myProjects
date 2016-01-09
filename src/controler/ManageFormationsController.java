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
        System.out.println("On construction");
    }

    @Override
    protected boolean interact(int response) {

        return false;
    }
}
