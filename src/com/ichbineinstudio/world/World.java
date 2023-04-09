package com.ichbineinstudio.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import com.ichbineinstudio.entities.BillyWeapon;
import com.ichbineinstudio.entities.Boss1;
import com.ichbineinstudio.entities.Boss2;
import com.ichbineinstudio.entities.Boss3;
import com.ichbineinstudio.entities.Bullet;
import com.ichbineinstudio.entities.Button;
import com.ichbineinstudio.entities.EletronicWall;
import com.ichbineinstudio.entities.Enemy;
import com.ichbineinstudio.entities.Enemy2;
import com.ichbineinstudio.entities.Enemy3;
import com.ichbineinstudio.entities.Enemy4;
import com.ichbineinstudio.entities.Entity;
import com.ichbineinstudio.entities.FriendlyNpc;
import com.ichbineinstudio.entities.LifePack;
import com.ichbineinstudio.entities.Player;
import com.ichbineinstudio.entities.Player2;
import com.ichbineinstudio.entities.PressurePlate;
import com.ichbineinstudio.entities.Trap;
import com.ichbineinstudio.entities.Weapon;
import com.ichbineinstudio.graficos.Spritesheet;
import com.ichbineinstudio.main.Game;


public class World {
	
	public static Tile[] tiles;
	public static Entity[] entities;
	public static int WIDTH,HEIGHT;
	public static final int TILE_SIZE = 16;
	public static final int BOSS_TILE_SIZE = 32;
	
	public static Random rand;
	
	private int waterFrames = 0, maxWaterFrames = 15, waterIndex = 0, maxWaterIndex = 3;
	public static boolean WaterMoved = false;
	
