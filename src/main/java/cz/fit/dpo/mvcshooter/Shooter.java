package cz.fit.dpo.mvcshooter;

import cz.fit.dpo.mvcshooter.controller.Controller;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.modes.Mode;
import cz.fit.dpo.mvcshooter.model.modes.RealisticMode;
import cz.fit.dpo.mvcshooter.model.modes.SimpleMode;
import cz.fit.dpo.mvcshooter.view.MainWindow;

import javax.swing.*;

/**
 * @author stue
 */
public class Shooter {

    private static final boolean SIMPLE_GAME_MODE = true;

    public static void main(String[] args) {

        Mode mode = (SIMPLE_GAME_MODE) ? new SimpleMode() : new RealisticMode();

        final Model model = new Model(mode);
        final Controller controller = new Controller(model);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainWindow(model, controller).setVisible(true);
            }
        });
    }
}
