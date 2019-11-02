package dev.VideoGame.Dragons.entities.creatures;

import dev.VideoGame.Dragons.entities.Entity;

public abstract class Creature extends Entity{
	
	protected int health;
	
	public Creature(float x, float y) {
		super(x, y);
		health = 10;
	}
	
	

}
