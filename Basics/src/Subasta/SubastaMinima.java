package Subasta;

public class SubastaMinima extends Subasta {
    private int cantidadMinimaPuja;
    
    public SubastaMinima(String nombreProducto, String propietario, int cantidadMinimaPuja) {
        super(nombreProducto, propietario);
        this.cantidadMinimaPuja = cantidadMinimaPuja; // Corregido
    }
    
    // Método para obtener la cantidad mínima
    public int getCantidadMinimaPuja() {
        return cantidadMinimaPuja;
    }
    
    // Método para modificar la cantidad mínima
    public void setCantidadMinimaPuja(int nuevaCantidadMinima) {
        this.cantidadMinimaPuja = nuevaCantidadMinima;
    }
    
    @Override
    public Boolean ejecutar() {
        // Sólo se puede ejecutar si la puja mayor es mayor o igual a la cantidad mínima
        if(this.getPujaMayor() < cantidadMinimaPuja) {
            return false; // No se puede ejecutar
        }
        
        return super.ejecutar(); // Ejecutar la lógica de la clase base
    }
    
    public Boolean cerrarDirectamente() {
        this.abierta = false;
        return true;
    }
}