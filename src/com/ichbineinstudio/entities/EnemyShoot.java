package com.ichbineinstudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.ichbineinstudio.main.Game;
import com.ichbineinstudio.world.Camera;
import com.ichbineinstudio.world.World;

public class EnemyShoot extends Entity{
	
	private double dx;
	private double dy;
    private double spd = 2;
    private int Durability = 25, curDurability = 0;
    
    public Random rand;
    
	
	public EnemyShoot(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite);
		this.dx = dx;
		this.dy = dy;
		
		rand = new Random();
		
	}

	public void tick() {
		x+=dx*spd;
		y+=dy*spd;
		curDurability++;
		if(curDurability == Durability) {
			Game.enemyBullets.remove(this);
			return;
		}
	}

	/*
			if((int)x < Game.player.getX() && World.isFree((int)(x+spd),this.getY())
						&& !BulletCollidingWith((int)(x+spd),this.getY())) {
					x+=spd;
					
				}
				else if((int)x > Game.player.getX()&& World.isFree((int)(x-spd),this.getY())
						&& !BulletCollidingWith((int)(x-spd),this.getY())) {
					x-=spd;
					
				}
				if((int)y < Game.player.getY()&& World.isFree(this.getX(),(int)(y+spd))
						&& !BulletCollidingWith(this.getX(),(int)(y+spd))) {
					y+=spd;
					
				}
				else if((int)y > Game.player.getY()&& World.isFree(this.getX(),(int)(y-spd))
						&& !BulletCollidingWith(this.getX(),(int)(y-spd))) {
					y-=spd;
				}
				
				
		}
			
	


			
			
			
			public boolean BulletCollidingWith(int xnext,int ynext) { 

				for(int i = 0; i < Game.bullets.size(); i++) {
					BulletShoot e =  Game.bullets.get(i);
					if(e == this)
						continue;
					
				}
				return false;
				}*/
	public void render(Graphics g) {
		if(Game.texture == "Texture_ONE") {
		g.setColor(new Color(255, 0, 0, 180));
		g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, width, height);
		}else if(Game.texture == "Texture_TWO") {
		g.setColor(new Color(255, 106, 0, 180));
		g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, width, height);	
		}else if(Game.texture == "Texture_THREE") {
			g.setColor(new Color(255, 235, 127));
			g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, width, height);	
			if(this.rand.nextInt(100) <= 25) {
		g.setColor(new Color(255, 235, 127, 180));
		g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, width, height);
			}else if(this.rand.nextInt(100) > 25 && this.rand.nextInt(100) <= 50) {
		g.setColor(new Color(244, 104, 255, 180));
		g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, width, height);		
			}else if(this.rand.nextInt(100) > 50 && this.rand.nextInt(100) <= 75) {
		g.setColor(new Color(122, 151, 255, 180));
		g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, width, height);		
			}else if(this.rand.nextInt(100) > 75) {
		g.setColor(new Color(153, 255, 168, 180));
		g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, width, height);		
			}
		}else if(Game.texture == "Texture_FOUR") {
			g.setColor(new Color(255, 235, 127));
			g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, width, height);	
			if(this.rand.nextInt(100) <= 50) {
		g.setColor(new Color(255, 255, 255, 180));
		g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, width, height);
			}else {
		g.setColor(new Color(255,102,0,180));
		g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, width, height);		
			}	
		}
		
	}
	
	
}
