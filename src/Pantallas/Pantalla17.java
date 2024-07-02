package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla17 
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
	public Pantalla17 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla del final
		{

			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			
		
			
			System.out.println("\n~FINAL~\n");
			
			
			System.out.println("¡Enhorabuena, gracias por haber llegado al final!");
			
			
			//Aquí leer todos los archivos y guardarlos en variables.
			
			
			System.out.println("Cosas que aún quedan por hacer:");
			
			
			
			System.out.println("\nP22, donde se llega desde el atajo\n");
			
			System.out.println("\nLas montañas\n");
	

			try 
			{	
				File file = new File("Final.txt");
				BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
				writer.write("ahorasi"); //El cerdo azul inicia vivo
				writer.close();
			}
			catch(Exception e)
			{
				System.out.println("Error al ahora si en el final.");
			}

		}
		
		


}
