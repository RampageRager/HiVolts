package com.company.HiVolts;

import java.awt.*;

public class Mho {
    private Point playerCoordinates;
    private Point mhoCoordinates;

    public Mho(Point coords) {
        mhoCoordinates = coords;
    }

    public void setPlayerCoordinates(int i, int j) {
        playerCoordinates.setLocation(i, j);
    }
    public void setMhoCoordinates(int x, int y) {
        mhoCoordinates.setLocation(x, y);
    }

    public Point getMhoCoordinates() {return mhoCoordinates;}
    public Point getPlayerCoordinates() {return playerCoordinates;}

    private Point getNewMhoMove() {
        Point move = new Point(0, 0);
        if (mhoCoordinates.getX() < playerCoordinates.getX()) {
            move.setLocation(1, move.getY());
        } else if (mhoCoordinates.getX() > playerCoordinates.getX()) {
            move.setLocation(-1, move.getY());
        }
        if (mhoCoordinates.getY() < playerCoordinates.getY()) {
            move.setLocation(move.getX(), 1);
        } else if (mhoCoordinates.getX() > playerCoordinates.getX()) {
            move.setLocation(move.getX(), -1);
        }

        return move;
    }

    public Point getNewMhoPos() {
        return new Point((int)(mhoCoordinates.getX()+getNewMhoMove().getX()), (int)(mhoCoordinates.getY()+getNewMhoMove().getY()));
    }

    public boolean checkIntersecting() {
        if (playerCoordinates.getX() == mhoCoordinates.getX() && playerCoordinates.getY() == mhoCoordinates.getY()) {
            return true;
        } else {
            return false;
        }
    }
}
