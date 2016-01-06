package cz.fit.dpo.mvcshooter.model.movement;

import cz.fit.dpo.mvcshooter.model.entities.Coordinates;
import cz.fit.dpo.mvcshooter.model.entities.Missile;

/**
 * Created by Drugnanov on 6.1.2016.
 */
// x = x0 + v0*t*cos(alpha)
// y = y0 - v0*t*sin(alpha) + 1/2*g*t^2
public class RealisticMovementImp implements MovementStrategy {

    private static final double SLOW_VALUE = 10;

    @Override
    public Coordinates move(int g, Missile m) {
        int x = (int) (m.getBeginX() + m.getForce() * m.getTime() / SLOW_VALUE * cos(m.getAngle()));
        int y = (int) (m.getBeginY() - (m.getForce() * m.getTime() / SLOW_VALUE * sin(m.getAngle())) +
            (0.5 * g *(m.getTime() / SLOW_VALUE * m.getTime() / SLOW_VALUE)));
        return new Coordinates(x, y);
    }

    private double cos(int angle) {
        return Math.cos(Math.toRadians(angle));
    }

    private double sin(int angle) {
        return Math.sin(Math.toRadians(angle));
    }
}
