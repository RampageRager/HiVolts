package com.company.HiVolts;

import java.awt.*;
import java.util.Random;

public class Board {
    private Cell[][] board = new Cell[12][12];
    private Player myPlayer;
    private Point move;

    public Board() {
        Random rand = new Random();
        Point[] fenceLocs = new Point[20];
        Point[] mhoLocs = new Point[12];
        Point playerLoc = null;
        boolean matches = false;
        while (fenceLocs[19] == null) {
            int nullInd = 0;
            Point newPoint;
            for (int i = 0; i < 20; i++) {
                if (fenceLocs[i] == null) {
                    nullInd = i;
                    break;
                }
            }
            newPoint = new Point(rand.nextInt(10)+1, rand.nextInt(10)+1);
            for (int i = 0; i < 20; i++) {
                if (fenceLocs[i] != null) {
                    if (fenceLocs[i].getX() == newPoint.getX() && fenceLocs[i].getY() == newPoint.getY()) {
                        matches = true;
                        break;
                    }
                } else {
                    matches = false;
                }
            }
            if (matches == false) {
                fenceLocs[nullInd] = newPoint;
            }
        }

        while (mhoLocs[11] == null) {
            matches = false;
            int nullInd = 0;
            Point newPoint;
            for (int i = 0; i < 12; i++) {
                if (mhoLocs[i] == null) {
                    nullInd = i;
                    break;
                }
            }
            newPoint = new Point(rand.nextInt(10)+1, rand.nextInt(10)+1);
            for (int i = 0; i < 12; i++) {
                if (mhoLocs[i] != null) {
                    if (mhoLocs[i].getX() == newPoint.getX() && mhoLocs[i].getY() == newPoint.getY()) {
                        matches = true;
                        break;
                    }

                } else {
                    matches = false;
                }

                for (int j = 0; j < 20; j++) {
                    if (newPoint.getX() == fenceLocs[j].getX() && newPoint.getY() == fenceLocs[j].getY()) {
                        matches = true;
                        break;
                    }
                }
            }
            if (matches == false) {
                mhoLocs[nullInd] = newPoint;
            }


        }

        while (playerLoc == null) {
            matches = false;
            Point newPoint;
            newPoint = new Point(rand.nextInt(10)+1, rand.nextInt(10)+1);

            for (int i = 0; i < 12; i++) {
                if (mhoLocs[i].getX() == newPoint.getX() && mhoLocs[i].getY() == newPoint.getY()) {
                    matches = true;
                    break;
                }
            }
            for (int j = 0; j < 20; j++) {
                if (newPoint.getX() == fenceLocs[j].getX() && newPoint.getY() == fenceLocs[j].getY()) {
                    matches = true;
                    break;
                }
            }
            if (matches == false) {
                playerLoc = newPoint;
            }
        }

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                board[i][j] = new Cell();
                if (i == 0 || i == 11) {
                    board[i][j].setFence(new Fence());
                } else if (j == 0 || j == 11) {
                    board[i][j].setFence(new Fence());
                }
            }
        }

        for (int i = 0; i < 20; i++) {
            Point fenceLoc = fenceLocs[i];
            int px = (int) fenceLoc.getX();
            int py = (int) fenceLoc.getY();
            board[px][py].setFence(new Fence());
        }

        for (int i = 0; i < 12; i++) {
            Point mhoLoc = mhoLocs[i];
            int px = (int) mhoLoc.getX();
            int py = (int) mhoLoc.getY();
            board[px][py].setMho(new Mho(mhoLoc));
        }

        int px = (int) playerLoc.getX();
        int py = (int) playerLoc.getY();
        board[px][py].setPlayer(new Player());

    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setMove(int x, int y){
        move.setLocation(x, y);
    }

    public boolean hasPlayer(int i, int j) {
        return board[i][j].checkPlayer();
    }

    public Player getPlayer(int i, int j) {
        return board[i][j].returnPlayer();
    }

    public boolean hasFence(int i, int j) {
        return board[i][j].checkFence();
    }

    public Fence returnFence(int i, int j) {
        return board[i][j].returnFence();
    }

    public boolean hasMho(int i, int j) {
        return board[i][j].checkMho();
    }

    public Mho returnMho(int i, int j) {
        return board[i][j].returnMho();
    }

    public void findPlayer() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (hasPlayer(i, j) == true) {
                    myPlayer = getPlayer(i, j);
                }
            }
        }

    }

}
