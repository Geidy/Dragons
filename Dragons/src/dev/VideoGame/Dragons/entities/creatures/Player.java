package dev.VideoGame.Dragons.entities.creatures;

import java.awt.Graphics;

import dev.VideoGame.Dragons.Game;
import dev.VideoGame.Dragons.gfx.Assets;

public class Player extends Creature {

	public Player(Game game, float x, float y) {
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);  //Scale img sizes
		
	}

	@Override
	public void tick() {
		getInput();
		move();
		
//		//handling input and moving player
//		if(game.getKeyManager().up)
//			y -=3;//y move up
//		if(game.getKeyManager().down)
//			y +=3;//y move down
//		if(game.getKeyManager().left)
//			x -=3;//y move left
//		if(game.getKeyManager().right)
//			x +=3;//y move right	
		
	}
	
	//how player will move
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		//increasing or decreasing speed by 3 bc of Creature default speed
		if(game.getKeyManager().up)
			yMove = -speed;
		if(game.getKeyManager().down)
			yMove = speed;
		if(game.getKeyManager().left)
			xMove = -speed;
		if(game.getKeyManager().right)
			xMove = speed;
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, width, height, null);		
	}
	

}
