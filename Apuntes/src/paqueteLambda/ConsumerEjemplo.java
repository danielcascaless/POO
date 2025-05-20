// ConsumerEjemplo.java
package paqueteLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Implementaci�n de un m�todo doIf similar al ejercicio 11
 */
public class ConsumerEjemplo {
    
    // M�todo para aplicar una acci�n a elementos que cumplen una condici�n
    public static <T> void doIf(List<T> lista, Predicate<T> condicion, Consumer<T> accion) {
        for (T elemento : lista) {
            if (condicion.test(elemento)) {
                accion.accept(elemento);
            }
        }
    }
    
    // Versi�n gen�rica para cualquier colecci�n
    public static <T> void doIf(Iterable<T> coleccion, Predicate<T> condicion, Consumer<T> accion) {
        for (T elemento : coleccion) {
            if (condicion.test(elemento)) {
                accion.accept(elemento);
            }
        }
    }
    
    public static void main(String[] args) {
        // Ejemplo con lista de n�meros
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }
        
        // Aplicar acci�n a n�meros pares
        System.out.println("N�meros pares:");
        doIf(numeros, 
             n -> n % 2 == 0,                  // condici�n: es par
             n -> System.out.println(n));      // acci�n: imprimir
        
        // Usando referencias a m�todos
        System.out.println("\nN�meros impares:");
        doIf(numeros, 
             n -> n % 2 != 0,                   // condici�n: es impar
             System.out::println);              // acci�n: imprimir con referencia a m�todo
        
        // Ejemplo m�s complejo
        List<String> palabras = List.of("Java", "Lambda", "Stream", "Functional", "Programming");
        
        System.out.println("\nPalabras que empiezan con P:");
        doIf(palabras,
             s -> s.startsWith("P"),            // condici�n
             s -> System.out.println("- " + s.toUpperCase()));  // acci�n
        
        System.out.println("\nPalabras con m�s de 5 letras:");
        doIf(palabras, 
             s -> s.length() > 5,               // condici�n
             s -> System.out.println(s + " (" + s.length() + " letras)"));  // acci�n
    }
}
