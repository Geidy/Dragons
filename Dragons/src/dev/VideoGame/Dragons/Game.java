package dev.VideoGame.Dragons;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
//import java.awt.image.BufferedImage;

import dev.VideoGame.Dragons.Display.*;
import dev.VideoGame.Dragons.gfx.Assets;
import dev.VideoGame.Dragons.gfx.GameCamera;
import dev.VideoGame.Dragons.input.KeyManager;
import dev.VideoGame.Dragons.states.GameState;
import dev.VideoGame.Dragons.states.MenuState;
//import dev.VideoGame.Dragons.gfx.ImageLoader;
//import dev.VideoGame.Dragons.gfx.SpriteSheet;
import dev.VideoGame.Dragons.states.State;

public class Game implements Runnable {
	
	private Display Display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
//	private BufferedImage test;
//	private SpriteSheet sheet;
	
	//States
	private State gameState;
	//private State menuState;
	
	//input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
		
		
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
				
	}
	
	
	//init- Initialize the graphics of the game
	public void init() {
		Display = new Display(title,width, height);  //loaded sprite sheet
		//test = ImageLoader.loadImage("/textures/Sonic_dragon.png");
		//sheet = new SpriteSheet(test);
		Display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameCamera = new GameCamera(this, 0, 0);
		
		gameState = new GameState(this);
		State.setState(gameState);
		//menuState = new MenuState(this);
				
					
		}
		
	//int x = 0;
private void tick() {  //could be called update
	//x +=1;
	keyManager.tick();
	
		if(State.getState() != null)
			State.getState().tick();
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
		if(State.getState() != null)
			State.getState().render(g);
		
		
		//g.drawImage(Assets.dirt, x, 10, null);
		      //Rendering part of SpriteSheet
		//g.drawImage(sheet.crop(0, 0, 86, 74),20, 35, null);  //Inefficient cropping img many times
		//g.drawImage(testImage, 10, 10, null);	example
		
		//End Draw
		bs.show();
		g.dispose();
		
	}
	
	public void run() {  //majority of our code will go
		
		init();
		
		int fps = 60;
	    double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		//running is true loop-keep
		while(running) {  //tick and render makes
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();    //everything run over and over
				render();
				ticks++;
				delta--;
				
			}
			if(timer >= 1000000000) {
				System.out.println("Ticks and frames:" + ticks);
				ticks = 0;
				timer = 0;
			}
			
	}
		
		stop();
		
	}
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
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
