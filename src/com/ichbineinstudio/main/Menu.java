package com.ichbineinstudio.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.ichbineinstudio.entities.Entity;
import com.ichbineinstudio.entities.Player;
import com.ichbineinstudio.graficos.UI;
import com.ichbineinstudio.world.World;

public class Menu {
	
	public static String[] options = {"New Game","Load Game","Controls","Store","Settings","Exit"};
	public static String[] PauseOptions = {"Resume","Exit"};
	
	public static int currentOption;
	public int MaxOption = options.length - 1;
	
	public static int currentPauseOption;
	public int MaxPauseOption = PauseOptions.length - 1;
	
	public boolean down,up;
	public static boolean pause = false;
	
	public static boolean saveExists = false;
	public static boolean saveGame = false;
	
	public int ColorX1 = 255;
	public int ColorY1 = 255;
	public int ColorZ1 = 255;
	public static boolean ChangeColors = false;
	public static boolean isThisColor = false;
	
	public void tick() {
		
	/*	if(!isThisColor) {
		if(Game.rand.nextInt(100) < 50){
			ChangeColors = true;
		}
		
			if(ChangeColors = true) {
				ColorX1 = 0;
				ColorY1 = 0;
				ColorZ1 = 0;
				
				isThisColor = true;
			}
			else if(ChangeColors = false) {
				ColorX1 = 255;
				ColorY1 = 255;
				ColorZ1 = 255;
				
				isThisColor = true;
			}
		
		}
		*/
		
		File file = new File("save.txt");
		if(file.exists()) {
			saveExists = true;
		}else {
			saveExists = false;
		}
		
	//	if(!pause) {
		if(up) {
			Sound.changeOptionSound.play();
			up = false;
			currentOption--;
			if(currentOption < 0) {
				currentOption = MaxOption;
			}
			
		}
		if(down) {
			Sound.changeOptionSound.play();
			down = false;
			currentOption++;
			if(currentOption > MaxOption) {
				currentOption = 0;
			}
		}
		
/*		}else {
			if(up) {
				up = false;
				currentPauseOption--;
				if(currentPauseOption < 0) {
					currentPauseOption = MaxPauseOption;
				}
			}
			if(down) {
				down = false;
				currentPauseOption++;
				if(currentPauseOption > MaxPauseOption) {
					currentPauseOption = 0;
				}
			}
			
		}*/
		if(Game.select) {
			Sound.selectOptionSound.play();
			Game.select = false;
			if(options[currentOption] == "New Game") {	
				
				if(!pause) {
					file = new File("save.txt");
					file.delete();
					
				Player.StartNewGame = true;
				Game.gameState = "Normal";
				pause = false;
				
				}else {
					Game.gameState = "Normal";
					pause =  false;
				}
			}
			else if(options[currentOption] == "Load Game") {
			if(!pause) {
				if(saveExists) {
				file = new File("save.txt");
				if(file.exists()) {
					String saver = loadGame(10);
					applySave(saver);
					
				Game.currentStateScene = Game.playing;
				}
				}
				}else {
					
                if(Game.CUR_LEVEL > 1) {Game.saveGame = true;}
					
				}
				
				
			
			}
			else if(options[currentOption] == "Controls") {
				Game.gameState = "Controls";
			}
			else if(options[currentOption] == "Store") {
				Game.gameState = "Store";
			}
			else if(options[currentOption] == "Settings") {
				Game.gameState = "Settings";
			}
			else if(options[currentOption] == "Exit") {
				System.exit(1);
			}
			else if(PauseOptions[currentOption] == "Resume") {
				pause = false;
			}
			
		}
	}
	
	public static void applySave(String str) {
		String[] spl = str.split("/");
        for(int i = 0; i < spl.length; i++) {
            String[] spl2 = spl[i].split(":");
            switch(spl2[0]) {
            case "level":
            	
           // Game.CUR_LEVEL = spl2[1].hashCode() - 48;
            	
            	Game.CUR_LEVEL = Integer.parseInt(spl2[1]);
  
                    World.restartGame("level"+spl2[1]+".png");
                    
                    
                    Game.gameState = "Normal";
                    pause = false;
                    break;
           
                
      /*            for(int a = 0; a < 15; a++) {
                        
                    	if(spl2[1].equals(a)) {
                            Game.CUR_LEVEL = a;
                            }
                  	if(spl2[1].valueOf(a) != null) {
                            Game.CUR_LEVEL = a;
                            }
                    }*/
                    
                    
                    
           case "life":

        	    if(1 == Integer.parseInt(spl2[1])) {
        	    Game.player.life = 100;
        	    }else {
        	    Game.player.life = Integer.parseInt(spl2[1]);
        	    }
        	    break;
        	 	
           case "stock":
        	   
        	   Game.player.stock = Integer.parseInt(spl2[1]);
        	   
        	    break;
        	    
           case "coins":
        	   
        	   Game.player.coins = Integer.parseInt(spl2[1]);

        	    break;
        	    
     
    	   
	    
            }
        }
	}
	
	
	
