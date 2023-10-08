package org.kasun.xpmultiplierplus.Multiplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MultiplierManager {
    HashMap<UUID, List<Multiplier>> multipliers;
    ArrayList<GlobalMultiplier> globalMultipliers;


    public MultiplierManager() {
        multipliers = new HashMap<>();
        globalMultipliers = new ArrayList<>();
    }

    public ArrayList<GlobalMultiplier> getGlobalMultipliers() {
        return globalMultipliers;
    }

    public void setGlobalMultipliers(ArrayList<GlobalMultiplier> globalMultipliers) {
        this.globalMultipliers = globalMultipliers;
    }

    public HashMap<UUID, List<Multiplier>> getMultipliers() {

        return multipliers;
    }

    public void setMultipliers(HashMap<UUID, List<Multiplier>> multipliers) {

        this.multipliers = multipliers;
    }

}
