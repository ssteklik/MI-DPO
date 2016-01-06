package cz.fit.dpo.mvcshooter.model.shooting_modes;

import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.modes.Mode;

import java.util.ArrayList;

/**
 * Created by simon on 6.1.16.
 */
public class SingleShootingMode implements ShootingMode
{
    @Override
    public ArrayList<Missile> shoot(Cannon cannon, Mode gameMode)
    {
        ArrayList<Missile> missiles = new ArrayList<Missile>();
        Missile missile = gameMode.createMissile(cannon.getX(), cannon.getY(), cannon.getAngle(), cannon.getForce());
        missiles.add(missile);

        return missiles;
    }

    @Override
    public boolean isSingle()
    {
        return true;
    }
}
