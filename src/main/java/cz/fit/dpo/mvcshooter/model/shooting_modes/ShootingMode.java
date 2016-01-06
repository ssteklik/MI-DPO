package cz.fit.dpo.mvcshooter.model.shooting_modes;

import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Missile;
import cz.fit.dpo.mvcshooter.model.modes.Mode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon on 6.1.16.
 */
public interface ShootingMode
{
    ArrayList<Missile> shoot(Cannon cannon, Mode gameMode);

    boolean isSingle();
}
