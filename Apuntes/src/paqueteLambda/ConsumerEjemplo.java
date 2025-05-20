// ConsumerEjemplo.java
package paqueteLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Implementación de un método doIf similar al ejercicio 11
 */
public class ConsumerEjemplo {
    
    // Método para aplicar una acción a elementos que cumplen una condición
    public static <T> void doIf(List<T> lista, Predicate<T> condicion, Consumer<T> accion) {
        for (T elemento : lista) {
            if (condicion.test(elemento)) {
                accion.accept(elemento);
            }
        }
    }
    
    // Versión genérica para cualquier colección
    public static <T> void doIf(Iterable<T> coleccion, Predicate<T> condicion, Consumer<T> accion) {
        for (T elemento : coleccion) {
            if (condicion.test(elemento)) {
                accion.accept(elemento);
            }
        }
    }
    
    public static void main(String[] args) {
        // Ejemplo con lista de números
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }
        
        // Aplicar acción a números pares
        System.out.println("Números pares:");
        doIf(numeros, 
             n -> n % 2 == 0,                  // condición: es par
             n -> System.out.println(n));      // acción: imprimir
        
        // Usando referencias a métodos
        System.out.println("\nNúmeros impares:");
        doIf(numeros, 
             n -> n % 2 != 0,                   // condición: es impar
             System.out::println);              // acción: imprimir con referencia a método
        
        // Ejemplo más complejo
        List<String> palabras = List.of("Java", "Lambda", "Stream", "Functional", "Programming");
        
        System.out.println("\nPalabras que empiezan con P:");
        doIf(palabras,
             s -> s.startsWith("P"),            // condición
             s -> System.out.println("- " + s.toUpperCase()));  // acción
        
        System.out.println("\nPalabras con más de 5 letras:");
        doIf(palabras, 
             s -> s.length() > 5,               // condición
             s -> System.out.println(s + " (" + s.length() + " letras)"));  // acción
    }
}
