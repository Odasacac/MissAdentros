package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla15 
{
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
	public Pantalla15 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla del caballero
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			
			String estadoDelCaballero="variableInicial";
			
			System.out.println("\n~Ecos de vida~\n");
			
			try {	
			 	File file = new File("Caballero.txt");
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	            
	            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
	            
	            while ((line = br.readLine()) != null) 
	            {        
	                 estadoDelCaballero=line;	                    
	            }	       	            
	            br.close();
			}
			catch (Exception e)
			{
				System.out.println("Error al leer el arhivo");
			}
			
			if (estadoDelCaballero.equals("vivo"))
			{
				System.out.println("En el camino te topas con un caballero protegido con una gruesa armadura.");
				System.out.println("Se gira y te habla.");
				System.out.println("- Hola, pareces fuerte, te propongo un duelo. - dice.");
				System.out.println("- Si me derrotas, te mostraré un atajo a las montañas. - añade.");
				System.out.println("- Sin embargo, si te derroto... Bueno, no querrás saber qué haré con tu cuerpo.");
				if (FU.decision("Te enfrentas a él, no parece tan fuerte", "Parece fuerte, y en realidad no estás interesado.", eD)==1)
				{
					//Batalla
					int suerte=R.nextInt(11);
					Personaje Caballero = new Personaje ("Caballero", 1, suerte, 120, 40, 20);
					
					FU.batalla(getMC(), Caballero);
					
					if (getMC().getVida() >= Caballero.getVida())
					{
						
						System.out.println("\nEl cuerpo del caballero cae al suelo de rodillas");
						System.out.println("Levanta su mano y señala un camino entre los árboles.");
						System.out.println("Cae el suelo.");
						System.out.println("Te acercas a él y siente como exhala y ves como su mirada se pierde en algo que ni siquiera percibes.");
						System.out.println("Silencio");
						System.out.println("Te planteas enterrar el cadáver.");
						
						
						if (FU.decision("Lo entierro.", "No lo entierro.", eD)==1)
						{
							try {
							System.out.println("\nHaces un agujero, colocas el cuerpo sin vida y echas tierra encima.");
							System.out.println("Con un par de palos haces una cruz y la colocas sobre la improvisada tumba.");
						    File file = new File ("Caballero.txt");
							BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
						    writer.write("enterrado"); //El cerdo azul inicia vivo
						    writer.close();
							}
							catch (Exception e)
							{
								System.out.println("Error al poner enterrado.");
							}
						}
						else
						{
							try {
								System.out.println("\nRetiras el cadáver del camino.");
							    File file = new File ("Caballero.txt");
								BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
							    writer.write("muerto"); //El cerdo azul inicia vivo
							    writer.close();
								}
								catch (Exception e)
								{
									System.out.println("Error al poner muerto.");
								}
						}
						
						System.out.println("Tienes ahora una decisión que tomar.");
						int decision =FU.decision("Quiero ir a la posada.","Quiero ir a la ciudad.", "Quiero ir por el atajo a las montañas.", eD);
						if (decision==1)
						{
							Pantalla12 P12 = new Pantalla12 (getMC(), R); //A la posada
							P12.pantalla();
						}
						else if (decision ==2)
						{
							Pantalla11 P11 = new Pantalla11 (getMC(), R); //Al cruce
							P11.pantalla();
						}
						else
						{
							Pantalla18 P18 = new Pantalla18 (getMC(), R); //Al atajo
							P18.pantalla();
						}
						
					}
					
					
				}
				else
				{
					System.out.println("\n-¡Muy bien! - dice - Vuelve cuando cambies de opinión.");
					
					
					if (FU.decision("Quiero ir a la posada.","Quiero ir a la ciudad.", eD)==1)
					{
						Pantalla12 P12 = new Pantalla12 (getMC(), R); //A la posada
						P12.pantalla();
					}
					else
					{
						Pantalla11 P11 = new Pantalla11 (getMC(), R); //Al cruce
						P11.pantalla();
					}
				}
				
			}
			else if (estadoDelCaballero.equals("enterrado"))
			{
				System.out.println("La cruz en el camino te hace recordar la batalla contra el caballero.");
				int decision = FU.decision("Quiero ir a la posada.", "Tomo el atajo de las montañas.","Quiero ir a la ciudad.", eD);
				if (decision==1)
				{
					Pantalla12 P12 = new Pantalla12 (getMC(), R); //A la posada
					P12.pantalla();
				}
				else if (decision==2)
				{
					Pantalla18 P18 = new Pantalla18 (getMC(), R); //Al atajo
					P18.pantalla();
				}
				else
				{
					Pantalla11 P11 = new Pantalla11 (getMC(), R); //Al cruce
					P11.pantalla();
				}
			}
			else
			{
				System.out.println("Llegas donde derrotaste al caballero, el cadáver parece haber desaparecido.");
				
				int decision = FU.decision("Quiero ir a la posada.", "Tomo el atajo de las montañas.","Quiero volver al cruce.", eD);
				if (decision==1)
				{
					Pantalla12 P12 = new Pantalla12 (getMC(), R); //A la posada
					P12.pantalla();
				}
				else if (decision==2)
				{
					Pantalla18 P18 = new Pantalla18 (getMC(), R); //Al atajo
					P18.pantalla();
				}
				else
				{
					Pantalla11 P11 = new Pantalla11 (getMC(), R); //Al cruce
					P11.pantalla();
				}
				
			}
	
		}

}
