package examen;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Cata {

	private final String nombre;

	private final List<Vino> vinos;

	protected final List<Valoracion> valoraciones;

	public Cata(String nombre) {
		this.nombre = nombre;
		this.vinos = new ArrayList<>();
		this.valoraciones = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public List<Vino> getVinos() {
		return new ArrayList<>(vinos);
	}

	public List<Valoracion> getValoracion() {
		return new ArrayList<>(valoraciones);
	}

	public boolean registrarVino(Vino vino) {
		if (!vinos.contains(vino)) {
			vinos.add(vino);
			return true;
		}
		return false;
	}

	protected boolean esCatadorApto(String catador) {
		return true;
	}

	/**
	 * Devuelve un conjunto con los nombres de los catadores que han hecho alguna
	 * valoración. No se repiten, por lo que se usa un Set.
	 */
	public Set<String> getCatadores() {
		Set<String> catadores = new HashSet<>();
		for (Valoracion v : valoraciones) {
			catadores.add(v.getCatador());
		}
		return catadores;
	}

	public List<Vino> getVinosValoradosPor(String catador) {
		List<Vino> resultado = new ArrayList<>();

		for (Valoracion v : valoraciones) {
			if (v.getCatador().equals(catador)) {
				resultado.add(v.getVino());
			}
		}

		return resultado;
	}

	public boolean haSidoValoradoPor(String catador, Vino vino) {
		if(!vinos.contains(vino)) {
			return false;
		}
		
		for (Valoracion v : valoraciones) {
			if (v.getCatador().equals(catador) && v.getVino().equals(vino)) {
				return true;
			}
		}
		
		return false;
	}

	public boolean valorarVino(String catador, Vino vino, int calificacionOlfativa, int calificacionVisual, int calificacionGustativa) {
		if (!vinos.contains(vino)) return false;
		
		if (!haSidoValoradoPor(catador, vino)) return false;
		
		if(!esCatadorApto(catador)) return false;
		
		Valoracion valoracion = new Valoracion(catador, vino, calificacionOlfativa, calificacionVisual, calificacionGustativa);
		valoraciones.add(valoracion);
		return true;
	}
	
	public Map<Vino, List<Valoracion>> getValoracionesPorVinos(){
		Map<Vino, List<Valoracion>> mapa = new HashMap<>();
		
		for (Vino v : vinos) {
			mapa.put(v,  new ArrayList<>());
		}
		
		for (Valoracion val : valoraciones) {
			Vino v = val.getVino();
			
			if(mapa.containsKey(v)) {
				mapa.get(v).add(val);
			}
		}
		return mapa;
	}
	
	
	public List<Valoracion> getValoracionesPorVino(Vino vino){
		if (!vinos.contains(vino)) {
			return null;
		}
		
		List<Valoracion> resultado = new ArrayList<>();
		
		for (Valoracion v : valoraciones) {
			if (v.getVino().equals(vino)) {
				resultado.add(v);
			}
		}
		return resultado;
	}
	
	
	
	
	public double getPuntuacionMedia(Vino vino) {
		if(!vinos.contains(vino)) {
			return -1;
		}
		
		double suma = 0;
		int contador = 0;
		
		for (Valoracion v : valoraciones) {
			if (v.getVino().equals(vino)) {
				suma += v.getNota();
				contador++;
			}
		}
		
		if (contador == 0) {
			return 0;
		}
		
		return suma / contador;
	}
	
	
	
	
	public List<Vino> getMejoresVinos(){
		List<Vino> mejores = new ArrayList<>();
		double mejorPuntuacion = -1;
		
		for (Vino vino : vinos) {
			double puntuacion = getPuntuacionMedia(vino);
			
			if (puntuacion < 0) {
				if (puntuacion > mejorPuntuacion) {
					mejores.clear();
					mejores.add(vino);
					mejorPuntuacion = puntuacion;
				}else if (puntuacion == mejorPuntuacion) {
					mejores.add(vino);
				}
			}
		}
		
		return mejores;
	}
	
	
	
	@Override
	public String toString() {
	    return "Cata[nombre=" + getNombre() + ", vinos=" + vinos.size() + ", valoraciones=" + valoraciones.size() + "]";
	}

	
	@Override
	public Cata clone() {
	    Cata copia = new Cata(this.getNombre());

	    // Copiar todos los vinos (por referencia, son inmutables)
	    for (Vino v : this.getVinos()) {
	        copia.registrarVino(v);
	    }

	    return copia;
	}

	
	
	
	
	
	
}
