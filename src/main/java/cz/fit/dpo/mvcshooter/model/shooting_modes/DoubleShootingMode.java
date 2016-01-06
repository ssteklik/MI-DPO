package cz.fit.dpo.mvcshooter.model.shooting_modes;

import cz.fit.dpo.mvcshooter.model.ModelConfig;
import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.modes.Mode;

import java.util.ArrayList;

/**
 * Created by simon on 6.1.16.
 */
public class DoubleShootingMode implements ShootingMode
{
    @Override
    public ArrayList<Missile> shoot(Cannon cannon, Mode gameMode)
    {
        ArrayList<Missile> missiles = new ArrayList<Missile>();
        Missile firstMissile = gameMode.createMissile(cannon.getX(), cannon.getY(), cannon.getAngle(), cannon.getForce());
        missiles.add(firstMissile);
        int addedAngle = cannon.getAngle() + ModelConfig.CANNON_AIM_STEP;
        Missile secondMissile = gameMode.createMissile(cannon.getX(), cannon.getY(), addedAngle, cannon.getForce());
        missiles.add(secondMissile);

        return missiles;
    }

    @Override
    public boolean isSingle()
    {
        return false;
    }
}
