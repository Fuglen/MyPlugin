package me.Fuglen.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyPluginFlyCommand implements CommandExecutor {
	
	public MyPluginFlyCommand(MyPlugin myPlugin) {
	}
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Du skal være en spiller!");
			return true;
		}
		
        Player player = (Player) sender;
		
        
        if (cmd.getName().equalsIgnoreCase("fly")) {
        	if (args.length == 0) {
            	player.sendMessage(ChatColor.YELLOW + "Brug /fly on = du kan flyve");
            	player.sendMessage(ChatColor.YELLOW + "Brug /fly off = du kan ikke flyve");
            	return true;
            }
        	
        		//Kommando til /fly on s� man kan sl� det til.
                if (args[0].equalsIgnoreCase("on")) {
                    if (args.length == 1) {
    					player.setAllowFlight(true);
    					player.sendMessage(ChatColor.GREEN + "Du kan nu flyve din vej...");
                    	return true;
                	}
                
                    else if (args.length == 2) {
                    	Player target = Bukkit.getPlayer(args[1]);
        				if (target == null) {
        					sender.sendMessage(ChatColor.RED + "Spilleren er ikke online!");
        					return true;
        				}
                    	target.setAllowFlight(true);
                    	target.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + ", har givet dig tilladelse til at flyve!");
                    	player.sendMessage(ChatColor.YELLOW + target.getName() + ChatColor.GREEN + ", kan nu flyve!");
                    	return true;
                    }
                }
                
                //Kommando til /fly off s� man kan sl� det fra.
                else if (args[0].equalsIgnoreCase("off")) {
                    if (args.length == 1) {
    					player.setAllowFlight(false);
    					player.sendMessage(ChatColor.GREEN + "Du kan ikke længere flyve!");
                    	return true;
                	}
                
                    else if (args.length == 2) {
                    	Player target = Bukkit.getPlayer(args[1]);
        				if (target == null) {
        					sender.sendMessage(ChatColor.RED + "Spilleren er ikke online!");
        					return true;
        				}
                    	target.setAllowFlight(false);
                    	target.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.GREEN + ", har fjernet din tilladelse til at flyve!");
                    	player.sendMessage(ChatColor.YELLOW + target.getName() + ChatColor.GREEN + ", kan ikke længere flyve!");
                    	return true;
                    }
                }
                
                
                
                return true;
        }
        return true;
    }
}