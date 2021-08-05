package me.thiboisweird.testingplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class God implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(!player.hasPermission("testingplugin.godmode")){
                player.sendMessage(ChatColor.RED + "You're missing the required permission for this command! " + ChatColor.RED + "" + ChatColor.ITALIC + "(testingplugin.godmode)");
                return false;
            }
            if(player.isInvulnerable()) {
                player.setInvulnerable(false);
                player.sendMessage(ChatColor.RED + "You're now vulnerable!");
            }else{
                player.setInvulnerable(true);
                player.sendMessage(ChatColor.GREEN + "You're now invulnerable!");
            }
        }


        return true;
    }
}
