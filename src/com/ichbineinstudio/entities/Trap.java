package com.ichbineinstudio.entities;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.ichbineinstudio.main.Game;
import com.ichbineinstudio.main.Sound;
import com.ichbineinstudio.world.AStar;
import com.ichbineinstudio.world.Camera;
import com.ichbineinstudio.world.Vector2i;
import com.ichbineinstudio.world.World;

public class Trap extends Entity{
	
	   public boolean canHurtPlayer = false;
	   public int HurtCounter = 0;
	   public int hurtCounterTexture3 = 0;
		
		private int maskx = 0, masky = 0, maskw = 16, maskh = 16;
		
		private int frames = 0, maxFrames = 300, index = 0, maxIndex = 2;

		private BufferedImage[] sprites;
		private BufferedImage[] sprites2;
		private BufferedImage[] sprites3;
		private BufferedImage[] sprites4;
		
		
		private boolean isDamaged = false;
		private int damageFrames = 10, damageCurrent = 0;
		
		public Trap(int x, int y, int width, int height, BufferedImage sprite) {
			super(x, y, width, height, null);
			sprites = new BufferedImage[2];
			sprites[0] = Game.tiles.getSprite(0, 6*16, 32, 32);
		    sprites[1] = Game.tiles.getSprite(0, 8*16, 32, 32);
		    
		    
		    sprites2 = new BufferedImage[2];
			sprites2[0] = Game.tiles.getSprite(9*16, 3*16, 16, 16);
		    sprites2[1] = Game.tiles.getSprite(9*16 +16, 3*16, 16, 16);
		    
		    
		    sprites3 = new BufferedImage[4];
			sprites3[0] = Game.tiles.getSprite(6*16, 6*16, 16, 16);
		    sprites3[1] = Game.tiles.getSprite(7*16, 6*16, 16, 16);
		    sprites3[2] = Game.tiles.getSprite(6*16, 7*16, 16, 16);
		    sprites3[3] = Game.tiles.getSprite(7*16, 7*16, 16, 16);
		    
		    
		    sprites4 = new BufferedImage[2];
			sprites4[0] = Game.tiles.getSprite(11*16, 7*16, 16, 16);
		    sprites4[1] = Game.tiles.getSprite(11*16, 8*16, 16, 16);
		    
		}
			
			
			public void tick(){
				depth = 0;
				
				this.HurtCounter++;
				if(HurtCounter >= 300 && HurtCounter < 600) {
					canHurtPlayer = true;
				}else if(HurtCounter >= 600 && HurtCounter < 900) {
					canHurtPlayer = false;
				}
				
				if(HurtCounter >= 900){
					HurtCounter = 300;
				}
			
				
				if(isCollidingWithPlayer() == false) {
				
				
				}else {
					if(canHurtPlayer) {
						if(Player.isJumping == false) {
					Game.player.life-=(0.15);
					Game.player.isDamaged = true;
						}
				
					}
									
				}	
				
				
				
				
				
					
				/*
			
				if(Game.texture != "Texture_THREE") {
					maxFrames = 300;
					maxIndex = 2;
					
					frames++;
					if(frames == maxFrames) {
						frames = 0;
						index++;
						if(index > maxIndex) {
							index = 0;
						}
					
					}
				}else {
					maxIndex = 4;
					if(index < 4) {
					maxFrames = 75;
					}else {
						maxFrames = 300;
					}
					
					frames++;
					if(frames == maxFrames) {
						frames = 0;
						index++;
						if(index > maxIndex) {
							index = 0;
						}
					
					}
					
					
				}
					*/
						
				
				}
							
				
			    public boolean isCollidingWithPlayer(){
			    	Rectangle enemyCurrent = new Rectangle(this.getX() + maskx, this.getY() + masky, maskw,maskh);
			    	Rectangle player = new Rectangle(Game.player.getX(),Game.player.getY(),16,16);
			    	return enemyCurrent.intersects(player);
			    }
			    
			    
			
				
				
			public void render(Graphics g) {
			//	super.render(g);
				
				if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO") {
					if(canHurtPlayer) {
					g.drawImage(this.sprites[1], this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
				}else {
					g.drawImage(this.sprites[0], this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
				}
				}
				else if(Game.texture == "Texture_THREE") {
					if(canHurtPlayer) {
						hurtCounterTexture3 = 0;
						g.drawImage(this.sprites3[3], this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
					}else {
						hurtCounterTexture3+=1;
						if(hurtCounterTexture3 <= 100) {
						g.drawImage(this.sprites3[0], this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
					       }
						else if(hurtCounterTexture3 > 100 && hurtCounterTexture3 <= 200) {
						g.drawImage(this.sprites3[1], this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
						   }
						else if(hurtCounterTexture3 > 200) {
						g.drawImage(this.sprites3[2], this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
						   }
						if(hurtCounterTexture3 >= 300) {
							hurtCounterTexture3 = 0;
						}
						}
				}
				else if(Game.texture == "Texture_FOUR") {
					if(canHurtPlayer) {
						g.drawImage(this.sprites4[1], this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
					}else {
						g.drawImage(this.sprites4[0], this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
					}
				}
				
				
				
			//	g.fillRect((this.getX() - 2) - (Camera.x), (this.getY() - 4) - (Camera.y),16,3);
			//	g.fillRect((this.getX() - 2) - (Camera.x), (this.getY() - 4) - (Camera.y),(int)(16*(this.life/this.maxLife)),3);
				
				
			
			}
			
	}



