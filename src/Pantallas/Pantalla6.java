package Pantallas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla6 {
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
	public Pantalla6 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla de vuelta a la ciudad
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			
			//Lo primero es restaurar la vida, pero solo si los babypigs estan vivos.
			String estadoDelosBabypigs="variableInicial";
			
			try {	
				 	File file = new File("CerdoHijos.txt");
		            BufferedReader br = new BufferedReader(new FileReader(file));
		            String line;
		            
		            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
		            
		            while ((line = br.readLine()) != null) 
		            {
		                
		                  estadoDelosBabypigs=line;
		                    
		            }	       	            
		            br.close();
				
		            if (estadoDelosBabypigs.equals("vivos"))
		            {
		            	getMC().setVida(getMC().getVidaMaxima());
		            }
			}
			catch(Exception e)
			{
				System.out.println("Error al leer el archivo CerdoHijos");
			}
			
			
			//Aquí se pone la pantalla como tal
			
			System.out.println("\n~Regreso a los inicios~\n");
			System.out.println("Te tomas un pequeño descanso sumergido en un aura familiar y conocida.");
			System.out.println("Vuelves a sentirte preparado para continuar con tu aventura.");
			if ((getMC().getSuerte()>R.nextInt(2))&& estadoDelosBabypigs.equals("vivos")||((getMC().getSuerte()>R.nextInt(7))&&estadoDelosBabypigs.equals("muertos")))
			{
			System.out.println("Además, parece que el sol brilla especialmente, te sientes muy bien y lleno de vitalidad.");
			getMC().setVida(getMC().getVidaMaxima()+20);
			}
			System.out.println("Tus pulmones se llenan de un aire frío y picante.");
			System.out.println("Frente a ti, vuelves a tener dos caminos:");
			System.out.println("Ir hacia el oeste para adentrarte en el bosque.");
			System.out.println("O ir hacia el este, por la senda que se dirige a las montañas.");
			System.out.println("Siempre puedes abandonar...");
			
			int decision = FU.decision("Ir hacia el oeste.", "Ir hacia el este.", "Abandono", eD);
			
			if(decision==1) //Es 1 si decide ir al primero.
			{	
				Pantalla2 P2 = new Pantalla2 (MC, R); //Vamos al bosque en este caso, pantalla 2.
				P2.pantalla();
				
			}
			else if(decision==2) //Es 1 si decide ir al primero.
			{	
				
				Pantalla3 P3 = new Pantalla3 (MC, R); //Vamos a las montañas, pantalla 3.
				P3.pantalla();
			}
			else
			{
				System.out.println("\nBueno, más suerte o más valentía la próxima vez.");
			}
			
	
		}

}
