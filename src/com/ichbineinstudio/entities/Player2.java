package com.ichbineinstudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.ichbineinstudio.graficos.Spritesheet;
import com.ichbineinstudio.main.Game;
import com.ichbineinstudio.main.Sound;
import com.ichbineinstudio.world.Camera;
import com.ichbineinstudio.world.World;

public class Player2 extends Entity {
	
	public boolean right,left,up,down;
	public static int right_dir = 0, left_dir = 1, up_dir =  2, down_dir = 3;
	public static int dir = right_dir;
	public double speed = 1.4;
	
	public int z = 0;
	
	int timer = 1;
	
	public double life = 100, maxlife = 100;
	public static int stock = 3;
	public static int coins = 0;
	public static boolean StartNewGame = false;
	
	public static boolean renderJump = false;
	
	public int frames = 0;
	public int maxFrames = 5;
	public int index = 0;
	public int maxIndex = 3;
	public boolean moved = false;
	public boolean jump = false;
	public int jumpFrames = 50, jumpCur = 0;
	public static boolean isJumping = false;
	
	public boolean jumpUp = false, jumpDown = false;
	
	public int jumpSpd = 2;
	
	public static boolean playerIsRunning = false;
	
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	private BufferedImage[] upPlayer;
	
	private BufferedImage[] rightPlayer2;
	private BufferedImage[] leftPlayer2;
	private BufferedImage[] upPlayer2;
	
	private BufferedImage[] rightPlayer3;
	private BufferedImage[] leftPlayer3;
	private BufferedImage[] upPlayer3;
	
	private BufferedImage[] rightPlayer4;
	private BufferedImage[] leftPlayer4;
	private BufferedImage[] upPlayer4;
	
	private BufferedImage playerDamage;
	private BufferedImage playerDamage2;
	private BufferedImage playerDamage3;
	private BufferedImage playerDamage4_Face;
	private BufferedImage playerDamage4_Back;
	
	private BufferedImage playerJumping_Face;
	private BufferedImage playerJumping_Back;
	private BufferedImage playerJumping_Face2;
	private BufferedImage playerJumping_Back2;
	private BufferedImage playerJumping_Face3;
	private BufferedImage playerJumping_Back3;
	private BufferedImage playerJumping_Face4;
	private BufferedImage playerJumping_Back4;
	
	public static BufferedImage playerStock;
	public static BufferedImage playerStock2;
	public static BufferedImage playerStock3;
	public static BufferedImage playerStock4;
	
	public static boolean hasGun = false;
    public static boolean hasGun2 = false;
	public static int ammo;
	public static int ammo2;
	
	public boolean shoot =  false;
	public boolean mouseShoot =  false;
	
	public int mouseX, mouseY;
	
	public boolean atack = false;
	
	public boolean ThePressurePlateWasPressed = false;
	
	public boolean isDamaged = false;
	private int DamageFrames = 0;
	
	public static boolean hasTexture2 = false;
	public static boolean hasTexture3 = false;
	public static boolean hasTexture4 = false;

