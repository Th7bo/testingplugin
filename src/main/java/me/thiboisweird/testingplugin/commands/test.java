package me.thiboisweird.testingplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class test implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can run this command!");
            return true;
        }
        Player player = (Player) sender;
        if (args.length < 1) {
            player.setHealth(0);
            player.sendMessage("You've killed yourself!");
        } else {
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target != null) {
                target.sendMessage("You got killed LLL");
                target.setHealth(0);
            } else {
                player.sendMessage(ChatColor.RED + "Could not find a player by that name of '" + args[0] + "'!");
            }
        }
        return true;
    }
}
