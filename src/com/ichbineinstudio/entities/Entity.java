package com.ichbineinstudio.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.List;

import com.ichbineinstudio.main.Game;
import com.ichbineinstudio.world.Camera;
import com.ichbineinstudio.world.Node;
import com.ichbineinstudio.world.Vector2i;

public class Entity {
	
	private int waterFrames = 0, maxWaterFrames = 15, waterIndex = 0, maxWaterIndex = 3;
	
	public static BufferedImage[] WaterMovements;
	
	public static BufferedImage LIFEPACK_EN = Game.spritesheet.getSprite(6*16,0,16,16);
	public static BufferedImage WEAPON_EN = Game.spritesheet.getSprite(7*16,0,16,16);
	public static BufferedImage BILLY_EN = Game.spritesheet.getSprite(3*16,4*16,16,16);
	public static BufferedImage BULLET_EN = Game.spritesheet.getSprite(6*16,16,16,16);
	
	public static BufferedImage LIFEPACK_EN_TEXTURE2 = Game.movements.getSprite(16*16,2*16,16,16);
	public static BufferedImage WEAPON_EN_TEXTURE2 = Game.movements.getSprite(10*16,2*16,16,16);
	public static BufferedImage BULLET_EN_TEXTURE2 = Game.movements.getSprite(16*16,16,16,16);
	
	public static BufferedImage LIFEPACK_EN_TEXTURE3 = Game.movements.getSprite(7*16,13*16,16,16);
	public static BufferedImage WEAPON_EN_TEXTURE3 = Game.movements.getSprite(1*16,13*16,16,16);
	public static BufferedImage BULLET_EN_TEXTURE3 = Game.movements.getSprite(7*16,12*16,16,16);
	public static BufferedImage LIFEPACK__EN_TEXTURE3 = Game.movements.getSprite(34*16,38*16,32,32);
	public static BufferedImage WEAPON__EN_TEXTURE3 = Game.movements.getSprite(38*16,38*16,32,32);
	public static BufferedImage BULLET__EN_TEXTURE3 = Game.movements.getSprite(36*16,38*16,32,32);
	
	public static BufferedImage LIFEPACK_EN_TEXTURE4 = Game.movements.getSprite(16*16,13*16,16,16);
	public static BufferedImage WEAPON_EN_TEXTURE4 = Game.movements.getSprite(10*16,13*16,16,16);
	public static BufferedImage BULLET_EN_TEXTURE4 = Game.movements.getSprite(16*16,12*16,16,16);
	
	public static BufferedImage FRIENDLY_NPC = Game.movements.getSprite(6*16,  3*16, 16, 16);
	public static BufferedImage FRIENDLY_NPC_TEXTURE2 = Game.movements.getSprite(15*16,  3*16, 16, 16);
	public static BufferedImage FRIENDLY_NPC_TEXTURE3 = Game.movements.getSprite(6*16,  14*16, 16, 16);
	public static BufferedImage FRIENDLY_NPC_TEXTURE4 = Game.movements.getSprite(15*16,  14*16, 16, 16);
	
	public static BufferedImage ENEMY_EN = Game.spritesheet.getSprite(7*16,16,16,16);
	public static BufferedImage ENEMY_FEEDBACK = Game.spritesheet.getSprite(7*16, 5*16, 16, 16);
	public static BufferedImage ENEMY_FEEDBACK_TEXTURE2 = Game.movements.getSprite(12*16, 3*16, 16, 16);
	public static BufferedImage ENEMY_FEEDBACK_TEXTURE3 = Game.movements.getSprite(3*16, 14*16, 16, 16);
	public static BufferedImage ENEMY_FEEDBACK_TEXTURE4 = Game.movements.getSprite(12*16, 14*16, 16, 16);
	
	public static BufferedImage ENEMY2_EN = Game.spritesheet.getSprite(16,4*16,16,16);
	public static BufferedImage ENEMY2_FEEDBACK = Game.spritesheet.getSprite(0,4*16,16,16);
	public static BufferedImage ENEMY2_FEEDBACK_TEXTURE2 = Game.spritesheet.getSprite(0,4*16,16,16);
	public static BufferedImage ENEMY2_FEEDBACK_TEXTURE3 = Game.movements.getSprite(3*16,15*16,16,16);
	public static BufferedImage ENEMY2_FEEDBACK_TEXTURE4 = Game.movements.getSprite(12*16,15*16,16,16);
	
