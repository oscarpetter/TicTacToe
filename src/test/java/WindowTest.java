import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class WindowTest {

    Window window = new Window();
    Player testPlayer = new Player(1, window);

    @Test
    void testList(){
        assertEquals(9, window.getGameLabels().size());
    }

    @Test
    void testGetButton(){
        try{
            JButton testButton = window.getResetGame();
        }
        catch (Exception e){
            fail("Could not get button");
        }
    }

    @Test
    void testScoreCounter(){
        testPlayer.setPlayerScore(4);
        assertEquals("4", window.getPlayer1Score().getText());
    }

    @Test
    void testCurrentPlayer(){
        if (window.getCurrentPlayer() < 1 && window.getCurrentPlayer() > 2){
            fail("There can only be 2 players");
        }
    }
}
