package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.Visitor;

import java.util.Random;

/**
 *
 * @author Ondrej Stuchlik
 */
public abstract class Enemy extends TimedGameObject {
    private static final Random random = new Random();
    
    protected int type;

    public Enemy(int x, int y) {
        super(x, y);
        type = random.nextInt(2);
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public abstract void move();

    public abstract boolean isVisible();

    public abstract Enemy copy();

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    public int getType() {
        return type;
    }

}
