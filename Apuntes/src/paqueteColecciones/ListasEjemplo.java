// ListasEjemplo.java
package paqueteColecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Ejemplos de uso de ArrayList, recorridos y operaciones comunes
 */
public class ListasEjemplo {
    
    public static void main(String[] args) {
        // Crear una ArrayList vac�a
        ArrayList<String> lista = new ArrayList<>();
        
        // Tambi�n se puede inicializar con capacidad inicial
        ArrayList<String> listaConCapacidad = new ArrayList<>(20);
        
        // A�adir elementos
        lista.add("uno");       // a�ade al final
        lista.add("dos");
        lista.add("tres");
        
        // Insertar en posici�n espec�fica
        lista.add(0, "cero");   // desplaza los otros elementos
        
        // Acceder a elementos
        String elemento = lista.get(0);  // "cero"
        
        // Modificar elementos
        lista.set(1, "UNO");     // reemplaza "uno" con "UNO"
        
        // Eliminar elementos
        lista.remove(0);         // elimina por �ndice
        lista.remove("dos");     // elimina por objeto (primera ocurrencia)
        
        // Tama�o y comprobaciones
        int tamanio = lista.size();
        boolean vacia = lista.isEmpty();
        boolean contiene = lista.contains("UNO");
        
        // Convertir ArrayList a array
        String[] array = lista.toArray(new String[0]);
        
        // Recorrido con for tradicional
        System.out.println("For tradicional:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        
        // Recorrido con for-each (preferido)
        System.out.println("For-each:");
        for (String s : lista) {
            System.out.println(s);
        }
        
        // Recorrido con iterador
        System.out.println("Iterador:");
        Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
            // Se puede usar it.remove() para eliminar el elemento actual
        }
        
        // Ordenaci�n
        Collections.sort(lista);  // orden natural
        
        // Ordenaci�n con comparador personalizado
        Collections.sort(lista, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);  // orden inverso
            }
        });
        
        // Ordenaci�n con expresi�n lambda (Java 8+)
        Collections.sort(lista, (s1, s2) -> s2.compareTo(s1));
        
        // M�todo sort de List (Java 8+)
        lista.sort(Comparator.naturalOrder());
        lista.sort(Comparator.reverseOrder());
        
        // Copiar listas
        ArrayList<String> copia = new ArrayList<>(lista);  // Constructor de copia
        ArrayList<String> otra = new ArrayList<>();
        otra.addAll(lista);  // A�adir todos los elementos
    }
}