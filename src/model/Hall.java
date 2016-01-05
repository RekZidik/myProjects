package model;

/**
 * Created by RekZidik on 01/12/2015.
 */
public abstract class Hall extends Model {
    private final int COUR_FLAG= 1;
    private final int TD_FLAG=10;
    private final int TP_FLAG=100;

    private  int seanceType;
    private boolean projector;

    public boolean isProjector() {
        return projector;
    }

    public boolean isValidForTd(){
        return (seanceType & TD_FLAG)>0;
    }

    public boolean isValidForTp(){
        return (seanceType & TP_FLAG)>0;
    }

    public boolean isValidForCours(){
        return (seanceType & COUR_FLAG)>0;
    }
}
