// ClaseHija.java
package paqueteHerencia;

/**
 * Ejemplo de clase hija (subclase) que hereda de ClasePadre
 */
public class ClaseHijo extends ClasePadre {
    // Atributo adicional
    private double valor;
    
    // Constructor
    public ClaseHijo(String nombre, int id, String detalle, double valor) {
        // Llamada al constructor de la clase padre
        super(nombre, id, detalle);
        this.valor = valor;
    }
    
    // Sobreescritura de m�todo
    @Override
    public void mostrarInfo() {
        // Llamada al m�todo de la clase padre
        super.mostrarInfo();
        System.out.println("ClaseHija - Valor: " + valor);
    }
    
    // M�todo adicional
    public void metodoAdicional() {
        System.out.println("Este m�todo solo existe en ClaseHija");
        System.out.println(obtenerDetalle());  // Acceso a m�todo protegido del padre
    }
    
    // Getter y setter para el nuevo atributo
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "ClaseHija [" + super.toString() + ", valor=" + valor + "]";
    }
    
    // Ejemplo de uso
    public static void main(String[] args) {
        ClasePadre padre = new ClasePadre("Padre", 1, "Detalle padre");
        ClaseHijo hijo = new ClaseHijo("Hija", 2, "Detalle hija", 99.9);
        
        // Llamada a m�todos
        padre.mostrarInfo();
        hijo.mostrarInfo();
        
        // Polimorfismo
        ClasePadre referencia = hijo;  // Una referencia de tipo ClasePadre apunta a un objeto ClaseHija
        referencia.mostrarInfo();      // Llama al m�todo sobrescrito en ClaseHija
        
        // Conversi�n expl�cita (casting)
        if (referencia instanceof ClaseHijo) {
        	ClaseHijo convertida = (ClaseHijo) referencia;
            convertida.metodoAdicional();
        }
        
        // Operador instanceof con pattern matching (Java 16+)
        // if (referencia instanceof ClaseHija convertida) {
        //     convertida.metodoAdicional();
        // }
    }
}