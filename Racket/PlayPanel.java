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
            ball = new BouncingBall((GAME_WIDTH/2)-(BouncingBall_DIAMETER/2),random.nextInt(GAME_HEIGHT-BouncingBall_DIAMETER),BouncingBall_DIAMETER,BouncingBall_DIAMETER);

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
         ball.draw(g);
         score.draw,(g);
     }

     public void move() {
         racket1.move();
         racket2.move();
         ball.move();
     }

     public void checkCollision() {

         //Bouncing the ball of the edges (top & bottom)
         if ball.y <=0 {
            ball.setYDirection(-ball.yVelocity);
         }
         if(ball.y >= GAME_HEIGHT-BouncingBall_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
         }

         //Bounce the ball of the rackets
         if (ball.intersects(racket1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; //Options for increased difficulty
            if(ball.yVelocity>0)
               ball.yVelocity++; //Even more difficulty
            else
               ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);

         }

         if (ball.intersects(racket2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; //Options for increased difficulty
            if(ball.yVelocity>0)
               ball.yVelocity++; //Even more difficulty
            else
               ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);

         }


         //STOPS THE RACKETS AT THE WINDOW EDGES
            if(racket1.y<=0)
                  racket1.y=0;
            if(racket1.y >= (GAME_HEIGHT-MovingRackets_HEIGHT))
                  racket1.y = GAME_HEIGHT-MovingRackets_HEIGHT;
            if(racket2.y<=0)
                  racket2.y=0;
            if(racket2.y >= (GAME_HEIGHT-MovingRackets_HEIGHT))
                  racket2.y = GAME_HEIGHT-MovingRackets_HEIGHT;
        
         //Give player 1 point and creates a new racket and ball
         if(ball.x <=0) {
               score.player2++;
               newMovingRackets();
               newBouncingBall();
               System.out.println("Player 2:"+score.player2);

         }
         if(ball.x >= GAME_WIDTH-BouncingBall_DIAMETER) {
            score.player1++;
            newMovingRackets();
            newBouncingBall();
            System.out.println("Player 1:"+score.player1);
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
}