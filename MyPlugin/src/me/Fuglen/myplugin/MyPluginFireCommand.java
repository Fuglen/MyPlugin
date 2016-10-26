package me.Fuglen.myplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyPluginFireCommand implements CommandExecutor {

	public MyPluginFireCommand(MyPlugin myPlugin) {
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

	    if (cmd.getName().equalsIgnoreCase("fire")) {
			if (args.length == 0) {
				((Player) sender).setFireTicks(200);
				sender.sendMessage(ChatColor.RED + "Du satte ild til dig selv!");
				return true;
			}
	    
		//Er brugeren en rigtig spiller? Nej? så skriver vi til ham at han skal være det!
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Du skal være en spiller!");
			return true;
		}
		
		Player target = sender.getServer().getPlayer(args[0]);
		
		if (target == null) {
			sender.sendMessage(ChatColor.RED + "Spilleren er ikke online!");
			return true;
		}
		
		sender.sendMessage(ChatColor.GOLD + "BURN BABY, BURN!");
		target.setFireTicks(200);
		return true;
		
	    }
		return true;
	    }
	}

