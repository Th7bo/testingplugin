package me.thiboisweird.testingplugin;

import me.thiboisweird.testingplugin.commands.*;
import me.thiboisweird.testingplugin.events.PlayerMove;
import me.thiboisweird.testingplugin.listeners.JoinLeaveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class TestingPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("Testing Plugin has been enabled!");

        getServer().getPluginManager().registerEvents(new JoinLeaveEvent(), this);
        //getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        Objects.requireNonNull(getCommand("god")).setExecutor(new God());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new Feed());
        Objects.requireNonNull(getCommand("test")).setExecutor(new test());
        Objects.requireNonNull(getCommand("vault")).setExecutor(new Vault());
        Objects.requireNonNull(getCommand("fly")).setExecutor(new Fly());

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        String version = getConfig().getString("config-version");
        System.out.println(version);
        assert version != null;
        if (!version.equalsIgnoreCase("1.0")){
            System.out.println("[FATAL ERROR] You do not have the latest version of the config, please back up your config.yml and delete it after!");
            getServer().getPluginManager().disablePlugin(this);
        }
    }

}
