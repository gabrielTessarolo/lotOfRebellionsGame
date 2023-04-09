package com.ichbineinstudio.graficos;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tiles {

		private BufferedImage tiles; 

		public Tiles(String path)
		{
			try {
				tiles = ImageIO.read(getClass().getResource(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public BufferedImage getSprite(int x, int y, int width, int height) {
			return tiles.getSubimage(x,y,width,height);
		}
	

}
