package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla16 
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
	public Pantalla16 (Personaje MC, Random R)
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
			
			
			System.out.println("Las grandes puertas de La Montaña se alzan imponentes.");
			if (estadoMontañas.equals("abiertas")||getMC().getNombre().equals("Carlos"))
			{
			System.out.println("Abiertas de par en par, un aire frio proviene de las montañas.");
			System.out.println("Algunos árboles incluso se mueven con su paso.");
			System.out.println("Algo ha debido pasar, porque está todo vacío y hay huellas recientes de personas.");
			System.out.println("El viento vuelve a soplar.");
			
			//Si están abiertas o eres Carlos puedes ir a P19 o a P11
			//Hay que preguntar y lo que el usuario decida
			
			System.out.println("Tienes dos opciones ahora.");
			System.out.println("O bien ir hacia el valle, o bien ir a las montañas.");
			
			if (FU.decision("Prefiero ir al valle.", "Iré a las montañas.", eD)==1)
			{
				Pantalla11 P11 = new Pantalla11(MC,R);
				P11.pantalla();
			}
			else
			{
				System.out.println("\nCruzas al otro lado.");
				Pantalla19 P19 = new Pantalla19(MC,R);
				P19.pantalla();
			}
			
			
	
			
			
			}
			else
			{
				System.out.println("Imponentes y firmes, dos amplias planchas de metal forjado se presentan ante ti.");
				System.out.println("Pocas personas rondan por el lugar, la mayoría aventureros.");
				System.out.println("Dos de ellos discuten acaloradamente.");
				System.out.println("-¡Que no! - Dice uno - Te digo que la clave está en completar el círculo.");
				System.out.println("-Y dale - Dice otro - Te digo que está en encontrar la joya perdida.");
				System.out.println("El gélido viento de las montañas sopla con fuerza, y te preguntas hasta qué punto estás en el lugar adecuado.");
				System.out.println("¿Cuál es el lugar adecuado? - Te preguntas.");
				System.out.println("Desde luego, aquí no parece que la situación vaya a evolucionar.");
				System.out.println("Te preguntas si estás en el lugar adecuado.");
				
				if(FU.decision("Espero.", "Me marcho", eD)==1)
				{
					System.out.println("\nEsperas un poco, la discusión parece que se apacigua.");
					System.out.println("El viento sopla más suavemente.");
					System.out.println("Ves dos pájaros sobrevolar el cielo.");
					System.out.println("Al darte la vuelta puedes ver el valle con las nubes carácterísticas de esta época del año.");
					System.out.println("Te preguntas qué estás esperando de qué o de quién.");
					System.out.println("La valentía de ti mismo, posiblemente.");
					System.out.println("Te sientes mejor, al menos más liviano, y vuelves por donde has venido.");
					System.out.println("\n-Pues yo te digo que la clave está en explorarlo todo.");
					System.out.println("-Sí claro, o en llamarte Carlos."); //Porque con ese nombre está todo abierto
					Pantalla11 P11 = new Pantalla11 (getMC(), R);
					P11.pantalla();
				}
				else
				{
					System.out.println("\nVuelves por donde has venido, un poco insulso quizás.");
					
					Pantalla11 P11 = new Pantalla11 (getMC(), R);
					P11.pantalla();
					
				}
				
				
				
			}

		}

}
