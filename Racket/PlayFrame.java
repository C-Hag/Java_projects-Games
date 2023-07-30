import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PlayFrame extends JFrame {

    PlayPanel panel;

    PlayFrame(){
        panel = new PlayPanel();
        this.add(panel);
        this.setTitle("Racket Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EX.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
    } 

} 