package model.manager;

import model.Teacher;
import model.University;

/**
 * Created by RekZidik on 27/12/2015.
 */
public class TeachersManager extends Manager<Teacher> {

    public TeachersManager() {
        label = "Teachers";
    }

    @Override
    public Teacher getModelInstance() {
        return new Teacher();
    }

    @Override
    public boolean add(Teacher m) {
        return _add(m);
    }

    @Override
    public boolean remove(Teacher m) {
        return University.getInstance().getSlots().stream(m).count() <= 0 && _remove(m);
    }

    @Override
    public void printGlobalStat() {
        super.printGlobalStat();
        System.out.println("Naming Grades");
        for (String e :
                Teacher.GRADES) {
            System.out.println(e);
        }
    }
}
