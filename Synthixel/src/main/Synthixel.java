package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

import save.FilePicker;
import ui.FontManager;

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
    	
//    	try {
//            UIManager.setLookAndFeel(
//                "javax.swing.plaf.nimbus.NimbusLookAndFeel"
//            );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    	
//    	FilePicker.applySynthixelTheme();
//    	
    	
    	 try {
    	        UIManager.setLookAndFeel(
    	            "javax.swing.plaf.nimbus.NimbusLookAndFeel"
    	        );
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }

    	    // MUST APPLY THEME IMMEDIATELY AFTER LAF
    	    FilePicker.applySynthixelTheme();

    	    // FORCE FONT BEFORE ANY UI CREATION
    	    UIManager.put("defaultFont", FontManager.pixel18);
    	new Synthixel();
    	
    	//new main method
    	
    }
}