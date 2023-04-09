package com.ichbineinstudio.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.ichbineinstudio.main.Game;
import com.ichbineinstudio.main.Sound;
import com.ichbineinstudio.world.Camera;
import com.ichbineinstudio.world.World;

public class Enemy4 extends Entity{
	
	private int maskx = 8, masky = 8, maskw = 32, maskh = 16;
	
	private int frames = 0, maxFrames = 10, index = 0, maxIndex = 2;
	
	private double life = 60, maxLife = 60;

	
	private boolean shoot;
	private boolean shoot2;
	private int shootCounter = 0;

	private BufferedImage[] sprites;
	private BufferedImage[] sprites2;
	private BufferedImage[] sprites3;
	private BufferedImage[] sprites4;
	
	
	private boolean isDamaged = false;
	private int damageFrames = 10, damageCurrent = 0;
	
	public Enemy4(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, 32, 16, null);
		sprites = new BufferedImage[3];
		sprites[0] = Game.movements.getSprite(32*16,0*16, 32, 16);
	    sprites[1] = Game.movements.getSprite(32*16 +32, 0*16, 32, 16);
	    sprites[2] = Game.movements.getSprite(32*16 +64, 0*16, 32, 16);
	    
	    sprites2 = new BufferedImage[3];
		sprites2[0] = Game.movements.getSprite(32*16, 4*16, 32, 16);
	    sprites2[1] = Game.movements.getSprite(32*16 +32, 4*16, 32, 16);
	    sprites2[2] = Game.movements.getSprite(32*16 +64, 4*16, 32, 16);
	    
	    sprites3 = new BufferedImage[3];
		sprites3[0] = Game.movements.getSprite(32*16, 8*16, 32, 16);
	    sprites3[1] = Game.movements.getSprite(32*16 + 32, 8*16, 32, 16);
	    sprites3[2] = Game.movements.getSprite(32*16 + 64, 8*16, 32, 16);
	    
