import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PlayPanel extends Jpanel implements Runnable {

    static final int GAME_WIDTH = 1000;  
    static final int GAME_HEIGHT = (int)GAME_WIDTH* (0.5555);
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BouncingBall_DIAMETER = 20;
    static final int MovingRackets_WIDTH = 25;
    static final int MovingRackets_HEIGHT = 25;
    static final int gameThread;
    Image image;
    Graphics graphics;
    Random random;
    MovingRackets racket1;
    MovingRackets racket2;
    BouncingBall ball;
    Score score;

     PlayPanel (){
         newMovingRackets();
         newBouncingBall();
         score = new Score(GAME_WIDTH,GAME_HEIGHT); 
         this.setFocusable(true);
         this.addKeyListener(new AL());
         this.setPreferredSize(SCREEN_SIZE);   

         gameThread = new Thread(this);
         gameThread.start

     }

     public void newBouncingBall() {
            //random = new Random();
            ball = new BouncingBall((GAME_WIDTH));

     }

     public void newMovingRackets() {
        racket1 = new MovingRackets(0,(GAME_HEIGHT/2)-(MovingRackets_HEIGHT/2),MovingRackets_WIDTH,MovingRackets_HEIGHT,1);
        racket2 = new MovingRackets(GAME_WIDTH-MovingRackets_WIDTH(GAME_HEIGHT/2)-(MovingRackets_HEIGHT/2),MovingRackets_WIDTH,MovingRackets_HEIGHT,2);

     }

     public void paint(Graphics g) {
         image = createImage(getWidth(),getHeight());
         graphics = image.getGraphics();
         draw(graphics);
         g.drawImage(image,0,0,this);

     }

     public void draw(Graphics g) {
         racket1.draw(g);
         racket2.draw(g);
     }

     public void move() {
         racket1.move();
         racket2.move();
         ball.move();
     }

     public void checkCollision() {
         //STOPS THE RACKETS AT THE WINDOW EDGES
            if(racket1.y<=0)
                  racket1.y=0;
            if(racket1.y >= (GAME_HEIGHT-MovingRackets_HEIGHT))
                  racket1.y = GAME_HEIGHT-MovingRackets_HEIGHT;
            if(racket2.y<=0)
                  racket2.y=0;
            if(racket2.y >= (GAME_HEIGHT-MovingRackets_HEIGHT))
                  racket2.y = GAME_HEIGHT-MovingRackets_HEIGHT;
        
     }

     public void run() {
         //game loop
         long lastTime = System.nanoTime();
         double amountOfTicks = 60.0;
         double ns = 1000000000 / amountOfTicks
         double delta = 0;
         while(true){
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >1) {
               move();
               checkCollision();
               repaint();
               delta--;
               System.out.println("TEST");
            }

         }

     }

     public class AL extendes KeyAdapter() {

        public void keyPressed(KeyEvent e) {
            racket1.keyPressed(e);
            racket2.keyPressed(e);

        }

        public void keyReleased(KeyEvent e) {
            racket1.keyReleased(e);
            racket2.keyReleased(e);
        }

        
     }
}