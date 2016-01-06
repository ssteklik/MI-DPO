package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.model.entities.Collision;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon on 6.1.16.
 */
public class SavedGame
{
    private List<Enemy> enemies = new ArrayList<Enemy>();
    private List<Missile> missiles = new ArrayList<Missile>();
    private List<Collision> collisions = new ArrayList<Collision>();
    private int gravity = ModelConfig.DEFAULT_GRAVITY;

    public SavedGame(Model model) {
        for (Enemy enemy : model.getEnemies()) {
            this.enemies.add(enemy.copy());
        }

        for (Missile missile : model.getMissiles()) {
            this.missiles.add(missile.copy());
        }

        for (Collision collision : model.getCollisions()) {
            this.collisions.add(collision.copy());
        }

        this.gravity = model.getGravity();
    }


    public List<Enemy> getEnemies()
    {
        return enemies;
    }

    public List<Missile> getMissiles()
    {
        return missiles;
    }

    public List<Collision> getCollisions()
    {
        return collisions;
    }

    public int getGravity()
    {
        return gravity;
    }
}
