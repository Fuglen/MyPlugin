package me.Fuglen.myplugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MyPlugin extends JavaPlugin {
	
	//Skriver en besked til console når dette plugin bliver aktiveret.
	@Override
	public void onEnable() {
		Bukkit.getServer().getLogger().info("Fly has been enabled, made by Fuglen!");
		this.getCommand("fly").setExecutor(new MyPluginFlyCommand(this));
		this.getCommand("fire").setExecutor(new MyPluginFireCommand(this));
		this.getCommand("time").setExecutor(new MyPluginWeatherCommand(this));
		this.getCommand("vejr").setExecutor(new MyPluginWeatherCommand(this));
	}
	
	//Skriver en besked til console når dette plugin bliver deaktiveret.
	@Override
	public void onDisable() {
		Bukkit.getServer().getLogger().info("Fly has been disabled, made by Fuglen!");		
	}
}