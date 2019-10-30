package dev.VideoGame.Dragons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.VideoGame.Dragons.Display.*;

public class Game implements Runnable {
	
	private Display Display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
				
	}
	
	
	//init- Initialize the graphics of the game
	public void init() {
		Display = new Display(title,width, height);
					
		}
		
	
private void tick() {  //could be called update
		
	}
	
	private void render() {
		bs = Display.getCanvas().getBufferStrategy();
		if(bs == null) {
			Display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear the screen
		g.clearRect(0, 0, width, height);  //clear screen after draw
		//Draw here
		
		g.setColor(Color.red);
		g.fillRect(10, 50, 50, 70);
		g.setColor(Color.pink);
		g.fillRect(2, 2, 10, 10);
		
		//End Draw
		bs.show();
		g.dispose();
		
	}
	
	public void run() {  //majority of our code will go
		
		init();
		//running is true loop-keep
		while(running) {  //tick and render makes
			tick();    //everything run over and over
			render();
	}
		
		stop();
	}
	
	public synchronized void start() {
		if(running)    //if game already running keep...
			return;
		running = true;   //if its not or false then true and run
		thread = new Thread(this); //allows to run game class
		thread.start();
	}
		public synchronized void stop() {
			if(!running)   //if not running
				return;
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	

}
