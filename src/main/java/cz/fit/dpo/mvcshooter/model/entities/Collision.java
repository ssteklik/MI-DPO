package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.ModelConfig;
import cz.fit.dpo.mvcshooter.model.Visitor;

/**
 * @author Ondrej Stuchlik
 */
public class Collision extends TimedGameObject {

    private int remainingTime = ModelConfig.COLLISION_LIVE_TIME;

    public Collision(int x, int y) {
        super(x, y);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void decreaseRemainingTime() {
        this.remainingTime--;
    }

    public boolean isVisible() {
        return this.remainingTime >= 0;
    }

    public Collision copy() {
        Collision collision = new Collision(x, y);
        collision.setRemainingTime(remainingTime);
        return collision;
    }
}
