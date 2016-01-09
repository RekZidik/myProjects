import controler.MainMenu;
import model.University;
import org.json.JSONObject;



/**
 * Created by RekZidik on 08/01/2016.
 */
public class SchedulerApp {

    public static void main(String[] argv){
        University university = University.getInstance();
        university.fromJSON(new JSONObject());
        MainMenu menu = new MainMenu(null,university);
        menu.interact();
    }
}
