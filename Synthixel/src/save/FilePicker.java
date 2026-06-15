package save;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FilePicker {

    public File pickOpenFile() {

        JFileChooser chooser =
                new JFileChooser();

        chooser.setDialogTitle(
                "Open Synthixel Recording");

        chooser.setFileFilter(
                new FileNameExtensionFilter(
                        "Synthixel Files (*.syn)",
                        "syn"));

        int result =
                chooser.showOpenDialog(null);

        if(result ==
                JFileChooser.APPROVE_OPTION) {

            File file =
                    chooser.getSelectedFile();

            if(file.getName()
                    .toLowerCase()
                    .endsWith(".syn")) {

                return file;
            }
        }

        return null;
    }

    public File pickSaveFile() {

        JFileChooser chooser =
                new JFileChooser();

        chooser.setDialogTitle(
                "Save Synthixel Recording");

        chooser.setFileFilter(
                new FileNameExtensionFilter(
                        "Synthixel Files (*.syn)",
                        "syn"));

        int result =
                chooser.showSaveDialog(null);

        if(result ==
                JFileChooser.APPROVE_OPTION) {

            File file =
                    chooser.getSelectedFile();

            if(!file.getName()
                    .toLowerCase()
                    .endsWith(".syn")) {

                file = new File(
                        file.getAbsolutePath()
                        + ".syn");
            }

            return file;
        }

        return null;
    }
}
