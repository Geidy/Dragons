package dev.VideoGame.Dragons.Display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;   //pixels
	
	//Constructor
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height  = height;
		
		createDisplay();	
		
	}
	
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //make sure game close properly
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);  //Appears in the center
		frame.setVisible(true);
		
		canvas = new Canvas();   //Canvas will have width and size of game
		//Makes sure canvas-Display stay at the size I gave it
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		frame.add(canvas);
		frame.pack();	

		
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	

}
