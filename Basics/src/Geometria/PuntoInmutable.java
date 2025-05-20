package Geometria;
public record PuntoInmutable(int x, int y) {
    // Constructor sin parámetros (equivalente al constructor por defecto)
    public PuntoInmutable() {
        this(0, 0);
    }
    
    // Constructor de copia
    public PuntoInmutable(PuntoInmutable punto) {
        this(punto.x(), punto.y());
    }
    
    // Método para crear un nuevo punto incrementado
    public PuntoInmutable incrementar(int dx, int dy) {
        return new PuntoInmutable(this.x + dx, this.y + dy);
    }
}

	/*public class PuntoInmutable {
	    private final int x;
	    private final int y;
	    
	    public PuntoInmutable() {
	        this.x = 0;
	        this.y = 0;
	    }
	    
	    public PuntoInmutable(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	    
	    public PuntoInmutable(PuntoInmutable punto) {
	        this.x = punto.x;
	        this.y = punto.y;
	    }
	    
	    public int getX() {
	        return x;
	    }
	    
	    public int getY() {
	        return y;
	    }
	    
	    // En lugar de modificar las coordenadas, devuelve un nuevo objeto
	    public PuntoInmutable incrementar(int dx, int dy) {
	        return new PuntoInmutable(this.x + dx, this.y + dy);
	    }
	    
	    @Override
	    public String toString() {
	        return "PuntoInmutable [x=" + x + ", y=" + y + "]";
	    }*/
	

