package ui;

import java.awt.Color;
import java.awt.Graphics2D;

import main.PianoPanel;

public class UIManager {
	
	private PianoPanel panel;
	private int menuIndex = 0;

    public enum Screen {
        MAIN_MENU,
        PIANO,
        ABOUT,
        SETTINGS
    }

    private Screen currentScreen = Screen.MAIN_MENU;
    
    public UIManager(PianoPanel panel) {
        this.panel = panel;
    }

    public void setScreen(Screen screen) {
        currentScreen = screen;
    }

    public Screen getScreen() {
        return currentScreen;
    }

    public void draw(Graphics2D g2) {

        switch (currentScreen) {

            case MAIN_MENU:
                drawMainMenu(g2);
                break;

            case PIANO:
                drawPiano(g2);
                break;

            case ABOUT:
                drawAbout(g2);
                break;

            case SETTINGS:
                drawSettings(g2);
                break;
        }
    }

    private void drawMainMenu(Graphics2D g2) {
        // Draw title
        // Draw Play button
        // Draw About button
        // Draw Quit button
    	
    	

    	    g2.setColor(new Color(23, 35, 31));
    	    g2.fillRect(0, 0, 512, 384);

    	    g2.setColor(Color.WHITE);
    	    g2.setFont(FontManager.big32);

    	    g2.drawString("SYNTHIXEL", 120, 142);

    	    g2.setFont(FontManager.pixel18);

    	    int x = 200;
    	    int y = 180;

    	    g2.drawString("PLAY", x, y);
    	    if (menuIndex == 0) {
    	        g2.drawString(">", x - 30, y);
    	    }

    	    y += 40;
    	    g2.drawString("ABOUT", x, y);
    	    if (menuIndex == 1) {
    	        g2.drawString(">", x - 30, y);
    	    }

    	    y += 40;
    	    g2.drawString("QUIT", x, y);
    	    if (menuIndex == 2) {
    	        g2.drawString(">", x - 30, y);
    	    }
    	
    }

    private void drawPiano(Graphics2D g2) {
        // Draw piano UI
    	panel.drawPiano(g2);
    }

    private void drawAbout(Graphics2D g2) {
        // Draw about page
    }

    private void drawSettings(Graphics2D g2) {
        // Draw settings
    }
    
    public void moveUp() {

        menuIndex--;

        if (menuIndex < 0)
            menuIndex = 2;
    }

    public void moveDown() {

        menuIndex++;

        if (menuIndex > 2)
            menuIndex = 0;
    }
    
    public void select() {

        switch (menuIndex) {

            case 0:
                setScreen(Screen.PIANO);
                break;

            case 1:
                setScreen(Screen.ABOUT);
                break;

            case 2:
                System.exit(0);
                break;
        }
    }
}