// ClaseBasica.java
package paqueteClases;

/**
 * Ejemplo de una clase b�sica con atributos, constructores y m�todos
 */
public class ClaseBasica {
    // Atributos (variables de instancia)
    private String nombre;
    private int edad;
    
    // Constantes
    public static final int EDAD_MINIMA = 0;
    
    // Atributo est�tico (compartido por todas las instancias)
    private static int contador = 0;
    
    // Constructor con par�metros
    public ClaseBasica(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        contador++;
    }
    
    // Constructor sin par�metros (por defecto)
    public ClaseBasica() {
        this("Sin nombre", 0);  // Llamada a otro constructor
    }
    
    // Constructor de copia
    public ClaseBasica(ClaseBasica otro) {
        this(otro.nombre, otro.edad);
    }
    
    // M�todos getter y setter
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
    
    // M�todo est�tico
    public static int getContador() {
        return contador;
    }
    
    // M�todo de instancia
    public void incrementarEdad() {
        this.edad++;
    }
    
    // Sobrecarga de m�todos (mismo nombre, diferentes par�metros)
    public void incrementarEdad(int cantidad) {
        this.edad += cantidad;
    }
    
    // Sobreescritura del m�todo toString
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
        
        System.out.println("N�mero total de instancias: " + ClaseBasica.getContador());
    }
}