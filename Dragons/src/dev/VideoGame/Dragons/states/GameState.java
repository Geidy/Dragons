package dev.VideoGame.Dragons.states;

import java.awt.Graphics;

import dev.VideoGame.Dragons.Game;
import dev.VideoGame.Dragons.entities.creatures.Player;
import dev.VideoGame.Dragons.tiles.Tile;
import dev.VideoGame.Dragons.world.World;

//import dev.VideoGame.Dragons.gfx.Assets;

public class GameState extends State{
	
	private Player player;
	private World world;
		
	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);  //position
		//world = new World(""); before world.text
		world = new World(game, "res/worlds/world1.txt");
		
		
	}

	@Override
	public void tick() {
		world.tick();
		player.tick();
				
	}

	@Override
	public void render(Graphics g) {
		//g.drawImage(Assets.dirt, 0, 0, null);
		world.render(g);
		player.render(g);
		Tile.tiles[1].render(g, 0, 0);
				
	}

	

}
