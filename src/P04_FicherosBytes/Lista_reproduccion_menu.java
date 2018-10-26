package P04_FicherosBytes;

import java.io.IOException;
import java.util.Scanner;

public class Lista_reproduccion_menu {
	
	static Scanner teclado;
	static int opcion;
	
	static int id_aux;
	static boolean bandera;
	
	static Lista_reproduccion lista;
	static Cancion cancion;
	static Cancion canciones[];
	
	public static void main(String[] args) throws IOException
	{
		
		teclado = new Scanner(System.in);
		opcion = 0;
		
		lista = new Lista_reproduccion("src\\P04_FicherosBytes\\ficheros\\lista_reproduccion.lr");
		cancion = new Cancion();
		
		
		//
		
		
		while(true)
		{
			
			
			System.out.println("_________________________________");
			System.out.println("|     LISTA DE REPRODUCCIÓN      |");
			System.out.println("|--------------------------------|");
			System.out.println("|1. CREAR LISTA DE REPRODUCCIÓN  |");
			System.out.println("|2. INSERTAR CANCIÓN             |");
			System.out.println("|3. CONSULTAR LISTA DE CANCIONES |");
			System.out.println("|4. CONSULTAR CANCIÓN            |");
			System.out.println("|5. MODIFICAR CANCIÓN            |");
			System.out.println("|6. BORRAR CANCIÓN               |");
			System.out.println("|7. MOSTRAR CANCIONES BORRADAS   |");
			System.out.println("|________________________________|");
			
			opcion = teclado.nextInt();
			
			
			switch(opcion)
			{
				case 1:
				{
				
					lista.crearLista();
					
				}break;
				
				case 2:
				{
					
					bandera = true;
					
					while(bandera)
					{
						
						System.out.println("Introduce un ID. Tiene que ser mayor a 0");

						bandera = false;
						id_aux = teclado.nextInt();
					
						canciones = lista.consultarCanciones(); 
						for(int i = 0; i < canciones.length; i++)
						{
							if(canciones[i].getId()==id_aux)
							{
								bandera = true;
							}
						}
						
						if(bandera)
						{
							System.out.print("El ID introducido no es valido. ");
						}
						else
						{
							cancion.setId(id_aux);
						}
						
					}


					System.out.println("Introduce el año");
					cancion.setAno(teclado.nextInt());
					teclado.nextLine();
					
					System.out.println("Introduce el título");
					cancion.setTitulo(teclado.nextLine());
					
					System.out.println("Introduce el Artista");
					cancion.setArtista(teclado.nextLine());
					
					System.out.println("Introduce la duracion");
					cancion.setDuracion(teclado.nextLine());
					
					System.out.println("Es española?");
					cancion.setCancion_espanola(teclado.nextBoolean());
					
					lista.insertarCancion(cancion);
					
					cancion = new Cancion();
					
				}break;
				
				case 3:
				{
					canciones = lista.consultarCanciones();
					
					
					for(int i = 0; i < canciones.length; i++)
					{
						System.out.println(canciones[i].mostrarDatosCancion());
					}
						
				
				}break;
				
				case 4:
				{

					System.out.println("Introduce el ID de la canción");
					
					if((cancion = lista.consultarCancion(lista.consultarCanciones(), teclado.nextInt())) == null)
					{
						System.out.println("La canción con ese ID no se ha encontrado");
					}
					else
					{
						System.out.println(cancion.mostrarDatosCancion());
					}
					
				
				}break;
				
				case 5:
				{
					
					System.out.println("Introduce el ID de la canción");
					
					id_aux = teclado.nextInt();
					
					if((cancion = lista.consultarCancion(lista.consultarCanciones(), id_aux)) == null)
					{
						System.out.println("La canción con ese ID no se ha encontrado");
					}
					else
					{
						System.out.println("Introduce un nuevo año");
						
						if(lista.modificarCancion(id_aux, teclado.nextInt()))
						{
							System.out.println("La canción ha sido modificada");
						}
						else
						{
							System.out.println("La canción no ha sido modificada");
						}
						
						
						
					}
					
				}break;
				
				case 6:
				{

					
					System.out.println("Introduce el ID de la canción");
					
					id_aux = teclado.nextInt();
					
					if((cancion = lista.consultarCancion(lista.consultarCanciones(), id_aux)) == null)
					{
						System.out.println("La canción con ese ID no se ha encontrado");
					}
					else
					{
						System.out.println("La canción se ha borrado");
						lista.borrarCancion(id_aux);
					}
					
				
				}break;
				
				case 7:
				{
					
					canciones = lista.mostrarCancionesBorradas();
					
					for(int i = 0; i < canciones.length; i++)
					{
						System.out.println("Id: " + canciones[i].getAno());
					}
					
				}
			}
			
		}
		
	}

}
