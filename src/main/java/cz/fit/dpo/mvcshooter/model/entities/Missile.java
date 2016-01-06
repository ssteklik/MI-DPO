package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.ModelConfig;
import cz.fit.dpo.mvcshooter.model.Visitor;
import cz.fit.dpo.mvcshooter.model.movement.MovementStrategy;

/**
 * @author Ondrej Stuchlik
 */
public class Missile extends TimedGameObject {

    private int beginX;
    private int beginY;
    private int angle;
    private int force;
    private MovementStrategy movementStrategy;

    public Missile(int x, int y, int angle, int force) {
        super(x, y);
        this.force = force;
        this.angle = angle;
        this.beginX = x;
        this.beginY = y;
        this.time = 1;
    }

    public void move(int gravity) {
        time++;
        Coordinates coord = movementStrategy.move(gravity, this);
        this.x = coord.getX();
        this.y = coord.getY();
    }

    public boolean isVisible() {
        return y <= ModelConfig.PLAYGROUND_HEIGHT && x <= ModelConfig.PLAYGROUND_WIDTH;
    }

    public Missile copy() {
        Missile missile = new Missile(beginX, beginY, angle, force);
        missile.setTime(time);
        missile.setMovementStrategy(movementStrategy);
        return missile;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getBeginX() {
        return beginX;
    }

    public int getBeginY() {
        return beginY;
    }

    public int getAngle() {
        return angle;
    }

    public int getForce() {
        return force;
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }
}
