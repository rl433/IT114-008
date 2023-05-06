package Project.common;

import java.util.function.BooleanSupplier;

public class Player {

    private boolean isReady = false;
    private boolean isSkipped = false;
    private boolean isOut = false;
    private boolean isSpectator = false;
    private boolean isAway = false;
    private String Hold;

    public void setReady(boolean isReady) {
        this.isReady = isReady;
    }

    public boolean isReady() {
        return this.isReady;
    }

    public void setAway(boolean isAway) {
        this.isAway = isAway;
    }

    public boolean isAway() {
        return isAway;
    }
    
    public void setSpectator(boolean isSpectator) {
        this.isSpectator = isSpectator;
    }

    public boolean isSpectator() {
        return isSpectator;
    }
    
    public boolean isNotOut() {
        return !isOut;
    }

    public void setOut(boolean isOut) {
        this.isOut = isOut;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setSkipped(boolean isSkipped) {
        this.isSkipped = isSkipped;
    }

    public boolean isSkipped() {
        return this.isSkipped;
    }

    public String getHold() {
        return Hold;
    }

    public void setHold(String hold) {
        Hold = hold;
    }

    public void setChoice(String hold) {
        Hold = hold;
    }

    public String getChoice() {
        return this.Hold;
    }
    
    private int points = 0;

    public void setPoints(int points) {
        this.points = points;
    }

    public void changePoints(int points) {
        this.points += points;
        if (this.points < 0) {
            this.points = 0;
        }
    }

    public int getPoints() {
        return points;
    }

}