package viajes;

import java.time.LocalDate;


public record Reserva (String usuario,
					   int numeroPlazas,
					   LocalDate fecha,
					   String codigoViaje){


}
