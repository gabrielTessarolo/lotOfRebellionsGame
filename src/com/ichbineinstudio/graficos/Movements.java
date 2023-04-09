package com.ichbineinstudio.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Movements {

	private BufferedImage movements; 

	public Movements(String path)
	{
		try {
			movements = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getSprite(int x, int y, int width, int height) {
		return movements.getSubimage(x,y,width,height);
	}
}
