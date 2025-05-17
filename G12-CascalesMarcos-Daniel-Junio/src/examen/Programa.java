package examen;

import java.util.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class Programa {

	public static void main(String[] args) {

		// Vinos constructor normal
		Vino v1 = new Vino(LocalDate.of(2020, 6, 1), "Marqués", "tinto", "reserva", 15.0);
		Vino v2 = new Vino(LocalDate.of(2015, 10, 1), "Constantino", "tinto", "gran reserva", 30.0);
		Vino v3 = new Vino(LocalDate.of(2022, 9, 1), "El Purísimo", "rosado", "crianza", 5.0);

		// constructor por defecto
		Vino v4 = new Vino(LocalDate.of(2023, 10, 1), "Don Pinpón");
		Vino v5 = new Vino(LocalDate.of(2020, 11, 1), "Gil y Gil");

		List<Vino> vinos = new ArrayList<>();

		vinos.add(v1);
		vinos.add(v2);
		vinos.add(v3);
		vinos.add(v4);
		vinos.add(v5);

		// Mostrar los vinos en consola
		System.out.println("\nLista de vinos registrados:");
		for (Vino vino : vinos) {
			System.out.println(vino);
		}

		// Crear cata profesional con sumilleres "Andoni" y "Gemma"
		CataProfesional cataProf = new CataProfesional("Bodega Talavera", "Andoni", "Gemma");

		// Crear cata amateur
		CataAmateur cataAm = new CataAmateur("Taller iniciación");

		// Crear lista de catas
		List<Cata> catas = new ArrayList<>();
		catas.add(cataProf);
		catas.add(cataAm);

		// Registrar los vinos (solo se registran los que cumplan restricciones de cada
		// tipo de cata)
		for (Vino v : vinos) {
			for (Cata c : catas) {
				c.registrarVino(v);
			}
		}

		// Mostrar vinos registrados por cata
		System.out.println("\nVinos registrados en cada cata:");
		for (Cata c : catas) {
			System.out.println("Cata: " + c.getNombre());
			for (Vino v : c.getVinos()) {
				System.out.println(" - " + v.getNombre());
			}
		}

		// Recorrer las catas para valorar y rectificar
		System.out.println("\nValoraciones en cada cata:");
		for (Cata c : catas) {
			System.out.println("\nCata: " + c.getNombre());

			if (c instanceof CataProfesional cp) {
				System.out.println("Responsable: " + cp.getResponsable());
			}

			for (Vino v : c.getVinos()) {
				c.valorarVino("Andoni", v, 8, 7, 9);
				c.valorarVino("Custodio", v, 5, 8, 9);
			}

			// Si es amateur, rectificar "Gil y Gil" por Custodio
			if (c instanceof CataAmateur ca) {
				for (Vino v : ca.getVinos()) {
					if (v.getNombre().equalsIgnoreCase("Gil y Gil")) {
						ca.rectificarValoracion("Custodio", v, 9, 9, 9);
					}
				}
			}

			// Mostrar los mejores vinos
			System.out.println("Mejores vinos:");
			for (Vino mejor : c.getMejoresVinos()) {
				System.out.println(" - " + mejor.getNombre());
			}
		}

		boolean hayRosado = vinos.stream().anyMatch(v -> v.getColor().equalsIgnoreCase("rosado"));

		System.out.println("¿Hay algún vino rosado? " + hayRosado);

		long anteriores2021 = vinos.stream().filter(v -> v.getFechaProduccion().isBefore(LocalDate.of(2021, 1, 1)))
				.count();

		System.out.println("Número de vinos producidos antes de 2021: " + anteriores2021);

		List<Vino> carosOrdenados = vinos.stream().filter(v -> v.getCoste() > 5).sorted() // usa compareTo() de Vino
				.toList();

		System.out.println("Vinos con coste > 5€ (orden natural):");
		carosOrdenados.forEach(System.out::println);

		List<String> nombresCarosOrdenados = vinos.stream().filter(v -> v.getCoste() > 5).map(Vino::getNombre).sorted() // orden
																														// alfabético
				.toList();

		System.out.println("Nombres de vinos con coste > 5€ (orden alfabético):");
		nombresCarosOrdenados.forEach(System.out::println);

		
		
		
		
		try {
		    Collection<Vino> vinosTeclado = Utils.registrarVinosPorTeclado();
		    System.out.println("Vinos registrados desde teclado:");
		    for (Vino v : vinosTeclado) {
		        System.out.println(" - " + v);
		    }
		} catch (RegistroVinoException e) {
		    System.out.println(e.getMessage());
		}

		
		
		// Lista original
        List<Integer> numeros = new ArrayList<>(List.of(4, 5, 7, 9, 4, 4));
        System.out.println("Original: " + numeros);

        // Definimos la función: cuadrado del número
        Function<Integer, Integer> cuadrado = x -> x * x;

        // Aplicamos buscarReemplazar para reemplazar todos los 4 por su cuadrado
        Utils.buscarReemplazar(numeros, 4, cuadrado);

        // Mostramos el resultado
        System.out.println("Después de reemplazar 4 por su cuadrado: " + numeros);
    }
		
		
		
		
	}
	


