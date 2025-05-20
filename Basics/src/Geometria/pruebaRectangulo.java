package Geometria;

public class pruebaRectangulo {
	public static void main(String[] args) {
		PuntoInmutable verticeII_1 = new PuntoInmutable(3,1);
		Rectangulo rectangulo1 = new Rectangulo(verticeII_1,2,5);
		//PuntoInmutable verticeII_2 = new PuntoInmutable(3,-1);
		//PuntoInmutable verticeSD_1 = new PuntoInmutable(5,-6);
		//Rectangulo rectangulo2 = new Rectangulo(verticeII_2,verticeSD_1);
		System.out.println("Rectangulo antes desplazar: "+rectangulo1);
		rectangulo1.Desplazar(0, -7);
		System.out.println("Rectangulo post desplazar: " + rectangulo1);
	}
}
