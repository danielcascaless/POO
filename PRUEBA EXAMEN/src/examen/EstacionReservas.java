package examen;

import java.time.LocalDateTime;
import java.util.*;

/*
 * 4. (1,5 ptos) Estación con reservas

Una estación con reservas es un tipo de estación que permite a los usuarios reservar una bici
durante un tiempo determinado para poder alquilarla.
La clase EstacionReservas no declara propiedades nuevas, sino que utiliza un atributo de
implementación, reservas, que mantiene una lista con todas las reservas realizadas.

La funcionalidad que añade la clase es la siguiente:
	• Consultar la reserva activa de un usuario. Esta operación retorna el valor nulo si no la tiene.
	Nótese que un usuario solo puede tener una reserva activa.
	
	• Consultar si un usuario tiene reserva activa. Esta operación retorna un valor booleano.
	
	• Consultar el número de reservas caducadas de un usuario.
	
	• Consultar si un usuario está bloqueado. Un usuario está bloqueado (quiere que decir que no
	podrá hacer reservas ni alquilar una bici) si tiene 3 reservas caducadas.

	• Consultar si una bici está reservada. Esta condición se cumple si tiene una reserva que esté
	activa.
	• Reservar una bici por parte de un usuario. No está permitido hacer una reserva si el usuario
	está bloqueado o tiene una reserva activa. Además, tampoco se puede reservar una bicicleta
	que ya esté reservada o que no sea alquilable. Si se permite realizar la reserva, se crea un
	objeto Reserva y se añade a la lista de reservas. La operación retorna un valor booleano
	informando si se ha efectuado la reserva.
	
	• Desbloquear usuario. Esta operación elimina todas las reservas caducadas de un
	usuario. Requisito: implementar la operación haciendo uso de un iterador explícito.
	
	En una estación con reservas se puede alquilar una bici reservada siempre que el usuario que
	solicita el alquiler coincida con la reserva. En este caso, antes de efectuar el alquiler se elimina la
	reserva. En el caso de que la bici no esté reservada, la política de alquiler coincide con el de
	cualquier estación. Por último, recuerda que un usuario bloqueado no puede realizar alquileres.
	
	Finalmente, los usuarios con alguna reserva caducada tienen una penalización sobre el precio del
	alquiler, el cual se duplica.
*/

/**
 * Clase que amplía el comportamiento de Estacion para gestionar reservas.
 * Añade restricciones como reservas activas, bloqueo de usuarios y penalizaciones.
 * Utiliza herencia para extender la clase base Estacion.
 */
public class EstacionReservas extends Estacion {

    // Lista que almacena todas las reservas realizadas en la estación (activas y caducadas)
    private final List<Reserva> reservas;

    // Constructor que llama al constructor de la clase base Estacion
    public EstacionReservas(String nombre, int numBicis) {
        super(nombre, numBicis);
        this.reservas = new ArrayList<>();
    }

    /**
     * Devuelve la reserva activa del usuario si existe; si no, devuelve null.
     * Solo puede haber una reserva activa por usuario.
     */
    public Reserva getReservaActiva(String usuario) {
        for (Reserva r : reservas) {
            if (r.getUsuario().equals(usuario) && r.activa()) {
                return r;
            }
        }
        return null;
    }

    // Devuelve true si el usuario tiene una reserva activa, usando el método anterior
    public boolean tieneReservaActiva(String usuario) {
        return getReservaActiva(usuario) != null;
    }

    // Cuenta cuántas reservas caducadas tiene un usuario
    public int getNumReservasCaducadas(String usuario) {
        int contador = 0;
        for (Reserva r : reservas) {
            if (r.getUsuario().equals(usuario) && r.caducada()) {
                contador++;
            }
        }
        return contador;
    }

    // Devuelve true si el usuario tiene 3 o más reservas caducadas (queda bloqueado)
    public boolean estaBloqueado(String usuario) {
        return getNumReservasCaducadas(usuario) >= 3;
    }

    /**
     * Comprueba si una bicicleta está actualmente reservada.
     * Una bici está reservada si tiene alguna reserva activa.
     */
    public boolean biciReservada(int idBici) {
        for (Reserva r : reservas) {
            if (r.getIdBici() == idBici && r.activa()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Intenta hacer una reserva. Se permiten reservas solo si:
     * - El usuario no está bloqueado
     * - No tiene otra reserva activa
     * - La bici no está reservada por otro usuario
     * - La bici es alquilable
     * Si se cumplen todas, se crea una nueva reserva y se añade a la lista.
     */
    public boolean reservar(int idBici, String usuario) {
        if (estaBloqueado(usuario)) return false;
        if (tieneReservaActiva(usuario)) return false;
        if (biciReservada(idBici)) return false;
        if (!esAlquilable(idBici)) return false;

        reservas.add(new Reserva(idBici, usuario));
        return true;
    }

    /**
     * Desbloquea al usuario eliminando todas sus reservas caducadas.
     * Se exige usar un iterador explícito para evitar ConcurrentModificationException.
     */
    public void desbloquear(String usuario) {
        Iterator<Reserva> it = reservas.iterator();
        while (it.hasNext()) {
            Reserva r = it.next();
            if (r.getUsuario().equals(usuario) && r.caducada()) {
                it.remove();
            }
        }
    }

    /**
     * Sobrescribe el método alquilar de Estacion.
     * Permite alquilar una bici reservada si coincide con la reserva del usuario.
     * Si el usuario está bloqueado, no se permite alquilar.
     */
    @Override
    public boolean alquilar(int idBici, String usuario, LocalDateTime inicio) {
        if (estaBloqueado(usuario)) return false;

        Reserva reserva = getReservaActiva(usuario);
        if (reserva != null && reserva.getIdBici() == idBici) {
            reservas.remove(reserva); // Se elimina la reserva al alquilar
        } else if (reserva != null || biciReservada(idBici)) {
            return false; // La bici está reservada por otro o hay conflicto
        }

        return super.alquilar(idBici, usuario, inicio); // Llama al método original de Estacion
    }

    /**
     * Versión sobrecargada de alquilar sin parámetro de fecha: usa fecha actual.
     */
    @Override
    public boolean alquilar(int idBici, String usuario) {
        return alquilar(idBici, usuario, LocalDateTime.now());
    }

    /**
     * Clonación profunda de EstacionReservas.
     * Copia todos los eventos de bicicletas y todas las reservas activas o caducadas.
     */
    @Override
    public EstacionReservas clone() {
        EstacionReservas copia = new EstacionReservas(this.nombre, 0);

        for (Map.Entry<Integer, List<EventoBici>> entry : this.eventos.entrySet()) {
            List<EventoBici> copiaEventos = new ArrayList<>();
            for (EventoBici e : entry.getValue()) {
                copiaEventos.add(e.clone());
            }
            copia.eventos.put(entry.getKey(), copiaEventos);
        }

        for (Reserva r : this.reservas) {
            copia.reservas.add(r.clone());
        }

        return copia;
    }

    /**
     * Añade información sobre las reservas al método toString() heredado de Estacion.
     */
    @Override
    public String toString() {
        return super.toString() + ", reservas=" + reservas + "]";
    }
}
