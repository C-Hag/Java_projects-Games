import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Score extends Rectangle {

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
    int player2;

    Score(int GAME_WIDTH, GAME_HEIGHT){
        score.GAME_WIDTH = GAME_WIDTH;
        score.GAME_HEIGHT = GAME_HEIGHT;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Times New Roman",Font.PLAIN,60));
        
        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);

        g.drawString(String.valueOf(player1/10)+String.ValueOf(player1/10), (GAME_WIDTH/2)-85, 50);
        g.drawString(String.valueOf(player2)+String.ValueOf(player2/10), (GAME_WIDTH/2)+20 50);
    }

}