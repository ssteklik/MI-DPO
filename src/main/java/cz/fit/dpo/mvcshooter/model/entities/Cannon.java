package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.ModelConfig;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Cannon extends GameObject {
    
    private int angle = ModelConfig.CANNON_DEFAULT_ANGLE;
    private int force = ModelConfig.CANNON_DEFAULT_FORCE;

    public Cannon() {
        super(ModelConfig.CANNON_X, ModelConfig.CANNON_DEFAULT_Y);
    }

    public int getForce() {
        return force;
    }

    public int getAngle() {
        return angle;
    }
    
    public void moveUp() {
        if (y >= ModelConfig.CANNON_TOP_MARGIN) {
            y -= ModelConfig.CANNON_MOVE_STEP;
        }
    }
    
    public void moveDown() {
        if (y <= ModelConfig.PLAYGROUND_HEIGHT - ModelConfig.CANNON_BOTTOM_MARGIN) {
            y +=  ModelConfig.CANNON_MOVE_STEP;
        }
    }
    
    public void aimUp() {
        if (angle < ModelConfig.CANNON_MAX_UP_ANGLE) {
            angle += ModelConfig.CANNON_AIM_STEP;
        }
    }
    
    public void aimDown() {
        if (angle > ModelConfig.CANNON_MAX_DOWN_ANGLE) {
            angle -= ModelConfig.CANNON_AIM_STEP;
        }
    }
    
    public void forceUp() {
        if (force < ModelConfig.CANNON_MAX_FORCE) {
            force += ModelConfig.CANNON_FORCE_STEP;
        }
    }
    
    public void forceDown() {
        if (force > ModelConfig.CANNON_MIN_FORCE) {
            force -= ModelConfig.CANNON_FORCE_STEP;
        }
    }
    
    public Missile shoot() {
        return new Missile(x, y, force, angle);
    }
}
