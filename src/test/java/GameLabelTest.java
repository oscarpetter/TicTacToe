import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;


public class GameLabelTest {
    Window w = new Window();
    Player one = new Player(1,w);
    Player two = new Player(2,w);
    WinCondition wc = new WinCondition(one, two, new Resetter(w));

    @Test
    public void testOnlyAllowedClickedOnce() {
        GameLabel gl = new GameLabel(1, w, wc );
        assertEquals(0, gl.labelValue);
        gl.select(); //player 1
        assertEquals(1, gl.labelValue);
        gl.select(); // player 2
        assertEquals(1, gl.labelValue);
    }

    @Test
    public void testWin() {

        GameLabel gl0 = new GameLabel(0, w, wc );
        GameLabel gl1 = new GameLabel(1, w, wc );
        GameLabel gl2 = new GameLabel(2, w, wc );
        GameLabel gl3 = new GameLabel(3, w, wc );
        GameLabel gl4 = new GameLabel(4, w, wc );
        GameLabel gl5 = new GameLabel(5, w, wc );
        GameLabel gl6 = new GameLabel(6, w, wc );
        GameLabel gl7 = new GameLabel(7, w, wc );
        GameLabel gl8 = new GameLabel(8, w, wc );

        wc.setList(new ArrayList<>(Arrays.asList(gl0,gl1,gl2,gl3,gl4,gl5,gl6,gl7,gl8)));


        gl1.select(); //P1
        gl3.select(); //P2
        gl2.select(); //P1
        gl4.select(); //P2
        gl6.select(); //P1
        gl5.select(); //P2

        System.out.println(WinCondition.checkPlayerWin(2));
        System.out.println(WinCondition.checkPlayerWin(1));
        assertEquals(2, WinCondition.checkPlayerWin(2)); //player two win
    }

    @Test
    public void imageIconTest() {
        ImageIcon ring = new ImageIcon("bin/ring.gif");
        ImageIcon cross = new ImageIcon("bin/cross.png");

        assertNotNull(ring);
        assertNotNull(cross);
    }

    @Test
    public void playerValueTest() {
        GameLabel gl = new GameLabel(1, w, wc );

        gl.select();
        assertEquals(1,gl.labelValue);

        assertNotEquals(2,1);
    }



}
