package com.ichbineinstudio.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.ichbineinstudio.main.Game;
import com.ichbineinstudio.main.Sound;
import com.ichbineinstudio.world.AStar;
import com.ichbineinstudio.world.Camera;
import com.ichbineinstudio.world.Vector2i;
import com.ichbineinstudio.world.World;

public class Enemy extends Entity{
	
	public double speed = 0.6;
	private boolean moved = false;
	
	public static int positionEnemyImage = 0;
	
	private int maskx = 8, masky = 8, maskw = 10, maskh = 15;
	
	private int frames = 0, maxFrames = 5, index = 0, maxIndex = 2;
	
	private double life = 12, maxLife = 12;

	private BufferedImage[] sprites;
	private BufferedImage[] sprites2;
	private BufferedImage[] sprites3;
	private BufferedImage[] sprites4;
	
	
	private boolean isDamaged = false;
	private int damageFrames = 10, damageCurrent = 0;
	
	public Enemy(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, null);
		sprites = new BufferedImage[3];
		sprites[0] = Game.movements.getSprite(0, 3*16, 16, 16);
	    sprites[1] = Game.movements.getSprite(0 +16, 3*16, 16, 16);
	    sprites[2] = Game.movements.getSprite(0 +32, 3*16, 16, 16);
	    
	    sprites2 = new BufferedImage[3];
		sprites2[0] = Game.movements.getSprite(9*16, 3*16, 16, 16);
	    sprites2[1] = Game.movements.getSprite(9*16 +16, 3*16, 16, 16);
	    sprites2[2] = Game.movements.getSprite(9*16 +32, 3*16, 16, 16);
	    
	    sprites3 = new BufferedImage[3];
		sprites3[0] = Game.movements.getSprite(0*16, 14*16, 16, 16);
	    sprites3[1] = Game.movements.getSprite(1*16, 14*16, 16, 16);
	    sprites3[2] = Game.movements.getSprite(2*16, 14*16, 16, 16);
	    
