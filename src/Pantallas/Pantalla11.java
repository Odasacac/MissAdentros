package Pantallas;

import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla11 {
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
	public Pantalla11 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla de cruce de MA
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			
			
			System.out.println("\n~Más decisiones otra vez~\n");
			
			System.out.println("Entre unas rocas, ves un poste de madera con tres flechas.");
			System.out.println("Una de ellas tiene escrita la palabra Ciudad.");
			System.out.println("La otra la palabra Montañas.");
			System.out.println("Y la última Posada.");
			
			int decision=FU.decision("Voy a la ciudad.", "Prefiero dirigirme a las montañas.", "Quiero ir a la posada.", eD);
			
			if (decision==1)
			{
				Pantalla6 P6 = new Pantalla6 (getMC(), R); 
				P6.pantalla();
			}
			else if (decision==2)
			{
				Pantalla16 P16 = new Pantalla16 (getMC(), R);
				P16.pantalla();
				
			}
			else
			{
				Pantalla15 P15 = new Pantalla15 (getMC(), R); //Al caballero
				P15.pantalla();
			}
			
	
		}

}