	public Player2(int x, int y, int width, int height, BufferedImage sprite) {
		super(4, 2, 7, 14, sprite);
	
		rightPlayer = new BufferedImage[4];
	    leftPlayer = new BufferedImage[4];
	    upPlayer = new BufferedImage[4];
	    
	    rightPlayer2 = new BufferedImage[4];
	    leftPlayer2 = new BufferedImage[4];
	    upPlayer2 = new BufferedImage[4];
	    
	    rightPlayer3 = new BufferedImage[4];
	    leftPlayer3 = new BufferedImage[4];
	    upPlayer3 = new BufferedImage[4];
	    
	    rightPlayer4 = new BufferedImage[4];
	    leftPlayer4 = new BufferedImage[4];
	    upPlayer4 = new BufferedImage[4];
	    
	    playerDamage = Game.spritesheet.getSprite(7*16, 4*16, 16, 16);
	    playerStock = Game.movements.getSprite(7*16, 26*16, 16, 16);
	    playerJumping_Face = Game.movements.getSprite(6*16, 22*16, 16, 16);
	    playerJumping_Back = Game.movements.getSprite(7*16, 22*16, 16, 16);

	    rightPlayer[0] = Game.movements.getSprite(0, 22*16, 16, 16);
	    rightPlayer[1] = Game.movements.getSprite(16, 22*16, 16, 16);
	    rightPlayer[2] = Game.movements.getSprite(32, 22*16, 16, 16);
	    rightPlayer[3] = Game.movements.getSprite(48, 22*16, 16, 16);
	    
	   
	 //    for(int i = 0; i < 4; i++) {
	 //   rightPlayer[0] = Game.movements.getSprite(32 + (i*16), 0, 16, 16);
	 //}
	 //   for(int i = 0; i < 4; i++) {
	 //   leftPlayer[0] = Game.movements.getSprite(32 + (i*16), 16, 16, 16);
	    
	    upPlayer[0] = Game.movements.getSprite(64, 22*16, 16, 16);
	    upPlayer[1] = Game.movements.getSprite(64, 23*16, 16, 16);
	    upPlayer[2] = Game.movements.getSprite(80, 22*16, 16, 16);
	    upPlayer[3] = Game.movements.getSprite(80, 23*16, 16, 16);
	    
	/*    downBilly = Game.spritesheet.getSprite(4*16,5*16,16,16);
	    rightBilly = Game.spritesheet.getSprite(6*16, 5*16, 16, 16);
	    leftBilly = Game.spritesheet.getSprite(5*16, 5*16, 16, 16);
	    upBilly = Game.spritesheet.getSprite(3*16, 5*16, 16, 16); */
	 //   }
	}
	public void tick() {
		depth = 2;
		moved = false;
		
		if(this.playerIsRunning) {
			speed = 1.9;
		}else if(this.playerIsRunning == false) {
			speed = 1.4;
		}
		
		if(jump) {
			jump = false;
			if(isJumping == false){
				
			//	System.out.println("A");
			isJumping = true;
			jumpUp = true;
			}
		}
		if(isJumping == true) {
			
		//	if(jumpCur < jumpFrames) {
				if(jumpUp) {
				    jumpCur+=jumpSpd;
				    renderJump = true;
				}else if(jumpDown) {
					jumpCur-=(jumpSpd+0.5);
					if(jumpCur <= 0) {
						isJumping = false;
						jumpUp = false;
						jumpDown = false;
					}
				}
				z = jumpCur;
				
				if(jumpCur >= jumpFrames) {
					jumpUp = false;
					jumpDown = true;
					renderJump = false;
				//	System.out.println("abc");
				}
		//	}
			
			
		}
		
		if(right) {
			dir = right_dir;
		 if(World.isFree((int)(x+1.9),this.getY())) {
			moved = true;
			x+=speed;
		}
		}else if(left) {
			dir = left_dir;
		 if(World.isFree((int)(x-1.9),this.getY())) {
			moved = true;
			x-=speed;
		}
		} if(up) {
			dir = up_dir;
		 if(World.isFree(this.getX(),(int)(y-1.9))) { 
			moved = true;
			y-=speed;
		}
		}else if(down) {
			dir = down_dir;
		 if(World.isFree(this.getX(),(int)(y+1.9))) { 
			moved = true;
			y+=speed;	
	    }
		}
		if (moved) {
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex)
					index = 0;
				
			}
		}
		
		
		this.checkCollisionLifePack();
			this.checkCollisionBullet();
			    this.checkCollisionGun();
			       this.collidingBullet();
			        this.checkCollisionPressurePlate();
	/*              this.checkCollisionBilly();
			        
		  if(atack) {
			  atack = false;
			        if(hasBilly) {
			        	int dx2 = 1;
			        	int dy2 = 1;
			        	int px2 = 5;
			        	int py2 = 5;
			        	if(dir == right_dir) {
			        		px2 = 0;
			        		py2 = 0;
			        		BillyAttack attack = new BillyAttack(this.getX()+px2,this.getY()+py2,0,0,Entity.RIGHT_BILLY,dx2,dy2);
					        Game.attacks.add(attack);
				    	}
				    	else if(dir == down_dir){
				    		BillyAttack attack = new BillyAttack(this.getX()+px2,this.getY()+py2,0,0,Entity.DOWN_BILLY,dx2,dy2);
					        Game.attacks.add(attack);
				    	}
				    	else if(dir == up_dir){
				    		BillyAttack attack = new BillyAttack(this.getX()+px2,this.getY()+py2,0,0,Entity.UP_BILLY,dx2,dy2);
					        Game.attacks.add(attack);
				    	}
				    	else if(dir == left_dir){
				    		BillyAttack attack = new BillyAttack(this.getX()+px2,this.getY()+py2,0,0,Entity.LEFT_BILLY,dx2,dy2);
					        Game.attacks.add(attack);
				    	}
			        	BillyAttack attack = new BillyAttack(this.getX()+px2,this.getY()+py2,0,0,Entity.BILLY_EN,dx2,dy2);
				        Game.attacks.add(attack);
			        }
			    } */
			   
			    if(shoot) {
			    	shoot = false;
			    	if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO" || Game.texture == "Texture_THREE") {
			    		if(!isJumping) {
					    	if(hasGun && ammo > 0) {
					    	ammo--;
					    	int dx = 0;
					    	int dy = 0;
					    	int px = 11;
					    	int py = 7;
					    	
					    	if(dir == right_dir) {
					    		 dx = 1;
					    	}
					    	else if(dir == down_dir){
					    		 dy = 1;
					    		 px = 6;
					    		 py = 8;
					    	}
					    	else if(dir == up_dir){
					    		 dy = -1;
					    		 px = 3;
					    		 py = 2;
					    	}
					    	else if(dir == left_dir){
					    		 dx = -1;
					    		 px = 1;
					    		 py = 7;
					    	}
					    	BulletShoot bullet = new BulletShoot(this.getX()+px,this.getY()+py,3,3,null,dx,dy);
					        Game.bullets.add(bullet);
					    	}
					    	}
			    	}else if(Game.texture == "Texture_FOUR") {
			    		if(!isJumping) {
					    	if(hasGun && ammo > 0) {
					    	ammo--;
					    	int dx = 0;
					    	int dy = 0;
					    	int px = 11;
					    	int py = 7;
					    	
					    	if(dir == right_dir) {
					    		 dx = 1;
					    		 px = 14;
					    		 py = 5;
					    	}
					    	else if(dir == down_dir){
					    		 dy = 1;
					    		 px = 6;
					    		 py = 8;
					    	}
					    	else if(dir == up_dir){
					    		 dy = -1;
					    		 px = 3;
					    		 py = 2;
					    	}
					    	else if(dir == left_dir){
					    		 dx = -1;
					    		 px = -2;
					    		 py = 5;
					    	}
					    	BulletShoot bullet = new BulletShoot(this.getX()+px,this.getY()+py,3,3,null,dx,dy);
					        Game.bullets.add(bullet);
					    	}
					    	}
			    	}
			    	
			    }
			    
		/*	    if(mouseShoot) {
			    	mouseShoot = false;
			    	double angle = Math.toDegrees(Math.atan2(mouseY - (this.getY()+8 - Camera.y), mouseX - (this.getX()+8 - Camera.x)));
			 //   	System.out.println(angle);
			    	if(!isJumping) {
			    	if(hasGun && ammo > 0) {
			    //	ammo--;
			    	
			    	
			    	
			    	
			    	double dx = Math.cos(angle);
			    	double dy = Math.sin(angle);
			    	int px = 11;
			    	int py = 7;
			    	
			/*    	if(dir == right_dir) {
			    		 dx = 1;
			    	}
			    	else if(dir == down_dir){
			    		 dy = 1;
			    		 px = 6;
			    		 py = 8;
			    	}
			    	else if(dir == up_dir){
			    		 dy = -1;
			    		 px = 3;
			    		 py = 2;
			    	}
			    	else if(dir == left_dir){
			    		 dx = -1;
			    		 px = 1;
			    		 py = 7;
			    	}*/
			    /*	BulletShoot bullet = new BulletShoot(this.getX()+px,this.getY()+py,3,3,null,dx,dy);
			        Game.bullets.add(bullet);
			    	}
			    	}
			    }*/
			
			if(isDamaged) {
				this.DamageFrames++;
				if(this.DamageFrames == 8) {
					this.DamageFrames = 0;
					this.isDamaged = false;
				}
	
				
				
			}
			if(this.ThePressurePlateWasPressed) {
				Game.eletronicWalls.remove(index);
			}
	/*		if(stock == 3) {
				StartNewGame = false;
			}*/
			
			if(StartNewGame == true) {
				Game.entities = new ArrayList<Entity>();
				Game.enemies = new ArrayList<Enemy>();
				Game.enemies2 = new ArrayList<Enemy2>();
				Game.enemies3 = new ArrayList<Enemy3>();
				Game.enemies4 = new ArrayList<Enemy4>();
				Game.boss1 = new ArrayList<Boss1>();
				Game.boss2 = new ArrayList<Boss2>();
				
				//Game.boss3 = new ArrayList<Boss3>();
				Game.spritesheet = new Spritesheet("/spritesheet.png");
				Game.player2 = new Player2(0,0,16,16,Game.movements.getSprite(0,22*16,16,16));
				Game.entities.add(Game.player2);
				Game.world = new World("/Level1.png");
				Game.gameState = "Normal";
		      	this.StartNewGame = false;
				this.life = 100;
				hasGun = false;
				ammo = 0;
				stock = 3;
			//	System.out.println("a");
			}
			if(life <= 0) {
				if(stock >= 1 ) {
				Game.entities = new ArrayList<Entity>();
				Game.enemies = new ArrayList<Enemy>();
				Game.enemies2 = new ArrayList<Enemy2>();
				Game.enemies3 = new ArrayList<Enemy3>();
				Game.enemies4 = new ArrayList<Enemy4>();
				Game.boss1 = new ArrayList<Boss1>();
				Game.boss2 = new ArrayList<Boss2>();
				Game.traps = new ArrayList<Trap>();
				//Game.boss3 = new ArrayList<Boss3>();
				Game.spritesheet = new Spritesheet("/spritesheet.png");
				Game.player2 = new Player2(0,0,16,16,Game.movements.getSprite(0,22*16,16,16));
				Game.entities.add(Game.player2);
				Game.world = new World("/Level"+Game.CUR_LEVEL+".png");
				hasGun = false;
				ammo = 0;
				stock--;
				return;
			}else if(stock <= 0) {
				Game.gameState = "GameOver";
			}
			}
		    if(this.ThePressurePlateWasPressed) {
		    	
		    }
		
		
		//Camera2.x  = Camera2.clamp(this.getX() - (Game.WIDHT/2),0,World.WIDTH*16 - Game.WIDHT);
		//Camera2.y  = Camera2.clamp(this.getY() - (Game.HEIGHT/2),0,World.HEIGHT*16 - Game.HEIGHT);
	
	}
	
	public void checkCollisionBullet() {
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity atual = Game.entities.get(i);
			if(atual instanceof Bullet) {
				if(Entity.isColliding2(this, atual)) {
						ammo += 35;
						Game.entities.remove(i);
							
						
					}
				}
			}
		}
	
	public void collidingBullet() {
        for(int i = 0; i < Game.enemyBullets.size(); i++) {
        	Entity e = Game.enemyBullets.get(i);
        	if(e instanceof EnemyShoot) {
        		
        		if(Entity.isColliding2(this, e)) {
        			Sound.hurtEffect.play();
        			this.life-=0.5;
        			isDamaged = true;
        			return;
        		}
        		
        	}
        }
       
        
		
		
	}
	public void checkCollisionGun() {
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity atual = Game.entities.get(i);
			if(atual instanceof Weapon) {
				if(Entity.isColliding2(this, atual)) {
						hasGun = true;
						Game.entities.remove(atual);
							
						
					}
				}
			}
		}
	
	
	public void checkCollisionLifePack() {
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity atual = Game.entities.get(i);
			if(atual instanceof LifePack) {
				if(Entity.isColliding2(this, atual)) {
						life += 25;
						Game.entities.remove(atual);
						if(life > 100) {
							life = 100;
					
				
				}
				}
			}
			}
	}
	public void checkCollisionPressurePlate() {
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity atual = Game.entities.get(i);
			Entity eletronicWall = Game.entities.get(i);
			if(atual instanceof PressurePlate) {
				if(Entity.isColliding2(this, atual)) {
					Game.entities.remove(atual);
	                 this.ThePressurePlateWasPressed = true;
	                 if(this.ThePressurePlateWasPressed == true) {
	                	 this.ThePressurePlateWasPressed = false;
	                	 
	                 }
	                 
	   //              System.out.println("AAAA");
				
				}
				}
			}
			
	}
	
	
	//Criar um comando p/ abrir a porta semelhante a esse ^
	
		public void render(Graphics g) {
			if(!isJumping) {
				g.setColor(new Color(40,40,40, 140));
				g.fillOval(this.getX()- Camera.x + 2 , this.getY()- Camera.y + 12, 10, 5);
			}
			else if(isJumping) {
				g.setColor(new Color(40,40,40, 140));
				if(this.jumpCur <= 20) {
				g.fillOval(this.getX()- Camera.x + 4 , this.getY()- Camera.y + 12, 8, 4);
			    }
				else if(this.jumpCur > 20 && this.jumpCur <= 35) {
				g.fillOval(this.getX()- Camera.x + 4 , this.getY()- Camera.y + 12, 6, 3);	
				}
				else if(this.jumpCur > 35 && this.jumpCur <= 50) {
				g.fillOval(this.getX()- Camera.x + 6 , this.getY()- Camera.y + 12, 4, 2);	
				}
			}
			
			if(Game.texture == "Texture_ONE") {
			if(!isDamaged) {
				
				
				if(!renderJump) {
	  //  	if(!atack) {
			if(dir == right_dir || dir == down_dir) {
			g.drawImage(rightPlayer[index], this.getX()- Camera.x, this.getY()- Camera.y -z, null);
			
			    if(hasGun && dir == down_dir) {
				//Desenhar arma p/ baixo.
				g.drawImage(Entity.DOWN_GUN, this.getX() - Camera.x -1, this.getY() - Camera.y -z, null);
			    }
			
			    else if(hasGun && dir == right_dir) {
				//Desenhar arma p/ direita.
				g.drawImage(Entity.RIGHT_GUN, this.getX() - Camera.x  + 5, this.getY() -2  - Camera.y -z, null);
			    }
			}
			else if(dir == left_dir) {
			g.drawImage(rightPlayer[index], this.getX() - Camera.x, this.getY()- Camera.y -z, null);
			if(hasGun) {
				//Desenhar arma p/ esquerda.
				g.drawImage(Entity.LEFT_GUN, this.getX() - Camera.x - 8, this.getY() -2 - Camera.y -z, null );
			
			
			}
			}
			else if(dir == up_dir) {
			g.drawImage(upPlayer[index], this.getX()- Camera.x, this.getY()- Camera.y -z, null);
		    }
				
				/*	if(dir == right_dir || dir == down_dir) {
						g.drawImage(rightPlayer[index], this.getX()- Camera.x, this.getY()- Camera.y, null);
					    
						if(atack && dir == down_dir) {
						g.drawImage(Entity.DOWN_BILLY, this.getX() - Camera.x, this.getY() - Camera.y, null);
				        }
						else if(atack && dir == right_dir) {
						g.drawImage(Entity.RIGHT_BILLY, this.getX() - Camera.x, this.getY() - Camera.y, null);
						}
					}
					    else if(dir == left_dir) {
					    g.drawImage(leftPlayer[index], this.getX() - Camera.x, this.getY()- Camera.y, null);
					    if(atack && dir == left_dir) {	
					    g.drawImage(Entity.LEFT_BILLY, this.getX() - Camera.x, this.getY() - Camera.y, null);
					    }
					}
					    else if(dir == up_dir) {
					    g.drawImage(upPlayer[index], this.getX()- Camera.x, this.getY()- Camera.y, null);
					    if(atack && dir == up_dir) {
					    g.drawImage(Entity.UP_BILLY, this.getX() - Camera.x, this.getY() - Camera.y, null);	
					    }
			        }
				}*/
				}else {
					if(dir == right_dir || dir == left_dir || dir == down_dir) {
					g.drawImage(this.playerJumping_Face, this.getX() - Camera.x, this.getY() - Camera.y - z, null);
				    }else if(dir == up_dir) {
				    g.drawImage(this.playerJumping_Back, this.getX() - Camera.x, this.getY() - Camera.y - z, null);
				    }
					
				}
				
				}else {
				     g.drawImage(playerDamage, this.getX() - Camera.x, this.getY() - Camera.y -z, null);
				     if(hasGun && dir == right_dir) {
				    	 g.drawImage(Entity.RIGHT_GUN_FEEDBACK, this.getX() - Camera.x  + 5, this.getY() -2  - Camera.y -z, null);
				    	 
				     }
				     else if(hasGun && dir == left_dir) {
				    	 g.drawImage(Entity.LEFT_GUN_FEEDBACK, this.getX() - Camera.x  - 6, this.getY() -2  - Camera.y -z, null);
				    	 
				     }
				}
                  
			    }
			
			
			
			
		}
				

}