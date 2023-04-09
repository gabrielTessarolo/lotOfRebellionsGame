package com.ichbineinstudio.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.ichbineinstudio.entities.Player;
import com.ichbineinstudio.main.Game;

public class LightingSystem {

	
	public void render_1(Graphics g) {
		Graphics2D g1 = (Graphics2D) g;
		
		g1.setColor(new Color(0,0,0,150));
		g1.fillRect(0, 0, Game.WIDHT, Game.HEIGHT);
		g1.setColor(new Color(255,255,255,100));
		g1.fillOval(65, 40, 120, 80);
	    
	    }
	public void render_2(Graphics g) {
		Graphics2D g1 = (Graphics2D) g;
		g1.setColor(new Color(0,0,0,150));
		g1.fillRect(0, 0, Game.WIDHT, Game.HEIGHT);
		
	}
	


}
