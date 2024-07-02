package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla23 {
	private Personaje MC;
	private Random R;
	public Personaje getMC() {
		return MC;
	}
	public void setMC(Personaje mC) {
		MC = mC;
	}
	public Random getR() {
		return R;
	}
	public void setR(Random r) {
		R = r;
	}
	public Pantalla23 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla de la entrada a los lagos, la cabaña
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			String estadoCabanya = "";
			try 
			{
				
			 	File file = new File("Cabanya.txt");
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	            
	            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
	            
	            while ((line = br.readLine()) != null) 
	            {
	                
	                  estadoCabanya=line;
	                    
	            }	       	            
	            br.close();
			}
			catch (Exception e)
			{
				System.out.println("Error al leer el fichero de MA.");
			}
			String estadoBruja = "";
			try 
			{
				
			 	File file = new File("Bruja.txt");
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	            
	            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
	            
	            while ((line = br.readLine()) != null) 
	            {
	                
	                  estadoBruja=line;
	                    
	            }	       	            
	            br.close();
			}
			catch (Exception e)
			{
				System.out.println("Error al leer el fichero de MA.");
			}
			String estadoDragon="";
			try 
			{
				
			 	File file = new File("DragonAlado.txt");
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	            
	            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
	            
	            while ((line = br.readLine()) != null) 
	            {
	                
	                  estadoDragon=line;
	                    
	            }	       	            
	            br.close();
			}
			catch (Exception e)
			{
				System.out.println("Error al leer el fichero de MA.");
			}
			
			System.out.println("\n~La entrada a los lagos~\n");

			System.out.println("Después de una corta caminata, llegas a una cabaña que parece presidir la vista a un gran lago.");
			System.out.println("Además, frente a la cabaña hay una señal que indica:");
			System.out.println("Al oeste, ves un gran cúmulo de nubes por esa zona.");
			System.out.println("Al este, más despejado, pero un terreno más escarpado.");
			System.out.println("Tambien, bastante a lo lejos, parece que hay dos planchas de metal grandísimas.");
			System.out.println("Varias opciones se abren ante ti.");
			
			int decision = FU.decision("Entro en la cabaña.", "Me dirijo al oeste.", "Me dirijo al este.", "Me dirijo a las planchas de metal.", eD);
			
			if (decision ==1)
			{
				//Si el dragon esta vivo, hay un huevo cadaver y todo esta lleno de sangre
				
				if (estadoDragon.equals("vivo"))
				{
					System.out.println("\nEntras en la cabaña y todo está lleno de sangre.");
					System.out.println("Lo que más llama tu atención es el cadáver que hay en el centro de la estancia.");
					System.out.println("No sabrías decir si es un hombre o una mujer.");
					System.out.println("No tiene cabeza, sino que de su interior surgen pequeños gorgoteos.");
					System.out.println("No te atreves a acercarte más.");
					System.out.println("Oyes un fuerte rugido a lo lejos, proveniente del lago.");
					System.out.println("No te sientes tranquilo.");
					System.out.println("Es más, quizás te sientes en peligro.");
					System.out.println("Sales de la cabaña.");
					try
					{
						File Cabanya = new File ("Cabanya.txt");
					    BufferedWriter writer = new BufferedWriter(new FileWriter(Cabanya, false));				 
					    writer.write("yahapasadoymuerte");
					    writer.close();
					}
					catch (Exception e)
					{
						System.out.println("Error al escribir que ya ha pasado por P22." + e);
					}	
					
					
					
					int decision2 = FU.decision("Me dirijo al oeste.", "Me dirijo al este.", "Me dirijo a las planchas de metal.", eD);
					if (decision2 ==1)
					{
						
						Pantalla24 P24 = new Pantalla24(MC,R);
						P24.pantalla();
						
					}
					else if (decision2 ==2)
					{
						
						Pantalla26 P26 = new Pantalla26(MC,R);
						P26.pantalla();
						
					}
					else
					{
						Pantalla22 P22 = new Pantalla22(MC,R);
						P22.pantalla();
					}
				}
				 //Si esta muerto, pueden pasar varias cosas:
				//que ya hayas estado antes estando vivo el dragon, entonces lo que hay es el cadaver
				//que entre, el dragon este muerto y no haya entrado cuando estaba vivo, entonces tienes una mujer sanadora que te puede teletransportar a P6
				else
				{
					if (estadoCabanya.equals("yahapasadoymuerte"))
					{
						System.out.println("\nEntras en la cabaña y todo está lleno de sangre.");
						System.out.println("La misma escena que antes, sólo que el hedor se empieza a apoderar de la escena.");
						System.out.println("Sin embargo, confías en que la amenaza haya sido erradicada.");
						System.out.println("Sales de la cabaña, estás a punto de vomitar.");
						System.out.println("Tienes ahora tres opciones:");
						System.out.println("Al oeste, ves un gran cúmulo de nubes por esa zona.");
						System.out.println("Al este, más despejado, pero un terreno más escarpado.");
						System.out.println("Tambien, bastante a lo lejos, parece que hay dos planchas de metal grandísimas.");
						int decision2 = FU.decision("Me dirijo al oeste.", "Me dirijo al este.", "Me dirijo a las planchas de metal.", eD);
						if (decision2 ==1)
						{
							
							Pantalla24 P24 = new Pantalla24(MC,R);
							P24.pantalla();
							
						}
						else if (decision2 ==2)
						{
							
							Pantalla26 P26 = new Pantalla26(MC,R);
							P26.pantalla();
							
						}
						else
						{
							Pantalla22 P22 = new Pantalla22(MC,R);
							P22.pantalla();
						}
					}
					else //La curandera, sólo si le da el colgante
					{
						System.out.println("\nEntras en la cabaña y ves a una mujer con un curioso vestido naranja.");
						System.out.println("Te sientes en un lugar cálido.");
						System.out.println("- Hola - dice - ¿has venido por alivio y sosiego?");
						
						if (FU.decision("Sí.", "No.", eD)==1)
						{
							//Algo con el colgante
							String estadoColgante="";
							try
							{
								File file =new File ("Colgante.txt");
								BufferedReader br = new BufferedReader(new FileReader(file));
					            String line;
					            
					            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
					            
					            while ((line = br.readLine()) != null) 
					            {
					                
					                  estadoColgante=line;
					                    
					            }	       	            
					            br.close();			
							}
							catch (Exception e)
							{
								System.out.println("Error al leer el archivo.");
							}
							System.out.println("\nTodos necesitamos cálidez en los momentos en los que peor no sentimos.");
							System.out.println("Te cuenta una historia sobre su aldea de origen, donde vive su hermana gemela.");
							if (estadoBruja.equals("muerta"))
							{
								System.out.println("También que sintió un frío relámpago en su interior y que piensa que ha sido asesinada.");
								System.out.println("- No me caía especialmente bien - añade - admito que no era fácil tratar con ella.");
								System.out.println("Te mira.");
							}
							
							System.out.println("Pero también te cuenta que huyó de su aldea porque por las noches oía rugidos que provenían de unas cavernas que había cerca.");
							System.out.println("Que está bien en las montañas, y que a veces echa de menos oir el ajetreo de los bosques.");
							if (estadoColgante.equals("lotiene") || estadoColgante.equals("recuperado"))
							{
								System.out.println("La mujer se fija en el colgante que llevas.");
								System.out.println("- Muy bien, si me das ese colgante restauraré por completo tu salud o te enviaré a tu ciudad de origen, lo que prefieras.");
								if (FU.decision("Se lo doy.", "Prefiero quedármelo.", eD)==1)
								{
									try
									{
										File Colgante = new File ("Colgante.txt");
									    BufferedWriter writer = new BufferedWriter(new FileWriter(Colgante, false));				 
									    writer.write("dadoalacurandera");
									    writer.close();
									}
									catch (Exception e)
									{
										System.out.println("Error al escribir que el colgante se lo ha dado a la curandera." + e);
									}	
									System.out.println("\n- ¡Ay sí! - exclama - ¡Me encanta!");
									System.out.println("Ves cómo sonríe, realmente le gusta el colgante");
									System.out.println("- Muy bien, ¿prefieres restaurar tu salud o volver a tu lugar de origen?");
									if (FU.decision("Restaurar mi salud.", "Volver a mi ciudad de origen.", eD)==1)
									{
										System.out.println("\nLa mujer pone sus manos sobre tu espalda y sobre tu frente.");
										System.out.println("Te sientes mucho mejor.");
										getMC().setVida(getMC().getVidaMaxima());
										System.out.println("Sales por la puerta.");
										System.out.println("Tienes ahora tres opciones:");
										System.out.println("Al oeste, ves un gran cúmulo de nubes por esa zona.");
										System.out.println("Al este, más despejado, pero un terreno más escarpado.");
										System.out.println("Tambien, bastante a lo lejos, parece que hay dos planchas de metal grandísimas.");
										int decision2 = FU.decision("Me dirijo al oeste.", "Me dirijo al este.", "Me dirijo a las planchas de metal.", eD);
										if (decision2 ==1)
										{
											
											Pantalla24 P24 = new Pantalla24(MC,R);
											P24.pantalla();
											
										}
										else if (decision2 ==2)
										{
											
											Pantalla26 P26 = new Pantalla26(MC,R);
											P26.pantalla();
											
										}
										else
										{
											Pantalla22 P22 = new Pantalla22(MC,R);
											P22.pantalla();
										}
									}
									else
									{
										System.out.println("\nLa mujer pone sus manos sobre tus ojos y sientes cómo te desvaneces.");
										
										Pantalla6 P6 = new Pantalla6 (getMC(),R);
										P6.pantalla();
									}
								}
								else
								{
									System.out.println("\n- Bueno, espero entonces que te sientas bien - dice - adios.");
									System.out.println("Sales por la puerta.");
									System.out.println("Tienes ahora tres opciones:");
									System.out.println("Al oeste, ves un gran cúmulo de nubes por esa zona.");
									System.out.println("Al este, más despejado, pero un terreno más escarpado.");
									System.out.println("Tambien, bastante a lo lejos, parece que hay dos planchas de metal grandísimas.");
									int decision2 = FU.decision("Me dirijo al oeste.", "Me dirijo al este.", "Me dirijo a las planchas de metal.", eD);
									if (decision2 ==1)
									{
										
										Pantalla24 P24 = new Pantalla24(MC,R);
										P24.pantalla();
										
									}
									else if (decision2 ==2)
									{
										
										Pantalla26 P26 = new Pantalla26(MC,R);
										P26.pantalla();
										
									}
									else
									{
										Pantalla22 P22 = new Pantalla22(MC,R);
										P22.pantalla();
									}
								}
							}
							else
							{
								System.out.println("- Sin embargo, siento decirte que no tienes nada de valor para mí...");
								System.out.println("- Me encantan las joyas, vuelve cuando tengas una.");
								System.out.println("Sales de la cabaña");
								System.out.println("Tienes ahora tres opciones:");
								System.out.println("Al oeste, ves un gran cúmulo de nubes por esa zona.");
								System.out.println("Al este, más despejado, pero un terreno más escarpado.");
								System.out.println("Tambien, bastante a lo lejos, parece que hay dos planchas de metal grandísimas.");
								int decision2 = FU.decision("Me dirijo al oeste.", "Me dirijo al este.", "Me dirijo a las planchas de metal.", eD);
								if (decision2 ==1)
								{
									
									Pantalla24 P24 = new Pantalla24(MC,R);
									P24.pantalla();
									
								}
								else if (decision2 ==2)
								{
									
									Pantalla26 P26 = new Pantalla26(MC,R);
									P26.pantalla();
									
								}
								else
								{
									Pantalla22 P22 = new Pantalla22(MC,R);
									P22.pantalla();
								}
							}
						
						}
						else
						{
							System.out.println("\n- Bueno, espero entonces que te sientas bien - dice - adios.");
							System.out.println("Sales por la puerta.");
							System.out.println("Tienes ahora tres opciones:");
							System.out.println("Al oeste, ves un gran cúmulo de nubes por esa zona.");
							System.out.println("Al este, más despejado, pero un terreno más escarpado.");
							System.out.println("Tambien, bastante a lo lejos, parece que hay dos planchas de metal grandísimas.");
							int decision2 = FU.decision("Me dirijo al oeste.", "Me dirijo al este.", "Me dirijo a las planchas de metal.", eD);
							if (decision2 ==1)
							{
								
								Pantalla24 P24 = new Pantalla24(MC,R);
								P24.pantalla();
								
							}
							else if (decision2 ==2)
							{
								
								Pantalla26 P26 = new Pantalla26(MC,R);
								P26.pantalla();
								
							}
							else
							{
								Pantalla22 P22 = new Pantalla22(MC,R);
								P22.pantalla();
							}
						}
					
					}
				}
			}
			
			else if (decision ==2)
			{
				
				Pantalla24 P24 = new Pantalla24(MC,R);
				P24.pantalla();
				
			}
			else if (decision ==3)
			{
				
				Pantalla26 P26 = new Pantalla26(MC,R);
				P26.pantalla();
				
			}
			else
			{
				Pantalla22 P22 = new Pantalla22(MC,R);
				P22.pantalla();
			}

		}
}
