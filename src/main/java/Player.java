/**
 * Used for holding the score. Two ints that describe score and player number. Player 1 starts.
 * @author Hampus
 */

public class Player {

    private int playerNumber;
    private Window window;
    private int playerScore;

    /**
     * Just creates a player
     * @param player the number for the player
     * @param window the game window
     */
    public Player(int player, Window window)
    {
        this.playerNumber = player;
        this.playerScore = 0;
        this.window = window;
    }

    /**
     * Sets the score for this player and sends it to window to be visually displayed
     * Called from win condition
     * @param playerScore gets the score sent to set it
     */
    public void setPlayerScore(int playerScore)
    {
        this.playerScore = playerScore;
        window.setScore(playerNumber, playerScore);
    }

    public int getPlayerNumber()
    {
        return playerNumber;
    }

    public int getPlayerScore() {
        return playerScore;
    }
// 5
}
