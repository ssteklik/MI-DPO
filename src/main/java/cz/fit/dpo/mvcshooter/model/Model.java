package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.model.entities.*;
import cz.fit.dpo.mvcshooter.view.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Model {

    private List<Missile> missiles = new ArrayList<Missile>();

    private List<Enemy> enemies = new ArrayList<Enemy>();

    private List<Collision> collisions = new ArrayList<Collision>();

    private Cannon cannon;

    private Timer timer;

    private int gravity;

    private List<ModelObserver> observers = new ArrayList<ModelObserver>();


    public Model() {
        cannon = new Cannon();
        initTimer();
    }
    
    // TODO implement

    public int getPlaygroundWidth() {
        return ModelConfig.PLAYGROUND_WIDTH;
    }

    public int getPlaygroundHeight() {
        return ModelConfig.PLAYGROUND_HEIGHT;
    }

    // ############################### private initialization ###############################
    private void initTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // TODO implement
            }
    }, 0, ModelConfig.TICK_TIME);
    }

    public void moveCannonDown()
    {
        cannon.moveDown();
        notifyObservers();
    }

    public void moveCannonUp()
    {
        cannon.moveUp();
        notifyObservers();
    }

    public void forceOfCannonDown()
    {
        cannon.forceDown();
    }

    public void forceOfCannonUp()
    {
        cannon.forceUp();
    }

    public void aimCannonUp()
    {
        cannon.aimUp();
    }

    public void aimCannonDown()
    {
        cannon.aimDown();
    }

    public void shootCannon()
    {
        cannon.shoot();
    }

    public void increaseGravity()
    {
        gravity += ModelConfig.GRAVITY_STEP;
    }

    public void decreaseGravity()
    {
        gravity -= ModelConfig.GRAVITY_STEP;
    }



    // ################################## private logic ##################################


    public List<Missile> getMissiles()
    {
        return missiles;
    }

    public List<Enemy> getEnemies()
    {
        return enemies;
    }

    public List<Collision> getCollisions()
    {
        return collisions;
    }

    public Cannon getCannon()
    {
        return cannon;
    }

    public List<GameObject> getAll() {
        List<GameObject> all = new ArrayList<GameObject>();
        all.add(cannon);
        all.addAll(getEnemies());
        all.addAll(getMissiles());
        all.addAll(getCollisions());

        return all;
    }

    public void attach(ModelObserver observer) {
        observers.add(observer);
    }

    public void detach(ModelObserver observer)
    {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (ModelObserver obs : observers) {
            obs.modelUpdated();
        }
    }
}
