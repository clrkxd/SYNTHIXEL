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
    	
    	
//    	System.out.println("Current Index: " + currentIndex);
//        System.out.println("Instrument: " + instruments.get(currentIndex).getName());

        return instruments.get(currentIndex);
//        return instruments.get(currentIndex);
        
//        System.out.println(currentIndex);
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
        
//        String name = getCurrentInstrument().getName();
//        
//        System.out.println("Current Name = " + name);
//
//        return name;
     
    }
    
    public int getCurrentIndex() {
    	
//    	System.out.println(currentIndex);
    	return currentIndex;
    }
}