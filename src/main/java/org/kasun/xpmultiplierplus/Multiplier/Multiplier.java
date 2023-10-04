package org.kasun.xpmultiplierplus.Multiplier;



public class Multiplier {
    private double multiplier = 1.0;
    private String permission = "";


    public Multiplier(double multiplier, String permission) {
        this.multiplier = multiplier;
        this.permission = permission;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
