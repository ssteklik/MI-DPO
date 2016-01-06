package cz.fit.dpo.mvcshooter.model.movement;

import cz.fit.dpo.mvcshooter.model.entities.Coordinates;
import cz.fit.dpo.mvcshooter.model.entities.Missile;

/**
 * Created by Drugnanov on 6.1.2016.
 */
public class SimpleMovementImp implements MovementStrategy {

    @Override
    public Coordinates move(int g, Missile m) {
        int force = (m.getForce() / 4) == 0 ? 1 : (m.getForce() / 4);
        int x = m.getBeginX() + (int) (force * m.getTime());
        int y = m.getBeginY() - (int) (force * m.getTime() * Math.toRadians(m.getAngle()));
        return new Coordinates(x, y);
    }
}

