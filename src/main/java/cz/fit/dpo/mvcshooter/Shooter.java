package cz.fit.dpo.mvcshooter;

import cz.fit.dpo.mvcshooter.controller.Controller;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.modes.Mode;
import cz.fit.dpo.mvcshooter.model.modes.SimpleMode;
import cz.fit.dpo.mvcshooter.view.MainWindow;

import javax.swing.*;

/**
 *
 * @author stue
 */
public class Shooter {
    
    public static void main(String[] args) {
        Mode mode = new SimpleMode();
//        Mode mode = new RealisticMode();

        //ToDo jak udela factory pro harcore a softcore verzi
        final Model model = new Model(mode);
        final Controller controller = new Controller(model);
        
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
               new MainWindow(model, controller).setVisible(true);
            }
        });
    }
}
