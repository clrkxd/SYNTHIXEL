package input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import audio.InstrumentManager;
import audio.SoundManager;
import rec.Recorder;
import ui.ButtonLayer;
import ui.UIManager;

public class PianoInput extends KeyAdapter {

    public boolean[] whitePressed = new boolean[10];
    public boolean[] blackPressed = new boolean[7];

    private boolean[] keyHeld = new boolean[256];
    
    private UIManager uiManager;

    private SoundManager sound;
    private InstrumentManager instrumentManager;
    private ButtonLayer buttonLayer;
    private Recorder recorder;

    public PianoInput(SoundManager sound, InstrumentManager instrumentManager, ButtonLayer buttonLayer, Recorder recorder, UIManager uiManager) {
        this.sound = sound;
        this.instrumentManager = instrumentManager;
        this.buttonLayer = buttonLayer;
        this.recorder = recorder;
        this.uiManager = uiManager;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (uiManager.getScreen() == UIManager.Screen.MAIN_MENU) {

            // Handle menu navigation
        	switch (key) {
            case KeyEvent.VK_UP:
                uiManager.moveUp();
                break;

            case KeyEvent.VK_DOWN:
                uiManager.moveDown();
                break;

            case KeyEvent.VK_ENTER:
                uiManager.select();
                break;
        }

        } else if (uiManager.getScreen() == UIManager.Screen.PIANO) {

            // Handle piano controls
        	 // BLOCK AUTO REPEAT
            if (keyHeld[key]) return;

            keyHeld[key] = true;
            setKey(key, true);
            
            //volume
            int vol = e.getKeyCode();
            
            
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                sound.setSustain(true);
            }

//            if(vol >= KeyEvent.VK_1 &&
//            		   vol <= KeyEvent.VK_9) {
    //
//            		    int level =
//            		        vol - KeyEvent.VK_0;
    //
//            		    sound.setVolume(level);
//            		}
//            
//            if(vol == KeyEvent.VK_0) {
    //
//                sound.setVolume(10);
//            }
            
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            	sound.stop(null);            
            	sound.stop("C");
            	sound.stop("D");
            	sound.stop("E");
            	sound.stop("F");
            	sound.stop("G");
            	sound.stop("A");
            	sound.stop("B");
            	sound.stop("C2");
            	sound.stop("D2");
            	sound.stop("E2");
            	sound.stop("C#");
            	sound.stop("D#");
            	sound.stop("F#");
            	sound.stop("G#");
            	sound.stop("A#");
            	sound.stop("C#2");
            	sound.stop("D#2");
            	instrumentManager.nextInstrument();
                sound.loadCurrentInstrument();
                buttonLayer.setRightPressed(true);
            }

            if(e.getKeyCode() == KeyEvent.VK_LEFT) {
//            	sound.stop(null);
            	sound.stop("C");
            	sound.stop("D");
            	sound.stop("E");
            	sound.stop("F");
            	sound.stop("G");
            	sound.stop("A");
            	sound.stop("B");
            	sound.stop("C2");
            	sound.stop("D2");
            	sound.stop("E2");
            	sound.stop("C#");
            	sound.stop("D#");
            	sound.stop("F#");
            	sound.stop("G#");
            	sound.stop("A#");
            	sound.stop("C#2");
            	sound.stop("D#2");
                instrumentManager.previousInstrument();
                sound.loadCurrentInstrument();
                buttonLayer.setLeftPressed(true);
            }
            
            
            
                
            switch (vol) {    
            case KeyEvent.VK_DOWN:
                sound.decreaseVolume();
                break;

            case KeyEvent.VK_UP:
                sound.increaseVolume();
                break;
            }   
            
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            	uiManager.setScreen(UIManager.Screen.PAUSE);
            }

        } else if (uiManager.getScreen() == UIManager.Screen.PAUSE) {
        	switch (key) {
            case KeyEvent.VK_UP:
                uiManager.pause_up();
                break;

            case KeyEvent.VK_DOWN:
                uiManager.pause_down();
                break;

            case KeyEvent.VK_ENTER:
                uiManager.pause_select();
                break;
        	}
        }
        
        

       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        keyHeld[key] = false;
        setKey(key, false);
        
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            sound.setSustain(false);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            buttonLayer.setRightPressed(false);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            buttonLayer.setLeftPressed(false);
        }

    }

    private void setKey(int key, boolean pressed) {

        switch (key) {

            // WHITE KEYS
            case KeyEvent.VK_A -> {
                whitePressed[0] = pressed;
                if (pressed) sound.play("C");
                else sound.stop("C");
                
                recorder.record("C", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_S -> {
                whitePressed[1] = pressed;
                if (pressed) sound.play("D");
                else sound.stop("D");
                
                recorder.record("D", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_D -> {
                whitePressed[2] = pressed;
                if (pressed) sound.play("E");
                else sound.stop("E");
                
                recorder.record("E", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_F -> {
                whitePressed[3] = pressed;
                if (pressed) sound.play("F");
                else sound.stop("F");
                
                recorder.record("F", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_G -> {
                whitePressed[4] = pressed;
                if (pressed) sound.play("G");
                else sound.stop("G");
                
                recorder.record("G", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_H -> {
                whitePressed[5] = pressed;
                if (pressed) sound.play("A");
                else sound.stop("A");
                
                recorder.record("A", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_J -> {
                whitePressed[6] = pressed;
                if (pressed) sound.play("B");
                else sound.stop("B");
                
                recorder.record("B", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_K -> {
                whitePressed[7] = pressed;
                if (pressed) sound.play("C2");
                else sound.stop("C2");
                
                recorder.record("C2", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_L -> {
                whitePressed[8] = pressed;
                if (pressed) sound.play("D2");
                else sound.stop("D2");
                
                recorder.record("D2", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_SEMICOLON -> {
                whitePressed[9] = pressed;
                if (pressed) sound.play("E2");
                else sound.stop("E2");
                
                recorder.record("E2", pressed, instrumentManager.getCurrentIndex());
            }

            // BLACK KEYS
            case KeyEvent.VK_W -> {
                blackPressed[0] = pressed;
                if (pressed) sound.play("C#");
                else sound.stop("C#");
                
                recorder.record("C#", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_E -> {
                blackPressed[1] = pressed;
                if (pressed) sound.play("D#");
                else sound.stop("D#");
                
                recorder.record("D#", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_T -> {
                blackPressed[2] = pressed;
                if (pressed) sound.play("F#");
                else sound.stop("F#");
                
                recorder.record("F#", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_Y -> {
                blackPressed[3] = pressed;
                if (pressed) sound.play("G#");
                else sound.stop("G#");
                
                recorder.record("G#", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_U -> {
                blackPressed[4] = pressed;
                if (pressed) sound.play("A#");
                else sound.stop("A#");
                
                recorder.record("A#", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_O -> {
                blackPressed[5] = pressed;
                if (pressed) sound.play("C#2");
                else sound.stop("C#2");
                
                recorder.record("C#2", pressed, instrumentManager.getCurrentIndex());
            }
            case KeyEvent.VK_P -> {
                blackPressed[6] = pressed;
                if (pressed) sound.play("D#2");
                else sound.stop("D#2");
                
                recorder.record("D#2", pressed, instrumentManager.getCurrentIndex());
            }
        }
    }
}