	public World(String path) {
		
		rand = new Random();
		
	//	if(Game.defaultMaps) {
		try {
			
			BufferedImage map = ImageIO.read(getClass().getResource(path));
		    int[] pixels = new int[map.getWidth() * map.getHeight()];
		    WIDTH = map.getWidth();
		    HEIGHT = map.getHeight();
		    tiles = new Tile[map.getWidth() * map.getHeight()];
		    map.getRGB(0,0,map.getWidth(),map.getHeight(),pixels,0,map.getWidth());
            for(int xx = 0; xx < map.getWidth(); xx++) {
            	for(int yy = 0; yy < map.getHeight(); yy++) {
            		int pixelAtual = pixels[xx + (yy * map.getWidth())];
            		
            		
            		
            		if(Game.CUR_LEVEL <= 3) {
            			if(Game.texture == "Texture_ONE") {
            				if(Game.CUR_LEVEL == 0) {
            					tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR);	
            				}else {
            				if(this.rand.nextInt(100) < 50) {
                    			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR);
                    				}else {
                    					tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR);		
                    				}
            				}
            			}
            			else if(Game.texture == "Texture_TWO") {
            				if(this.rand.nextInt(100) < 50) {
                    			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR_TEXTURE2);
                    				}else {
                    					tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR_TEXTURE2);		
                    				}
            			}
            			else if(Game.texture == "Texture_THREE") {
            				if(this.rand.nextInt(100) < 50) {
                    			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR_TEXTURE3);
                    				}else {
                    				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR__TEXTURE3);		
                    				}
            			}
            			else if(Game.texture == "Texture_FOUR") {
            				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR_TEXTURE4);
            			}
            			
            			}
            			
            			
            		else if(Game.CUR_LEVEL == 4) {
            		
            			if(Game.texture == "Texture_ONE") {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR);
            			}
            			else if(Game.texture == "Texture_TWO") {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR_TEXTURE2);
            			}
            			else if(Game.texture == "Texture_THREE") {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR_TEXTURE3);	
            			}
            			else if(Game.texture == "Texture_FOUR") {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR_TEXTURE4);		
            			}
            			
            		}else if(Game.CUR_LEVEL == 5) {
            			if(Game.texture == "Texture_ONE") {
            				if(this.rand.nextInt(100) < 50) {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR);
            				}else {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR);		
            				}
            			}
            			else if(Game.texture == "Texture_TWO") {
            				if(this.rand.nextInt(100) < 50) {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR_TEXTURE2);
            				}else {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR_TEXTURE2);		
            				}
            			}
            			else if(Game.texture == "Texture_THREE") {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR_TEXTURE3);		
            			}
            			else if(Game.texture == "Texture_FOUR") {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR_TEXTURE4);		
            			}
            		}
            		else if(Game.CUR_LEVEL >= 6 && Game.CUR_LEVEL <= 10) {
            			if(Game.texture == "Texture_ONE") {
            				if(this.rand.nextInt(100) < 94) {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_SAND);
            				} else {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_SAND2);		
            				}
            			}else if(Game.texture == "Texture_TWO") {
            				if(this.rand.nextInt(100) < 94) {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_SAND_TEXTURE2);
            				} else {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_SAND2_TEXTURE2);		
            				}
            			}else if(Game.texture == "Texture_THREE") {
            				if(this.rand.nextInt(100) < 50) {
                    			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR2_TEXTURE3);
                    				} else {
                    			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR2__TEXTURE3);		
                    				}
            				
            			}else if(Game.texture == "Texture_FOUR") {
            				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR2_TEXTURE4);
            			}
            		}else if(Game.CUR_LEVEL >= 11){
            			if(Game.texture == "Texture_ONE") {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3);
                				if(this.rand.nextInt(100) <= 3) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3___);
                				}else if(this.rand.nextInt(100) > 3 && this.rand.nextInt(100) <= 6){
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3__);		
                				}else if(this.rand.nextInt(100) > 6 && this.rand.nextInt(100) <= 9) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3_);	
                				}else if(this.rand.nextInt(100) > 9) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3);		
                				}
                			}else if(Game.texture == "Texture_TWO") {
                				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3_TEXTURE2);
                				if(this.rand.nextInt(100) <= 3) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3____TEXTURE2);
                				}else if(this.rand.nextInt(100) > 3 && this.rand.nextInt(100) <= 6){
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3___TEXTURE2);		
                				}else if(this.rand.nextInt(100) > 6 && this.rand.nextInt(100) <= 9) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3__TEXTURE2);	
                				}else if(this.rand.nextInt(100) > 9) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3_TEXTURE2);		
                				}
                			}else if(Game.texture == "Texture_THREE") {
                				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3_TEXTURE3);
                				if(this.rand.nextInt(100) <= 50) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3_TEXTURE3);
                				}else {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3__TEXTURE3);	
                					
                				}
                			}else if(Game.texture == "Texture_FOUR") {
                				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3_TEXTURE4);
                			}
            		}
            		else if(pixelAtual == 0xFFC2CCCC) {	
            				Game.entities.add(new PressurePlate(xx*16,yy*16,16,16,Entity.PRESSURE_PLATE));
                        
            		}
            		if(!Game.player.ThePressurePlateWasPressed) {
            			if(pixelAtual == 0xFFB5A45A) {
            				Game.entities.add(new EletronicWall(xx*16,yy*16,16,16,Entity.ELETRONIC_WALL));
            			}
            		}else if(Game.player.ThePressurePlateWasPressed) {
            			if(pixelAtual == 0xFFB5A45A) {
            				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_SAND);
            			}
            		}
            		
            		if(pixelAtual == 0xFF000000) {
            			//Floor
            			
            			if(Game.texture == "Texture_ONE") {
            				if(Game.CUR_LEVEL == 0) {
            					tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR);	
            				}else {
            				if(this.rand.nextInt(100) < 10) {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR);
            				}else {
            					tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR);	
            				}
            				}
            			}else if(Game.texture == "Texture_TWO") {
            				if(Game.CUR_LEVEL == 0) {
            					tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR_TEXTURE2);	
            				}else {
            				if(this.rand.nextInt(100) < 50) {
                    			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR_TEXTURE2);
                    				}else {
                    					tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR_TEXTURE2);	
                    				}
                    				}
            			}else if(Game.texture == "Texture_THREE") {
            				if(Game.CUR_LEVEL == 0) {
            					tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR_TEXTURE3);	
            				}else {
            				if(this.rand.nextInt(100) < 50) {
                    			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR_TEXTURE3);
                    				}else {
                    				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR__TEXTURE3);		
                    				}
            				}
            			}else if(Game.texture == "Texture_FOUR") {
            				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR_TEXTURE4);
            			}
            			
            		}
            		else if(pixelAtual == 0xFFC0C0C0) {
            			if(Game.texture == "Texture_ONE") {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR);
            			}else if(Game.texture == "Texture_TWO") {
            				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR_TEXTURE2);	
            			}else if(Game.texture == "Texture_THREE") {
                    		tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR_TEXTURE3);                    				
            			}else if(Game.texture == "Texture_FOUR") {
            				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR_TEXTURE4);    
            			}
            		}
            		else if(pixelAtual == 0xFFFFFFFF) {
            			//Walls
            			if(Game.texture == "Texture_ONE") {
            			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL);
            			}
            			else if(Game.texture == "Texture_TWO") {
            				if(Game.CUR_LEVEL <= 5) {
            					if(this.rand.nextInt(100) < 35) {
            			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL_TEXTURE2);
            					} else {
                        			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL___TEXTURE2);			
            					}
            				
            				}else if(Game.CUR_LEVEL > 5 && Game.CUR_LEVEL <= 10) {
            				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL__TEXTURE2);		
            				}
            			}else if(Game.texture == "Texture_THREE") {
            				if(Game.CUR_LEVEL == 6 || Game.CUR_LEVEL == 9) {
            					if(this.rand.nextInt(100) < 95) {
            						tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2_TEXTURE3);
            					}else {
            						tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2__TEXTURE3);
            					}
            				}else {
            					if(this.rand.nextInt(100) < 95) {
                        			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL_TEXTURE3);
                        				}else {
                        				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL__TEXTURE3);		
                        				}
            				}
            				
            			}else if(Game.texture == "Texture_FOUR") {
            				if(Game.CUR_LEVEL == 6 || Game.CUR_LEVEL == 9) {
            					tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2_TEXTURE4);
                        		if(this.rand.nextInt(100) <= 33) {
                    				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2_TEXTURE4);  
                    				}else if(this.rand.nextInt(100) > 33 && this.rand.nextInt(100) <= 68) {
                    				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2__TEXTURE4);	
                    				}else if(this.rand.nextInt(100) > 68) {
                        			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2___TEXTURE4);	
                        			}
            				}else {
            				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL___TEXTURE4);
            				if(this.rand.nextInt(100) < 33) {
            				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL_TEXTURE4);  
            				}else if(this.rand.nextInt(100) > 32 && this.rand.nextInt(100) < 68) {
            				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL__TEXTURE4);	
            				}else if(this.rand.nextInt(100) > 67) {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL___TEXTURE4);	
                			}
            				}
            			}
            		}else if(pixelAtual == 0xFFFF6868) {
            			if(Game.texture == "Texture_ONE") {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL);
                			tiles[xx + (yy*WIDTH)].canBeChanged = true;
                			}
                			else if(Game.texture == "Texture_TWO") {
                				if(Game.CUR_LEVEL <= 5) {
                					if(this.rand.nextInt(100) < 35) {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL_TEXTURE2);
                			tiles[xx + (yy*WIDTH)].canBeChanged = true;
                					} else {
                            			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL___TEXTURE2);
                            			tiles[xx + (yy*WIDTH)].canBeChanged = true;
                					}
                				
                				}else if(Game.CUR_LEVEL > 5 && Game.CUR_LEVEL <= 10) {
                				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL__TEXTURE2);		
                				tiles[xx + (yy*WIDTH)].canBeChanged = true;
                				}
                			}else if(Game.texture == "Texture_THREE") {
                				if(Game.CUR_LEVEL == 6 || Game.CUR_LEVEL == 9) {
                					if(this.rand.nextInt(100) < 95) {
                						tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2_TEXTURE3);
                						tiles[xx + (yy*WIDTH)].canBeChanged = true;
                					}else {
                						tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2__TEXTURE3);
                						tiles[xx + (yy*WIDTH)].canBeChanged = true;
                					}
                				}else {
                					if(this.rand.nextInt(100) < 95) {
                            			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL_TEXTURE3);
                            			tiles[xx + (yy*WIDTH)].canBeChanged = true;
                            				}else {
                            				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL__TEXTURE3);		
                            				tiles[xx + (yy*WIDTH)].canBeChanged = true;
                            				}
                				}
                				
                			}else if(Game.texture == "Texture_FOUR") {
                				if(Game.CUR_LEVEL == 6 || Game.CUR_LEVEL == 9) {
                					tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2_TEXTURE4);
                					tiles[xx + (yy*WIDTH)].canBeChanged = true;
                            		if(this.rand.nextInt(100) <= 33) {
                        				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2_TEXTURE4);  
                        				tiles[xx + (yy*WIDTH)].canBeChanged = true;
                        				}else if(this.rand.nextInt(100) > 33 && this.rand.nextInt(100) <= 68) {
                        				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2__TEXTURE4);	
                        				tiles[xx + (yy*WIDTH)].canBeChanged = true;
                        				}else if(this.rand.nextInt(100) > 68) {
                            			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2___TEXTURE4);	
                            			tiles[xx + (yy*WIDTH)].canBeChanged = true;
                            			}
                				}else {
                				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL___TEXTURE4);
                				tiles[xx + (yy*WIDTH)].canBeChanged = true;
                				if(this.rand.nextInt(100) < 33) {
                				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL_TEXTURE4);  
                				tiles[xx + (yy*WIDTH)].canBeChanged = true;
                				}else if(this.rand.nextInt(100) > 32 && this.rand.nextInt(100) < 68) {
                				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL__TEXTURE4);	
                				tiles[xx + (yy*WIDTH)].canBeChanged = true;
                				}else if(this.rand.nextInt(100) > 67) {
                    			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL___TEXTURE4);	
                    			tiles[xx + (yy*WIDTH)].canBeChanged = true;
                    			}
                				}
                			}
            		}
            		else if(pixelAtual == 0xFF0094FF) {
            			Game.player.setX(xx*16);
            			Game.player.setY(yy*16);
            		}
            		else if(pixelAtual == 0xFF003256) {
            		//	if(Game.numberOfPlayers == 2) {
            			Game.player2.setX(xx*16);
            			Game.player2.setY(yy*16);
            		//	System.out.println("added");
            		//	}
            		}
            		else if(pixelAtual == 0xFF00FF21) {
            			if(Game.texture == "Texture_ONE") {
            			FriendlyNpc npc = new FriendlyNpc(xx*16,yy*16,16,16,Entity.FRIENDLY_NPC);
            			Game.entities.add(npc);
            			}else if(Game.texture == "Texture_TWO") {
            			FriendlyNpc npc = new FriendlyNpc(xx*16,yy*16,16,16,Entity.FRIENDLY_NPC_TEXTURE2);
                		Game.entities.add(npc);
            			}else if(Game.texture == "Texture_THREE") {
            			FriendlyNpc npc = new FriendlyNpc(xx*16,yy*16,16,16,Entity.FRIENDLY_NPC_TEXTURE3);
                		Game.entities.add(npc);	
            			}else if(Game.texture == "Texture_FOUR") {
            			FriendlyNpc npc = new FriendlyNpc(xx*16,yy*16,16,16,Entity.FRIENDLY_NPC_TEXTURE4);
                    	Game.entities.add(npc);		
            			}
            		}
            		else if(pixelAtual == 0xFFFF0000) {
            			//Enemy
            			Enemy en = new Enemy(xx*16,yy*16,16,16,Entity.ENEMY_EN);
            			Game.entities.add(en);
            			Game.enemies.add(en);
            		}
            		else if(pixelAtual == 0xFF770033) {
            			Trap trp = new Trap(xx*16,yy*16,16,16,Entity.TRAP_EN);
            			Game.entities.add(trp);
            			Game.traps.add(trp);
            			
            			
            		}
            		else if(pixelAtual == 0xFFFF4949) {
            			Button button = new Button(xx*16,yy*16,16,16,null);
            			Game.entities.add(button);
            			Game.buttons.add(button);
            			
            			
            		}
            		else if(pixelAtual == 0xFFFF6A00) {
            			//Bullet
            			if(Game.texture == "Texture_ONE") {
            			Game.entities.add(new Bullet(xx*16,yy*16,16,16,Entity.BULLET_EN));
            			}else if(Game.texture == "Texture_TWO") {
            				Game.entities.add(new Bullet(xx*16,yy*16,16,16,Entity.BULLET_EN_TEXTURE2));	
            			}else if(Game.texture == "Texture_THREE") {
            				Game.entities.add(new Bullet(xx*16,yy*16,16,16,Entity.BULLET__EN_TEXTURE3));	
            			}else if(Game.texture == "Texture_FOUR") {
            				Game.entities.add(new Bullet(xx*16,yy*16,16,16,Entity.BULLET_EN_TEXTURE4));
            			}
            		}
                    else if(pixelAtual == 0xFFFBD400) {
            			//Weapon
                    	if(Game.texture == "Texture_ONE") {
                    		if(Game.CUR_LEVEL == 7) {
                    			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_BRIDGE);
                    			Game.entities.add(new Weapon(xx*16,yy*16,16,16,Entity.WEAPON_EN));
                    		} else {
                    	Game.entities.add(new Weapon(xx*16,yy*16,16,16,Entity.WEAPON_EN));
                    		}
                    	}else if(Game.texture == "Texture_TWO") {
                    		if(Game.CUR_LEVEL == 7) {
                    			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_BRIDGE_TEXTURE2);
                    			Game.entities.add(new Weapon(xx*16,yy*16,16,16,Entity.WEAPON_EN_TEXTURE2));
                    		} else {
                    	Game.entities.add(new Weapon(xx*16,yy*16,16,16,Entity.WEAPON_EN_TEXTURE2));
                    		}
                    	}else if(Game.texture == "Texture_THREE") {
                    		if(Game.CUR_LEVEL == 7) {
                    			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR2_TEXTURE3);
                    			Game.entities.add(new Weapon(xx*16,yy*16,16,16,Entity.WEAPON_EN_TEXTURE3));
                    		}else {
                    			Game.entities.add(new Weapon(xx*16,yy*16,16,16,Entity.WEAPON_EN_TEXTURE3));
                    		}
                    	
                    	}else if(Game.texture == "Texture_FOUR") {
                    		Game.entities.add(new Weapon(xx*16,yy*16,16,16,Entity.WEAPON_EN_TEXTURE4));
                    	}
            		}
                    else if(pixelAtual == 0xFF00FFFF) {
                    	//Lifepack
            //        	LifePack pack = new LifePack(xx*16,yy*16,16,16,Entity.LIFEPACK_EN);
              //      	pack = setMask(0,0,16,8);
                    	if(Game.texture == "Texture_ONE") {
                    	Game.entities.add(new LifePack(xx*16,yy*16,16,16,Entity.LIFEPACK_EN));
                    	}else if(Game.texture == "Texture_TWO") {
                    		Game.entities.add(new LifePack(xx*16,yy*16,16,16,Entity.LIFEPACK_EN_TEXTURE2));
                    	}else if(Game.texture == "Texture_THREE") {
                    		Game.entities.add(new LifePack(xx*16,yy*16,16,16,Entity.LIFEPACK_EN_TEXTURE3));
                    	}else if(Game.texture == "Texture_FOUR") {
                    		Game.entities.add(new LifePack(xx*16,yy*16,16,16,Entity.LIFEPACK_EN_TEXTURE4));
                    	}
                    
                    }
                    else if(pixelAtual == 0xFFA08500) {
                    	Game.entities.add(new BillyWeapon(xx*16,yy*16,16,16,Entity.BILLY_EN));
                    }
                    else if(pixelAtual == 0xFF822C2C) {
                    	Enemy2 en2 = new Enemy2(xx*16,yy*16,16,16,Entity.ENEMY2_EN);
                    	Game.entities.add(en2);
            			Game.enemies2.add(en2);
                    
                    }else if(pixelAtual == 0xFFC10037) {
                    	Enemy3 en3 = new Enemy3(xx*16,yy*16,16,16,Entity.ENEMY3_EN);
                    	Game.entities.add(en3);
            			Game.enemies3.add(en3);
                    }else if(pixelAtual == 0xFF413F3F) {
                    	Enemy4 en4 = new Enemy4(xx*16,yy*16,16,16,Entity.ENEMY4_EN);
                    	Game.entities.add(en4);
            			Game.enemies4.add(en4);
                    }
                    else if(pixelAtual == 0xFFFFB27F) {
                    	if(Game.CUR_LEVEL == 5) {	
                    		//if(Game.boss1.size() == 0) {                   			
                    	Boss1 bs1 = new Boss1(xx*16,yy*16,16,16,Entity.BOSS1_EN);
                    	Game.entities.add(bs1);
                    	Game.boss1.add(bs1);
                    		//}
                    	}
                    }
                    else if(pixelAtual == 0xFF7F3388) {
                    	Boss2 bs1 = new Boss2(xx*16,yy*16,16,16,Entity.BOSS2_EN);
                    	Game.entities.add(bs1);
                    	Game.boss2.add(bs1);
                    }
                    else if(pixelAtual == 0xFF478E4F) {
                    	Boss3 bs1 = new Boss3(xx*16,yy*16,16,16,Entity.BOSS3_EN);
                    	Game.entities.add(bs1);
                    	Game.boss3.add(bs1);
                    }
            		
                    else if(pixelAtual == 0xFFFFE97F) {
                    	if(Game.texture == "Texture_ONE") {
            				if(this.rand.nextInt(100) < 94) {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_SAND);
            				} else {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_SAND2);	
            				}
            			}else if(Game.texture == "Texture_TWO") {
            				if(this.rand.nextInt(100) < 99) {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_SAND_TEXTURE2);
            				} else {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_SAND2_TEXTURE2);		
            				}
            			}
            			else if(Game.texture == "Texture_THREE") {
            				if(this.rand.nextInt(100) < 50) {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR2_TEXTURE3);
            				} else {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR2__TEXTURE3);		
            				}
            			}else if(Game.texture == "Texture_FOUR") {
            			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR2_TEXTURE4);
            			}
            		}
                    else if(pixelAtual == 0xFF007F0E) {
                    	if(Game.texture == "Texture_ONE") {
                    	tiles[xx + (yy*WIDTH)] = new WallTile2(xx*16,yy*16,Tile.TILE_WALL2);
                    	}else if(Game.texture == "Texture_TWO") {
                    	tiles[xx + (yy*WIDTH)] = new WallTile2(xx*16,yy*16,Tile.TILE_WALL2_TEXTURE2);
                    		
                    	}else if(Game.texture == "Texture_THREE") {
                    		if(this.rand.nextInt(100) < 95) {
                    			tiles[xx + (yy*WIDTH)] = new WallTile2(xx*16,yy*16,Tile.TILE_WALL2_TEXTURE3);
                    		}else {
                    			tiles[xx + (yy*WIDTH)] = new WallTile2(xx*16,yy*16,Tile.TILE_WALL2__TEXTURE3);
                    		}
                    		
                    	}else if(Game.texture == "Texture_FOUR") {
        
                    		tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2_TEXTURE4);
                    		if(this.rand.nextInt(100) <= 33) {
                				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2_TEXTURE4);  
                				}else if(this.rand.nextInt(100) > 33 && this.rand.nextInt(100) <= 68) {
                				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2__TEXTURE4);	
                				}else if(this.rand.nextInt(100) > 68) {
                    			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2___TEXTURE4);	
                    			}
                    	}
                    }
                    else if(pixelAtual == 0xFFCC5100) {
                    	if(Game.texture == "Texture_ONE") {
                    	tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_BRIDGE);
                    	}else if(Game.texture == "Texture_TWO") {
                    	tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_BRIDGE_TEXTURE2);
                    	}else if(Game.texture == "Texture_THREE") {
                    	tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR2_TEXTURE3);	
                    	}else if(Game.texture == "Texture_FOUR") {
                    	tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR2_TEXTURE4);
                    	}
                    }
                    else if(pixelAtual == 0xFF808080) {
                    	tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_GRID);
                    	
                    }
                    else if(pixelAtual == 0xFF707070) {
                    	if(Game.CUR_LEVEL == 0) {
                    		if(Game.texture == "Texture_ONE") {
                    			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR);
                    		}
                    		else if(Game.texture == "Texture_TWO") {
                    			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR_TEXTURE2);
                    		}
                    		else if(Game.texture == "Texture_THREE") {
                    			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_PRISONFLOOR_TEXTURE3);
                    		}else if(Game.texture == "Texture_FOUR") {
                    			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_FLOOR_TEXTURE4);
                    		}
                    		
                    	}
                    }
                    ///////////AAGUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
            		if (WaterMoved) {
                		waterFrames++;
            			if(waterFrames == maxWaterFrames) {
            				waterFrames = 0;
            				waterIndex++;
            				if(waterIndex > maxWaterIndex)
            					waterIndex = 0;
            				
            			}
            		}
                    else if(pixelAtual == 0xFF00CCCC) {
                    	if(Game.texture == "Texture_ONE") {
                    	tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.WaterMovements[waterIndex]);	
                    	}else if(Game.texture == "Texture_TWO") {
                    	tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WATER_TEXTURE2);	
                    	}else if(Game.texture == "Texture_THREE") {
                    	tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2_TEXTURE3);	
                    	}else if(Game.texture == "Texture_FOUR") {
                    		tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2_TEXTURE4);
                    		if(this.rand.nextInt(100) <= 33) {
                				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2_TEXTURE4);  
                				}else if(this.rand.nextInt(100) > 33 && this.rand.nextInt(100) <= 68) {
                				tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2__TEXTURE4);	
                				}else if(this.rand.nextInt(100) > 68) {
                    			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL2___TEXTURE4);	
                    			}	
                    	}
                    	}
                    else if(pixelAtual ==  0xFF840000) {
                    	if(Game.texture == "Texture_ONE") {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3);
                				if(this.rand.nextInt(100) <= 3) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3___);
                				}else if(this.rand.nextInt(100) > 3 && this.rand.nextInt(100) <= 6){
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3__);		
                				}else if(this.rand.nextInt(100) > 6 && this.rand.nextInt(100) <= 9) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3_);	
                				}else if(this.rand.nextInt(100) > 9) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3);		
                				}
                			}else if(Game.texture == "Texture_TWO") {
                				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3_TEXTURE2);
                				if(this.rand.nextInt(100) <= 3) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3____TEXTURE2);
                				}else if(this.rand.nextInt(100) > 3 && this.rand.nextInt(100) <= 6){
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3___TEXTURE2);		
                				}else if(this.rand.nextInt(100) > 6 && this.rand.nextInt(100) <= 9) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3__TEXTURE2);	
                				}else if(this.rand.nextInt(100) > 9) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3_TEXTURE2);		
                				}
                			}else if(Game.texture == "Texture_THREE") {
                				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3_TEXTURE3);
                				if(this.rand.nextInt(100) <= 50) {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3_TEXTURE3);
                				}else {
                			tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3__TEXTURE3);	
                					
                				}
                			}else if(Game.texture == "Texture_FOUR") {
                				tiles[xx + (yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.TILE_FLOOR3_TEXTURE4);
                			}
                    }
                    else if(pixelAtual ==  0xFFC0C084) {
                    	if(Game.texture == "Texture_ONE") {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3);
                				if(this.rand.nextInt(100) <= 50) {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3_);
                				}
                				else {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3);		
                				}
                			}else if(Game.texture == "Texture_TWO") {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3_TEXTURE2);
                				if(this.rand.nextInt(100) <= 50) {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3__TEXTURE2);
                				}
                				else {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3_TEXTURE2);		
                				}
                			}else if(Game.texture == "Texture_THREE") {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3_TEXTURE3);
                				if(this.rand.nextInt(100) <= 5) {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3__TEXTURE3);
                				}
                				else {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3_TEXTURE3);		
                				}
                			}else if(Game.texture == "Texture_FOUR") {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3_TEXTURE4);
                				if(this.rand.nextInt(100) <= 25) {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3_TEXTURE4);
                				}else if(this.rand.nextInt(100) > 25 && this.rand.nextInt(100) <= 50) {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3__TEXTURE4);		
                				}else if(this.rand.nextInt(100) > 50 && this.rand.nextInt(100) <= 75) {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3___TEXTURE4);		
                				}else if(this.rand.nextInt(100) > 75) {
                			tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.TILE_WALL3____TEXTURE4);		
                				}
                				
                			}
                    	
                    }
            		
            		
                    	
                    	
                    /*	if(waterFrames <= 5) {
                        	tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.WaterMovements[1]);
                        }
                        	else if(waterFrames > 5 && waterFrames <= 10) {
                        		tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.WaterMovements[2]);
                        	}
                        	else if(waterFrames > 10 && waterFrames <= 15) {
                        		tiles[xx + (yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.WaterMovements[3]);
                        	}*/
                    }
            		
            		
            	
            	
            }
		
		} catch (IOException e) {
			e.printStackTrace();
		}	
		/*}else {
			Game.player.setX(0);
			Game.player.setY(0);
			WIDTH = 100;
			HEIGHT = 100;
			tiles = new Tile[WIDTH*HEIGHT];
			
			for(int xx = 0; xx < WIDTH; xx++) {
				for(int yy = 0; yy < HEIGHT; yy++) {
					tiles[xx+yy*WIDTH] = new Tile(xx*16, yy*16, Tile.TILE_FLOOR);
				}
			}
			
			int dir = 0;
			
			int xx = 0, yy = 0;
			
			for(int i = 0; i < 200; i++) {
				if(dir == 0) {
					//right
					if(xx < WIDTH) {
						xx++;
					}
				}
				else if(dir == 1) {
					//left
					if(xx > 0) {
						xx--;
					}
				}
				else if(dir == 2) {
					//down
					if(yy < HEIGHT) {
						yy++;
					}
				}
				else if(dir == 3) {
					//up
					if(yy > 0) {
						yy--;
					}
				}
				if(Game.rand.nextInt(100) < 30) {
					dir = Game.rand.nextInt(4);
				}
				tiles[xx+yy*WIDTH] = new Tile(xx*16, yy*16, Tile.TILE_FLOOR);
				
			}
	    }*/
	}
		
	/*public static boolean changedTexture() {
		
	    if(Help.textureHasChanged == true) {
	    	return true;
	    }
		
		return false;
		
	}
	*/
	
		
	
	
	
	public static boolean isFree(int xnext, int ynext) {
		int x1 = xnext / TILE_SIZE;
		int y1 = ynext / TILE_SIZE;
		
		int x2 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y2 = ynext / TILE_SIZE;
		
		int x3 = xnext / TILE_SIZE;
		int y3 = (ynext+TILE_SIZE-1) /  TILE_SIZE;
		
		int x4 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y4 = (ynext+TILE_SIZE-1) /  TILE_SIZE;
	
		if(!((tiles[x1 + (y1*World.WIDTH)] instanceof WallTile)|| 
				(tiles[x1 + (y1*World.WIDTH)] instanceof WallTile2)||
			//	(entities[x1 + (y1*World.WIDTH)] instanceof EletronicWall)||
				(tiles[x2 + (y2*World.WIDTH)] instanceof WallTile) ||
				(tiles[x2 + (y2*World.WIDTH)] instanceof WallTile2)||
			//	(entities[x2 + (y2*World.WIDTH)] instanceof EletronicWall)||
				(tiles[x3 + (y3*World.WIDTH)] instanceof WallTile) ||
				(tiles[x3 + (y3*World.WIDTH)] instanceof WallTile2)||
			//	(entities[x3 + (y3*World.WIDTH)] instanceof EletronicWall)||
				(tiles[x4 + (y4*World.WIDTH)] instanceof WallTile) ||
				(tiles[x4 + (y4*World.WIDTH)] instanceof WallTile2))
	){
			return true;
		
	}
		// Para pular paredes, deixe fora de comentário as próximas 6 linhas de código e comente as 4 próximas a elas.
		/*else {
		if(!Player. isJumping) {
			return false;
		}else {
			return true;
		}
	}*/
		/*if(zplayer > 0) {
			return true;
			
		}*/return false;
			//	(entities[x4 + (y4*World.WIDTH)] instanceof EletronicWall));//||
	}
	
	public static boolean isFreeForEnemies(int xnext, int ynext) {
		int x1 = xnext / TILE_SIZE;
		int y1 = ynext / TILE_SIZE;
		
		int x2 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y2 = ynext / TILE_SIZE;
		
		int x3 = xnext / TILE_SIZE;
		int y3 = (ynext+TILE_SIZE-1) /  TILE_SIZE;
		
		int x4 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y4 = (ynext+TILE_SIZE-1) /  TILE_SIZE;
		
		return !((tiles[x1 + (y1*World.WIDTH)] instanceof WallTile)|| 
				(tiles[x1 + (y1*World.WIDTH)] instanceof WallTile2)||
				(tiles[x1 + (y1*World.WIDTH)] instanceof WaterTile)||
			//	(entities[x1 + (y1*World.WIDTH)] instanceof EletronicWall)||
				(tiles[x2 + (y2*World.WIDTH)] instanceof WallTile) ||
				(tiles[x2 + (y2*World.WIDTH)] instanceof WallTile2)||
				(tiles[x1 + (y1*World.WIDTH)] instanceof WaterTile)||
			//	(entities[x2 + (y2*World.WIDTH)] instanceof EletronicWall)||
				(tiles[x3 + (y3*World.WIDTH)] instanceof WallTile) ||
				(tiles[x3 + (y3*World.WIDTH)] instanceof WallTile2)||
				(tiles[x1 + (y1*World.WIDTH)] instanceof WaterTile)||
			//	(entities[x3 + (y3*World.WIDTH)] instanceof EletronicWall)||
				(tiles[x4 + (y4*World.WIDTH)] instanceof WallTile) ||
				(tiles[x4 + (y4*World.WIDTH)] instanceof WallTile2)||
				(tiles[x1 + (y1*World.WIDTH)] instanceof WaterTile));
	}
	
	public static boolean isFreeForBosses(int xnext, int ynext, int width, int height) {
		int x1 = xnext / TILE_SIZE;
		int y1 = ynext / TILE_SIZE;
		
		int x2 = (xnext+width-1) / TILE_SIZE;
		int y2 = ynext / TILE_SIZE;
		
		int x3 = xnext/ TILE_SIZE;
		int y3 = (ynext+height-1) /  TILE_SIZE;
		
		int x4 = (xnext+width-1) / TILE_SIZE;
		int y4 = (ynext+height-1) / TILE_SIZE;
		
		return !((tiles[x1 + (y1*World.WIDTH)] instanceof WallTile) || 
				(tiles[x1 + (y1*World.WIDTH)] instanceof WallTile2)||
				(tiles[x2 + (y2*World.WIDTH)] instanceof WallTile) ||
				(tiles[x2 + (y2*World.WIDTH)] instanceof WallTile2)||
				(tiles[x3 + (y3*World.WIDTH)] instanceof WallTile) ||
				(tiles[x3 + (y3*World.WIDTH)] instanceof WallTile2)||
				(tiles[x4 + (y4*World.WIDTH)] instanceof WallTile) ||
				(tiles[x3 + (y3*World.WIDTH)] instanceof WallTile2));//||
	}
	
	public static boolean isFreeDynamic(int xnext, int ynext, int width, int height) {
		int x1 = xnext / TILE_SIZE;
		int y1 = ynext / TILE_SIZE;
		
		int x2 = (xnext+width-1) / TILE_SIZE;
		int y2 = ynext / TILE_SIZE;
		
		int x3 = xnext / TILE_SIZE;
		int y3 = (ynext+height-1) /  TILE_SIZE;
		
		int x4 = (xnext+width-1) / TILE_SIZE;
		int y4 = (ynext+height-1) /  TILE_SIZE;
	
		return !((tiles[x1 + (y1*World.WIDTH)] instanceof WallTile)|| 
				(tiles[x1 + (y1*World.WIDTH)] instanceof WallTile2)||
			//	(entities[x1 + (y1*World.WIDTH)] instanceof EletronicWall)||
				(tiles[x2 + (y2*World.WIDTH)] instanceof WallTile) ||
				(tiles[x2 + (y2*World.WIDTH)] instanceof WallTile2)||
			//	(entities[x2 + (y2*World.WIDTH)] instanceof EletronicWall)||
				(tiles[x3 + (y3*World.WIDTH)] instanceof WallTile) ||
				(tiles[x3 + (y3*World.WIDTH)] instanceof WallTile2)||
			//	(entities[x3 + (y3*World.WIDTH)] instanceof EletronicWall)||
				(tiles[x4 + (y4*World.WIDTH)] instanceof WallTile) ||
				(tiles[x4 + (y4*World.WIDTH)] instanceof WallTile2));
	
		
	}
	
	
	
	public static boolean isFreeForBullet(int xnext,int ynext) {
		int x1 = xnext / TILE_SIZE;
		int y1 = ynext / TILE_SIZE;
		
		int x2 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y2 = ynext / TILE_SIZE;
		
		int x3 = xnext/ TILE_SIZE;
		int y3 = (ynext+TILE_SIZE-1) /  TILE_SIZE;
		
		int x4 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y4 = (ynext+TILE_SIZE-1) /  TILE_SIZE;
		
		return !((tiles[x1 + (y1*World.WIDTH)] instanceof WallTile)||
				(tiles[x2 + (y2*World.WIDTH)] instanceof WallTile)||
				(tiles[x3 + (y3*World.WIDTH)] instanceof WallTile)||
				(tiles[x4 + (y4*World.WIDTH)] instanceof WallTile));
	}
	
	public static void restartGame(String Level) {
		Game.entities = new ArrayList<Entity>();
		Game.enemies = new ArrayList<Enemy>();
		Game.enemies2 = new ArrayList<Enemy2>();
		Game.boss1 = new ArrayList<Boss1>();
		Game.spritesheet = new Spritesheet("/spritesheet.png");
		Game.player = new Player(0,0,16,16,Game.spritesheet.getSprite(0,32,16,16));
		Game.entities.add(Game.player);
		Game.player.hasGun = false;
		Game.player.ammo = 0;
		Game.world = new World("/"+Level);
		Game.minimap = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Game.minimapPixels = ((DataBufferInt)Game.minimap.getRaster().getDataBuffer()).getData();  
	}
	
	public void render(Graphics g) {
		if(Game.numberOfPlayers == 1) {
		int xstart = Camera.x >> 4;
		int ystart = Camera.y >> 4;
		
		int xfinal = xstart + (Game.WIDHT >> 4) ;
		int yfinal = ystart + (Game.HEIGHT >> 4) ;
		
		for(int xx = xstart; xx <= xfinal; xx++) {
			for(int yy = ystart; yy <= yfinal; yy++) {
				if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT) {
				continue;
				}
			    Tile tile = tiles[xx + (yy*WIDTH)];
				tile.render(g);
				
				
			}
		
	}
		}else if(Game.numberOfPlayers == 2) {
			int xstart = Camera2_1.x >> 4;
			int ystart = Camera2_1.y >> 4;
			
			int xfinal = xstart + (Game.WIDHT >> 4) ;
			int yfinal = ystart + (Game.HEIGHT >> 4) ;
			
			for(int xx = xstart; xx <= xfinal; xx++) {
				for(int yy = ystart; yy <= yfinal; yy++) {
					if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT) {
					continue;
					}
				    Tile tile = tiles[xx + (yy*WIDTH)];
					tile.render(g);
					
					
				}
			
		}
		}
	}
	public static void renderMinimap() {
		
		for(int i = 0; i < Game.minimapPixels.length; i++) {
			Game.minimapPixels[i] = 0;
			
		}
		for(int xx = 0; xx < WIDTH; xx++) {
			for(int yy = 0; yy < HEIGHT; yy++) {
				if(tiles[xx + (yy*WIDTH)] instanceof WallTile || tiles[xx + (yy*WIDTH)] instanceof WallTile2) {
					if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO") {
					Game.minimapPixels[xx + (yy*WIDTH)] = 0x009900;
					}else if(Game.texture == "Texture_THREE") {
						if(tiles[xx + (yy*WIDTH)] instanceof FloorTile || tiles[xx + (yy*WIDTH)] instanceof FloorTile2) {
							Game.minimapPixels[xx + (yy*WIDTH)] = 0xFFD800;
						}else if(tiles[xx + (yy*WIDTH)] instanceof WallTile || tiles[xx + (yy*WIDTH)] instanceof WallTile2) {
							Game.minimapPixels[xx + (yy*WIDTH)] = 0x49AAFF;
						}
					}else if(Game.texture == "Texture_FOUR") {
						if(tiles[xx + (yy*WIDTH)] instanceof FloorTile || tiles[xx + (yy*WIDTH)] instanceof FloorTile2) {
							Game.minimapPixels[xx + (yy*WIDTH)] = 0x00A010;
						}else if(tiles[xx + (yy*WIDTH)] instanceof WallTile || tiles[xx + (yy*WIDTH)] instanceof WallTile2) {
							Game.minimapPixels[xx + (yy*WIDTH)] = 0xFFD800;
						}
					}
				}
			}
			
		}
		int xPlayer = Game.player.getX()/16;
		int yPlayer = Game.player.getY()/16;
		
		Game.minimapPixels[xPlayer + (yPlayer*WIDTH)] = 0x0094FF;
		
		if(Game.numberOfPlayers == 2) {
		int xPlayer2 = Game.player2.getX()/16;
		int yPlayer2 = Game.player2.getY()/16;
		
		Game.minimapPixels[xPlayer2 + (yPlayer2*WIDTH)] = 0x003256;
		
		}
		
		for(int i = 0; i < Game.enemies.size(); i++) {
			
			Enemy e = Game.enemies.get(i);
			e.getX();
			e.getY();
		
		int xEnemy = e.getX()/16;
		int yEnemy = e.getY()/16;
		
		Game.minimapPixels[xEnemy + (yEnemy*WIDTH)] = 0xFF0000;
		}
		
        for(int i = 0; i < Game.enemies2.size(); i++) {
			
			Enemy2 e = Game.enemies2.get(i);
			e.getX();
			e.getY();
		
		int xEnemy2 = e.getX()/16;
		int yEnemy2 = e.getY()/16;
		
		Game.minimapPixels[xEnemy2 + (yEnemy2*WIDTH)] = 0xFF0000;
        }
        
        for(int i = 0; i < Game.enemies3.size(); i++) {
			
			Enemy3 e = Game.enemies3.get(i);
			e.getX();
			e.getY();
		
		int xEnemy3 = e.getX()/16;
		int yEnemy3 = e.getY()/16;
		
		Game.minimapPixels[xEnemy3 + (yEnemy3*WIDTH)] = 0xFF0000;
        }
        
        for(int i = 0; i < Game.enemies4.size(); i++) {
			
			Enemy4 e = Game.enemies4.get(i);
			e.getX();
			e.getY();
		
		int xEnemy4 = e.getX()/16;
		int yEnemy4 = e.getY()/16;
		
		Game.minimapPixels[xEnemy4 + (yEnemy4*WIDTH)] = 0xFF0000;
        }
		
        for(int i = 0; i < Game.boss1.size(); i++) {
			
			Boss1 e = Game.boss1.get(i);
			e.getX();
			e.getY();
		
		int xBoss1 = e.getX()/16;
		int yBoss1 = e.getY()/16;
		
		Game.minimapPixels[xBoss1 + (yBoss1*WIDTH)] = 0xFF0000;
		}
        
        for(int i = 0; i < Game.boss2.size(); i++) {
			
			Boss2 e = Game.boss2.get(i);
			e.getX();
			e.getY();
		
		int xBoss2 = e.getX()/16;
		int yBoss2 = e.getY()/16;
		
		Game.minimapPixels[xBoss2 + (yBoss2*WIDTH)] = 0xFF0000;
		}
        
        for(int i = 0; i < Game.boss3.size(); i++) {
			
			Boss3 e = Game.boss3.get(i);
			e.getX();
			e.getY();
		
		int xBoss3 = e.getX()/16;
		int yBoss3 = e.getY()/16;
		
		Game.minimapPixels[xBoss3 + (yBoss3*WIDTH)] = 0xFF0000;
		}
        
        for(int i = 0; i < Game.entities.size(); i++) {
			
			Entity e = Game.entities.get(i);
			e.getX();
			e.getY();
		
		int xEntity = e.getX()/16;
		int yEntity = e.getY()/16;
		
		if(!(e instanceof Player || e instanceof Player2 || e instanceof Enemy || e instanceof Enemy2 || e instanceof Enemy3 || e instanceof Enemy4 || e instanceof Boss1 || e instanceof Boss2 || e instanceof Boss3 || e instanceof Trap)) {
		Game.minimapPixels[xEntity + (yEntity*WIDTH)] = 0xFFB27F;
		}
		}
        
        /*for(int i = 0; i < Game.traps.size(); i++) {
			
			Trap e = Game.traps.get(i);
			e.getX();
			e.getY();
		
		int xTrap = e.getX()/16;
		int yTrap = e.getY()/16;
		
		Game.minimapPixels[xTrap + (yTrap*WIDTH)] = 0x7F006E;
		}*/
			
		
	}

}
