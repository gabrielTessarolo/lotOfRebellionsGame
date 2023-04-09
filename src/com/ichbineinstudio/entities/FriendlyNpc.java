package com.ichbineinstudio.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ichbineinstudio.main.Game;
import com.ichbineinstudio.world.Camera;

public class FriendlyNpc extends Entity{
	
	public String[] frases = new String[5];
	public String[] frasesPT = new String[5];
	public String[] frases2_Texture1 = new String[5];
	public String[] frases2_Texture2 = new String[5];
	public String[] frases2_Texture3 = new String[5];
	public String[] frases2_Texture4 = new String[5];
	public String[] frases3_Texture1 = new String[3];
	public String[] frases3_Texture2 = new String[3];
	public String[] frases3_Texture3 = new String[3];
	public String[] frases3_Texture4 = new String[3];
	
	public static boolean ShowMessage = false;
	
	public int curIndexMsg = 0;
	public int fraseIndex = 0;
	public int timeMsg = 0;
	public int maxTimeMsg = 5;
	public boolean showContinueButton = false;

	public FriendlyNpc(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		frases[0] = "Hey, cop! I thank God that you're alive...          ";
		frases[1] = "The prisoners are making a rebellion. Most of your co-workers are hurt.          ";
		frases[2] = "I, the deputy, am looking for help, and I already asked for reinforcements.          ";
		frases[3] = "But now, we have to defeat those prisoners before they kill us!          ";
		frases[4] = "Are you ready for the mission? Let's go!          ";
		
		frasesPT[0] = "Ei, policial! Eu agradeço a Deus por você estar vivo...";
		frasesPT[1] = "Os prisioneiros estão fazendo uma rebelião. A maioria de seus colegas está ferida.         ";
		frasesPT[2] = "Eu, o delegado, estou procurando ajuda, e já chamei reforços.          ";
		frasesPT[3] = "Mas devemos derrotar esses detentos antes de nos matarem!         ";
		frasesPT[4] = "Está pronto para a missão? Vamos lá!          ";
		
		frases2_Texture1[0] = "Hey! Nice to see you again. We are in Siria.         ";
		frases2_Texture1[1] = "The rebellion apparently generated other revolts.           ";
		frases2_Texture1[2] = "The prisoners convinced the Islamists that we are their enemies.          ";
		frases2_Texture1[3] = "They won't hear us. Unfortunately, we have to do something.          ";
		frases2_Texture1[4] = "But first we need to scape from this labyrinth. Let's go!          ";
		
		frases2_Texture2[0] = "Soldier, our group was attacked by the monsters...       ";
		frases2_Texture2[1] = "The bandits made an alliance with them. Damn.          ";
		frases2_Texture2[2] = "These corrupted lands are gonna be destroyed by us!          ";
		frases2_Texture2[3] = "Please, help me for kill those monsters!           ";
		frases2_Texture2[4] = "This labyrinth is so confused. Find a gun and go save our lives!        ";
		
		frases2_Texture3[0] = "Hey, little girl! You're probably confused about the situation, aren't you?        ";
		frases2_Texture3[1] = "The clouds are revolted because the rainny (and rebeld) clouds convinced them that we are boring...         ";
		frases2_Texture3[2] = "There are, in this labyrinth, gum balls that will incapacite them.";
		frases2_Texture3[3] = "Find the gun and shoot the clouds!          ";
		frases2_Texture3[4] = "It can't be so hard, they don't have even arms!          ";
		
		frases2_Texture4[0] = "Nice, champion! Congrats, you won those german dumbs!        ";
		frases2_Texture4[1] = "Let's show them what is the better soccer team in the WORLD!         ";
		frases2_Texture4[2] = "Let's go, Brazil! Now, go shoot Belgium!";
		frases2_Texture4[3] = "If Müller couldn't win you, Hazzard will not win you too!          ";
		frases2_Texture4[4] = "Brazil has the BETTER soccer team! Don't let them win!        ";
		
		frases3_Texture1[0] = "Don't look at me. I know you have no ideia we are here, me neither.          ";
		frases3_Texture1[1] = "This is an old abandoned robots factory. The robots became crazy, and now are trying to kill us!         ";
		frases3_Texture1[2] = "We have to destroy them, and NOW!          ";
		
		
	}
	
