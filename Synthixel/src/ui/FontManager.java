package ui;

import java.awt.Font;

public class FontManager {

    public static Font pixel18;
    public static Font pixel14;
    public static Font pixel24;
    public static Font pixel32;
    
    public static Font big32, big24, big40;

    public static void loadFonts() {

        try {

            Font baseFont = Font.createFont(
                    Font.TRUETYPE_FONT,
                    FontManager.class.getResourceAsStream(
                            "/font/VT323-Regular.ttf"));

            pixel14 = baseFont.deriveFont(14f);
            pixel18 = baseFont.deriveFont(18f);
            pixel24 = baseFont.deriveFont(24f);
            pixel32 = baseFont.deriveFont(32f);
            
            
            Font nameFont = Font.createFont(
                    Font.TRUETYPE_FONT,
                    FontManager.class.getResourceAsStream(
                            "/font/PressStart2P-Regular.ttf"));
            
            big40 = nameFont.deriveFont(40f);
            big32 = nameFont.deriveFont(32f);
            big24 = nameFont.deriveFont(24f);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}