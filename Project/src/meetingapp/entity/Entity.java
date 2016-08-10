package meetingapp.entity;

/**
 * Created by cthill on 8/9/16.
 */
public abstract class Entity {
    protected int ID;

    public Entity(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    abstract void save();
}