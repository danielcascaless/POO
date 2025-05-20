package Geometria;
/*	PUNTO INMUTABLE COMO RECORD
 * public record PuntoInmutable(int x, int y) {
    // Constructor sin parámetros (equivalente al constructor por defecto)
    public PuntoInmutable() {
        this(0, 0);
    }
    
    // Constructor de copia
    public PuntoInmutable(PuntoInmutable punto) {
        this(punto.x(), punto.y());
    }
    
    // Método para crear un nuevo punto incrementado
    public PuntoInmutable incrementar(int dx, int dy) {
        return new PuntoInmutable(this.x + dx, this.y + dy);
    }
}
*/
public class circuloPuntoInmutable {
    double pi = Math.PI;
    PuntoInmutable ORIGEN_COORDENADAS = new PuntoInmutable();
    double RADIO_DEFECTO = 5;
    PuntoInmutable origen;
    double radio;
    
    public circuloPuntoInmutable() {
        this.origen = ORIGEN_COORDENADAS;
        this.radio = RADIO_DEFECTO;
    }
    
    public circuloPuntoInmutable(PuntoInmutable origen, double radio) {
        this.origen = origen;
        this.radio = radio;
    }
    public circuloPuntoInmutable(PuntoInmutable punto) {
    	this(punto,5);
    }
    public circuloPuntoInmutable(circuloPuntoInmutable circulo) {
        this.origen = circulo.origen;
        this.radio = circulo.radio;
    }

    // Métodos
    public void desplazar(int x, int y) {
        // Ahora creamos un nuevo punto en lugar de modificar el existente
        this.origen = this.origen.incrementar(x, y);
    }
    
    public void escalar(double porcentaje) {
        porcentaje /= 100;
        this.radio *= porcentaje;
    }
    
    public double getPi() {
        return pi;
    }
    
    @Override
    public String toString() {
        return "Circulo [origen=" + origen + ", radio=" + radio + "]";
    }
    
    public PuntoInmutable getOrigen() {
        return origen;
    }
    
    public void setOrigen(PuntoInmutable origen) {
        this.origen = origen;
    }
    
    public double getRadio() {
        return radio;
    }
    
    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public PuntoInmutable getORIGEN_COORDENADAS() {
        return ORIGEN_COORDENADAS;
    }
    
    public double getRADIO_DEFECTO() {
        return RADIO_DEFECTO;
    }
}