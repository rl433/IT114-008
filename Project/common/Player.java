package Project.common;

public class Player {

    private boolean isReady = false;
    private boolean isSkipped = false;
    private boolean isOut = true;
    private boolean setIsOut = false;

    public boolean isSetIsOut() {
        return setIsOut;
    }

    public void setSetIsOut(boolean setIsOut) {
        this.setIsOut = setIsOut;
    }

    private String Hold;

    public void setReady(boolean isReady) {
        this.isReady = isReady;
    }

    public boolean isReady() {
        return this.isReady;
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
}