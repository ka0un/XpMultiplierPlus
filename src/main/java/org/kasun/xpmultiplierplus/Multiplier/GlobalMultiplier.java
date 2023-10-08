package org.kasun.xpmultiplierplus.Multiplier;

import java.sql.Timestamp;

public class GlobalMultiplier {
    private double multiplier;
    private boolean isTemp;
    private long durationSecounds;
    private Timestamp startTimeStamp;

    public GlobalMultiplier(double multiplier, boolean isTemp, long durationSecounds, Timestamp startTimeStamp) {
        this.isTemp = isTemp;
        this.multiplier = multiplier;
        this.durationSecounds = durationSecounds;
        this.startTimeStamp = startTimeStamp;
    }

    //getters and setters

    public boolean isTemp() {
        return isTemp;
    }

    public void setTemp(boolean temp) {
        isTemp = temp;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public long getDurationSecounds() {
        return durationSecounds;
    }

    public void setDurationSecounds(long durationSecounds) {
        this.durationSecounds = durationSecounds;
    }

    public Timestamp getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(Timestamp startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }
}
