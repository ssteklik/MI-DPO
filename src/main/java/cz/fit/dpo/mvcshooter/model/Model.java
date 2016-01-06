package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.model.entities.*;
import cz.fit.dpo.mvcshooter.model.modes.Mode;

import java.util.*;

/**
 * @author Ondrej Stuchlik
 */
public class Model {

    private List<Missile> missiles = new ArrayList<Missile>();
    private List<Enemy> enemies = new ArrayList<Enemy>();
    private List<Collision> collisions = new ArrayList<Collision>();
    private Cannon cannon;
    private Timer timer;
    private int gravity = ModelConfig.DEFAULT_GRAVITY;
    ;
    private List<ModelObserver> observers = new ArrayList<ModelObserver>();
    private Mode gameMode;
    private int timeTicks = 0;


    public Model(Mode mode) {
        this.gameMode = mode;
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
                moveObjects();
            }
        }, 0, ModelConfig.TICK_TIME);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                addNewEnemy();
            }
        }, 0, 5000);

        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                timeTicks++;
            }
        }, 0, 1000);
    }

    private void addNewEnemy() {
        int generatedX, generatedY;

        if (enemies.size() == ModelConfig.ENEMIES_COUNT) {
            return;
        }
        generatedX = (int) (Math.random() * (ModelConfig.PLAYGROUND_WIDTH - 120)) + 100;
        generatedY = (int) (Math.random() * (ModelConfig.PLAYGROUND_HEIGHT - 40)) + 20;
        Enemy enemy = gameMode.createEnemy(generatedX, generatedY);
        enemies.add(enemy);
        notifyObservers();
    }

    private void moveObjects() {
        refreshMissiles();
        refreshEnemies();
        refreshCollisions();
        checkCollisions();

        notifyObservers();
    }

    private void checkCollisions() {
        for (Iterator<Enemy> enemyIter = enemies.iterator(); enemyIter.hasNext(); ) {
            Enemy enemy = enemyIter.next();
            for (Iterator<Missile> missileIter = missiles.iterator(); missileIter.hasNext(); ) {
                Missile missile = missileIter.next();
                if (missile.collidesWith(enemy)) {
                    collisions.add(new Collision(enemy.getX(), enemy.getY()));
                    //ToDO score board
//                    gameStats.addScore();
                    enemyIter.remove();
                    missileIter.remove();
                }
            }
        }
    }

    private void refreshCollisions() {
        for (Iterator<Collision> colIter = collisions.iterator(); colIter.hasNext(); ) {
            Collision collision = colIter.next();
            collision.decreaseRemainingTime();
            if (!collision.isVisible()) {
                colIter.remove();
            }
        }
    }

    private void refreshEnemies() {
        boolean removed = false;
        for (Iterator<Enemy> it = enemies.iterator(); it.hasNext(); ) {
            Enemy enemy = it.next();
            enemy.move();
            if (!enemy.isVisible()) {
                it.remove();
                removed = true;
            }
        }
        if (removed) {
            addNewEnemy();
        }
    }


    private void refreshMissiles() {
        for (Iterator<Missile> it = missiles.iterator(); it.hasNext(); ) {
            Missile missile = it.next();
            missile.move(gravity);
            if (!missile.isVisible()) {
                //ToDO score board
//                gameStats.minusScore();
                it.remove();
            }
        }
    }

    public void moveCannonDown() {
        cannon.moveDown();
        notifyObservers();
    }

    public void moveCannonUp() {
        cannon.moveUp();
        notifyObservers();
    }

    public void forceOfCannonDown() {
        cannon.forceDown();
    }

    public void forceOfCannonUp() {
        cannon.forceUp();
    }

    public void aimCannonUp() {
        cannon.aimUp();
    }

    public void aimCannonDown() {
        cannon.aimDown();
    }

    public void shootCannon() {
        ArrayList<Missile> newMissiles = cannon.shootMissile(gameMode);
        missiles.addAll(newMissiles);
        notifyObservers();
    }

    public void increaseGravity() {
        gravity += ModelConfig.GRAVITY_STEP;
    }

    public void decreaseGravity() {
        gravity -= ModelConfig.GRAVITY_STEP;
    }

    // ################################## private logic ##################################


    public List<Missile> getMissiles() {
        return missiles;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Collision> getCollisions() {
        return collisions;
    }

    public Cannon getCannon() {
        return cannon;
    }

    public int getGravity()
    {
        return gravity;
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

    public void detach(ModelObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (ModelObserver obs : observers) {
            obs.modelUpdated();
        }
    }

    public void toggleShootingMode() {
        cannon.changeShootingMode();
    }

    public SavedGame saveGame() {
        return new SavedGame(this);
    }

    public void loadGame(SavedGame savedGame)
    {
        enemies.clear();
        missiles.clear();
        collisions.clear();
        for (Enemy enemy : savedGame.getEnemies()) {
            enemies.add(enemy.copy());
        }
        for (Missile missile : savedGame.getMissiles()) {
            missiles.add(missile.copy());
        }
        for (Collision collision : savedGame.getCollisions()) {
            collisions.add(collision.copy());
        }
        gravity = savedGame.getGravity();
    }
}
