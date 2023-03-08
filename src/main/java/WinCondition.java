import java.util.ArrayList;
    /**
     * Used to check if there is a winner
     * If there is a winner, the board is reset and next round begins.
     * @author Anton
    */
public class WinCondition {

    private Player player1;
    private Player player2;
    private Resetter rs;

        /**
         * Creates instance of Wincondition
         * @param player1 the first player (1) that is in the game
         * @param player2 the second player (2) that is in the game
         * @param rs the resetter used to reset the board after one round has been played
         */
    public WinCondition(Player player1, Player player2, Resetter rs){
        this.player1 = player1;
        this.player2 = player2;
        this.rs = rs;
    }

    static ArrayList<GameLabel> list;

        /**
         * Checks if there is a winner, gives the winning player a point and resets the board
         * This does nothing if there is no winner yet
         * @param p1 Player 1:s player number
         * @param p2 Player 2:s player number
         */
    public void checkGameWon(int p1, int p2){
        if (checkPlayerWin(1) == 1) {
            player1.setPlayerScore(player1.getPlayerScore() + 1);
            rs.reset();
        }
        else if (checkPlayerWin(2) == 2) {
            player2.setPlayerScore(player2.getPlayerScore() + 1);
            rs.reset();
        }
    }

        /**
         * Checks if a player has marked 3 positions on the tictactoe-board
         * @param player The players player number
         * @param a The first position to check
         * @param b The second position to check
         * @param c The third position to check
         * @return True if the player holds all positions in arguments, returns false if not.
         */
    private static boolean check3Positions(int player, int a, int b, int c){
        return list.get(a).getLabelValue() == player && list.get(b).getLabelValue() == player && list.get(c).getLabelValue() == player;
    }

        /**
         * Checks if a player has won the round
         * @param player The players player number
         * @return The players number if the player has won, 0 if the player has not won
         */
    public static int checkPlayerWin(int player){
        if (check3Positions(player, 0,1 ,2))
            return player;
        else if(check3Positions(player, 0,3,6))
            return player;
        else if (check3Positions(player,0,4,8))
            return player;
        else if (check3Positions(player,1,4,7))
            return player;
        else if (check3Positions(player,2,4,6 ))
            return player;
        else if (check3Positions(player,2,5,8))
            return player;
        else if (check3Positions(player,3,4,5 ))
            return player;
        else if (check3Positions(player, 6,7,8))
            return player;
        else
            return 0;
    }

        /**
         * Sets WinCondition.list to specified list
         * @param list The list you want to set Wincondition.list to
         */
        public void setList(ArrayList<GameLabel> list) {
            this.list = list;
        }

        // 3
}
