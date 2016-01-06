package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.Visitor;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Collision extends TimedGameObject {

    public Collision(int x, int y) {
        super(x, y);
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
    
}
