package me.thiboisweird.testingplugin.commands;

import me.thiboisweird.testingplugin.TestingPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class Warps implements CommandExecutor {
    Plugin plugin = TestingPlugin.getPlugin(TestingPlugin.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args[0].equalsIgnoreCase("")){
                player.sendMessage("You must specify a warp!");
            } else if (args[0].equalsIgnoreCase("starter")){
                Location loc = player.getLocation();
                loc.setX(-1);
                loc.setY(65);
                loc.setZ(2);
                loc.setWorld(plugin.getServer().getWorld("spawn"));
                loc.setYaw(40);
                loc.setPitch(2);
                World w = loc.getWorld();
                assert w != null;
                ArmorStand as = (ArmorStand) w.spawnEntity(loc, EntityType.ARMOR_STAND);
                as.setInvisible(false);
                Location location2 = loc;
                location2.setX(-23);
                location2.setZ(30);
                Location difference = loc.subtract(location2);
                Vector normalizedDifference = difference.toVector().normalize();
                Vector multiplied = normalizedDifference.multiply(1);
                player.setPassenger(as);
                as.setVelocity(multiplied);
                Bukkit.getScheduler().runTaskLater(plugin, () -> as.setHealth(0), 200L);
            }
        }
        return true;
    }
}
