package audio;

import java.util.ArrayList;

public class InstrumentManager {

    private ArrayList<Instruments> instruments;
    private int currentIndex;

    public InstrumentManager() {

        instruments = new ArrayList<>();

        instruments.add(new Instruments("Piano", "/piano/"));
        instruments.add(new Instruments("Organ", "/organ/"));
        instruments.add(new Instruments("Strings", "/strngs/"));
        instruments.add(new Instruments("Guitar", "/guitar/"));

        currentIndex = 0;

    }

    public Instruments getCurrentInstrument() { 	

        return instruments.get(currentIndex);
    }

    public void nextInstrument() {
        currentIndex++;
        if (currentIndex >= instruments.size()) {
            currentIndex = 0;
        }
    }

    public void previousInstrument() {
        currentIndex--;
        if (currentIndex < 0) {
            currentIndex = instruments.size() - 1;
        }
    }

    public String getCurrentName() {
        return getCurrentInstrument().getName();
     
    }
    
    public int getCurrentIndex() {
    	
    	return currentIndex;
    }
    
    public void setCurrentIndex(int index) {

        if(index >= 0 &&
           index < instruments.size()) {

            currentIndex = index;
        }
    }
}