package org.kasun.xpmultiplierplus.Multiplier;

import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PlayersMultipliersManager {
    private UUID PlayerUUID;
    private XpMultiplierPlus plugin;
    private List<Multiplier> allAvailableMultipliersList;
    private HashMap<UUID, List<Multiplier>> MainMultiplierMap;
    public PlayersMultipliersManager(UUID PlayerUUID) {
        this.PlayerUUID = PlayerUUID;
        this.plugin = XpMultiplierPlus.getInstance();
        this.allAvailableMultipliersList = plugin.getMainManager().getConfigManager().getMainConfig().multipliers;
        this.MainMultiplierMap = plugin.getMainManager().getMultiplierManager().getMultipliers();
    }

    public void addPermenentMuliplierToPlayer(Multiplier multiplier){

        if (MainMultiplierMap.containsKey(PlayerUUID)){
            List<Multiplier> playerMultipliersList = MainMultiplierMap.get(PlayerUUID);
            playerMultipliersList.add(multiplier);
            MainMultiplierMap.put(PlayerUUID, playerMultipliersList);
        }else {
            List<Multiplier> playerMultipliersList = MainMultiplierMap.get(PlayerUUID);
            if (playerMultipliersList == null){
                playerMultipliersList = new ArrayList<>();
            }
            playerMultipliersList.add(multiplier);
            MainMultiplierMap.put(PlayerUUID, playerMultipliersList);
        }
    }

    public void removePermenentMuliplierFromPlayer(Multiplier multiplier){
        if (MainMultiplierMap.containsKey(PlayerUUID)){
            List<Multiplier> playerMultipliersList = MainMultiplierMap.get(PlayerUUID);
            playerMultipliersList.remove(multiplier);
            MainMultiplierMap.put(PlayerUUID, playerMultipliersList);
        }
    }

    public void clearPlayersAllMultipliers(){
        if (MainMultiplierMap.containsKey(PlayerUUID)){
            MainMultiplierMap.remove(PlayerUUID);
        }
    }

    public void addTempMultiplierToPlayer(Multiplier multiplier, long durationSecounds, Timestamp currentTimeStamp){

        if (AddDurationIfTempMultiplierAlredyExisits(multiplier, durationSecounds, currentTimeStamp)){
            return;
        }

        TempMultiplier tMultiplier = new TempMultiplier(multiplier.getMultiplier(), "", currentTimeStamp, durationSecounds);
        addPermenentMuliplierToPlayer(tMultiplier);
    }

    public boolean isMultiplierExist(double multiplier){
        for (Multiplier m : allAvailableMultipliersList){
            if (m.getMultiplier() == multiplier){
                return true;
            }
        }
        return false;
    }

    public Multiplier getMultiplierFromDouble(double multiplier){
        for (Multiplier m : allAvailableMultipliersList){
            if (m.getMultiplier() == multiplier){
                return m;
            }
        }
        return null;
    }


    private boolean AddDurationIfTempMultiplierAlredyExisits(Multiplier multiplier, long DurationSecounds, Timestamp currentTimeStamp){
        List<Multiplier> playerMultipliersList = MainMultiplierMap.get(PlayerUUID);
        if (playerMultipliersList != null) {
            for (Multiplier m : allAvailableMultipliersList) {
                if (m.getMultiplier() == multiplier.getMultiplier()) {
                    if (m instanceof TempMultiplier) {
                        ((TempMultiplier) m).setTimeSecounds(((TempMultiplier) m).getTimeSecounds() * 2);
                        return true;
                    }
                }
            }
        }
        return false;
    }



}
