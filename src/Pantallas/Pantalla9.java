package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla9 {
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
	public Pantalla9 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla del arroyo
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			boolean muere=false;
			
			System.out.println("\n~Una dura sorpresa~\n");
			
			System.out.println("Agua, y bastante en realidad.");
			
			String estadoDelCadaver="variableInicial";
			
			try {	
				 	File file = new File("Cadaver.txt");
		            BufferedReader br = new BufferedReader(new FileReader(file));
		            String line;
		            
		            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
		            
		            while ((line = br.readLine()) != null) 
		            {
		                
		                  estadoDelCadaver=line;
		                    
		            }	       	            
		            br.close();
			}
			catch (Exception e)
			{
				System.out.println("Error al leer el archivo");
			}
				
		            
		        //Así que, si esta vivo vamos aqui
		            
			if (estadoDelCadaver.equals("esta")) 
			{
			
			
			System.out.println("Todo sería perfecto si no fuera por ese cadáver que flota en la orilla del arroyo.");
			System.out.println("Te sientes algo incómodo, ¿habías visto un cadáver humano antes?");
			if (FU.decision("Me acerco a ver qué le ha pasado.", "Estoy algo nervioso y no me siento seguro, prefiero irme.", eD)==1)
			{
				System.out.println("\nEstá lleno de picotazos y presenta contusiones, pero parece que murió ahogado.");
				System.out.println("Oyes un aleteo cercano a tus espaldas.");
				if(FU.decision("Me giro, no temo a la muerte.", "Sales corriendo, esto es demasiado para ti.", eD)==1)
				{
				System.out.println("\nUn pequeño buitre decide que vas a formar parte de su cena.");	
				int suerte = R.nextInt(11);
				Personaje Buitre = new Personaje ("Buitre", 0, suerte, 50, 20, 5);
				FU.batalla(getMC(), Buitre);
				
				//Desenlace de la batalla, si ha ganado...
				if (getMC().getVida() >= Buitre.getVida())
				{
					System.out.println("\nEn un último esfuerzo, el buitre huye y se adentra en el bosque.");
					System.out.println("Vuelves a escuchar aleteos.");
					if (FU.decision("Me quedo.", "Prefiero irme, no me siento cómodo.", eD)==1)
					{
						System.out.println("\nUn enorme buitre con agujas en sus alas aparece y te ataca por sorpresa desde el cielo.");	
						suerte = R.nextInt(11);
						Personaje BuitreJefe = new Personaje ("Gran Buitre afilado", 5, suerte, 80, 50, 10);
						FU.batalla(BuitreJefe, getMC());
						if (getMC().getVida() >= BuitreJefe.getVida())
						{
							try {
							System.out.println("\nDos cadáveres componen ahora la escena.");
							System.out.println("Decides esconder el cadáver del Gran Buitre entre los arbustos y examinar el cadáver humano.");
							System.out.println("Encuentras plantas medicinales con las que restauras tu salud completamente.");
							getMC().setVida(getMC().getVidaMaxima());
							System.out.println("Antes de irte, entierras el cadáver humano, era un conocido tuyo.");
							File file = new File("Cadaver.txt");
							BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
							writer.write("enterrado");
							writer.close();
							System.out.println("Llegas a lo que parece ser una pequeña aldea rodeada de una densa niebla.");
							}
							catch (Exception e)
							{
								System.out.println("Error al actualizar el cadaver.");
							}
						}
					}
					else
					{
						System.out.println("\nDejando el cadáver aún en el río decides marcharte siguiendo el río.");
						System.out.println("Llegas a lo que parece ser una pequeña aldea rodeada de una densa niebla.");
						
						Pantalla7 P7 = new Pantalla7 (getMC(), R);
						P7.pantalla();
					}
				}
			}
			else
			{
				System.out.println("\nSales corriendo sin mirar atrás y sin dirección, tropezándote con ramas en más de una ocasión.");					
				getMC().setVida(getMC().getVida()-15);
				Pantalla4 P4 = new Pantalla4 (getMC(), R);
				P4.pantalla();
			}			
			}
			else
			{
				System.out.println("\nDejas el cadáver en el río y te marchas siguiendo el río.");
				System.out.println("Llegas a lo que parece ser una pequeña aldea rodeada de una densa niebla.");
				
				Pantalla7 P7 = new Pantalla7 (getMC(), R);
				P7.pantalla();
			}

			
		
				}
			else
			{
				System.out.println("Varios buitres surcan el cielo y algunos en la tierra se alimentan de uno de los suyos.");
				System.out.println("Decides marcharte siguiendo el río.");
				System.out.println("Llegas a lo que parece ser una pequeña aldea rodeada de una densa niebla.");
				Pantalla7 P7 = new Pantalla7 (getMC(), R);
				P7.pantalla();
			}

		}
}
