// ClaseBasica.java
package paqueteClases;

/**
 * Ejemplo de una clase básica con atributos, constructores y métodos
 */
public class ClaseBasica {
    // Atributos (variables de instancia)
    private String nombre;
    private int edad;
    
    // Constantes
    public static final int EDAD_MINIMA = 0;
    
    // Atributo estático (compartido por todas las instancias)
    private static int contador = 0;
    
    // Constructor con parámetros
    public ClaseBasica(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        contador++;
    }
    
    // Constructor sin parámetros (por defecto)
    public ClaseBasica() {
        this("Sin nombre", 0);  // Llamada a otro constructor
    }
    
    // Constructor de copia
    public ClaseBasica(ClaseBasica otro) {
        this(otro.nombre, otro.edad);
    }
    
    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        if (edad >= EDAD_MINIMA) {
            this.edad = edad;
        }
    }
    
    // Método estático
    public static int getContador() {
        return contador;
    }
    
    // Método de instancia
    public void incrementarEdad() {
        this.edad++;
    }
    
    // Sobrecarga de métodos (mismo nombre, diferentes parámetros)
    public void incrementarEdad(int cantidad) {
        this.edad += cantidad;
    }
    
    // Sobreescritura del método toString
    @Override
    public String toString() {
        return "ClaseBasica [nombre=" + nombre + ", edad=" + edad + "]";
    }
    
    // Ejemplo de uso
    public static void main(String[] args) {
        ClaseBasica persona1 = new ClaseBasica("Juan", 25);
        ClaseBasica persona2 = new ClaseBasica();
        ClaseBasica persona3 = new ClaseBasica(persona1);  // copia de persona1
        
        System.out.println(persona1);
        System.out.println(persona2);
        
        persona1.incrementarEdad();
        persona2.incrementarEdad(5);
        
        System.out.println("Número total de instancias: " + ClaseBasica.getContador());
    }
}