package cz.fit.dpo.mvcshooter.model.modes;

import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.movement.SimpleMovementImp;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public class SimpleMode implements Mode{

    @Override
    public Enemy createEnemy(int x, int y) {
        return new SimpleEnemy(x, y);
    }

    @Override
    public Missile createMissile(int firstX, int firstY, int angle, int force) {
        Missile missile = new Missile(firstX, firstY, angle, force);
        missile.setMovementStrategy(new SimpleMovementImp());
        return missile;
    }
}
