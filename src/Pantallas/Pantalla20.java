package Pantallas;

import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla20 {
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
	public Pantalla20 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla de elegir ir al ascenso
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			
			
			
			System.out.println("\n~La senda que asciende~\n");
			
			
			System.out.println("La zona se encuentra formada por peculiares azulejos que aparecen y desvanecen.");
			System.out.println("Será mejor volver por donde hemos venido.");
			
			Pantalla19 P19 = new Pantalla19(MC,R);
			P19.pantalla();
		}
}
