package com.ichbineinstudio.main;

import java.applet.Applet;
import java.applet.AudioClip;

import java.io.*;
import javax.sound.sampled.*;

public class Sound {

	
	private AudioClip clip;
	
	//public static final Sound musicBackground = new Sound("/PoliceGameBackgroundMusic.wav");
	//public static final Sound musicBackground3 = new Sound("/PoliceGameBackgroundMusicTexture3_2.wav");
	//public static final Sound hurtEffect = new Sound("/Hurt.wav");
	//public static final Sound EnemyHurtEffect = new Sound("/Enemy_Hurt.wav");
	//public static final Sound BossMessageSound = new Sound("/BossMessageSound.wav");
	
	
/*	private Sound(String name) {
		try {
			clip = Applet.newAudioClip(Sound.class.getResource(name));
		}catch(Throwable e) {}
	}
		public void play() {
			try {
				new Thread() {
					public void run() {
						clip.play();
					}
				}.start();
			}catch(Throwable e) {}
		
		
	}
		public void loop() {
			try {
				new Thread() {
					public void run() {
						clip.loop();
					//	System.out.println("AA");
					}
				}.start();
			}catch(Throwable e) {}
		
		
	}*/
	
	      public static class Clips{
	    	  
	    	  public Clip[] clips;
	    	  private int p;
	    	  private int count;
	    	  
	    	  public Clips(byte[] buffer, int count) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
	    		  if(buffer == null) {
	    			  return;
	    		  }
	    		  
	    		  clips = new Clip[count];
	    		  this.count = count;
	    		  
	    		  for(int i = 0; i < count; i++) {
	    			  clips[i] = AudioSystem.getClip();
	    			  clips[i].open(AudioSystem.getAudioInputStream(new ByteArrayInputStream(buffer)));
	    			  
	    		  }
	    	  }
	    	  
	    	  public void play() {
	    		  if(clips == null) {
	    			  return;
	    		  }
	    		  clips[p].stop();
	    		  clips[p].setFramePosition(0);
	    		  clips[p].start();
	    		  p++;
	    		  
	    		  if(p >= count) { //Se p for maior que count, reinicie, pois terminou de tocar o som.
	    			  p = 0;
	    		  }
	    	  }
	    	  
	    	  public void loop() {
	    		  
	    		  if(clips == null) {
	    			  return;
	    		  }
	    		  clips[p].loop(300);
	    	  }
	    	  
	    	  public void stop() {
	    		  
	    		  clips[p].stop();
	    		  
	    	  }
	    	  
	    	  
		
	}
	      
	      public static Clips musicBackground = load("/PoliceGameBackgroundMusic.wav", 1);
	      public static Clips musicBackground2 = load("/PoliceGameBackgroundMusicTexture3.wav", 1);
	      public static Clips musicBackground3 = load("/Football Texture Music.wav", 1);
	      
	      public static Clips hurtEffect = load("/Hurt.wav", 1);
	      public static Clips EnemyHurtEffect = load("/Enemy_Hurt.wav", 1);
	      
	      public static Clips BossMessageSound = load("/BossMessageSound.wav", 1);
	      
	      public static Clips changeOptionSound = load("/changeOptionSound.wav", 1);
	      public static Clips selectOptionSound = load("/selectOptionSound.wav", 1);
	      
	      private static Clips load(String name, int count) {
	    	  try {
	    		
	    		  ByteArrayOutputStream baos = new  ByteArrayOutputStream();
	    		  DataInputStream dis = new DataInputStream(Sound.class.getResourceAsStream(name));
	    		  
	    		  byte[] buffer = new byte[1024];
	    		  int read = 0;
	    		  while((read = dis.read(buffer)) >= 0) {
	    			  baos.write(buffer,0,read);
	    		  }
	    		  dis.close();
	    		  byte[] data = baos.toByteArray();
	    		  return new Clips(data,count);
	    		  
	    	  }catch(Exception e) {
	    		  try {
	    			  
	    			  return new Clips(null, 0);
	    			  
	    		  }catch(Exception ee) {
	    			  
	    			  return null;
	    			  
	    		  }
	    	  }
	    		 
	    	  
	      }
}
