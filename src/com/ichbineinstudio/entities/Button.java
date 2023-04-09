package com.ichbineinstudio.entities;

	import java.awt.Color;
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.Rectangle;
	import java.awt.image.BufferedImage;

import com.ichbineinstudio.world.Tile;
import com.ichbineinstudio.world.WallTile;
import com.ichbineinstudio.main.Game;
	import com.ichbineinstudio.main.Sound;
	import com.ichbineinstudio.world.AStar;
	import com.ichbineinstudio.world.Camera;
import com.ichbineinstudio.world.FloorTile;
import com.ichbineinstudio.world.Vector2i;
	import com.ichbineinstudio.world.World;

	public class Button extends Entity{
		
		   public boolean wasPressed = false;
		   public boolean canBePressed = true;
		   
		   public int[] positionX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		   public int[] positionY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		   public int currentPositionX = 0;
		   public int maxPositionX = positionX.length;
		   public int currentPositionY = 0;
		   public int maxPositionY = positionY.length;
		//   public int[] position = {positionX, positionY}; 
		   
			private int maskx = 0, masky = 0, maskw = 16, maskh = 16;
			
			private int frames = 0, maxFrames = 300, index = 0, maxIndex = 2;

			private BufferedImage pressed, notPressed;
			private BufferedImage pressed2, notPressed2;
			private BufferedImage pressed3, notPressed3;
			private BufferedImage pressed4, notPressed4;
			
			public Button(int x, int y, int width, int height, BufferedImage sprite) {
				super(x, y, width, height, null);
				
				notPressed = Game.tiles.getSprite(0, 10*16, 16, 16);
				pressed = Game.tiles.getSprite(16, 10*16, 16, 16);
			}
				
				
				public void tick(){
					depth = 0;
					
				//	System.out.println(positionX[currentPositionX]);
					
					if(Game.CUR_LEVEL == 1) {
						positionX[0] = 1*16;
						positionX[1] = 2*16;
						positionX[2] = 3*16;
						positionX[3] = 4*16;
						positionX[4] = 5*16;
					
						positionY[0] = 14*16;
						positionY[1] = 14*16;
						positionY[2] = 14*16;
						positionY[3] = 14*16;
						positionY[4] = 14*16;
					
						maxPositionX = 4;
						maxPositionY = 4;
					}
					else if(Game.CUR_LEVEL == 2) {
						positionX[0] = 15*16;
						positionX[1] = 16*16;
						
						positionY[0] = 16*16;
						positionY[1] = 15*16;
						
						maxPositionX = 1;
						maxPositionY = 1;
					}
				
					if(currentPositionX > maxPositionX) {
						currentPositionX = maxPositionX;
						canBePressed = false;
					}
					
					if(currentPositionY > maxPositionY) {
						currentPositionY = maxPositionY;
						canBePressed = false;
					}
					
					if(isCollidingWithPlayer() == false) {
				
				//	System.out.println(World.tiles.length);
						
						//Se não der certo, cria uma variável em Tile que permita que o tile seja mudado e um looping depois.
					
					}else {
						wasPressed = true;
					
				
						if(canBePressed) {
						int tileX = positionX[currentPositionX]/16;
						int tileY = positionY[currentPositionY]/16;
							
							
						
					/*	for(int i = 0; i < World.tiles.length; i++) {
							
							int tileX = 0; tileX++;
							int tileY = 0; tileY++;
							
							if(World.tiles[tileX + (tileY*World.WIDTH)].canBeChanged == true) {
								if(Game.texture == "Texture_ONE") {
		            				if(World.rand.nextInt(100) < 50) {
		            					World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_FLOOR);
		                    				}else {
		                    					World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_PRISONFLOOR);		
		                    				}
								
		            			}
		            			else if(Game.texture == "Texture_TWO") {
		            				if(World.rand.nextInt(100) < 50) {
		            					World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_FLOOR_TEXTURE2);
		                    				}else {
		                    					World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_PRISONFLOOR_TEXTURE2);		
		                    				}
		            			}
		            			else if(Game.texture == "Texture_THREE") {
		            				if(World.rand.nextInt(100) < 50) {
		            					World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_FLOOR_TEXTURE3);
		                    				}else {
		                    					World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_FLOOR__TEXTURE3);		
		                    				}
		            			}
		            			else if(Game.texture == "Texture_FOUR") {
		            				World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_FLOOR_TEXTURE4);
		            			}
							}
						}
						*/
					
							if(Game.texture == "Texture_ONE") {
	            				if(World.rand.nextInt(100) < 50) {
	            					World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_FLOOR);
	                    				}else {
	                    					World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_PRISONFLOOR);		
	                    				}
							
	            			}
	            			else if(Game.texture == "Texture_TWO") {
	            				if(World.rand.nextInt(100) < 50) {
	            					World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_FLOOR_TEXTURE2);
	                    				}else {
	                    					World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_PRISONFLOOR_TEXTURE2);		
	                    				}
	            			}
	            			else if(Game.texture == "Texture_THREE") {
	            				if(World.rand.nextInt(100) < 50) {
	            					World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_FLOOR_TEXTURE3);
	                    				}else {
	                    					World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_FLOOR__TEXTURE3);		
	                    				}
	            			}
	            			else if(Game.texture == "Texture_FOUR") {
	            				World.tiles[tileX + (tileY*World.WIDTH)] = new FloorTile(tileX*16,tileY*16,Tile.TILE_FLOOR_TEXTURE4);
	            			}
						
					
						currentPositionX++;
						currentPositionY++;
						
						
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
							
					
				
								
					
				    public boolean isCollidingWithPlayer(){
				    	Rectangle enemyCurrent = new Rectangle(this.getX() + maskx, this.getY() + masky, maskw,maskh);
				    	Rectangle player = new Rectangle(Game.player.getX(),Game.player.getY(),16,16);
				    	return enemyCurrent.intersects(player);
				    }
				    
				    
				
					
					
				public void render(Graphics g) {
				//	super.render(g);
					
					if(wasPressed) {

						g.drawImage(pressed, this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
					
					}else {
					
				g.drawImage(notPressed, this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
					
					}
					
					
				//	g.fillRect((this.getX() - 2) - (Camera.x), (this.getY() - 4) - (Camera.y),16,3);
				//	g.fillRect((this.getX() - 2) - (Camera.x), (this.getY() - 4) - (Camera.y),(int)(16*(this.life/this.maxLife)),3);
					
					
				
				}
				
		

}
