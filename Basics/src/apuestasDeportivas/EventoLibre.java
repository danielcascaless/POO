package apuestasDeportivas;

public class EventoLibre extends Evento{
	public EventoLibre(String nombre, double precio) {
        super(nombre, precio);
    }
	
	@Override
	protected boolean esAceptable(Marcador marcador) {
		return !getApuestas().containsValue(marcador);
	}
	
}
