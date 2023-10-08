package org.kasun.xpmultiplierplus.Multiplier;

import java.sql.Timestamp;

public class TempMultiplier extends Multiplier{

    private long timeSecounds;
    private Timestamp startTime;
    public TempMultiplier(double multiplier, String permission, Timestamp startTime, long timeSecounds) {
        super(multiplier, permission);
        this.startTime = startTime;
        this.timeSecounds = timeSecounds;
    }

    public long getTimeSecounds() {
        return timeSecounds;
    }

    public void setTimeSecounds(long timeSecounds) {
        this.timeSecounds = timeSecounds;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
}
