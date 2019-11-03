package dev.VideoGame.Dragons.states;

import java.awt.Graphics;

import dev.VideoGame.Dragons.Game;

public abstract class State {
	//Game state management
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
		
	}
	
	public static State getState() {
		return currentState;
	}
	
	
	
	//Class
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	public abstract void tick();
	
	public abstract void render(Graphics g); //magic paint brush
	
	
	
	
	

}
