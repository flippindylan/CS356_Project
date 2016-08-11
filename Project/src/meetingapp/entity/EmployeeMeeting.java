package meetingapp.entity;

import meetingapp.db.EmployeeDB;
import meetingapp.db.EmployeeMeetingDB;
import meetingapp.db.MeetingDB;

import java.util.*;
/**
 * Created by cthill on 8/7/16.
 */
public class EmployeeMeeting extends Entity {

    protected int employeeID;
    protected int meetingID;
    protected boolean isOwner;
    protected boolean accepted;
    protected boolean seen;
    protected boolean seenByOwner;

    public EmployeeMeeting(int ID, int employeeID, int meetingID, boolean isOwner, boolean accepted, boolean seen, boolean seenByOwner) {
        super(ID);

        this.employeeID = employeeID;
        this.meetingID = meetingID;
        this.isOwner = isOwner;
        this.accepted = accepted;
        this.seen = seen;
        this.seenByOwner = seenByOwner;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
        save();
    }

    public int getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(int meetingID) {
        this.meetingID = meetingID;
        save();
    }

    public boolean getIsOwner() {
        return isOwner;
    }

    public boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
        save();
    }

    public boolean getSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
        save();
    }

    public boolean getSeenByOwner() {
        return seenByOwner;
    }

    public void setSeenByOwner(boolean seenByOwner) {
        this.seenByOwner = seenByOwner;
    }

    public void save() {
        EmployeeMeetingDB.getInstance().save(this);
    }

    public Meeting getMeeting() {
        return MeetingDB.getInstance().load(meetingID);
    }

    public Meeting getEmployee() {
        return MeetingDB.getInstance().load(employeeID);
    }
}
