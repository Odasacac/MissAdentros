package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla22 {
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
	public Pantalla22 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla del atajo, entre las puertas de la montaña y los lagos
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			
			
			
			System.out.println("\n~Un punto de encuentro~\n");
			//Esta pantalla depende de si ha atajado o no
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
			String estadoAtajo = "";
			try 
			{
				
			 	File file = new File("Atajo.txt");
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	            
	            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
	            
	            while ((line = br.readLine()) != null) 
	            {
	                
	                  estadoAtajo=line;
	                    
	            }	       	            
	            br.close();
			}
			catch (Exception e)
			{
				System.out.println("Error al leer el fichero de MA.");
			}
			String estadoP22 = "";
			try 
			{
				
			 	File file = new File("P22.txt");
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	            
	            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
	            
	            while ((line = br.readLine()) != null) 
	            {
	                
	                  estadoP22=line;
	                    
	            }	       	            
	            br.close();
			}
			catch (Exception e)
			{
				System.out.println("Error al leer el fichero de MA.");
			}
			
			
			if (estadoAtajo.equals("atajado")&&estadoP22.equals("nohallegadoaun"))
			{
				try
				{
					File P22 = new File ("P22.txt");
				    BufferedWriter writer = new BufferedWriter(new FileWriter(P22, false));				 
				    writer.write("yahapasado");
				    writer.close();
				}
				catch (Exception e)
				{
					System.out.println("Error al escribir que ya ha pasado por P22." + e);
				}	
				
				System.out.println("Los atajos conducen a situaciones de forma más rápida que otras opciones.");
				System.out.println("Sin embargo, llegar antes de hora quizás no siempre es lo más adecuado.");
				
				System.out.println("Una amplia cordillera se muestra ante ti.");
				System.out.println("El tiempo parece ir más despacio y una relativa tranquilidad se apodera de tus pensamientos.");
				System.out.println("Fijándote algo mejor, detectas un rastro en el suelo.");
				System.out.println("Desde luego no es humano, el rastro parece dirigirse en dirección a una cabaña cercana.");
				System.out.println("De repente ves algo oscuro que se adentra por entre las rocas.");
				
				if (FU.decision("Era muy grande, prefiero hacer como que no he visto nada.", "Me dirijo a por donde se ha escondido.", eD)==1)
				{
					System.out.println("\nDejas pasar un poco el tiempo.");
					System.out.println("A lo lejos ves unas grandes placas de metal, parecen ser una puerta.");
					System.out.println("Un poco más cerca, una pequeña cabaña.");
					
					if (FU.decision("Voy a la cabaña.", "Decido ir a las puertas", eD)==1)
					{
						Pantalla23 P23 = new Pantalla23(MC,R);
						P23.pantalla();
					}
					else
					{
						Pantalla21 P21 = new Pantalla21(MC,R);
						P21.pantalla();
					}
				}
				else
				{
					System.out.println("\nSigues el rastro de lo que te ha parecido que era una criatura.");
					System.out.println("Te encuentras rodeado ahora por altos picos y sientes un extraño tipo de presencia.");
					System.out.println("Un enorme dragon negro aparece de entre las rocas y te ataca.");
					
					int suerte = R.nextInt(11);
					Personaje Dragon = new Personaje ("Dragón alado", 4, suerte, 150, 60, 40);
					FU.batalla(Dragon, getMC());
					
					if (getMC().getVida() >= Dragon.getVida())
					{
						//Lo primero es cambiar el estado del dragon a muerto, por si se vuelve a esta pantalla que no aparezca
						try 
						{
						File file = new File ("DragonAlado.txt");
					    // Crear FileWriter con append = false para sobrescribir el archivo
					    BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
					    writer.write("muerto");
					    writer.close();
					    
					    File file2 = new File ("Colmillo.txt");
					    // Crear FileWriter con append = false para sobrescribir el archivo
					   writer = new BufferedWriter(new FileWriter(file2, false));
					    writer.write("lotiene");
					    writer.close();
						
						}
						catch (Exception e)
						{
							System.out.println("Error al leer el fichero de MA.");
						}
						System.out.println("\nEl dragón se desploma frente a ti.");
						System.out.println("Quién lo diría, yo pensaba que el dragón te vencería, era un enemigo poderoso.");
						System.out.println("¡Enhorabuena!");
						System.out.println("Guardas uno de sus colmillos como trofeo.");
						System.out.println("Vuelves por donde habías venido.");
						System.out.println("A lo lejos ves unas grandes placas de metal, parecen ser una puerta.");
						System.out.println("Un poco más cerca, una pequeña cabaña.");
						
						if (FU.decision("Voy a la cabaña.", "Decido ir a las puertas.", eD)==1)
						{
							Pantalla23 P23 = new Pantalla23(MC,R);
							P23.pantalla();
						}
						else
						{
							Pantalla21 P21 = new Pantalla21(MC,R);
							P21.pantalla();
						}
					}
					
				}
				
			}
			else
			{
				try
				{
					File P22 = new File ("P22.txt");
				    BufferedWriter writer = new BufferedWriter(new FileWriter(P22, false));				 
				    writer.write("yahapasado");
				    writer.close();
				}
				catch (Exception e)
				{
					System.out.println("Error al escribir que ya ha pasado por P22." + e);
				}	
				
				System.out.println("Una extraña sensacion te invade.");
				System.out.println("No hay nada especial en esta zona, pero a la misma vez sientes que lo ha podido haber antes.");
				System.out.println("Fijándote algo mejor, detectas un rastro en el suelo.");
				if (estadoDragon.equals("muerto"))
				{
					System.out.println("El recuerdo de tus experiencias te ayuda a reconocer que se trata del dragón negro que derrotaste.");
				}
				else
				{
					System.out.println("Desde luego no es humano, el rastro parece dirigirse en dirección a una cabaña cercana.");
				}
				System.out.println("Por otro lado, a lo lejos ves unas grandes placas de metal, parecen ser una puerta.");
				System.out.println("La cabaña está algo más cerca.");
				
				if (FU.decision("Voy a la cabaña.", "Decido ir a las puertas.", eD)==1)
				{
					Pantalla23 P23 = new Pantalla23(MC,R);
					P23.pantalla();
				}
				else
				{
					Pantalla21 P21 = new Pantalla21(MC,R);
					P21.pantalla();
				}
			}
			
			
			

		}
}
