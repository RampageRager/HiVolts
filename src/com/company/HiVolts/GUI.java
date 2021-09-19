package com.company.HiVolts;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {
    Board myBoard = new Board();
    public GUI() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.LIGHT_GRAY);

    }
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


    }
}
