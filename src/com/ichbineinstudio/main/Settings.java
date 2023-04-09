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

public class Settings {

	public static String[] options = {"BackToMenu","Texture1","Texture2","Texture3","Texture4","English","Português"};
	
	public static int currentOption;
	public int MaxOption = options.length - 1;
	
	public boolean down,up,right,left;
	
	public void tick() {
	
		//System.out.println(currentOption);
		
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
		else if(options[currentOption] == "Texture1") {
			
				Sound.selectOptionSound.play();
				
				if(Game.texture == "Texture_THREE") {
					Sound.musicBackground2.stop();
				}else if(Game.texture == "Texture_FOUR") {
					Sound.musicBackground3.stop();
				}
				Sound.musicBackground.loop();
			
			Game.texture = "Texture_ONE";
		}
		else if(options[currentOption] == "Texture2") {
			if(Player.hasTexture2) {
				
				Sound.selectOptionSound.play();
				if(Game.texture == "Texture_THREE") {
					Sound.musicBackground2.stop();
				}else if(Game.texture == "Texture_FOUR") {
					Sound.musicBackground3.stop();
				}
				Sound.musicBackground.loop();
			Game.texture = "Texture_TWO";
			} else {
			
			}
		}else if(options[currentOption] == "Texture3") {
			if(Player.hasTexture3) {
				
				Sound.selectOptionSound.play();
				if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO") {
					Sound.musicBackground.stop();
				}else if(Game.texture == "Texture_FOUR") {
					Sound.musicBackground3.stop();
				}
				Sound.musicBackground2.loop();
				
				Game.texture = "Texture_THREE";
				
				
			} else {
				
			}
		}else if(options[currentOption] == "Texture4") {
			
			if(Player.hasTexture4) {
				Sound.selectOptionSound.play();
				if(Game.texture == "Texture_THREE") {
					Sound.musicBackground2.stop();
				}else if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO") {
					Sound.musicBackground.stop();
				}
				Sound.musicBackground3.loop();
			Game.texture = "Texture_FOUR";
			} else {
			
			}
		}else if(options[currentOption] == "English") {
				Sound.selectOptionSound.play();
				Game.language = "English";
			
		}else if(options[currentOption] == "Português") {
			Sound.selectOptionSound.play();
			Game.language = "Português";
		
	}
	}
	if(up) {
		Sound.changeOptionSound.play();
		//System.out.println("AAAAAA");
		up = false;
		if(currentOption == 4 || currentOption == 3 || currentOption == 2 || currentOption == 6) {
		currentOption--;
		}else if(currentOption == 1) {
		currentOption = 4;
		}else if(currentOption == 5) {
		currentOption = 6;
		}
		
	}
	if(down) {
		Sound.changeOptionSound.play();
		down = false;
		if(currentOption == 1 || currentOption == 2 || currentOption == 3 || currentOption == 5) {
			currentOption++;
			}else if(currentOption == 4) {
			currentOption = 1;
			}else if(currentOption == 6) {
			currentOption = 5;
			}
	}
	if(left) {
		Sound.changeOptionSound.play();
		left = false;
		if(currentOption == 0) {
			currentOption = 5;
		}else if(currentOption >= 1 && currentOption <= 4) {
			currentOption = 0;
		}else if(currentOption == 5 || currentOption == 6) {
			currentOption = 1;
		}
	}
	if(right) {
		
			Sound.changeOptionSound.play();
			right = false;
			if(currentOption == 0) {
				currentOption = 1;
			}else if(currentOption >= 1 && currentOption <= 4) {
				currentOption = 5;
			}else if(currentOption == 5 || currentOption == 6) {
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
		
		/*g.setColor(new Color(100,100,100, 150));
		g.fillRect(50, 230, 620, 200);
		g.setColor(new Color(255,204,51));
		g.fillRect(50, 230, 7, 200);
		g.fillRect(663, 230, 7, 200);
		g.fillRect(50, 230, 620, 7);
		g.fillRect(50, 423, 620, 7);
		g.fillRect(443, 230, 7, 200);
		g.fillRect(464, 230, 7, 200);
		g.setColor(new Color(0,0,100));
		g.fillRect(450, 230, 14, 200);*/
		
		
		// Selecionar texturas

		g.setColor(new Color(100,100,100, 150));
		g.fillRect(50, 230, 200, 200);
		g.setColor(new Color(255,204,51));
	//	g.fillRect(464, 50, 206, 163);
	//	g.setColor(new Color(100,100,100, 150));
	//	g.fillRect(451, 57, 199, 156);
		g.fillRect(50, 230, 200, 7);
		g.fillRect(50, 423, 200, 7);
		g.fillRect(50, 230, 7, 193);
		g.fillRect(243, 230, 7, 193);
		
		
		// Selecionar idioma
		
		g.setColor(new Color(100,100,100, 150));
		g.fillRect(257, 230, 200, 200);
		g.setColor(new Color(255,204,51));
	//	g.fillRect(464, 50, 206, 163);
	//	g.setColor(new Color(100,100,100, 150));
	//	g.fillRect(451, 57, 199, 156);
		g.fillRect(257, 230, 200, 7);
		g.fillRect(257, 423, 200, 7);
		g.fillRect(257, 230, 7, 193);
		g.fillRect(450, 230, 7, 193);
		
		
		// Voltar para o Menu
		
		g.setColor(new Color(100,100,100, 150));
		g.fillRect(464, 230, 200, 200);
		g.setColor(new Color(255,204,51));
	//	g.fillRect(464, 50, 206, 163);
	//	g.setColor(new Color(100,100,100, 150));
	//	g.fillRect(451, 57, 199, 156);
		g.fillRect(464, 230, 200, 7);
		g.fillRect(464, 423, 200, 7);
		g.fillRect(464, 230, 7, 193);
		g.fillRect(657, 230, 7, 193);
		
		
		if(Game.language == "English") {
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,18));
		g.drawString("Select the texture:", 68, 258);
		g.drawString("Select the language:", 268, 258);
		}else if(Game.language == "Português") {
			g.setColor(Color.white);
			g.setFont(new Font("Arial",Font.BOLD, 18));
			g.drawString("Selecione a textura:", 62, 258);
			g.drawString("Selecione o idioma:", 271, 258);
		}
	
		 if(options[currentOption] == "BackToMenu") {
			 g.setColor(new Color(150,150,150, 150));
			    g.fillRect(500,252,135,152);
		    	g.setColor(Color.white);
		    	g.fillRect(500, 253, 5, 150);
		    	g.fillRect(630, 253, 5, 150);
		    	g.fillRect(500, 253, 135, 5);
		    	g.fillRect(500, 403, 135, 5);
		    
	    }else if(options[currentOption] == "Texture1") {
	    	g.setColor(new Color(150,150,150, 150));
	    	g.fillRect(61, 267, 100, 17);
	    	g.drawImage(Entity.J_KEY, 171, 263, 23, 23, null);
	    }else if(options[currentOption] == "Texture2") {
	    	g.setColor(new Color(150,150,150, 150));
	    	g.fillRect(61, 295, 100, 17);
	    	if(Player.hasTexture2) {
	    	g.drawImage(Entity.J_KEY, 171, 290, 23, 23, null);
	    	} else {
	    	g.drawImage(Entity.LOCK, 171, 290, 23, 23, null);
	     	}
	    }else if(options[currentOption] == "Texture3") {
	    	g.setColor(new Color(150,150,150, 150));
	    	g.fillRect(61, 323, 100, 17);
	    	if(Player.hasTexture3) {
	    	g.drawImage(Entity.J_KEY, 171, 317, 23, 23, null);
	    	} else {
	    	g.drawImage(Entity.LOCK, 171, 317, 23, 23, null);
	     	}
	    }else if(options[currentOption] == "Texture4") {
	    	g.setColor(new Color(150,150,150, 150));
	    	g.fillRect(61, 351, 100, 17);
	    	if(Player.hasTexture4) {
	    	g.drawImage(Entity.J_KEY, 171, 344, 23, 23, null);
	    	} else {
	    	g.drawImage(Entity.LOCK, 171, 344, 23, 23, null);
	     	}
	    }else if(options[currentOption] == "English") {
	    	g.setColor(new Color(150,150,150, 150));
	    	g.fillRect(275, 267, 100, 17);
	    	g.drawImage(Entity.J_KEY, 385, 263, 23, 23, null);
	    }else if(options[currentOption] == "Português") {
	    	g.setColor(new Color(150,150,150, 150));
	    	g.fillRect(275, 295, 100, 17);
	    	g.drawImage(Entity.J_KEY, 385, 290, 23, 23, null);
	    }
		if(Game.texture == "Texture_ONE") {
			g.setColor(new Color(150,150,150, 150));
			g.fillRect(61, 267, 100, 17);
	    	if(Game.select) {
	    		if(options[currentOption] == "Texture2") {
	    			//Player.StartNewGame = true;
	    			
	    		
	    	        
	    		}
	    	}
		}else if(Game.texture == "Texture_TWO") {
			g.setColor(new Color(150,150,150, 150));
			g.fillRect(61, 295, 100, 17);
	    	if(Game.select) {
	    		if(options[currentOption] == "Texture1") {
	    		if(Game.texture == "Texture_ONE") {
	    			Game.gameState = "Menu";
	    			
	    		    }
	    		}
	    	}
		}else if(Game.texture == "Texture_THREE") {
			g.setColor(new Color(150,150,150, 150));
			g.fillRect(61, 323, 100, 17);
	    	if(Game.select) {
	    		if(options[currentOption] == "Texture1") {
	    		if(Game.texture == "Texture_ONE") {
	    			Game.gameState = "Menu";
	    			
	    		    }
	    		}
	    	}
		}else if(Game.texture == "Texture_FOUR") {
			g.setColor(new Color(150,150,150, 150));
			g.fillRect(61, 351, 100, 17);
	    	if(Game.select) {
	    		if(options[currentOption] == "Texture1") {
	    		if(Game.texture == "Texture_ONE") {
	    			Game.gameState = "Menu";
	    			
	    		    }
	    		}
	    	}
		} 
		if(Game.language == "English") {
			g.setColor(new Color(150,150,150, 150));
			g.fillRect(275, 267, 100, 17);
		}else if(Game.language == "Português") {
			g.setColor(new Color(150,150,150, 150));
			g.fillRect(275, 295, 100, 17);
		}
		if(Game.language == "English") {
			g.setColor(Color.white);
			g.setFont(new Font("Times New Roman",Font.ITALIC,14));
			g.drawString("It takes one level to load the entire texture", 50, 444);
		 g.setColor(Color.white);
		 g.setFont(new Font("Arial",Font.ITALIC,30));
			g.drawString("Back", 530, 295);
			g.drawString("to", 548, 340);
			g.drawString("Menu", 525, 385);
			
			g.setFont(new Font("Arial",Font.ITALIC,18));
			g.drawString("Texture - 1", 66, 282);
			g.drawString("Texture - 2", 66, 310);
			g.drawString("Texture - 3", 66, 338);
			g.drawString("Texture - 4", 66, 366);
			g.drawString("English", 280, 282);
			g.drawString("Português", 280, 310);
		}else if(Game.language == "Português") {
			g.setColor(Color.white);
			g.setFont(new Font("Times New Roman",Font.ITALIC,14));
			g.drawString("Demora um nível para carregar toda a textura", 50, 444);
			 g.setColor(Color.white);
			 g.setFont(new Font("Arial",Font.ITALIC,30));
				g.drawString("Voltar", 525, 295);
				g.drawString("ao", 548, 335);
				g.setFont(new Font("Arial",Font.ITALIC,20));
				g.drawString("Menu", 515, 365);
				g.drawString("Principal", 535, 390);
				
				g.setFont(new Font("Arial",Font.ITALIC,18));
				g.drawString("Textura - 1", 66, 282);
				g.drawString("Textura - 2", 66, 310);
				g.drawString("Textura - 3", 66, 338);
				g.drawString("Textura - 4", 66, 366);
				g.drawString("English", 280, 282);
				g.drawString("Português", 280, 310);
		}
	//System.out.println(currentOption);
	
	}
}