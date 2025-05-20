// Interfaz.java
package paqueteHerencia;

/**
 * Ejemplo de interfaz en Java
 */
public interface Interfaz {
    // Constantes (implícitamente public, static y final)
    int VALOR_CONSTANTE = 100;
    
    // Métodos abstractos (implícitamente public y abstract)
    void metodoAbstracto();
    
    String procesarTexto(String texto);
    
    // Método por defecto (Java 8+)
    default void metodoPorDefecto() {
        System.out.println("Implementación por defecto");
        metodoPrivado();  // Llamada a método privado (Java 9+)
    }
    
    // Método estático (Java 8+)
    static void metodoEstatico() {
        System.out.println("Método estático en interfaz");
    }
    
    // Método privado (Java 9+)
    private void metodoPrivado() {
        System.out.println("Método privado en interfaz");
    }
}

// Segunda interfaz para mostrar herencia múltiple
interface SegundaInterfaz {
    void otroMetodo();
    
    default void metodoPorDefecto() {
        System.out.println("Método por defecto en SegundaInterfaz");
    }
}

// Implementación de interfaces
class ClaseImplementadora implements Interfaz, SegundaInterfaz {
    @Override
    public void metodoAbstracto() {
        System.out.println("Implementación de metodoAbstracto");
    }
    
    @Override
    public String procesarTexto(String texto) {
        return texto.toUpperCase();
    }
    
    @Override
    public void otroMetodo() {
        System.out.println("Implementación de otroMetodo");
    }
    
    // Obligatorio implementar cuando hay conflicto de métodos por defecto
    @Override
    public void metodoPorDefecto() {
        // Podemos elegir una implementación o hacer algo completamente diferente
        Interfaz.super.metodoPorDefecto();
        // SegundaInterfaz.super.metodoPorDefecto();
    }
    
    public static void main(String[] args) {
        ClaseImplementadora obj = new ClaseImplementadora();
        obj.metodoAbstracto();
        System.out.println(obj.procesarTexto("Hola"));
        obj.metodoPorDefecto();
        
        // Uso de constante de interfaz
        System.out.println("Constante: " + Interfaz.VALOR_CONSTANTE);
        
        // Llamada a método estático de interfaz
        Interfaz.metodoEstatico();
    }
}