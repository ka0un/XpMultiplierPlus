package org.kasun.xpmultiplierplus.Multiplier;


import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MultiplierManager {
    HashMap<UUID, List<Multiplier>> multipliers;
    private double defaultMultiplier = 1.0;

    public MultiplierManager() {
        multipliers = new HashMap<>();
    }

    public HashMap<UUID, List<Multiplier>> getMultipliers() {
        return multipliers;
    }

    public void setMultipliers(HashMap<UUID, List<Multiplier>> multipliers) {
        this.multipliers = multipliers;
    }

    public double getDefaultMultiplier() {
        return defaultMultiplier;
    }

    public void setDefaultMultiplier(double defaultMultiplier) {
        this.defaultMultiplier = defaultMultiplier;
    }
}
