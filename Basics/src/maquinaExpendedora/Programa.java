package maquinaExpendedora;

public class Programa {
	public static void main(String[] args) {
		Monedero monederoMaquina = new Monedero();
		MaquinaExpendedora maquina = new MaquinaExpendedora("AGUA",0.5,10);
		System.out.println("Estado de la maquina: " + maquina);
		Monedas monedaEuro = Monedas.EURO;
		maquina.InsertarMoneda(monedaEuro);
		System.out.println("Estado de la maquina: " + maquina);
		maquina.Comprar();
		System.out.println("Estado de la maquina: " + maquina);

	}
}
