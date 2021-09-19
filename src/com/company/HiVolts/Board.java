package com.company.HiVolts;

import java.awt.*;
import java.util.Random;

public class Board {
    private Cell[][] board = new Cell[12][12];
    private Player myPlayer;
    private Point move;
    private boolean gameOver = false;

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
        board[px][py].setPlayer(new Player(px, py));
        myPlayer = new Player(px, py);

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
                    myPlayer.setPlayerCoords(i, j);
                }
            }
        }
    }

    public boolean checkGameOver() {
        return gameOver;
    }

    public void updatePlayer(Point move) {
        Random rand = new Random();
        if (myPlayer != null) {
            if (move.getX() != 5) {
                findPlayer();
                myPlayer.setMove((int) move.getX(), (int) move.getY());
                board[(int) myPlayer.getPlayerCoords().getX()][(int) myPlayer.getPlayerCoords().getY()].removePlayer();
                myPlayer.updateLoc();
                board[(int) myPlayer.getPlayerCoords().getX()][(int) myPlayer.getPlayerCoords().getY()].setPlayer(myPlayer);
                if (board[(int) myPlayer.getPlayerCoords().getX()][(int) myPlayer.getPlayerCoords().getY()].checkFence() || board[(int) myPlayer.getPlayerCoords().getX()][(int) myPlayer.getPlayerCoords().getY()].checkMho()) {
                    myPlayer = null;
                    gameOver = true;
                }
            } else {
                findPlayer();
                board[(int) myPlayer.getPlayerCoords().getX()][(int) myPlayer.getPlayerCoords().getY()].removePlayer();
                myPlayer.updateLoc();
                board[rand.nextInt(12)][rand.nextInt(12)].setPlayer(myPlayer);
                findPlayer();
                if (board[(int) myPlayer.getPlayerCoords().getX()][(int) myPlayer.getPlayerCoords().getY()].checkFence() || board[(int) myPlayer.getPlayerCoords().getX()][(int) myPlayer.getPlayerCoords().getY()].checkMho()) {
                    myPlayer = null;
                    gameOver = true;
                }
            }
        }
    }

    public void updateMhos() {
        if (gameOver == false) {
            Cell[][] newBoard = new Cell[12][12];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    newBoard[i][j] = new Cell();
                    if (board[i][j].checkFence()) {
                        newBoard[i][j].setFence(new Fence());
                    }
                    if (board[i][j].checkMho()) {
                        newBoard[i][j].setMho(new Mho(new Point(i, j)));
                    }
                    if (board[i][j].checkPlayer()) {
                        newBoard[i][j].setPlayer(new Player(i, j));
                    }

                }
            }
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    if (board[i][j].checkMho()) {
                        Point mhoPos = board[i][j].returnMho().getNewMhoPos(myPlayer.getPlayerCoords(), new Point(i, j));
                        if (!board[(int) mhoPos.getX()][(int) mhoPos.getY()].checkMho()) {
                            if (!board[(int) mhoPos.getX()][(int) mhoPos.getY()].checkFence()) {
                                //board[(int) mhoPos.getX()][(int) mhoPos.getY()].setMho(board[i][j].returnMho());
                                newBoard[(int) mhoPos.getX()][(int) mhoPos.getY()].setMho(newBoard[i][j].returnMho());
                            }
                            newBoard[i][j].removeMho();

                        }
                    }
                }
            }
            board = newBoard;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    if (board[i][j].checkPlayer() && board[i][j].checkMho()) {
                        myPlayer = null;
                        gameOver = true;
                    }
                }
            }
        }
    }

}
