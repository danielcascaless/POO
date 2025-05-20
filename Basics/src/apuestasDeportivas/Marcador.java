package apuestasDeportivas;

import java.util.Objects;

public record Marcador(int tanteoLocal,int tanteoVisitante) {
	public Marcador {
		if(tanteoLocal < 0 || tanteoVisitante < 0) {
			throw new IllegalArgumentException("No puedes poner marcador negativo");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(tanteoLocal, tanteoVisitante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marcador other = (Marcador) obj;
		return tanteoLocal == other.tanteoLocal && tanteoVisitante == other.tanteoVisitante;
	}
	
}
