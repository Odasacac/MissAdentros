package Pantallas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla19 
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
	public Pantalla19 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla despues de elegir ir a las montañas al principio, en el cruce
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			
			
			
			System.out.println("\n~Las puertas de La Montaña~\n");
			//Esta pantalla depende de si las puertas de las montañas estan abiertas o cerradas, a leer
			String estadoMontañas="";
			try 
			{
				File file = new File ("Montañas.txt");
				
				BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	            
	            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
	            
	            while ((line = br.readLine()) != null) 
	            {
	                
	                  estadoMontañas=line;
	                    
	            }	       	            
	            br.close();		
				
				
			}
			catch (Exception e)
			{
				System.out.println("Error al leer el archivo");
			}
			
			System.out.println("Las grandes puertas de La Montaña se alzan resistiendo el paso del viento.");
			if (estadoMontañas.equals("abiertas")||getMC().getNombre().equals("Carlos"))
			{
				System.out.println("Abiertas de par en par, un amplio bosque se puede ver a lo lejos en el valle.");
				System.out.println("Además, hay dos caminos que se adentran en las montañas.");
				System.out.println("Uno, hacia el norte, pedregoso y que parece que las bordean.");
				System.out.println("Otro, al sur, algo más demandante físicamente y que inicia el ascenso a los picos.");
				//Si están abiertas o eres Carlos puedes ir a P20, a P 21 o a P16
				//Hay que preguntar y lo que el usuario decida
				
				int decision = FU.decision("Prefiero ir al valle.", "Iré por el camino pedregoso.","Decido iniciar el ascenso.", eD);
				
				
				if (decision==1)
				{
					System.out.println("\nCruzas al otro lado.");
					Pantalla16 P16 = new Pantalla16(MC,R);
					P16.pantalla();
				}
				else if (decision ==2)
				{
					Pantalla21 P21 = new Pantalla21(MC,R);
					P21.pantalla();
				}
				else
				{
					Pantalla20 P20 = new Pantalla20(MC,R);
					P20.pantalla();
				}
			}
			else
			{
				System.out.println("Las puertas están firmemente cerradas, son gigantescas y pesadas.");
				System.out.println("No creo que puedan forzarse.");
				System.out.println("Quedan dos caminos.");
				System.out.println("Uno, pedregoso que parece que las bordean.");
				System.out.println("Otro, algo más demandante físicamente que inicia el ascenso a los picos.");
				
				if (FU.decision("Iré por el camino pedregoso.","Decido iniciar el ascenso.", eD)==1)
				{
					Pantalla21 P21 = new Pantalla21(MC,R);
					P21.pantalla();
				}
				else
				{
					Pantalla20 P20 = new Pantalla20(MC,R);
					P20.pantalla();
				}
			}
			
			
			
			
			
			
		}
}
		