package dev.VideoGame.Dragons.entities;

import java.awt.Graphics;

import dev.VideoGame.Dragons.Game;

public abstract class Entity {
	protected Game game;
	protected float x, y;   //Achieve smooth movement
	protected int width, height; //help draw images in diff places on scree
		
	public Entity(Game game, float x, float y, int width, int height) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
				
	}
	
	//Getters and setters
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	
	

}
