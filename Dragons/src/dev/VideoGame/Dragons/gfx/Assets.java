package dev.VideoGame.Dragons.gfx;

import java.awt.image.BufferedImage;

//will load in everything for the game
public class Assets {
	//variables that represent the tiles of the sprite sheets
	private static final int width = 58, height = 50;
	
	public static BufferedImage player, dirt, grass, stone, tree;
	
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Sonic_dragon.png"));
		
		player = sheet.crop(0, 0, width, height); //1st line 1st position on sprite sheet
		dirt = sheet.crop(width, 0, width, height);  //1st line 2nd position on sprite sheet
		grass = sheet.crop(width * 2, 0, width, height);  //1st line 3rd position
		stone = sheet.crop(width * 3, 0, width, height);   // 1st line 4th position sprite sheet
		tree = sheet.crop(0, height, width, height); //second line in sprite sheet
		
		
		
		
	}

}
