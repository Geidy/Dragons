package dev.VideoGame.Dragons.states;

import java.awt.Graphics;

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
	public abstract void tick();
	
	public abstract void render(Graphics g); //magic paint brush
	
	
	
	
	

}
