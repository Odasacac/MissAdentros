package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla8 {
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
	public Pantalla8 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla del cruce de la aldea
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			
			System.out.println("\n~Más decisiones~\n");
			
			System.out.println("Llegas a un pequeño claro en el bosque.");
			String estadoColgante = "";
			try 
			{
				
			 	File file = new File("Colgante.txt");
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
				System.out.println("Error al leer el fichero.");
			}
			
			
		
			String colgante = "";
			
			
			if (estadoColgante.equals("nolotiene"))
			{
				colgante = " y un colgante";				
			}
			else
			{
				colgante = "";
			}
			
			
			
			System.out.println("En en el centro se alza un poste de madera con tres flechas"+colgante+".");
			if (estadoColgante.equals("nolotiene"))
			{
				System.out.println("Lees las flechas y coges el colgante.");
			
				try
				{
					File file = new File("Colgante.txt");
					BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
					writer.write("lotiene"); 
					writer.close();
					
					File file2 = new File("Montañas.txt");
					writer = new BufferedWriter(new FileWriter(file2, false));
					writer.write("abiertas"); 
					writer.close();	
					
					
				}
				catch (Exception e)
				{
					System.out.println("Error al cambiar el estado.");
				}
				System.out.println("Unos pájaros a lo lejos se ven volar de repente, probablemente oyesen un fuerte sonido.");
			}	
			System.out.println("Una de ellas tiene escrita la palabra Cuevas, y un añarazo.");
			System.out.println("La otra la palabra Posada.");
			System.out.println("Y la última Aldea.");
			
			
			int decision=FU.decision("Voy a las cuevas.", "Prefiero dirigirme a la Posada.", "Quiero ir a la aldea.", eD);
		
			
			if (decision==1)
			{
				Pantalla14 P14 = new Pantalla14 (getMC(), R); //A lafueraCuevas
				P14.pantalla();
			}
			else if (decision==2)
			{
				Pantalla12 P12 = new Pantalla12 (getMC(), R);  //A la posada
				P12.pantalla();
			}
			else
			{
				Pantalla7 P7 = new Pantalla7 (getMC(), R); //A la aldea
				P7.pantalla();
			}
			
	
		}

}
