// ClaseInmutable.java
package paqueteClases;

/**
 * Ejemplo de una clase inmutable
 * Las clases inmutables no pueden cambiar su estado después de la creación
 */
public final class ClaseInmutable {
    // Atributos finales (no pueden cambiar después de la inicialización)
    private final String texto;
    private final int valor;
    
    // Constructor que inicializa todos los atributos
    public ClaseInmutable(String texto, int valor) {
        this.texto = texto;
        this.valor = valor;
    }
    
    // Solo getters, no setters
    public String getTexto() {
        return texto;
    }
    
    public int getValor() {
        return valor;
    }
    
    // Métodos que parecen modificar pero realmente crean nuevas instancias
    public ClaseInmutable conNuevoTexto(String nuevoTexto) {
        return new ClaseInmutable(nuevoTexto, this.valor);
    }
    
    public ClaseInmutable conNuevoValor(int nuevoValor) {
        return new ClaseInmutable(this.texto, nuevoValor);
    }
    
    @Override
    public String toString() {
        return "ClaseInmutable [texto=" + texto + ", valor=" + valor + "]";
    }
    
    // Buena práctica: implementar equals y hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        ClaseInmutable otro = (ClaseInmutable) obj;
        
        if (valor != otro.valor) return false;
        return texto != null ? texto.equals(otro.texto) : otro.texto == null;
    }
    
    @Override
    public int hashCode() {
        int result = texto != null ? texto.hashCode() : 0;
        result = 31 * result + valor;
        return result;
    }
    
    // Ejemplo de uso
    public static void main(String[] args) {
        ClaseInmutable obj1 = new ClaseInmutable("Hola", 10);
        
        // No podemos modificar obj1, pero podemos crear un nuevo objeto
        ClaseInmutable obj2 = obj1.conNuevoTexto("Adiós");
        
        System.out.println(obj1);  // texto sigue siendo "Hola"
        System.out.println(obj2);  // nuevo objeto con texto "Adiós"
    }
}