package com.mfigueroa.demo;

import com.mfigueroa.demo.model.Movie;
import com.mfigueroa.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication

public class BuscadorApplication implements CommandLineRunner {

	@Autowired
	private MovieService movieService;

	public static void main(String[] args) {
		SpringApplication.run(BuscadorApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String proveedor;

		boolean continuar = true;  // Variable para controlar el ciclo

		while (continuar) {
			// Solicitar al usuario que ingrese un proveedor
			System.out.println("Ingrese un nombre de proveedor: ");
			proveedor = sc.nextLine().trim();  // Leer el nombre del proveedor y eliminar posibles espacios extra

			// Obtener las películas del proveedor ingresado
			List<Movie> peliculas = movieService.obtenerPeliculasPorProveedor(proveedor);

			// Verificar si se encontraron películas para el proveedor
			if (peliculas.isEmpty()) {
				System.out.println("No se encontraron películas para el proveedor " + proveedor);
			} else {
				System.out.println("Catálogo de películas para el proveedor " + proveedor + ": ");
				peliculas.forEach(pelicula -> System.out.println("Id-" + pelicula.getId() + " | " + pelicula.getNombre()));  // Mostrar los nombres de las películas
			}

			// Preguntar si el usuario quiere realizar otra búsqueda
			System.out.println("¿Desea realizar otra búsqueda? (s/n)");

			// Leer la respuesta del usuario para continuar
			String respuesta = sc.nextLine().trim().toLowerCase();  // Leer la respuesta completa y normalizar a minúsculas

			// Si la respuesta no es 's', terminamos el ciclo
			if (!respuesta.equals("s")) {
				continuar = false;  // Salir del ciclo
			}
		}

		// Cerrar el scanner para liberar recursos
		sc.close();
		System.out.println("Programa finalizado.");
		System.exit(0);
	}

}
