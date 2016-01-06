package cz.fit.dpo.mvcshooter.model.entities;

/**
 *
 * @author Ondrej Stuchlik
 */
public abstract class TimedGameObject extends GameObject {
    
    private long created;

    protected int time = 1;

    public TimedGameObject(int x, int y) {
        super(x, y);
        created = System.currentTimeMillis();
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
