package maquinaExpendedora;

public enum Monedas {
    CENT_1(0.01),
    CENT_2(0.02),
    CENT_5(0.05),
    CENT_10(0.1),
    CENT_20(0.2),
    CENT_50(0.5),
    EURO(1),
    DOS_EUROS(2);
    
    private final double valor;
    
    Monedas(double valor) {
        this.valor = valor;
    }
    
    public double getValor() {
        return valor;
    }
}
