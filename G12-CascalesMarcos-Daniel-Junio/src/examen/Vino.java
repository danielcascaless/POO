package examen;

import java.time.LocalDate;
import java.util.Objects;
import java.util.List;

public class Vino implements Comparable<Vino> {

	private final LocalDate fechaProduccion;
	
	private final String nombre;
	
	private final String color;
	
	private final String maduracion;
	
	private final double coste;
	
	
	
	public Vino(LocalDate fechaProduccion, String nombre, String color, String maduracion, double coste) {
		if (fechaProduccion == null) {
	        throw new IllegalArgumentException("La fecha de producción no puede ser nula.");
	    }
	    if (nombre == null || nombre.trim().isEmpty()) {
	        throw new IllegalArgumentException("El nombre del vino no puede estar vacío.");
	    }
	    if (color == null || !(color.equalsIgnoreCase("tinto") || color.equalsIgnoreCase("blanco") || color.equalsIgnoreCase("rosado"))) {
	        throw new IllegalArgumentException("Color inválido. Debe ser 'tinto', 'blanco' o 'rosado'.");
	    }
	    if (maduracion == null || !(maduracion.equalsIgnoreCase("joven") || maduracion.equalsIgnoreCase("crianza") || maduracion.equalsIgnoreCase("reserva") || maduracion.equalsIgnoreCase("gran reserva"))) {
	        throw new IllegalArgumentException("Maduración inválida.");
	    }
	    if (coste < 0) {
	        throw new IllegalArgumentException("El coste no puede ser negativo.");
	    }
		this.fechaProduccion = fechaProduccion;
		this.nombre = nombre;
		this.color = color;
		this.maduracion = maduracion;
		this.coste = coste;
		
	}
	
	
	public Vino(LocalDate fechaProduccion, String nombre) {
		if (fechaProduccion == null) {
	        throw new IllegalArgumentException("La fecha de producción no puede ser nula.");
	    }
	    if (nombre == null || nombre.trim().isEmpty()) {
	        throw new IllegalArgumentException("El nombre del vino no puede estar vacío.");
	    }
		this.fechaProduccion = fechaProduccion;
		this.nombre = nombre;
		this.color = "blanco";
		this.maduracion = "joven";
		this.coste = 2.0;
	}
	
	public LocalDate getFechaProduccion() {
		return fechaProduccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getMaduracion() {
		return maduracion;
	}
	
	public double getCoste() {
		return coste;
	}
	
	
	
	@Override 
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Vino other = (Vino) obj;
		
		return fechaProduccion.equals(other.fechaProduccion)
			&& nombre.equals(other.nombre)
			&& color.equals(other.color)
			&& maduracion.equals(other.maduracion);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fechaProduccion, nombre, color, maduracion);
	}
	
	@Override
	public int compareTo(Vino otro) {
	    // Definir el orden de maduración manualmente
	    List<String> ordenMaduracion = List.of("joven", "crianza", "reserva", "gran reserva");

	    int thisIndex = ordenMaduracion.indexOf(this.maduracion);
	    int otherIndex = ordenMaduracion.indexOf(otro.maduracion);

	    // Primero comparar por tipo de maduración
	    if (thisIndex != otherIndex) {
	        return Integer.compare(thisIndex, otherIndex);
	    }

	    // Si la maduración es igual, comparar por fecha de producción
	    return this.fechaProduccion.compareTo(otro.fechaProduccion);
	}

	
	
	@Override
    public String toString() {
        return "Vino[nombre=" + nombre + ", color=" + color + ", maduración=" + maduracion +
               ", coste=" + coste + "€/L, producido el " + fechaProduccion + "]";
    }
	
	
}
