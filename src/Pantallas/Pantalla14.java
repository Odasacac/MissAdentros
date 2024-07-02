package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla14 {
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
	public Pantalla14 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla de fuera cuevas
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			
			
			System.out.println("\n~Una colina con miles de ojos~\n");
			
			System.out.println("Una estructura natural peculiar.");
			System.out.println("Una alta y verde colina con muchísimos agujeros con los que poder acceder a su interior.");
		
			
			
			if(FU.decision("Entro.", "Me marcho.", eD)==1)
			{
				Pantalla13 P13 = new Pantalla13 (getMC(),R);
				P13.pantalla();
			}
			else
			{	

				String estadoDeLaCueva="variableInicial";
				
				try {	
					 	File file = new File("Cuevas.txt");
			            BufferedReader br = new BufferedReader(new FileReader(file));
			            String line;
			            
			            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
			            
			            while ((line = br.readLine()) != null) 
			            {
			                
			                  estadoDeLaCueva=line;
			                    
			            }	       	            
			            br.close();
				}
				catch (Exception e)
				{
					System.out.println("Error al leer el archivo de la cueva.");
				}
				if (estadoDeLaCueva.equals("si"))
				{
					System.out.println("\nVes un camino que lleva a una señal y lo sigues.");
					Pantalla8 P8 = new Pantalla8 (getMC(),R);
					P8.pantalla();
					try {
					  File Cuevas = new File("Cuevas.txt");
					    // Crear FileWriter con append = false para sobrescribir el archivo
					    BufferedWriter writer = new BufferedWriter(new FileWriter(Cuevas, false));				 
					    writer.write("no");
					    writer.close();
					}
					catch (Exception e)
					{
						System.out.println("Error al cambiar a no en la cueva.");
					}
					
					
				}
				else
				{
					System.out.println("\nVuelves a la señal.");
					Pantalla8 P8 = new Pantalla8 (getMC(),R);
					P8.pantalla();
				}
				
					
			}
			
		
		}

}
