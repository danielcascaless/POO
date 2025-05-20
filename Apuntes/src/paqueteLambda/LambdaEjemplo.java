// LambdaEjemplo.java
package paqueteLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Ejemplos de expresiones lambda y referencias a métodos
 */
public class LambdaEjemplo {
    
    public static void main(String[] args) {
        // Lambda básica (sin parámetros)
        Runnable runSinLambda = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hola sin lambda");
            }
        };
        
        Runnable runConLambda = () -> System.out.println("Hola con lambda");
        
        runSinLambda.run();
        runConLambda.run();
        
        // Lambda con un parámetro
        Consumer<String> printer = mensaje -> System.out.println(mensaje);
        printer.accept("Mensaje usando Consumer");
        
        // Lambda con múltiples parámetros
        BiFunction<Integer, Integer, Integer> sumador = (a, b) -> a + b;
        System.out.println("Suma: " + sumador.apply(5, 3));
        
        // Lambda con bloque de código
        BiFunction<Integer, Integer, Integer> multiplicador = (a, b) -> {
            System.out.println("Multiplicando " + a + " por " + b);
            return a * b;
        };
        System.out.println("Multiplicación: " + multiplicador.apply(4, 7));
        
        // Interfaces funcionales comunes
        
        // Predicate<T> - recibe T, devuelve boolean
        Predicate<String> esMayorQueCinco = s -> s.length() > 5;
        System.out.println("¿'Lambda' es mayor que 5? " + esMayorQueCinco.test("Lambda"));
        
        // Function<T, R> - recibe T, devuelve R
        Function<String, Integer> longitud = s -> s.length();
        System.out.println("Longitud de 'Lambda': " + longitud.apply("Lambda"));
        
        // Consumer<T> - recibe T, no devuelve nada
        Consumer<String> impresora = s -> System.out.println("Consumidor: " + s);
        impresora.accept("Hola desde Consumer");
        
        // Supplier<T> - no recibe nada, devuelve T
        Supplier<Double> numeroAleatorio = () -> Math.random();
        System.out.println("Número aleatorio: " + numeroAleatorio.get());
        
        // BiFunction<T, U, R> - recibe T y U, devuelve R
        BiFunction<String, String, String> concatenador = (s1, s2) -> s1 + s2;
        System.out.println("Concatenación: " + concatenador.apply("Hola, ", "mundo!"));
        
        // Ejemplos de uso práctico
        
        // Ordenación de lista
        List<String> nombres = new ArrayList<>(
                Arrays.asList("Carlos", "Ana", "Beatriz", "David", "Elena"));
        
        // Implementación tradicional
        Collections.sort(nombres, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        
        // Con lambda
        Collections.sort(nombres, (s1, s2) -> s1.compareTo(s2));
        
        // Con referencia a método
        Collections.sort(nombres, String::compareTo);
        
        System.out.println("Lista ordenada: " + nombres);
        
        // Filtrado
        List<String> nombresFiltrados = filtrar(nombres, s -> s.startsWith("A"));
        System.out.println("Nombres que empiezan con A: " + nombresFiltrados);
        
        // Referencias a métodos
        
        // Referencia a método estático
        Function<String, Integer> parseIntLambda = s -> Integer.parseInt(s);
        Function<String, Integer> parseIntRef = Integer::parseInt;
        
        System.out.println("ParseInt Lambda: " + parseIntLambda.apply("123"));
        System.out.println("ParseInt Ref: " + parseIntRef.apply("456"));
        
        // Referencia a método de instancia de un objeto específico
        String prefijo = "Hola, ";
        Function<String, String> concatLambda = s -> prefijo.concat(s);
        Function<String, String> concatRef = prefijo::concat;
        
        System.out.println("Concat Lambda: " + concatLambda.apply("mundo"));
        System.out.println("Concat Ref: " + concatRef.apply("Java"));
        
        // Referencia a método de instancia de un tipo
        Function<String, String> upperLambda = s -> s.toUpperCase();
        Function<String, String> upperRef = String::toUpperCase;
        
        System.out.println("Upper Lambda: " + upperLambda.apply("lambda"));
        System.out.println("Upper Ref: " + upperRef.apply("referencia"));
        
        // Referencia a constructor
        Supplier<List<String>> listCreatorLambda = () -> new ArrayList<>();
        Supplier<List<String>> listCreatorRef = ArrayList::new;
        
        List<String> lista1 = listCreatorLambda.get();
        List<String> lista2 = listCreatorRef.get();
    }
    
    // Método que utiliza Predicate para filtrar
    public static <T> List<T> filtrar(List<T> lista, Predicate<T> predicado) {
        List<T> resultado = new ArrayList<>();
        for (T elemento : lista) {
            if (predicado.test(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }
}