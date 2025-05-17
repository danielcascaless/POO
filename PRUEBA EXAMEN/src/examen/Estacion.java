package examen;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

/*
3. (1,6 ptos) Estación
La clase Estacion define una estación de aparcamiento de bicicletas que se ofrecen para ser
alquiladas. La clase tiene como propiedades:
	• nombre: cadena de texto con el nombre de la estación. Esta propiedad no puede variar una
	vez establecida.
	• bicis: conjunto con los identificadores de las bicicletas gestionadas por la estación (cada
	bicicleta está identificada por un número).
	• número de bicis: cantidad de bicis que gestiona la estación.
	
En relación con la propiedad bicis, la implementación de la clase almacena la propiedad en un
mapa en el que las claves son los identificadores de las bicicletas (enteros) y el valor asociado es
una lista de eventos de alquiler (EventoBici). Este mapa es un atributo de implementación
denominado eventos.
	El constructor de la clase recibe como argumentos el nombre y el número inicial de bicicletas. En
	el constructor se debe inicializar el mapa registrando una entrada para cada una de las bicicletas
	comenzando por el número 1. A cada bicicleta se le asocia una lista vacía. Por tanto, si el número
	inicial de bicicletas es 3, se crearán las entradas del mapa con identificadores 1, 2 y 3.
	
La funcionalidad que ofrece la clase Estacion es la siguiente:
	• Añadir una bici. La tarea es añadir una nueva bici a la estación. Tendrá como identificador
	el número actual de bicis de la estación más uno. La operación retorna el identificador de la
	nueva bici.
	
	• Consultar si una bici es alquilable (parámetro: identificador de la bicicleta). Una bici es
	alquilable si en el mapa de eventos la bicicleta está asociada a una lista vacía o el último
	evento de la bici es "fin alquiler". Además, si la bici no existe retornará falso porque no es
	alquilable.
	
	• Alquilar (parámetros: identificador bici, identificador usuario, instante inicial). El objetivo de
	la operación es crear un alquiler si la bici es alquilable. Por tanto, la operación retorna un
	valor booleano informando si ha tenido éxito. Si se puede alquilar, se crea un
	objeto EventoBici de tipo "inicio alquiler" y se almacena en último lugar de la lista de eventos
	asociados a la bici.
	
	• Versión sobrecargada del método alquilar en el que se omite el instante inicial en el que se
	hace el alquiler y se entiende que estamos haciendo referencia al instante actual (fecha y
	hora actual).
	
	• Consultar si una bici está alquilada (parámetro: identificador de la bicicleta). Una bici cumple
	esta condición si el último evento que tiene asociado es de tipo "inicio alquiler".
	
	• Estacionar (parámetros: identificador bici, identificador usuario, instante final). Esta
	operación da por finalizado un alquiler entregando la bicicleta. Retorna un número real con
	el coste del alquiler concluido. En primer lugar, crea un EventoBici de tipo "fin alquiler" y lo
	almacena al final de la lista de eventos de la bici. A continuación, calcula el número de
	minutos entre el instante inicial y el instante final del alquiler. El coste del alquiler se calcula
	como el número de minutos multiplicado por 0,01 euros. Por último, si la bici no estaba
	alquilada, se retornará el valor -1.
	
	Nota: la llamada ChronoUnit.MINUTES.between(fin, inicio) calcula el número de minutos
	transcurridos entre dos instantes de tiempo (LocalDateTime).
	• Consultar las bicicletas alquiladas
*/


/**
 * Clase que representa una estación de aparcamiento de bicicletas.
 * Gestiona un conjunto de bicicletas que pueden ser alquiladas o estacionadas.
 * Implementa el concepto de "encapsulación", ya que todos los atributos son privados.
 */
public class Estacion {

    // Nombre de la estación. Atributo final (no cambia nunca).
    protected final String nombre;

    /**
     * Mapa que asocia cada bici (clave: Integer) con su lista de eventos (valor: List<EventoBici>).
     * Es un atributo de implementación: gestiona el historial de cada bicicleta.
     */
    protected final Map<Integer, List<EventoBici>> eventos;

    /**
     * Constructor que inicializa la estación con un nombre y un número inicial de bicis.
     * Cada bicicleta recibe un identificador secuencial comenzando por 1.
     */
    public Estacion(String nombre, int numBicis) {
        this.nombre = nombre;
        this.eventos = new HashMap<>();

        // Inicializa el mapa con entradas vacías para cada bici
        for (int i = 1; i <= numBicis; i++) {
            eventos.put(i, new ArrayList<>());
        }
    }