	    sprites4 = new BufferedImage[3];
		sprites4[0] = Game.movements.getSprite(32*16, 12*16, 32, 16);
	    sprites4[1] = Game.movements.getSprite(32*16 + 32, 12*16, 32, 16);
	    sprites4[2] = Game.movements.getSprite(32*16 + 64, 12*16, 32, 16);
	}
		
		
		public void tick(){
			depth = 1;
			
			
				
				//System.out.println("A");
			int dx = 1;
	    	int dy = 1;
	    	int px = 14;
	    	int py = -1;
	  
	    	if(shoot) {
	    	
	    	EnemyShoot enemyShoot = new EnemyShoot(this.getX()+px,this.getY()+py,3,3,null,dx,dy);
	    	Game.enemyBullets.add(enemyShoot);
	    	
	    	EnemyShoot enemyShoot2 = new EnemyShoot(this.getX()+px,this.getY()+py,3,3,null,dx-2,dy-2);
	    	Game.enemyBullets.add(enemyShoot2);
	    	
	    	EnemyShoot enemyShoot3 = new EnemyShoot(this.getX()+px,this.getY()+py,3,3,null,dx-2,dy);
	    	Game.enemyBullets.add(enemyShoot3);
	    	
	    	EnemyShoot enemyShoot4 = new EnemyShoot(this.getX()+px,this.getY()+py,3,3,null,dx,dy-2);
	    	Game.enemyBullets.add(enemyShoot4);
	    	
	    	}else if(shoot2) {
	    	
	    	EnemyShoot enemyShoot5 = new EnemyShoot(this.getX()+px,this.getY()+py,3,3,null,dx-1,dy-2);
	    	Game.enemyBullets.add(enemyShoot5);
	    	
	    	EnemyShoot enemyShoot6 = new EnemyShoot(this.getX()+px,this.getY()+py,3,3,null,dx-1,dy);
	    	Game.enemyBullets.add(enemyShoot6);
	    	
	    	EnemyShoot enemyShoot7 = new EnemyShoot(this.getX()+px,this.getY()+py,3,3,null,dx,dy-1);
	    	Game.enemyBullets.add(enemyShoot7);
	    	
	    	EnemyShoot enemyShoot8 = new EnemyShoot(this.getX()+px,this.getY()+py,3,3,null,dx-2,dy-1);
	    	Game.enemyBullets.add(enemyShoot8);
	    	
			}
	    	
		
		/*	if(Game.texture == "Texture_ONE") {
				this.positionEnemyImage = 0;
			}
			else if(Game.texture == "Texture_TWO") {
				this.positionEnemyImage = 9*16;
			}*/
		//	System.out.println(this.positionEnemyImage);
			
		//	if(Game.rand.nextInt(100) < 30) {
			
			
				
			
			
       /*     if(path == null || path.size() == 0) {
            	
            	Vector2i start = new Vector2i((int)(x/16),(int)(y/16));
            	Vector2i end = new Vector2i((int)(Game.player.x/16),(int)(Game.player.y/16));
            	
				path = AStar.findPath(Game.world, start, end);
			}
			followPath(path);*/
			
			shootCounter++;
			if(shootCounter >= 100) {
				shoot = true;
				if(shootCounter >= 200) {
					
					shoot = false;
					
					if(shootCounter >= 300) {
						
						shoot2 = true;
						
						if(shootCounter >= 400) {
							
							shoot2 = false;
							shoot = false;
							shootCounter = 0;
							
						}
						
						
					}
				}
				
			}
	    	if(Game.texture == "Texture_ONE" || Game.texture == "Texture_THREE" || Game.texture == "Texture_FOUR") {
	    	
					frames++;
					if(frames == maxFrames) {
						frames = 0;
						index++;
						if(index > maxIndex) {
							index = 0;
							
						}
				
					}
	    	}else if(Game.texture == "Texture_TWO") {
	    		
	    		maxFrames = 20;
	    		
	    		frames++;
				if(frames == maxFrames) {
					frames = 0;
					index++;
					if(index > maxIndex) {
						index = 0;
						
					}
			
				}
	    	}
					
					
					
					if(this.isCollidingWithPlayer()) {
						if(!Player.isJumping) {
						if(Game.rand.nextInt(100) < 10) {
						Sound.hurtEffect.play();
						Game.player.life-=5;
						Game.player.isDamaged = true;
						}
						}
					}
					
			
			
			collidingBullet();
			
			if(this.life <= 0) {
				destroySelf();
				return;
			}
			if(isDamaged) {
				this.damageCurrent++;
				if(this.damageCurrent >= this.damageFrames) {
					this.damageCurrent = 0;
					isDamaged = false;
				}
			}
			
			
			
}
			
			public void destroySelf() {
				Game.enemies4.remove(this);
				Game.entities.remove(this);
				Player.coins += 6;
			}
			
			public void collidingBullet() {
            for(int i = 0; i < Game.bullets.size(); i++) {
            	Entity e = Game.bullets.get(i);
            	if(e instanceof BulletShoot) {
            		
            		if(Entity.isColliding2(this, e)) {
            			Sound.EnemyHurtEffect.play();
            			this.life-=3;
            			isDamaged = true;
            			Game.bullets.remove(i);
            			return;
            		}
            		
            	}
            }
           
            
			
			
		}
		    public boolean isCollidingWithPlayer(){
		    	Rectangle enemy4Current = new Rectangle(this.getX() + maskx, this.getY() + masky, maskw,maskh);
		    	Rectangle player = new Rectangle(Game.player.getX(),Game.player.getY(),16,16);
		    	return enemy4Current.intersects(player);
		    }
		
			public boolean isColliding(int xnext,int ynext) { 
				Rectangle enemy4Current = new Rectangle(xnext + maskx, ynext + masky, maskw,maskh);
				for(int i = 0; i < Game.enemies4.size(); i++) {
					Enemy4 e =  Game.enemies4.get(i);
					if(e == this)
						continue;
					
					Rectangle targetEnemy4 = new Rectangle(e.getX()+ maskx,e.getY()+ masky, maskw,maskh);
				    if(enemy4Current.intersects(targetEnemy4)) {
				    	return true;
				
				}
				
			}
		return false;	
			
		
			
}
			
		public void render(Graphics g) {
		//	super.render(g);
			if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO") {
			g.setColor(new Color(40,40,40, 130));
			g.fillOval(this.getX()- Camera.x -1 , this.getY()- Camera.y + 12, 32, 8);
			}else if(Game.texture == "Texture_THREE") {
			g.setColor(new Color(40,40,40, 130));
			g.fillOval(this.getX()- Camera.x - 1 , this.getY()- Camera.y + 12, 32, 8);	
			}else if(Game.texture == "Texture_FOUR") {
		    /*g.setColor(new Color(40,40,40, 130));
			g.fillOval(this.getX()- Camera.x + 3 , this.getY()- Camera.y + 12, 10, 5);*/
			}
			if(!isDamaged) {
				if(Game.texture == "Texture_ONE") {
			g.drawImage(sprites[index],this.getX() - Camera.x,this.getY() - Camera.y,null);
				}
		    else if(Game.texture == "Texture_TWO") {
			g.drawImage(sprites2[index],this.getX() - Camera.x,this.getY() - Camera.y,null);
				}
		    else if(Game.texture == "Texture_THREE") {
		    g.drawImage(sprites3[index],this.getX() - Camera.x,this.getY() - Camera.y,null);	
		        }
		    else if(Game.texture == "Texture_FOUR")	{
		    g.drawImage(sprites4[index],this.getX() - Camera.x,this.getY() - Camera.y,null);	
		    }
		    	
		//    g.fillRect(this.getX() + maskx - Camera.x, this.getY() + masky - Camera.y, maskw,maskh);
			}else {
				if(Game.texture == "Texture_ONE") {
				g.drawImage(Entity.ENEMY4_FEEDBACK,this.getX() - Camera.x,this.getY() - Camera.y,null);
			}else if(Game.texture == "Texture_TWO") {
				g.drawImage(Entity.ENEMY4_FEEDBACK_TEXTURE2,this.getX() - Camera.x,this.getY() - Camera.y,null);
			}else if(Game.texture == "Texture_THREE") {
				g.drawImage(Entity.ENEMY4_FEEDBACK_TEXTURE3,this.getX() - Camera.x,this.getY() - Camera.y,null);
			}else if(Game.texture == "Texture_FOUR") {
				g.drawImage(Entity.ENEMY4_FEEDBACK_TEXTURE4,this.getX() - Camera.x,this.getY() - Camera.y,null);
			}
				
			}
			if(Game.currentStateScene != Game.entering) {
				/*if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO" || Game.texture == "Texture_FOUR") {
					
			g.setColor(Color.white);
			g.setFont(new Font("Arial",Font.BOLD,8));
			g.drawString(this.life+"/"+this.maxLife, (this.getX() -3) - (Camera.x), (this.getY() - 4) - (Camera.y));
					
				}else if(Game.texture == "Texture_THREE") {
					g.setColor(new Color(51, 224, 225));
			g.setFont(new Font("Arial",Font.BOLD,8));
			g.drawString(this.life+"/"+this.maxLife, (this.getX() -3) - (Camera.x), (this.getY() - 4) - (Camera.y));		
				}*/
				
				
				g.setColor(Color.white);
				g.fillRect((this.getX() - 1) - (Camera.x), (this.getY() - 5) - (Camera.y), 34, 5);
				g.setColor(new Color(80, 80, 80, 130));
				g.fillRect((this.getX()) - (Camera.x), (this.getY() - 4) - (Camera.y), 32, 3);
				if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO") {
				g.setColor(Color.red);
				g.fillRect((this.getX()) - (Camera.x), (this.getY() - 4) - (Camera.y),(int)((this.life/this.maxLife)*32),3);
				}else if(Game.texture == "Texture_THREE") {
				g.setColor(new Color(51, 224, 225));
				g.fillRect((this.getX()) - (Camera.x), (this.getY() - 4) - (Camera.y),(int)((this.life/this.maxLife)*32),3);
				}else if(Game.texture == "Texture_FOUR") {
				g.setColor(new Color(255, 204, 51));
				g.fillRect((this.getX()) - (Camera.x), (this.getY() - 4) - (Camera.y),(int)((this.life/this.maxLife)*32),3);
				}
				}
		}
		
		
		
}
