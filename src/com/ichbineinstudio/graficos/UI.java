package com.ichbineinstudio.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import com.ichbineinstudio.entities.Enemy;
import com.ichbineinstudio.entities.Enemy2;
import com.ichbineinstudio.entities.Enemy3;
import com.ichbineinstudio.entities.Enemy4;
import com.ichbineinstudio.entities.Entity;
import com.ichbineinstudio.entities.Player;
import com.ichbineinstudio.main.Game;
import com.ichbineinstudio.main.Sound;
import com.ichbineinstudio.world.Camera;
import com.ichbineinstudio.world.World;

public class UI {
	
	public void render(Graphics g) {
		if(Game.currentStateScene == Game.playing) {
			
		g.setColor(Color.white);
		g.fillRect(5,5,50,10);
		if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO") {
		g.setColor(Color.RED);
		g.fillRect(5,5,(int)((Game.player.life/Game.player.maxlife)*50),10);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial",Font.BOLD,8));
		g.drawString((int)Game.player.life+"/"+(int)Game.player.maxlife,16,13);
		}else if(Game.texture == "Texture_THREE") {
			g.setColor(new Color(0,150,250));
			g.fillRect(5,5,(int)((Game.player.life/Game.player.maxlife)*50),10);
			g.setColor(new Color(255,204,51));
			g.setFont(new Font("Arial",Font.BOLD,8));
			g.drawString((int)Game.player.life+"/"+(int)Game.player.maxlife,16,13);	
		}else if(Game.texture == "Texture_FOUR") {
			g.setColor(new Color(0, 160, 0));
			g.fillRect(5,5,(int)((Game.player.life/Game.player.maxlife)*50),10);
			g.setColor(new Color(255,204,51));
			g.setFont(new Font("Arial",Font.BOLD,8));
			g.drawString((int)Game.player.life+"/"+(int)Game.player.maxlife,16,13);	
		}
		if(Game.language == "English") {
		g.setColor(Color.YELLOW);
	    g.setFont(new Font("Arial",Font.ROMAN_BASELINE,8));
	    g.drawString("Ammo: "+(int)Player.ammo,200, 13);
		}else if(Game.language == "Português") {
			g.setColor(Color.YELLOW);
		    g.setFont(new Font("Arial",Font.ROMAN_BASELINE,9));
		    g.drawString("Munição: "+(int)Player.ammo,180, 13);	
		}
	    
	    g.drawImage(Entity.COIN, 5, 19, null);
	    g.setColor(new Color(255,204,51));
	    g.drawString("x "+Player.coins, 20, 30);
	    
	    g.setColor(Color.YELLOW);
	    g.setFont(new Font("Arial",Font.ROMAN_BASELINE,8));
	    if(Game.currentStateScene != Game.entering) {
	    	if(Game.CUR_LEVEL >= 1 && Game.CUR_LEVEL <= 5) {
	    g.drawString("1 -", 210, 30);
	    g.drawString(""+(int)Game.CUR_LEVEL, 222, 30);
	    	}else if(Game.CUR_LEVEL >= 6 && Game.CUR_LEVEL <= 10) {
	    g.drawString("2 -", 210, 30);
	    g.drawString(""+(int)(Game.CUR_LEVEL - 5), 222, 30);
	    	}else if(Game.CUR_LEVEL >= 11 && Game.CUR_LEVEL <= 15) {
	    g.drawString("3 -", 210, 30);
	    g.drawString(""+(int)(Game.CUR_LEVEL - 10), 222, 30);
	    	}
	    }
		
	    
	    
	    
	    
	    
	   if(!Game.npc.ShowMessage) {
		   if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO") {
	    g.setColor(Color.white);
	    g.fillRect(1, 119, 34, 40);
	    g.setColor(Color.DARK_GRAY);
	    g.fillRect(2, 120, 32, 38);
	    g.setColor(new Color(0, 200, 80));
	    if(Game.language == "English") {
	    g.setFont(new Font("Arial",Font.BOLD,9));
	    g.drawString("Enem.", 4, 130);
	    g.setFont(new Font("Arial",Font.ROMAN_BASELINE,9));
	    g.drawString("rem.", 5, 140);
	    }else if(Game.language == "Português") {
	    	g.setFont(new Font("Arial",Font.BOLD,9));
		    g.drawString("Inim.", 4, 130);
		    g.setFont(new Font("Arial",Font.ROMAN_BASELINE,9));
		    g.drawString("rest.", 5, 140);	
	    }
	   // if(Game.currentStateScene == Game.playing) {
	    g.setFont(new Font("Arial",Font.ROMAN_BASELINE,10));
	    g.drawString("= "+(int)(Game.enemies.size()+Game.enemies2.size()+Game.enemies3.size()+Game.enemies4.size()+Game.boss1.size()+Game.boss2.size()+Game.boss3.size()), 9, 155);
	   }else if(Game.texture == "Texture_THREE") {
		    g.setColor(Color.white);
		    g.fillRect(1, 119, 34, 40);
		    g.setColor(new Color(0, 150, 250));
		    g.fillRect(2, 120, 32, 38);
		    g.setColor(new Color(255, 204, 51));
		    if(Game.language == "English") {
			    g.setFont(new Font("Arial",Font.BOLD,9));
			    g.drawString("Enem.", 4, 130);
			    g.setFont(new Font("Arial",Font.ROMAN_BASELINE,9));
			    g.drawString("rem.", 5, 140);
			    }else if(Game.language == "Português") {
			    	g.setFont(new Font("Arial",Font.BOLD,9));
				    g.drawString("Inim.", 4, 130);
				    g.setFont(new Font("Arial",Font.ROMAN_BASELINE,9));
				    g.drawString("rest.", 5, 140);	
			    }
		   // if(Game.currentStateScene == Game.playing) {
		    g.setFont(new Font("Arial",Font.ROMAN_BASELINE,10));
		    g.drawString("= "+(int)(Game.enemies.size()+Game.enemies2.size()+Game.enemies3.size()+Game.enemies4.size()+Game.boss1.size()+Game.boss2.size())/*+Game.boss3.size*/, 9, 155);
	   }else if(Game.texture == "Texture_FOUR") {
		    g.setColor(Color.white);
		    g.fillRect(1, 119, 34, 40);
		    g.setColor(new Color(0, 160, 0));
		    g.fillRect(2, 120, 32, 38);
		    g.setColor(new Color(255, 204, 51));
		    if(Game.language == "English") {
			    g.setFont(new Font("Arial",Font.BOLD,9));
			    g.drawString("Enem.", 4, 130);
			    g.setFont(new Font("Arial",Font.ROMAN_BASELINE,9));
			    g.drawString("rem.", 5, 140);
			    }else if(Game.language == "Português") {
			    	g.setFont(new Font("Arial",Font.BOLD,9));
				    g.drawString("Inim.", 4, 130);
				    g.setFont(new Font("Arial",Font.ROMAN_BASELINE,9));
				    g.drawString("rest.", 5, 140);	
			    }
		   // if(Game.currentStateScene == Game.playing) {
		    g.setFont(new Font("Arial",Font.ROMAN_BASELINE,10));
		    g.drawString("= "+(int)(Game.enemies.size()+Game.enemies2.size()+Game.enemies3.size()+Game.enemies4.size()+Game.boss1.size()+Game.boss2.size())/*+Game.boss3.size*/, 9, 155);
	   }
	   }
	   /* } else if(Game.currentStateScene == Game.entering) {
	    g.drawString("=  0", 200, 155);	
	    
	    }*/
	    	
