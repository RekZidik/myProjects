package controler;

import model.University;

import java.util.Optional;

/**
 * Created by RekZidik on 07/01/2016.
 */
public class MainMenu extends BaseController<University> {


    public MainMenu(Controller father,University university) {
        super(father,university);
        setHook(false);
    }

    @Override
    protected void printMenu() {
        System.out.println("1: Manage Formations.");
        System.out.println("2: Manage Teachers.");
        System.out.println("3: Manage Blocks.");
        System.out.println("4: Manage Slots.");
    }



    protected boolean interact(int response) {
        switch (response){
            case 1:
                (new ManageFormationsController(this,getModel().getFormations())).interact();
                return true;

        }
        return false;
    }
}
