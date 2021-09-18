package com.company.HiVolts;

public class Board {
    private int[] myArr = new int[5];
    private Cell[][] board = new Cell[12][12];

    public boolean hasPlayer (int i, int j) {
        return board[i][j].hasPlayer();
    }

    public fence getFence(int i, int j) {
        return board[i][j].getFence();
    }

    public m

    public Player getPlayer(int i, int j) {
        return board[i][j].getPlayer();
    }

    public void setElement (int index) {
        myArr[index] = 3;
    }

    public void printArr() {
        for (int i = 0; i < myArr.length; i++) {
            System.out.println(myArr[i]);
        }
    }
}
