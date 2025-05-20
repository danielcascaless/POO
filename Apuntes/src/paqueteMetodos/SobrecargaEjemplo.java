// SobrecargaEjemplo.java
package paqueteMetodos;

/**
 * Ejemplo de sobrecarga de m�todos (mismo nombre, diferentes par�metros)
 */
public class SobrecargaEjemplo {
    
    // Diferentes versiones del mismo m�todo con distintos par�metros
    
    // Versi�n sin par�metros
    public void imprimir() {
        System.out.println("Sin par�metros");
    }
    
    // Versi�n con un par�metro String
    public void imprimir(String texto) {
        System.out.println("String: " + texto);
    }
    
    // Versi�n con un par�metro int
    public void imprimir(int numero) {
        System.out.println("Int: " + numero);
    }
    
    // Versi�n con dos par�metros
    public void imprimir(String texto, int numero) {
        System.out.println("String y int: " + texto + ", " + numero);
    }
    
    // Versi�n con par�metros en orden diferente
    public void imprimir(int numero, String texto) {
        System.out.println("Int y String: " + numero + ", " + texto);
    }
    
    // Versi�n con n�mero variable de argumentos
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
        
        // Llamadas a los diferentes m�todos sobrecargados
        ejemplo.imprimir();
        ejemplo.imprimir("Hola");
        ejemplo.imprimir(123);
        ejemplo.imprimir("Hola", 123);
        ejemplo.imprimir(123, "Hola");
        ejemplo.imprimir("N�meros", 1, 2, 3, 4, 5);
        
        // Prueba de constructores sobrecargados
        SobrecargaEjemplo e1 = new SobrecargaEjemplo();
        SobrecargaEjemplo e2 = new SobrecargaEjemplo("Ana");
        SobrecargaEjemplo e3 = new SobrecargaEjemplo("Juan", 30);
        
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
    }
}