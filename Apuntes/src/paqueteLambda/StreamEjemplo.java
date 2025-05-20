// StreamEjemplo.java
package paqueteLambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Ejemplos de uso de Streams (Java 8+)
 */
public class StreamEjemplo {
    
    public static void main(String[] args) {
        // Crear Stream a partir de colección
        List<String> palabras = Arrays.asList("Java", "Stream", "API", "Programación", "Funcional");
        Stream<String> streamPalabras = palabras.stream();
        
        // Crear Stream de forma directa
        Stream<Integer> streamNumeros = Stream.of(1, 2, 3, 4, 5);
        Stream<String> streamVacio = Stream.empty();
        
        // Streams de tipos primitivos
        IntStream intStream = IntStream.range(1, 6); // 1, 2, 3, 4, 5
        IntStream intStreamCerrado = IntStream.rangeClosed(1, 5); // 1, 2, 3, 4, 5
        
        // Operaciones intermedias (devuelven otro Stream)
        
        // filter: filtrar elementos
        List<String> palabrasLargas = palabras.stream()
                .filter(p -> p.length() > 4)
                .collect(Collectors.toList());
        System.out.println("Palabras largas: " + palabrasLargas);
        
        // map: transformar elementos
        List<Integer> longitudes = palabras.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Longitudes: " + longitudes);
        
        // flatMap: aplanar streams anidados
        List<List<Integer>> listasNumeros = Arrays.asList(
                Arrays.asList(1, 2), 
                Arrays.asList(3, 4), 
                Arrays.asList(5, 6));
        
        List<Integer> numerosPlanados = listasNumeros.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Números planados: " + numerosPlanados);
        
        // distinct: eliminar duplicados
        List<Integer> conDuplicados = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5);
        List<Integer> sinDuplicados = conDuplicados.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Sin duplicados: " + sinDuplicados);
        
        // sorted: ordenar
        List<String> ordenadas = palabras.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Ordenadas: " + ordenadas);
        
        // sorted con comparador
        List<String> ordenadasPorLongitud = palabras.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        System.out.println("Ordenadas por longitud: " + ordenadasPorLongitud);
        
        // peek: para depuración
        List<String> depuradas = palabras.stream()
                .peek(p -> System.out.println("Procesando: " + p))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Palabras mayúsculas: " + depuradas);
        
        // Operaciones terminales (devuelven un resultado final)
        
        // forEach: recorrer elementos
        System.out.println("forEach:");
        palabras.stream().forEach(System.out::println);
        
        // count: contar elementos
        long count = palabras.stream()
                .filter(p -> p.contains("a"))
                .count();
        System.out.println("Palabras con 'a': " + count);
        
        // anyMatch, allMatch, noneMatch
        boolean algunaLarga = palabras.stream().anyMatch(p -> p.length() > 5);
        boolean todasCortas = palabras.stream().allMatch(p -> p.length() < 10);
        boolean ningunaVacia = palabras.stream().noneMatch(String::isEmpty);
        
        System.out.println("¿Alguna palabra larga? " + algunaLarga);
        System.out.println("¿Todas cortas? " + todasCortas);
        System.out.println("¿Ninguna vacía? " + ningunaVacia);
        
        // findFirst, findAny
        Optional<String> primera = palabras.stream()
                .filter(p -> p.startsWith("P"))
                .findFirst();
        System.out.println("Primera con P: " + primera.orElse("No encontrada"));
        
        // min, max
        Optional<String> masCortaPosible = palabras.stream()
                .min(Comparator.comparing(String::length));
        System.out.println("Palabra más corta: " + masCortaPosible.get());
        
        // reduce
        Optional<String> concatenacion = palabras.stream()
                .reduce((a, b) -> a + ", " + b);
        System.out.println("Concatenación: " + concatenacion.get());
        
        int suma = IntStream.rangeClosed(1, 5)
                .reduce(0, Integer::sum);
        System.out.println("Suma: " + suma);
        
        // collect con varios collectors
        
        // toList, toSet
        List<String> lista = palabras.stream().collect(Collectors.toList());
        
        // joining
        String cadena = palabras.stream().collect(Collectors.joining(", "));
        System.out.println("Unidas: " + cadena);
        
        // groupingBy
        Map<Integer, List<String>> porLongitud = palabras.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Agrupadas por longitud: " + porLongitud);
        
        // partitioningBy
        Map<Boolean, List<String>> particionadas = palabras.stream()
                .collect(Collectors.partitioningBy(p -> p.length() > 4));
        System.out.println("Particionadas: " + particionadas);
        
        // Operaciones estadísticas
        IntStream numerosStream = IntStream.rangeClosed(1, 100);
        
        // Para estadísticas en un stream de objetos,
        // se puede usar mapToInt, mapToDouble, etc.
        IntStream streamLongitudes = palabras.stream()
                .mapToInt(String::length);
        
        double promedio = numerosStream.average().orElse(0);
        System.out.println("Promedio: " + promedio);
        
        // Procesamiento paralelo
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sumaParalela = numeros.parallelStream()
                .reduce(0, Integer::sum);
        System.out.println("Suma paralela: " + sumaParalela);
    }
}