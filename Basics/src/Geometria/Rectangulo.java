package Geometria;

public class Rectangulo {
	private int ladoX;
	private int ladoY;
	private PuntoInmutable verticeSI;
	private PuntoInmutable verticeII;
	private PuntoInmutable verticeID;
	private PuntoInmutable verticeSD;
	
	Rectangulo(PuntoInmutable verticeII,int ladoX, int ladoY){
		this.ladoX = ladoX;
		this.ladoY = ladoY;
		this.verticeII = verticeII;
		
		int xDerecha = this.verticeII.x() + ladoX;
		int yArriba = this.verticeII.y()+ ladoY;
		this.verticeID = new PuntoInmutable(xDerecha,verticeII.y());
		this.verticeSI = new PuntoInmutable(verticeII.x(),yArriba);
		this.verticeSD = new PuntoInmutable(xDerecha,yArriba);
	}
	Rectangulo(PuntoInmutable verticeII,PuntoInmutable verticeSD){
		this.verticeII = verticeII;
		this.verticeSD = verticeSD;
		this.verticeID = new PuntoInmutable(this.verticeSD.x(),this.verticeII.y());
		this.verticeSI = new PuntoInmutable(this.verticeII.x(),this.verticeSD.y());
		this.ladoX = Math.abs(this.verticeSD.x()-this.verticeSI.x());
		this.ladoY = Math.abs(this.verticeSD.y()-this.verticeID.y());
	}
	
	void Desplazar(int x,int y) {
		this.verticeID = new PuntoInmutable(this.verticeID.x()+x,this.verticeID.y()+y);
		this.verticeSD = new PuntoInmutable(this.verticeSD.x()+x,this.verticeSD.y()+y);
		this.verticeII = new PuntoInmutable(this.verticeII.x()+x,this.verticeII.y()+y);
		this.verticeSI = new PuntoInmutable(this.verticeSI.x()+x,this.verticeSI.y()+y);
	}
	void Escalar(int porcentaje) {
		
		double escalado = (double)porcentaje / 100;
		this.ladoX *= escalado;
		this.ladoY *= escalado;
		
		int xDerecha = this.verticeII.x() + ladoX;
		int yArriba = this.verticeII.y()+ ladoY;
		this.verticeID = new PuntoInmutable(xDerecha,verticeII.y());
		this.verticeSI = new PuntoInmutable(verticeII.x(),yArriba);
		this.verticeSD = new PuntoInmutable(xDerecha,yArriba);
	}
	
	
	// Getters setters and toString
	public int getLadoX() {
		return ladoX;
	}
	public void setLadoX(int ladoX) {
		this.ladoX = ladoX;
	}
	public int getLadoY() {
		return ladoY;
	}
	public void setLadoY(int ladoY) {
		this.ladoY = ladoY;
	}
	public PuntoInmutable getVerticeSI() {
		return verticeSI;
	}
	public void setVerticeSI(PuntoInmutable verticeSI) {
		this.verticeSI = verticeSI;
	}
	public PuntoInmutable getVerticeII() {
		return verticeII;
	}
	public void setVerticeII(PuntoInmutable verticeII) {
		this.verticeII = verticeII;
	}
	public PuntoInmutable getVerticeID() {
		return verticeID;
	}
	public void setVerticeID(PuntoInmutable verticeID) {
		this.verticeID = verticeID;
	}
	public PuntoInmutable getVerticeSD() {
		return verticeSD;
	}
	public void setVerticeSD(PuntoInmutable verticeSD) {
		this.verticeSD = verticeSD;
	}
	@Override
	public String toString() {
		return "Rectangulo [ladoX=" + ladoX + ", ladoY=" + ladoY + ", verticeSI=" + verticeSI + ", verticeII="
				+ verticeII + ", verticeID=" + verticeID + ", verticeSD=" + verticeSD + "]";
	}
	
}
