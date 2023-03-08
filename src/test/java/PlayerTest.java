import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest
{
    Window window = new Window();
    Player player = new Player(1, window);


    @Test
    public void getPlayerScore()
    {
        player.setPlayerScore(5);
        assertEquals(5, player.getPlayerScore());
    }

    @Test
    public void getPlayerNumber()
    {
        assertEquals(1, player.getPlayerNumber());
    }
}
