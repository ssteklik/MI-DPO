package cz.fit.dpo.mvcshooter.model.modes;

import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public interface Mode {

    //create enemy
    public Enemy createEnemy(int x, int y);

    //create missile
    public Missile createMissile(int firstX, int firstY, int angle, int force);
}
