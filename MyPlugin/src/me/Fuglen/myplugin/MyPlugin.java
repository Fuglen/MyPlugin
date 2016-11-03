package me.Fuglen.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.Fuglen.myplugin.commands.MyPluginFireCommand;
import me.Fuglen.myplugin.commands.MyPluginFlyCommand;
import me.Fuglen.myplugin.commands.MyPluginWeatherCommand;
import me.Fuglen.myplugin.event.MyPluginPlayerJoin;

public class MyPlugin extends JavaPlugin {
	
	//Skriver en besked til console når dette plugin bliver aktiveret.
	@Override
	public void onEnable() {
		Bukkit.getServer().getLogger().info("Myplugin has been enabled, made by Fuglen!");
		
		registerEvents();
		registerCommands();
		registerConfigs();

	}

    //Skriver en besked til console når dette plugin bliver deaktiveret.
	@Override
	public void onDisable() {
		Bukkit.getServer().getLogger().info("MyPlugin has been disabled, made by Fuglen!");		
	}
	
	private void registerConfigs() {
	    getConfig().options().copyDefaults(true);
	    saveConfig();
	}
	
	public void registerEvents() {
	    PluginManager pm = getServer().getPluginManager();
	    pm.registerEvents(new MyPluginPlayerJoin(this), this); 
	}
	
	public void registerCommands() {
	    getCommand("fly").setExecutor(new MyPluginFlyCommand(this));
	    getCommand("fire").setExecutor(new MyPluginFireCommand(this));
	    getCommand("time").setExecutor(new MyPluginWeatherCommand(this));
	    getCommand("vejr").setExecutor(new MyPluginWeatherCommand(this));
	}
}