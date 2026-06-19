package save;

import java.io.*;

import rec.NoteEvent;
import rec.Recorder;
import ui.MsgNotice;

public class SaveManager {
	
	private MsgNotice msgNotice;

    public SaveManager(MsgNotice msgNotice) {
        this.msgNotice = msgNotice;
    }

    public void save(
            File file,
            Recorder recorder)
            throws IOException {

    	try {
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
                    + e.getTime()
                    + ","
                    + e.getInstrument());
        }

        out.close();
        
        if (msgNotice != null) {
            msgNotice.show("SAVE COMPLETE", "FILE SAVED SUCCESSFULLY.");
        }

    } catch (Exception e) {

        if (msgNotice != null) {
            msgNotice.show("SAVE ERROR", "FAILED TO SAVE FILE.");
        }

        throw e;
    }
    }
}