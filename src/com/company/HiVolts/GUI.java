package com.company.HiVolts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ActionListener {
    Board myBoard = new Board();
    Cell[][] grid;
    Timer updateTimer = new Timer(1, this);
    public GUI() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.LIGHT_GRAY);
        grid = myBoard.getBoard();
        updateTimer.start();

    }
    public Dimension getPreferredSize() {
        return new Dimension(720, 720);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (myBoard.hasFence(i, j)) {
                    g.setColor(Color.pink);
                    g.fillRect(i*60, j*60, 60, 60);
                }
                if (myBoard.hasMho(i, j)) {
                    g.setColor(Color.RED);
                    g.fillRect(i*60, j*60, 60, 60);
                }
                if (myBoard.hasPlayer(i, j)) {
                    g.setColor(Color.BLUE);
                    g.fillRect(i*60+20, j*60+20, 20, 20);
                }

                g.setColor(Color.black);
                g.drawRect(i*60, j*60, 60, 60);
            }
        }

    }


    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == updateTimer) {
            repaint();
        }
    }
}
