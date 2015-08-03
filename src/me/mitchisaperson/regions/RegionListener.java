package me.mitchisaperson.regions;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RegionListener implements Listener
{
	private RegionManager rm = RegionManager.getInstance();
	
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent e)
	{
		if(rm.isPlayerInRegion(e.getPlayer())) e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1800, 1));
		
		if(!rm.isLocationInRegion(e.getFrom()) && rm.isLocationInRegion(e.getTo())) Bukkit.getServer().getPluginManager().callEvent(new PlayerEnterRegionEvent(e.getPlayer(), rm.getRegion(e.getTo())));
		if(!rm.isLocationInRegion(e.getTo()) && rm.isLocationInRegion(e.getFrom())) Bukkit.getServer().getPluginManager().callEvent(new PlayerExitRegionEvent(e.getPlayer(), rm.getRegion(e.getFrom())));
	}
	
	@EventHandler
	public void onPlayerEnterRegion(PlayerEnterRegionEvent e)
	{
		e.getPlayer().sendMessage("You entered a region!");
		e.getRegion().addPlayer(e.getPlayer());
	}
	
	@EventHandler
	public void onPlayerExitRegion(PlayerExitRegionEvent e)
	{
		e.getPlayer().sendMessage("You exited a region!");
		e.getRegion().removePlayer(e.getPlayer());
	}
}