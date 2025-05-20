// MapEjemplo.java
package paqueteColecciones;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Ejemplos de uso de HashMap, LinkedHashMap y TreeMap
 */
public class MapEjemplo {
    
    public static void main(String[] args) {
        // HashMap: sin orden garantizado, rápido
        Map<String, Integer> hashMap = new HashMap<>();
        
        // Añadir elementos (pares clave-valor)
        hashMap.put("uno", 1);
        hashMap.put("dos", 2);
        hashMap.put("tres", 3);
        
        // Sobreescribe el valor si la clave ya existe
        hashMap.put("uno", 11);
        
        // Acceder a valores
        int valor = hashMap.get("dos");  // 2
        
        // Valor por defecto si la clave no existe
        int valorDefault = hashMap.getOrDefault("cuatro", 0);  // 0
        
        // Comprobar existencia
        boolean contieneClaveUno = hashMap.containsKey("uno");
        boolean contieneValor3 = hashMap.containsValue(3);
        
        // Eliminar
        hashMap.remove("tres");
        
        // Iteración sobre un Map
        System.out.println("Recorrer claves y valores:");
        for (Map.Entry<String, Integer> entrada : hashMap.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
        
        // Recorrer solo claves
        System.out.println("Recorrer solo claves:");
        for (String clave : hashMap.keySet()) {
            System.out.println(clave);
        }
        
        // Recorrer solo valores
        System.out.println("Recorrer solo valores:");
        for (Integer val : hashMap.values()) {
            System.out.println(val);
        }
        
        // LinkedHashMap: mantiene orden de inserción
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("uno", 1);
        linkedHashMap.put("dos", 2);
        linkedHashMap.put("tres", 3);
        
        System.out.println("LinkedHashMap: " + linkedHashMap);  // Mantiene orden de inserción
        
        // TreeMap: mantiene las claves ordenadas
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("c", 3);
        treeMap.put("a", 1);
        treeMap.put("b", 2);
        
        System.out.println("TreeMap: " + treeMap);  // Claves ordenadas alfabéticamente
        
        // Operaciones específicas de TreeMap
        String primeraLlave = treeMap.firstKey();
        String ultimaLlave = treeMap.lastKey();
        Map.Entry<String, Integer> primerEntrada = treeMap.firstEntry();
        
        // Submapas
        Map<String, Integer> subMap = treeMap.subMap("a", "c");  // de a (inclusivo) a c (exclusivo)
    }
}