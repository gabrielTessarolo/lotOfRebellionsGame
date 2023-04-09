package com.ichbineinstudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.ichbineinstudio.main.Game;
import com.ichbineinstudio.world.Camera;
import com.ichbineinstudio.world.World;

public class BulletShoot extends Entity{
	
	private double dx;
	private double dy;
    private double spd = 4;
    private int Durability = 25, curDurability = 0;
    
	
	public BulletShoot(int x, int y, int width, int height, BufferedImage sprite, double dx, double dy) {
		super(x, y, width, height, sprite);
		this.dx = dx;
		this.dy = dy;
		
	}

	public void tick() {
		//Para que o jogador possa atirar entre as paredes, comente as próximas 1ª, 4ª, 5ª, 6ª e 7ª linhas de código.
		if(World.isFreeDynamic((int) (x + (dx*spd)), (int) (y + (dy*spd)), 3, 3)) {
			x+=dx*spd;
			y+=dy*spd;
		}else {
			Game.bullets.remove(this);
			return;
		}
		curDurability++;
		if(curDurability == Durability) {
			Game.bullets.remove(this);
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
		if(Game.texture == "Texture_ONE" || Game.texture == "Texture_TWO") {
		g.setColor(new Color(200,200,200));
		g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, width, height);
		}else if(Game.texture == "Texture_THREE") {
		g.setColor(new Color(51, 224, 225));
		g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, width, height);
		}else if(Game.texture == "Texture_FOUR") {
		g.setColor(Color.yellow);
		g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, width, height);	
		}
		
	}
	
	
}
