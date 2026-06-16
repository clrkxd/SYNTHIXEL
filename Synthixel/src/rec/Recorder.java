package rec;

import java.util.ArrayList;

import audio.SoundManager;

//import main.SoundManager;

public class Recorder {

    private ArrayList<NoteEvent> events =
            new ArrayList<>();

    private long startTime;

    private boolean recording;
    private boolean playing;
    

    public void startRecording() {

        events.clear();

        startTime =
                System.currentTimeMillis();

        recording = true;
    }

    public void stopRecording() {

        recording = false;
    }

    public void record(
            String key,
            boolean pressed,
            int instrument) {

        if(!recording)
            return;

        long current =
                System.currentTimeMillis()
                - startTime;

        events.add(
                new NoteEvent(
                        key,
                        pressed,
                        current,
                        instrument));
        
//        System.out.println(
//                "Recorded: "
//                + key
//                + " "
//                + pressed);
        System.out.println(
                key
                + " "
                + pressed
                + " instrument="
                + instrument);
    }

    public void playback(
            SoundManager sound) {

        if(events.isEmpty())
            return;

        new Thread(() -> {

            playing = true;

            long last = 0;

            for(NoteEvent e : events) {

                if(!playing)
                    break;

                try {

                    Thread.sleep(
                            e.getTime() - last);

                } catch(Exception ex) {

                    ex.printStackTrace();
                }
                
                sound.setInstrument(
                        e.getInstrument());

                if(e.isPressed()) {
                    sound.play(e.getKey());
                }
                else {
                    sound.stop(e.getKey());
                }
//                playbackSound.setInstrument(
//                        e.getInstrument());
//
//                if(e.isPressed()) {
//                    playbackSound.play(e.getKey());
//                }
//                else {
//                    playbackSound.stop(e.getKey());
//                }

                last = e.getTime();
            }

        }).start();
    }

    public void stopPlayback() {

        playing = false;
    }

    public boolean isRecording() {
        return recording;
    }

    public boolean isPlaying() {
        return playing;
    }
    
    

    public ArrayList<NoteEvent>
    getEvents() {

        return events;
    }
}