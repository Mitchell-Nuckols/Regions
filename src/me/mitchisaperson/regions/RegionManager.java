package me.mitchisaperson.regions;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class RegionManager
{
	private RegionManager() {}
	private static RegionManager instance = new RegionManager();
	public static RegionManager getInstance() {return instance;}
	
	private List<Region> regions = new ArrayList<Region>();
	public int id;
	
	public void addRegion(Region r)
	{
		regions.add(r);
	}
	
	public void removeRegion(Region r)
	{
		regions.remove(r);
	}
	
	public int getId()
	{
		id++;
		return id;
	}
	
	public Region getRegion(int id)
	{
		for(Region r : regions)
		{
			if(r.getId() == id) return r;
		}
		
		return null;
	}
	
	public Region getRegion(Player player)
	{
		for(Region r : regions)
		{
			for(Player p : r.getPlayers())
			{
				if(p == player) return r;
			}
		}
		
		return null;
	}
	
	public Region getRegion(Location location)
	{
		int sx, sz, ex, ez;
		
		for(Region region: regions)
		{
		if(region.pos1().x >= region.pos2().x)
		{
			sx = region.pos1().x;
			sz = region.pos1().y;
			
			ex = region.pos2().x;
			ez = region.pos2().y;
		}else
		{
			sx = region.pos2().x;
			sz = region.pos2().y;
			
			ex = region.pos1().x;
			ez = region.pos1().y;
		}
		
		int x = sx - ex;
		int z = sz - ez;
		
		for(int i = sx; i > ex; i--)
		{
			for(int j = sz; j > ez; j--)
			{
				if(location.getBlockX() == i && location.getBlockZ() == j) return region;
			}
		}
		}
			
		return null;
	}
	
	public boolean isLocationInRegion(Location location)
	{
		int sx, sz, ex, ez;
		
		for(Region region: regions)
		{
		if(region.pos1().x >= region.pos2().x)
		{
			sx = region.pos1().x;
			sz = region.pos1().y;
			
			ex = region.pos2().x;
			ez = region.pos2().y;
		}else
		{
			sx = region.pos2().x;
			sz = region.pos2().y;
			
			ex = region.pos1().x;
			ez = region.pos1().y;
		}
		
		int x = sx - ex;
		int z = sz - ez;
		
		for(int i = sx; i > ex; i--)
		{
			for(int j = sz; j > ez; j--)
			{
				if(location.getBlockX() == i && location.getBlockZ() == j) return true;
			}
		}
		}
			
		return false;
	}
	
	public boolean isPlayerInRegion(Player player, Region region)
	{
		for(Player p : region.getPlayers())
		{
			if(p == player) return true;
		}
			
		return false;
	}
	
	public boolean isPlayerInRegion(Player player)
	{
		for(Region r : regions)
		{
			for(Player p : r.getPlayers())
			{
				if(p == player) return true;
			}
		}
			
		return false;
	}
}