	public static BufferedImage ENEMY3_EN = Game.movements.getSprite(32*16,1*16,16,16);
	public static BufferedImage ENEMY3_FEEDBACK = Game.movements.getSprite(35*16,1*16,16,16);
	public static BufferedImage ENEMY3_FEEDBACK_TEXTURE2 = Game.movements.getSprite(35*16,5*16,16,16);
	public static BufferedImage ENEMY3_FEEDBACK_TEXTURE3 = Game.movements.getSprite(35*16,9*16,16,16);
	public static BufferedImage ENEMY3_FEEDBACK_TEXTURE4 = Game.movements.getSprite(35*16,13*16,16,16);
	
	public static BufferedImage ENEMY4_EN = Game.movements.getSprite(32*16,0*16,32,16);
	public static BufferedImage ENEMY4_FEEDBACK = Game.movements.getSprite(38*16,0*16,32,16);
	public static BufferedImage ENEMY4_FEEDBACK_TEXTURE2 = Game.movements.getSprite(38*16,4*16,32,16);
	public static BufferedImage ENEMY4_FEEDBACK_TEXTURE3 = Game.movements.getSprite(38*16,8*16,32,16);
	public static BufferedImage ENEMY4_FEEDBACK_TEXTURE4 = Game.movements.getSprite(38*16,12*16,32,16);
	
	public static BufferedImage BOSS1_EN = Game.spritesheet.getSprite(8*16,8*16,32,32);
	public static BufferedImage BOSS_1_FEEDBACK = Game.spritesheet.getSprite(2*16,8*16,32,32);
	public static BufferedImage BOSS_1_FEEDBACK_TEXTURE2 = Game.movements.getSprite(9*16,8*16,32,32);
	public static BufferedImage BOSS_1_FEEDBACK_TEXTURE3 = Game.movements.getSprite(0*16,19*16,32,32);
	public static BufferedImage BOSS_1_FEEDBACK_TEXTURE4 = Game.movements.getSprite(9*16,19*16,32,32);
	
	public static BufferedImage BOSS2_EN = Game.movements.getSprite(6*16,6*16,32,32);
	public static BufferedImage BOSS_2_FEEDBACK = Game.movements.getSprite(0*16,6*16,32,32);
	public static BufferedImage BOSS_2_FEEDBACK_TEXTURE2 = Game.movements.getSprite(9*16,6*16,32,32);
	public static BufferedImage BOSS_2_FEEDBACK_TEXTURE3 = Game.movements.getSprite(0*16,17*16,32,32);
	public static BufferedImage BOSS_2_FEEDBACK_TEXTURE4 = Game.movements.getSprite(9*16,17*16,32,32);
	
	public static BufferedImage BOSS3_EN = Game.movements.getSprite(38*16,2*16,32,32);
	public static BufferedImage BOSS_3_FEEDBACK = Game.movements.getSprite(32*16,2*16,32,32);
	public static BufferedImage BOSS_3_FEEDBACK_TEXTURE2 = Game.movements.getSprite(32*16,6*16,32,32);
	public static BufferedImage BOSS_3_FEEDBACK_TEXTURE3 = Game.movements.getSprite(32*16,10*16,32,32);
	public static BufferedImage BOSS_3_FEEDBACK_TEXTURE4 = Game.movements.getSprite(32*16,14*16,32,32);
	
	public static BufferedImage TRAP_EN = Game.spritesheet.getSprite(6*16,6*16,32,32);
	
