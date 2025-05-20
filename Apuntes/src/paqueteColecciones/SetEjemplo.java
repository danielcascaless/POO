// SetEjemplo.java
package paqueteColecciones;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Ejemplos de uso de HashSet, LinkedHashSet y TreeSet
 */
public class SetEjemplo {
    
    public static void main(String[] args) {
        // HashSet: conjunto sin orden garantizado, rápido
        Set<String> hashSet = new HashSet<>();
        
        // Añadir elementos
        hashSet.add("uno");
        hashSet.add("dos");
        hashSet.add("tres");
        hashSet.add("uno");  // Duplicado, no se añade
        
        System.out.println("HashSet: " + hashSet);  // Orden no garantizado
        
        // Operaciones comunes
        boolean contiene = hashSet.contains("dos");
        hashSet.remove("tres");
        int tamanio = hashSet.size();
        
        // LinkedHashSet: mantiene orden de inserción
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("uno");
        linkedHashSet.add("dos");
        linkedHashSet.add("tres");
        
        System.out.println("LinkedHashSet: " + linkedHashSet);  // Orden de inserción
        
        // TreeSet: mantiene los elementos ordenados
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("c");
        treeSet.add("a");
        treeSet.add("b");
        
        System.out.println("TreeSet: " + treeSet);  // Ordenado alfabéticamente
        
        // Operaciones específicas de TreeSet
        String primero = treeSet.first();  // Primer elemento
        String ultimo = treeSet.last();    // Último elemento
        Set<String> subSet = treeSet.subSet("a", "c");  // Subconjunto entre a (inclusivo) y c (exclusivo)
        
        // Operaciones entre conjuntos
        Set<String> conjunto1 = new HashSet<>();
        conjunto1.add("a");
        conjunto1.add("b");
        conjunto1.add("c");
        
        Set<String> conjunto2 = new HashSet<>();
        conjunto2.add("b");
        conjunto2.add("c");
        conjunto2.add("d");
        
        // Copia temporal para no modificar conjunto1
        Set<String> union = new HashSet<>(conjunto1);
        union.addAll(conjunto2);
        System.out.println("Unión: " + union);
        
        Set<String> interseccion = new HashSet<>(conjunto1);
        interseccion.retainAll(conjunto2);
        System.out.println("Intersección: " + interseccion);
        
        Set<String> diferencia = new HashSet<>(conjunto1);
        diferencia.removeAll(conjunto2);
        System.out.println("Diferencia (conjunto1 - conjunto2): " + diferencia);
    }
}
