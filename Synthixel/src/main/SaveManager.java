package main;

import java.io.*;

public class SaveManager {

    public void save(
            File file,
            Recorder recorder)
            throws IOException {

        PrintWriter out =
                new PrintWriter(
                        new FileWriter(file));

        for(NoteEvent e :
                recorder.getEvents()) {

            out.println(
                    e.getKey()
                    + ","
                    + e.isPressed()
                    + ","
                    + e.getTime());
        }

        out.close();
    }
}