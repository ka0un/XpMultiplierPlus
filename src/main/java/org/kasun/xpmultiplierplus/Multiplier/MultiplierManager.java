package org.kasun.xpmultiplierplus.Multiplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class MultiplierManager {
    HashMap<UUID, Multiplier> multipliers;
    private double defaultMultiplier = 1.0;

    public MultiplierManager() {
        multipliers = new HashMap<>();
    }

    public HashMap<UUID, Multiplier> getMultipliers() {
        return multipliers;
    }

    public void setMultipliers(HashMap<UUID, Multiplier> multipliers) {
        this.multipliers = multipliers;
    }

    public double getDefaultMultiplier() {
        return defaultMultiplier;
    }

    public void setDefaultMultiplier(double defaultMultiplier) {
        this.defaultMultiplier = defaultMultiplier;
    }
}
