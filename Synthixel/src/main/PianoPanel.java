package main;

import javax.swing.*;

import audio.InstrumentManager;
import audio.SoundManager;
import rec.Recorder;
import save.LoadManager;
import save.SaveManager;
import ui.AboutPage;
import ui.ButtonLayer;
import ui.DisplayManager;
import ui.MonitorDisplay;
import ui.MsgNotice;
import ui.PianoButton;
import ui.PianoFrameLayer;
import ui.PianoKeys;
import ui.PianoLinesLayer;
import ui.TipTool;
import ui.VolumeLayer;
import ui.FontManager;
import ui.UIManager;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;

public class PianoPanel extends JPanel {

    public static final int FIN_WIDTH = 512;
    public static final int FIN_HEIGHT = 384;

    private UIManager uiManager;
    private AboutPage aboutPage;
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
    
    public MsgNotice msgNotice;
    
 

    
    public PianoPanel() {
    	
        setPreferredSize(new Dimension(FIN_WIDTH, FIN_HEIGHT));
        setBackground(new Color(23, 35, 31));
        setLayout(null);
        
        uiManager = new UIManager(this);
        
        aboutPage = new AboutPage(uiManager);
       

        msgNotice = new MsgNotice();
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
                loadManager,
                msgNotice);

        keyLayer = new PianoKeys(sound, instrumentManager, buttonLayer, recorder, uiManager);
        linesLayer = new PianoLinesLayer();
        volumeLayer = new VolumeLayer(sound);
        monitorLayer = new MonitorDisplay();
        displayManager = new DisplayManager();
        
        displayManager.setIns(instrumentManager);
        displayManager.setRec(recorder);
        
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
                
                msgNotice.clickOK(e.getX(), e.getY());
                
                if (uiManager.getScreen() == UIManager.Screen.ABOUT) {
                    aboutPage.mouseClicked(e.getX(), e.getY());
                }
          
                
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

        uiManager.draw(g2);
//        // Bottom Layer
//        frameLayer.draw(g2);
//
//        // Piano Keys
//        keyLayer.draw(g2);
//        
//        // button layer
//        buttonLayer.draw(g2);
//        
//        // volume layer
//        volumeLayer.draw(g2);
//        
//        // monitor layer
//        monitorLayer.draw(g2);
//        
//        // display
//        displayManager.draw(g2);
//        
//        // Top Layer
//        linesLayer.draw(g2);
//        
//        //hovers
//        tiptool.draw(g2);
//        
//        //message
//        msgNotice.draw(g2);

        g2.dispose();
    }
    
    public void drawPiano(Graphics2D g2) {
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
        
        //message
        msgNotice.draw(g2);
    	
    }
}