import java.awt.*;
import javax.swing.*;

public class PlayFrame extends JFrame {

    PlayPanel panel;

    PlayFrame(){
        panel = new PlayPanel();
        this.add(panel);
        this.setTitle("Racket Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    } 

} 