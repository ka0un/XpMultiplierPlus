package org.kasun.xpmultiplierplus.Commands.Admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class AdminCommandManager {
    CommandSender sender;
    Command command;
    String label;
    String[] args;
    public AdminCommandManager(CommandSender sender, Command command, String label, String[] args) {
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;

        if (args.length == 1){
            new AdminHelp(sender);
        }else{
            if (args[1].equalsIgnoreCase("help")) {
                new AdminHelp(sender);
            }else if (args[1].equalsIgnoreCase("give")){
                new AdminGive(sender, command, label, args);
            }else if (args[1].equalsIgnoreCase("view")) {
                new AdminView(sender, command, label, args);
            }else if (args[1].equalsIgnoreCase("take")) {
                new AdminTake(sender, command, label, args);
            }else if (args[1].equalsIgnoreCase("global")) {
                 new AdminGlobal(sender, command, label, args);
            }else{
                new AdminHelp(sender);
            }
        }
    }
}
