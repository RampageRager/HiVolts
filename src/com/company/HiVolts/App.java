package com.company.HiVolts;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");

        GUI panel = new GUI();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
