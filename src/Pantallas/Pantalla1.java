package Pantallas;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla1 
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
	public Pantalla1 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
	public void pantalla() //Esta es la primera pantalla, elegir izquierda o derecha
	{
		MC.setVida(100);
		
		
		//Aquí se pone la pantalla como tal
		
		System.out.println("\n~Otra difícil decisión~\n"); //El Título
		//Lo que sucede
		System.out.println("Es el momento, a tus espaldas las puertas de tu ciudad.");
		System.out.println("Ser consciente de que quizás marchas para no regresar no suena demasiado estimulante.");
		System.out.println("Pero ha sido tu decisión embarcarte en esto.");
		if (MC.getSuerte()>7) //Un indicador de si el jugador tiene buena suerte
		{
			System.out.println("Se ve que tienes suerte y un grillo ha cantado con alegría.");
		}
		else if (MC.getSuerte()<3)
		{
			System.out.println("No tienes mucha suerte y al salir pisas un charco lleno de barro y te manchas.");
		}
		System.out.println("Frente a ti se muestran dos claras opciones:");
		System.out.println("Ir hacia el oeste para adentrarte en el bosque.");
		System.out.println("O ir hacia el este, por camino que se dirige a las montañas.");
		
		FuncionesUtiles FU = new FuncionesUtiles ();
		Scanner eD = new Scanner (System.in);
		
		if(FU.decision("Ir hacia el oeste.", "Ir hacia el este.", eD)==1) //Es 1 si decide ir al primero.
		{	
			Pantalla2 P2 = new Pantalla2 (getMC(), getR()); //Vamos al bosque en este caso, pantalla 2.
			P2.pantalla();
			
		}
		else
		{
			Pantalla3 P3 = new Pantalla3 (getMC(), getR()); //Vamos a las montañas, pantalla 3.
			P3.pantalla();
		}

	}
}
