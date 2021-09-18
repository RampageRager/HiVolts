package com.company.HiVolts;

public class Mho {
        private int mhoCount;
        private int validMoves;
        private int mhoLocation;
        private int moveResult;
        public Mho(int Mhocount, int validMoves, int mhoLocation, int moveResult){
            this.mhoCount = mhoCount;
            this.validMoves = validMoves;
            this.mhoLocation = mhoLocation;
            this.moveResult = moveResult;
    }
    public int getMhoCount(){
            return this.mhoCount;
    }
    public int getValidMoves(){
            return this.validMoves
    }
    public int setMhoLocation(int mhoLocation) {
        this.setMhoLocation(); = mhoLocation[0][0];
    }
    public int getMoveResult(){
            return this.moveResult;
    }
}
