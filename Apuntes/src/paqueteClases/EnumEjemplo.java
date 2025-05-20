// EnumEjemplo.java
package paqueteClases;

/**
 * Ejemplo de uso de enumerados en Java
 */
public class EnumEjemplo {
    
    // Enumerado simple
    public enum DiaSemana {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }
    
    // Enumerado con propiedades
    public enum Moneda {
        UN_CENTIMO(0.01),
        DOS_CENTIMOS(0.02),
        CINCO_CENTIMOS(0.05),
        DIEZ_CENTIMOS(0.10),
        VEINTE_CENTIMOS(0.20),
        CINCUENTA_CENTIMOS(0.50),
        UN_EURO(1.0),
        DOS_EUROS(2.0);
        
        private final double valor;
        
        // Constructor privado
        private Moneda(double valor) {
            this.valor = valor;
        }
        
        public double getValor() {
            return valor;
        }
    }
    
    // Enumerado con métodos
    public enum Direccion {
        ARRIBA, ABAJO, IZQUIERDA, DERECHA;
        
        // Método para obtener la dirección opuesta
        public Direccion opuesta() {
            switch (this) {
                case ARRIBA: return ABAJO;
                case ABAJO: return ARRIBA;
                case IZQUIERDA: return DERECHA;
                case DERECHA: return IZQUIERDA;
                default: throw new AssertionError("Dirección desconocida");
            }
        }
    }
    
    public static void main(String[] args) {
        // Uso básico
        DiaSemana hoy = DiaSemana.LUNES;
        
        // Switch con enum
        switch (hoy) {
            case LUNES:
            case MARTES:
            case MIERCOLES:
            case JUEVES:
            case VIERNES:
                System.out.println("Día laborable");
                break;
            case SABADO:
            case DOMINGO:
                System.out.println("Fin de semana");
                break;
        }
        
        // Métodos de enum
        System.out.println("Nombre: " + hoy.name());
        System.out.println("Ordinal: " + hoy.ordinal());
        System.out.println("toString: " + hoy.toString());
        
        // Recorrer todos los valores
        System.out.println("Dias de la semana:");
        for (DiaSemana dia : DiaSemana.values()) {
            System.out.println(dia);
        }
        
        // Uso de enumerado con propiedades
        Moneda moneda = Moneda.DOS_EUROS;
        System.out.println("Valor de " + moneda + ": " + moneda.getValor() + " euros");
        
        // Calcular valor total
        double total = 0.0;
        for (int i = 0; i < 5; i++) {
            total += Moneda.CINCUENTA_CENTIMOS.getValor();
        }
        System.out.println("Total: " + total + " euros");
        
        // Uso de enumerado con métodos
        Direccion dir = Direccion.ARRIBA;
        System.out.println("Opuesto a " + dir + " es " + dir.opuesta());
    }
}