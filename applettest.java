import java.applet.*;
import java.awt.*;

public static void main(String[] args) {

/*
<applet code="SimpleApplet.class" 
         height="250" width="250">
</applet>
*/
public class applettest extends Applet {
  public void init() {
  }

  public void start() {
  }

  public void stop() {
  }

  public void destroy() {
  }

  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.drawString("Welcome to the applet box!", 50, 100);
        }
 }
}

