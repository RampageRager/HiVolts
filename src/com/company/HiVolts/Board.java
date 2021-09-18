package com.company.HiVolts;

import java.awt.*;

public class Board {
    private Cell[][] board = new Cell[12][12];
    private Player myPlayer;
    private Point move;

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
