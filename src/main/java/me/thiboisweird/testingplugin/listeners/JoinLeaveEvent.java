package me.thiboisweird.testingplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static org.bukkit.Bukkit.getServer;

public class JoinLeaveEvent implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){

        Player player = e.getPlayer();

        e.setQuitMessage(ChatColor.GRAY+ "(" + ChatColor.RED + "-" + ChatColor.GRAY + ") " + ChatColor.GRAY + player.getDisplayName());

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();
        if (player.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.GRAY+ "(" + ChatColor.GREEN + "+" + ChatColor.GRAY + ") " + ChatColor.GRAY + player.getDisplayName());
        } else {
            e.setJoinMessage(ChatColor.GRAY+ "(" + ChatColor.DARK_GREEN + "+" + ChatColor.GRAY + ") " + ChatColor.GRAY + player.getDisplayName());
        }

    }

}
