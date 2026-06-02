package main;

import javax.swing.*;
import java.awt.*;

public class PianoPanel extends JPanel {

    public static final int FIN_WIDTH = 512;
    public static final int FIN_HEIGHT = 384; // 4:3 ratio

    private PianoKeys keyPanel;

    public PianoPanel() {

        setLayout(new GridBagLayout()); // center everything
        setPreferredSize(new Dimension(FIN_WIDTH, FIN_HEIGHT));
        setBackground(new Color(228, 157, 110));

        keyPanel = new PianoKeys();

        add(keyPanel); // centered automatically
    }
}