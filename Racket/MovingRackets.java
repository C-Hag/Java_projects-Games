import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MovingRackets extends Rectangle {

    int id;
    int yVelocity;

    MovingRackets(int x, int y, int MovingRackets_WIDTH, int MovingRackets_HEIGHT, int id ){
        super(x,y,MovingRackets_WIDTH,MovingRackets_HEIGHT);
        this.id=id;
    }

    public void keyPressed(KeyEvent e) {
            
    }

    public void keyReleased(KeyEvent e) {
            
    }

    public void setYdirection(int Ydirection) {
        
    }

    public void move() {
        
    }

    public void draw(Graphics g) {
        if(id==1)
            g.setColor(Color.yellow);
        else
            g.setColor(Color.green)
        g.fillRect(x, y, width, height);    
        

    }

}