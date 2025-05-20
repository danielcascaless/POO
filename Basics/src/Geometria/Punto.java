package Geometria;
import java.math.*;
public class Punto {
	int x;
	int y;
	public Punto(){
		this.x = 0;
		this.y = 0;
	}
	public Punto(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public Punto(Punto punto) {
		this.x = punto.x;
		this.y = punto.y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void Desplazar(int x,int y) {
		this.x += x;
		this.y += y;
	}
	public void Desplazar(Direccion direccion) {
		switch(direccion) {
		case ARRIBA: this.Desplazar(0,1); break;
		case ABAJO: this.Desplazar(0,-1); break;
		case IZQUIERDA: this.Desplazar(-1,0); break;
		case DERECHA: this.Desplazar(1,0); break;
		default: break;
		}
	}
	public double calcDistancia(Punto punto1, Punto punto2) {
		return Math.sqrt(
				Math.pow((punto1.x - punto2.x),2)-
				Math.pow((punto1.y-punto2.y),2));
	}
	public Punto mayorDistancia(Punto... puntos) {
		if(puntos.length == 0) return null;
		Punto puntoOrigen = new Punto();
		Punto puntoMasLejos = new Punto(puntos[0]);
		double distancia = 0;
		double distanciaMax = this.calcDistancia(puntoOrigen, puntoMasLejos);
		for(Punto punto : puntos) {
			distancia = this.calcDistancia(punto, puntoOrigen);
			if (distancia > distanciaMax){
				puntoMasLejos = punto;
				distanciaMax = distancia;
			}
		}
		return puntoMasLejos;
	}
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
}
