package rec;

public class NoteEvent {

    private String key;
    private boolean pressed;
    private long time;

    public NoteEvent(String key,
                     boolean pressed,
                     long time) {

        this.key = key;
        this.pressed = pressed;
        this.time = time;
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
}