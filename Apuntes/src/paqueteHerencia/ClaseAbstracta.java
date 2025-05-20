// ClaseAbstracta.java
package paqueteHerencia;

/**
 * Ejemplo de clase abstracta en Java
 */
public abstract class ClaseAbstracta {
    // Atributos (pueden ser privados, protegidos o p�blicos)
    private String nombre;
    protected int codigo;
    
    // Constructor
    public ClaseAbstracta(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    
    // M�todo abstracto (sin implementaci�n)
    public abstract void metodoAbstracto();
    
    // M�todo concreto (con implementaci�n)
    public void metodoConcreto() {
        System.out.println("Implementaci�n en clase abstracta, nombre: " + nombre);
    }
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}

// Clase concreta que hereda de la clase abstracta
class ClaseConcreta extends ClaseAbstracta {
    private double valor;
    
    public ClaseConcreta(String nombre, int codigo, double valor) {
        super(nombre, codigo);
        this.valor = valor;
    }
    
    // Implementaci�n obligatoria del m�todo abstracto
    @Override
    public void metodoAbstracto() {
        System.out.println("Implementaci�n del m�todo abstracto en ClaseConcreta");
        System.out.println("C�digo: " + codigo + ", Valor: " + valor);
    }
    
    // M�todo adicional
    public void metodoPropio() {
        System.out.println("Este m�todo es propio de ClaseConcreta");
    }
    
    public static void main(String[] args) {
        // No se puede instanciar una clase abstracta
        // ClaseAbstracta abstracta = new ClaseAbstracta("Test", 1); // Error
        
        ClaseConcreta concreta = new ClaseConcreta("Ejemplo", 123, 45.67);
        concreta.metodoAbstracto();
        concreta.metodoConcreto();
        
        // Polimorfismo
        ClaseAbstracta referencia = concreta;
        referencia.metodoAbstracto();  // Llama a la implementaci�n en ClaseConcreta
    }
}