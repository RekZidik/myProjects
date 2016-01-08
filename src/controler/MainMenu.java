package controler;

import model.University;

/**
 * Created by RekZidik on 07/01/2016.
 */
public class MainMenu extends BaseController<University> {


    public MainMenu(Controller father,University university) {
        super(father,university);
    }

    @Override
    public void printMenu() {
        getModel().printState();
        System.out.println("1: Manage Formations.");
        System.out.println("2: Manage Teachers.");
        System.out.println("3: Manage Blocks.");
        System.out.println("4: Manage Slots.");

    }

    @Override
    public void consume(int response) {
        switch (response){

        }
    }
}
