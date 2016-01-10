package controler;

import model.Formation;
import model.Model;
import model.manager.FormationsManager;
import model.manager.Manager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by RekZidik on 09/01/2016.
 */
public class AddModelController<T extends Model> extends BaseController<Manager<T>> {

    private ConfigDisplay config;

    public AddModelController(Controller father, Manager<T> model,ConfigDisplay configDisplay) {
        super(father, model);
        setHook(false);
        this.config = configDisplay;
        setRegexResponse(config.getRegex());
        //"^([\\w\\s]+/[\\d]+)|([\\d])$"
    }

    @Override
    protected void printMenu() {
        System.out.print(config.getMessage());
    }

    @Override
    protected boolean interact(String response) {
        String[] tab = matcher.group(1).split(config.getSeparator());
        Constructor<?> constructor ;
        T element=null;
        try {
            constructor = Model.class.getConstructor();

            for (Constructor<?> e : getModel().getModelInstance().getClass().getConstructors()){
                if(e.getParameterCount() > 0){
                    constructor = e;
                    break;
                }
            }
            element = (T) constructor.newInstance(tab);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        if(!getModel().add(element)) {
            printErrorMessage();
            return false;
        }

        printSuccessMessage();
        return true;
    }

    @Override
    protected void printStatModel() {
    }

    public static class ConfigDisplay{
        private String regex;
        private String message;
        private String separator;

        public ConfigDisplay(String regex, String message, String separator) {
            this.regex = regex;
            this.message = message;
            this.separator = separator;
        }

        public String getRegex() {
            return regex;
        }

        public void setRegex(String regex) {
            this.regex = regex;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getSeparator() {
            return separator;
        }

        public void setSeparator(String separator) {
            this.separator = separator;
        }
    }
}
