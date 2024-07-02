package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla21 {
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
	public Pantalla21 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla para iniciar el bordear las montañas
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			
			
			System.out.println("\n~El camino pedregoso~\n");
			
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
			
			String estadoSenyorMontanyas = "";
			try 
			{
				
			 	File file = new File("SenyorMontanyas.txt");
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	            
	            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
	            
	            while ((line = br.readLine()) != null) 
	            {
	                
	                  estadoSenyorMontanyas=line;
	                    
	            }	       	            
	            br.close();
			}
			catch (Exception e)
			{
				System.out.println("Error al leer el fichero.");
			}
			
			String estadoMA = "";
			try 
			{
				
			 	File file = new File("MissAdentros.txt");
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	            
	            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
	            
	            while ((line = br.readLine()) != null) 
	            {
	                
	                  estadoMA=line;
	                    
	            }	       	            
	            br.close();
			}
			catch (Exception e)
			{
				System.out.println("Error al leer el fichero.");
			}
			
			
			System.out.println("Algún pájaro ves a lo lejos, sobre extensos mantos de negros pinares.");
			System.out.println("La brisa llena de fresco tus pulmones.");
			System.out.println("Un paisaje completo en detalles y profundo de armonía.");
			System.out.println("Piensas acerca de la felicidad.");
			
			if (estadoMA.equals("contenta"))
			{
				System.out.println("Quizás te sientes bien y con eso te basta.");
				System.out.println("De repente la tranquilidad se ha apoderado de todo.");
			}
			else if (estadoMA.equals("triste"))
			{
				System.out.println("¿Qué es la felicidad?");
			}
			else if (estadoMA.equals("enfadada"))
			{
				System.out.println("¿Felicidad? Déjame de tonterías anda.");
			}
			else if (estadoMA.equals("inicio"))
			{
				System.out.println("Estar en la misma búsqueda de la felicidad es lo que me hace feliz y dichoso.");
				System.out.println("De repente la tranquilidad se ha apoderado de todo.");
			}
			else
			{
				System.out.println("MA no sabe cómo se siente.");
				System.out.println("Estado: " + estadoMA);
			
			}
	
	
			
			
			if (estadoSenyorMontanyas.equals("nohablado"))
			{
				System.out.println("\nUn señor mayor, con barba blanca, calva coronilla y manto negro te saca de tus pensamientos");
				System.out.println("- Hola - dice - ¿cómo va eso?");
	
				
				if(FU.decision("Te acercas a saludar.", "Pasas de largo.", eD)==1)
				{	System.out.println("");
					if (estadoAtajo.equals("atajado"))
					{
					System.out.println("- Eres una persona impaciente, por lo que veo.");
					}
					else
					{
						System.out.println("- Bienvenido a las montañas.");
						System.out.println("- Un lugar para pasear y disfrutar de las vistas.");
						System.out.println("- Me alegra que hayas llegado hasta aquí.");
					}
					System.out.println("- Escúchame bien porque no estaré mucho más por aquí.");
					System.out.println("Levanta su mano y señala a hacia un punto.");
					System.out.println("- Por allí, es el norte, donde se encuentran los lagos del ensueño.");
					System.out.println("Señala hacia otro punto.");
					System.out.println("- Por allí, es el sur, es donde están las puertas de la montaña y el inicio del asecnso.");
					System.out.println("Señala hacia otro punto.");
					System.out.println("- Por allí, es el este, allí está la Cima de los Nueve destinos, pero tienes que ir hacia el sur si quieres subir.");
					System.out.println("Baja de la roca en la que estaba sentado.");
					System.out.println("- Y finalmente, por allí es el oeste, pero esa zona ya la conoces.");
					System.out.println("- Ten cuidado, seres extraños y peligrosos rondan estos lugares.");
					try
					{
						File SenyorMontanyas = new File ("SenyorMontanyas.txt");
					    BufferedWriter writer = new BufferedWriter(new FileWriter(SenyorMontanyas, false));				 
					    writer.write("hablado");
					    writer.close();
					}
					catch (Exception e)
					{
						System.out.println("Error al escribir que el señor de las montañas ya ha hablado" + e);
					}		
					System.out.println("El señor se aleja con una sonrisa y deseándote buena suerte.");	
					System.out.println("Tienes varias opciones ahora para elegir.");
					
					if (FU.decision("Iré al sur.", "Iré al norte.", eD)==1)
					{
						Pantalla19 P19 = new Pantalla19(MC,R);
						P19.pantalla();
					}
					else
					{
						Pantalla22 P22 = new Pantalla22(MC,R);
						P22.pantalla();
					}		
				}
				else
				{
					try
					{
						File SenyorMontañas = new File ("SenyorMontanyas.txt");
					    BufferedWriter writer = new BufferedWriter(new FileWriter(SenyorMontañas, false));				 
					    writer.write("hablado");
					    writer.close();
					}
					catch (Exception e)
					{
						System.out.println("Error al escribir que el señor de las montañas ya ha hablado" + e);
					}		
					
					System.out.println("\nSigues tu camino, contemplando el paisaje.");
					System.out.println("- Adios - exclama.");
						
					System.out.println("Sientes que has perdido una oportunidad.");
					System.out.println("Tienes ahora dos opciones.");
					System.out.println("Sigues por el camino hacia donde a lo lejos ves dos planchas de metal gigantes que forman una puerta.");
					System.out.println("Continuas en dirección ascendente donde algo más adelante ves una cabaña.");
					
				
					if (FU.decision("Me dirigo a las puertas.", "Voy hacia la cabaña.", eD)==1)
					{	
						Pantalla19 P19 = new Pantalla19(MC,R);
						P19.pantalla();
					}
					else
					{
						Pantalla22 P22 = new Pantalla22(MC,R);
						P22.pantalla();
					}		
				}		
				
			}
			else if (estadoSenyorMontanyas.equals("hablado"))
			{
				//Si ya le ha hablado, todo descriptivo
				System.out.println("Un fuerte soplo de viento te saca de tus pensamientos.");
				System.out.println("Tienes ahora dos opciones.");
				System.out.println("Sigues por el camino hacia donde a lo lejos ves dos planchas de metal gigantes.");
				System.out.println("Continuas en dirección ascendente donde algo más adelante ves una cabaña.");
				
			
				if (FU.decision("Me dirigo a las puertas.", "Voy hacia la cabaña.", eD)==1)
				{	
					Pantalla19 P19 = new Pantalla19(MC,R);
					P19.pantalla();
				}
				else
				{
					Pantalla22 P22 = new Pantalla22(MC,R);
					P22.pantalla();
				}		
				
				
				
		
			}
			else
			{
				System.out.println("Error. El estadoSenyorBosque no es ninguno.");
				System.out.println("Estado: " + estadoSenyorMontanyas);
			}

			
			
			
		}

}
