package org.kasun.xpmultiplierplus.Multiplier;

import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MultiplierProvider {
    private HashMap<UUID, List<Multiplier>> multipliers;
    private MultiplierManager multiplierManager;
    private double defaultMultiplier;
    private XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();

    public MultiplierProvider(HashMap<UUID, List<Multiplier>> multipliers) {
        this.multipliers = multipliers;
    }
    public List<Multiplier> getPlayersMultipliers(UUID uuid) {
        return multipliers.get(uuid);
    }
    public Multiplier getPlayersBestMultiplier(UUID uuid) {

        multiplierManager = plugin.getMainManager().getMultiplierManager();
        defaultMultiplier = multiplierManager.getDefaultMultiplier();

        System.out.printf(String.valueOf(defaultMultiplier));

        List<Multiplier> playersMultipliers = multipliers.get(uuid);
        Multiplier bestMultiplier = new Multiplier(defaultMultiplier, "");

        if (playersMultipliers == null || playersMultipliers.isEmpty()) {
            return new Multiplier(defaultMultiplier, "");
        }

        for (Multiplier m : playersMultipliers) {
            if (m.getMultiplier() > bestMultiplier.getMultiplier()) {
                bestMultiplier = m;
            }
        }

        if (bestMultiplier.getMultiplier() > defaultMultiplier) {
            return bestMultiplier;
        }else{
            return new Multiplier(defaultMultiplier, "");
        }

    }

}
