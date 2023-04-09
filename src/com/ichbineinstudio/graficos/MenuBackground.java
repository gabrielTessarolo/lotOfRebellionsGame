package com.ichbineinstudio.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MenuBackground {

	private BufferedImage menuBackground; 

	public MenuBackground(String path)
	{
		try {
			menuBackground = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getSprite(int x, int y, int width, int height) {
		return menuBackground.getSubimage(x,y,width,height);
	}
}
