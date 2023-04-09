package com.ichbineinstudio.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.ichbineinstudio.entities.Entity;
import com.ichbineinstudio.entities.Player;
import com.ichbineinstudio.graficos.UI;
import com.ichbineinstudio.world.World;

public class Help {

	public static String[] options = {"BackToMenu"};
	
	public static int currentOption;
	public int MaxOption = options.length - 1;
	
	public boolean down,up;
	
	public static boolean textureHasChanged;
	
	public void tick() {
	
	if(Game.select) {
		
		Game.select = false;
		if(options[currentOption] == "BackToMenu") {
			Sound.selectOptionSound.play();
		  //Game.defaultMaps = false;
	      Game.gameState = "Menu";
	  /*    if(Menu.pause == true) {
	    	  Menu.pause = true;
	      }*/
		}
		
	}
	if(up) {
		Sound.changeOptionSound.play();
		up = false;
		currentOption--;
		if(currentOption < 0) {
			currentOption = MaxOption;
		}
		
	}
	if(down) {
		Sound.changeOptionSound.play();
		down = false;
		currentOption++;
		if(currentOption > MaxOption) {
			currentOption = 0;
		}
	}
	}
	
	
	
    
	public void render(Graphics g) {
		g.setColor(new Color(0,0,100));
		g.fillRect(0,0, Game.WIDHT*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.white);
		g.setFont(Game.newFont);
		g.drawString("A lot of", 50, 100);
		g.setColor(new Color(255,204,51));
		g.setFont(Game.newFont2);
		g.drawString("Rebellions!", 170, 180);
		
		g.setColor(new Color(100,100,100, 150));
		g.fillRect(50, 230, 620, 200);
		g.setColor(new Color(255,204,51));
		g.fillRect(50, 230, 7, 200);
		g.fillRect(663, 230, 7, 200);
		g.fillRect(50, 230, 620, 7);
		g.fillRect(50, 423, 620, 7);
		g.fillRect(443, 230, 7, 200);
		g.fillRect(464, 230, 7, 200);
		g.setColor(new Color(0,0,100));
		g.fillRect(450, 230, 14, 200);
		
		
		// Selecionar texturas
		
		
		
		
		
		
		
		if(Game.language == "English") {
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Move:", 65, 260);
		g.drawImage(Entity.W_KEY, 125, 235, 32, 32, null);
		g.drawImage(Entity.A_KEY, 145, 235, 32, 32, null);
		g.drawImage(Entity.S_KEY, 165, 235, 32, 32, null);
		g.drawImage(Entity.D_KEY, 185, 235, 32, 32, null);
		g.drawString("or", 220, 260);
		g.drawImage(Entity.UP_KEY, 245, 235, 32, 32, null);
		g.drawImage(Entity.LEFT_KEY, 265, 235, 32, 32, null);
		g.drawImage(Entity.DOWN_KEY, 285, 235, 32, 32, null);
		g.drawImage(Entity.RIGHT_KEY, 305, 235, 32, 32, null);
		g.drawString("Shoot:", 65, 290);
		g.drawImage(Entity.J_KEY, 130, 265, 32, 32, null);
		g.drawString("or", 165, 290);
		g.drawImage(Entity.C_KEY, 190, 265, 32, 32, null);
		g.drawString("Jump:", 65, 320);
		g.drawImage(Entity.SPACE_KEY, 130, 295, 32, 32, null);
		g.drawString("Run:", 65, 350);
		g.drawImage(Entity.L_KEY, 110, 325, 32, 32, null);
		g.drawString("or", 145, 350);
		g.drawImage(Entity.B_KEY, 170, 325, 32, 32, null);
		g.drawString("Open the map:", 65, 380);
		g.drawImage(Entity.M_KEY, 205, 355, 32, 32, null);
		
		}else if(Game.language == "Português") {
			g.setColor(Color.white);
			g.setFont(new Font("Arial",Font.BOLD,20));
			g.drawString("Mover:", 65, 260);
			g.drawImage(Entity.W_KEY, 130, 235, 32, 32, null);
			g.drawImage(Entity.A_KEY, 150, 235, 32, 32, null);
			g.drawImage(Entity.S_KEY, 170, 235, 32, 32, null);
			g.drawImage(Entity.D_KEY, 190, 235, 32, 32, null);
			g.drawString("ou", 220, 260);
			g.drawImage(Entity.UP_KEY, 245, 235, 32, 32, null);
			g.drawImage(Entity.LEFT_KEY, 265, 235, 32, 32, null);
			g.drawImage(Entity.DOWN_KEY, 285, 235, 32, 32, null);
			g.drawImage(Entity.RIGHT_KEY, 305, 235, 32, 32, null);
			g.drawString("Atirar:", 65, 290);
			g.drawImage(Entity.J_KEY, 130, 265, 32, 32, null);
			g.drawString("ou", 165, 290);
			g.drawImage(Entity.C_KEY, 190, 265, 32, 32, null);
			g.drawString("Pular:", 65, 320);
			g.drawImage(Entity.SPACE_KEY, 130, 295, 32, 32, null);
			g.drawString("Correr:", 65, 350);
			g.drawImage(Entity.L_KEY, 140, 325, 32, 32, null);
			g.drawString("ou", 175, 350);
			g.drawImage(Entity.B_KEY, 200, 325, 32, 32, null);
			g.drawString("Abrir o mapa:", 65, 380);
			g.drawImage(Entity.M_KEY, 190, 355, 32, 32, null);
			
		}
	
		 if(options[currentOption] == "BackToMenu") {
			 g.setColor(new Color(150,150,150, 150));
			    g.fillRect(500,252,135,152);
		    	g.setColor(Color.white);
		    	g.fillRect(500, 253, 5, 150);
		    	g.fillRect(630, 253, 5, 150);
		    	g.fillRect(500, 253, 135, 5);
		    	g.fillRect(500, 403, 135, 5);
		    
	    }
		
		
		if(Game.language == "English") {
		 g.setColor(Color.white);
		 g.setFont(new Font("Arial",Font.ITALIC,30));
			g.drawString("Back", 530, 295);
			g.drawString("to", 548, 340);
			g.drawString("Menu", 525, 385);
			
			
		}else if(Game.language == "Português") {
			 g.setColor(Color.white);
			 g.setFont(new Font("Arial",Font.ITALIC,30));
				g.drawString("Voltar", 525, 295);
				g.drawString("ao", 548, 335);
				g.setFont(new Font("Arial",Font.ITALIC,20));
				g.drawString("Menu", 515, 365);
				g.drawString("Principal", 535, 390);
				
				
		}
	
	
	}
}
