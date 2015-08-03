package me.mitchisaperson.regions;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Region
{
	public int id;
	private int x1, z1, x2, z2;
	private String name;
	
	private List<Player> players = new ArrayList<Player>();
	
	public Region(int id, int sx, int sz, int ex, int ez, String name)
	{
		id = this.id;
		x1 = sx;
		x2 = ex;
		z1 = sz;
		z2 = ez;
		this.name = name;
	}
	
	public int getId() {return this.id;}
	public Point pos1() {return new Point(x1, z1);}
	public Point pos2() {return new Point(x2, z2);}
	public String getName() {return this.name;}
	
	public void setPos1(int x, int z)
	{
		x1 = x;
		z1 = z;
	}
	
	public void setPos2(int x, int z)
	{
		x2 = x;
		z2 = z;
	}
	
	public void setName(String n) {name = n;}
	
	public void addPlayer(Player p) {players.add(p);}
	public void removePlayer(Player p) {players.remove(p);}
	
	public boolean containsPlayer(Player p)
	{
		return players.contains(p);
	}
	
	public List<Player> getPlayers() {return players;}
}
