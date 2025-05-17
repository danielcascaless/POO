package examen;

import java.util.*;

/**
 * Subclase de Cata para catas profesionales.
 * - Solo pueden participar sumilleres registrados.
 * - Solo se aceptan vinos de maduración "reserva" o "gran reserva".
 * - El responsable es el primer sumiller del listado.
 */
public class CataProfesional extends Cata {

    private final Set<String> sumilleres; // colección inmutable de sumilleres
    private final String responsable;     // primer sumiller introducido

    /**
     * Constructor: recibe el nombre de la cata y una lista variable de sumilleres.
     * La colección se guarda como un conjunto inmutable.
     */
    public CataProfesional(String nombre, String... sumilleres) {
        super(nombre);

        if (sumilleres.length == 0) {
            throw new IllegalArgumentException("Debe haber al menos un sumiller.");
        }

        // Crear conjunto inmutable
        this.sumilleres = Set.of(sumilleres);
        this.responsable = sumilleres[0];
    }

    /**
     * Devuelve el nombre del responsable de la cata profesional.
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * Redefinición del método plantilla.
     * Solo los sumilleres registrados están autorizados a valorar.
     */
    @Override
    protected boolean esCatadorApto(String catador) {
        return sumilleres.contains(catador);
    }

    /**
     * Solo se aceptan vinos de maduración "reserva" o "gran reserva".
     * Si el vino no cumple, no se registra.
     */
    @Override
    public boolean registrarVino(Vino vino) {
        String tipo = vino.getMaduracion().toLowerCase();

        if (tipo.equals("reserva") || tipo.equals("gran reserva")) {
            return super.registrarVino(vino);
        }

        return false;
    }
    
    
    @Override
    public String toString() {
        return "CataProfesional[nombre=" + getNombre() + ", sumilleres=" + sumilleres + ", responsable=" + responsable + "]";
    }
    
    
    @Override
    public CataProfesional clone() {
        // Convertimos el set a array para pasarlo al constructor
        CataProfesional copia = new CataProfesional(getNombre(), sumilleres.toArray(new String[0]));

        // Copiar los vinos válidos
        for (Vino v : getVinos()) {
            copia.registrarVino(v);
        }

        return copia;
    }


}
