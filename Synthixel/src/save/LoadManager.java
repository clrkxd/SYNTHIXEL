package save;

import java.io.*;
import java.util.Scanner;

import rec.NoteEvent;
import rec.Recorder;

public class LoadManager {
	
	
//	LoadManager loader =new LoadManager();

	

    public void load(
            File file,
            Recorder recorder)
            throws IOException {

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
    }
    
}