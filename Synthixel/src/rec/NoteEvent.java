package rec;

public class NoteEvent {

    private String key;
    private boolean pressed;
    private long time;
    private int instrument;

    public NoteEvent(String key,
                     boolean pressed,
                     long time,
                     int instrument) {

        this.key = key;
        this.pressed = pressed;
        this.time = time;
        this.instrument = instrument;
    }

    public String getKey() {
        return key;
    }

    public boolean isPressed() {
        return pressed;
    }

    public long getTime() {
        return time;
    }
    
    public int getInstrument() {
        return instrument;
    }
}