package org.kasun.xpmultiplierplus.Commands.Admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
import org.kasun.xpmultiplierplus.Multiplier.MultiplierProvider;
import org.kasun.xpmultiplierplus.Multiplier.TempMultiplier;
import org.kasun.xpmultiplierplus.Utils.ColorUtils;
import org.kasun.xpmultiplierplus.Utils.TimeStringToSecondsConverter;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class AdminView {
    CommandSender sender;
    Command command;
    String label;
    String[] args;
    private HashMap<UUID, List<Multiplier>> multiplierMap;
    XpMultiplierPlus plugin;


    public AdminView(CommandSender sender, Command command, String label, String[] args) {
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;
        plugin = XpMultiplierPlus.getInstance();
        multiplierMap = plugin.getMainManager().getMultiplierManager().getMultipliers();

        if (args.length == 3){
            Player player = plugin.getServer().getPlayer(args[2]);
            if (player == null){
                sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("player-not-found")));
                return;
            }

            MultiplierProvider multiplierProvider = new MultiplierProvider(multiplierMap);
            sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("admin-view-1")).replace("%player%", player.getName()));
            sender.sendMessage(" ");
            sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("admin-view-active")).replace("%multiplier%", multiplierProvider.getPlayersBestMultiplier(player.getUniqueId()).getMultiplier() + ""));
            sender.sendMessage(" ");

            if (multiplierMap.containsKey(player.getUniqueId())){
                for (Multiplier m : multiplierMap.get(player.getUniqueId())){

                    if (m instanceof TempMultiplier){
                        long timeleft = ((TempMultiplier) m).getTimeSecounds() - ((System.currentTimeMillis() - ((TempMultiplier) m).getStartTime().getTime()) / 1000);
                        String timeleftString = TimeStringToSecondsConverter.convertToTimeString(timeleft);
                        sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("admin-view-2")
                                .replace("%multiplier%", String.valueOf(m.getMultiplier()))
                                .replace("%duration%", timeleftString)));
                    }else{
                        sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("admin-view-2")
                                .replace("%multiplier%", String.valueOf(m.getMultiplier()))
                                .replace("%duration%", "Permenent")));
                    }

                }
                return;
            }else{
                sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("admin-view-no-multipliers")).replace("%player%", player.getName()));
                return;
            }

        }


    }
}
