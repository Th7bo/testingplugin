package me.thiboisweird.testingplugin.commands;

import me.thiboisweird.testingplugin.TestingPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Objects;

public class Fly implements CommandExecutor {
    private ArrayList<Player> list_of_flying_players = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("testingplugin.fly")){
                Player target = player;
                if (args.length > 0){
                    target = Bukkit.getPlayerExact(args[0]);
                    if (target == null){
                        target = player;
                    }
                }
                try {
                    flyMethod(player, target);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    private void flyMethod(Player player, Player target) throws InterruptedException {
        Plugin plugin = TestingPlugin.getPlugin(TestingPlugin.class);
        if(player.hasPermission("testingplugin.fly")){
            if(list_of_flying_players.contains(target)){
                list_of_flying_players.remove(target);
                target.setAllowFlight(false);
                if (target == player){
                    String message = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("fly-message-off-self")));
                    String p = target.getDisplayName();
                    String msg = message.replace("{P}", p);
                    player.sendMessage(msg);
                }else{
                    String message = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("fly-message-off-other")));
                    String p = target.getDisplayName();
                    String msg = message.replace("{P}", p);
                    player.sendMessage(msg);
                }
            }else{
                list_of_flying_players.add(target);
                target.setAllowFlight(true);
                if (target == player){
                    String message = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("fly-message-on-self")));
                    String p = target.getDisplayName();
                    String msg = message.replace("{P}", p);
                    player.sendMessage(msg);
                }else{
                    String message = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("fly-message-on-other")));
                    String p = target.getDisplayName();
                    String msg = message.replace("{P}", p);
                    player.sendMessage(msg);
                }

            }
        }
    }
}
