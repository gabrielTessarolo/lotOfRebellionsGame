package com.ichbineinstudio.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.ichbineinstudio.main.Game;

public class Tile {
	
	public static BufferedImage[] WaterMovements;
	
	public int waterFrames = 0, maxWaterFrames = 15, waterIndex = 0, maxWaterIndex = 3;
	public static boolean WaterMoved = false;

	public static BufferedImage TILE_FLOOR = Game.tiles.getSprite(0, 0, 16, 16);
	public static BufferedImage TILE_PRISONFLOOR = Game.tiles.getSprite(0, 1*16, 16, 16);
	public static BufferedImage TILE_FLOOR2 = Game.spritesheet.getSprite(16, 48, 16, 16);
	public static BufferedImage TILE_WALL = Game.tiles.getSprite(16, 0, 16, 16);
	public static BufferedImage TILE_WALL2 = Game.tiles.getSprite(16, 2*16, 16, 16);
	public static BufferedImage TILE_BRIDGE = Game.tiles.getSprite(0, 3*16, 16, 16);
	public static BufferedImage TILE_PRESSURE_PLATE = Game.spritesheet.getSprite(8*16, 6*16, 16, 16);
	public static BufferedImage TILE_GRID = Game.spritesheet.getSprite(16, 7*16, 16, 16);
	public static BufferedImage NOTHING = Game.spritesheet.getSprite(16, 144, 16, 16);
	public static BufferedImage TILE_SAND = Game.tiles.getSprite(0*16, 2*16, 16, 16);
	public static BufferedImage TILE_SAND2 = Game.tiles.getSprite(2*16, 2*16, 16, 16);
	public static BufferedImage TILE_FLOOR3 = Game.tiles.getSprite(0*16, 4*16, 16, 16);
	public static BufferedImage TILE_FLOOR3_ = Game.tiles.getSprite(0*16, 5*16, 16, 16);
	public static BufferedImage TILE_FLOOR3__ = Game.tiles.getSprite(1*16, 4*16, 16, 16);
	public static BufferedImage TILE_FLOOR3___ = Game.tiles.getSprite(2*16, 4*16, 16, 16);
	public static BufferedImage TILE_WALL3 = Game.tiles.getSprite(1*16, 5*16, 16, 16);
	public static BufferedImage TILE_WALL3_ = Game.tiles.getSprite(1*16, 5*16, 16, 16);
	
	public static BufferedImage TILE_FLOOR_TEXTURE2 = Game.tiles.getSprite(3*16, 0, 16, 16);
	public static BufferedImage TILE_PRISONFLOOR_TEXTURE2 = Game.tiles.getSprite(3*16, 16, 16, 16);
	public static BufferedImage TILE_SAND_TEXTURE2 = Game.tiles.getSprite(3*16, 2*16, 16, 16);
	public static BufferedImage TILE_SAND2_TEXTURE2 = Game.tiles.getSprite(5*16, 2*16, 16, 16);
	public static BufferedImage TILE_WALL_TEXTURE2 = Game.tiles.getSprite(4*16, 0, 16, 16);
	public static BufferedImage TILE_WALL__TEXTURE2 = Game.tiles.getSprite(4*16, 1*16, 16, 16);
	public static BufferedImage TILE_WALL___TEXTURE2 = Game.tiles.getSprite(5*16, 0*16, 16, 16);
	public static BufferedImage TILE_WALL2_TEXTURE2 = Game.tiles.getSprite(4*16, 2*16, 16, 16);
	public static BufferedImage TILE_BRIDGE_TEXTURE2 = Game.tiles.getSprite(3*16, 3*16, 16, 16);
	public static BufferedImage TILE_WATER_TEXTURE2 = Game.tiles.getSprite(4*16, 3*16, 16, 16);
	public static BufferedImage TILE_FLOOR3_TEXTURE2 = Game.tiles.getSprite(3*16, 4*16, 16, 16);
	public static BufferedImage TILE_FLOOR3__TEXTURE2 = Game.tiles.getSprite(4*16, 4*16, 16, 16);
	public static BufferedImage TILE_FLOOR3___TEXTURE2 = Game.tiles.getSprite(5*16, 4*16, 16, 16);
	public static BufferedImage TILE_FLOOR3____TEXTURE2 = Game.tiles.getSprite(3*16, 5*16, 16, 16);
	public static BufferedImage TILE_WALL3_TEXTURE2 = Game.tiles.getSprite(4*16, 5*16, 16, 16);
	public static BufferedImage TILE_WALL3__TEXTURE2 = Game.tiles.getSprite(5*16, 5*16, 16, 16);
	
	
	public static BufferedImage TILE_FLOOR_TEXTURE3 = Game.tiles.getSprite(6*16, 0, 16, 16);
	public static BufferedImage TILE_FLOOR__TEXTURE3 = Game.tiles.getSprite(8*16, 0, 16, 16);
	public static BufferedImage TILE_PRISONFLOOR_TEXTURE3 = Game.tiles.getSprite(6*16, 1*16, 16, 16);
	public static BufferedImage TILE_FLOOR2_TEXTURE3 = Game.tiles.getSprite(6*16, 2*16, 16, 16);
	public static BufferedImage TILE_FLOOR2__TEXTURE3 = Game.tiles.getSprite(7*16, 2*16, 16, 16);
	public static BufferedImage TILE_WALL_TEXTURE3 = Game.tiles.getSprite(7*16, 0, 16, 16);
	public static BufferedImage TILE_WALL__TEXTURE3 = Game.tiles.getSprite(7*16, 1*16, 16, 16);
	//public static BufferedImage TILE_WALL___TEXTURE2 = Game.tiles.getSprite(5*16, 0*16, 16, 16);
	public static BufferedImage TILE_WALL2_TEXTURE3 = Game.tiles.getSprite(8*16, 1*16, 16, 16);
	public static BufferedImage TILE_WALL2__TEXTURE3 = Game.tiles.getSprite(8*16, 2*16, 16, 16);
	public static BufferedImage TILE_BRIDGE_TEXTURE3 = Game.tiles.getSprite(6*16, 3*16, 16, 16);
	public static BufferedImage TILE_WATER_TEXTURE3 = Game.tiles.getSprite(7*16, 3*16, 16, 16);
	public static BufferedImage TILE_FLOOR3_TEXTURE3 = Game.tiles.getSprite(6*16, 4*16, 16, 16);
	public static BufferedImage TILE_FLOOR3__TEXTURE3 = Game.tiles.getSprite(7*16, 4*16, 16, 16);
	public static BufferedImage TILE_WALL3_TEXTURE3 = Game.tiles.getSprite(6*16, 5*16, 16, 16);
	public static BufferedImage TILE_WALL3__TEXTURE3 = Game.tiles.getSprite(7*16, 5*16, 16, 16);
	
