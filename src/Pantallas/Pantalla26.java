package Pantallas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Personajes.Personaje;

public class Pantalla26 {
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
	public Pantalla26 (Personaje MC, Random R)
	{
		this.MC=MC;
		this.R=R;
	}
		
		public void pantalla() //Esta es la pantalla de elegir ir al ascenso
		{
			Scanner eD = new Scanner (System.in);
			FuncionesUtiles FU = new FuncionesUtiles();
			//Vamos a probar el metodo leerArchivo
			
			String estadoInterior = FU.leerArchivo("Interior.txt");
			
			String estadoDragon = FU.leerArchivo("DragonAlado.txt");
				
				System.out.println("\n~Entre acantilados~\n");
				
				if (estadoDragon.equals("vivo"))
				{
					System.out.println("Una gran sombra detiene la luz del sol por un momento.");
					System.out.println("Miras al cielo y a lo lejos algo se aleja volando.");
				}
				else
				{
					System.out.println("Se respira un aire frío y profundo, vacío de sensaciones.");
				}
				
				System.out.println("Amplios lagos se ven a un lado, mientras por el otro un alto abismo nos llama desde abajo.");
				System.out.println("Estas tranquilo.");
				System.out.println("Te paras a mirar alrededor.");
				
				int decision = FU.decision("Miro al cielo.", "Miro al horizonte.", "Me voy.", eD);
				
				if (decision==1)
				{
					String estadoCerdoHijos = FU.leerArchivo("CerdoHijos.txt");
					if (estadoCerdoHijos.equals("muertos"))
					{
						System.out.println("\nNo siempre la vida se abre paso.");
						System.out.println("Y cobijando tus dulces deseos sigues pensando en el futuro.");
						
					}
					else
					{
						System.out.println("\nUn cielo despejado, algo apagado.");
						getMC().setVida(getMC().getVida()+20);
						if (estadoDragon.equals("vivo"))
						{
							System.out.println("Un profundo respirar puede sentirse a lo lejos.");
						}
					}
					String estadoMA = FU.leerArchivo("MissAdentros.txt");
					if (FU.decision("Me siento en el suelo.", "Me voy.", eD)==1)
					{
						System.out.println("\nTe sientas en el suelo.");
					
						if (!estadoInterior.equals("vivo"))
						{
						System.out.println("Sientes que algo no está bien.");
						System.out.println("No sabes qué es, ni desde cuando, pero no lo está.");
						System.out.println("Lo que sí consideras tener es el poder para vencer a cualquier sensación desagradable.");
						System.out.println("Pero no todo es tan cómodo como parecía, sientes como unas piedras moverse.");
						System.out.println("Te giras y ante tí aparece un ser terrible.");
						
						if (estadoMA.equals("triste"))
						{
							System.out.println("Una aplia figura con abrigo de alta negrura y cara pálida como la blanca luna nos mira fijamente.");
						}
						else if (estadoMA.equals("enfadada"))
						{
							System.out.println("Apagado, deforme, traído de las entrañas del planeta, no sabría describirlo.");
						}
						else
						{
						System.out.println("Una blanca cara sonriente y cuchillas como agujas de paladio se acercan hacia ti como una araña.");
						}
						System.out.println("¿Qué es este frío?");
						System.out.println("¿Por qué ahora?");
						System.out.println("¿Qué he hecho?");
						System.out.println("De repente desaparece.");
						if (FU.decision("Nada puede parar mi voluntad, estoy preparado.", "Me largo de aquí.", eD)==1)
						{
				
							System.out.println("\nUn sonido penetrante y suave, fino como el paladio e incesante como la sed, susurra a tus oídos.");
							System.out.println("¿Mamá? - Oyes.");
							System.out.println("Un ruido como el arrastrar una pesada maquinaria férrica irrumpe de repente");
							System.out.println("Un escalofrío te recorre la piel liberas la tensión que te aflijía.");
							System.out.println("Siempre hay motivos para recuperar la respiración");
							System.out.println("El destino te llama, te enfrentas a él.");
							
							
							String nombreDestino = new StringBuilder(getMC().getNombre().replace(" ", "")).reverse().toString();
							int claseDestino = R.nextInt(6);
							int suerte = R.nextInt(11);
							
							
							Personaje Destino = new Personaje (nombreDestino, claseDestino, suerte, getMC().getVida(), getMC().getAtaque(), getMC().getDefensa());
							
							FU.batalla (getMC(), Destino);
							
							if (getMC().getVida() >= Destino.getVida())
							{
									try {
								 	File file = new File ("Interior.txt");
									BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
								    writer.write("muerto");
								    writer.close();
									}
									catch (Exception e)
									{
										System.out.println("Error al poner muerto.");
									}
									System.out.println("No es fácil encararse a uno mismo ni a sus miedos.");
									System.out.println("Enhorabuena.");
									System.out.println("Divagando entre tus pensamientos te topas con unas amplias plachas de metal que forman una puerta.");
									
									Pantalla19 P19 = new Pantalla19 (getMC(), R);
									P19.pantalla();
							}
							
							
							
						}
						else
						{
							System.out.println("Tras volver a tí, inocente pero no falto de presteza, te alejas del lugar disimulando.");
							System.out.println("Te quedas pensando en lo que has visto y oído, tocado y sentido.");
							System.out.println("Y nada parece tener la suficiente solidez para notarse.");
							System.out.println("Divagando entre tus pensamientos te topas con unas amplias plachas de metal que forman una puerta.");
							
							Pantalla19 P19 = new Pantalla19 (getMC(), R);
							P19.pantalla();
							
							
						}
						
						
					}
					else
					{
						System.out.println("\n¿Nada resulta demasiado estimulante?");
						System.out.println("Muy bien, pues tienes entonces dos opciones.");
						System.out.println("Al oeste, donde está la cabaña");
						if (estadoDragon.equals("vivo"))
						{
							System.out.println("O al este, desde donde profundo respirar se siente intenso.");
						}
						else
						{
						System.out.println("O al este, donde nada parece agitar la bruma que se forma por allí.");
						}
						
						if (FU.decision("Voy hacia la cabaña", "Voy hacia el este.", eD)==1)
						{
							Pantalla23 P23 = new Pantalla23 (getMC(), R);
							P23.pantalla();
							
						}
						else
						{
							Pantalla25 P25 = new Pantalla25 (getMC(), R);
							P25.pantalla();
						}
					}	
					
				}
				else
				{
					System.out.println("\n¿Nada resulta demasiado estimulante?");
					System.out.println("Muy bien, pues tienes entonces dos opciones.");
					System.out.println("Al oeste, donde está la cabaña");
					if (estadoDragon.equals("vivo"))
					{
						System.out.println("O al este, desde donde profundo respirar se siente intenso.");
					}
					else
					{
					System.out.println("O al este, donde nada parece agitar la bruma que se forma por allí.");
					}
					
					if (FU.decision("Voy hacia la cabaña", "Voy hacia el este.", eD)==1)
					{
						Pantalla23 P23 = new Pantalla23 (getMC(), R);
						P23.pantalla();
						
					}
					else
					{
						Pantalla25 P25 = new Pantalla25 (getMC(), R);
						P25.pantalla();
					}
				}
				}
				else if (decision==2)
				{	
					System.out.println("\nQuién pudiera cruzar la línea entre el cielo y la tierra y ver más allá, ¿verdad?");
				
					String estadoEscudo = FU.leerArchivo("ObjetoCuevas.txt");
					if (estadoEscudo.equals("lotiene"))
					{
						System.out.println("Miras el escudo que cogiste en las cuevas.");
						System.out.println("Te preguntas de quién sería para estar donde estaba.");
						System.out.println("Es pesado y efectivo, pero tampoco nada del otro mundo.");
					}
					else
					{
						System.out.println("\nUna sensación vacía te recuerda la profundidad de los abismos que rodean el lago.");
						if (estadoDragon.equals("vivo"))
						{
							System.out.println("Una brisa algo cercana te eriza la piel.");
						}
					}
					getMC().setVida(getMC().getVida()+20);

					System.out.println("Ahora tienes entonces dos opciones.");
					System.out.println("Al oeste, donde está la cabaña");
					if (estadoDragon.equals("vivo"))
					{
						System.out.println("O al este, desde donde profundo respirar se siente intenso.");
					}
					else
					{
					System.out.println("O al este, donde nada parece agitar la bruma que se forma por allí.");
					}
					
					if (FU.decision("Voy hacia la cabaña", "Voy hacia el este.", eD)==1)
					{
						Pantalla23 P23 = new Pantalla23 (getMC(), R);
						P23.pantalla();
						
					}
					else
					{
						Pantalla25 P25 = new Pantalla25 (getMC(), R);
						P25.pantalla();
					}
				}
				else if (decision==3)
				{
					System.out.println("\n¿Nada resulta demasiado estimulante?");
					System.out.println("Muy bien, pues tienes entonces dos opciones.");
					System.out.println("Al oeste, donde está la cabaña");
					if (estadoDragon.equals("vivo"))
					{
						System.out.println("O al este, desde donde profundo respirar se siente intenso.");
					}
					else
					{
					System.out.println("O al este, donde nada parece agitar la bruma que se forma por allí.");
					}
					
					if (FU.decision("Voy hacia la cabaña", "Voy hacia el este.", eD)==1)
					{
						Pantalla23 P23 = new Pantalla23 (getMC(), R);
						P23.pantalla();
						
					}
					else
					{
						Pantalla25 P25 = new Pantalla25 (getMC(), R);
						P25.pantalla();
					}
					
				}
				else
				{
					System.out.println("No ha habido decisión");
				}
				
				
				
			}
			
			
			
			
			
			
			
			
		
		}



