package com.company.HiVolts;

import java.awt.*;

public class Mho {
    private Point playerCoordinates;
    private Point mhoCoordinates;
    public void setPlayerCoordinates(int i, int j) {
        playerCoordinates.setLocation(i, j);
    }
    public void setMhoCoordinates(int x, int y) {
        mhoCoordinates.setLocation(x, y);
    }
}
