package viajes;

import java.time.LocalDate;
import java.util.ArrayList;
public class ViajeSelectivo extends Viaje{
	private ArrayList<String> vetados;

	public ViajeSelectivo(String propietario, String coche,
            String ruta, LocalDate fechaSalida,int plazas) {
		super(propietario,coche,ruta,fechaSalida,plazas);
		this.vetados = new ArrayList<String>();
	}
	public ViajeSelectivo(String propietario, String coche,
            String ruta, LocalDate fechaSalida) {
		this(propietario,coche,ruta,fechaSalida,1);
	}
	
	// Funciones
	public boolean addVeto(String usuario) {
		for(String usuarioVetado : vetados) {
			if(usuarioVetado.equals(usuario)) return false;
		}
		vetados.add(usuario);
		return true;
	}
	public boolean removeVeto(String usuario) {
		for(String usuarioVetado : vetados) {
			if(usuarioVetado.equals(usuario)) {
				vetados.remove(usuarioVetado);
				return true;
			}
		}
		return false;
	}
	public ArrayList<Reserva> reservar(String usuario,int plazas){
		for(String usuarioVetado : vetados) {
			if(usuarioVetado.equals(usuario)) return null;
		}
		return super.reservar(usuario, plazas);
	}
	public ArrayList<Reserva> reservar(String usuario){
		for(String usuarioVetado : vetados) {
			if(usuarioVetado.equals(usuario)) return null;
		}
		return super.reservar(usuario, 1);
	}
	
	
}
