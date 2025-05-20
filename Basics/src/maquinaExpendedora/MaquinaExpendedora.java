package maquinaExpendedora;

public class MaquinaExpendedora {
    private String producto;
    private double precio;
    private int stock;
    private Monedero dineroAcumulado;
    private Monedero transaccion;
    private boolean vacia;

    public MaquinaExpendedora(String producto, double precio, int stock) {
        this.producto = producto;
        this.precio = precio;
        this.stock = stock;
        this.dineroAcumulado = new Monedero();
        this.transaccion = new Monedero();
    }
    
    public void InsertarMoneda(Monedas moneda) {
        this.transaccion.Insertar(moneda);
    }
    
    public double DevolverDinero() {
        double cantidad = this.transaccion.getValorTotal();
        System.out.println("Aqui tienes " + cantidad + "€");
        return cantidad;
    }
    
    @Override
    public String toString() {
        return "MaquinaExpendedora [producto=" + producto + ", precio=" + precio + ", stock=" + stock
                + ", dineroAcumulado=" + dineroAcumulado + ", transaccion=" + transaccion + "]";
    }
    
    public boolean Comprar() {
        double valorDevuelto;
        if(this.transaccion.getValorTotal() >= this.precio) {
            valorDevuelto = this.transaccion.getValorTotal() - this.precio;
            this.transaccion.setValorTotal(valorDevuelto);
            System.out.println("Valor devuelto: " + valorDevuelto);
            this.stock--;
            this.dineroAcumulado.setValorTotal(this.dineroAcumulado.getValorTotal() + this.precio);
            return true;
        }
        else {
            System.out.println("Dinero insuficiente. Has insertado: " + this.transaccion.getValorTotal() + "€, pero el precio es: " + this.precio + "€");
            return false;
        }
    }
}