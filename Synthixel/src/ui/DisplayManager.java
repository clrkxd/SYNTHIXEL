package ui;

import java.awt.Color;
import java.awt.Graphics2D;

import audio.InstrumentManager;
import rec.Recorder;

public class DisplayManager {

//	private String title;
	public InstrumentManager instrumentManager;
	public Recorder recorder;
	public Recorder player;
	
//	public void setSymbol () {
//	
//	}
	
	public void setRec(Recorder recorder) {
	    this.recorder = recorder;
	}
	
//	public void setPlay(Recorder player) {
//		this.player = player;
//	}
	
	
//	public void setTitle(String title) {
//		this.title = title;
////		this.recorder = recorder;
//		
//		
//	}
//	
	public void setIns(InstrumentManager instrumentManager) {
		this.instrumentManager = instrumentManager;
	}
	
	
	
	public void draw(Graphics2D g2) {
		String title;
		
//		if (recorder == null) {
//		    System.out.println("Recorder is null");
//		} else {
//		    System.out.println("Recording: " + recorder.isRecording());
//		}
		
		if(recorder != null && recorder.isRecording()) {
			title = "RECORDING...";
		} else if (recorder != null && recorder.isPlaying()) {
			title = "PLAYING...";
		}
		else {
			title = "SYNTHIXEL";
		}

		g2.setColor(new Color(255, 200, 62));
		g2.setFont(FontManager.pixel32);
		g2.drawString(title, 135, 50);

		if(instrumentManager != null) {
	        String insD = instrumentManager.getCurrentInstrument().getName();
			g2.setColor(new Color(255, 200, 62));
			g2.setFont(FontManager.big32);
	        g2.drawString(insD, 50, 115);

	        int intNum = instrumentManager.getCurrentIndex();
	        String insN = String.valueOf(intNum + 1);
	        g2.setFont(FontManager.big24);
	        g2.drawString(insN, 50, 55);
	    }
		
	}
}
