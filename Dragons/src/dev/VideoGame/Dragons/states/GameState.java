package dev.VideoGame.Dragons.states;

import java.awt.Graphics;

import dev.VideoGame.Dragons.Game;
import dev.VideoGame.Dragons.entities.creatures.Player;

//import dev.VideoGame.Dragons.gfx.Assets;

public class GameState extends State{
	
	private Player player;
		
	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);  //position
		
	}

	@Override
	public void tick() {
		player.tick();
				
	}

	@Override
	public void render(Graphics g) {
		//g.drawImage(Assets.dirt, 0, 0, null);
		player.render(g);
				
	}

	

}
