package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ui.PianoPanel;

public class Synthixel {

    public JFrame windowPiano;
    public PianoPanel panel;

    public Synthixel() {

        windowPiano = new JFrame("Synthixel  --Clark ");
        
        ImageIcon icon = new ImageIcon(
                Synthixel.class.getResource("/sprite/synthixel_appicon.png"));

        windowPiano.setIconImage(icon.getImage());

        panel = new PianoPanel();

        windowPiano.add(panel);

        windowPiano.pack(); 

        windowPiano.setLocationRelativeTo(null);
        windowPiano.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowPiano.setResizable(false);
        windowPiano.setVisible(true);
    }
    
    public static void main(String[] args) {
    	new Synthixel();
    	
    	//new main method
    	
    }
}