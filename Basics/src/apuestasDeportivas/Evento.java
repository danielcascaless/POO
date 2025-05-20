package apuestasDeportivas;
import java.util.HashMap;
import java.util.Map;

public abstract class Evento {
	private String nombre;
	private double precio;
    Map<String, Marcador> apuestas;
    
    public Evento(String nombre, double precio) {
    	this.nombre = nombre;
    	this.precio = precio;
    	apuestas = new HashMap<>();
    }
    public boolean apostar(String nombre, Marcador marcador) {
    	if(esAceptable(marcador)) {
    		apuestas.put(nombre,marcador);
    		return true;
    	}
    	return false;
    }   
    
    
    public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public Map<String, Marcador> getApuestas() {
		return new HashMap<>(apuestas);
	}
	public int getnApuestas() {
		return apuestas.size();
	}
	public double getDineroRecaudado() {
		return apuestas.size() * precio;
	}
	protected abstract boolean esAceptable(Marcador marcador);

    
}
