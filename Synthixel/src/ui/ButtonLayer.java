package ui;

import main.UIConstants;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import audio.SoundManager;

public class ButtonLayer {

    private ArrayList<PianoButton> buttons;
//    private boolean sustainEnabled;
    private SoundManager sound;
    
    private Image left, right, sust, play, stop, imprt, record, save;
    
    private boolean leftP, rightP;
    private long rightPressedTime;
    private long leftPressedTime;

    public ButtonLayer(SoundManager sound) {
    	

        this.sound = sound;
    	
    	left = new ImageIcon(
    	        getClass().getResource("/sprite/left.png"))
    	        .getImage();

    	right = new ImageIcon(
    	        getClass().getResource("/sprite/right.png"))
    	        .getImage();

    	sust = new ImageIcon(
    	        getClass().getResource("/sprite/sustain.png"))
    	        .getImage();
    	
    	play = new ImageIcon(
    	        getClass().getResource("/sprite/play.png"))
    	        .getImage();

    	stop = new ImageIcon(
    	        getClass().getResource("/sprite/stop.png"))
    	        .getImage();

    	imprt = new ImageIcon(
    	        getClass().getResource("/sprite/import.png"))
    	        .getImage();
    	
    	record = new ImageIcon(
    	        getClass().getResource("/sprite/record.png"))
    	        .getImage();

    	save = new ImageIcon(
    	        getClass().getResource("/sprite/save.png"))
    	        .getImage();
    	


        buttons = new ArrayList<>();

        buttons.add(
                new PianoButton(
                		UIConstants.LEFT_X,
            	        UIConstants.LEFT_Y,
            	        UIConstants.BUTTON_W,
            	        UIConstants.BUTTON_H,
                        "left",
                        left));

        buttons.add(
                new PianoButton(
                		UIConstants.RIGHT_X,
            	        UIConstants.RIGHT_Y,
            	        UIConstants.BUTTON_W,
            	        UIConstants.BUTTON_H,
                        "right",
                        right));

        buttons.add(
                new PianoButton(
                		UIConstants.SUST_X,
            	        UIConstants.SUST_Y,
            	        UIConstants.BUTTON_W,
            	        UIConstants.BUTTON_H,
                        "sust",
                        sust));
        
        buttons.add(
                new PianoButton(
                		UIConstants.PLAY_X,
            	        UIConstants.PLAY_Y,
            	        UIConstants.BUTTON_W,
            	        UIConstants.BUTTON_H,
                        "play",
                        play));

        buttons.add(
                new PianoButton(
                		UIConstants.STOP_X,
            	        UIConstants.STOP_Y,
            	        UIConstants.BUTTON_W,
            	        UIConstants.BUTTON_H,
                        "stop",
                        stop));

        buttons.add(
                new PianoButton(
                		UIConstants.REC_X,
            	        UIConstants.REC_Y,
            	        UIConstants.BUTTON_W,
            	        UIConstants.BUTTON_H,
                        "record",
                        record));
        
        buttons.add(
                new PianoButton(
                		UIConstants.IMP_X,
            	        UIConstants.IMP_Y,
            	        UIConstants.BUTTON_W,
            	        UIConstants.BUTTON_H,
                        "imprt",
                        imprt));
        
        buttons.add(
                new PianoButton(
                		UIConstants.SAVE_X,
            	        UIConstants.SAVE_Y,
            	        UIConstants.BUTTON_W,
            	        UIConstants.BUTTON_H,
                        "save",
                        save));
    }

    public void draw(Graphics2D g2) {

//        for (PianoButton button : buttons) {
//
//            button.draw(g2);
//            
//        }
    	for (PianoButton button : buttons) {

            button.draw(g2);

            if (button.getId().equals("sust") && !sound.isSustainEnabled()) {

                g2.setColor(new Color(0, 0, 0, 100));

                g2.fillRect(
                        button.getX(),
                        button.getY(),
                        button.getWidth(),
                        button.getHeight());
            }
            
//            if(button.getId().equals("left") && leftP) {
//
//                g2.setColor(new Color(0,0,0,120));
//                g2.fillRect(
//                        button.getX(),
//                        button.getY(),
//                        button.getWidth(),
//                        button.getHeight());
//                
//                System.out.println("left");
//                
//                
//                
//            }
//
//            if(button.getId().equals("right") && rightP) {
//
//                g2.setColor(new Color(0,0,0,120));
//                g2.fillRect(
//                        button.getX(),
//                        button.getY(),
//                        button.getWidth(),
//                        button.getHeight());
//                
//                System.out.println("right");
//                
//    
//
//            }
            
            if (button.getId().equals("left")
                    && System.currentTimeMillis() - leftPressedTime < 75) {

                g2.setColor(new Color(0, 0, 0, 120));
                g2.fillRect(
                        button.getX(),
                        button.getY(),
                        button.getWidth(),
                        button.getHeight());
            }
            
            if (button.getId().equals("right")
                    && System.currentTimeMillis() - rightPressedTime < 75) {

                g2.setColor(new Color(0, 0, 0, 120));
                g2.fillRect(
                        button.getX(),
                        button.getY(),
                        button.getWidth(),
                        button.getHeight());
            }
        }
    }

    public void handleClick(
            int mouseX,
            int mouseY) {
    	
    	System.out.println("HANDLE CLICK CALLED");

        for (PianoButton button : buttons) {

            if (button.contains(
                    mouseX,
                    mouseY)) {
            	
            	if(button.getId().equals("sust")) {
//                    sustainEnabled = !sustainEnabled;
                    
                    sound.toggleSustain();
                    
                    System.out.println(
                            "Sustain: " + sound.isSustainEnabled());
                }

                System.out.println(
                        "Clicked: "
                        + button.getId());
            }
        }
    }
    
    public void setLeftPressed(boolean pressed) {
        leftP = pressed;
        
        if (pressed) {
            leftPressedTime = System.currentTimeMillis();
        }
        
        System.out.println("left" + pressed);

    }

    public void setRightPressed(boolean pressed) {
        rightP = pressed;
        
        if (pressed) {
            rightPressedTime = System.currentTimeMillis();
        }
        
        System.out.println("right" + pressed);

    }

	
}