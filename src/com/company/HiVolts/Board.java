package com.company.HiVolts;

public class Board {
    private Cell[][] board = new Cell[12][12];

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

}
