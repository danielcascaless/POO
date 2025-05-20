// ClasePadre.java
package paqueteHerencia;

/**
 * Ejemplo de clase padre (superclase)
 */
public class ClasePadre {
    // Atributos protegidos (accesible en subclases)
    protected String nombre;
    protected int id;
    
    // Atributo privado (no accesible en subclases directamente)
    private String detalle;
    
    // Constructor
    public ClasePadre(String nombre, int id, String detalle) {
        this.nombre = nombre;
        this.id = id;
        this.detalle = detalle;
    }
    
    // Método final (no se puede sobrescribir)
    public final void metodoFinal() {
        System.out.println("Método final que no se puede sobrescribir");
    }
    
    // Método que puede ser sobrescrito
    public void mostrarInfo() {
        System.out.println("ClasePadre - Nombre: " + nombre + ", ID: " + id);
    }
    
    // Método protegido (accesible en subclases)
    protected String obtenerDetalle() {
        return "Detalle: " + detalle;
    }
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDetalle() {
        return detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    @Override
    public String toString() {
        return "ClasePadre [nombre=" + nombre + ", id=" + id + ", detalle=" + detalle + "]";
    }
}