import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    /**
    * Empties the board and allows for a new game to be played. Contains a button to manually reset the whole game.
     * @author Hampus
    */
public class Resetter {

    private Window window;
    private JButton resetButton;

        /**
         * Creates a resetter class. Also creates a button that will call reset.
         * @param window the window it resets
         */
    public Resetter(Window window)
    {
        this.window = window;
        resetButton = window.getResetGame();
        resetButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                hardReset();
            }
        });
    }

        /**
         * Resets the entire game. Players and the board specifically
         */
    public void hardReset()
    {
        window.resetBoard();
        window.resetPlayers();
    }

        /**
         * Called from the button in the constructor. This will only reset the board
         */
    public void reset()
    {
        window.resetBoard();
    }

    // 4
}
