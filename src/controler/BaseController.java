package controler;

import model.Model;

/**
 * Created by RekZidik on 07/01/2016.
 */
public abstract class BaseController<T extends Model> implements Controller {

    private Controller father;
    private T model;

    public BaseController(Controller father, T model) {
        this.father = father;
        this.model = model;
    }

    @Override
    public Controller getFather() {
        return father;
    }

    public T getModel(){
        return model;
    }


    public abstract void printMenu() ;


    public abstract void consume(int response) ;
}
