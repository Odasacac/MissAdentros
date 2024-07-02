package Pantallas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla18 {

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
	public Pantalla18 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla despues de elegir ir a las montañas al principio, en el cruce
		{

			Scanner eD = new Scanner (System.in);
			
		
			
			System.out.println("\n~El precio de la impaciencia~\n");
			
			System.out.println("¿Por qué un atajo?");
			System.out.println("¿Acaso tengo prisa?");
			System.out.println("Es más, ¿acaso espero algo?");
			System.out.println("¿Es que no puedo dejar de pensar en qué hacer?");
			
			if (getMC().getSuerte()<R.nextInt(11))
			{
				System.out.println("Te tropiezas con una roca y te haces una buena herida.");
				getMC().setVida(getMC().getVida()-10);
				if (getMC().getVida()<0)
				{
					getMC().setVida(0);
				}
			}
			else
			{
				System.out.println("Encuentras una árboles frutales y restauras algo tu salud.");
				getMC().setVida(getMC().getVida()+10);
			}
			
			
			
			try
			{
				File file = new File("Atajo.txt");
				BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
				writer.write("atajado"); 
				writer.close();
				
				
				
			}
			catch (Exception e)
			{
				System.out.println("Error al cambiar el estado.");
			}
			
			System.out.println("Cruzar las montañas no parecía algo tan atractivo ni de lejos.");
			
			
			Pantalla22 P22 = new Pantalla22(MC,R);
			P22.pantalla();
			
	
		}
}