	    if(Game.texture == "Texture_ONE") {
	    	g.drawImage(Player.playerStock, 100, 2, null);
	    }else if(Game.texture == "Texture_TWO") {
	    	g.drawImage(Player.playerStock2, 100, 2, null); 	
	    }else if(Game.texture == "Texture_THREE") {
	    	g.drawImage(Player.playerStock3, 100, 2, null);
	    }else if(Game.texture == "Texture_FOUR") {
	    	g.drawImage(Player.playerStock4, 100, 2, null);
	    }
		if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO" || Game.texture == "Texture_FOUR") {
	        g.setColor(Color.white);
	        g.setFont(new Font("Arial",Font.ROMAN_BASELINE, 10));
	        g.drawString("x "+Player.stock, 120, 13);
		}else if(Game.texture == "Texture_THREE") {
			g.setColor(new Color(51, 224, 225));
	        g.setFont(new Font("Arial",Font.ROMAN_BASELINE, 10));
	        g.drawString("x "+Player.stock, 120, 13);
		}
		} 
	        
	        if(Game.BossMessageShow) {
				Game.BossMessageX++;
				if(Game.BossMessageX < 20) {
				Sound.BossMessageSound.play();
				}
				if(Game.BossMessageX >= 255) {
					Game.BossMessageX=0;
					Game.BossMessageShow = false;
					Game.BossMessageAppears = false;
					
				}
			}
	        if(Game.BossMessageShow) {
	        	if(Game.language == "English") {
				g.setColor(new Color(200,200,240, Game.BossMessageX));
				g.setFont(new Font("Bauhaus 93",Font.ITALIC,30));
				g.drawString("Boss", 95, 60);
				g.drawString("Fight", 87, 85);
	        	}else if(Game.language == "Português") {
	        		g.setColor(new Color(200,200,240, Game.BossMessageX));
					g.setFont(new Font("Bauhaus 93",Font.ITALIC,30));
					g.drawString("Luta", 95, 60);
					g.drawString("do Chefão", 55, 85);	
	        	}
				
			}
	       
	       /* if(Game.gameState == "GameOver") {
	        	Graphics2D g2= (Graphics2D) g;
	    		g2.setColor(new Color(255,255,255,255));
				g2.setFont(new Font("Arial",Font.ITALIC, 10));		
         		g2.drawString("G A M E    O V E R",72, 60);
	        }*/
	 /*       g.setColor(Color.white);
			g.fillRect(100,100,16,3);
			g.setColor(Color.RED);
			g.fillRect(100,100,(int)(16*(Enemy.life/Enemy.maxLife)),3);*/
	    
	    }
	

}
