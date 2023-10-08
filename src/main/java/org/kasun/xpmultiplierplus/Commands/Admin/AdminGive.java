package org.kasun.xpmultiplierplus.Commands.Admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.kasun.xpmultiplierplus.Config.MainConfig;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
import org.kasun.xpmultiplierplus.Multiplier.PlayersMultipliersManager;
import org.kasun.xpmultiplierplus.Multiplier.TempMultiplier;
import org.kasun.xpmultiplierplus.Utils.ColorUtils;
import org.kasun.xpmultiplierplus.Utils.TimeStringToSecondsConverter;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class AdminGive {
    private CommandSender sender;
    private Command command;
    private String label;
    private String[] args;
    private XpMultiplierPlus plugin;
    private List<Multiplier> multipliers;
    private HashMap<UUID, List<Multiplier>> multiplierMap;

    public AdminGive(CommandSender sender, Command command, String label, String[] args) {
        plugin = XpMultiplierPlus.getInstance();
        MainConfig mainConfig = plugin.getMainManager().getConfigManager().getMainConfig();
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;
        multipliers = plugin.getMainManager().getConfigManager().getMainConfig().multipliers;
        multiplierMap = plugin.getMainManager().getMultiplierManager().getMultipliers();

        //xpm admin set <player> <multiplier> <duration>

        if (args.length <= 3) {
            sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-usage")));
            return;
        }

        if (args.length >= 4) {
            if (plugin.getServer().getPlayer(args[2]) == null) {
                sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("player-not-found")));
                return;
            }

            if (args[3].equalsIgnoreCase("0")) {
                sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-usage")));
                return;
            }

            PlayersMultipliersManager playersMultipliersManager = new PlayersMultipliersManager(plugin.getServer().getPlayer(args[2]).getUniqueId());

            if (!playersMultipliersManager.isMultiplierExist(Double.parseDouble(args[3]))){
                sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-multiplier-not-found")));
                return;
            }

            Multiplier multiplier = playersMultipliersManager.getMultiplierFromDouble(Double.parseDouble(args[3]));

            if (args.length == 4){
                playersMultipliersManager.addPermenentMuliplierToPlayer(multiplier);
                sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-success").replace("%player%", args[2]).replace("%multiplier%", args[3])));
            }

            if (args.length == 5){

                if (args[4].equalsIgnoreCase("0")){
                    sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-usage")));
                    return;
                }

                if (args[4].equalsIgnoreCase("PERMANENT") || args.length == 4){
                    playersMultipliersManager.addPermenentMuliplierToPlayer(multiplier);
                }else{
                    Long timeSecounds = TimeStringToSecondsConverter.convertToSeconds(args[4]);
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    playersMultipliersManager.addTempMultiplierToPlayer(multiplier, timeSecounds, timestamp);
                    sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-success-temp").replace("%player%", args[2]).replace("%multiplier%", args[3]).replace("%time%", args[4])));
                }
            }
        }
    }
}
