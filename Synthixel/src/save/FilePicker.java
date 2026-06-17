package save;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import ui.FontManager;

public class FilePicker {
	
	private void setFontRecursively(java.awt.Component comp, Font font) {

	    comp.setFont(font);

	    if (comp instanceof java.awt.Container) {
	        for (java.awt.Component child :
	                ((java.awt.Container) comp).getComponents()) {

	            setFontRecursively(child, font);
	        }
	    }
	}

    // MUST BE CALLED ONCE AT APP START (VERY IMPORTANT)
    public static void applySynthixelTheme() {

        Color text = new Color(255, 200, 62);
        Color dark = new Color(23, 35, 31);
        Color panel = new Color(50, 60, 57);

        // Nimbus base colors
        UIManager.put("control", dark);
        UIManager.put("info", dark);
        UIManager.put("nimbusBase", dark);
        UIManager.put("nimbusBlueGrey", panel);
        UIManager.put("text", text);

        Font font = FontManager.pixel14;

        // IMPORTANT: global default font FIRST
        UIManager.put("defaultFont", font);

        // UI fonts
        UIManager.put("Button.font", font);
        UIManager.put("Label.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("List.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("Tree.font", font);
        UIManager.put("FileChooser.font", font);

        // File chooser colors (best effort in Nimbus)
        UIManager.put("List.background", dark);
        UIManager.put("List.foreground", text);
        UIManager.put("List.selectionBackground", panel);
        UIManager.put("List.selectionForeground", text);

        UIManager.put("Table.background", dark);
        UIManager.put("Table.foreground", text);
        UIManager.put("Table.selectionBackground", panel);
        UIManager.put("Table.selectionForeground", text);

        UIManager.put("Tree.background", dark);
        UIManager.put("Tree.foreground", text);
        UIManager.put("Tree.selectionBackground", panel);
        UIManager.put("Tree.selectionForeground", text);

        UIManager.put("Panel.background", dark);
        UIManager.put("ScrollPane.background", dark);
        UIManager.put("Viewport.background", dark);
    }

    // OPEN FILE
    public File pickOpenFile() {

        JFileChooser chooser = new JFileChooser();
        
//        chooser.setFont(FontManager.pixel18);
        
     // FORCE ROOT FONT
        chooser.setFont(FontManager.pixel14);

        // FORCE ALL CHILD COMPONENT FONTS
        setFontRecursively(chooser, FontManager.pixel14);
        
        chooser.setDialogTitle("Open Synthixel Recording");

       

        chooser.setFileFilter(
            new FileNameExtensionFilter(
                "Synthixel Files (*.syn)",
                "syn"
            )
        );

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            File file = chooser.getSelectedFile();

            if (file.getName().toLowerCase().endsWith(".syn")) {
                return file;
            }
        }

        return null;
    }

    // SAVE FILE
    public File pickSaveFile() {

        JFileChooser chooser = new JFileChooser();
        
//        chooser.setFont(FontManager.pixel18);
     // FORCE ROOT FONT
        chooser.setFont(FontManager.pixel14);

        // FORCE ALL CHILD COMPONENT FONTS
        setFontRecursively(chooser, FontManager.pixel14);
        chooser.setDialogTitle("Save Synthixel Recording");

        

        chooser.setFileFilter(
            new FileNameExtensionFilter(
                "Synthixel Files (*.syn)",
                "syn"
            )
        );

        int result = chooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {

            File file = chooser.getSelectedFile();

            if (!file.getName().toLowerCase().endsWith(".syn")) {
                file = new File(file.getAbsolutePath() + ".syn");
            }

            return file;
        }

        return null;
    }
}