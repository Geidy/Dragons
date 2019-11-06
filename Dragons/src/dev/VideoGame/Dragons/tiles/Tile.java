package dev.VideoGame.Dragons.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//Static stuff variables
	
	public static Tile[] tiles = new Tile[256];
	public static Tile GrassTile = new GrassTile(0);
	public static Tile DirtTile = new DirtTile(1);
	public static Tile RockTile = new RockTile(2);
	
	
	
	//Class
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected static int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		//Tiles id as identifier in array
		tiles[id] = this;
		tiles[0] = this;
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
		
	}
	
	public boolean isSolid() {   //If is walkable is false
		return false;   //should return true if a rock or solid tile
	}
	
	public int getId() {
		return id;
	}

}
