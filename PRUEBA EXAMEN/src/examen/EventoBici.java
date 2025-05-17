package examen;

import java.time.LocalDateTime;

/*
	2. (0,35 ptos) Eventos de alquiler
	Implementa la clase EventoBici que representa las acciones del proceso de alquiler de una bicicleta
	 objetos inmutables. Las propiedades son:
		• usuario: cadena de texto con el identificador del usuario.
		• tiempo: instante de tiempo (LocalDateTime) en el que se ha realizado la acción.
		• tipo: identifica la acción de alquiler, que solo puede ser "inicio alquiler" o "fin alquiler".
	La clase ofrece un constructor que recibe como argumentos las tres propiedades. Adicionalmente,
	declara un segundo constructor que omite el tiempo e inicializa esta propiedad con el instante
	actual.
*/

/**
 * Clase que representa un evento relacionado con el alquiler de una bicicleta.
 * Según los apuntes, los eventos reflejan acciones como "inicio alquiler" o "fin alquiler".
 * La clase es inmutable: todos los atributos son 'final' y no hay setters.
 */
public class EventoBici {

    // Constantes públicas para representar los dos tipos de evento permitidos
    public static final String INICIO_ALQUILER = "inicio alquiler";
    public static final String FIN_ALQUILER = "fin alquiler";

    // Usuario que realiza la acción (alquilar o devolver la bici)
    private final String usuario;

    // Instante en el que se produce el evento
    private final LocalDateTime tiempo;

    // Tipo de evento: puede ser "inicio alquiler" o "fin alquiler"
    private final String tipo;

    /**
     * Constructor principal: recibe usuario, tiempo y tipo.
     * Si el tipo no es válido (no coincide con las constantes), lanza una excepción.
     */
    public EventoBici(String usuario, LocalDateTime tiempo, String tipo) {
        if (!tipo.equals(INICIO_ALQUILER) && !tipo.equals(FIN_ALQUILER)) {
            throw new IllegalArgumentException("Tipo inválido");
        }
        this.usuario = usuario;
        this.tiempo = tiempo;
        this.tipo = tipo;
    }

    /**
     * Constructor secundario: recibe solo usuario y tipo.
     * El tiempo se establece como el instante actual (LocalDateTime.now()).
     * Muy útil para registrar eventos en tiempo real.
     */
    public EventoBici(String usuario, String tipo) {
        this(usuario, LocalDateTime.now(), tipo);
    }

    // Getter para el usuario que realizó el evento
    public String getUsuario() {
        return usuario;
    }

    // Getter para el momento en que ocurrió el evento
    public LocalDateTime getTiempo() {
        return tiempo;
    }

    // Getter para el tipo de evento (inicio o fin del alquiler)
    public String getTipo() {
        return tipo;
    }

    /**
     * Método clone implementado manualmente (no usa super.clone()).
     * Al ser todos los atributos inmutables (String, LocalDateTime), no es necesaria copia profunda.
     */
    public EventoBici clone() {
        return new EventoBici(usuario, tiempo, tipo);
    }

    /**
     * Representación textual del evento, útil para depurar o mostrar en consola.
     */
    @Override
    public String toString() {
        return "EventoBici[usuario=" + usuario + ", tiempo=" + tiempo + ", tipo=" + tipo + "]";
    }
}
