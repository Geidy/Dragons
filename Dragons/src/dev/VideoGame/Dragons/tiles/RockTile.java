package dev.VideoGame.Dragons.tiles;

import dev.VideoGame.Dragons.gfx.Assets;

public class RockTile extends Tile {
	
	public RockTile(int id) {
		super(Assets.stone, id);
	}
	
	
	public boolean isSolid() {
		return true;  //Override is solid method bec is a solid- not walkable tile
	}

}
