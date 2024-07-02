package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla2 
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
	public Pantalla2 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
	public void pantalla() //Esta es la pantalla de la cerda azul
	{
		
		Scanner eD = new Scanner (System.in);
		FuncionesUtiles FU = new FuncionesUtiles();
		
		System.out.println("\n~Gritos de un alma con miedo~\n"); //El Título
		//Lo que sucede
		System.out.println("Parece ser que las ramas de los árboles se han propuesto ser nuestro techo.");
		
		//Vamos a ver si el cerdo esta vivo o muerto
		String estadoDelCerdo="variableInicial";
			
		try {	
			 	File file = new File("Cerdo.txt");
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	            
	            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
	            
	            while ((line = br.readLine()) != null) 
	            {
	                
	                  estadoDelCerdo=line;
	                    
	            }	       	            
	            br.close();
			
	            
	        //Así que, si esta vivo vamos aqui
	            
			if (estadoDelCerdo.equals("vivo")) 
			{
				System.out.println("Y adentrándote más en el bosque oyes un revoltijo que te saca de tus pensamientos.");
				System.out.println("Ahora por el rabillo del ojo notas las hojas moverse y te pones algo alerta.");
				System.out.println("Oyes unos gruñidos y entre la maleza consigues ver un cerdo morado quizás algo grande.");
				System.out.println("Te mira fijamente y no se mueve, parece intimidante.");
				System.out.println("Otra vez gruñidos.");
				
				int decision=FU.decision("Volver por donde he venido, no me encuentro muy cómodo.","Sigo mi camino, pero dejo al cerdo al lado, no me obstaculiza.","Acercarme a él, tampoco me importaría saludar.", eD);
				
				if (decision ==1)
				{
					Pantalla6 P6 = new Pantalla6 (getMC(),getR());
					P6.pantalla();
					//Ir a pantalla de inicio, pero la no inicial, Pantalla 6
				}
				else if (decision ==2)
				{
					//Ir a Pantalla 4
					Pantalla4 P4 = new Pantalla4 (getMC(),getR());
					P4.pantalla();
				}
				else if (decision==3)
				{
					//Pelea con la cerda azul
					System.out.println("El cerdo se lanza sobre tí y te golpea.");
					int suerte = R.nextInt(11);
					Personaje Cerdo = new Personaje ("Cerdo morado", 0, suerte, 120, 10, 40);
					
					//Luego llamar a la batalla
				
					FuncionesUtiles FU1 = new FuncionesUtiles();
					
					FU1.batalla(Cerdo, getMC());
					
					
					//Desenlace de la batalla, si ha ganado...
					if (getMC().getVida() >= Cerdo.getVida())
					{
						//Lo primero es cambiar el estado del Cerdo a muerto, por si se vuelve a esta pantalla que no aparezca
						
						
					    // Crear FileWriter con append = false para sobrescribir el archivo
					    BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
					    writer.write("muerto"); 
					    writer.close();
						
						//Luego si la vida del protagonista es baja, va al interior de las cuevas
						if(getMC().getVida()<(getMC().getVidaMaxima()*0.25))
						{
							System.out.println("Algo asustado por apenas salir con vida sales corriendo.");
							System.out.println("Tienes la mente nublada, te late muy rápido el corazón y estás seguro de haber oído gruñidos a lo lejos tras la muerte del cerdo.");
							System.out.println("Ves una colina con muchos agujeros y te adentras profundamente en uno de ellos con el fin de esconderte y recuperarte.");
							  
								File Cuevas = new File("Cuevas.txt");							   
							    writer = new BufferedWriter(new FileWriter(Cuevas, false));				 
							    writer.write("si");
							    writer.close();
							    
							Pantalla13 P13 = new Pantalla13 (getMC(), R);
							P13.pantalla();
							
						}
						else //Si no, puede elegir ir a los bebés cerdo, volver al inicio o seguir adelante
						{
							System.out.println("Frente a ti yace la que parece que es una cerda morada.");
							System.out.println("Está feo que yo lo diga, pero debe ser un especimen poco común porque yo jamás vi uno.");
							System.out.println("Vuelves a oir gruñidos.");
							decision=FU.decision("Me acerco a los gruñidos.","Sigo hacia donde iba.","Vuelvo a la ciudad, esto ha sido mucho para mí.", eD);
							
							if (decision ==1)
							{
								Pantalla5 P5 = new Pantalla5 (getMC(), getR());
								P5.pantalla(); //Vamos a los baby cerdos
							}
							else if (decision ==2)
							{
								Pantalla4 P4 = new Pantalla4 (getMC(), getR());
								P4.pantalla(); //Nos adentramos en el bosque
							}
							else if (decision ==3)
							{
								Pantalla6 P6 = new Pantalla6 (getMC(), getR());
								P6.pantalla(); //Volvemos a casa
							}
						}
				
					}

					
				}
				
				
				
				
				
			}
			else if (estadoDelCerdo.equals("muerto"))
			{
				//Aquí si el cerdo esta muerto
				System.out.println("El cadáver de un cerdo morado aparece en tu camino.");
				System.out.println("Huele mal y todo parece bastante calmado, sólo hay silencio.");
				System.out.println("Dos opciones tienes ante ti.");
				System.out.println("O bien te diriges hacia el puente que lleva de regreso a la ciudad.");
				System.out.println("O bien te adentras más en el bosque.");
				
				if (FU.decision("Vuelvo a la ciudad.", "Me adentro más en el bosque.", eD)==1)
				{
					Pantalla6 P6 = new Pantalla6 (getMC(), getR());
					P6.pantalla();
				}
				else
				{
					Pantalla4 P4 = new Pantalla4 (getMC(), getR());
					P4.pantalla();
				}
				
				
			}
			else
			{
				System.out.println("El cerdo de Shrodinguer.");
			}
		}
		catch (Exception e)
		{
			System.out.println("Error 8. Gracias por informar.");
		}
		

	}

}
