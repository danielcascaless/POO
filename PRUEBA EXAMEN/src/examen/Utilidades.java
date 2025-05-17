package examen;

import java.util.Collection;
import java.util.Random;

/*
10.(0,6 ptos) Excepciones
El propósito de este ejercicio es escribir un método que genere un número aleatorio si se cumple
una condición. Para ello:
	a. Define una excepción comprobada con nombre GeneradorException que se utilizará para
	 que no ha podido cumplir su tarea. La excepción debe permitir establecer un
	mensaje de error.
	
	b. Crea una clase Utilidades y declara un método de clase getNumero. Esta operación tiene
	dos parámetros que especifican una horquilla de valores enteros, por ejemplo, 10 y 20
	definen la horquilla de valores entre 10 y 20, ambos incluidos. La horquilla debe definirse en
	el rango de 0 a 100. Utilizando un generador de números aleatorios se obtendrá un número
	al azar en el rango 0 a 100. Si el número está comprendido en la horquilla establecida, será
	retornado por la operación. En caso contrario, se intentará hasta 3 veces y si no se consigue
	se notifica la excepción GeneradorException.
	
	Nota: utiliza la clase java.util.Random para obtener un generador aleatorio. El
	método nextInt(cota) genera un número al azar entre 0 y cota - 1.
	
	c. Incluye el control de precondiciones en la operación.
	
	d. Introduce una prueba en el programa.
*/

/**
 * Clase de utilidades con métodos de clase (estáticos).
 * Se usa para ofrecer funciones generales que no dependen del estado de objetos.
 */
public class Utilidades {

    /**
     * Método de clase que intenta generar un número aleatorio dentro de una horquilla (min, max).
     * Si tras 3 intentos no se consigue, lanza una excepción comprobada (GeneradorException).
     *
     * Basado en los apuntes:
     * - Usa java.util.Random
     * - Usa nextInt(101) para generar valores entre 0 y 100 (ambos incluidos)
     * - Controla precondiciones para evitar errores de rango
     */
    public static int getNumero(int min, int max) throws GeneradorException {
        // Validación de precondiciones (mínimo mayor que 0, máximo menor o igual a 100, y min <= max)
        if (min < 0 || max > 100 || min > max) {
            throw new IllegalArgumentException("Parámetros inválidos: deben estar entre 0 y 100 y min ≤ max.");
        }

        Random random = new Random(); // Generador de números aleatorios

        // Se intentará hasta 3 veces generar un número dentro de la horquilla
        for (int i = 0; i < 3; i++) {
            int numero = random.nextInt(101); // entre 0 y 100 inclusive
            System.out.println("Intento " + (i + 1) + ": generado " + numero);

            // Si el número está en el rango permitido, se retorna
            if (numero >= min && numero <= max) {
                return numero;
            }
        }

        // Si después de 3 intentos no se genera un número válido, se lanza una excepción
        throw new GeneradorException("No se pudo generar número entre " + min + " y " + max + " tras 3 intentos.");
    }

    /**
     * Método de clase genérico que rellena una colección con 'n' elementos del mismo valor 'o'.
     *
     * Concepto clave: genericidad.
     * <T> es un tipo genérico, lo que permite usar este método con cualquier tipo de dato.
     * Ejemplo: fill(lista, 3, "hola") → añade "hola", "hola", "hola" a la lista.
     */
    public static <T> void fill(Collection<T> coleccion, int n, T o) {
        for (int i = 0; i < n; i++) {
            coleccion.add(o); // Añade 'o' n veces
        }
    }
}
