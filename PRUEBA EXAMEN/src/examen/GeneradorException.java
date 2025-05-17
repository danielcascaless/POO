package examen;

/*
 * 10.(0,6 ptos) Excepciones
El propósito de este ejercicio es escribir un método que genere un número aleatorio si se cumple
una condición. Para ello:
	a. Define una excepción comprobada con nombre GeneradorException que se utilizará para
	notificar que no ha podido cumplir su tarea. La excepción debe permitir establecer un
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
 * Clase que define una excepción comprobada personalizada.
 * Extiende la clase Exception, lo que la convierte en una excepción "checked" (comprobada).
 * Según los apuntes, las excepciones comprobadas obligan a ser declaradas en los métodos que las pueden lanzar.
 */
public class GeneradorException extends Exception {

    // Identificador de versión de serialización (por buenas prácticas, aunque no es obligatorio aquí)
    private static final long serialVersionUID = 1L;

    /**
     * Constructor que recibe un mensaje de error.
     * Este mensaje se puede recuperar más tarde con getMessage().
     */
    public GeneradorException(String mensaje) {
        super(mensaje); // Llama al constructor de Exception y guarda el mensaje
    }
}
