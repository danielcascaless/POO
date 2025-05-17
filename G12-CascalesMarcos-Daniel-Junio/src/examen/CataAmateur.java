package examen;


/**
 * Subclase de Cata para catas amateur.
 * - Solo se aceptan vinos de maduración "joven".
 * - Todos los catadores son aptos.
 * - Los catadores pueden rectificar sus valoraciones.
 */
public class CataAmateur extends Cata {

    /**
     * Constructor que llama al constructor de Cata.
     */
    public CataAmateur(String nombre) {
        super(nombre);
    }

    /**
     * Todos los catadores son aptos en una cata amateur.
     */
    @Override
    protected boolean esCatadorApto(String catador) {
        return true;
    }

    /**
     * Solo se aceptan vinos con maduración "joven".
     */
    @Override
    public boolean registrarVino(Vino vino) {
        return vino.getMaduracion().equalsIgnoreCase("joven") && super.registrarVino(vino);
    }

    /**
     * Permite a un catador rectificar una valoración anterior con una nueva.
     * Solo se reemplaza si la nueva valoración es válida.
     *
     * @param catador nombre del catador
     * @param vino vino que se va a rectificar
     * @param olfativa nueva puntuación olfativa
     * @param visual nueva puntuación visual
     * @param gustativa nueva puntuación gustativa
     * @return true si se ha rectificado, false si no era válido o no había valoración previa
     */
    public boolean rectificarValoracion(String catador, Vino vino, int olfativa, int visual, int gustativa) {
        // Primero verificar que el vino está registrado y ya ha sido valorado por ese catador
        if (!haSidoValoradoPor(catador, vino)) return false;

        // Intentamos validar la nueva valoración usando el método plantilla
        if (!esCatadorApto(catador)) return false;

        // Creamos una nueva valoración
        Valoracion nueva = new Valoracion(catador, vino, olfativa, visual, gustativa);

        // Buscar la valoración anterior en la lista y reemplazarla
        for (int i = 0; i < getValoracion().size(); i++) {
            Valoracion actual = getValoracion().get(i);
            if (actual.getCatador().equals(catador) && actual.getVino().equals(vino)) {
                // Reemplazamos directamente en la lista
                valoraciones.set(i, nueva);
                return true;
            }
        }

        return false; // No se encontró la valoración anterior (no debería pasar si `haSidoValoradoPor` es true)
    }
    
    
    
    
    @Override
    public String toString() {
        return "CataAmateur[nombre=" + getNombre() + ", vinos=" + getVinos().size() + ", valoraciones=" + getValoracion().size() + "]";
    }
    
    
    @Override
    public CataAmateur clone() {
        CataAmateur copia = new CataAmateur(getNombre());

        for (Vino v : getVinos()) {
            copia.registrarVino(v);
        }

        return copia;
    }


}
