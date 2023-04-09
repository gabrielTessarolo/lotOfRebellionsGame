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

public class GameOver {


public static String[] options = {"Try again","Exit to Menu"};
	
	public static int currentOption;
	public int MaxOption = options.length - 1;
	
	public void tick() {
	
	if(Game.select) {
		Game.select = false;
		if(options[currentOption] == "Exit to Menu") {
	      Game.gameState = "Menu";
		}
		else if(options[currentOption] == "Try again") {
			Player.StartNewGame = true;
			Game.CUR_LEVEL = 1;
			Game.gameState = "Normal";
			Menu.pause = false;
			
		}
	}
	
	
	
    }
	public void render(Graphics g) {
		g.setColor(new Color(0,0,100));
		g.fillRect(0,0, Game.WIDHT*Game.SCALE, Game.HEIGHT*Game.SCALE);
    }
}