    // Devuelve el nombre de la estación
    public String getNombre() {
        return nombre;
    }

    // Devuelve el número total de bicicletas registradas en la estación
    public int getNumeroBicis() {
        return eventos.size();
    }

    /**
     * Añade una nueva bicicleta a la estación.
     * El identificador asignado es el siguiente al último registrado.
     */
    public int anadirBici() {
        int nuevoId = getNumeroBicis() + 1;
        eventos.put(nuevoId, new ArrayList<>());
        return nuevoId;
    }

    /**
     * Verifica si una bicicleta es alquilable.
     * Una bici es alquilable si:
     * - Existe
     * - Su lista de eventos está vacía, o
     * - Su último evento es "fin alquiler"
     */
    public boolean esAlquilable(int idBici) {
        List<EventoBici> lista = eventos.get(idBici);
        if (lista == null) return false;
        if (lista.isEmpty()) return true;
        return lista.get(lista.size() - 1).getTipo().equals(EventoBici.FIN_ALQUILER);
    }

    /**
     * Intenta alquilar una bicicleta indicando el instante de inicio.
     * Si la bici es alquilable, se registra un evento de tipo "inicio alquiler" y devuelve true.
     * Si no lo es, devuelve false.
     */
    public boolean alquilar(int idBici, String usuario, LocalDateTime inicio) {
        if (!esAlquilable(idBici)) return false;
        eventos.get(idBici).add(new EventoBici(usuario, inicio, EventoBici.INICIO_ALQUILER));
        return true;
    }

    /**
     * Versión sobrecargada de alquilar que usa el tiempo actual como instante de inicio.
     */
    public boolean alquilar(int idBici, String usuario) {
        return alquilar(idBici, usuario, LocalDateTime.now());
    }

    /**
     * Indica si una bicicleta está alquilada.
     * Para ello, se comprueba si el último evento es de tipo "inicio alquiler".
     */
    public boolean estaAlquilada(int idBici) {
        List<EventoBici> lista = eventos.get(idBici);
        if (lista == null || lista.isEmpty()) return false;
        return lista.get(lista.size() - 1).getTipo().equals(EventoBici.INICIO_ALQUILER);
    }

    /**
     * Finaliza el alquiler de una bicicleta (estacionarla).
     * Si está correctamente alquilada:
     * - Se registra un evento de tipo "fin alquiler"
     * - Se calcula el coste del alquiler (minutos * 0,01)
     * Si no estaba alquilada, retorna -1.
     */
    public double estacionar(int idBici, String usuario, LocalDateTime fin) {
        if (!estaAlquilada(idBici)) return -1;

        List<EventoBici> lista = eventos.get(idBici);
        EventoBici inicio = lista.get(lista.size() - 1);
        lista.add(new EventoBici(usuario, fin, EventoBici.FIN_ALQUILER));

        long minutos = ChronoUnit.MINUTES.between(inicio.getTiempo(), fin);
        return minutos * 0.01;
    }

    /**
     * Devuelve el conjunto de bicicletas que están actualmente alquiladas.
     * Se recorre el mapa y se comprueba el último evento de cada bici.
     */
    public Set<Integer> obtenerBicisAlquiladas() {
        Set<Integer> alquiladas = new HashSet<>();
        for (Map.Entry<Integer, List<EventoBici>> entry : eventos.entrySet()) {
            List<EventoBici> lista = entry.getValue();
            if (!lista.isEmpty() && lista.get(lista.size() - 1).getTipo().equals(EventoBici.INICIO_ALQUILER)) {
                alquiladas.add(entry.getKey());
            }
        }
        return alquiladas;
    }

    /**
     * Realiza una copia profunda (deep clone) de la estación.
     * Se clonan todas las listas de eventos de cada bicicleta.
     */
    @Override
    public Estacion clone() {
        Estacion copia = new Estacion(this.nombre, 0); // Crea estación vacía

        for (Map.Entry<Integer, List<EventoBici>> entry : this.eventos.entrySet()) {
            List<EventoBici> copiaEventos = new ArrayList<>();
            for (EventoBici e : entry.getValue()) {
                copiaEventos.add(e.clone()); // Clon manual
            }
            copia.eventos.put(entry.getKey(), copiaEventos);
        }

        return copia;
    }

    /**
     * Representación textual de la estación, útil para mostrar en consola o depurar.
     */
    @Override
    public String toString() {
        return "Estacion[nombre=" + nombre + ", eventos=" + eventos + "]";
    }
}
