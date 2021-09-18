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

    public Point getMhoCoordinates() {
        return mhoCoordinates;
    }
    public Point getPlayerCoordinates() {
        return playerCoordinates;
    }
    public boolean checkIntersecting() {
        if (playerCoordinates.getX() == mhoCoordinates.getX() && playerCoordinates.getY() == mhoCoordinates.getY()) {
            return true;
        } else {
            return false;
        }
    }
}
