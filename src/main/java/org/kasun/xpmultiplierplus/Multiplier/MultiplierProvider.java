package org.kasun.xpmultiplierplus.Multiplier;

import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MultiplierProvider {
    private HashMap<UUID, List<Multiplier>> multipliers;
    private MultiplierManager multiplierManager;
    private XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();

    public MultiplierProvider(HashMap<UUID, List<Multiplier>> multipliers) {
        this.multipliers = multipliers;
    }
    public List<Multiplier> getPlayersMultipliers(UUID uuid) {
        return multipliers.get(uuid);
    }
    public Multiplier getPlayersBestMultiplier(UUID uuid) {

        multiplierManager = plugin.getMainManager().getMultiplierManager();

        //best best global multiplier
        ArrayList<GlobalMultiplier> globalMultipliers = multiplierManager.getGlobalMultipliers();
        GlobalMultiplier bestGlobalMultiplier = globalMultipliers.get(0);
        for (GlobalMultiplier globalMultiplier : globalMultipliers) {
            if (bestGlobalMultiplier.getMultiplier() < globalMultiplier.getMultiplier()) {
                bestGlobalMultiplier = globalMultiplier;
            }
        }



        List<Multiplier> playersMultipliers = multipliers.get(uuid);
        Multiplier bestMultiplier = new Multiplier(bestGlobalMultiplier.getMultiplier(), "");

        if (playersMultipliers == null || playersMultipliers.isEmpty()) {
            return new Multiplier(bestMultiplier.getMultiplier(), "");
        }

        for (Multiplier m : playersMultipliers) {
            if (m.getMultiplier() > bestMultiplier.getMultiplier()) {
                bestMultiplier = m;
            }
        }

        if (bestMultiplier.getMultiplier() > bestGlobalMultiplier.getMultiplier()) {
            return bestMultiplier;
        }else{
            return new Multiplier(bestGlobalMultiplier.getMultiplier(), "");
        }

    }

}
