package Pantallas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla5 {
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
	public Pantalla5 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla de los bebes cerdo
		{
			
			FuncionesUtiles FU = new FuncionesUtiles ();
			Scanner eD = new Scanner (System.in);
			
			//Aquí se pone la pantalla como tal
			
			System.out.println("\n~Llantos de seres indefensos~\n");
			System.out.println("Los gruñidos que escuchabas eran de los lechones.");
			System.out.println("Son cuatro y buscan a su madre, que yace a escasos metros, pero parece que no la han visto aún.");
			System.out.println("Quizás es cruel, pero si te los comes podrás recuperar buena cantidad de vida...");
			
			if(FU.decision("Matarlos y comértelos.","Abandonarlos a su suerte y seguir tu camino.", eD)==1)
			{
				try {
					System.out.println("\nCrujientes, tiernos y deliciosos.");
					System.out.println("Tu cuerpo se siente revitalizado y preparado para continuar.");
					getMC().setVida(getMC().getVida()+50);
					File CerdoHijos = new File("CerdoHijos.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				 
				    BufferedWriter writer = new BufferedWriter(new FileWriter(CerdoHijos, false));
				    writer.write("muertos"); //El cerdo azul inicia vivo
				    writer.close();
				}
				catch (Exception e)
				{
					System.out.println("Error al escribir los babypig muertos");
				}
			}
			else
			{
				System.out.println("\nDejas los gruñidos atrás y te sientes bien, aunque algo culpable.");
		
			}
			Pantalla4 P4 = new Pantalla4 (getMC(), getR());
			P4.pantalla(); //Nos adentramos en el bosque

		}
}
