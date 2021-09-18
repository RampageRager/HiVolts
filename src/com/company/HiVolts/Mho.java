package com.company.HiVolts;

public class Mho {
    private int validMoves;
    private int moveResult;
    public Mho(int validMoves, int moveResult){
        this.validMoves = validMoves;
        this.moveResult = moveResult;
    }
    public int getValidMoves(){
            return this.validMoves;
    }
    public int getMoveResult(){
        return this.moveResult;
    }
}
