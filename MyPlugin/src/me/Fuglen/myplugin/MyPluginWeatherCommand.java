package me.Fuglen.myplugin;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class MyPluginWeatherCommand implements CommandExecutor {
	
	public MyPluginWeatherCommand(MyPlugin myPlugin) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Du skal være en spiller!");
		}
			Player p = (Player) sender;
		
			if (cmd.getName().equalsIgnoreCase("time")) {
				if(args.length == 0){
					p.sendMessage(ChatColor.YELLOW + "/time day");
					p.sendMessage(ChatColor.YELLOW + "/time night");
					return true;
				}
				
				if (args[0].equalsIgnoreCase("day")) {
					p.setPlayerTime(1000, true);
					p.sendMessage(ChatColor.GREEN + "Du ændrede tiden til dag!");
					return true;
				}
				
				if (args[0].equalsIgnoreCase("night")) {
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
				
				else if (args[0].equalsIgnoreCase("sun")) {
					p.getWorld().setStorm(false);
					p.getWorld().setThundering(false);
					p.sendMessage(ChatColor.GREEN + "Du ændrede vejret til solskin!");
					return true;
				}
				
				else if (args[0].equalsIgnoreCase("rain")) {
					p.getWorld().setStorm(true);
					p.getWorld().setThundering(false);
					p.sendMessage(ChatColor.GREEN + "Du ændrede vejret til regnvejr!!");
					return true;
				}
				
				else if (args[0].equalsIgnoreCase("thunder")) {
					p.getWorld().setStorm(true);
					p.getWorld().setThundering(true);
					p.sendMessage(ChatColor.GREEN + "Du ændrede vejret til tordenvejr!");
					return true;
				}				
				
				else if (args[0].equalsIgnoreCase("clear")) {
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
