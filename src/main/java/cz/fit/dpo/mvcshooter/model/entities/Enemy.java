package cz.fit.dpo.mvcshooter.model.entities;

import cz.fit.dpo.mvcshooter.model.ModelConfig;
import java.util.Random;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Enemy extends TimedGameObject {
    private static final Random random = new Random();
    
    private int type;

    public Enemy(int x, int y) {
        super(x, y);
        type = random.nextInt(2);
    }
    
    public boolean shouldBeDiscarted() {
        return super.shouldBeDiscarted(ModelConfig.ENEMY_LIVE_TIME);
    }

    public int getType() {
        return type;
    }
    
}