	public void tick() {
		int xPlayer = Game.player.getX();
		int yPlayer = Game.player.getY();
		
		int xNpc = (int)x;
		int yNpc = (int)y;
		
		if(Math.abs(xPlayer - xNpc) < 20 && Math.abs(yPlayer - yNpc) < 20) {
			ShowMessage = true;
		//	Game.ShowMessageNpc1 = true;
			
		}else {
			ShowMessage = false;
		//	Game.ShowMessageNpc1 = true;
		}
		
		if(ShowMessage == true) {
			if(Game.select) {
				Game.select = false;
				fraseIndex++;
				if(Game.CUR_LEVEL == 6) {
				if(fraseIndex >= 5) {
					fraseIndex = 0;
				}
				}else if(Game.CUR_LEVEL == 11) {
				if(fraseIndex >= 3) {
					fraseIndex = 0;
				}
				}
			}
		}else {
			fraseIndex = 0;
		}
		
		
	/*	this.timeMsg++;
		if(timeMsg >= maxTimeMsg) {
			
		timeMsg = 0;
		
		
		
		if(curIndexMsg < frases[fraseIndex].length()) {
			
			if(fraseIndex != 4) {
				curIndexMsg++;
			}
			
			
			if(fraseIndex == 4) {
				curIndexMsg++;
			if(curIndexMsg >= frases[4].length() - 10) {
				curIndexMsg = frases[4].length() - 10;
				
				if(Game.select) {
					
					fraseIndex = 0;
					ShowMessage = false;
				//	System.out.println("Started");
				}
				
			}
			}
		
			
		}else {
			if(fraseIndex < frases.length) {
				if(fraseIndex <= 3) {
					fraseIndex++;
					
				}else if(fraseIndex == 4) {
					showContinueButton = true;
					
					
					
				}
			
			curIndexMsg =  0;
			}
		
		
		}
		
		
		
		} */
		
	}
	
