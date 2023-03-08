import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

    /**
     *
     * Represents a square on the board. Holds either X or O, and holds a number where it is positioned.
     * There should be 9 objects of this class. Contains two ints, position and value. X represents 1 and O represents 2.
     * 0 is empty.
     * @author Oscar
     */

public class GameLabel {

    ImageIcon ring = new ImageIcon("bin/ring.gif");
    ImageIcon cross = new ImageIcon("bin/cross.png");
    ImageIcon empty = new ImageIcon();

    int labelValue = 0;
    JLabel label = new JLabel();
    Window window;
    WinCondition winCondition;

        /**
         * Adds mouseListnener to labels and calls for select() method
         * @param position sets position on board
         * @param window takes in GUI for board layout
         * @param winCondition updates win condition
         *
         */
    public GameLabel(int position, Window window, WinCondition winCondition) {
        this.window = window;
        this.winCondition = winCondition;

        label.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                select();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }


        /**
         * Checks current player turn and sets the selected position and adds players icon on that position
         */
    public void select() {
        int player = window.getCurrentPlayer();
        if (labelValue == 0) {
            if (player == 1) {
                label.setIcon(cross);
                labelValue = 1;
            } else if (player == 2) {
                label.setIcon(ring);
                labelValue = 2;
            }
            window.alternatePlayer();
            winCondition.checkGameWon(1,2);
        } // else dont do anything
    }

        /**
         * @return labelValue to WinCondtition class
         */
    public int getLabelValue() {
        return labelValue;
    }

        /**
         * @return chosen player move to WinCondition class
         */
    public JLabel getLabel() {
        return label;
    }

        public void resetGameLabel() {
            this.labelValue = 0;
            label.setIcon(empty);
        }

        public void setLabelValue(int labelValue) {
            this.labelValue = labelValue;
        }
    }
