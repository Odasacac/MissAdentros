package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla13 {
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
	public Pantalla13 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla de las cuevas
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
		
			
			System.out.println("\n~El interior del subsuelo~\n");
			
			System.out.println("La oscuridad sería casi completa si no fuese por unos agujeros hechos en los techos que permiten que pase algo de luz.");
			System.out.println("Oyes a lo lejos agua gotear lentamente.");
			System.out.println("Tus pasos hacen un suave eco y puedes oir tu respiración.");
			System.out.println("Tras caminar un buen rato por los pasadizos, te encuentras con tres puertas.");
			System.out.println("La puerta de la izquierda, tiene un gran arañazo y está algo deteriorada en general.");
			System.out.println("La puerta del centro, tiene el pomo muy gastado y puede intuirse algo de luz tras ella.");
			System.out.println("La puerta de la derecha, nada destacable a primera vista, quizás es la que está en mejor estado.");
			
			int decision = FU.decision("Iré por la puerta de la izquierda", "Iré por la puerta central", "Iré por la puerta de la derecha", eD);
			
			if (decision==1)
			{
				//Aqui hay un objeto especial
				String estadoDelObjeto="variableInicial";
				
				try {	
					 	File file = new File("ObjetoCuevas.txt");
			            BufferedReader br = new BufferedReader(new FileReader(file));
			            String line;
			            
			            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
			            
			            while ((line = br.readLine()) != null) 
			            {
			                
			                  estadoDelObjeto=line;
			                    
			            }	       	            
			            br.close();
					}
					catch(Exception e)
					{
						System.out.println("Error al leer el archivo ObjetoCuevas");
					}
					
			  
					if (estadoDelObjeto.equals("nolotiene")) 
					{
						//Si aun no lo ha cogido, lo coge
						System.out.println("\nLa sala es amplia, llena de azulejos y más iluminada que las demás.");
						System.out.println("En el centro hay un gran escudo.");
						
						if(FU.decision("Cojo el escudo.", "Me voy, no quiero nada.", eD)==1)
						{
							System.out.println("\nCargas con el escudo.");
							System.out.println("Te sientes más seguro con él.");
							getMC().setDefensa(getMC().getDefensa()+30);
							System.out.println("\nAl fondo hay una puerta, y tras ella un túnel que te conduce al exterior.");
							try {	
						
							 	File file = new File("ObjetoCuevas.txt");
							 	  BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
								    writer.write("lotiene");
								    writer.close();
							}
							catch (Exception e)
							{
								System.out.println("Error al actualizar el objeto.");
							}
							
							Pantalla14 P14 = new Pantalla14 (getMC(),R);
							P14.pantalla();
							
						}
						else
						{
							System.out.println("Echas un pequeño ojo más a la sala, pero nada llama tu atención.");
							System.out.println("\nAl fondo hay una puerta, y tras ella un túnel que te conduce al exterior.");
							Pantalla14 P14 = new Pantalla14 (getMC(),R);
							P14.pantalla();
						}
	      
					}
					else
					{
						//Si lo ha cogido, pues un cofre vacio o algo
						System.out.println("\nLa sala es amplia, llena de azulejos y más iluminada que las demás.");
						System.out.println("Echas un pequeño ojo más a la sala, pero nada llama tu atención.");
						System.out.println("\nAl fondo hay una puerta, y tras ella un túnel que te conduce al exterior.");
						Pantalla14 P14 = new Pantalla14 (getMC(),R);
						P14.pantalla();
					}
			}
			if (decision==2)
			{
				System.out.println("\nEntras en una sala vacía, no hay nada reseñable.");
				System.out.println("Un aire limpio suaviza la estancia, eso sí.");
				System.out.println("\nAl fondo hay una puerta, y tras ella un túnel que te conduce al exterior.");
				Pantalla14 P14 = new Pantalla14 (getMC(),R);
				P14.pantalla();
			}
			if (decision==3)
			{
				//Lo que haya aqui dentro dependera del estado de MA (enfadada, triste, contenta)
				String estadoMA="";
				try 
				{	
				 	File file = new File("MissAdentros.txt");
		            BufferedReader br = new BufferedReader(new FileReader(file));
		            String line;
		           
		            while ((line = br.readLine()) != null) 
		            {
		                  estadoMA=line;                   
		            }	       	            
		            br.close();
				}
				
		        catch (Exception e)
		        {
		            System.out.println("Error al leer los archivos.");
		        }
				
				
				if (estadoMA.equals("inicio"))
				{
					System.out.println("\nEntras en una sala vacía, no hay nada reseñable.");
					System.out.println("Un aire viciado impregna la estancia, eso sí.");
					System.out.println("Al fondo hay una puerta abierta, y tras ella un túnel que te conduce al exterior.");
					Pantalla14 P14 = new Pantalla14 (getMC(),R);
					P14.pantalla();
				}
				
				String estadoSer="";
				
				
				try 
				{	
				 	File file = new File("SerCuevas.txt");
		            BufferedReader br = new BufferedReader(new FileReader(file));
		            String line;
		           
		            while ((line = br.readLine()) != null) 
		            {
		                  estadoSer=line;                   
		            }	       	            
		            br.close();
				}
				
		        catch (Exception e)
		        {
		            System.out.println("Error al leer los archivos.");
		        }
				if (estadoMA.equals("contenta"))
					{
						System.out.println("\nEntras en una sala vacía, no hay nada reseñable.");
						System.out.println("Un aire limpio te hace sentir cómodo aquí.");
						System.out.println("Un pequeño gorrión blanco revolotea por el lugar.");
						System.out.println("Estás contento, te sientes incluso restaurado.");
						getMC().setVida(getMC().getVidaMaxima());
						System.out.println("\nAl fondo hay una puerta, y tras ella un túnel que te conduce al exterior.");
						Pantalla14 P14 = new Pantalla14 (getMC(),R);
						P14.pantalla();
					}
				if (estadoSer.equals("vivo")) //Si le vence, se le cambia a muerto el estado
					{
					if (estadoMA.equals("triste"))
					{
		
							System.out.println("\nUn bello pero vacío ser alado, envuelto en telas y empapado respira entrecortadamente.");
							System.out.println("Se gira y al verte oculta su rostro y huye.");
							System.out.println("\nAl fondo hay una puerta, y tras ella un túnel que te conduce al exterior.");
							Pantalla14 P14 = new Pantalla14 (getMC(),R);
							P14.pantalla();
							
					}
					else if (estadoMA.equals("enfadada"))//Si esta enfadada
					{
							int suerte = R.nextInt(11);
							System.out.println("\nUn desfigurado ser alado, vestido de fuego y envuelto en un humo denso respira intensamente.");
							System.out.println("Se gira y al verte se lanza iracundo hacia ti.");
							Personaje E1=new Personaje ("Demonio de la cueva", 5, suerte, 20, 150, 0); //Enfadada, asi que sin defensa, con poca vida, pero con mucho ataque, obvio Berserk
						
					
							FU.batalla(getMC(),E1);
					
							if (getMC().getVida() >= E1.getVida())
							{
								try 
								{
									File SerCuevas = new File("SerCuevas.txt");							   
									BufferedWriter writer = new BufferedWriter(new FileWriter(SerCuevas, false));				 
									writer.write("muerto");
									writer.close();
								}
								catch (Exception e)
								{
									System.out.println("Error al actualizar a muerto al ser de la cueva");
								}
						
								System.out.println("El cuerpo de ser se desploma ante ti.");
								System.out.println("Peculiar, parece extraído de la mente fantasiosa de alguien.");
								System.out.println("Al fondo hay una puerta, y tras ella un túnel que te conduce al exterior.");
								Pantalla14 P14 = new Pantalla14 (getMC(),R);
								P14.pantalla();
							}
						}
						else
						{
							System.out.println("MA no esta ni triste ni enfadada ni contenta.");
						}
					}
				else
				{
					System.out.println("\nEntras en una sala vacía, no hay nada reseñable.");
					System.out.println("Sólo el cadáver de la criatura que derrotaste antes.");
					if (estadoMA.equals("contenta"))
					{
						System.out.println("A pesar de ello, un aire limpio te hace sentir cómodo aquí.");
					}
					System.out.println("Al fondo hay una puerta, y tras ella un túnel que te conduce al exterior.");
					Pantalla14 P14 = new Pantalla14 (getMC(),R);
					P14.pantalla();
					
				}
			}

		}

}
