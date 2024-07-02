package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla10 {
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
	public Pantalla10 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla de la cascada
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			
			
			System.out.println("\n~Secretos bajo el impacto~\n");
			getMC().setVida(getMC().getVida()+20);
			System.out.println("Realmente, te sientes bien y confiado en esta aventura.");
			System.out.println("La tranquilidad y la paz que sientes en este lugar te hacen quedarte dormido.");
			System.out.println("Al despertar, ha pasado el tiempo y todo ha adquirido un tono algo más oscuro.");
			System.out.println("Los rayos de sol hacen brillar algo bajo la cascada.");
			String estadoDeLaEspada="variableInicial";
			if(FU.decision("Acercarme a mirar.", "Seguir el camino que sigue el riachuelo ", eD)==1)
			{
				//Comprobamos que la espada esté
				
				try {	
				 	File file = new File("Espada.txt");
		            BufferedReader br = new BufferedReader(new FileReader(file));
		            String line;
		            
		            
		            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
		            
		            while ((line = br.readLine()) != null) 
		            {
		                
		                  estadoDeLaEspada=line;
		                    
		            }	       	            
		            br.close();
					}
					catch (Exception e)
					{
						System.out.println("Error al leer la espada.");
					}
				
				if (estadoDeLaEspada.equals("esta")) //Si la espada está, lucha contra una serpiente y si gana se lleva la espada
				{
					int suerte = R.nextInt(11);
					System.out.println("\nUna gran serpiente con perlas en su cuerpo y con afilados colmillos se escondía bajo la cascada y salta hacia ti.");
					Personaje Serpiente = new Personaje ("Serpiente perlada", 2, suerte, 80, 30, 10);
					
					FU.batalla(Serpiente, getMC());
					
					
					//Desenlace de la batalla, si ha ganado...
						if (getMC().getVida() >= Serpiente.getVida())
						{
							System.out.println("\nUn enfrentamiento algo difícil, todo hay que decirlo.");
							System.out.println("Sin embargo, de repente notas que algo brilla bajo el agua.");
							System.out.println("Decides meter las manos bajo la cascada y encuentras una espada brillante con una perla en su empuñadura.");
							System.out.println("Decides llevarla contigo, te sientes algo más seguro.");
							getMC().setAtaque(getMC().getAtaque()+20);
							try {
							//Recogemos la espada
							File file = new File("Espada.txt");
							BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
						    writer.write("recogida"); 
						    writer.close();
						    System.out.println("\nSiguiendo el camino del riachuelo, poco a poco ves como éste pasa a convertirse en un arroyo bastante caudaloso.");
							
							Pantalla9 P9 = new Pantalla9(getMC(),R);
							
							P9.pantalla();
							}
							catch(Exception e)
							{
								System.out.println("Error al recoger la espada.");
							}
							
						}
					
				}
				else
				{
					System.out.println("\nUn pequeño truco de luces entre las hojas y el agua, no hay nada relevante en la zona.");
					System.out.println("\nSiguiendo el camino del riachuelo, poco a poco ves como éste pasa a convertirse en un arroyo bastante caudaloso.");
					
					Pantalla9 P9 = new Pantalla9(getMC(),R);
					
					P9.pantalla();
				}
			}
			else
			{
				System.out.println("\nSiguiendo el camino del riachuelo, poco a poco ves como éste pasa a convertirse en un arroyo bastante caudaloso.");
				
				Pantalla9 P9 = new Pantalla9(getMC(),R);
				
				P9.pantalla();
			}
			

		}

}
