import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

    /**
     * The window for the game. Here is where all the visuals are.
     * As this is mostly for visuals and has only a few functions that other classes use, there can not be too many tests.
     * @author Luca
     *
     */

public class Window extends JButton {


        // 1
        JFrame gameWindow = new JFrame();
        ImageIcon icon = new ImageIcon("treiradboard.png");

        JLabel board = new JLabel(icon);

        JLabel player1Name = new JLabel("Player X");
        JLabel player2Name = new JLabel("Player O");

        Player player1;
        Player player2;

        JLabel player1Score = new JLabel("0");
        JLabel player2Score = new JLabel("0");
        JButton resetGame = new JButton("Restart");
        JButton quitGame = new JButton("Exit");
        JButton resetBoardButton = new JButton("Reset Board");

        Font defaultFont = new Font("Calibri", Font.BOLD, 30);
        Font defaultScoreFont = new Font("Calibri", Font.BOLD, 54);
        private int currentPlayer = 1;

        final int OFFSET = 50;
        final int DEF_SIZE = 100;

        Resetter resetter;
        /**
         * Run in GameLabel whenever you put down a piece. This is how we find out whose turn it is.
         */

        public void alternatePlayer() {
            if (currentPlayer == 1) {
                currentPlayer = 2;
            } else {
                currentPlayer = 1;
            }
        }

        private ArrayList<GameLabel> gameLabels;

        /**
         * Building the window and all of its components.
         */
        public Window() {

            // Window size is 540x580;

            gameWindow.setResizable(false);
            gameWindow.setLayout(null);
            gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            try {
                gameWindow.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("wood.png")))));
            } catch (Exception e) {
                e.getStackTrace();
            }
            gameWindow.pack();

            board.setBounds(263 - 200, 300 - 220, 400, 440);
            board.setVisible(true);

            gameWindow.add(board);

            player1Name.setBounds(5, 0, 200, 150);
            player1Name.setForeground(Color.BLACK);
            player1Name.setFont(defaultFont);

            player2Name.setBounds(422, 0, 200, 150);
            player2Name.setForeground(Color.BLACK);
            player2Name.setFont(defaultFont);

            player1Score.setBounds(5, 0, 200, 80);
            player1Score.setForeground(Color.BLACK);
            player1Score.setFont(defaultScoreFont);

            player2Score.setBounds(505, 0, 200, 80);
            player2Score.setForeground(Color.BLACK);
            player2Score.setFont(defaultScoreFont);

            resetGame.setBounds(110 - 100, 548 - 25, 200, 50);
            resetGame.setForeground(Color.BLACK);
            resetGame.setFont(defaultFont);

            quitGame.setBounds(280 - 65, 548 - 25, 130, 50);
            quitGame.setForeground(Color.BLACK);
            quitGame.setFont(defaultFont);

            resetBoardButton.setBounds(425 - 75, 548 - 25, 190, 50);
            resetBoardButton.setForeground(Color.BLACK);
            resetBoardButton.setFont(defaultFont);

            player1 = new Player(1, this);
            player2 = new Player(2, this);
            resetter = new Resetter(this);
            WinCondition condition = new WinCondition(player1, player2, resetter);


            GameLabel square1 = new GameLabel(1, this, condition);
            GameLabel square2 = new GameLabel(2, this, condition);
            GameLabel square3 = new GameLabel(3, this, condition);
            GameLabel square4 = new GameLabel(4, this, condition);
            GameLabel square5 = new GameLabel(5, this, condition);
            GameLabel square6 = new GameLabel(6, this, condition);
            GameLabel square7 = new GameLabel(7, this, condition);
            GameLabel square8 = new GameLabel(8, this, condition);
            GameLabel square9 = new GameLabel(9, this, condition);

            square1.getLabel().setBounds(263 - OFFSET, 300 - OFFSET, DEF_SIZE, DEF_SIZE);
            square2.getLabel().setBounds(263 - OFFSET, 163 - OFFSET, DEF_SIZE, DEF_SIZE);
            square3.getLabel().setBounds(263 - OFFSET, 437 - OFFSET, DEF_SIZE, DEF_SIZE);
            square4.getLabel().setBounds(396 - OFFSET, 163 - OFFSET, DEF_SIZE, DEF_SIZE);
            square5.getLabel().setBounds(396 - OFFSET, 300 - OFFSET, DEF_SIZE, DEF_SIZE);
            square6.getLabel().setBounds(396 - OFFSET, 437 - OFFSET, DEF_SIZE, DEF_SIZE);
            square7.getLabel().setBounds(128 - OFFSET, 163 - OFFSET, DEF_SIZE, DEF_SIZE);
            square8.getLabel().setBounds(128 - OFFSET, 300 - OFFSET, DEF_SIZE, DEF_SIZE);
            square9.getLabel().setBounds(128 - OFFSET, 437 - OFFSET, DEF_SIZE, DEF_SIZE);

            gameLabels = new ArrayList<>();
            gameLabels.add(square7);
            gameLabels.add(square2);
            gameLabels.add(square4);
            gameLabels.add(square8);
            gameLabels.add(square1);
            gameLabels.add(square5);
            gameLabels.add(square9);
            gameLabels.add(square3);
            gameLabels.add(square6);

            condition.setList(gameLabels);

            gameWindow.add(player1Name);
            gameWindow.add(player2Name);
            gameWindow.add(player1Score);
            gameWindow.add(player2Score);
            gameWindow.add(resetGame);
            gameWindow.add(quitGame);
            gameWindow.add(resetBoardButton);

            for (GameLabel l : gameLabels) {
                gameWindow.add(l.getLabel());
            }

            /**
             * Quit button.
            */
            quitGame.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }

            });

            /**
             * Reset
             */
            resetBoardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resetBoard();
                }
            });
            gameWindow.setVisible(true);
        }

        /**
         * Updates the score counter and sets the score to the appropriate label.
         * @param player this determines whose score to set
         * @param playerScore what it should be set to
         */

        public void setScore(int player, int playerScore) {
            if (player == 1) {
                player1Score.setText(String.valueOf(playerScore));
            } else {
                player2Score.setText(String.valueOf(playerScore));
            }
        }

        // For resetter class
        public JButton getResetGame() {
            return resetGame;
        }

        /**
         * @return the arraylist of gamelabels
         */
        public ArrayList<GameLabel> getGameLabels() {
            return gameLabels;
        }

        public JLabel getPlayer1Score() {
            return player1Score;
        }

        public int getCurrentPlayer() {
            return currentPlayer;
        }

        /**
         * Combined with reset board this will reset the entire game.
         */

        public void resetPlayers() {
            player1.setPlayerScore(0);
            player2.setPlayerScore(0);
            currentPlayer = 1;
        }

        /**
         * Gets all GameLabels and resets them. Also puts the turn to player 1.
         */

        public void resetBoard() {
            for (GameLabel g : gameLabels){
                g.resetGameLabel();
            }
            currentPlayer = 1;
        }

         // All below for JUnit


        public Resetter getResetter() {
            return resetter;
        }

        public Player getPlayer1() {
            return player1;
        }

        public Player getPlayer2() {
            return player2;
        }
    }