	public static void saveGame(String[] val1, int[] val2, int encode) {
		BufferedWriter write = null;
		try {
			write = new BufferedWriter(new FileWriter("save.txt"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < val1.length; i++) {
			String current = val1[i];
			current += ":";
			char[] value = Integer.toString(val2[i]).toCharArray();
			for(int n = 0; n < value.length; n++) {
				value[n] += encode;
                current += value[n];			
			
			}
			try {
				write.write(current);
				if(i < val1.length - 1) {
					write.newLine();
				}
			}catch(IOException e) {
				
			}
		}
		try {
			write.flush();
			write.close();
		}catch(IOException e) {}
	}
	
	public static String loadGame(int encode) {
		/////////////////////////////////////////////////////
		String line = "";
		/////////////////////////////////////////////////////
		File file = new File("save.txt");
		if(file.exists()) {
			
			try {
				String singleLine = null;
				BufferedReader reader = new BufferedReader(new FileReader("save.txt"));
		        try {
		        	while((singleLine = reader.readLine()) != null){
		        		String[] trans = singleLine.split(":");
		        		char[] val = trans[1].toCharArray();
		        		trans[1] = "";
		        		for(int i = 0; i < val.length; i++) {
		        			val[i]-=encode;
		        			trans[1] += val[i]; 
		        			
		        		}
		        			line += trans[0];
		        			line += ":";
		        			line += trans[1];
		        			line += "/";
		        			
		        		
		        	}
		        }catch(IOException e) {}
			
			}catch(FileNotFoundException e) {}
			
		}
		
		return line;
	}
	
	public void render(Graphics g) {

		g.setColor(new Color(0,0,100));
		g.fillRect(0,0, Game.WIDHT*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.white);
	//	g.setFont(new Font("Arial",Font.BOLD,100));
		g.setFont(Game.newFont);
		g.drawString("A lot of", 50, 100);
		g.setColor(new Color(255,204,51));
		g.setFont(Game.newFont2);
		g.drawString("Rebellions!", 170, 180);
		
		if(Game.language == "English") {
		if(options[currentOption] == "New Game") {
			g.setColor(new Color(255,204,51));
			g.fillRect(0, 250, Game.WIDHT*Game.SCALE, 24);
			g.drawImage(Entity.J_KEY, 255, 253, null);
		}
		if(options[currentOption] == "Load Game") {
			g.setColor(new Color(255,204,51));
			g.fillRect(0, 290, Game.WIDHT*Game.SCALE, 24);
			g.drawImage(Entity.J_KEY, 255, 293, null);
		}
		if(options[currentOption] == "Controls") {
			g.setColor(new Color(255,204,51));
			g.fillRect(0, 330, Game.WIDHT*Game.SCALE, 24);
			g.drawImage(Entity.J_KEY, 255, 333, null);
		}
		if(options[currentOption] == "Store") {
			g.setColor(new Color(255,204,51));
			g.fillRect(0, 370, Game.WIDHT*Game.SCALE, 24);
			g.drawImage(Entity.J_KEY, 255, 373, null);
		}
		if(options[currentOption] == "Settings") {
			g.setColor(new Color(255,204,51));
			g.fillRect(0, 410, Game.WIDHT*Game.SCALE, 24);
			g.drawImage(Entity.J_KEY, 255, 413, null);
		}
		
		if(options[currentOption] == "Exit") {
			g.setColor(new Color(255,204,51));
			g.fillRect(0, 450, Game.WIDHT*Game.SCALE, 24);
			g.drawImage(Entity.J_KEY, 255, 453, null);
		}
		
		g.setColor(new Color(ColorX1,ColorY1,ColorZ1));
		g.setFont(new Font("Arial",Font.ROMAN_BASELINE,20));
		if(!pause) {
			g.drawString("> New Game", 110, 270);
			if(!saveExists) {
				g.setColor(Color.DARK_GRAY);
			}
			g.drawString("> Load Game", 110, 310);
			g.setColor(new Color(ColorX1,ColorY1,ColorZ1));
			g.drawString("> Controls", 110, 350);
			g.drawString("> Store", 110, 390);
			g.drawString("> Settings", 110, 430);
			g.drawString("> Exit", 110, 470);
		}else {
			g.drawString("> Resume", 110, 270);
			if(Game.CUR_LEVEL <= 1) {
				g.setColor(Color.DARK_GRAY);
			}
			g.drawString("> Save Game", 110, 310);
			g.setColor(new Color(ColorX1,ColorY1,ColorZ1));
			g.drawString("> Controls", 110, 350);
			g.drawString("> Store", 110, 390);
			g.drawString("> Settings", 110, 430);
			g.drawString("> Exit", 110, 470);
			g.setColor(new Color(255,204,51));
		    g.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
		    g.drawString("P a u s e d", 110, 245);	
		
		}
		}
		else if(Game.language == "Português") {
			if(options[currentOption] == "New Game") {
				g.setColor(new Color(255,204,51));
				g.fillRect(0, 250, Game.WIDHT*Game.SCALE, 24);
				g.drawImage(Entity.J_KEY, 255, 253, null);
			}
			if(options[currentOption] == "Load Game") {
				g.setColor(new Color(255,204,51));
				g.fillRect(0, 290, Game.WIDHT*Game.SCALE, 24);
				g.drawImage(Entity.J_KEY, 255, 293, null);
			}
			if(options[currentOption] == "Controls") {
				g.setColor(new Color(255,204,51));
				g.fillRect(0, 330, Game.WIDHT*Game.SCALE, 24);
				g.drawImage(Entity.J_KEY, 255, 333, null);
			}
			if(options[currentOption] == "Store") {
				g.setColor(new Color(255,204,51));
				g.fillRect(0, 370, Game.WIDHT*Game.SCALE, 24);
				g.drawImage(Entity.J_KEY, 255, 373, null);
			}
			if(options[currentOption] == "Settings") {
				g.setColor(new Color(255,204,51));
				g.fillRect(0, 410, Game.WIDHT*Game.SCALE, 24);
				g.drawImage(Entity.J_KEY, 255, 413, null);
			}
			if(options[currentOption] == "Exit") {
				g.setColor(new Color(255,204,51));
				g.fillRect(0, 450, Game.WIDHT*Game.SCALE, 24);
				g.drawImage(Entity.J_KEY, 255, 453, null);
			}
			
			g.setColor(new Color(ColorX1,ColorY1,ColorZ1));
			g.setFont(new Font("Arial",Font.ROMAN_BASELINE,20));
			if(!pause) {
				g.drawString("> Novo jogo", 110, 270);
				if(!saveExists) {
					g.setColor(Color.DARK_GRAY);
				}
				g.drawString("> Carregar jogo", 110, 310);
				g.setColor(new Color(ColorX1,ColorY1,ColorZ1));
				g.drawString("> Controles", 110, 350);
				g.drawString("> Loja", 110, 390);
				g.drawString("> Configurações", 110, 430);
				g.drawString("> Sair do jogo", 110, 470);
			}else {
				g.drawString("> Resumir jogo", 110, 270);
				if(Game.CUR_LEVEL <= 1) {
					g.setColor(Color.DARK_GRAY);
				}
				g.drawString("> Salvar jogo", 110, 310);
				g.setColor(new Color(ColorX1,ColorY1,ColorZ1));
				g.drawString("> Controles", 110, 350);
				g.drawString("> Loja", 110, 390);
				g.drawString("> Configurações", 110, 430);
				g.drawString("> Sair do jogo", 110, 470);
				g.setColor(new Color(255,204,51));
			    g.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
			    g.drawString("P a u s a d o", 110, 245);	
			
			}	
		}
		//g.drawImage(Entity.BackgroundWall, 320, 160, 204, 296, null);
		g.setColor(new Color(255,204,51));
		g.setFont(Game.newFont2);
		g.drawString("Rebellions!", 170, 180);
		//g.drawImage(Entity.BackgroundPoliceman, 365, 226, 93, 241, null);
		//System.out.println(this.loadGame(encode));
		
	}

}
