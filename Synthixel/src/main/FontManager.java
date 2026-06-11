package main;

import java.awt.Font;

public class FontManager {

    public static Font pixel18;
    public static Font pixel14;
    public static Font pixel24;
    public static Font pixel32;

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}