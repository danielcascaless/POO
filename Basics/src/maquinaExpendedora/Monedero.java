package maquinaExpendedora;

public class Monedero {
    private int[] cantidades = new int[Monedas.values().length];

    public Monedero(Monedas tipoMoneda, int cantidad) {
        this.cantidades[tipoMoneda.ordinal()] = cantidad;
    }
    
    public Monedero(Monedas tipoMoneda) {
        this(tipoMoneda, 1);
    }
    
    public Monedero() {
        for(int i = 0; i < Monedas.values().length; i++) {
            this.cantidades[i] = 0;
        }
    }

    public void Insertar(Monedas tipoMoneda, int cantidad) {
        this.cantidades[tipoMoneda.ordinal()] += cantidad;
    }
    
    public void Insertar(Monedas tipoMoneda) {
        this.Insertar(tipoMoneda, 1);
    }
    
    public void Vaciar() {
        for(int i = 0; i < Monedas.values().length; i++) {
            this.cantidades[i] = 0;
        }
    }

    public void Combinar(Monedero monedero2) {
        for(int i = 0; i < Monedas.values().length; i++) {
            this.cantidades[i] += monedero2.cantidades[i];
        }
        monedero2.Vaciar();
    }
    
    public double getValorTotal() {
        double total = 0;
        for(int i = 0; i < Monedas.values().length; i++) {
            if(this.cantidades[i] > 0) {
                total += this.cantidades[i] * Monedas.values()[i].getValor();
                System.out.println("Cantidad de monedas de " + Monedas.values()[i] + " " + this.cantidades[i]);
            }
        }
        return total;
    }
    
    public void setValorTotal(double valor) { 
    	this.Vaciar();
        double valorRestante = valor;
        for(int i = Monedas.values().length-1; i >= 0; i--) {
            if(valorRestante >= Monedas.values()[i].getValor()) {
                this.cantidades[i] = (int)(valorRestante / Monedas.values()[i].getValor());
                valorRestante = valorRestante - this.cantidades[i] * Monedas.values()[i].getValor();
            }
        }
    }
    
    public int[] getCantidades() {
        return cantidades;
    }
    
    @Override
    public String toString() {
        return "" + getValorTotal();
    }
}