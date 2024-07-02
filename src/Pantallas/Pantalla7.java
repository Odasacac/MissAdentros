package Pantallas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla7 {
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
	public Pantalla7 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla de la aldea
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			
			System.out.println("\n~Una gélida acogida~\n");
			
			System.out.println("No hay personas, sólo varios cuervos dominan la escena picoteando algo.");
			if (R.nextInt()>getMC().getSuerte())
			{
			System.out.println("Un cuervo se abalanza sobre ti y te da un picotazo, luego sale volando.");
			getMC().setVida(getMC().getVida()-10);
			if (getMC().getVida()<0)
			{
				getMC().setVida(0);
			}
			}
			
			String estadoDeLaBruja="variableInicial";
			
			try {	
				 	File file = new File("Bruja.txt");
		            BufferedReader br = new BufferedReader(new FileReader(file));
		            String line;
		            
		            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
		            
		            while ((line = br.readLine()) != null) 
		            {
		                
		                  estadoDeLaBruja=line;
		                    
		            }	       	            
		            br.close();
			}
			catch (Exception e)
			{
				System.out.println("Error al leer el archivo");
			}
				
		            
			if (estadoDeLaBruja.equals("viva"))
			{
				System.out.println("Te acercas a una casa que tiene el cráneo de una cabra en el marco de la puerta.");
				if (R.nextInt()>getMC().getSuerte()&&getMC().getClase()!=4)
				{
					System.out.println("Otro cuervo se abalanza sobre ti y te da otro picotazo, luego sale volando.");
					getMC().setVida(getMC().getVida()-10);
					if (getMC().getVida()<0)
					{
						getMC().setVida(0);
					}
				}
			
				if (FU.decision("Toco a la puerta.", "Sigo mi camino, no tengo buenas sensaciones", eD)==1)
				{
					System.out.println("\nUna mujer con aspecto descuidado y con una mirada algo inquietante te da la bienvenida.");
					System.out.println("Pasas dentro de la casa y te sientas junto a ella en una pequeña mesa llena de velas.");
					System.out.println("\n- Vamos a jugar a un juego - dice.");
					System.out.println("Saca dos frascos, uno verde y otro morado.");
					System.out.println("- Si te bebes el frasco verde, tu defensa se reducirá al mínimo, tu fuerza será grandiosa y saldrás por esta puerta.");
					System.out.println("- Si te bebes el frasco morado, tu fuerza se reducirá al mínimo, pero regresarás a tu ciudad.");
					System.out.println("- El juego reside en que colocaré dos cartas boca abajo, y la carta que elijas será el frasco del que bebas.");
			
				
					if(FU.decision("No te apetece y decides marcharte.", "Aceptas su juego.", eD)==1)
					{
						System.out.println("\nLa mujer ve tus intenciones y te agarra fuerte del brazo.");
						System.out.println("Intentas liberarte...");
						int suerte = R.nextInt(11);
						if (getMC().getSuerte()>suerte)
						{
						System.out.println("Pero te da un fuerte bofetón.");
						getMC().setVida(getMC().getVida()-10);
						}
						else
						{
							System.out.println("Lo consigues y corres hasta la puerta, pero está firmemente cerrada.");
						}
						System.out.println("Acorralado, te enfrentas a la mujer.");
						suerte = R.nextInt(11);
						Personaje Bruja = new Personaje ("Bruja", 3, suerte, 60, 20,20);
						FU.batalla(Bruja, getMC());
						if (getMC().getVida() >= Bruja.getVida())
						{
							try 
							{
							File file = new File ("Bruja.txt");
							BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
						    writer.write("muerta");
						    writer.close();
							}
							catch (Exception e)
							{
								System.out.println("Error al actualizar Bruja.txt");
							}
							
							System.out.println("\nEl cadáver de la mujer yace en el suelo.");
							System.out.println("De entre sus pertenencias decides quedarte con un pequeño libro, parece un diccionario.");
							System.out.println("Sales de la casa, con no buenas sensaciones.");
							System.out.println("\nNo hay gran cosa más por los alrededores, por lo que atraviesas la aldea, continuando el camino.");
							Pantalla8 P8 = new Pantalla8(getMC(), R);
							P8.pantalla();
						}
					
					}
					else
					{
						System.out.println("\nLa mujer coloca dos cartas bocabajo.");
						if (FU.decision("Eliges la carta de la izquierda", "Eliges la carta de la derecha", eD)==1)
						{
							if (getMC().getSuerte()%2==0)
							{
								System.out.println("\nAl darle la vuelta, la carta muestra un frasco de color verde.");
								System.out.println("Lo bebes.");
								getMC().setDefensa(1);
								getMC().setAtaque(150);
								System.out.println("La mujer sonríe y sales por la puerta.");
								System.out.println("No hay gran cosa más por los alrededores, por lo que sales de la aldea.");
								Pantalla8 P8 = new Pantalla8(getMC(), R);
								P8.pantalla();
								
							
							}
							else
							{
								System.out.println("\nAl darle la vuelta, la carta muestra un frasco de color morado.");
								getMC().setVida(getMC().getVidaMaxima());
								getMC().setAtaque(5);
								System.out.println("Lo bebes.");
								System.out.println("Te desmayas.");
								Pantalla6 P6 = new Pantalla6(getMC(), R);
								P6.pantalla();
								
							}
						}
						else
						{
							if (getMC().getSuerte()%2==0)
							{
								System.out.println("\nAl darle la vuelta, la carta muestra un frasco de color morado.");
								System.out.println("Lo bebes.");
								getMC().setVida(getMC().getVidaMaxima());
								getMC().setAtaque(5);
								System.out.println("Te desmayas.");
								Pantalla6 P6 = new Pantalla6(getMC(), R);
								P6.pantalla();
							}
							else
							{
								System.out.println("\nAl darle la vuelta, la carta muestra un frasco de color verde.");
								System.out.println("Lo bebes.");
								getMC().setDefensa(1);
								getMC().setAtaque(150);
								System.out.println("La mujer sonríe y sales por la puerta.");
								System.out.println("No hay gran cosa más por los alrededores, por lo que sales de la aldea.");
								Pantalla8 P8 = new Pantalla8(getMC(), R);
								P8.pantalla();
								
							}
						}
					}			
				}
				else
				{
					System.out.println("\nNo hay gran cosa más por los alrededores, por lo que atraviesas la aldea, continuando el camino.");
					Pantalla8 P8 = new Pantalla8(getMC(), R);
					P8.pantalla();
				}
			
			
			}
			
			
			
			else
			{
				System.out.println("\nNo hay gran cosa más por aquí, pero un aura extraña rodea el lugar.");
				System.out.println("No tienes buenas sensaciones y decides marcharte.");
				Pantalla8 P8 = new Pantalla8(getMC(), R);
				P8.pantalla();
			}
		
		}

}
