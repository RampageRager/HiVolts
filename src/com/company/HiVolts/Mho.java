package com.company.HiVolts;

import java.awt.*;

public class Mho {
    private Point playerCoordinates = new Point(0, 0);
    private Point mhoCoordinates;

    public Mho(Point coords) {
        mhoCoordinates = coords;
    }

    public void setPlayerCoordinates(Point playerCoords) {
        playerCoordinates.setLocation(playerCoords);
    }
    public void setMhoCoordinates(Point mhoCoords) {
        mhoCoordinates.setLocation(mhoCoords);
    }

    public Point getMhoCoordinates() {
        return mhoCoordinates;
    }
    public Point getPlayerCoordinates() {
        return playerCoordinates;
    }

    public Point getNewMhoMove() {
        Point move = new Point(0, 0);

        if (mhoCoordinates.getX() == playerCoordinates.getX()) {
            if (mhoCoordinates.getY() > playerCoordinates.getY()) {
                move.setLocation(move.getX(), -1);
            } else {
                move.setLocation(move.getX(), 1);
            }
        } else if (mhoCoordinates.getY() == playerCoordinates.getY()) {
            if (mhoCoordinates.getX() > playerCoordinates.getX()) {
                move.setLocation(-1, move.getY());
            } else {
                move.setLocation(1, move.getY());
            }
        } else if (Math.abs(mhoCoordinates.getY() - playerCoordinates.getY()) == Math.abs(mhoCoordinates.getX() - playerCoordinates.getX())) {
            if (mhoCoordinates.getX() > playerCoordinates.getX()) {
                move.setLocation(-1, move.getY());
            } else {
                move.setLocation(1, move.getY());
            }
            if (mhoCoordinates.getY() > playerCoordinates.getY()) {
                move.setLocation(move.getX(), -1);
            } else {
                move.setLocation(move.getX(), 1);
            }

        } else if (Math.abs(mhoCoordinates.getY() - playerCoordinates.getY()) < Math.abs(mhoCoordinates.getX() - playerCoordinates.getX())) {
            if (mhoCoordinates.getX() > playerCoordinates.getX()) {
                move.setLocation(-1, move.getY());
            } else {
                move.setLocation(1, move.getY());
            }
        } else if (Math.abs(mhoCoordinates.getY() - playerCoordinates.getY()) > Math.abs(mhoCoordinates.getX() - playerCoordinates.getX())) {
            if (mhoCoordinates.getY() > playerCoordinates.getY()) {
                move.setLocation(move.getX(), -1);
            } else {
                move.setLocation(move.getX(), 1);
            }
        }

        return move;
    }

    public Point getNewMhoPos(Point playerCoords, Point mhoCoords) {
        setPlayerCoordinates(playerCoords);
        setMhoCoordinates(mhoCoords);
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
