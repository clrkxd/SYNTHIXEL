package main;

import java.awt.*;
import java.util.ArrayList;

public class ButtonLayer {

    private ArrayList<PianoButton> buttons;

    public ButtonLayer() {

        buttons = new ArrayList<>();

//        buttons.add(
//                new PianoButton(
//                        40,
//                        40,
//                        30,
//                        20,
//                        "INST1"));

//        buttons.add(
//                new PianoButton(
//                        80,
//                        40,
//                        30,
//                        20,
//                        "INST2"));
//
//        buttons.add(
//                new PianoButton(
//                        120,
//                        40,
//                        30,
//                        20,
//                        "INST3"));
    }

    public void draw(Graphics2D g2) {

        for (PianoButton button : buttons) {

            button.draw(g2);
        }
    }

    public void handleClick(
            int mouseX,
            int mouseY) {

        for (PianoButton button : buttons) {

            if (button.contains(
                    mouseX,
                    mouseY)) {

                System.out.println(
                        "Clicked: "
                        + button.getId());
            }
        }
    }
}