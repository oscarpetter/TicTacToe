import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;
// Hampus had to leave and we didn't have time to finish it together, so I wrote some tests on here ~ Luca

public class ResetterTest
{

    @Test
    public void testHardReset()
    {
        Window window = new Window();
        Resetter resetter = window.getResetter();

        window.getPlayer1().setPlayerScore(3);
        window.getPlayer2().setPlayerScore(5);

        resetter.hardReset();
        assertEquals(0, window.getPlayer2().getPlayerScore());
        assertEquals(0, window.getPlayer2().getPlayerScore());
    }

    @Test
    public void testResetBoard()
    {
        Window window = new Window();
        Resetter resetter = window.getResetter();

        ArrayList<GameLabel> gameLabels = window.getGameLabels();
        for (GameLabel g : gameLabels){
            g.setLabelValue(ThreadLocalRandom.current().nextInt(1,3));
        }
        resetter.reset();
        for (GameLabel g : gameLabels){
            assertEquals(0, g.getLabelValue());
        }
    }
}
