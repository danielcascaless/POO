package Geometria;

public class PruebaCirculo {
	public static void main(String[] args) {
		Circulo circulo1 = new Circulo();
		Punto origen = new Punto(2,2);
		Circulo circulo2 = new Circulo(origen,3);
		Circulo circulo3 = new Circulo(circulo2);

		System.out.println("Circulo1: " + circulo1);
		System.out.println("Circulo2: " + circulo2);
		System.out.println("Circulo3: " + circulo3);
		circulo1.escalar(150);
		System.out.println("Circulo1: " + circulo1);
		circulo2.escalar(50);
		System.out.println("Circulo2: "+ circulo2);
		circulo2.desplazar(3, 3);
		System.out.println("Circulo2: "+ circulo2);
		PuntoInmutable punto2 = new PuntoInmutable(3,2);
		circuloPuntoInmutable circulo4 = new circuloPuntoInmutable(punto2);
		System.out.println("circulo4: " + circulo4);
		circulo4.desplazar(3, 3);
		System.out.println("circulo4: " + circulo4);

	}
}
