package Subasta;
import java.util.ArrayList;
public class Subasta {
	protected String nombreProducto;
	protected String propietario;
	protected Boolean abierta;
	protected ArrayList<Puja> lista;
	// Constructores
	public Subasta(String nombreProducto, String propietario) {
		this.nombreProducto = nombreProducto;
		this.propietario = propietario;
		this.lista = new ArrayList<Puja>();
		this.abierta = true;
	}
	// Funciones
	public Boolean pujar(String pujador, double cantidad) {
		if(pujador.isBlank() || pujador.isEmpty()) return false;
		if(cantidad <= 0) return false;
		if(!this.abierta) return false;
		if(this.propietario.equals(pujador)) return false;
		if(this.getPujaMayor() > cantidad) return false;
		Puja puja = new Puja(pujador,cantidad);
		lista.add(puja);
		return true;
	}
	
	public Boolean pujar(String pujador) {
		return this.pujar(pujador,this.getPujaMayor()+1);
	}
	public Boolean ejecutar() {
		if(!this.abierta) return false;
		if(lista.isEmpty()) return false;
		this.abierta = false;
		return true;
	}
	// Getters
	public String getNombre() {
		return nombreProducto;
	}
	public String getPropietario() {
		return propietario;
	}
	public Boolean getAbierta() {
		return abierta;
	}
	public ArrayList<Puja> getLista() {
		return new ArrayList<Puja> (lista);
	}
	public double getPujaMayor() {
		double pujaMayor = -999;
		for(int i = 0; i < lista.size();i++) {
			if(lista.get(i).cantidad() > pujaMayor) pujaMayor = lista.get(i).cantidad();
		}
		return pujaMayor;
	}
}