	public static BufferedImage RIGHT_GUN = Game.spritesheet.getSprite(6*16, 4*16, 16, 16);
	public static BufferedImage LEFT_GUN = Game.spritesheet.getSprite(5*16, 4*16, 16, 16);
	public static BufferedImage DOWN_GUN = Game.spritesheet.getSprite(4*16, 4*16, 16, 16);
	public static BufferedImage RIGHT_GUN_FEEDBACK = Game.spritesheet.getSprite(9*16, 5*16, 16, 16);
	public static BufferedImage LEFT_GUN_FEEDBACK = Game.spritesheet.getSprite(8*16, 5*16, 16, 16);
	
	public static BufferedImage RIGHT_GUN_TEXTURE2 = Game.movements.getSprite(11*16, 2*16, 16, 16);
	public static BufferedImage LEFT_GUN_TEXTURE2 = Game.movements.getSprite(10*16, 2*16, 16, 16);
	public static BufferedImage DOWN_GUN_TEXTURE2 = Game.movements.getSprite(9*16, 2*16, 16, 16);
	public static BufferedImage RIGHT_GUN_FEEDBACK_TEXTURE2 = Game.movements.getSprite(13*16, 2*16, 16, 16);
	public static BufferedImage LEFT_GUN_FEEDBACK_TEXTURE2 = Game.movements.getSprite(12*16, 2*16, 16, 16);
	
	public static BufferedImage RIGHT_GUN_TEXTURE3 = Game.movements.getSprite(2*16, 13*16, 16, 16);
	public static BufferedImage LEFT_GUN_TEXTURE3 = Game.movements.getSprite(1*16, 13*16, 16, 16);
	public static BufferedImage DOWN_GUN_TEXTURE3 = Game.movements.getSprite(0*16, 13*16, 16, 16);
	public static BufferedImage RIGHT_GUN_FEEDBACK_TEXTURE3 = Game.movements.getSprite(4*16, 13*16, 16, 16);
	public static BufferedImage LEFT_GUN_FEEDBACK_TEXTURE3 = Game.movements.getSprite(3*16, 13*16, 16, 16);
	
	public static BufferedImage RIGHT_GUN_TEXTURE4 = Game.movements.getSprite(11*16, 13*16, 16, 16);
	public static BufferedImage LEFT_GUN_TEXTURE4 = Game.movements.getSprite(10*16, 13*16, 16, 16);
	public static BufferedImage DOWN_GUN_TEXTURE4 = Game.movements.getSprite(9*16, 13*16, 16, 16);
	public static BufferedImage RIGHT_GUN_FEEDBACK_TEXTURE4 = Game.movements.getSprite(13*16, 13*16, 16, 16);
	public static BufferedImage LEFT_GUN_FEEDBACK_TEXTURE4 = Game.movements.getSprite(12*16, 13*16, 16, 16);
	
	public static BufferedImage PRESSURE_PLATE = Game.spritesheet.getSprite(8*16, 6*16, 16, 16);
	public static BufferedImage ELETRONIC_WALL = Game.spritesheet.getSprite(16, 7*16, 16, 16);
	
	
	
	/*	public static BufferedImage RIGHT_BILLY = Game.spritesheet.getSprite(6*16, 5*16, 16, 16);
	public static BufferedImage LEFT_BILLY = Game.spritesheet.getSprite(5*16, 5*16, 16, 16);
	public static BufferedImage DOWN_BILLY = Game.spritesheet.getSprite(4*16,5*16,16,16);
	public static BufferedImage UP_BILLY = Game.spritesheet.getSprite(3*16, 5*16, 16, 16);*/
	
	
	public static BufferedImage W_KEY = Game.spritesheet.getSprite(32, 7*16, 16, 16);
	public static BufferedImage S_KEY = Game.spritesheet.getSprite(48, 7*16, 16, 16);
	public static BufferedImage A_KEY = Game.spritesheet.getSprite(64, 7*16, 16, 16);
	public static BufferedImage D_KEY = Game.spritesheet.getSprite(80, 7*16, 16, 16);
	public static BufferedImage UP_KEY = Game.spritesheet.getSprite(0, 8*16, 16, 16);
	public static BufferedImage DOWN_KEY = Game.spritesheet.getSprite(16, 8*16, 16, 16);
	public static BufferedImage LEFT_KEY = Game.spritesheet.getSprite(0, 9*16, 16, 16);
	public static BufferedImage RIGHT_KEY = Game.spritesheet.getSprite(16, 9*16, 16, 16);
	