	    sprites4 = new BufferedImage[3];
		sprites4[0] = Game.movements.getSprite(9*16, 14*16, 16, 16);
	    sprites4[1] = Game.movements.getSprite(9*16 + 16, 14*16, 16, 16);
	    sprites4[2] = Game.movements.getSprite(9*16 + 32, 14*16, 16, 16);
	}
		
		
		public void tick(){
			depth = 1;
		/*	if(Game.texture == "Texture_ONE") {
				this.positionEnemyImage = 0;
			}
			else if(Game.texture == "Texture_TWO") {
				this.positionEnemyImage = 9*16;
			}*/
		//	System.out.println(this.positionEnemyImage);
			
			moved = false;
		//	if(Game.rand.nextInt(100) < 30) {
			if(this.calculateDistance(this.getX(), this.getY(), Game.player.getX(), Game.player.getY()) < 100) {
			if(isCollidingWithPlayer() == false) {
			if((int)x < Game.player.getX() && World.isFreeForEnemies((int)(x+speed),this.getY())
					&& !isColliding((int)(x+speed),this.getY())) {
				moved = true;
				x+=speed;
				
			}
			else if((int)x > Game.player.getX()&& World.isFreeForEnemies((int)(x-speed),this.getY())
					&& !isColliding((int)(x-speed),this.getY())) {
				moved = true;
				x-=speed;
				
			}
			if((int)y < Game.player.getY()&& World.isFreeForEnemies(this.getX(),(int)(y+speed))
					&& !isColliding(this.getX(),(int)(y+speed))) {
				moved = true;
				y+=speed;
				
			}
			else if((int)y > Game.player.getY()&& World.isFreeForEnemies(this.getX(),(int)(y-speed))
					&& !isColliding(this.getX(),(int)(y-speed))) {
				moved = true;
				y-=speed;
			}
			}else {
				if(Game.rand.nextInt(100) < 10) {
					if(!Player.isJumping) {
					Sound.hurtEffect.play();
				Game.player.life-=(Game.rand.nextInt(3)+1);
				Game.player.isDamaged = true;
					}
			//	System.out.println("Vida: "+(int)(Game.player.life));
				}
				
			}		
				
			}
			
       /*     if(path == null || path.size() == 0) {
            	
            	Vector2i start = new Vector2i((int)(x/16),(int)(y/16));
            	Vector2i end = new Vector2i((int)(Game.player.x/16),(int)(Game.player.y/16));
            	
				path = AStar.findPath(Game.world, start, end);
			}
			followPath(path);*/
			if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO" || Game.texture == "Texture_FOUR") {
				if(moved) {
					frames++;
					if(frames == maxFrames) {
						frames = 0;
						index++;
						if(index > maxIndex)
							index = 0;
					
				
					}
					}
			}else if(Game.texture == "Texture_THREE") {
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
				Game.enemies.remove(this);
				Game.entities.remove(this);
				Player.coins += 3;
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
		    	Rectangle enemyCurrent = new Rectangle(this.getX() + maskx, this.getY() + masky, maskw,maskh);
		    	Rectangle player = new Rectangle(Game.player.getX(),Game.player.getY(),16,16);
		    	return enemyCurrent.intersects(player);
		    }
		
			public boolean isColliding(int xnext,int ynext) { 
				Rectangle enemyCurrent = new Rectangle(xnext + maskx, ynext + masky, maskw,maskh);
				for(int i = 0; i < Game.enemies.size(); i++) {
					Enemy e =  Game.enemies.get(i);
					if(e == this)
						continue;
					
					Rectangle targetEnemy = new Rectangle(e.getX()+ maskx,e.getY()+ masky, maskw,maskh);
				    if(enemyCurrent.intersects(targetEnemy)) {
				    	return true;
				
				}
				
			}
		return false;	
			
		
			
}
		
			/*public double currentHP(int HP, int MAX) {
				HP = this.life;
				MAX = this.maxLife;
				
				return HP/MAX;
			} */
			
		public void render(Graphics g) {
		//	super.render(g);
			if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO") {
			g.setColor(new Color(40,40,40, 130));
			g.fillOval(this.getX()- Camera.x + 1 , this.getY()- Camera.y + 12, 10, 5);
			}else if(Game.texture == "Texture_THREE") {
			g.setColor(new Color(40,40,40, 130));
			g.fillOval(this.getX()- Camera.x + 1 , this.getY()- Camera.y + 12, 15, 5);	
			}else if(Game.texture == "Texture_FOUR") {
		    g.setColor(new Color(40,40,40, 130));
			g.fillOval(this.getX()- Camera.x + 3 , this.getY()- Camera.y + 12, 10, 5);
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
				g.drawImage(Entity.ENEMY_FEEDBACK,this.getX() - Camera.x,this.getY() - Camera.y,null);
			}else if(Game.texture == "Texture_TWO") {
				g.drawImage(Entity.ENEMY_FEEDBACK_TEXTURE2,this.getX() - Camera.x,this.getY() - Camera.y,null);
			}else if(Game.texture == "Texture_THREE") {
				g.drawImage(Entity.ENEMY_FEEDBACK_TEXTURE3,this.getX() - Camera.x,this.getY() - Camera.y,null);
			}else if(Game.texture == "Texture_FOUR") {
				g.drawImage(Entity.ENEMY_FEEDBACK_TEXTURE4,this.getX() - Camera.x,this.getY() - Camera.y,null);
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
			g.fillRect((this.getX() - 3) - (Camera.x), (this.getY() - 5) - (Camera.y), 18, 5);
			g.setColor(new Color(80, 80, 80, 130));
			g.fillRect((this.getX() - 2) - (Camera.x), (this.getY() - 4) - (Camera.y),16,3);
			if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO") {
			g.setColor(Color.red);
			g.fillRect((this.getX() - 2) - (Camera.x), (this.getY() - 4) - (Camera.y),(int)((this.life/this.maxLife)*16),3);
			}else if(Game.texture == "Texture_THREE") {
			g.setColor(new Color(51, 224, 225));
			g.fillRect((this.getX() - 2) - (Camera.x), (this.getY() - 4) - (Camera.y),(int)((this.life/this.maxLife)*16),3);
			}else if(Game.texture == "Texture_FOUR") {
			g.setColor(new Color(255, 204, 51));
			g.fillRect((this.getX() - 2) - (Camera.x), (this.getY() - 4) - (Camera.y),(int)((this.life/this.maxLife)*16),3);
			}
			}
			
			
			
			
			
		
		}
		
}
