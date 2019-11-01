package dev.VideoGame.Dragons;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
//import java.awt.image.BufferedImage;

import dev.VideoGame.Dragons.Display.*;
import dev.VideoGame.Dragons.gfx.Assets;
//import dev.VideoGame.Dragons.gfx.ImageLoader;
//import dev.VideoGame.Dragons.gfx.SpriteSheet;

public class Game implements Runnable {
	
	private Display Display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
//	private BufferedImage test;
//	private SpriteSheet sheet;
	
	
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
				
	}
	
	
	//init- Initialize the graphics of the game
	public void init() {
		Display = new Display(title,width, height);  //loaded sprite sheet
		//test = ImageLoader.loadImage("/textures/Sonic_dragon.png");
		//sheet = new SpriteSheet(test);
		Assets.init();	
					
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
		
		g.drawImage(Assets.dirt, 10, 10, null);
		      //Rendering part of SpriteSheet
		//g.drawImage(sheet.crop(0, 0, 86, 74),20, 35, null);  //Ineficient cropping img many times
		//g.drawImage(testImage, 10, 10, null);	example
		
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
