package save;

import java.io.*;
import java.util.Scanner;

import rec.NoteEvent;
import rec.Recorder;
import ui.MsgNotice;

public class LoadManager {

	
	private MsgNotice msgNotice;

    public LoadManager(MsgNotice msgNotice) {
        this.msgNotice = msgNotice;
    }

    public void load(
            File file,
            Recorder recorder)
            throws IOException {

    	try {
        recorder.getEvents().clear();

        Scanner scanner =
                new Scanner(file);

        while(scanner.hasNextLine()) {

            String line =
                    scanner.nextLine();

            String[] split =
                    line.split(",");

            String key =
                    split[0];

            boolean pressed =
                    Boolean.parseBoolean(
                            split[1]);

            long time =
                    Long.parseLong(
                            split[2]);
            
            int instrument =
                    Integer.parseInt(split[3]);

            recorder.getEvents().add(
                    new NoteEvent(
                            key,
                            pressed,
                            time,
                            instrument));
        }

        scanner.close();
        
        if (msgNotice != null) {
            msgNotice.show("LOAD COMPLETE", "FILE LOADED SUCCESSFULLY.");
        }

    } catch (Exception e) {

        if (msgNotice != null) {
            msgNotice.show("LOAD ERROR", "FAILED TO LOAD FILE.");
        }

        throw e;
    }
    }
    
}