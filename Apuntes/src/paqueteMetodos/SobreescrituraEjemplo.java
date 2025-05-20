// SobreescrituraEjemplo.java
package paqueteMetodos;

/**
 * Ejemplo de sobreescritura de métodos (mismo método en clases con herencia)
 */
public class SobreescrituraEjemplo {
    
    // Clase base
    public static class Animal {
        protected String nombre;
        
        public Animal(String nombre) {
            this.nombre = nombre;
        }
        
        public void hacerSonido() {
            System.out.println("Animal hace un sonido");
        }
        
        public void comer() {
            System.out.println("Animal comiendo");
        }
        
        @Override
        public String toString() {
            return "Animal: " + nombre;
        }
    }
    
    // Subclase que sobreescribe métodos
    public static class Perro extends Animal {
        private String raza;
        
        public Perro(String nombre, String raza) {
            super(nombre);
            this.raza = raza;
        }
        
        // Sobreescritura de método
        @Override
        public void hacerSonido() {
            System.out.println("Perro " + nombre + " ladra: Guau guau!");
        }
        
        // Sobreescritura con llamada al método padre
        @Override
        public void comer() {
            super.comer();  // Llamada al método de la clase padre
            System.out.println("Perro comiendo croquetas");
        }
        
        // Método adicional
        public void jugar() {
            System.out.println("Perro " + nombre + " está jugando");
        }
        
        @Override
        public String toString() {
            return "Perro: " + nombre + ", Raza: " + raza;
        }
    }
    
    // Otra subclase
    public static class Gato extends Animal {
        public Gato(String nombre) {
            super(nombre);
        }
        
        @Override
        public void hacerSonido() {
            System.out.println("Gato " + nombre + " maulla: Miau!");
        }
        
        @Override
        public String toString() {
            return "Gato: " + nombre;
        }
    }
    
    public static void main(String[] args) {
        // Objetos de cada clase
        Animal animal = new Animal("Genérico");
        Perro perro = new Perro("Bobby", "Labrador");
        Gato gato = new Gato("Michi");
        
        // Llamada a métodos propios
        animal.hacerSonido();
        perro.hacerSonido();
        gato.hacerSonido();
        
        // Polimorfismo
        System.out.println("\nPolimorfismo:");
        Animal[] animales = {animal, perro, gato};
        
        for (Animal a : animales) {
            System.out.println(a);       // Llama al toString() sobreescrito
            a.hacerSonido();             // Llama al método sobreescrito
            
            // Comprobación de tipo
            if (a instanceof Perro) {
                Perro p = (Perro) a;
                p.jugar();               // Método específico de Perro
            }
        }
        
        System.out.println("\nLlamada a super:");
        perro.comer();  // Muestra la implementación combinada
    }
}
