package main;

import javax.swing.*;
import java.awt.*;

public class VolumeLayer {

    private Image volumeSprite;

//    private int volume = 100;
//    private int volumeLevel = 10;
    private SoundManager sound;

    public VolumeLayer(SoundManager sound) {
    	
    	this.sound = sound;

        

        volumeSprite = new ImageIcon(
                getClass().getResource("/sprite/vol.png"))
                .getImage();
    }
//    public void increaseVolume() {
//
//        if (volume < 100) {
//            volume += 10;
//            sound.increaseVolume();
//        }
//    }
    public void increaseVolume() {

        sound.increaseVolume();
    }

//    public void decreaseVolume() {
//
//        if (volume > 0) {
//            volume -= 10;
//            sound.decreaseVolume();
//        }
//    }
    public void decreaseVolume() {

        sound.decreaseVolume();
    }

    public void draw(Graphics2D g2) {

//        int bars = volume / 10;
    	int bars = sound.getVolumeLevel();
    	
    	System.out.println("volume: " + bars);

        for (int i = 0; i < bars; i++) {

            int x =
                    UIConstants.VOLUME_X +
                    i * (UIConstants.VOLUME_BAR_W +
                         UIConstants.VOLUME_GAP);
            
            g2.setColor(Color.RED);

//            g2.fillRect(
//                    x,
//                    UIConstants.VOLUME_Y,
//                    UIConstants.VOLUME_BAR_W,
//                    UIConstants.VOLUME_BAR_H);

            g2.drawImage(
                    volumeSprite,
                    x,
                    UIConstants.VOLUME_Y,
                    UIConstants.VOLUME_BAR_W,
                    UIConstants.VOLUME_BAR_H,
                    null);
            
            
        }
    }
//    public void draw(Graphics2D g2) {
//
//        int bars = sound.getVolumeLevel();
//
//        for (int i = 0; i < bars; i++) {
//
//            int x =
//                    UIConstants.VOLUME_X +
//                    i * (UIConstants.VOLUME_BAR_W +
//                         UIConstants.VOLUME_GAP);
//
//            g2.setColor(Color.RED);
//
//            g2.fillRect(
//                    x,
//                    UIConstants.VOLUME_Y,
//                    UIConstants.VOLUME_BAR_W,
//                    UIConstants.VOLUME_BAR_H);
//
//            System.out.println("Drawing bar " + i);
//        }
//    }
}