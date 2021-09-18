package com.company.HiVolts;

import java.awt.*;

public class Player {
    private Point playerCoords;
    private Point move;
    public void setPlayerCoords(int i, int j) {
        playerCoords.setLocation(i, j);
    }
    public Point getPlayerCoords() {
        return playerCoords;
    }

    public void setMove(int i, int j) {
        move.setLocation(i, j);
    }
    public boolean checkPossible() {
        if (playerCoords.getX()+move.getX() < 0 || playerCoords.getX()+move.getX() > 11 || playerCoords.getY()+move.getY() < 0 || playerCoords.getY()+move.getY() > 11) {
            return false;
        } else {
            return true;
        }
    }
}
