// SobrecargaEjemplo.java
package paqueteMetodos;

/**
 * Ejemplo de sobrecarga de métodos (mismo nombre, diferentes parámetros)
 */
public class SobrecargaEjemplo {
    
    // Diferentes versiones del mismo método con distintos parámetros
    
    // Versión sin parámetros
    public void imprimir() {
        System.out.println("Sin parámetros");
    }
    
    // Versión con un parámetro String
    public void imprimir(String texto) {
        System.out.println("String: " + texto);
    }
    
    // Versión con un parámetro int
    public void imprimir(int numero) {
        System.out.println("Int: " + numero);
    }
    
    // Versión con dos parámetros
    public void imprimir(String texto, int numero) {
        System.out.println("String y int: " + texto + ", " + numero);
    }
    
    // Versión con parámetros en orden diferente
    public void imprimir(int numero, String texto) {
        System.out.println("Int y String: " + numero + ", " + texto);
    }
    
    // Versión con número variable de argumentos
    public void imprimir(String texto, int... numeros) {
        System.out.print("String y varios int: " + texto + " - ");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
    // Sobrecarga de constructores
    
    private String nombre;
    private int edad;
    
    public SobrecargaEjemplo() {
        this("Sin nombre", 0);  // Llamada a otro constructor
    }
    
    public SobrecargaEjemplo(String nombre) {
        this(nombre, 0);  // Llamada a otro constructor
    }
    
    public SobrecargaEjemplo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        return "SobrecargaEjemplo [nombre=" + nombre + ", edad=" + edad + "]";
    }
    
    public static void main(String[] args) {
        SobrecargaEjemplo ejemplo = new SobrecargaEjemplo();
        
        // Llamadas a los diferentes métodos sobrecargados
        ejemplo.imprimir();
        ejemplo.imprimir("Hola");
        ejemplo.imprimir(123);
        ejemplo.imprimir("Hola", 123);
        ejemplo.imprimir(123, "Hola");
        ejemplo.imprimir("Números", 1, 2, 3, 4, 5);
        
        // Prueba de constructores sobrecargados
        SobrecargaEjemplo e1 = new SobrecargaEjemplo();
        SobrecargaEjemplo e2 = new SobrecargaEjemplo("Ana");
        SobrecargaEjemplo e3 = new SobrecargaEjemplo("Juan", 30);
        
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
    }
}