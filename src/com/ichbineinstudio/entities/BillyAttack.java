package com.ichbineinstudio.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.ichbineinstudio.main.Game;
import com.ichbineinstudio.world.Camera;

public class BillyAttack extends Entity{
 
	
	public static BufferedImage RIGHT_BILLY = Game.spritesheet.getSprite(6*16, 5*16, 16, 16);
	public static BufferedImage LEFT_BILLY = Game.spritesheet.getSprite(5*16, 5*16, 16, 16);
	public static BufferedImage DOWN_BILLY = Game.spritesheet.getSprite(4*16,5*16,16,16);
	public static BufferedImage UP_BILLY = Game.spritesheet.getSprite(3*16, 5*16, 16, 16);
	
	
	private int directionX;
	private int directionY;
	private int range = 1;
	public static int time = 30, curTime = 0;

	public BillyAttack(int x, int y, int width, int height, BufferedImage sprite, int directionX, int directionY) {
		super(x, y, width, height, sprite);
		this.directionX = directionX;
		this.directionY = directionY;
		
	}
	
	public void tick() {
		x= this.x;
		y= this.y;
		curTime++;
		if(curTime > time) {
			Game.attacks.remove(this);
			return;
		}
	}
   /* public void render(Graphics g) {
		if(Player.dir == Player.right_dir) {
		g.drawImage(Entity.RIGHT_BILLY,this.getX() - Camera.x, this.getY() - Camera.y, null);
    	}
		else if(Player.dir == Player.left_dir) {
			g.drawImage(Entity.LEFT_BILLY,this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
		else if(Player.dir == Player.down_dir) {
			g.drawImage(Entity.DOWN_BILLY,this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
		else if(Player.dir == Player.up_dir) {
			g.drawImage(Entity.UP_BILLY,this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
    }*/
}
