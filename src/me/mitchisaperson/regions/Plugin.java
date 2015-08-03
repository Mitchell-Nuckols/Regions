package me.mitchisaperson.regions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin
{
	private RegionManager rm = RegionManager.getInstance();
	
	public void onEnable()
	{
		Bukkit.getServer().getPluginManager().registerEvents(new RegionListener(), this);
	}
	
	public void onDisable()
	{
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args)
	{
		Player player = (Player) sender;
		
		if(str.equalsIgnoreCase("rg"))
		{
			if(args.length < 1)
			{
				player.sendMessage(ChatColor.RED + "You must specify enough arguments!");
				return false;
			}
			
			if(args[0].equalsIgnoreCase("create"))
			{
				Region r = new Region(rm.getId(), player.getLocation().getBlockX(), player.getLocation().getBlockZ(), player.getLocation().getBlockX() - 10, player.getLocation().getBlockZ() - 10, "Testing");
				rm.addRegion(r);
				player.sendMessage("Created region");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("info"))
			{
				if(rm.isPlayerInRegion(player)) player.sendMessage(rm.getRegion(player).getName());
			}
			
		}
		
		return false;
	}
}