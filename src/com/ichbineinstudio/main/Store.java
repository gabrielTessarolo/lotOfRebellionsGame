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

public class Store {
	
public static String[] options = {"BackToMenu","BuyTexture2","BuyTexture3","BuyTexture4","BuyTexture5"};
	
	public static int currentOption;
	public int MaxOption = options.length - 1;
	
	public boolean down,up;
	
	public void tick() {
		
		if(Game.select) {
			Game.select = false;
			if(options[currentOption] == "BuyTexture2") {
				if(Player.coins >= 50) {
					if(!Player.hasTexture2) {
					Sound.selectOptionSound.play();
					Player.hasTexture2 = true;
					Player.coins -= 50;
					}
				}
			}else if(options[currentOption] == "BuyTexture3") {
				if(Player.coins >= 75) {
					if(!Player.hasTexture3) {
					Sound.selectOptionSound.play();
					Player.hasTexture3 = true;
					Player.coins -= 75;
				}
				}
		}else if(options[currentOption] == "BuyTexture4") {
				if(Player.coins >= 100) {
					if(!Player.hasTexture4) {
					Sound.selectOptionSound.play();
					Player.hasTexture4 = true;
					Player.coins -= 100;
				}
				}
		
					
		}else if(options[currentOption] == "BackToMenu") {
				Sound.selectOptionSound.play();
			      Game.gameState = "Menu";
			      
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
		g.fillRect(50, 230, 410, 200);
		
		g.setColor(new Color(100,100,100, 100));
		g.fillRect(10, 200, 100*3, 15*3);
		
		g.setColor(new Color(100,100,100, 100));
		g.fillRect(10, 270, 100*3, 15*3);
		
		g.setColor(new Color(100,100,100, 100));
		g.fillRect(10, 340, 100*3, 15*3);
		
		g.setColor(new Color(100,100,100, 100));
		g.fillRect(10, 410, 100*3, 15*3);
		
		if(options[currentOption] == "BuyTexture2") {
		g.setColor(Color.white);
		g.fillRect(10, 200, 2*3, 15*3);
		g.fillRect(101*3, 200, 2*3, 15*3);
		g.fillRect(10, 200, 99*3, 2*3);
		g.fillRect(10, 245, 299, 2*3);
		}
		if(options[currentOption] == "BuyTexture3") {
		g.setColor(Color.white);
		g.fillRect(10, 270, 2*3, 15*3);
		g.fillRect(101*3, 270, 2*3, 15*3);
		g.fillRect(10, 270, 99*3, 2*3);
		g.fillRect(10, 315, 299, 2*3);	
		}
		if(options[currentOption] == "BuyTexture4") {
			g.setColor(Color.white);
			g.fillRect(10, 340, 2*3, 15*3);
			g.fillRect(101*3, 340, 2*3, 15*3);
			g.fillRect(10, 340, 99*3, 2*3);
			g.fillRect(10, 385, 299, 2*3);	
		}
		if(options[currentOption] == "BuyTexture5") {
			g.setColor(Color.white);
			g.fillRect(10, 410, 2*3, 15*3);
			g.fillRect(101*3, 410, 2*3, 15*3);
			g.fillRect(10, 410, 99*3, 2*3);
			g.fillRect(10, 455, 299, 2*3);	
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
			
			if(options[currentOption] != "BuyTexture2") {
				g.setColor(Color.white);
				g.setFont(new Font("Bauhaus 93",Font.ITALIC,20));
				g.drawString("Texture 2", 25, 230);
				}else {
					g.setColor(Color.white);
					g.setFont(new Font("Bauhaus 93",Font.ITALIC,10));
					g.drawString("Texture 2", 20, 220);
					g.setColor(Color.white);
					g.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
					g.drawString("Darkness World", 25, 235);	
				}
				g.setColor(new Color(255, 204, 51));
				g.setFont(new Font("Arial",Font.ITALIC,20));
				g.drawImage(Player.playerStock2, 53*3, 190, 64, 64, null);
				if(!Player.hasTexture2) {
				g.drawString("50", 80*3, 230);
			    g.drawImage(Entity.COIN, 90*3, 207, 32, 32, null);
				}else {
				g.setColor(Color.GREEN);
				g.drawString("OWNED", 110*3, 230);
				}
			    
				if(options[currentOption] != "BuyTexture3") {
					g.setColor(Color.white);
					g.setFont(new Font("Bauhaus 93",Font.ITALIC,20));
					g.drawString("Texture 3", 25, 300);
					}else {
						g.setColor(Color.white);
						g.setFont(new Font("Bauhaus 93",Font.ITALIC,10));
						g.drawString("Texture 3", 20, 290);
						g.setColor(Color.white);
						g.setFont(new Font("Arial",Font.CENTER_BASELINE,18));
						g.drawString("Travel to Sky", 25, 308);	
					}
				g.setColor(new Color(255, 204, 51));
				g.setFont(new Font("Arial",Font.ITALIC,20));
				g.drawImage(Player.playerStock3, 53*3, 265, 64, 64, null);
			    
			    
			    /*g.setFont(new Font("Bauhaus 93",Font.ITALIC,20));
				g.drawString("Textura 3", 25, 300);
				g.setColor(new Color(255, 204, 51));
				g.setFont(new Font("Arial",Font.ITALIC,20));
				g.drawImage(Player.playerStock3, 40*3, 263, 64, 64, null);*/
				if(!Player.hasTexture3) {
				g.drawString("75", 80*3, 300);
			    g.drawImage(Entity.COIN, 90*3, 277, 32, 32, null);
				}else {
				g.setColor(Color.GREEN);
				g.drawString("OWNED", 110*3, 300);	
				}
			    
				if(options[currentOption] != "BuyTexture4") {
					g.setColor(Color.white);
					g.setFont(new Font("Bauhaus 93",Font.ITALIC,20));
					g.drawString("Texture 4", 25, 370);
					}else {
						g.setColor(Color.white);
						g.setFont(new Font("Bauhaus 93",Font.ITALIC,10));
						g.drawString("Texture 4", 20, 360);
						g.setColor(Color.white);
						g.setFont(new Font("Arial",Font.CENTER_BASELINE,18));
						g.drawString("World Cup", 25, 378);	
					}
				g.setColor(new Color(255, 204, 51));
				g.setFont(new Font("Arial",Font.ITALIC,20));
				g.drawImage(Player.playerStock4, 53*3, 333, 64, 64, null);
			    /*g.setColor(Color.white);
			    g.setColor(Color.white);
			    g.setFont(new Font("Bauhaus 93",Font.ITALIC,20));
				g.drawString("Textura 4", 25, 370);
				g.setColor(new Color(255, 204, 51));
				g.setFont(new Font("Arial",Font.ITALIC,20));
				g.drawImage(Player.playerStock4, 40*3, 333, 64, 64, null);*/
				if(!Player.hasTexture4) {
				g.drawString("100", 80*3, 370);
			    g.drawImage(Entity.COIN, 90*3, 347, 32, 32, null);
				}else {
				g.setColor(Color.GREEN);
				g.drawString("OWNED", 110*3, 370);	
				}
			    
			    g.setColor(Color.white);
			    g.setFont(new Font("Bauhaus 93",Font.ITALIC,20));
				g.drawString("Texture 5", 25, 440);
				g.setColor(new Color(255, 204, 51));
				g.setFont(new Font("Arial",Font.ITALIC,20));
			//	g.drawImage(Player.playerStock5, 40*3, 403, 64, 64, null);
	        //	if(!Player.hasTexture5) {
				g.drawString("??", 80*3, 440);
			    g.drawImage(Entity.COIN, 90*3, 417, 32, 32, null);
		
        //	}else {
		//	g.setColor(Color.GREEN);
		//	g.drawString("OWNED", 110*3, 230);	
		//	}
		    }else if(Game.language == "Português") {
		    	g.setColor(Color.white);
				 g.setFont(new Font("Arial",Font.ITALIC,30));
					g.drawString("Voltar", 525, 295);
					g.drawString("ao", 548, 335);
					g.setFont(new Font("Arial",Font.ITALIC,20));
					g.drawString("Menu", 515, 365);
					g.drawString("Principal", 535, 390);
					
					if(options[currentOption] != "BuyTexture2") {
					g.setColor(Color.white);
					g.setFont(new Font("Bauhaus 93",Font.ITALIC,20));
					g.drawString("Textura 2", 25, 230);
					}else {
						g.setColor(Color.white);
						g.setFont(new Font("Bauhaus 93",Font.ITALIC,10));
						g.drawString("Textura 2", 20, 220);
						g.setColor(Color.white);
						g.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
						g.drawString("Mundo da Escuridão", 25, 235);	
					}
					g.setColor(new Color(255, 204, 51));
					g.setFont(new Font("Arial",Font.ITALIC,20));
					g.drawImage(Player.playerStock2, 53*3, 190, 64, 64, null);
					if(!Player.hasTexture2) {
					g.drawString("50", 80*3, 230);
				    g.drawImage(Entity.COIN, 90*3, 207, 32, 32, null);
					}else {
					g.setColor(Color.GREEN);
					g.drawString("ADQUIRIDO", 110*3, 230);
					}
				    
					if(options[currentOption] != "BuyTexture3") {
						g.setColor(Color.white);
						g.setFont(new Font("Bauhaus 93",Font.ITALIC,20));
						g.drawString("Textura 3", 25, 300);
						}else {
							g.setColor(Color.white);
							g.setFont(new Font("Bauhaus 93",Font.ITALIC,10));
							g.drawString("Textura 3", 20, 290);
							g.setColor(Color.white);
							g.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
							g.drawString("Viagem aos Céus", 25, 308);	
						}
					g.setColor(new Color(255, 204, 51));
					g.setFont(new Font("Arial",Font.ITALIC,20));
					g.drawImage(Player.playerStock3, 53*3, 265, 64, 64, null);
				    
				    
				    /*g.setFont(new Font("Bauhaus 93",Font.ITALIC,20));
					g.drawString("Textura 3", 25, 300);
					g.setColor(new Color(255, 204, 51));
					g.setFont(new Font("Arial",Font.ITALIC,20));
					g.drawImage(Player.playerStock3, 40*3, 263, 64, 64, null);*/
					if(!Player.hasTexture3) {
					g.drawString("75", 80*3, 300);
				    g.drawImage(Entity.COIN, 90*3, 277, 32, 32, null);
					}else {
					g.setColor(Color.GREEN);
					g.drawString("ADQUIRIDO", 110*3, 300);	
					}
				    
					if(options[currentOption] != "BuyTexture4") {
						g.setColor(Color.white);
						g.setFont(new Font("Bauhaus 93",Font.ITALIC,20));
						g.drawString("Textura 4", 25, 370);
						}else {
							g.setColor(Color.white);
							g.setFont(new Font("Bauhaus 93",Font.ITALIC,10));
							g.drawString("Textura 4", 20, 360);
							g.setColor(Color.white);
							g.setFont(new Font("Arial",Font.CENTER_BASELINE,18));
							g.drawString("Copa do Mundo", 25, 378);	
						}
					g.setColor(new Color(255, 204, 51));
					g.setFont(new Font("Arial",Font.ITALIC,20));
					g.drawImage(Player.playerStock4, 53*3, 333, 64, 64, null);
				    /*g.setColor(Color.white);
				    g.setColor(Color.white);
				    g.setFont(new Font("Bauhaus 93",Font.ITALIC,20));
					g.drawString("Textura 4", 25, 370);
					g.setColor(new Color(255, 204, 51));
					g.setFont(new Font("Arial",Font.ITALIC,20));
					g.drawImage(Player.playerStock4, 40*3, 333, 64, 64, null);*/
					if(!Player.hasTexture4) {
					g.drawString("100", 80*3, 370);
				    g.drawImage(Entity.COIN, 90*3, 347, 32, 32, null);
					}else {
					g.setColor(Color.GREEN);
					g.drawString("ADQUIRIDO", 110*3, 370);	
					}
				    
				    g.setColor(Color.white);
				    g.setFont(new Font("Bauhaus 93",Font.ITALIC,20));
					g.drawString("Textura 5", 25, 440);
					g.setColor(new Color(255, 204, 51));
					g.setFont(new Font("Arial",Font.ITALIC,20));
				//	g.drawImage(Player.playerStock5, 40*3, 403, 64, 64, null);
		        //	if(!Player.hasTexture5) {
					g.drawString("??", 80*3, 440);
				    g.drawImage(Entity.COIN, 90*3, 417, 32, 32, null);
				
		        //	}else {
				//	g.setColor(Color.GREEN);
				//	g.drawString("ADQUIRIDO", 110*3, 230);	
				//	}	
		    }
		    
		    g.setColor(new Color(255, 204, 51));
		    g.setFont(new Font("Arial",Font.BOLD,30));
		    g.drawImage(Entity.COIN, 560, 20, 64, 64, null);
		    g.drawString("x "+Player.coins, 620, 63);
	}

}
