package me.thiboisweird.testingplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Vault implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            Inventory vault = Bukkit.createInventory(player, 27, ChatColor.GREEN + "Viewing your vault!");
            ItemStack item1 = new ItemStack(Material.CLAY_BALL, 10);

            item1.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 100);
            ItemMeta meta = item1.getItemMeta();
            assert meta != null;
            meta.setDisplayName(ChatColor.AQUA+"ItemName");
            meta.setUnbreakable(true);
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Some lore");
            lore.add(ChatColor.GOLD + "Some lore");
            lore.add(ChatColor.GOLD + "Some lore");
            meta.setLore(lore);

            item1.setItemMeta(meta);

            vault.addItem(item1);

            player.openInventory(vault);

        }else{
            System.out.println("You must be a player to execute this!");
        }


        return true;
    }
}
