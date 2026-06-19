package save;

import java.io.*;

import rec.NoteEvent;
import rec.Recorder;

public class SaveManager {

    public void save(
            File file,
            Recorder recorder)
            throws IOException {

        try (PrintWriter out =
                     new PrintWriter(
                             new FileWriter(file))) {

            for (NoteEvent e : recorder.getEvents()) {

                out.println(
                        e.getKey()
                        + ","
                        + e.isPressed()
                        + ","
                        + e.getTime()
                        + ","
                        + e.getInstrument());
            }
        }
    }
}