import java.util.Scanner;

import Pantallas.Aventura;

public class Programa 
	{

		public void ejecutarPrograma()
		{
			try
			{
				Scanner eD = new Scanner(System.in);
				
				boolean checkPrograma=false;
				
				while (!checkPrograma)
				{
					Aventura MA = new Aventura ();
					//AQUÍ VA EL PROGRAMA
					
					MA.aventura();
					
					// HASTA AQUÍ VA EL PROGRAMA
					
					
					System.out.print("\n¿Quieres probar de nuevo? ");
			        boolean checkp = false;
			        while (!checkp)
			        {
			            String decision = eD.nextLine().toLowerCase();
			            if (decision.equals("si") || decision.equals("sí")) 
			            {
			                checkp = true;
			            } 
			            else if (decision.equals("no")) 
			            {
			                checkPrograma = true;
			                checkp = true;
			            } 
			            else 
			            {
			                System.out.print("\n¿Por favor, indica SÍ o NO: ");
			            }
			        }
				}
		
			}
			catch (Exception e)
			{
				System.out.println("\nError 2. Gracias por informar.\n");
			}
			finally
			{
				System.out.println("\nGracias por usar el programa.\n");
			}	
		}
	}
