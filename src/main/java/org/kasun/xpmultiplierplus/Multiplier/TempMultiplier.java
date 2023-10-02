package org.kasun.xpmultiplierplus.Multiplier;

import java.sql.Timestamp;

public class TempMultiplier extends Multiplier{

    private int timeSecounds;
    private Timestamp startTime;
    public TempMultiplier(double multiplier, String permission, Timestamp startTime, int timeSecounds) {
        super(multiplier, permission);
        this.startTime = startTime;
        this.timeSecounds = timeSecounds;
    }

    public int getTimeSecounds() {
        return timeSecounds;
    }

    public void setTimeSecounds(int timeSecounds) {
        this.timeSecounds = timeSecounds;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
}
