package Geometria;

public class pruebasSesion3 {
	public static void main(String[] args) {
		Punto punto1 = new Punto(1,1);
		Punto punto2 = new Punto(4,2);
		Punto[] puntos = {punto1,punto2};
		for(Punto punto : puntos) {
			System.out.println("Punto: "+punto);
		}
		System.out.println("Distancia: " + punto1.calcDistancia(punto1, punto2));
		Punto punto = punto1.mayorDistancia(puntos);
		System.out.println("Punto mas lejano: " + punto);
	}
}
