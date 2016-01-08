package model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by RekZidik on 05/01/2016.
 */
public class Slot extends Model implements OverlapCapacity<Slot>{

    private Duration duration;
    private Group group;
    private Teacher teacher;
    private Hall hall;

    public Slot(Duration duration, Group group, Teacher teacher, Hall hall) {
        this.duration = duration;
        this.group = group;
        this.teacher = teacher;
        this.hall = hall;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @Override
    public boolean fromJSON(JSONObject jsonObject) throws JSONException {
        return false;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void printState() {

    }

    @Override
    public boolean overlapWith(Slot other) {
        return duration.overlapWith(other.getDuration())&& getGroup().equals(other.getGroup());
    }

    public static class Duration extends Model implements OverlapCapacity<Duration>{
        private Date begin;
        private Date end;

        public Duration(Date begin, Date end) {
            if(begin.getTime()<end.getTime()) {
                this.begin = begin;
                this.end = end;
            }
            else {
                this.begin = end;
                this.end = begin;
            }
        }

        public boolean overlapWith(Duration duration){
            return getBegin().compareTo(duration.getEnd()) > 0 || getEnd().compareTo(duration.getBegin()) < 0;
        }

        public Date getBegin() {
            return begin;
        }

        public void setBegin(Date begin) {
            if (begin.compareTo(this.end) < 0)
                this.begin = begin;
            else{
                this.begin = end;
                this.end = begin;
            }
        }

        public Date getEnd() {
            return end;
        }

        public void setEnd(Date end) {
            if (end.compareTo(this.begin) > 0)
                this.end = end;
            else {
                this.end = begin;
                this.begin = end;
            }
        }

        @Override
        public boolean fromJSON(JSONObject jsonObject) throws JSONException {
            return false;
        }

        @Override
        public JSONObject toJSON() {
            return null;
        }

        @Override
        public void printState() {

        }
    }
}
