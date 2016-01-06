package cz.fit.dpo.mvcshooter.model.modes;

import cz.fit.dpo.mvcshooter.model.ModelConfig;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public class SimpleEnemy extends Enemy{

    protected int remainingTime = ModelConfig.ENEMY_LIVE_TIME;

    public SimpleEnemy(int x, int y) {
        super(x, y);
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    @Override
    public void move() {
        remainingTime--;
    }

    @Override
    public boolean isVisible() {
        return remainingTime >= 0;
    }

    @Override
    public Enemy copy() {
        SimpleEnemy se = new SimpleEnemy(x, y);
        se.setTime(time);
        se.setType(type);
        se.setRemainingTime(remainingTime);
        return se;
    }
}
