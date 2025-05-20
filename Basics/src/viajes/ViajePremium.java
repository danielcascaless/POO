package viajes;

import java.time.LocalDate;


public class ViajePremium extends Viaje{

	public ViajePremium(String propietario, String coche,
            String ruta, LocalDate fechaSalida,int plazas) {
		super(propietario,coche,ruta,fechaSalida,plazas);
	}
	public ViajePremium(String propietario, String coche,
            String ruta, LocalDate fechaSalida) {
		this(propietario,coche,ruta,fechaSalida,1);
	}
	
	// Funciones
	boolean cancelarViaje(String usuario) {
		if(LocalDate.now().isAfter(fechaSalida.minusDays(1))) return false;
		for(Reserva reserva : this.reservas) {
			if(reserva.usuario().equals(usuario)) {
				reservas.remove(reserva);
				this.plazasDisponibles = this.plazasDisponibles+reserva.numeroPlazas();
				this.plazasReservadas = this.plazasReservadas - reserva.numeroPlazas();
				return true;
			}
		}
		return false;
	}
}
