package controler;

/**
 * Created by RekZidik on 04/01/2016.
 */
public interface Controller {

    public Controller getFather();
    public void printMenu();
    public void consume(int response);
}
