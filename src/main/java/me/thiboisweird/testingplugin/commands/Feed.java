package me.thiboisweird.testingplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            player.setFoodLevel(20);
            player.sendMessage("You've been fed!");

        }else{
            System.out.println("You must be a player!");
        }



        return true;
    }
}
