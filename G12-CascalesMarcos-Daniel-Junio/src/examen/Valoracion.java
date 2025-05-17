package examen;

public class Valoracion {

	private final String catador;
	
	private final Vino vino;
	
	private final int calificacionOlfativa;
	
	private final int calificacionVisual;
	
	private final int calificacionGustativa;
	
	private final double nota;
	
	
	public Valoracion(String catador, Vino vino, int calificacionOlfativa, int calificacionVisual, int calificacionGustativa) {
		this.catador = catador;
		this.vino = vino;
		this.calificacionOlfativa = calificacionOlfativa;
		this.calificacionVisual = calificacionVisual;
		this.calificacionGustativa = calificacionGustativa;
		this.nota = (calificacionOlfativa + calificacionVisual + calificacionGustativa) / 3.0;
	}
	
	public String getCatador() {
		return catador;
	}
	
	public Vino getVino() {
		return vino;
	}
	
	public int getCalificacionOlfativa() {
		return calificacionOlfativa;
	}
	
	public int getCalificacionVisual() {
		return calificacionVisual;
	}
	
	public int getCalificacionGustativa() {
		return calificacionGustativa;
	}
	
	public double getNota() {
		return nota;
	}
	
	
	@Override
    public String toString() {
        return "Valoracion[catador=" + catador + ", vino=" + vino.getNombre()
                + ", nota=" + nota + ", olfativa=" + calificacionOlfativa
                + ", visual=" + calificacionVisual + ", gustativa=" + calificacionGustativa + "]";
    }
	
	
}
