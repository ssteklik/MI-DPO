package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.ModelConfig;
import cz.fit.dpo.mvcshooter.model.Visitor;

/**
 * @author Ondrej Stuchlik
 */
public class Collision extends TimedGameObject {

    public Collision(int x, int y) {
        super(x, y);
        time = ModelConfig.COLLISION_LIVE_TIME;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void decreaseRemainingTime() {
        this.time--;
    }

    public boolean isVisible() {
        return this.time >= 0;
    }

    public Collision copy() {
        Collision collision = new Collision(x, y);
        collision.setTime(time);
        return collision;
    }
}
