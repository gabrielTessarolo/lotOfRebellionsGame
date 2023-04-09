package com.ichbineinstudio.world;

public class Camera2_1 {

	  public static int x;
	   public static int y;
	   
	   public static int clamp(int Atual, int Min, int Max) {  
		   if(Atual < Min) {
			   Atual = Min;
		   }
		   if(Atual > Max) {
			   Atual = Max;
		   }
		   return Atual;
	   }
	
}
