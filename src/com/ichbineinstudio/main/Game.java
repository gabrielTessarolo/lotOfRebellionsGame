package com.ichbineinstudio.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.ichbineinstudio.entities.BillyAttack;
import com.ichbineinstudio.entities.Boss1;
import com.ichbineinstudio.entities.Boss2;
import com.ichbineinstudio.entities.Boss3;
import com.ichbineinstudio.entities.BulletShoot;
import com.ichbineinstudio.entities.Button;
import com.ichbineinstudio.entities.EletronicWall;
import com.ichbineinstudio.entities.Enemy;
import com.ichbineinstudio.entities.Enemy2;
import com.ichbineinstudio.entities.Enemy3;
import com.ichbineinstudio.entities.Enemy4;
import com.ichbineinstudio.entities.EnemyShoot;
import com.ichbineinstudio.entities.Entity;
import com.ichbineinstudio.entities.FriendlyNpc;
import com.ichbineinstudio.entities.Player;
import com.ichbineinstudio.entities.Player2;
import com.ichbineinstudio.entities.Trap;
import com.ichbineinstudio.graficos.LightingSystem;
import com.ichbineinstudio.graficos.MenuBackground;
import com.ichbineinstudio.graficos.Movements;
import com.ichbineinstudio.graficos.Spritesheet;
import com.ichbineinstudio.graficos.Tiles;
import com.ichbineinstudio.graficos.UI;
import com.ichbineinstudio.world.World;

public class Game extends Canvas implements Runnable,KeyListener,MouseListener,MouseMotionListener {

	private static final long serialVersionUID = 1L;
			public static JFrame frame;
			public static final /*(Para n�o ser mudado se usa "final")*/ int WIDHT = 240;
			public static final int HEIGHT = 160;
			public final static int SCALE = 3;//Quanto maior a escala, mais pixelada fica a imagem/texto.
			private Thread thread;
			private boolean isRunning = true;
			
			public static boolean showMinimap = false;
			
			public static boolean changedLevel = false;
			
			public static int coinsSpent = 0;

			public static boolean BossMessageShow;
			public static boolean BossMessageAppears;
			public static boolean BossMessageOver;
			public static int BossMessageX = 1;
			
			private BufferedImage image;
			
			public static boolean ShowMessageNpc1 = false;
			
			public static List<Entity> entities;
			public static List<Enemy> enemies;
			public static List<Enemy2> enemies2;
			public static List<Enemy3> enemies3;
			public static List<Enemy4> enemies4;
			public static List<Boss1> boss1;
			public static List<Boss2> boss2;
			public static List<Boss3> boss3;
			public static List<Trap> traps;
			public static List<Button> buttons;
			public static List<BulletShoot> bullets;
			public static List<EnemyShoot> enemyBullets;
			public static List<BillyAttack> attacks;
			public static List<EletronicWall> eletronicWalls;
			
			public int positionPlayerImage = 32;
			
			public static MenuBackground menuBackground;
			public static Spritesheet spritesheet;
			public static Movements movements;
			public static Tiles tiles;
			
			//Cutscene
			
			public static int entering = 1;
			public static int start = 2;
			public static int playing = 3;
			
			public static int currentStateScene = entering;
			
			//
			
		//	public static boolean defaultMaps = true;
			
			public int mouseX, mouseY;
			
			public static String texture = "Texture_ONE";
			public static String language = "English";
		
			public Menu menu;
			public Help controls;
			public Settings settings;
			public Store store;
			public GameOver gameOver;
			public PlayerWon winState;
			
			public static World world;
			
			public static Player player;
			public static Player2 player2;
			
			public static int numberOfPlayers = 1;
			
			public static int gameMode;
			
			public static FriendlyNpc npc;
			
			public static Random rand;
			
			
			public static boolean select = false;
			private boolean ShowMessageGameOver = true; 
			private boolean ShowMessageWin = true;
			private int framesGameOver = 0;
			private int framesWin = 0;
			
			public static int CUR_LEVEL = 0;
			private int MAX_LEVEL = 15;
			
			public int curIndexMsg = 0;
			public int fraseIndex = 0;
			public int timeMsg = 0;
			public int maxTimeMsg = 5;
			public boolean showContinueButton = false;
			
			
			public UI ui;
			public LightingSystem lightingSystem;
			
			public InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("Squarified.ttf");
			public static Font newFont;
			
			public InputStream stream2 = ClassLoader.getSystemClassLoader().getResourceAsStream("Squarified.ttf");
			public static Font newFont2;
			
			public static boolean saveGame = false;
		
			public static String gameState = "Menu";
			
			
			public int[] pixels;
			public BufferedImage lightmap;
			public int[] lightMapPixels;
			
			public static BufferedImage minimap;
			public static int[] minimapPixels;

			public Game(){
				if(gameState == "Menu") {
					if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO") {
						Sound.musicBackground.loop();
					}/*else if(Game.texture == "Texture_THREE") {
						Sound.musicBackground2.loop();
					}*/
				}
				rand = new Random();
				addKeyListener(this);
				addMouseListener(this);
				addMouseMotionListener(this);
				this.setPreferredSize(new Dimension(WIDHT*SCALE,HEIGHT*SCALE));
				initFrame();
				
				
				lightingSystem = new LightingSystem();
			    ui = new UI();
			    
			    
			    
