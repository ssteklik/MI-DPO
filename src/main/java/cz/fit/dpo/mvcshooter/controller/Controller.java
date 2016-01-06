package cz.fit.dpo.mvcshooter.controller;

import cz.fit.dpo.mvcshooter.model.GameCaretaker;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.view.MainWindow;
import java.awt.event.KeyEvent;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Controller {

    private Model model;
    private MainWindow view;
    private GameCaretaker caretaker = new GameCaretaker();

    public Controller(Model model) {
        this.model = model;
    }

    public void keyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                model.moveCannonDown();
                break;
            case KeyEvent.VK_UP:
                model.moveCannonUp();
                break;
            case KeyEvent.VK_LEFT:
                model.forceOfCannonDown();
                break;
            case KeyEvent.VK_RIGHT:
                model.forceOfCannonUp();
                break;
            case KeyEvent.VK_PAGE_UP:
                model.aimCannonUp();
                break;
            case KeyEvent.VK_PAGE_DOWN:
                model.aimCannonDown();
                break;
            case KeyEvent.VK_SPACE:
                model.shootCannon();
                break;
            case KeyEvent.VK_S:
                model.toggleShootingMode();
                break;
            case KeyEvent.VK_HOME:
                model.increaseGravity();
                break;
            case KeyEvent.VK_END:
                model.decreaseGravity();
                break;
            case KeyEvent.VK_F6:
                caretaker.saveGame(model);
                System.out.println("Game saved");
                break;
            case KeyEvent.VK_F8:
                caretaker.loadGame(model);
                System.out.println("Game loaded");
                break;

            case KeyEvent.VK_F1:
                view.showHelp();
                break;
        }
    }

    public void setView(MainWindow view) {
        this.view = view;
    }
}
