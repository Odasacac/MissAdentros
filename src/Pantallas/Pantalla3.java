package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla3 
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
	public Pantalla3 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
	public void pantalla() //Esta es la pantalla de decidir ir hacia las montañas
	{
		
		
		//Aquí se pone la pantalla como tal
		
		System.out.println("\n~Miss Adentros~\n");
		
		//Lo primero es ver como está MA
		FuncionesUtiles FU = new FuncionesUtiles();
		String estadoMA =" ";
		Scanner eD = new Scanner (System.in);
		if (!getMC().getNombre().equals("Carlos!"))
		{
			try 
			{	
			 	File file = new File("MissAdentros.txt");
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	           
	            while ((line = br.readLine()) != null) 
	            {
	                  estadoMA=line;                   
	            }	       	            
	            br.close();
	            
	            
			}
			
	        catch (Exception e)
	        {
	            System.out.println("Error al leer los archivos.");
	        }
			String estadoSer="";
			try 
			{	
			 	File file = new File("SerCuevas.txt");
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	           
	            while ((line = br.readLine()) != null) 
	            {
	                  estadoSer=line;                   
	            }	       	            
	            br.close();
			}
			
	        catch (Exception e)
	        {
	            System.out.println("Error al leer los archivos.");
	        }
			
			
			
			System.out.println("Sales de la ciudad, y no muy lejos ves una silueta.");
			if (estadoMA.equals("inicio"))
			{
				System.out.println("Sentada en un banco mirando el horizonte ves a una mujer.");
				System.out.println("Te acercas a ella.");
				System.out.println("Te escucha y dirige su mirada hacia ti.");
				if(estadoSer.equals("muerto"))
				{
					System.out.println("Una gran cicatriz cruza su cara.");
				}
				
				
				try 
				{
					if (getMC().getSuerte()%2==0) //Si es par va a estar enfadada
					{
			
					File file = new File("MissAdentros.txt");
					BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
					writer.write("enfadada");
					writer.close();
					}
					
					else
					{
					
						File file = new File("MissAdentros.txt");
						BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
						writer.write("triste"); 
						writer.close();
					
					}
				}
				catch (Exception e)
				{
					System.out.println("Error al actualizar a triste.");
				}
				
			}
			else
			{
				System.out.println("Sentada en un banco vuelves a ver a esa mujer mirando al horizonte.");
				System.out.println("Te vuelves a acercar a ella.");
				System.out.println("Te escucha y dirige su mirada hacia ti.");
				if(estadoSer.equals("muerto"))
				{
					System.out.println("Una gran cicatriz cruza su cara.");
				}
				
			}
			
			try 
			{	
			 	File file = new File("MissAdentros.txt");
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	           
	            while ((line = br.readLine()) != null) 
	            {
	                  estadoMA=line;                   
	            }	       	            
	            br.close();
	            
	            
			}
			
	        catch (Exception e)
	        {
	            System.out.println("Error al leer los archivos.");
	        }
			
			
			
			if (estadoMA.equals("enfadada"))
			{
					System.out.println("\nSu ceño fruncido y su mirada ardiente te hacen pensar que quizás está enfadada.");
					System.out.println("- ¿Qué quieres? - Pregunta directamente.");
						
						if(FU.decision("Nada, sólo pasaba por aquí y me acerqué a saludar.","Quisiera saber qué te ocurre.", eD)==1)
						{
							System.out.println("\nSu mirada se relaja, pero notas cierta desconfianza.");
							System.out.println("- Pues hola, la verdad es que no me apetece estar con nadie, estoy algo molesta.");
							if(FU.decision("Vaya, ¿podría preguntar por qué?","Bueno, muchas veces sienta bien pasar tiempo aislado para relativizar lo que nos aflije.", eD)==1)
							{
								System.out.println("\n- No, no puedes, y si no te importa, me gustaría estar sola. - Responde.");
								System.out.println("Ante esta situación, te disculpas y prosigues tu camino.");
							}
							else
							{
								try {
								System.out.println("\nNotas como su rostro se relaja y vuelve a mirar al horizonte.");
								System.out.println("- Sí, supongo... Si no te importa, me gustaría estar sola. - Responde triste.");
								System.out.println("Ante esta situación, te despides y prosigues tu camino.");
								File file = new File("MissAdentros.txt");
								BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
								writer.write("triste");
								writer.close();	
								}
								catch (Exception e)
								{
									System.out.println("Error al actualizar a triste");
								}
							}
						}
						else
						{
							System.out.println("\n- Y a ti qué te importa. - Responde.");
							System.out.println("Ante esta situación, te disculpas y prosigues tu camino.");
						}
						
			}
						
			else if (estadoMA.equals("triste"))
			{
						
						
						
						System.out.println("\nSu rostro y sobre todo su mirada te hacen pensar que está triste.");
						System.out.println("- Hola, ¿qué querías? - Pregunta.");
						
						if(FU.decision("Nada, sólo pasaba por aquí y me acerqué a saludar.","Quisiera saber qué te ocurre.", eD)==1)
						{
							System.out.println("\nSu mirada se entristece.");
							System.out.println("- Pues hola, la verdad es que no me apetece estar con nadie, estoy algo triste.");
							if(FU.decision("Vaya, ¿podría preguntar por qué?","Bueno, muchas veces sienta bien pasar tiempo aislado para relativizar lo que nos aflije.", eD)==1)
							{
								System.out.println("\n- No lo sé ni yo... Si no te importa, me gustaría estar sola. - Responde.");
								System.out.println("Ante esta situación, te disculpas y prosigues tu camino.");
							}
							else
							{
								System.out.println("\nNotas como su rostro se relaja y vuelve a mirar al horizonte.");
								System.out.println("- Sí, supongo... No es nada importante, sólo que me siento en un pozo. - Responde.");
								
								if(FU.decision("Pues espero que llores tanto como para que tus lágrimas te saquen de él.","Si necesitas cualquier cosa, cuenta conmigo.", eD)==1)
								{
									
									try {
										System.out.println("\nLa mujer se ríe y vuelve a mirar al horizonte.");
										System.out.println("Te sientes bien y decides irte.");
										File file = new File("MissAdentros.txt");
										BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
										writer.write("contenta");
										writer.close();
										}
										catch (Exception e)
										{
											System.out.println("Error al actualizar a contenta.");
										}
									
								}
								else
								{
									System.out.println("\nLa mujer te da las gracias y vuelve a mirar al horizonte.");
								}
								
								
							}
						}
						else
						{
							try {
							System.out.println("\n- Pero bueno, y a ti qué te importa. - Responde enfadada.");
							System.out.println("Ante esta situación, te disculpas y prosigues tu camino.");
							File file = new File("MissAdentros.txt");
							BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
							writer.write("enfadada");
							writer.close();
							}
							catch (Exception e)
							{
								System.out.println("Error al actualizar a enfadada.");
							}
						}	
			}
			
			else if (estadoMA.equals("contenta"))
			{
				System.out.println("Te saluda sonriente.");
				System.out.println("Su sonrisa y su mirada te hacen sentir satisfecho.");
				if(estadoSer.equals("muerto"))
				{
					System.out.println("La cicatriz de su cara parece haberse fundido más en su rostro.");
				}
				
				System.out.println("Te despides de ella y sigues tu camino.");
			}
			else
			{
					System.out.println("MD no sabe como se siente.");
			}
			
		}
		else
		{
			System.out.println("\nLo siento, tenemos prisa gracias.");
		}
		
		
		
		Pantalla11 P11 = new Pantalla11 (getMC(),R);
		P11.pantalla();

	}

}
