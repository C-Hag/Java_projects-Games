import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class applettest extends Applet {

  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.drawString("Welcome to the applet box!", 100, 100);
  
    }
}

/*
 <html>
 <applet code="applettest.class" Codebase="" width=300 height=400></applet>
 </html>
 */ 

