package Geometria;

public class Circulo {
	double pi = Math.PI;
	Punto ORIGEN_COORDENADAS = new Punto();
	double RADIO_DEFECTO = 5;
	Punto origen;
	double radio;
	public Circulo() {
		this.origen = ORIGEN_COORDENADAS;
		this.radio = RADIO_DEFECTO;
	}
	public Circulo(Punto origen, double radio) {
		this.origen = origen;
		this.radio = radio;
	}
	public Circulo(Circulo circulo) {
		this.origen = circulo.origen;
		this.radio = circulo.radio;
	}
	
	//Metodos
	public void desplazar(int x, int y) {
		this.origen.Desplazar(x,y);
	}
	public void escalar(double porcentaje) {
		porcentaje /= 100;
		this.radio *= porcentaje;
	}
	public double getPi() {
		return pi;
	}
	@Override
	public String toString() {
		return "Circulo [origen=" + origen + ", radio=" + radio + "]";
	}
	public Punto getOrigen() {
		return origen;
	}
	public void setOrigen(Punto origen) {
		this.origen = origen;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public Punto getORIGEN_COORDENADAS() {
		return ORIGEN_COORDENADAS;
	}
	public double getRADIO_DEFECTO() {
		return RADIO_DEFECTO;
	}
	
}