	public void render(Graphics g) {
	//    super.render(g);
	    if(Game.texture == "Texture_ONE") {
	    g.drawImage(Game.movements.getSprite(6*16, 3*16, 16, 16), this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
	    }else if(Game.texture == "Texture_TWO") {
	    	  g.drawImage(Game.movements.getSprite(15*16, 3*16, 16, 16), this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
	    }else if(Game.texture == "Texture_THREE") {
	    	  g.drawImage(Game.movements.getSprite(6*16, 14*16, 16, 16), this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
	    }else if(Game.texture == "Texture_FOUR") {
	    	  g.drawImage(Game.movements.getSprite(15*16, 14*16, 16, 16), this.getX() - Camera.x, this.getY() - Camera.y, 16, 16, null);
	    }
	    
	 /*   if(ShowMessage) {
	    
	    g.setColor(Color.red);
		 g.setFont(new Font("Arial", Font.BOLD, 20));
		 g.drawString("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", 20, 10);
	    
	    }*/
	    
	   if(ShowMessage) {
	    	
		 /*  g.setColor(Color.white);
		   g.setFont(new Font("Arial", Font.ROMAN_BASELINE, 9));
		   g.drawString("="+fraseIndex, 5, 110+2);*/
		   
		//   g.setColor(Color.red);
		//	 g.setFont(new Font("Arial", Font.BOLD, 20));
		//   g.drawString("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", 10, 110);
	    	
	    	g.setColor(new Color(50,50,50, 180));
			g.fillRect(0, 100, Game.WIDHT, 60);
			g.setColor(Color.white);
			g.fillRect(0, 100, Game.WIDHT, 1);
			if(Game.texture == "Texture_ONE") {
			g.drawImage(Entity.FRIENDLY_NPC, 165, 65, 96, 96, null);
			}else if(Game.texture == "Texture_TWO") {
			g.drawImage(Entity.FRIENDLY_NPC_TEXTURE2, 165, 65, 96, 96, null);	
			}else if(Game.texture == "Texture_THREE") {
			g.drawImage(Entity.FRIENDLY_NPC_TEXTURE3, 165, 65, 96, 96, null);	
			}else if(Game.texture == "Texture_FOUR") {
			g.drawImage(Entity.FRIENDLY_NPC_TEXTURE4, 158, 65, 96, 96, null);	
			}
			g.setColor(Color.white);
			g.setFont(new Font("Arial", Font.ROMAN_BASELINE, 9));
			
			if(Game.language == "English") {
			if(Game.CUR_LEVEL == 6) {
			if(Game.texture == "Texture_ONE") {
			if(fraseIndex == 0) {
				g.drawString(frases2_Texture1[0], 5, 110+2);	
			}else if(fraseIndex == 1) {
				g.drawString(frases2_Texture1[1], 5, 110+2);
			}else if(fraseIndex == 2) {
				g.drawString("The prisoners convinced the Islamists", 5, 110+2);
				g.drawString("that we are their enemies.", 5, 120+2);
			}else if(fraseIndex == 3) {
				g.drawString("They won't hear us.", 5, 110+2);
				g.drawString("Unfortunately, we have to do something.", 5, 120+2);
			}else if(fraseIndex == 4) {
				g.drawString("But first we need to scape from", 5, 110+2);
				g.drawString("this labyrinth. Let's go!", 5, 120+2);
			}
			}else if(Game.texture == "Texture_TWO") {
				if(fraseIndex == 0) {
					g.drawString("Soldier, our group was attacked", 5, 110+2);
					g.drawString("by the monsters...", 5, 120+2);	
				}else if(fraseIndex == 1) {
					g.drawString("The bandits made an alliance with them.", 5, 110+2);
					g.drawString("Damn.", 5, 120+2);
				}else if(fraseIndex == 2) {
					g.drawString("These corrupted lands are gonna", 5, 110+2);
					g.drawString("be destroyed by us!", 5, 120+2);
				}else if(fraseIndex == 3) {
					g.drawString(frases2_Texture2[3], 5, 110+2);
				}else if(fraseIndex == 4) {
					g.drawString("This labyrinth is so confused.", 5, 110+2);
					g.drawString("Find a gun and go save our lives!", 5, 120+2);
				}
			}else if(Game.texture == "Texture_THREE") {
				if(fraseIndex == 0) {
					g.drawString("Hey, little girl! You're probably confused", 5, 110+2);
					g.drawString("about the situation, aren't you?", 5, 120+2);	
				}else if(fraseIndex == 1) {
					g.drawString("The clouds are revolted because the rainny (and", 5, 110+2);
					g.drawString("rebeld) clouds convinced them that we are boring...", 5, 120+2);
				}else if(fraseIndex == 2) {
					g.drawString("There are, in this labyrinth,", 5, 110+2);
					g.drawString("gum balls that will incapacite them.", 5, 120+2);
				}else if(fraseIndex == 3) {
					g.drawString(frases2_Texture3[3], 5, 110+2);
				}else if(fraseIndex == 4) {
					g.drawString("It can't be so hard, because", 5, 110+2);
					g.drawString("they don't have even arms!", 5, 120+2);
				}
			}else if(Game.texture == "Texture_FOUR") {
				if(fraseIndex == 0) {
					g.drawString("Nice, champion! Congrats, you won those", 5, 110+2);
					g.drawString("german dumbs!", 5, 120+2);	
				}else if(fraseIndex == 1) {
					g.drawString("Let's show them what is the best soccer", 5, 110+2);
					g.drawString("team in the WORLD!", 5, 120+2);
				}else if(fraseIndex == 2) {
					g.drawString("Let's go, Brazil! Now, go shoot Belgium!", 5, 110+2);
				}else if(fraseIndex == 3) {
					g.drawString("If Müller couldn't win you,", 5, 110+2);
					g.drawString("Hazzard will not win you too!", 5, 120+2);
				}else if(fraseIndex == 4) {
					g.drawString("Brazil has the BEST soccer team!", 5, 110+2);
					g.drawString("Don't let them win!", 5, 120+2);
				}
			}
			}else if(Game.CUR_LEVEL == 11) {
				if(Game.texture == "Texture_ONE") {
					if(fraseIndex == 0) {
						g.drawString("Don't look at me. I know you have ", 5, 110+2);
						g.drawString("no ideia we are here, me neither.", 5, 120+2);
					}else if(fraseIndex == 1) {
						g.drawString("This is an old abandoned robots factory.", 5, 110+2);
						g.drawString("The robots became crazy, and now are trying to kill us!", 5, 120+2);
					}else if(fraseIndex == 2) {
						g.drawString("We have to destroy them, and NOW!", 5, 110+2);

					}
				}else if(Game.texture == "Texture_TWO") {
					if(fraseIndex == 0) {
						g.drawString("Don't look at me. I know you have ", 5, 110+2);
						g.drawString("no ideia we are here, me neither.", 5, 120+2);
					}else if(fraseIndex == 1) {
						g.drawString("This is an old abandoned robots factory.", 5, 110+2);
						g.drawString("The robots became crazy, and now are trying to kill us!", 5, 120+2);
					}else if(fraseIndex == 2) {
						g.drawString("We have to destroy them, and NOW!", 5, 110+2);

					}
				}else if(Game.texture == "Texture_THREE") {
					if(fraseIndex == 0) {
						g.drawString("Thank you for the help, little girl!", 5, 110+2);
						g.drawString("Could you help us with one last thing?", 5, 120+2);
					}else if(fraseIndex == 1) {
						g.drawString("We are in the sunny clouds.", 5, 110+2);
						g.drawString("The sons of Sun are so angry with us...", 5, 120+2);
					}else if(fraseIndex == 2) {
						g.drawString("And now are trying to kill us.", 5, 110+2);
						g.drawString("Maybe I should sleep... I'm so tired.", 5, 120+2);

					}
				}else if(Game.texture == "Texture_FOUR") {
					if(fraseIndex == 0) {
						g.drawString("I was sure that you could defeat those dumbs!", 5, 110+2);
						g.drawString("It's time to win our last match...", 5, 120+2);
					}else if(fraseIndex == 1) {
						g.drawString("It's against Netherlands!", 5, 110+2);
						g.drawString("This is going to be easy... we are the bests!", 5, 120+2);
					}else if(fraseIndex == 2) {
						g.drawString("Shoot them and go face Robben!", 5, 110+2);
						
					}
				}
				}
			}else if(Game.language == "Português") {
				if(Game.CUR_LEVEL == 6) {
				if(Game.texture == "Texture_ONE") {
					if(fraseIndex == 0) {
						g.drawString("Ei! É bom ver você denovo.         ", 5, 110+2);	
						g.drawString("Nós estamos na Síria.         ", 5, 120+2);
					}else if(fraseIndex == 1) {
						g.drawString("A rebelião aparentemente", 5, 110+2);
						g.drawString("gerou outras revoltas.", 5, 120+2);
					}else if(fraseIndex == 2) {
						g.drawString("Os prisioneiros convenceram os ", 5, 110+2);
						g.drawString("Islâmicos de que nós somos seus inimigos.", 5, 120+2);
					}else if(fraseIndex == 3) {
						g.drawString("Eles não irão nos escutar.", 5, 110+2);
						g.drawString("Infelizmente, nós temos que reagir.", 5, 120+2);
					}else if(fraseIndex == 4) {
						g.drawString("Mas primeiro temos que sair", 5, 110+2);
						g.drawString("deste labirinto. Vamos lá!", 5, 120+2);
					}
					}else if(Game.texture == "Texture_TWO") {
						if(fraseIndex == 0) {
							g.drawString("Soldado, nosso grupo foi atacado", 5, 110+2);
							g.drawString("pelos monstros...", 5, 120+2);	
						}else if(fraseIndex == 1) {
							g.drawString("Os bandidos fizeram uma aliança", 5, 110+2);
							g.drawString("com eles. Droga.", 5, 120+2);
						}else if(fraseIndex == 2) {
							g.drawString("Essas terras corruptas serão", 5, 110+2);
							g.drawString("destruídas por nós!", 5, 120+2);
						}else if(fraseIndex == 3) {
							g.drawString("Por favor, me ajude a matar", 5, 110+2);
							g.drawString("aqueles monstros!", 5, 120+2);
						}else if(fraseIndex == 4) {
							g.drawString("Esse labirinto é muito confuso.", 5, 110+2);
							g.drawString("Ache uma arma e salve nossas vidas!", 5, 120+2);
						}
					}else if(Game.texture == "Texture_THREE") {
						if(fraseIndex == 0) {
							g.drawString("Ei, garotinha! Você deve estar ", 5, 110+2);
							g.drawString("confusa em relação à situação, não é?", 5, 120+2);	
						}else if(fraseIndex == 1) {
							g.drawString("As nuvens estão revoltadas porque as nuvens", 5, 110+2);
							g.drawString("chuvosas as convenceram de que somos chatos.", 5, 120+2);
						}else if(fraseIndex == 2) {
							g.drawString("Há, nesse labirinto, balas de chiclete", 5, 110+2);
							g.drawString("que vão incapacitá-las.", 5, 120+2);
						}else if(fraseIndex == 3) {
							g.drawString("Ache a arma e vá acertar elas!", 5, 110+2);
						}else if(fraseIndex == 4) {
							g.drawString("Não pode ser tão difícil,", 5, 110+2);
							g.drawString("elas sequer têm braços!", 5, 120+2);
						}
					}else if(Game.texture == "Texture_FOUR") {
						if(fraseIndex == 0) {
							g.drawString("Boa, campeão! Você venceu aqueles", 5, 110+2);
							g.drawString("alemães idiotas!", 5, 120+2);	
						}else if(fraseIndex == 1) {
							g.drawString("Vamos mostrar a eles qual é o ", 5, 110+2);
							g.drawString("melhor time de futebol do MUNDO!", 5, 120+2);
						}else if(fraseIndex == 2) {
							g.drawString("Vamos lá, Brasil! Agora vá acertar", 5, 110+2);
							g.drawString("a Bélgica!", 5, 120+2);
						}else if(fraseIndex == 3) {
							g.drawString("Se Müller não pôde te vencer,", 5, 110+2);
							g.drawString("Hazzard também não poderá!", 5, 120+2);
						}else if(fraseIndex == 4) {
							g.drawString("O Brasil tem o MELHOR time de", 5, 110+2);
							g.drawString("futebol! Não os deixe vencer!", 5, 120+2);
						}
					}
					
					}else if(Game.CUR_LEVEL == 11) {
						if(Game.texture == "Texture_ONE") {
							if(fraseIndex == 0) {
								g.drawString("Não olhe para mim. Eu sei que você não ", 5, 110+2);
								g.drawString("tem ideia do porquê estamos aqui. Nem eu.", 5, 120+2);
							}else if(fraseIndex == 1) {
								g.drawString("Essa é uma fábrica de robôs abandonada. Os ", 5, 110+2);
								g.drawString("robôs ficaram loucos, e agora querem nos matar!", 5, 120+2);
							}else if(fraseIndex == 2) {
								g.drawString("Nós temos que destruí-los, e AGORA!", 5, 110+2);

							}
						}else if(Game.texture == "Texture_TWO") {
							if(fraseIndex == 0) {
								g.drawString("Não olhe para mim. Eu sei que você não ", 5, 110+2);
								g.drawString("tem ideia do porquê estamos aqui. Nem eu.", 5, 120+2);
							}else if(fraseIndex == 1) {
								g.drawString("Essa é uma fábrica de robôs abandonada. Os ", 5, 110+2);
								g.drawString("robôs ficaram loucos, e agora querem nos matar!", 5, 120+2);
							}else if(fraseIndex == 2) {
								g.drawString("Nós temos que destruí-los, e AGORA!", 5, 110+2);

							}
						}else if(Game.texture == "Texture_THREE") {
							if(fraseIndex == 0) {
								g.drawString("Obrigado pela ajuda, garotinha!", 5, 110+2);
								g.drawString("Você poderia nos ajudar com algo a mais?", 5, 120+2);
							}else if(fraseIndex == 1) {
								g.drawString("Nós estamos nas nuvens ensolaradas.", 5, 110+2);
								g.drawString("Os filhos do Sol estão bravos conosco...", 5, 120+2);
							}else if(fraseIndex == 2) {
								g.drawString("E agora querem nos matar! Talvez eu ", 5, 110+2);
								g.drawString("devesse dormir. Estou tão cansado...", 5, 120+2);

							}
						}else if(Game.texture == "Texture_FOUR") {
							if(fraseIndex == 0) {
								g.drawString("Eu sabia que derrotaria aqueles idiotas!", 5, 110+2);
								g.drawString("É hora de vencer nossa última partida...", 5, 120+2);
							}else if(fraseIndex == 1) {
								g.drawString("É contra a Holanda!", 5, 110+2);
								g.drawString("Isso será fácil. Somos os melhores!", 5, 120+2);
							}else if(fraseIndex == 2) {
								g.drawString("Acerte eles e encare Robben!", 5, 110+2);
								
							}
						}
					}
				
			}
				
				
				
			
			
			
			g.drawImage(Entity.J_KEY, 0, 125, 32, 32, null);
			
			
			
				 
			 }
			}  
	    	
	    	
	/*    	g.setColor(new Color(100,100,100, 100));
	    	g.drawString("AAAAAAAAAAAAAAAAAAAA", 0, 0);
	    	g.fillRect(0, 100*Game.SCALE, Game.WIDHT*Game.SCALE, 60*Game.SCALE);*/
	
	
	}
	


