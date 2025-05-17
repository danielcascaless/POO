package examen;

import java.time.LocalDateTime;
import java.util.Objects;


/**
Bloque 0: Ejercicios comunes a los bloques 1 y 2
Nota: Este bloque será valorado junto al bloque 2.
a) Implementa la clase Reserva de acuerdo con la siguiente especificación:
Una reserva representa la solicitud de un usuario para mantener bloqueada una bicicleta durante
un tiempo determinado. Esta clase implementa objetos inmutables con las siguientes
propiedades:
	• idBici: número entero que representa el identificador de la bicicleta.
	• usuario: cadena de texto con el identificador del usuario que realiza la reserva.
	• caducidad: instante de tiempo (LocalDateTime) en el que la reserva deja de estar activa.
	• activa: una reserva se considera activa si el instante actual es anterior a la caducidad.
	• caducada: una reserva está caducada si no está activa
*/

/**
 * Clase que representa una reserva de bicicleta.
 * Implementa inmutabilidad: todos los atributos son 'final' y privados.
 */
public class Reserva {

    // Identificador único de la bicicleta reservada
    private final int idBici;

    // Usuario que ha hecho la reserva
    private final String usuario;

    // Fecha y hora de caducidad de la reserva
    private final LocalDateTime caducidad;

    /**
     * Constructor: inicializa la reserva con id de bici y usuario.
     * La caducidad se establece automáticamente a 30 minutos desde el momento actual.
     * (Basado en apuntes: uso de LocalDateTime.of(...) y now().plusMinutes(...))
     */
    public Reserva(int idBici, String usuario) {
        this.idBici = idBici;
        this.usuario = usuario;
        this.caducidad = LocalDateTime.now().plusMinutes(30);
    }

    // Devuelve el ID de la bici asociada a esta reserva
    public int getIdBici() {
        return idBici;
    }

    // Devuelve el usuario que hizo la reserva
    public String getUsuario() {
        return usuario;
    }

    // Devuelve el instante de caducidad
    public LocalDateTime getCaducidad() {
        return caducidad;
    }

    /**
     * Indica si la reserva está activa (no ha caducado).
     * Se basa en la comparación del tiempo actual con la fecha de caducidad.
     */
    public boolean activa() {
        return LocalDateTime.now().isBefore(caducidad);
    }

    /**
     * Indica si la reserva ya ha caducado.
     * Es la negación de 'activa'.
     */
    public boolean caducada() {
        return !activa();
    }

    /**
     * Redefinición del método equals de Object.
     * Dos reservas son iguales si coinciden en todos sus atributos.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // mismo objeto
        if (obj == null || getClass() != obj.getClass()) return false; // distinto tipo
        Reserva other = (Reserva) obj;
        return idBici == other.idBici &&
               usuario.equals(other.usuario) &&
               caducidad.equals(other.caducidad);
    }

    /*
    1. (0,1 ptos) Extensión de la clase Reserva
    Redefine los métodos equals/hashCode en la clase Reserva. Dos reservas son iguales si tienen el
    mismo valor para todas sus propiedades.
    */
    
    /**
     * Redefinición de hashCode (coherente con equals).
     * Usa Objects.hash para generar un código de dispersión.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idBici, usuario, caducidad);
    }
    
    /*
    5. (0,65 ptos) Redefinición de métodos de Object
    
    • Implementa toString en todas las clases siguiendo las recomendaciones de la asignatura.
    
    • Implementa clone en la jerarquía de estaciones siguiendo las recomendaciones de la
    asignatura. Se implementará una copia profunda.
    */

    /**
     * Representación textual de la reserva.
     * Útil para imprimir o depurar.
     */
    @Override
    public String toString() {
        return "Reserva[idBici=" + idBici + ", usuario=" + usuario + ", caducidad=" + caducidad + "]";
    }

    /**
     * Método clone implementado manualmente.
     * Crea una nueva reserva con los mismos datos (pero cuidado: caducidad se reinicia).
     * NOTA: este clone no es una copia fiel exacta, ya que la caducidad se recalcula.
     */
    public Reserva clone() {
        return new Reserva(idBici, usuario); // se reinicia la caducidad
    }
}
