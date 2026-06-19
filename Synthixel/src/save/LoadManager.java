package save;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import rec.NoteEvent;
import rec.Recorder;

public class LoadManager {

    public void load(File file, Recorder recorder) throws IOException {

        recorder.getEvents().clear();

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {

                String[] split = scanner.nextLine().split(",");

                recorder.getEvents().add(
                    new NoteEvent(
                        split[0],
                        Boolean.parseBoolean(split[1]),
                        Long.parseLong(split[2]),
                        Integer.parseInt(split[3])
                    )
                );
            }
        }
        
        
    }
    
    
}