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
        }
    }
}
