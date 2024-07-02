package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla12 {
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
	public Pantalla12 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla de la posada
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			
			
			System.out.println("\n~Vestigios de un tiempo mejor~\n");
			
			System.out.println("Bienvenido a la posada, un lugar tranquilo y con buena música.");
			System.out.println("Aunque no con poca compañía sin intereses.");
			System.out.println("Sea como fuere, te relajas y tomas un buen almuerzo.");
			getMC().setVida(getMC().getVidaMaxima());
			System.out.println("Te sientes mejor.");
			
			String estadoColgante="";
			
			//Algo con el colgante
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
			
			if (estadoColgante.equals("lotiene"))
			{
				//Si tiene el colgante, le habla el señor
				System.out.println("Un señor se acerca y te pregunta por el colgante.");
				System.out.println("Dice que es de un amigo suyo.");
				System.out.println("- ¿Podrías dármelo? - pregunta.");
				
				
				if(FU.decision("Sí.", "No.", eD)==1)
				{
					System.out.println("\nGracias.- Dice");
					System.out.println("Ya no tienes el colgante.");
					System.out.println("El señor de marcha de la posada.");
					try
					{
					File file = new File("Colgante.txt");
					BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
				    writer.write("perdido"); 
				    writer.close();
					}
					catch(Exception e)
					{
						System.out.println("Error al actualizar a perdido.");
					}
				}
				else
				{
					System.out.println("\nTe mira con mala cara y se va.");
				}
			}
			else if (estadoColgante.equals("recuperado"))
			{
				System.out.println("Un señor se acerca y te pregunta por el colgante.");
				System.out.println("Dice que es de un amigo suyo.");
				System.out.println("- ¿Me lo darías? - pregunta.");
				if(FU.decision("Sí, pero sólo por algo a cambio.", "No.", eD)==1)
				{
					System.out.println("\n- ¡Ah pequeña víbora! - Exclama.");
					System.out.println("- Muy bien - añade - Te diré que bajo las cuevas, la opción central es siempre segura.");
					System.out.println("\nEl señor ha cumplido su parte, así que le das el colgante.");
					
					try
					{
					File file = new File("Colgante.txt");
					BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
				    writer.write("entregado"); 
				    writer.close();
					}
					catch(Exception e)
					{
						System.out.println("Error al actualizar a perdido.");
					}
				}
				else
				{
					System.out.println("Te mira con mala cara y se va.");
				}
				
			}
			else
			{
				//Si no lo tiene, no pasa nada, algo descriptivo
			}
			
		
			
			System.out.println("\nTienes dos opciones ahora.");
			System.out.println("Tomar el camino que lleva a la ciudad.");
			System.out.println("O tomar el camino que se dirige al bosque.");
			
			if (FU.decision("Tomo el camino que va a la ciudad.", "Iré dirección al bosque.", eD)==1)
			{
				Pantalla15 P15 = new Pantalla15 (getMC(), R); //Al caballero
				P15.pantalla();
			}
			else
			{
				Pantalla8 P8 = new Pantalla8 (getMC(), R); //Al cruce de la ladea
				P8.pantalla();
			}

		}

}
