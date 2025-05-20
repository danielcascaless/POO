// ObjectMethodsEjemplo.java
package paqueteMetodos;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Ejemplo de sobreescritura de métodos de Object:
 * toString(), equals(), hashCode() y clone()
 */
public class ObjectMethodsEjemplo implements Cloneable {
    private String nombre;
    private int id;
    private ArrayList<String> elementos;
    
    public ObjectMethodsEjemplo(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.elementos = new ArrayList<>();
    }
    
    public void addElemento(String elemento) {
        elementos.add(elemento);
    }
    
    // Sobreescritura de toString()
    @Override
    public String toString() {
        return "ObjectMethodsEjemplo [nombre=" + nombre + ", id=" + id + 
               ", elementos=" + elementos + "]";
    }
    
    // Sobreescritura de equals()
    @Override
    public boolean equals(Object obj) {
        // Verificaciones básicas
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        // Conversión segura
        ObjectMethodsEjemplo other = (ObjectMethodsEjemplo) obj;
        
        // Comparación de campos
        return id == other.id && 
               Objects.equals(nombre, other.nombre) &&
               Objects.equals(elementos, other.elementos);
    }
    
    // Sobreescritura de hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(nombre, id, elementos);
    }
    
    // Sobreescritura de clone()
    @Override
    public ObjectMethodsEjemplo clone() {
        try {
            ObjectMethodsEjemplo copia = (ObjectMethodsEjemplo) super.clone();
            // Copia profunda de colecciones u objetos mutables
            copia.elementos = new ArrayList<>(this.elementos);
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("No debería ocurrir", e);
        }
    }
    
    public static void main(String[] args) {
        // Prueba de toString
        ObjectMethodsEjemplo obj1 = new ObjectMethodsEjemplo("Test", 1);
        obj1.addElemento("Uno");
        obj1.addElemento("Dos");
        
        System.out.println("toString(): " + obj1);
        
        // Prueba de equals y hashCode
        ObjectMethodsEjemplo obj2 = new ObjectMethodsEjemplo("Test", 1);
        obj2.addElemento("Uno");
        obj2.addElemento("Dos");
        
        ObjectMethodsEjemplo obj3 = new ObjectMethodsEjemplo("Otro", 2);
        
        System.out.println("obj1.equals(obj2): " + obj1.equals(obj2));
        System.out.println("obj1.equals(obj3): " + obj1.equals(obj3));
        System.out.println("obj1.hashCode(): " + obj1.hashCode());
        System.out.println("obj2.hashCode(): " + obj2.hashCode());
        System.out.println("obj3.hashCode(): " + obj3.hashCode());
        
        // Prueba de clone
        ObjectMethodsEjemplo copia = obj1.clone();
        System.out.println("Copia: " + copia);
        System.out.println("Original equals Copia: " + obj1.equals(copia));
        
        // Comprobar que es copia profunda
        copia.addElemento("Tres");
        System.out.println("Original después de modificar copia: " + obj1);
        System.out.println("Copia modificada: " + copia);
    }
}