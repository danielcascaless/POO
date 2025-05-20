// RecordEjemplo.java
package paqueteClases;

/**
 * Ejemplo de uso de Records (Java 16+)
 * Los records son clases inmutables simplificadas para almacenar datos
 */
public class RecordEjemplo {
    
    // Definici�n de un record
    public record Punto(int x, int y) {
        // Constructor compacto - validaci�n adicional
        public Punto {
            if (x < 0 || y < 0) {
                throw new IllegalArgumentException("Coordenadas negativas no permitidas");
            }
        }
        
        // M�todos adicionales
        public double distanciaAlOrigen() {
            return Math.sqrt(x * x + y * y);
        }
        
        // M�todo est�tico
        public static Punto origen() {
            return new Punto(0, 0);
        }
    }
    
    // Otro ejemplo de record
    public record Persona(String nombre, int edad) {
        // Constructor con validaci�n
        public Persona {
            if (edad < 0) {
                throw new IllegalArgumentException("Edad no puede ser negativa");
            }
            // nombre se asigna autom�ticamente
        }
        
        // M�todo adicional
        public boolean esMayorDeEdad() {
            return edad >= 18;
        }
    }
    
    public static void main(String[] args) {
        // Crear instancias
        Punto p1 = new Punto(3, 4);
        Punto p2 = new Punto(5, 12);
        
        // Acceder a los componentes (getters generados autom�ticamente)
        System.out.println("p1.x = " + p1.x() + ", p1.y = " + p1.y());
        
        // Usar m�todos adicionales
        System.out.println("Distancia al origen: " + p1.distanciaAlOrigen());
        
        // toString, equals y hashCode generados autom�ticamente
        System.out.println(p1);  // Punto[x=3, y=4]
        System.out.println("p1 equals p2: " + p1.equals(p2));
        
        // Usar m�todo est�tico
        Punto origen = Punto.origen();
        System.out.println("Origen: " + origen);
        
        // Ejemplo con Persona
        Persona persona = new Persona("Ana", 25);
        System.out.println(persona);  // Persona[nombre=Ana, edad=25]
        System.out.println("Es mayor de edad: " + persona.esMayorDeEdad());
    }
}