				image = new BufferedImage(WIDHT,HEIGHT,BufferedImage.TYPE_INT_RGB);
				try {
					lightmap = ImageIO.read(getClass().getResource("/mapTest.png"));
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				lightMapPixels = new int[lightmap.getWidth() * lightmap.getHeight()];
				lightmap.getRGB(0,0,lightmap.getWidth(),lightmap.getHeight(),lightMapPixels,0,lightmap.getWidth());
						
				
				pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
			    entities = new ArrayList<Entity>();
			    enemies = new ArrayList<Enemy>();
			    enemies2 = new ArrayList<Enemy2>();
			    enemies3 = new ArrayList<Enemy3>();
			    enemies4 = new ArrayList<Enemy4>();
			    boss1 = new ArrayList<Boss1>();
			    boss2 = new ArrayList<Boss2>();
			    boss3 = new ArrayList<Boss3>();
			    traps = new ArrayList<Trap>();
                buttons = new ArrayList<Button>();
			    bullets = new ArrayList<BulletShoot>();
			    enemyBullets = new ArrayList<EnemyShoot>();
			    attacks = new ArrayList<BillyAttack>();
			    eletronicWalls = new ArrayList<EletronicWall>();
			    spritesheet = new Spritesheet("/spritesheet.png");
			    movements = new Movements("/Movements.png");
			    tiles = new Tiles("/Tiles.png");
			    menuBackground = new MenuBackground("/MenuBackground.png");
			    
			    player = new Player(0,0,16,16,movements.getSprite(0,0,16,16));
			    entities.add(player);
			
			    player2 = new Player2(0,0,16,16,movements.getSprite(0,22*16,16,16));
			    entities.add(player2);
			    
			 //   npc = new FriendlyNpc(0,0,16,16,movements.getSprite(6*16, 3*16, 16, 16));
			    
			    
			    if(texture == "Texture_ONE") {
			    npc = new FriendlyNpc(7*16,7*16,16,16,movements.getSprite(6*16, 3*16, 16, 16));
			    entities.add(npc);
			    }else if(texture == "Texture_TWO") {
			    npc = new FriendlyNpc(7*16,7*16,16,16,movements.getSprite(15*16,  3*16, 16, 16));
				entities.add(npc);	
			    }else if(texture == "Texture_THREE") {
			    npc = new FriendlyNpc(7*16,7*16,16,16,movements.getSprite(6*16,  14*16, 16, 16));
				entities.add(npc);		
			    }else if(texture == "Texture_FOUR") {
			    npc = new FriendlyNpc(7*16,7*16,16,16,movements.getSprite(15*16,  14*16, 16, 16));
				entities.add(npc);	
			    }
			    
			    if(CUR_LEVEL == 6) {
			    	if(texture == "Texture_ONE") {
					    npc = new FriendlyNpc(45*16,78*16,16,16,movements.getSprite(6*16, 3*16, 16, 16));
					    entities.add(npc);
					    }else if(texture == "Texture_TWO") {
					    npc = new FriendlyNpc(45*16,78*16,16,16,movements.getSprite(15*16,  3*16, 16, 16));
						entities.add(npc);	
					    }else if(texture == "Texture_THREE") {
					    npc = new FriendlyNpc(45*16,78*16,16,16,movements.getSprite(6*16,  14*16, 16, 16));
						entities.add(npc);		
					    }else if(texture == "Texture_FOUR") {
					    npc = new FriendlyNpc(45*16,78*16,16,16,movements.getSprite(15*16,  14*16, 16, 16));
						entities.add(npc);		
					    }
			    }
			    //if(Help.textureHasChanged) {
			    //System.out.println("a");
			    //}
			    if(CUR_LEVEL == 11) {
			    	if(texture == "Texture_ONE") {
					    npc = new FriendlyNpc(22*16,22*16,16,16,movements.getSprite(6*16, 3*16, 16, 16));
					    entities.add(npc);
					    }else if(texture == "Texture_TWO") {
					    npc = new FriendlyNpc(22*16,22*16,16,16,movements.getSprite(15*16,  3*16, 16, 16));
						entities.add(npc);	
					    }else if(texture == "Texture_THREE") {
					    npc = new FriendlyNpc(22*16,22*16,16,16,movements.getSprite(6*16,  14*16, 16, 16));
						entities.add(npc);		
					    }else if(texture == "Texture_FOUR") {
					    npc = new FriendlyNpc(22*16,22*16,16,16,movements.getSprite(15*16,  14*16, 16, 16));
						entities.add(npc);		
					    }
			    }
			    
			    
			  //  if(Player.StartNewGame) {
			    	world = new World("/Level_Cutscene1.png");
			   // }
			    
			    
			    minimap = new BufferedImage(World.WIDTH, World.HEIGHT, BufferedImage.TYPE_INT_RGB);
			    minimapPixels = ((DataBufferInt)minimap.getRaster().getDataBuffer()).getData();
			    
			    menu = new Menu();
			    controls = new Help();
			    settings = new Settings();
			    store = new Store();
			    
			    try {
					newFont = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(80f);
				} catch (FontFormatException e) {
				
					e.printStackTrace();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			    
			    try {
					newFont2 = Font.createFont(Font.TRUETYPE_FONT, stream2).deriveFont(80f);
				} catch (FontFormatException e) {
				
					e.printStackTrace();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			    
 			}
			private void initFrame() {
				frame = new JFrame(/*Nome da janela*/"A lot of Rebellions!");
				frame.add(this);
				frame.setResizable(false);
				frame.pack();
				
				Image imagem = null;
				try {
				imagem = ImageIO.read(getClass().getResource("/frameIcon.png"));
				}catch(IOException e) {
					e.printStackTrace();
				}
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image image = toolkit.getImage(getClass().getResource("/cursorIcon.png"));
				Cursor c = toolkit.createCustomCursor(image, new Point(0,0), "img");
				frame.setCursor(c);
				frame.setIconImage(imagem);
				frame.setAlwaysOnTop(true);
				
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
			public synchronized void start() {
				thread = new Thread(this);
				isRunning = true;
				thread.start();
				
			}
			public synchronized void stop() {
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				isRunning = false;
				
			}
			public static void main(String[] args) {
				Game game = new Game();
			    game.start();
			}
			public void tick() {


				
	//			System.out.println(Game.entities.size());
		//		if(menu.pause) {
		//		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		//		}
				
				if(Game.CUR_LEVEL != 5 && Game.CUR_LEVEL != 10 && Game.CUR_LEVEL != 15) {
					this.BossMessageAppears = true;
				}
				
				if(BossMessageAppears) {
				if(CUR_LEVEL == 5 || CUR_LEVEL == 10 || CUR_LEVEL == 15) {
					this.BossMessageShow = true;
					
				}
				}
				
			/*	if(this.texture == "Texture_ONE") {
					this.positionPlayerImage = 0;
				}
				else if(this.texture == "Texture_TWO") {
					this.positionPlayerImage = 9*16;
				}*/
				
				if(this.saveGame) {
					this.saveGame = false;
					String[] opt1 = {"level","life","stock","coins"};
					int[] opt2 = {this.CUR_LEVEL, (int) player.life, player.stock, player.coins};
				 /*	if(Player.hasTexture2) {
				        coinsSpent += 50;
					}if(Player.hasTexture3) {
					    coinsSpent += 75;	
					}if(Player.hasTexture4) {
					    coinsSpent += 100;
					}*/
					Menu.saveGame(opt1,opt2,10);
					//System.out.println("a");
				}
				
				if(this.gameState == "Normal") {
					
					
					if(Game.currentStateScene == playing) {
						
					
				for(int i = 0; i < entities.size(); i++) {
				
					Entity e = entities.get(i);
					if(!(e instanceof Player2)) {
					e.tick();
					}else {
						if(numberOfPlayers == 2) {
							e.tick();
						}
					}
				}
				for(int i = 0; i < bullets.size(); i ++) {
					bullets.get(i).tick();
				}
				for(int i = 0; i < enemyBullets.size(); i ++) {
					enemyBullets.get(i).tick();
				}
				for(int i = 0; i < attacks.size(); i ++) {
					attacks.get(i).tick();
			    }
					}else {
						if(Game.currentStateScene == entering) {
							if(player.getX() < 6*19) {
								player.x++;
								
								player.frames++;
								if(player.frames == player.maxFrames) {
									player.frames = 0;
									player.index++;
									if(player.index > player.maxIndex)
										player.index = 0;
									
								}
								
								
							}else {
								if(player.getY() < 6*16 -5) {
									player.y++;
									
									player.frames++;
									if(player.frames == player.maxFrames) {
										player.frames = 0;
										player.index++;
										if(player.index > player.maxIndex)
											player.index = 0;
									}
										
								}else {
									
									//npc.ShowMessage = true;
									ShowMessageNpc1 = true;
									
									
									
									
									//Game.currentStateScene = start;
									
									
								}
							}
						/*	if(player.getY() > 10*Game.SCALE) {
								player.y--;
							}else {
								Game.currentStateScene = playing;
							}*/
							if(Game.CUR_LEVEL == 0) {
							
							if(ShowMessageNpc1) {
								
								if(select) {
									currentStateScene = playing;
									Game.CUR_LEVEL = 1;
									fraseIndex = 0;
									this.ShowMessageNpc1 = false;
								//	System.out.println("Started");
								}
								
								this.timeMsg++;
								if(timeMsg >= maxTimeMsg) {
									
								timeMsg = 0;
								
								if(Game.language == "English") {
								
								if(curIndexMsg < npc.frases[fraseIndex].length()) {
									
									if(fraseIndex != 4) {
										curIndexMsg++;
									}
									
									
									if(fraseIndex == 4) {
										curIndexMsg++;
									if(curIndexMsg >= npc.frases[4].length() - 10) {
										curIndexMsg = npc.frases[4].length() - 10;
										
										
										
									}
									}
								
									
								}else {
									if(fraseIndex < npc.frases.length) {
										if(fraseIndex <= 3) {
											fraseIndex++;
											
										}else if(fraseIndex == 4) {
											showContinueButton = true;
											
											
											
										}
									
									curIndexMsg =  0;
									}
								
								
								}
								
								}else if(Game.language == "Portugu�s") {
									if(curIndexMsg < npc.frasesPT[fraseIndex].length()) {
										
										if(fraseIndex != 4) {
											curIndexMsg++;
										}
										
										
										if(fraseIndex == 4) {
											curIndexMsg++;
										if(curIndexMsg >= npc.frasesPT[4].length() - 10) {
											curIndexMsg = npc.frasesPT[4].length() - 10;
											
											
											
										}
										}
									
										
									}else {
										if(fraseIndex < npc.frasesPT.length) {
											if(fraseIndex <= 3) {
												fraseIndex++;
												
											}else if(fraseIndex == 4) {
												showContinueButton = true;
												
												
												
											}
										
										curIndexMsg =  0;
										}
									
									
									}
								}
								
								}
							}
							
							
							} else if(Game.CUR_LEVEL == 6) {
								
								if(ShowMessageNpc1) {
									
									this.timeMsg++;
									if(timeMsg >= maxTimeMsg) {
										
									timeMsg = 0;
									
									
									
									if(curIndexMsg < npc.frases[fraseIndex].length()) {
										
										if(fraseIndex != 4) {
											curIndexMsg++;
										}
										
										
										if(fraseIndex == 4) {
											curIndexMsg++;
										if(curIndexMsg >= npc.frases[4].length() - 10) {
											curIndexMsg = npc.frases[4].length() - 10;
											
											if(select) {
												currentStateScene = playing;
												Game.CUR_LEVEL = 1;
												fraseIndex = 0;
												this.ShowMessageNpc1 = false;
											//	System.out.println("Started");
											}
											
										}
										}
									
										
									}else {
										if(fraseIndex < npc.frases.length) {
											if(fraseIndex <= 3) {
												fraseIndex++;
												
											}else if(fraseIndex == 4) {
												showContinueButton = true;
												
												
												
											}
										
										curIndexMsg =  0;
										}
									
									
									}
									
									
									
									}
								}
								
								
							}
							
						}
						
						
						
					}
				if(player.StartNewGame || player.StartNewGame == false) {
				if(CUR_LEVEL < 5) {
				if(enemies.size() == 0) {
					CUR_LEVEL++;
					Game.bullets.clear();
				    String newWorld = "Level"+CUR_LEVEL+".png";
					World.restartGame(newWorld);
				}
				}else if(CUR_LEVEL == 6 || CUR_LEVEL == 9) {
					if(enemies.size() == 0 && enemies2.size() == 0) {
						CUR_LEVEL ++;
						
						
							if(CUR_LEVEL > this.MAX_LEVEL) {
								CUR_LEVEL = 1;
							}
							Game.bullets.clear();
						String newWorld = "Level"+CUR_LEVEL+".png";
						World.restartGame(newWorld);	
				}
			    }else if(CUR_LEVEL == 5) {
					if(boss1.size() == 0) {
						CUR_LEVEL++;
							
						Player.stock = 3;
						
						if(CUR_LEVEL > this.MAX_LEVEL) {
							CUR_LEVEL = 1;
						}
						Game.bullets.clear();
						String newWorld = "Level"+CUR_LEVEL+".png";
						World.restartGame(newWorld);	
				}
			    }else if(CUR_LEVEL == 7 || CUR_LEVEL == 8 ) {
			    	if(enemies2.size() == 0) {
						CUR_LEVEL ++;
							
						if(CUR_LEVEL > this.MAX_LEVEL) {
							CUR_LEVEL = 1;
						}
						Game.bullets.clear();
						String newWorld = "Level"+CUR_LEVEL+".png";
						World.restartGame(newWorld);	
			    }
			    }else if(this.CUR_LEVEL == 10) {
			    	if(boss2.size() == 0) {
						CUR_LEVEL++;
						
						Player.stock = 3;
							
						if(CUR_LEVEL > this.MAX_LEVEL) {
						//	gameState =  "PlayerWon";
							this.CUR_LEVEL = 1;
						}
						Game.bullets.clear();
						String newWorld = "Level"+CUR_LEVEL+".png";
						World.restartGame(newWorld);
			    }
			    }else if(this.CUR_LEVEL >= 11 && CUR_LEVEL < 15) {
			    	if(enemies3.size()+enemies4.size() == 0) {
                        CUR_LEVEL++;
                        
						
						if(CUR_LEVEL > this.MAX_LEVEL) {
							//	gameState =  "PlayerWon";
								this.CUR_LEVEL = 1;
							}
						Game.bullets.clear();
						String newWorld = "Level"+CUR_LEVEL+".png";
						World.restartGame(newWorld);
			    	}
			    }else if(this.CUR_LEVEL == 15) {
			    	if(boss3.size() == 0) {
                        CUR_LEVEL ++;
                        
                        Player.stock = 3;
						
						if(CUR_LEVEL > this.MAX_LEVEL) {
							//	gameState =  "PlayerWon";
								this.CUR_LEVEL = 1;
							}
						Game.bullets.clear();
						String newWorld = "Level"+CUR_LEVEL+".png";
						World.restartGame(newWorld);
			    	}
			    }
				}
				}else if(gameState == "GameOver") {
					this.framesGameOver++;
					if(this.framesGameOver > 20) {
						this.framesGameOver = 0;
						if(this.ShowMessageGameOver == true) {
							this.ShowMessageGameOver = false;
						}else {
							this.ShowMessageGameOver = true;
						}
						
					}
				}else if(gameState == "Menu") {
					menu.tick();
				}else if(gameState == "Controls") {
					controls.tick();
				}else if(gameState == "Settings") {
					settings.tick();
				}else if(gameState == "Store"){
				    store.tick();
			    }else if(gameState == "PlayerWon") {
					
					this.framesWin++;
					if(this.framesWin > 20) {
						this.framesWin = 0;
						if(this.ShowMessageWin == true) {
							this.ShowMessageWin = false;
						}else {
							this.ShowMessageWin = true;
						}
						
					}
					
				}
			}
			
			
		/*	public void drawRectangleExample() {
				
				for(int xx = 0; xx < 32; xx++) {
					
					
					for(int yy = 0; yy <32; yy++) {
						
						pixels[xx + (yy*WIDTH)] = 0xff0000;
						
					}
					
				}
				
				
			}	
			*/	
				
	/*		public void applyLight() {
				for(int xx = 0; xx < 240; xx++) {
					for(int yy = 0;  yy < 160; yy++) {
						if(lightMapPixels[xx + (yy * 240)] == 0xffffffff) {
							pixels[xx + (yy*160)] = 0x000000;
							
						}
					}
					
				}
			}
			
			
		*/	
			public void render() {
				BufferStrategy bs = this.getBufferStrategy();
				if(bs == null) {
					this.createBufferStrategy(3);
					return;
				}
				Graphics g = image.getGraphics();
			//	g.setColor(new Color(0/*Vermelho*/,0/*Verde*/,100/*Azul*/));
				g.setColor(new Color(0,0,0));
				g.fillRect(0, 0, 317, 191);
			//drawRectangleExample();
				
			/*	g.setFont(new Font("Arial",Font.ITALIC,20));
				g.setColor(Color.orange);
				g.drawString("Welcome to", 40, 60);
				
				g.setFont(new Font("Arial",Font.ROMAN_BASELINE,35));
				g.setColor(Color.WHITE);
				g.drawString("Kingdom's", 90, 110);
				g.drawString("Fury", 120, 140);                     */
				
				/*Renderiza��o do jogo*/
				world.render(g);
				Collections.sort(entities, Entity.nodeSorter);
		//		lightingSystem.render_1(g);	
				for(int i = 0; i < entities.size(); i++) {
					Entity e = entities.get(i);
					if(!(e instanceof Player2)) {
					e.render(g);
					}else {
						if(numberOfPlayers == 2) {
							e.render(g);
						}
					}
				}
					for(int i = 0; i < bullets.size(); i ++) {
						bullets.get(i).render(g);
					
				}
					for(int i = 0; i < enemyBullets.size(); i ++) {
						enemyBullets.get(i).render(g);
					
				}
					for(int i = 0; i < attacks.size(); i ++) {
						attacks.get(i).render(g);
				}
		//	    applyLight();
					
				
				ui.render(g);
				
				
				
				/**********************/
	/*			g.setColor(Color.WHITE);
				g.fillPolygon(0, 0, 60, 80);
				
	       		g.setColor(Color.lightGray);
				g.fillOval(0, 0, 30, 40);
				
				g.setColor(Color.RED);
				g.fillOval(0, 0, 15, 20);*/
				g.dispose();
				g = bs.getDrawGraphics();
				g.drawImage(image, 0, 0,WIDHT*SCALE,HEIGHT*SCALE,null);
				
				
				
				if(ShowMessageNpc1) {
					g.setColor(new Color(50,50,50, 180));
					g.fillRect(0, 100*Game.SCALE, Game.WIDHT*Game.SCALE, 60*Game.SCALE);
					g.setColor(Color.white);
					g.fillRect(0, 100*Game.SCALE, Game.WIDHT*Game.SCALE, 1*Game.SCALE);
					g.drawImage(Entity.FRIENDLY_NPC, 170*Game.SCALE, 75*Game.SCALE, 256, 256, null);
					g.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
					if(Game.language == "English") {
					g.drawString("to skip", 160, 149*Game.SCALE);
					g.drawString(npc.frases[fraseIndex].substring(0, curIndexMsg), 10, 110*Game.SCALE);
					}else if(Game.language == "Portugu�s") {
						g.drawString("para ignorar", 160, 149*Game.SCALE);
						g.drawString(npc.frasesPT[fraseIndex].substring(0, curIndexMsg), 10, 110*Game.SCALE);	
					}
					g.drawImage(Entity.J_KEY, 50, 110*Game.SCALE, 128, 128, null);
					
					if(fraseIndex == 4) {
						if(Game.language == "English") {
					 if(curIndexMsg >= (npc.frases[4].length() - 10)) {
						 g.drawString(npc.frases[4], 10, 110*Game.SCALE);
					 }
						
						 
					 }else if(Game.language == "Portugu�s") {
						 if(curIndexMsg >= (npc.frasesPT[4].length() - 10)) {
							 g.drawString(npc.frasesPT[4], 10, 110*Game.SCALE);
						 } 
					 }
					}
					
				}
				
						 
					/*	 g.setColor(Color.red);
						 g.setFont(new Font("Arial", Font.BOLD, 20));
						 g.drawString("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", 20, 10); */
					    	
					   /* 	g.setColor(new Color(50,50,50, 180));
							g.fillRect(0, 100*Game.SCALE, Game.WIDHT*Game.SCALE, 60*Game.SCALE);
							g.setColor(Color.white);
							g.fillRect(0, 100*Game.SCALE, Game.WIDHT*Game.SCALE, 1*Game.SCALE);
							if(Game.texture == "Texture_ONE") {
							g.drawImage(Entity.FRIENDLY_NPC, 170*Game.SCALE, 75*Game.SCALE, 256, 256, null);
							}else if(Game.texture == "Texture_TWO") {
							g.drawImage(Entity.FRIENDLY_NPC_TEXTURE2, 170*Game.SCALE, 75*Game.SCALE, 256, 256, null);	
							}else if(Game.texture == "Texture_THREE") {
							g.drawImage(Entity.FRIENDLY_NPC_TEXTURE3, 170*Game.SCALE, 75*Game.SCALE, 256, 256, null);	
							}
							g.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
							g.drawString(npc.frases2_Texture1[fraseIndex].substring(0, curIndexMsg), 10, 110*Game.SCALE);
							if(fraseIndex == 4) {
							 if(curIndexMsg >= (npc.frases2_Texture1[4].length() - 10)) {
								 g.drawString(npc.frases2_Texture1[4], 10, 110*Game.SCALE);
								 g.drawImage(Entity.J_KEY, 50, 110*Game.SCALE, 128, 128, null);
								 
							 }
							} */
					 
				
				
				if(gameState == "GameOver") {
					Graphics2D g2 = (Graphics2D) g;
					g2.setColor(new Color(0,0,100,200));
					g2.fillRect(0, 0, 240*3, 160*3);
					g2.setColor(new Color(255,255,255,255));
					g2.setFont(new Font("Arial",Font.ITALIC, 30));	
					
	         		g2.drawString("G A M E    O V E R",(WIDHT*SCALE) / 2 - 130,(HEIGHT*SCALE) / 2);
	         		g2.setFont(new Font("Arial",Font.BOLD, 20));
	         		if(ShowMessageGameOver) {
			        g2.drawString("Try again?", (WIDHT*SCALE) / 2 - 130,(HEIGHT*SCALE) / 2 + 50);
			        g2.drawString("> Enter:  Yes", (WIDHT*SCALE) / 2 - 130,(HEIGHT*SCALE) / 2 + 90);
			        g2.drawString("> Backspace:  No", (WIDHT*SCALE) / 2 - 130,(HEIGHT*SCALE) / 2 + 110);
	         		}
	         		
	         		
	         	//	gameOver.render(g);
	         		
				}else if(gameState == "PlayerWon") {
					Graphics2D g2 = (Graphics2D) g;
					g2.setColor(new Color(0,0,100,200));
					g2.fillRect(0, 0, 240*3, 160*3);
					g2.setColor(new Color(255,255,255,255));
					g2.setFont(new Font("Arial",Font.ITALIC, 30));	
					
					g2.drawString("C O N G R A T U L A T I O N S",(WIDHT*SCALE) / 2 - 130,(HEIGHT*SCALE) / 2);
					
					g2.setColor(new Color(255,204,51,200));
					g2.setFont(new Font("Arial",Font.BOLD, 25));	
					
					g2.drawString("You Win!",(WIDHT*SCALE) / 2 - 130,(HEIGHT*SCALE) / 2);
                    
					
					g2.setFont(new Font("Arial",Font.BOLD, 20));
	         		if(ShowMessageWin) {
			        g2.drawString("Try again?", (WIDHT*SCALE) / 2 - 130,(HEIGHT*SCALE) / 2 + 50);
			        g2.drawString("> Enter:  Yes", (WIDHT*SCALE) / 2 - 130,(HEIGHT*SCALE) / 2 + 90);
			        g2.drawString("> Backspace:  No", (WIDHT*SCALE) / 2 - 130,(HEIGHT*SCALE) / 2 + 110);
			        
	         		} 
				}else if(gameState == "Menu") {
					menu.render(g);
				}else if(gameState == "Controls") {
					controls.render(g);
				}else if(gameState == "Settings") {
					settings.render(g);
				}else if(gameState == "Store"){
				    store.render(g);
			    }
			/*	Graphics2D g2 = (Graphics2D) g;
				
				double angleMouse = Math.atan2(mouseY -200 +40, mouseX-200+40);
				
				g2.rotate(angleMouse, 200+40, 200+40);
				g2.setColor(new Color(255,160,160));
				g2.fillRect( 200, 200, 80, 80); */
				
				
				
				
				/*Para digitar um texto n�o pixelado, nesse local digite:
				  g.setColor();
				  g.drawString(***,int,int)*/
				//System.out.println(World.WIDTH+" x "+World.HEIGHT);
				
				if(ShowMessageNpc1 == false && npc.ShowMessage == false) {
				
					if(showMinimap) {
						
						g.setColor(new Color(80,80,80, 180));
						g.fillRect(0, 0, 240*3, 160*3);
						
				if(Game.gameState == "Normal") {
					if(Game.CUR_LEVEL < 4) {
						//20*20
				int multiply = 10;
				int minimapPositionX = 240*3/2 - 100;
				int minimapPositionY = 160*3/2 - 60;
				//int minimapPositionX = 615;
				//int minimapPositionY = 375;
				
				World.renderMinimap();
				g.drawImage(minimap, minimapPositionX, minimapPositionY, World.WIDTH*multiply, World.HEIGHT*multiply, null);
					}
					else if(Game.CUR_LEVEL == 4 || Game.CUR_LEVEL == 11 || Game.CUR_LEVEL == 13 || Game.CUR_LEVEL == 15) {
						//40*40
						int multiply = 7;
						int minimapPositionX = 240*3/2 - 130;
						int minimapPositionY = 160*3/2 - 100;
						
						World.renderMinimap();
						g.drawImage(minimap, minimapPositionX, minimapPositionY, World.WIDTH*multiply, World.HEIGHT*multiply, null);
					}
					else if(Game.CUR_LEVEL == 5 || Game.CUR_LEVEL == 7) {
						//30*30
						int multiply = 7;
						int minimapPositionX = 240*3/2 - 100;
						int minimapPositionY = 160*3/2 - 60;
						
						World.renderMinimap();
						g.drawImage(minimap, minimapPositionX, minimapPositionY, World.WIDTH*multiply, World.HEIGHT*multiply, null);
					}
					else if(Game.CUR_LEVEL == 6) {
						//80*80
						int multiply = 3;
						int minimapPositionX = 240*3/2 - 100;
						int minimapPositionY = 160*3/2 - 80;
						
						World.renderMinimap();
						g.drawImage(minimap, minimapPositionX, minimapPositionY, World.WIDTH*multiply, World.HEIGHT*multiply, null);
					}
					else if(Game.CUR_LEVEL == 8) {
						//50*70
						int multiply = 5;
						int minimapPositionX = 240*3/2 - 100;
						int minimapPositionY = 160*3/2 - 140;
						
						World.renderMinimap();
						g.drawImage(minimap, minimapPositionX, minimapPositionY, World.WIDTH*multiply, World.HEIGHT*multiply, null);
					}
					else if(Game.CUR_LEVEL == 9) {
						//80*30
						int multiply = 5;
						int minimapPositionX = 240*3/2 - 200;
						int minimapPositionY = 160*3/2 - 80;
						
						World.renderMinimap();
						g.drawImage(minimap, minimapPositionX, minimapPositionY, World.WIDTH*multiply, World.HEIGHT*multiply, null);
					}
					else if(Game.CUR_LEVEL == 10) {
						//60*60
						int multiply = 4;
						int minimapPositionX = 240*3/2 - 120;
						int minimapPositionY = 160*3/2 - 120;
						
						World.renderMinimap();
						g.drawImage(minimap, minimapPositionX, minimapPositionY, World.WIDTH*multiply, World.HEIGHT*multiply, null);
					}
					else if(Game.CUR_LEVEL == 12) {
						//80*20
						int multiply = 5;
						int minimapPositionX = 240*3/2 - 200;
						int minimapPositionY = 160*3/2 - 60;
						
						World.renderMinimap();
						g.drawImage(minimap, minimapPositionX, minimapPositionY, World.WIDTH*multiply, World.HEIGHT*multiply, null);
					}
					else if(Game.CUR_LEVEL == 14) {
						//20*120
						int multiply = 3;
						int minimapPositionX = 240*3/2 - 30;
						int minimapPositionY = 160*3/2 - 140;
						
						World.renderMinimap();
						g.drawImage(minimap, minimapPositionX, minimapPositionY, World.WIDTH*multiply, World.HEIGHT*multiply, null);
					}
					
					
						
				
				
				}
					}
				
				}
				bs.show();
				
				
				
			}
			public void run() {
				long lastTime = System.nanoTime();
				double amountOfTicks = 60.0;
				double ns = 1000000000 / amountOfTicks;
				double delta = 0;
				int frames = 0;
				requestFocus();
				double timer = System.currentTimeMillis();
			    while(isRunning) {
			   // 	System.out.println("Est� rodando.");
			    	long now = System.nanoTime();
			    	delta+= (now - lastTime) / ns;
			    	lastTime = now;
			    	if(delta >= 1) {
			    		tick();
			    		render();
			    		frames++;
			    		delta--;
			    	}
			    	
					if(System.currentTimeMillis() - timer >= 1000){
			    	System.out.println("FPS: " + frames);
			    	frames = 0;
			    	timer += 1000;
			    }
				
			}
			    stop();

			
	}
			@Override
			public void keyPressed(KeyEvent e) {
				if(numberOfPlayers == 1) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
					
					if(gameState == "Normal") {
						player.right = true;
						}else if(gameState == "Settings") {
						settings.right = true;
						}
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
					if(gameState == "Normal") {
					player.left = true;
					}else if(gameState == "Settings") {
						settings.left = true;
					}
					
				}
				if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
					player.up = true;
					if(gameState == "Menu") {
						menu.up = true;
					}else if(gameState == "Controls") {
						controls.up = true;
					}else if(gameState == "Settings") {
						settings.up = true;
					}else if(gameState == "Store") {
						store.up = true;
					}
				}
				else if/*Se quisermos que o jogador ande, por exemplo, para o lado e para cima, ao mesmo tempo(diagonal), n�o se pode deixar "else if" e sim "if" onde se pode combinar*/(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
					player.down = true;
					if(gameState == "Menu") {
						menu.down = true;
					}else if(gameState == "Controls") {
						controls.down = true;
					}else if(gameState == "Settings") {
						settings.down = true;
					}else if(gameState == "Store") {
						store.down = true;
					}

					
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					player.jump = true;
				}
				
				
				if(e.getKeyCode() == KeyEvent.VK_J || e.getKeyCode() == KeyEvent.VK_C) {
						player.shoot = true;
					if(gameState == "Menu" || gameState == "Controls" || gameState == "Settings" || gameState == "Store" || /*Game.CUR_LEVEL == 0 && */(this.currentStateScene == this.entering && this.ShowMessageNpc1 == true) || ((Game.CUR_LEVEL == 6 || Game.CUR_LEVEL == 11) && npc.ShowMessage == true)) {
						select = true;
						//Game.language = "Portugu�s";
						
						
					//	System.out.println("a");
					}
					
				}
				
				if(e.getKeyCode() == KeyEvent.VK_B || e.getKeyCode() == KeyEvent.VK_L) {
					Player.playerIsRunning = true;
				}
				}else if(numberOfPlayers == 2) {
					if(e.getKeyCode() == KeyEvent.VK_D) {
						
						if(gameState == "Normal") {
							player2.right = true;
							}else if(gameState == "Settings") {
							settings.right = true;
							}
					}
					else if(e.getKeyCode() == KeyEvent.VK_A) {
						if(gameState == "Normal") {
						player2.left = true;
						}else if(gameState == "Settings") {
							settings.left = true;
						}
						
					}
					if(e.getKeyCode() == KeyEvent.VK_W) {
						player2.up = true;
						if(gameState == "Menu") {
							menu.up = true;
						}else if(gameState == "Controls") {
							controls.up = true;
						}else if(gameState == "Settings") {
							settings.up = true;
						}else if(gameState == "Store") {
							store.up = true;
						}
					}
					else if(e.getKeyCode() == KeyEvent.VK_S) {
						player2.down = true;
						if(gameState == "Menu") {
							menu.down = true;
						}else if(gameState == "Controls") {
							controls.down = true;
						}else if(gameState == "Settings") {
							settings.down = true;
						}else if(gameState == "Store") {
							store.down = true;
						}

						
					}
					
					if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						player.right = true;
					}
					else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						player.left = true;
					}
					if(e.getKeyCode() == KeyEvent.VK_UP) {
						player.up = true;
					}
					else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
						player.down = true;
					}
					
					
					
					if(e.getKeyCode() == KeyEvent.VK_SPACE) {
						player.jump = true;
					}
					
					if(e.getKeyCode() == KeyEvent.VK_X) {
						player2.jump = true;
					}
					
					
					if(e.getKeyCode() == KeyEvent.VK_J) {
							player2.shoot = true;
						if(gameState == "Menu" || gameState == "Controls" || gameState == "Settings" || gameState == "Store" || /*Game.CUR_LEVEL == 0 && */(this.currentStateScene == this.entering && this.ShowMessageNpc1 == true) || ((Game.CUR_LEVEL == 6 || Game.CUR_LEVEL == 11) && npc.ShowMessage == true)) {
							select = true;
							//Game.language = "Portugu�s";
							
							
						//	System.out.println("a");
						}
						
					}
					if(e.getKeyCode() == KeyEvent.VK_C) {
						player.shoot = true;
					}
					
					if(e.getKeyCode() == KeyEvent.VK_L) {
						Player.playerIsRunning = true;
					}
					
					if(e.getKeyCode() == KeyEvent.VK_B) {
						Player2.playerIsRunning = true;
					}
				}
				if(gameState == "Menu" || gameState == "Controls" || gameState == "Settings" || gameState == "Store" || /*Game.CUR_LEVEL == 0 && */(this.currentStateScene == this.entering && this.ShowMessageNpc1 == true) || ((Game.CUR_LEVEL == 6 || Game.CUR_LEVEL == 11) && npc.ShowMessage == true)) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						select = true;
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if(gameState == "Normal") {
					if(!menu.pause) {
					gameState = "Menu";
					menu.pause = true;
					}
					}
					else if(menu.pause) {
					gameState = "Normal";
					menu.pause = false;
					}
				}
				
				
			//	else if(e.getKeyCode() == KeyEvent.VK_K) {
			//		player.atack = true;
		//		}
				
				if(Game.gameState == "GameOver") {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				//		System.out.println("A");
						Player.StartNewGame = true;
						Game.gameState = "Normal";
						CUR_LEVEL = 1;
			
					}
					else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						gameState = "Menu";
						
					}
					
				}else if(Game.gameState == "PlayerWon") {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						//		System.out.println("A");
								Player.StartNewGame = true;
								Game.gameState = "Normal";
								CUR_LEVEL = 1;
					}			
					else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						gameState = "Menu";
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_Q) {
				/*if(gameState == "Menu") {
					this.numberOfPlayers = 2;
				}*/
				
				if(gameState == "Normal") {
					
						this.saveGame = true;
					}
				}
				if(e.getKeyCode() ==  KeyEvent.VK_M) {
					showMinimap = true;
				}
				
				
				}
				
				
				
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(numberOfPlayers == 1) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
					player.right = false;
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
					player.left = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
					player.up = false;
				}
				else if/*Se quisermos que o jogador ande, por exemplo, para o lado e para cima, ao mesmo tempo(diagonal), n�o se pode deixar "else if" e sim "if" onde se pode combinar*/(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
					player.down = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					player.jump = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_J || e.getKeyCode() == KeyEvent.VK_C) {
					player.shoot = false;
				}
				else if(e.getKeyCode() == KeyEvent.VK_B || e.getKeyCode() == KeyEvent.VK_L) {
					Player.playerIsRunning = false;
				}
				}else if(numberOfPlayers == 2) {
					if(e.getKeyCode() == KeyEvent.VK_D) {
						player2.right = false;
					}
					else if(e.getKeyCode() == KeyEvent.VK_A) {
						player2.left = false;
					}
					if(e.getKeyCode() == KeyEvent.VK_W) {
						player2.up = false;
					}
					else if(e.getKeyCode() == KeyEvent.VK_S) {
						player2.down = false;
					}
					
					if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						player.right = false;
					}
					else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						player.left = false;
					}
					if(e.getKeyCode() == KeyEvent.VK_UP) {
						player.up = false;
					}
					else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
						player.down = false;
					}
					
					if(e.getKeyCode() == KeyEvent.VK_SPACE) {
						player.jump = false;
					}
					if(e.getKeyCode() == KeyEvent.VK_X) {
						player2.jump = false;
					}
					
					if(e.getKeyCode() == KeyEvent.VK_C) {
						player.shoot = false;
					}
					if(e.getKeyCode() == KeyEvent.VK_J) {
						player2.shoot = false;
					}
					if(e.getKeyCode() == KeyEvent.VK_B) {
						Player.playerIsRunning = false;
					}
					if(e.getKeyCode() == KeyEvent.VK_L) {
						Player2.playerIsRunning = false;	
					}
				}
				
				if(e.getKeyCode() ==  KeyEvent.VK_M) {
					showMinimap = false;
				}
				
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				player.mouseShoot = true;
				player.mouseX = (e.getX() / 3);
				player.mouseY = (e.getY() / 3);
				
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				this.mouseX = e.getX();
				this.mouseY = e.getY();
				
				
			}


}