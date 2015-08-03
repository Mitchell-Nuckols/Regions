package me.mitchisaperson.regions;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerExitRegionEvent extends Event
{
	private Player p;
	private Region r;
	
	private boolean cancelled;
	
	public PlayerExitRegionEvent(Player player, Region region)
	{
		p = player;
		r = region;
	}
	
	public Player getPlayer() {return p;}
	public Region getRegion() {return r;}
	
    public boolean isCancelled()
    {
        return cancelled;
    }
 
    public void setCancelled(boolean cancel)
    {
        cancelled = cancel;
    }
	
	private static HandlerList handlers = new HandlerList();
	
	public HandlerList getHandlers()
	{
		return handlers;
	}
	
	public static HandlerList getHandlerList()
	{
		return handlers;
	}
}