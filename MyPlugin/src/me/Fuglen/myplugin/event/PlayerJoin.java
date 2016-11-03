package me.Fuglen.myplugin.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Fuglen.myplugin.MyPlugin;

public class PlayerJoin implements Listener {
    
    private MyPlugin plugin;
    
    public PlayerJoin(MyPlugin pl) {
        plugin = pl;
    }
    
    // Når en spiller joiner serveren, køres dette stykke kode.
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        
        String WelcomeMessage;
        String Player = player.getName();
        
        WelcomeMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Welcome Message"));       
        
        WelcomeMessage = WelcomeMessage.replace("%player%", Player);
        
        player.sendMessage(WelcomeMessage);
    }
}