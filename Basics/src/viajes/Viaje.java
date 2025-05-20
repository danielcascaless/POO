package viajes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
public class Viaje {
	protected final String codigoViaje,propietario,coche,ruta;
	protected final LocalDate fechaSalida;
	protected final int plazasOfrecidas;
	protected ArrayList<Reserva> reservas;
	protected int plazasReservadas;
	protected int plazasDisponibles;
	
	public Viaje(String propietario, String coche,
            String ruta, LocalDate fechaSalida, int plazasOfrecidas) {
    this.codigoViaje = UUID.randomUUID().toString();
    this.propietario = propietario;
    this.coche = coche;
    this.ruta = ruta;
    this.fechaSalida = fechaSalida;
    this.plazasOfrecidas = plazasOfrecidas;
    this.reservas = new ArrayList<Reserva>();
    this.plazasReservadas = 0;
    this.plazasDisponibles = plazasOfrecidas;
    }
	public Viaje(String propietario, String coche,
            String ruta, LocalDate fechaSalida) {
		this(propietario,coche,ruta,fechaSalida,1);
    }
	// Funciones
	public ArrayList<Reserva> reservar(String usuario,int plazas){
		
		for(Reserva reserva : this.reservas) {
			if(reserva.usuario().equals(usuario)) return null;
		}
		this.plazasDisponibles = this.plazasOfrecidas - this.plazasReservadas;
		if(this.plazasDisponibles < plazas) return null;
		if(LocalDate.now().isAfter(fechaSalida)) return null;
		
		Reserva usuarioReserva = new Reserva(usuario,plazas,LocalDate.now(),UUID.randomUUID().toString());
		this.reservas.add(usuarioReserva);
		this.plazasReservadas += plazas;
		this.plazasDisponibles = this.plazasOfrecidas - this.plazasReservadas;
		return new ArrayList<Reserva>(this.reservas);
	}
	
	public ArrayList<Reserva> reservar(String usuario){
		return this.reservar(usuario, 1);
	}
	
	public Reserva consultarReserva(String codigoUsuario) {
		for(Reserva reserva : this.reservas) {
			if(codigoUsuario.equals(reserva.usuario())) return reserva;
		}
		return null;
	}

}
