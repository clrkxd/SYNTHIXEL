package main;

import javax.swing.JFrame;

public class Synthixel {

    public JFrame windowPiano;
    public PianoPanel panel;

    public Synthixel() {

        windowPiano = new JFrame("Synthixel --Clark");

        panel = new PianoPanel();

        windowPiano.add(panel);

        windowPiano.pack(); // uses 1024x768 from panel

        windowPiano.setLocationRelativeTo(null);
        windowPiano.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowPiano.setResizable(false);
        windowPiano.setVisible(true);
    }
    
    public static void main(String[] args) {
    	new Synthixel();
    }
}