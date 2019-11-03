package dev.VideoGame.Dragons.entities.creatures;

import dev.VideoGame.Dragons.entities.Entity;

public abstract class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0F;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
			               DEFAULT_CREATURE_HEIGHT = 64; //new creature size squares values
	
	protected int health;  //lives #
	protected float speed;  //movement
	protected float xMove, yMove;
	
	public Creature(float x, float y, int width, int height) {
		super(x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		x += xMove;
		y += yMove;
	}
	
	//Getters and setters

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	

}
