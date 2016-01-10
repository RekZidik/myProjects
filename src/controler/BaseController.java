package controler;

import model.Model;
import model.manager.Manager;

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
    private String regexResponse;
    protected Matcher matcher;


    public BaseController(Controller father, T model) {
        this.father = Optional.ofNullable(father);
        this.model = model;
        this.hook = true;
        this.regexResponse = "^\\d$";
    }

    @Override
    public Optional<Controller> getFather() {
        return father;
    }

    public T getModel(){
        return model;
    }

    protected void setRegexResponse(String regexResponse){
        this.regexResponse = regexResponse;
    }

    @Override
    public final void interact() {
        printStatModel();
        printMenu();
        if(hook)
            System.out.println("0: Previous.");
        Pattern pattern = Pattern.compile(regexResponse);
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean result = false;
        while (!result){
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
            result = matcher.find() && consume(input);
            if (!result)
                printErrorMessage();
        }
        if (getFather().isPresent())
            getFather().get().interact();
        else
            interact();
    }

    protected void setHook(boolean hook){
        this.hook = hook;
    }

    protected abstract void printMenu() ;


    private boolean consume(String response) {
        if (matcher.groupCount()== 0 && Integer.valueOf(response) == BACK_INPUT && getFather().isPresent())
            getFather().get().interact();
        return interact(response);
    }

    protected abstract boolean interact(String response);

    protected void printErrorMessage(){
        System.out.println("Incorrect Input! Retry");
    }

    protected void printSuccessMessage(){
        System.out.println("Operation performed");
    }

    protected void printStatModel(){
        getModel().printState();
    }

    protected <S extends Model>String getNameModel(Manager<S> manager){
        String[] name = manager.getModelInstance().getClass().getName().split("\\.");
        return name[name.length-1];
    }
}
