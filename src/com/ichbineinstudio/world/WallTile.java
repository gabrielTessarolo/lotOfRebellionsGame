package com.ichbineinstudio.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ichbineinstudio.main.Game;

public class WallTile extends Tile{

	public WallTile(int x, int y, BufferedImage sprite) {
		super(x, y, sprite);
		
	}
	
	/*public void  render(Graphics g) {
		super.render(g);
		if(isAJail) {
		g.drawImage(Game.tiles.getSprite(0, 0, 16, 16), x - Camera.x, y - Camera.y, 16, 16, null);
		}
		
	}*/

}