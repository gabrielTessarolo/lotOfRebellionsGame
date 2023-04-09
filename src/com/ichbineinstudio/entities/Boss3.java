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

public class Boss3 extends Entity{
	
	public double speed = 1.35;
	private boolean moved = false;
	
	private int maskx = 0, masky = 0, maskw = 32, maskh = 32;
	
	private int frames = 0, maxFrames = 5, index = 0, maxIndex = 2;
	
	private double life = 150, maxLife = 150;

	private BufferedImage[] sprites;
	private BufferedImage[] sprites2;
	private BufferedImage[] sprites3;
	private BufferedImage[] sprites4;
	
	private boolean isDamaged = false;
	private int damageFrames = 10, damageCurrent = 0;
	
	public Boss3(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, 32, 32, null);
		sprites = new BufferedImage[3];
		sprites[0] = Game.movements.getSprite(38*16, 2*16, 32, 32);
	    sprites[1] = Game.movements.getSprite(36*16, 2*16, 32, 32);
	    sprites[2] = Game.movements.getSprite(34*16, 2*16, 32, 32);
	    
	    sprites2 = new BufferedImage[3];
		sprites2[0] = Game.movements.getSprite(38*16, 6*16, 32, 32);
	    sprites2[1] = Game.movements.getSprite(36*16, 6*16, 32, 32);
	    sprites2[2] = Game.movements.getSprite(34*16, 6*16, 32, 32);
	    
	    sprites3 = new BufferedImage[3];
		sprites3[0] = Game.movements.getSprite(38*16, 10*16, 32, 32);
	    sprites3[1] = Game.movements.getSprite(36*16, 10*16, 32, 32);
	    sprites3[2] = Game.movements.getSprite(34*16, 10*16, 32, 32);
	    
	    sprites4 = new BufferedImage[3];
		sprites4[0] = Game.movements.getSprite(38*16, 14*16, 32, 32);
	    sprites4[1] = Game.movements.getSprite(36*16, 14*16, 32, 32);
	    sprites4[2] = Game.movements.getSprite(34*16, 14*16, 32, 32);
	}
		
		
		public void tick(){
			depth = 1;
			moved = false;
		//	if(Game.rand.nextInt(100) < 30) {
			if(isCollidingWithPlayer() == false) {
			if((int)x < Game.player.getX() && World.isFreeForBosses((int)(x+speed),this.getY(), width, height)
					&& !isColliding((int)(x+speed),this.getY())) {
				moved = true;
				x+=speed;
				
			}
			else if((int)x > Game.player.getX() && World.isFreeForBosses((int)(x-speed),this.getY(), width, height)
					&& !isColliding((int)(x-speed),this.getY())) {
				moved = true;
				x-=speed;
				
			}
			if((int)y < Game.player.getY() && World.isFreeForBosses(this.getX(),(int)(y+speed), width, height)
					&& !isColliding(this.getX(),(int)(y+speed))) {
				moved = true;
				y+=speed;
				
			}
			else if((int)y > Game.player.getY() && World.isFreeForBosses(this.getX(),(int)(y-speed), width, height)
					&& !isColliding(this.getX(),(int)(y-speed))) {
				moved = true;
				y-=speed;
			}
			}else {
				if(Game.rand.nextInt(100) < 10) {
					if(!Player.isJumping) {
					Sound.hurtEffect.play();
				Game.player.life-=(Game.rand.nextInt(20)+3);
				Game.player.isDamaged = true;
					}
			//	System.out.println("Vida: "+(int)(Game.player.life));
				}
				
					
				
			}
			
				maxFrames = 5;
				if(moved) {
					frames++;
					if(frames == maxFrames) {
						frames = 0;
						index++;
						if(index > maxIndex)
							index = 0;
					
				
					}
					}
			
			
			collidingBullet();
			
			if(this.life <= 0) {
				destroySelf1();
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
			
			public void destroySelf1() {
				Game.boss3.remove(this);
				Game.entities.remove(this);
				Player.coins += 50;
			}
			
			public void collidingBullet() {
            for(int i = 0; i < Game.bullets.size(); i++) {
            	Entity e = Game.bullets.get(i);
            	if(e instanceof BulletShoot) {
            		
            		if(Entity.isColliding2(this, e)) {
            			Sound.EnemyHurtEffect.play();
            			this.life-=1;
            			isDamaged = true;
            			Game.bullets.remove(i);
            			return;
            		}
            		
            	}
            }
           
			
		}
		    public boolean isCollidingWithPlayer(){
		    	Rectangle bossCurrent = new Rectangle(this.getX() + maskx, this.getY() + masky, maskw,maskh);
		    	Rectangle player = new Rectangle(Game.player.getX(),Game.player.getY(),16,16);
		    	return bossCurrent.intersects(player);
		    }
		
			public boolean isColliding(int xnext,int ynext) { 
				Rectangle bossCurrent = new Rectangle(xnext + maskx, ynext + masky, maskw,maskh);
				for(int i = 0; i < Game.boss3.size(); i++) {
					Boss3 e =  Game.boss3.get(i);
					if(e == this)
						continue;
					
					Rectangle targetBoss = new Rectangle(e.getX()+ maskx,e.getY()+ masky, maskw,maskh);
				    if(bossCurrent.intersects(targetBoss)) {
				    	return true;
				
				}
				
			}
		return false;	
			
		
			
}
			
		public void render(Graphics g) {
			g.setColor(new Color(40,40,40, 130));
			g.fillOval(this.getX()- Camera.x + 3 , this.getY()- Camera.y + 27, 25, 8);
		//	super.render(g);
			if(!isDamaged) {
				if(Game.texture == "Texture_ONE") {
			g.drawImage(sprites[index],this.getX() - Camera.x,this.getY() - Camera.y,null);
				}else if(Game.texture == "Texture_TWO") {
					g.drawImage(sprites2[index],this.getX() - Camera.x,this.getY() - Camera.y,null);
				}else if(Game.texture == "Texture_THREE") {
					g.drawImage(sprites3[index],this.getX() - Camera.x,this.getY() - Camera.y,null);
				}else if(Game.texture == "Texture_FOUR") {
					g.drawImage(sprites4[index],this.getX() - Camera.x,this.getY() - Camera.y,null);
				}
		//    g.fillRect(this.getX() + maskx - Camera.x, this.getY() + masky - Camera.y, maskw,maskh);
			}else {
				if(Game.texture == "Texture_ONE") {
				g.drawImage(Entity.BOSS_3_FEEDBACK,this.getX() - Camera.x,this.getY() - Camera.y,null);
				}else if(Game.texture == "Texture_TWO") {
				g.drawImage(Entity.BOSS_3_FEEDBACK_TEXTURE2,this.getX() - Camera.x,this.getY() - Camera.y,null);		
				}else if(Game.texture == "Texture_THREE") {
				g.drawImage(Entity.BOSS_3_FEEDBACK_TEXTURE3,this.getX() - Camera.x,this.getY() - Camera.y,null);			
				}else if(Game.texture == "Texture_FOUR") {
				g.drawImage(Entity.BOSS_3_FEEDBACK_TEXTURE4,this.getX() - Camera.x,this.getY() - Camera.y,null);	
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
            if(Game.texture == "Texture_FOUR") {
            	g.setColor(Color.white);
            	g.setFont(new Font("Arial", Font.BOLD, 10));
            g.drawString("Robben", (this.getX() -2) - (Camera.x), (this.getY() +40) - (Camera.y));
            //g.drawString("V", (this.getX() + 8) - (Camera.x), (this.getY() - 6) - (Camera.y));
            }
			
			
		}
		
}