	public static BufferedImage J_KEY = Game.spritesheet.getSprite(0, 6*16, 16, 16);
	public static BufferedImage C_KEY = Game.spritesheet.getSprite(7*16, 7*16, 16, 16);
	
	public static BufferedImage L_KEY = Game.spritesheet.getSprite(8*16, 7*16, 16, 16);
	public static BufferedImage B_KEY = Game.spritesheet.getSprite(9*16, 7*16, 16, 16);
	
	public static BufferedImage M_KEY = Game.spritesheet.getSprite(10*16, 7*16, 16, 16);
	
	public static BufferedImage SPACE_KEY = Game.spritesheet.getSprite(6*16, 7*16, 16, 16);
	
	public static BufferedImage LOCK = Game.spritesheet.getSprite(10*16, 6*16, 16, 16);
	
	public static BufferedImage COIN = Game.spritesheet.getSprite(10*16, 5*16, 16, 16);
	
	public static BufferedImage BackgroundPoliceman = Game.menuBackground.getSprite(0,0,31,77);
	public static BufferedImage BackgroundWall = Game.menuBackground.getSprite(33,0,51,74);
			
	public int depth;
	
	public double x;
	public double y;
	protected double z;
	protected int width;
	protected int height;
	
	protected List<Node> path;

	private BufferedImage sprite;
	
	private int mx, my, mwidth, mheight;
	
	public Entity(int x,int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		
		this.mx = 0;
		this.my = 0;
		this.mwidth = width;
		this.mheight = height;
		
		WaterMovements = new BufferedImage[3];
		
		WaterMovements[0] = Game.spritesheet.getSprite(32, 6*16, 16, 16);
		WaterMovements[1] = Game.spritesheet.getSprite(48, 6*16, 16, 16);
		WaterMovements[2] = Game.spritesheet.getSprite(64, 6*16, 16, 16);
	}
	public void setMask(int mx, int my, int mwidth, int mheight) {
	this.mx = mx;
	this.my = my;
	this.mwidth = mwidth;
	this.mheight = mheight;
	}
	
    public static Comparator<Entity> nodeSorter = new Comparator<Entity>() {
		
		
		@Override
		   public int compare(Entity n0, Entity n1) {
			   
			   if(n1.depth < n0.depth) 
				   return +1;
			   
			   if(n1.depth > n0.depth) 
				   return -1;
			   return 0;
		   
		   
		   }
	};
	
	public void setX(int newX) {
		this.x = newX;
	}
	public void setY(int newY) {
		this.y = newY;
	}
	
	public int getX(){
		return (int)this.x;
	}
	public int getY(){
		return (int)this.y;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public void tick() {
	
	}
	
	public double calculateDistance(int x1, int y1, int x2, int y2){
	    return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
	
	public void followPath(List<Node> path){
		if(path != null) {
			if(path.size() > 0) {
				//Ainda há caminho a ser percorrido;
				
				Vector2i target = path.get(path.size() -1).tile;
				//xprev = x;
				//yprev = y;
				
				if(x < target.x * 16) {
					x++;
					
				}
				else if(x > target.x * 16) {
					x--;
					
				}
				if(y < target.y * 16) {
					y++;
				
				}
				else if(y > target.y * 16) {
					y--;
				}
				
				if(x == target.x * 16 && y == target.y * 16) {
					path.remove(path.size() - 1);
				}
				
			}
		}
		
	}
	
	public static boolean isColliding2(Entity e1, Entity e2) {
		Rectangle e1Mask = new Rectangle(e1.getX()+e1.mx, e1.getY()+e1.my,e1.mwidth,e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX()+e2.mx, e2.getY()+e2.my,e2.mwidth,e2.mheight);
	    if(e1Mask.intersects(e2Mask) && e1.z == e2.z) {
		   return true;
	    }
	    return false;
	}
	
	public void render(Graphics g) {
	    g.drawImage(sprite,this.getX() - Camera.x,this.getY() - Camera.y,null);
	}
	}
