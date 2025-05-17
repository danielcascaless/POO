package examen;

import java.util.*;



/**
b) Crea una clase Programa con la siguiente funcionalidad:
• Declara una lista vacía de reservas.
• Crea una reserva para la bici 1 y usuario "juan". Añade la reserva a la lista.
• Igual que el anterior con bici 2 y usuario "pedro", bici 3 y usuario "enrique".
• Muestra en la consola el contenido de la lista para comprobar que todo ha ido bien.
*/


/**
 * Clase principal del programa.
 * Contiene el método main que prueba las funcionalidades de la aplicación:
 * reservas, estaciones, clonación, alquiler, streams, genéricos y excepciones.
 */
public class Programa {

    public static void main(String[] args) {

        // Se crea una lista de reservas vacía (fuera del contexto de EstacionReservas)
        List<Reserva> reservas = new ArrayList<>();

        // Se añaden tres reservas nuevas (caducan en 30 minutos)
        reservas.add(new Reserva(1, "juan"));
        reservas.add(new Reserva(2, "pedro"));
        reservas.add(new Reserva(3, "enrique"));

        // Mostrar la lista de reservas
        System.out.println("\nContenido de la lista de reservas:");
        for (Reserva r : reservas) {
            System.out.println(r);
        }
        
        /*
        9. (0,45 ptos) Procesamiento utilizando el modelo stream
        En el programa del bloque 0, utilizando la lista de reservas, implementa las siguientes consultas
        utilizando el procesamiento basado en streams:
        
        • Consulta si la bici 1 ha sido reservada. Respuesta esperada: true.
        
        • Cuenta el número de reservas caducadas de "juan". Respuesta esperada: 0
        
        • Obtén una lista con las reservas activas ordenadas alfabéticamente por el identificador del
        usuario. Muestra el resultado en la consola. Respuesta esperada: una nueva lista con todas
        las reservas ordenadas	
        */

        // --------------- STREAMS (procesamiento funcional) ----------------

        System.out.println("\nSTREAMS:");

        // ¿La bici 1 ha sido reservada? Se busca por ID
        boolean reservadaBici1 = reservas.stream()
                .anyMatch(r -> r.getIdBici() == 1);
        System.out.println("¿Bici 1 reservada? " + reservadaBici1);

        // ¿Cuántas reservas caducadas tiene el usuario "juan"?
        long caducadasJuan = reservas.stream()
                .filter(r -> r.getUsuario().equals("juan"))
                .filter(Reserva::caducada)
                .count();
        System.out.println("Reservas caducadas de juan: " + caducadasJuan);

        // Lista de reservas activas ordenadas alfabéticamente por usuario
        List<Reserva> ordenadas = reservas.stream()
                .filter(Reserva::activa)
                .sorted(Comparator.comparing(Reserva::getUsuario))
                .toList();
        System.out.println("Reservas activas ordenadas:");
        ordenadas.forEach(System.out::println);
        
        /*
        6. (0,3 ptos) Programa
        En el programa del bloque 0 añade la siguiente funcionalidad:
        
        • Crea una estación con nombre "Glorieta" y 4 bicicletas:
        	o Da de alta una nueva bici y muestra el identificador asignado por la consola.
        	o El usuario "juan" alquila la bici 1 en este momento.
        	
        • Crea una estación con reservas con nombre "Plaza Circular" y 3 bicicletas:
        	o El usuario "juan" reserva la bici 1.
        	
        • Construye una lista de estaciones y añade las dos estaciones anteriores.
        
        • Construye una lista vacía de estaciones llamada "copias".
        
        • Recorre la lista de estaciones:
        	o Muestra el conjunto de bicis.
        	o Crea una copia y añádela a la lista "copias".
        	
        • Añade la lista copias a la lista de estaciones.
        
        • Recorre de nuevo la lista de estaciones:
        	o Si la estación permite reservas, comprueba si el usuario "juan" tiene una reserva
        	activa y en ese caso, efectúa el alquiler de la bici reservada.
        	o Muestra el nombre de la estación y las bicis alquiladas.
         */

        // --------------- ESTACIÓN SIN RESERVAS ----------------

        // Crear una estación normal (sin reservas) con 4 bicis
        Estacion glorieta = new Estacion("Glorieta", 4);

        // Se da de alta una nueva bici y se muestra su ID
        int nuevaBici = glorieta.anadirBici();
        System.out.println("\nNueva bici añadida: " + nuevaBici);

        // El usuario "juan" alquila la bici 1 en este momento
        glorieta.alquilar(1, "juan");

        // --------------- ESTACIÓN CON RESERVAS ----------------

        // Crear una estación con reservas con 3 bicis
        EstacionReservas plaza = new EstacionReservas("Plaza Circular", 3);

        // El usuario "juan" reserva la bici 1
        plaza.reservar(1, "juan");

        // --------------- LISTAS DE ESTACIONES Y COPIAS ----------------

        List<Estacion> estaciones = new ArrayList<>();
        estaciones.add(glorieta);
        estaciones.add(plaza);

        // Lista vacía para las copias
        List<Estacion> copias = new ArrayList<>();

        // Recorrer estaciones originales
        for (Estacion e : estaciones) {
            System.out.println("\nEstación: " + e.getNombre());
            System.out.println("Bicis alquiladas: " + e.obtenerBicisAlquiladas());

            // Clonamos la estación y la añadimos a la lista de copias
            Estacion copia = e.clone();
            copias.add(copia);
        }

        // Añadir las copias a la lista principal
        estaciones.addAll(copias);

        // --------------- ALQUILER DESDE RESERVA ----------------

        for (Estacion e : estaciones) {

            // Si la estación es del tipo EstacionReservas
            if (e instanceof EstacionReservas) {
                EstacionReservas er = (EstacionReservas) e;

                // Si juan tiene una reserva activa, alquila la bici reservada
                Reserva r = er.getReservaActiva("juan");
                if (r != null) {
                    er.alquilar(r.getIdBici(), "juan");
                }
            }

            // Mostrar el nombre y bicis alquiladas de la estación
            System.out.println("Estación: " + e.getNombre());
            System.out.println("Bicis alquiladas: " + e.obtenerBicisAlquiladas());
        }

        // --------------- EXCEPCIÓN: getNumero ----------------

        System.out.println("\nPRUEBA DE getNumero() con excepción:");
        try {
            int numero = Utilidades.getNumero(10, 20);
            System.out.println("Número generado: " + numero);
        } catch (GeneradorException e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        
        /*
        11.(0,45 ptos) Genericidad
        Implementa en la clase Utilidades un método de clase genérico denominado fill cuya tarea es
        introducir en una colección n elementos con valor o. Por ejemplo, la llamada fill(lista, 5,
        "examen") deberá introducir 5 veces la cadena "examen" en la colección lista.
        En el programa principal realiza una prueba del método.
        */
        // --------------- MÉTODO GENÉRICO: fill ----------------

        System.out.println("\nPRUEBA DEL MÉTODO FILL:");
        List<String> listaTextos = new ArrayList<>();
        Utilidades.fill(listaTextos, 5, "examen");

        for (String s : listaTextos) {
            System.out.println(s);
        }
    }
}
