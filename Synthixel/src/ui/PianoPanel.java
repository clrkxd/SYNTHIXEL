package ui;

import javax.swing.*;

import audio.InstrumentManager;
import audio.SoundManager;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PianoPanel extends JPanel {

    public static final int FIN_WIDTH = 512;
    public static final int FIN_HEIGHT = 384;

    private PianoFrameLayer frameLayer;
    private PianoKeys keyLayer;
    private PianoLinesLayer linesLayer;
    private ButtonLayer buttonLayer;
    private VolumeLayer volumeLayer;
    private SoundManager sound;
    public InstrumentManager instrumentManager;
    private MonitorDisplay monitorLayer;
    private DisplayManager displayManager;

    public PianoPanel() {
    	
    	

        setPreferredSize(new Dimension(FIN_WIDTH, FIN_HEIGHT));
        setBackground(new Color(228, 157, 110));
        setLayout(null);
        

        instrumentManager = new InstrumentManager();
        sound = new SoundManager(instrumentManager);

        frameLayer = new PianoFrameLayer();
        
        buttonLayer = new ButtonLayer(sound);

        keyLayer = new PianoKeys(sound, instrumentManager, buttonLayer);
        linesLayer = new PianoLinesLayer();
        volumeLayer = new VolumeLayer(sound);
        monitorLayer = new MonitorDisplay();
        displayManager = new DisplayManager();
        
        
        FontManager.loadFonts();
        
        setFocusable(true);

        addKeyListener(
                keyLayer.getInput());

        SwingUtilities.invokeLater(
                this::requestFocusInWindow);
        
        addMouseListener(
                new MouseAdapter() {

            @Override
            public void mousePressed(
                    MouseEvent e) {
//            	requestFocusInWindow();
            	
            	
                buttonLayer.handleClick(
                        e.getX(),
                        e.getY());
                
                
                
            }
        });
        new Timer(16, e -> repaint()).start();
//        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Bottom Layer
        frameLayer.draw(g2);

        // Piano Keys
        keyLayer.draw(g2);
        
        // button layer
        buttonLayer.draw(g2);
        
        // volume layer
        volumeLayer.draw(g2);
        
        // monitor layer
        monitorLayer.draw(g2);
        
        // display
        displayManager.draw(g2);
        
        // Top Layer
        linesLayer.draw(g2);

        g2.dispose();
    }
}