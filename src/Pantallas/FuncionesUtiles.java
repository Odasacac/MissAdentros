package Pantallas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class FuncionesUtiles 
{
	
	//Le dices el nombre de un archivo con extensión y guarda su interior en una variable que te devuelve en forma de String
	
	
	public String leerArchivo(String nombreArchivo)
	{
		String contenidoArchivo ="";
		
		try {	
			 	File file = new File(nombreArchivo);
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	            
	            while ((line = br.readLine()) != null) 
	            {
	                
	                  contenidoArchivo=contenidoArchivo+line;  
	            }
	            br.close();
			}
	            
	            catch (Exception e)
	            {
	            	contenidoArchivo="Error al leer el archivo";
	            }
		
		
		return contenidoArchivo.toString();
		
	}	
	
	
	
	
	
	
	
	

	//Le das dos palabras y te devuelve 1 si es la primera elegida y 2 si es la segunda
	
	public int decision(String a, String b, Scanner eD) 

	{
		System.out.println("¿Qué harás?\n");
		System.out.println("1. "+a);
		System.out.println("2. "+b);

		int opcion=0;
		
		boolean checkNumero=false;
		while (!checkNumero) 
		{
			opcion = 0;
			System.out.print("Opción: ");

			try 
			{
				opcion = eD.nextInt();
				if (opcion <= 0) 
				{
					System.out.println("Introduce un número positivo.\n");
				} 
				else if (opcion >= 3) 
				{
					System.out.println("Introduce un número entre 1 y 2.\n");
				} 
				else 
				{
					checkNumero = true;
				}
				eD.nextLine();
			} 
			catch (Exception e7) 
			{
				System.out.println("Introduce un número entero.\n");
				eD.nextLine();
			}
		}
		
			return opcion;
	
		
	}
	
	//Igual que la de antes, pero con tres parámetros, en este caso, devolvera 1, 2 o 3
	public int decision(String a, String b, String c, Scanner eD) 

	{
		System.out.println("¿Qué harás?\n");
		System.out.println("1. "+a);
		System.out.println("2. "+b);
		System.out.println("3. "+c);

		int opcion=0;
		
		boolean checkNumero=false;
		while (!checkNumero) 
		{
			opcion = 0;
			System.out.print("Opción: ");

			try 
			{
				opcion = eD.nextInt();
				if (opcion <= 0) 
				{
					System.out.println("Introduce un número positivo.\n");
				} 
				else if (opcion >= 4) 
				{
					System.out.println("Introduce un número entre 1 y 3.\n");
				} 
				else 
				{
					checkNumero = true;
				}
				eD.nextLine();
			} 
			catch (Exception e7) 
			{
				System.out.println("Introduce un número entero.\n");
				eD.nextLine();
			}
		}
		
		
			return opcion;
		
	}
	
	//Igual que la de antes, pero con tres parámetros, en este caso, devolvera 1, 2, 3 o 4
		public int decision(String a, String b, String c, String d, Scanner eD) 

		{
			System.out.println("¿Qué harás?\n");
			System.out.println("1. "+a);
			System.out.println("2. "+b);
			System.out.println("3. "+c);
			System.out.println("4. "+d);

			int opcion=0;
			
			boolean checkNumero=false;
			while (!checkNumero) 
			{
				opcion = 0;
				System.out.print("Opción: ");

				try 
				{
					opcion = eD.nextInt();
					if (opcion <= 0) 
					{
						System.out.println("Introduce un número positivo.\n");
					} 
					else if (opcion >= 5) 
					{
						System.out.println("Introduce un número entre 1 y 4.\n");
					} 
					else 
					{
						checkNumero = true;
					}
					eD.nextLine();
				} 
				catch (Exception e7) 
				{
					System.out.println("Introduce un número entero.\n");
					eD.nextLine();
				}
			}
			
			
				return opcion;
			
		}

	public void batalla(Personaje P1, Personaje P2) //Batalla, P1 ataca primero y P2 defiende y ataca si sigue vivo
	{
		
		System.out.println("\n"+P1.getNombre()+" va a enfrentarse con " + P2.getNombre()+".");
		int rondas = 0;
		boolean cansancio = false;
		while (P1.getVida()>=0 && P2.getVida()>=0 && !cansancio)
		{
			rondas = rondas+1;
			//Se atacan
			atacar(P1, P2);
			if (P2.getVida()>=0) //Si esta vivo, lo mismo pero al reves
			{
				atacar(P2, P1);
			}
			if (rondas>30)
			{
				cansancio=true;
			}
		}
		if (cansancio)
		{
			System.out.print("\n" + P1.getNombre()+" y " + P2.getNombre() + " están agotados, sin embargo ");
			if (P1.getVida()<P2.getVida())
			{
				System.out.println("es " + P2.getNombre() + " quien se mantiene en pie, ya que tiene " +(P2.getVida()-P1.getVida()) + " puntos más de vida.");
			}
			else if (P1.getVida()>P2.getVida())
			{
				System.out.println("es " + P1.getNombre() + " quien se mantiene en pie, ya que tiene " +(P1.getVida()-P2.getVida()) + " puntos más de vida.");
			}
			else
			{
				System.out.println("es curioso ver lo equilibrados que están, no hay vencedor ni vencido.");
			}
		}
		else if (P1.getVida()<0)
		{
			System.out.println("\n¡El vencedor ha sido " + P2.getNombre()+"!\n");
		}
		else
		{
			System.out.println("\n¡El vencedor ha sido " + P1.getNombre()+"!\n");
		}
	}
	public void atacar (Personaje P1, Personaje P2)
	{
		Random R = new Random ();
		//Fase de ataque
		System.out.println("\n"+P1.getNombre() + " atacó a "+ P2.getNombre()+".");
		int damageEnviado=P1.getAtaque();
	
		//Si el porcentaje de vida del personaje atacante es bajo (<25%) podrá tener suerte y realizar un ataque crítico
		if (P1.getSuerte()>R.nextInt(11))
		{
			if (P1.getVida()<=(P1.getVidaMaxima()*0.25)) 
			{
				damageEnviado=damageEnviado*3;
				System.out.println("El aliento que llama a sobrevivir hizo que " +  P1.getNombre() + " no pensara en nada más y le brillaran los ojos.");
			}
			else if (P1.getClase()==1)//Si es guerrero y tiene suerte golpeará con más fuerza
			{
				damageEnviado=damageEnviado*3;
				System.out.println(P1.getNombre() + " golpeó con una fuerza bastante inesperada.");
			}
		
		}
		//Si es un berserk y tiene menos del 5% de vida siempre hará x3 de daño
		if (P1.getClase()==5 && P1.getVida()<=(P1.getVidaMaxima()*0.05))
		{
			System.out.println(P1.getNombre() + " tiene los ojos inyectados en sangre, sus venas se hinchan y deshinchan a pulsos y lanza un potente ataque.");
			damageEnviado=damageEnviado*3;
		}
		//Si es un mago y tiene suerte, podrá lanzar un ataque mágico
		if (P1.getSuerte()>R.nextInt(5)&&P1.getClase()==3) 
		{
			System.out.println(P1.getNombre() + " tuvo suerte y logró conjurar la llamarada de fuego incesante.");
			damageEnviado=damageEnviado*2;
		}
	
		System.out.println("Daño enviado: " + damageEnviado);
		//Fase de defensa
		//Ahora pueden pasar dos cosas, o que el personaje se defienda o que el ladrón esquive
	
		if(P2.getSuerte()>R.nextInt(11))
		{
			if(P2.getClase()==2)
			{
				System.out.println(P2.getNombre()+" tuvo suerte y esquivó el golpe.");
				damageEnviado=0;
			}
			else
			{
				System.out.println(P2.getNombre()+" tuvo suerte y pudo defenderse bien del ataque.");
				damageEnviado=damageEnviado-P2.getDefensa();
				if (damageEnviado < 0) 
				{
		            damageEnviado = 0;
		        }
			}
		}
		else
		{
			System.out.println(P2.getNombre()+" recibió el ataque como mejor pudo.");
		}
		//Fase final de recuento de daño, aquí, si es un clérigo y tiene suerte, se curará
		
		
		P2.setVida(P2.getVida()-damageEnviado);
		
		if(P2.getSuerte()>R.nextInt(7)&&P2.getClase()==4&&P2.getVida()<0)
		{
			System.out.println(P2.getNombre()+" miró al cielo con intensidad y sintió como un potente rayo de luz blanca atravesaba su cuerpo.");
			P2.setVida(P2.getVida()+30);
		}
				
		else if (P2.getSuerte()>R.nextInt(11)&&P2.getClase()==4)
		{
				System.out.println(P2.getNombre()+" miró al cielo con intensidad y recuperó algo de vida.");
				P2.setVida(P2.getVida()+15);
		}
		
		
		System.out.println("Ahora, " + P2.getNombre() + " tiene " + P2.getVida() + " puntos de vida.");
	
	}
}
