package cz.fit.dpo.mvcshooter.model;

/**
 * Created by simon on 6.1.16.
 */
public class GameCaretaker
{
    private SavedGame savedGame;

    public void saveGame(Model model)
    {
        savedGame = model.saveGame();
    }

    public void loadGame(Model model) {
        if (savedGame == null) return;
        model.loadGame(savedGame);
    }
}
