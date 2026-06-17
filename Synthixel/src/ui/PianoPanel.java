package ui;

import javax.swing.*;

import audio.InstrumentManager;
import audio.SoundManager;
import rec.Recorder;
import save.LoadManager;
import save.SaveManager;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;

public class PianoPanel extends JPanel {

    public static final int FIN_WIDTH = 512;
    public static final int FIN_HEIGHT = 384;

    private PianoFrameLayer frameLayer;
    private PianoKeys keyLayer;
    private PianoLinesLayer linesLayer;
    private ButtonLayer buttonLayer;
    private VolumeLayer volumeLayer;
    private SoundManager sound;          // user plays this
    private SoundManager playbackSound;  // recorder uses this
    public InstrumentManager instrumentManager;
    private MonitorDisplay monitorLayer;
    private DisplayManager displayManager;
    private  LoadManager loadManager;
    private Recorder recorder;
    private SaveManager saveManager;
    private TipTool tiptool;
 

    
    public PianoPanel() {
    	
        setPreferredSize(new Dimension(FIN_WIDTH, FIN_HEIGHT));
        setBackground(new Color(228, 157, 110));
        setLayout(null);
        

        instrumentManager = new InstrumentManager();
        sound = new SoundManager(instrumentManager);

        InstrumentManager playbackInstrumentManager =
                new InstrumentManager();

        playbackSound =
                new SoundManager(
                        playbackInstrumentManager);
        
        

        frameLayer = new PianoFrameLayer();
        recorder = new Recorder();
        saveManager = new SaveManager();
        loadManager = new LoadManager();

        buttonLayer = new ButtonLayer(sound, 
        		playbackSound,
        		recorder,
                saveManager,
                loadManager);

        keyLayer = new PianoKeys(sound, instrumentManager, buttonLayer, recorder);
        linesLayer = new PianoLinesLayer();
        volumeLayer = new VolumeLayer(sound);
        monitorLayer = new MonitorDisplay();
        displayManager = new DisplayManager();
        
        displayManager.setIns(instrumentManager);
        
        tiptool = new TipTool();
        
        
        
        
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
        
        
        addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {

                String text = buttonLayer.getHoverText(
                        e.getX(),
                        e.getY());

                tiptool.setText(text);
                
                PianoButton hovered =
                        buttonLayer.getHoveredButton(
                                e.getX(),
                                e.getY());
                
                tiptool.setText(text);
                tiptool.setPosition(
                        e.getX(),
                        e.getY());

                tiptool.setHoveredButton(hovered);

                repaint();
            }
            
            
        });
        new Timer(16, e -> repaint()).start();

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
        
        //hovers
        tiptool.draw(g2);

        g2.dispose();
    }
}