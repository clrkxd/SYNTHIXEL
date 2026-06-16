package ui;

import main.UIConstants;
import rec.Recorder;
import save.FilePicker;
import save.LoadManager;
import save.SaveManager;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import audio.SoundManager;

public class ButtonLayer {

    private ArrayList<PianoButton> buttons;
//    private boolean sustainEnabled;
    private SoundManager sound;
    private Recorder recorder;
    private FilePicker filePicker;
    private SaveManager saveManager;
    private LoadManager loadManager;
    
    private Image left, right, sust, play, stop, imprt, record, save;
    
    private boolean leftP, rightP;
    private long rightPressedTime;
    private long leftPressedTime;
    
    private SoundManager playbackSound;
    
    

    public ButtonLayer(SoundManager sound,
    		SoundManager playbackSound,
    		Recorder recorder, 
    		SaveManager saveManager, 
    		LoadManager loadManager){
    	
 
    	filePicker = new FilePicker();
        this.sound = sound;
        this.playbackSound = playbackSound;
        this.recorder = recorder;
       
        this.saveManager = saveManager;
        this.loadManager = loadManager;
    	
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
            
            
//            if(button.getId().equals("record")) {
//
//                recorder.startRecording();
//
//                System.out.println("Recording started");
//                
//                g2.setColor(new Color(0, 0, 0, 120));
//                g2.fillRect(
//                        button.getX(),
//                        button.getY(),
//                        button.getWidth(),
//                        button.getHeight());
//            }
//
//            if(button.getId().equals("stop")) {
//
//                recorder.stopRecording();
//                recorder.stopPlayback();
//                
//                g2.setColor(new Color(0, 0, 0, 120));
//                g2.fillRect(
//                        button.getX(),
//                        button.getY(),
//                        button.getWidth(),
//                        button.getHeight());
//
//                System.out.println("Stopped");
//            }
//
//            if(button.getId().equals("play")) {
//
//                recorder.playback(sound);
//                
//                g2.setColor(new Color(0, 0, 0, 120));
//                g2.fillRect(
//                        button.getX(),
//                        button.getY(),
//                        button.getWidth(),
//                        button.getHeight());
//
//                System.out.println("Playing");
//            }
//            
//            if(button.getId().equals("imprt")) {
//
//                recorder.startRecording();
//
//                System.out.println("importing");
//                
//                g2.setColor(new Color(0, 0, 0, 120));
//                g2.fillRect(
//                        button.getX(),
//                        button.getY(),
//                        button.getWidth(),
//                        button.getHeight());
//            }
////            
////            if(button.getId().equals("save")) {
////
////                recorder.startRecording();
////
////                System.out.println("save started");
////                
////                g2.setColor(new Color(0, 0, 0, 120));
////                g2.fillRect(
////                        button.getX(),
////                        button.getY(),
////                        button.getWidth(),
////                        button.getHeight());
////            }
////            
//            if(button.getId().equals("save")) {
//
//                try {
//
//                    File file =
//                            filePicker.pickSaveFile();
//
//                    if(file != null) {
//
//                        saveManager.save(
//                                file,
//                                recorder);
//
//                        System.out.println(
//                                "Saved: "
//                                + file.getName());
//                    }
//
//                } catch(Exception e) {
//
//                    e.printStackTrace();
//                }
//            }
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
            	
            	   if(button.getId().equals("save")) {

                       try {

//                           File file =
//                                   filePicker.pickSaveFile();
//
//                           if(file != null) {
//
//                               saveManager.save(
//                                       file,
//                                       recorder);
//
//                               System.out.println(
//                                       "Saved: "
//                                       + file.getName());
                    	   
                    	   System.out.println(
                                   "Events: "
                                   + recorder.getEvents().size());

                           File file =
                                   filePicker.pickSaveFile();

                           if(file != null) {

                               saveManager.save(
                                       file,
                                       recorder);

                               System.out.println(
                                       "Saved: "
                                       + file.getName());
                           }

                       } catch(Exception e) {

                           e.printStackTrace();
                       }
                   }
            	

                   if(button.getId().equals("imprt")) {

                	    try {

                	        File file =
                	                filePicker.pickOpenFile();

                	        if(file != null) {

                	            loadManager.load(
                	                    file,
                	                    recorder);

                	            System.out.println(
                	                    "Loaded: "
                	                    + file.getName());
                	        }

                	    } catch(Exception e) {

                	        e.printStackTrace();
                	    }
                	}
                   
                   if(button.getId().equals("record")) {

                	    if(!recorder.isRecording()) {

                	        recorder.startRecording();

                	        System.out.println("Recording");

                	    } else {

                	        recorder.stopRecording();

                	        System.out.println("Recording stopped");
                	    }
                	}
                   
                   if(button.getId().equals("play")) {

//                	    recorder.playback(sound);
                	   recorder.playback(playbackSound);

                	    System.out.println("Playing");
                	}
                   
                   if(button.getId().equals("stop")) {

                	    recorder.stopRecording();
                	    recorder.stopPlayback();

                	    System.out.println("Stopped");
                	}

                System.out.println(
                        "Clicked: "
                        + button.getId());
            }
//           if(button.getId().equals("save")) {
//
//            try {
//
//                saveManager.save(
//                        new File("song.syn"),
//                        recorder);
//
//                System.out.println("Saved");
//
//            } catch(Exception e) {
//
//                e.printStackTrace();
//            }
//        }
            
         
           
//           if(button.getId().equals("imprt")) {
//
//        	    try {
//
//        	        loadManager.load(
//        	                new File("song.syn"),
//        	                recorder);
//
//        	        System.out.println("Loaded");
//
//        	    } catch(Exception e) {
//
//        	        e.printStackTrace();
//        	    }
//        	}
           

        }
        
                
    }
    
    public void setLeftPressed(boolean pressed) {
        leftP = pressed;
        
        if (pressed) {
            leftPressedTime = System.currentTimeMillis();
        }
        
//        System.out.println("left" + pressed);

    }

    public void setRightPressed(boolean pressed) {
        rightP = pressed;
        
        if (pressed) {
            rightPressedTime = System.currentTimeMillis();
        }
        
//        System.out.println("right" + pressed);

    }

	
}