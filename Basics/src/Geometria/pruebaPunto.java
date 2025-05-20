package Geometria;

public class pruebaPunto {
	public static void main(String[] args) {
		Punto punto1 = new Punto();
		Punto punto2 = new Punto(4,2);
		Punto punto3 = new Punto(punto2);
		Punto punto4 = punto2; // Aliasing, crea referencia entre objetos
		System.out.println("Punto 1: " + punto1);
		System.out.println("Punto 2: " + punto2);
		System.out.println("Punto 3: " + punto3);
		System.out.println("Punto 4: " + punto4);
		punto4.Desplazar(3, 4);
		System.out.println("Punto 2: " + punto2);
		System.out.println("Punto 3: " + punto3);
		System.out.println("Punto 4: " + punto4);
		punto2.Desplazar(1, 1);
		System.out.println("Punto 2: " + punto2);
		System.out.println("Punto 3: " + punto3);
		System.out.println("Punto 4: " + punto4);
		punto3.Desplazar(3, 3);
		System.out.println("Punto 2: " + punto2);
		System.out.println("Punto 3: " + punto3);
		System.out.println("Punto 4: " + punto4);

	}
}
