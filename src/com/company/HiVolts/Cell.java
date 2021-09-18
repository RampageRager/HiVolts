package com.company.HiVolts;

public class Cell {
    private Mho myMho;
    private Player myPlayer;
    private Fence myFence;
    private boolean hasMho = false;
    private boolean hasPlayer = false;
    private boolean hasFence = false;

    public void setMho(Mho newMho) {
        myMho = newMho;
        hasMho = true;
    }

    public void removeMho() {
        myMho = null;
        hasMho = false;
    }

    public boolean checkMho() {
        return hasMho;
    }

    public Mho returnMho() {
        return myMho;
    }

    public void setPlayer(Player newPlayer) {
        myPlayer = newPlayer;
        hasPlayer = true;
    }

    public void removePlayer() {
        myMho = null;
        hasMho = false;
    }

    public boolean checkPlayer() {
        return hasPlayer;
    }

    public Player returnPlayer() {
        return myPlayer;
    }

    public void setFence(Fence newFence) {
        myFence = newFence;
        hasFence = true;
    }

    public void removeFence() {
        myFence = null;
        hasFence = false;
    }

    public boolean checkFence() {
        return hasFence;
    }

    public Fence returnFence() {
        return myFence;
    }


}
