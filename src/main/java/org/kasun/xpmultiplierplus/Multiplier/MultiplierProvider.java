package org.kasun.xpmultiplierplus.Multiplier;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MultiplierProvider {
    private HashMap<UUID, List<Multiplier>> multipliers;

    public MultiplierProvider(HashMap<UUID, List<Multiplier>> multipliers) {
        this.multipliers = multipliers;
    }


    public List<Multiplier> getPlayersMultipliers(UUID uuid) {
        return multipliers.get(uuid);
    }

    public Multiplier getPlayersBestMultiplier(UUID uuid) {
        List<Multiplier> playersMultipliers = multipliers.get(uuid);
        Multiplier bestMultiplier = new Multiplier(0.0, "");

        for (Multiplier m : playersMultipliers) {
            if (m.getMultiplier() > bestMultiplier.getMultiplier()) {
                bestMultiplier = m;
            }
        }

        return bestMultiplier;
    }

}
