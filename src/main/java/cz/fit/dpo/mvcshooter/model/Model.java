package cz.fit.dpo.mvcshooter.model;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Model {
    
    private Timer timer;
      

    public Model() {
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

    

    // ################################## private logic ##################################
    


}
