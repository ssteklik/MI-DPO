package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.model.entities.Cannon;
import cz.fit.dpo.mvcshooter.model.entities.Collision;
import cz.fit.dpo.mvcshooter.model.entities.Enemy;
import cz.fit.dpo.mvcshooter.model.entities.Missile;

/**
 * Created by simon on 5.1.16.
 */
public interface Visitor
{
    void visit(Enemy enemy);
    void visit(Cannon enemy);
    void visit(Missile enemy);
    void visit(Collision enemy);
}
