package Pantallas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import Pantallas.Pantalla1;
import Personajes.Personaje;

public class Aventura 
{	
	public void aventura()
	{
		Scanner eD = new Scanner (System.in);
		
		System.out.println("\n~~AVENTURAS POR LAS TIERRAS DE MISS ADENTROS~~");
		
		//Cada pantalla es una clase excepto la primera pantalla que está aquí:
		
		System.out.println("\nHola, te doy la bienvenida a las Tierras de Miss Adentros.");
		System.out.print("\nLo primero son las presentaciones... ¿cómo te llamas? ");
		String nombre = eD.nextLine();
		String tocayo="";//Una tontería por si se llama igual que yo.
		
		if (nombre.equals("Carlos"))
		{
			tocayo=" también";
		}
		
		System.out.print("\nMuy bien " + nombre + ", yo me llamo Carlos" +tocayo+ ".");
		
		System.out.println("\nAntes de embarcarte en una aventura como ésta, tienes que definirte como aventurero.");
		System.out.println("Para ello necesito que me digas qué clase de aventurero eres: \n");
		System.out.println("1: Soy un guerrero, lleno de valentía mi corazón.");
		System.out.println("2: Soy un ladrón, el sigilo es mi sombra.");
		System.out.println("3: Soy un mago, la sabiduría inunda mi mente.");
		System.out.println("4: Soy un monje, sólo una única fuerza me empuja.");
		System.out.println("5: Soy un berserker, la furia me inunda cuando me siento débil.");
		System.out.println("0: No tengo clase, sólo soy un aventurero.\n");
		
		int clase=0;
	
		boolean checkNumero=false;
		while (!checkNumero) 
		{
			clase = 0;
			System.out.print("Opción: ");
			try 
			{
				clase = eD.nextInt();
				if (clase < 0) 
				{
					System.out.println("Introduce un número positivo.\n");
				} 
				else if (clase >= 6) 
				{
					System.out.println("Introduce un número entre 0 y 4.\n");
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
		
		Random R = new Random ();
		int suerte = R.nextInt(11); //Esta es la suerte del protagonista, se puede modular más adelante
		if (nombre.equals("Carlos"))//Si se llama como yo es la máxima
		{
			suerte=999;
		}
		
		
		Personaje MC = new Personaje (nombre, clase, suerte, 100, 20, 5); //Creamos el protagonista y la suerte es distinta para cada personaje creado
	
		System.out.println("\n...");
		System.out.println("\nPerfecto " + MC.getNombre() + " ya veo que tu personaje ha sido creado, y eres un " + MC.getNombreClase() + ".");
		//Para ver si alguien con clase puede vencer a alguien sin clase ambos con suerte aleatoria, encima atacando el de sin clase antes
		System.out.println("Como último paso, te vas a enfrentar a un feroz enemigo, ¿estás listo?");
		System.out.println("Un segundo que lo traigamos de las mazmorras... \n");
		
		//Para una batalla, primero crear el enemigo
		suerte = R.nextInt(11);
		
		
		//Una tontería, hacer aleatorio el nombre del prisionero
		
		int numeroParaNombre=R.nextInt(7)+3;
		String nuevoNombre="";
		
		for (int i=0;i<numeroParaNombre;i++)
		{
			char letraAleatoria = (char) (R.nextInt(26) + 'a');
			
			nuevoNombre=nuevoNombre+letraAleatoria;
			if (i==0)
			{
				nuevoNombre=nuevoNombre.toUpperCase();
			}	
		}
		
		
		
		
		Personaje E1 = new Personaje (nuevoNombre, 0, suerte, 100, 20, 5);
		
		//Luego llamar a la batalla
	
		FuncionesUtiles FU = new FuncionesUtiles();
		
		FU.batalla(E1, MC);
		
		
		//Desenlace de la batalla
		
		if (MC.getVida() <0)
		{
			System.out.println("\n"+MC.getNombre() + " lo siento, no eres lo suficientemente fuerte para esta aventura.");
	
		}
		else
		{
			System.out.println("\n¡Enhorabuena!");
			
			
			//CREAR LOS DMFs

			try {
					//DMF del cerdo
				   File Cerdo = new File("Cerdo.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    BufferedWriter writer = new BufferedWriter(new FileWriter(Cerdo, false));
				    writer.write("vivo"); //El cerdo azul inicia vivo
				    writer.close();
				    
				    //DMF de los babypigs
				    File CerdoHijos = new File("CerdoHijos.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    writer = new BufferedWriter(new FileWriter(CerdoHijos, false));
				    writer.write("vivos"); //Sus hijos por tanto están vivos
				    writer.close();
				    
				    //DMF de MissAdentros
				    File MissAdentros = new File("MissAdentros.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    writer = new BufferedWriter(new FileWriter(MissAdentros, false));				 
				    writer.write("inicio");
				    writer.close();
				    
				  //DMF de la espada
				    File Espada = new File("Espada.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    writer = new BufferedWriter(new FileWriter(Espada, false));				 
				    writer.write("esta");
				    writer.close();
				  //DMF del cadaver
				    File Cadaver = new File("Cadaver.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    writer = new BufferedWriter(new FileWriter(Cadaver, false));				 
				    writer.write("esta");
				    writer.close();
				    //DMF de la bruja
				    File Bruja = new File("Bruja.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    writer = new BufferedWriter(new FileWriter(Bruja, false));				 
				    writer.write("viva");
				    writer.close();
				    
				    File Caballero = new File("Caballero.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    writer = new BufferedWriter(new FileWriter(Caballero, false));				 
				    writer.write("vivo");
				    writer.close();
				    
				    File Colgante = new File("Colgante.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    writer = new BufferedWriter(new FileWriter(Colgante, false));				 
				    writer.write("nolotiene");
				    writer.close();
				    
				    File Montañas = new File("Montañas.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    writer = new BufferedWriter(new FileWriter(Montañas, false));				 
				    writer.write("cerradas");
				    writer.close();
				    
				    File Final = new File("Final.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    writer = new BufferedWriter(new FileWriter(Final, false));				 
				    writer.write("aunno");
				    writer.close();
				    
				    File Interior = new File("Interior.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    writer = new BufferedWriter(new FileWriter(Final, false));				 
				    writer.write("vivo");
				    writer.close();
				    
				    File Cuevas = new File("Cuevas.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    writer = new BufferedWriter(new FileWriter(Cuevas, false));				 
				    writer.write("no");
				    writer.close();
				    
				    File ObjetoCuevas = new File("ObjetoCuevas.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    writer = new BufferedWriter(new FileWriter(ObjetoCuevas, false));				 
				    writer.write("nolotiene");
				    writer.close();
				    
				    File SerCuevas = new File("SerCuevas.txt");
				    // Crear FileWriter con append = false para sobrescribir el archivo
				    writer = new BufferedWriter(new FileWriter(SerCuevas, false));				 
				    writer.write("vivo");
				    writer.close();
				    
				    File SenyorMontanyas = new File ("SenyorMontanyas.txt");
				    writer = new BufferedWriter(new FileWriter(SenyorMontanyas, false));				 
				    writer.write("nohablado");
				    writer.close();
				    
				    File Atajo = new File ("Atajo.txt");
				    writer = new BufferedWriter(new FileWriter(Atajo, false));				 
				    writer.write("noatajado");
				    writer.close();
				    
				    File P22 = new File ("P22.txt");
				    writer = new BufferedWriter(new FileWriter(P22, false));				 
				    writer.write("nohallegadoaun");
				    writer.close();
				    
				    File Cabanya = new File ("Cabanya.txt");
				    writer = new BufferedWriter(new FileWriter(Cabanya, false));				 
				    writer.write("nohallegadoaun");
				    writer.close();
				    
				    File DragonAlado = new File ("DragonAlado.txt");
				    writer = new BufferedWriter(new FileWriter(DragonAlado, false));				 
				    writer.write("vivo");
				    writer.close();
				    
				    File Colmillo = new File ("Colmillo.txt");
				    writer = new BufferedWriter(new FileWriter(Colmillo, false));				 
				    writer.write("nolotiene");
				    writer.close();

				    System.out.println("Ya está todo listo.");
				    System.out.println("Ahora solo queda que comience la aventura... ¡Vamos allá!\n");

				    System.out.println("\n...\n");
				    //EMPIEZA EL JUEGO AQUI
				    Pantalla1 P1 = new Pantalla1(MC,R); // El R es sólo para reciclar el objeto, no se si es mejor o peor crearlo cada vez.	    
				    P1.pantalla();
				  //Y AQUI EL DESENLACE
				    
				    String estadoFinal="";
				    try
					{
						File file =new File ("Final.txt");
						BufferedReader br = new BufferedReader(new FileReader(file));
			            String line;
			            
			            //Estas línea anterior de código configuran br para que leer el archivo de texto “DMF.txt” línea por línea con el método br.readLine()
			            
			            while ((line = br.readLine()) != null) 
			            {
			                
			                  estadoFinal=line;
			                    
			            }	       	            
			            br.close();			
					}
					catch (Exception e)
					{
						System.out.println("Error al leer el archivo.");
					}
				    
				    
				    
				    if (estadoFinal.equals("ahorasi"))
				    {
				    	System.out.println("\nEnhorabuena, has completado la aventura, espero que te haya gustado.");
				    } 
				    else 
				    {
				        System.out.println("\n"+MC.getNombre() + " lo siento, no has completado la aventura.");
				    }
				} catch (Exception e) {
				    System.out.println("Error. No se ha podido escribir en el archivo.");
				}
		}
	
		//En este punto borramos los DMFs
		try 
		{
		    File file = new File("Cerdo.txt");//El del cerdo

		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    
		  //Y aqui el siguiente
		    
		   file = new File("CerdoHijos.txt");//El del cerdo

		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("MissAdentros.txt");//El del MA

		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("Espada.txt");//El de la espada

		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("Cadaver.txt");//El del cadaver
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("Bruja.txt");//El de la bruja
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("Caballero.txt");//El del caballero
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("Montañas.txt");//El de las montañas
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("Final.txt");//El del final
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("Cuevas.txt");//El de si va a la cueva desde el cerdo
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("ObjetoCuevas.txt");//El del objeto de la cueva
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("Colgante.txt");//El del objeto de la cueva
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("SerCuevas.txt");//El del ser de la cueva
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("SenyorMontanyas.txt");//El del ser de la cueva
		   
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    
		    file = new File("Atajo.txt");//El del ser de la cueva
		   
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("Interior.txt");//El del ser de la cueva
		   
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("P22.txt");//El del ser de la cueva
		   
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("Cabanya.txt");//El del ser de la cueva
		   
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("DragonAlado.txt");//El del ser de la cueva
		   
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		    file = new File("Colmillo.txt");//El del ser de la cueva
		   
		    
		    if(file.exists()) 
		    {
		    	file.delete();
		    }
		} 
		catch (Exception e) 
		{
		    System.out.println("Error 10. Los DMFs no han podido ser borrados.");
		}
	}
}
