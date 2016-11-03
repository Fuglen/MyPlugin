package me.Fuglen.myplugin.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Fuglen.myplugin.MyPlugin;
import net.md_5.bungee.api.ChatColor;

public class WeatherCommand implements CommandExecutor {
    
    public WeatherCommand(MyPlugin myPlugin) {
    }

    // This is a comment.
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Du skal være en spiller!");
        }
            Player p = (Player) sender;
        
            if (cmd.getName().equalsIgnoreCase("time")) {
                if(args.length == 0) {
                    p.sendMessage(ChatColor.YELLOW + "/time day");
                    p.sendMessage(ChatColor.YELLOW + "/time night");
                    return true;
                }
                
                if (args[0].equalsIgnoreCase("day")
                        && sender.hasPermission("myplugin.time.*")
                        || sender.hasPermission("myplugin.time.day")
                        || sender.hasPermission("myplugin.*")) {
                    p.setPlayerTime(1000, true);
                    p.sendMessage(ChatColor.GREEN + "Du ændrede tiden til dag!");
                    return true;
                }
                
                if (args[0].equalsIgnoreCase("night")
                        && sender.hasPermission("myplugin.time.*")
                        || sender.hasPermission("myplugin.time.night")
                        || sender.hasPermission("myplugin.*")) {
                    p.setPlayerTime(15000, true);
                    p.sendMessage(ChatColor.GREEN + "Du ændrede tiden til nat!");
                    return true;
                }
                return true;        
            }
            
            if (cmd.getName().equalsIgnoreCase("vejr")) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.YELLOW + "/vejr sun");
                    p.sendMessage(ChatColor.YELLOW + "/vejr rain");
                    p.sendMessage(ChatColor.YELLOW + "/vejr thunder");
                    p.sendMessage(ChatColor.YELLOW + "/vejr clear");
                    return true;
                }
                
                else if (args[0].equalsIgnoreCase("sun")
                        && sender.hasPermission("myplugin.weather.*")
                        || sender.hasPermission("myplugin.weather.sun")
                        || sender.hasPermission("myplugin.*")) {
                    p.getWorld().setStorm(false);
                    p.getWorld().setThundering(false);
                    p.sendMessage(ChatColor.GREEN + "Du ændrede vejret til solskin!");
                    return true;
                }
                
                else if (args[0].equalsIgnoreCase("rain")
                        && sender.hasPermission("myplugin.weather.*")
                        || sender.hasPermission("myplugin.weather.rain")
                        || sender.hasPermission("myplugin.*")) {
                    p.getWorld().setStorm(true);
                    p.getWorld().setThundering(false);
                    p.sendMessage(ChatColor.GREEN + "Du ændrede vejret til regnvejr!!");
                    return true;
                }
                
                else if (args[0].equalsIgnoreCase("thunder")
                        && sender.hasPermission("myplugin.weather.*")
                        || sender.hasPermission("myplugin.weaher.thunder")
                        || sender.hasPermission("myplugin.*")) {
                    p.getWorld().setStorm(true);
                    p.getWorld().setThundering(true);
                    p.sendMessage(ChatColor.GREEN + "Du ændrede vejret til tordenvejr!");
                    return true;
                }               
                
                else if (args[0].equalsIgnoreCase("clear")
                        && sender.hasPermission("myplugin.weather.*")
                        || sender.hasPermission("myplugin.weather.clear")
                        || sender.hasPermission("myplugin.*")) {
                    p.getWorld().setStorm(false);
                    p.getWorld().setThundering(false);
                    p.setPlayerTime(1000, true);
                    p.sendMessage(ChatColor.GREEN + "Du ændrede det til klart vejr!");
                    return true;
                }
                
                    return true;
                }
        
        return true;
    }

}