	public static BufferedImage TILE_FLOOR_TEXTURE4 = Game.tiles.getSprite(11*16, 0, 16, 16);
	public static BufferedImage TILE_FLOOR2_TEXTURE4 = Game.tiles.getSprite(11*16, 2*16, 16, 16);
	public static BufferedImage TILE_WALL_TEXTURE4 = Game.tiles.getSprite(12*16, 0, 16, 16);
	public static BufferedImage TILE_WALL__TEXTURE4 = Game.tiles.getSprite(11*16, 1*16, 16, 16);
	public static BufferedImage TILE_WALL___TEXTURE4 = Game.tiles.getSprite(12*16, 1*16, 16, 16);
	//public static BufferedImage TILE_WALL___TEXTURE2 = Game.tiles.getSprite(5*16, 0*16, 16, 16);
	public static BufferedImage TILE_WALL2_TEXTURE4 = Game.tiles.getSprite(12*16, 2*16, 16, 16);
	public static BufferedImage TILE_WALL2__TEXTURE4 = Game.tiles.getSprite(11*16, 3*16, 16, 16);
	public static BufferedImage TILE_WALL2___TEXTURE4 = Game.tiles.getSprite(12*16, 3*16, 16, 16);
	public static BufferedImage TILE_FLOOR3_TEXTURE4 = Game.tiles.getSprite(11*16, 4*16, 16, 16);
	public static BufferedImage TILE_WALL3_TEXTURE4 = Game.tiles.getSprite(11*16, 5*16, 16, 16);
	public static BufferedImage TILE_WALL3__TEXTURE4 = Game.tiles.getSprite(12*16, 5*16, 16, 16);
	public static BufferedImage TILE_WALL3___TEXTURE4 = Game.tiles.getSprite(11*16, 6*16, 16, 16);
	public static BufferedImage TILE_WALL3____TEXTURE4 = Game.tiles.getSprite(12*16, 6*16, 16, 16);
	
	public static BufferedImage ELETRONIC_WALL = Game.spritesheet.getSprite(16, 7*16, 16, 16);
	
	public static boolean canBeChanged = false;
	
	public boolean isAJail = true;
	
	private BufferedImage sprite;
	protected int x,y;
	
	public Tile(int x, int y, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		
        WaterMovements = new BufferedImage[3];
		
		WaterMovements[0] = Game.spritesheet.getSprite(32, 6*16, 16, 16);
		WaterMovements[1] = Game.spritesheet.getSprite(48, 6*16, 16, 16);
		WaterMovements[2] = Game.spritesheet.getSprite(64, 6*16, 16, 16);
		
	}
	
	public void render (Graphics g) {
		g.drawImage(sprite, x - Camera.x, y - Camera.y, null);
		
	}

}
