package com.company.HiVolts;

import java.awt.*;

public class Player {
    private Point playerCoords = new Point(0, 0);
    private Point move = new Point(0, 0);

    public Player(int i, int j) {
        playerCoords.setLocation(i, j);
    }

    public void setPlayerCoords(int i, int j) {
        playerCoords.setLocation(i, j);
    }
    public Point getPlayerCoords() {
        return playerCoords;
    }
    public void updateLoc() {
        playerCoords.setLocation(playerCoords.getX()+move.getX(), playerCoords.getY()+move.getY());
    }

    public void setMove(int i, int j) {
        move.setLocation(i, j);
    }
    public boolean checkPossible() {
        if (playerCoords.getX()+move.getX() < 1 || playerCoords.getX()+move.getX() > 10 || playerCoords.getY()+move.getY() < 1 || playerCoords.getY()+move.getY() > 10) {
            return false;
        } else {
            return true;
        }
    }
}
