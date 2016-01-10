package controler;

import model.Block;
import model.Teacher;
import model.University;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


/**
 * Created by RekZidik on 07/01/2016.
 */
public class MainMenu extends BaseController<University> {


    public MainMenu(Controller father,University university) {
        super(father,university);
        setHook(false);
    }




    @Override
    public void printMenu() {
        System.out.println("1: Manage Formations.");
        System.out.println("2: Manage Teachers.");
        System.out.println("3: Manage Blocks.");
        System.out.println("4: Manage Slots.");
    }



    protected boolean interact(String response) {
        switch (Integer.valueOf(response)){
            case 1:
                (new ManageModelsController<>(
                        this,
                        getModel().getFormations(),
                        new AddModelController.ConfigDisplay("^([\\w\\s]+/[\\d]+)|([\\d])$","Formation naming/Students","/"))
                ).interact();
                return true;

            case 2:
                (new ManageModelsController<>(
                        this,
                        getModel().getTeachers(),
                        new AddModelController.ConfigDisplay("^(([\\w\\s]+/){2}[\\w\\s]+)|([\\d])$","Name/First name/Grade","/"))
                ).interact();
                return true;
            case 3:
                (new ManageModelsController<>(
                        this,
                        getModel().getBlocks(),
                        new AddModelController.ConfigDisplay("^([\\w\\s]+)|([\\d])$","Label","/"))
                ).interact();
                return true;
            case 4:
                (new ManageSlotsController(this,getModel().getSlots())).interact();
                return true;


        }
        return false;

    }

    @Override
    protected void savingState() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("data.json", "UTF-8");
            System.out.println("Check Point(Work Saved)");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("Check Point(Work Not Saved)");
        }
        writer.print(University.getInstance().toJSON().toString());
        writer.close();
    }
}
