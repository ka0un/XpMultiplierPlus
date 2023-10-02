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



}
