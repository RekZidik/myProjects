package controler;

import model.Model;

import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RekZidik on 07/01/2016.
 */
public abstract class BaseController<T extends Model> implements Controller {
    public static final int BACK_INPUT = 0;

    private Optional<Controller> father;
    private T model;
    private boolean hook;

    public BaseController(Controller father, T model) {
        this.father = Optional.ofNullable(father);
        this.model = model;
        hook = true;
    }

    @Override
    public Optional<Controller> getFather() {
        return father;
    }

    public T getModel(){
        return model;
    }

    @Override
    public void interact() {
        getModel().printState();
        printMenu();
        if(hook)
            System.out.println("0: Previous.");
        Pattern pattern = Pattern.compile("^\\d$");
        Scanner scanner = new Scanner(System.in);
        String input;
        Matcher matcher;
        boolean result = false;
        while (!result){
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
            result = matcher.find() && consume(Integer.valueOf(input));
            printErrorMessage();
        }

    }

    protected void setHook(boolean hook){
        this.hook = hook;
    }

    protected abstract void printMenu() ;


    private boolean consume(int response) {
        if (response == BACK_INPUT && getFather().isPresent())
            getFather().get().interact();
        return interact(response);
    }

    protected abstract boolean interact(int response);

    protected void printErrorMessage(){
        System.out.println("Incorrect Input! Retry");
    }
}
