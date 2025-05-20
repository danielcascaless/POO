// Interfaz.java
package paqueteHerencia;

/**
 * Ejemplo de interfaz en Java
 */
public interface Interfaz {
    // Constantes (impl�citamente public, static y final)
    int VALOR_CONSTANTE = 100;
    
    // M�todos abstractos (impl�citamente public y abstract)
    void metodoAbstracto();
    
    String procesarTexto(String texto);
    
    // M�todo por defecto (Java 8+)
    default void metodoPorDefecto() {
        System.out.println("Implementaci�n por defecto");
        metodoPrivado();  // Llamada a m�todo privado (Java 9+)
    }
    
    // M�todo est�tico (Java 8+)
    static void metodoEstatico() {
        System.out.println("M�todo est�tico en interfaz");
    }
    
    // M�todo privado (Java 9+)
    private void metodoPrivado() {
        System.out.println("M�todo privado en interfaz");
    }
}

// Segunda interfaz para mostrar herencia m�ltiple
interface SegundaInterfaz {
    void otroMetodo();
    
    default void metodoPorDefecto() {
        System.out.println("M�todo por defecto en SegundaInterfaz");
    }
}

// Implementaci�n de interfaces
class ClaseImplementadora implements Interfaz, SegundaInterfaz {
    @Override
    public void metodoAbstracto() {
        System.out.println("Implementaci�n de metodoAbstracto");
    }
    
    @Override
    public String procesarTexto(String texto) {
        return texto.toUpperCase();
    }
    
    @Override
    public void otroMetodo() {
        System.out.println("Implementaci�n de otroMetodo");
    }
    
    // Obligatorio implementar cuando hay conflicto de m�todos por defecto
    @Override
    public void metodoPorDefecto() {
        // Podemos elegir una implementaci�n o hacer algo completamente diferente
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
        
        // Llamada a m�todo est�tico de interfaz
        Interfaz.metodoEstatico();
    }
}