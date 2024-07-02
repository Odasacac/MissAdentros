package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla4 
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
	public Pantalla4 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla de adentrarse en el bosque
		{
			
			FuncionesUtiles FU = new FuncionesUtiles ();
			Scanner eD = new Scanner (System.in);
			//Aquí se pone la pantalla como tal
			
			System.out.println("\n~Sumergido en la espesura~\n");
			
			System.out.println("El bosque es más rico en sensaciones de lo que esperabas.");
			System.out.println("Pájaros, el viento entre las hojas... Todo te hace sentir bastante aliviado.");
			System.out.println("La profundidad de la espesura te hace sentir sumergido en un lugar agradable.");
			//Aqui el colgante, leer y actualizar
			String estadoColgante="";
			
			try
			{
				File file =new File ("Colgante.txt");
				BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	            
	            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
	            
	            while ((line = br.readLine()) != null) 
	            {
	                
	                  estadoColgante=line;
	                    
	            }	       	            
	            br.close();			
			}
			catch (Exception e)
			{
				System.out.println("Error al leer el archivo.");
			}
			
			if (estadoColgante.equals("lotiene"))
			{
				System.out.println("Pero consideras portar más de lo que te hace liviano.");
			}
			else if (estadoColgante.equals("nolotiene"))
			{
				System.out.println("Realmente, sólo acabas de empezar esta aventura.");
			}
			else if (estadoColgante.equals("perdido"))
			{
				System.out.println("Encuentras un pequeño colgante en el suelo y lo coges.");
				
				try
				{
					File file = new File("Colgante.txt");
					BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
				    writer.write("recuperado"); 
				    writer.close();
				}
				catch (Exception e)
				{
					System.out.println("Error al actualizar a lotiene.");
				}
			
			}
			
			
			
			System.out.println("Un destello de luz te hace preguntarte hasta qué punto tus acciones te estan acercando a la felicidad.\n");
			
			//Depende de que ha hecho, ira mas a un lugar que a otro, lo primero rescatar los eventos
			
			String estadoCerdo =" ";
			String estadoCerdoHijos=" ";
			int suerte = MC.getSuerte()+R.nextInt(2);
			
			try 
			{	
			 	File file = new File("Cerdo.txt");
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String line;
	           
	            while ((line = br.readLine()) != null) 
	            {
	                
	                  estadoCerdo=line;
	                    
	            }	       	            
	            br.close();
	            
	            
	            
	            file = new File("CerdoHijos.txt");
	            br = new BufferedReader(new FileReader(file));
	     
	           
	            while ((line = br.readLine()) != null) 
	            {
	                
	                  estadoCerdoHijos=line;
	                    
	            }	       	            
	            br.close();    
			}
			
	        catch (Exception e)
	        {
	            System.out.println("Error al leer los archivos.");
	         }
	          
			
			if (estadoCerdoHijos.equals("muertos"))
			{
				//Si ha matado a los babypigs, no tendrá la opción de ir al arroyo ni a la cascada
				//Es decir, solo podrá ir a la aldea (P7) o al cruce para ir a las cuevas o al prado (P8).
				System.out.println("Quizás no mucho, hace tiempo que la felicidad no es algo que saborees frecuentemente.");
				if (suerte%2!=0)
				{
					System.out.println("Tras un buen rato caminando, llegas a lo que parece ser un aldea.");
					System.out.println("Las nubes bajas le aportan un toque mágico a la escena.");
					Pantalla7 P7 = new Pantalla7 (MC, R); //Aldea
					P7.pantalla();
				}
				else
				{
					System.out.println("Tras un buen rato caminando, te topas con una persona mirando una señal.");
					Pantalla8 P8 = new Pantalla8 (MC, R); //Cruce
					P8.pantalla();
				}
				
				
			}
			
			
			else if (estadoCerdo.equals("muerto")) //Pero si solo ha matado al cerdo, podra ir a las cuevas, por valiente
			{
				System.out.println("Pues quizás depende de la situación, no siempre la incomodidad te hace sentir impaciente.");
				if (suerte%3==0)
				{
					System.out.println("Tras un buen rato caminando, llegas a lo que parece ser un aldea.");
					System.out.println("Las nubes bajas le aportan un toque mágico a la escena.");
					Pantalla7 P7 = new Pantalla7 (MC, R); //Aldea
					P7.pantalla();
				}
				else if (suerte%3==1)
				{
					System.out.println("A través de senderos y paisajes pintorescos, te topas con una persona mirando una señal.");
					Pantalla8 P8 = new Pantalla8 (MC, R); //Cruce
					P8.pantalla();
				}
				else
				{
					System.out.println("De una forma suavemente repentina oyes un discurir de agua que te llama.");
					Pantalla9 P9 = new Pantalla9 (MC, R); //Arroyo
					P9.pantalla();
				}
			}
			else
			{
				System.out.println("Felicidad quizás no sea la palabra, pero si que pueda serlo sastisfacción.");
				if (suerte<4)
				{
					if(suerte%2!=0)
					{
						System.out.println("Tras un buen rato caminando, llegas a lo que parece ser un aldea.");
						System.out.println("Las nubes bajas le aportan un toque mágico a la escena.");
						Pantalla7 P7 = new Pantalla7 (MC, R); //Aldea
						P7.pantalla();
					}
					else
					{
						System.out.println("A través de senderos y paisajes pintorescos, te topas con una señal.");
						Pantalla8 P8 = new Pantalla8 (MC, R); //Cruce
						P8.pantalla();
					}
				}
				else
				{
					if(suerte%2!=0 && suerte<7)
					{
						System.out.println("De una forma suavemente repentina oyes un discurir de agua que te llama.");
						Pantalla9 P9 = new Pantalla9 (MC, R); //Arroyo
						P9.pantalla();
					}
					else
					{
						System.out.println("No siempre se accede a los lugares más íntimos de la forma más invasiva.");
						System.out.println("Aunque a veces el hermetismo de la vergüenza no pueda ser derribado de otra forma.");
						System.out.println("Caminando terminas encontrando entre unas rocas una pequeña cascada que llena una charca donde te mojas los pies.");
						Pantalla10 P10 = new Pantalla10 (MC, R); //Cascada
						P10.pantalla();
					}
				}
			}

		}

	}



