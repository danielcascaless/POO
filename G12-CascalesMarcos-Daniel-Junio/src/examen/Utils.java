package examen;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Function;


public class Utils {

    /**
     * Solicita vinos por teclado al usuario y devuelve una colección con los vinos registrados.
     * Usa el constructor por defecto (color: blanco, maduración: joven, coste: 2.0€).
     * Si hay un error, lanza una excepción comprobada.
     */
    public static Collection<Vino> registrarVinosPorTeclado() throws RegistroVinoException {
        Scanner sc = new Scanner(System.in);
        List<Vino> vinos = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print("Introduce el nombre del vino: ");
                String nombre = sc.nextLine().trim();

                System.out.print("Introduce la fecha de producción (formato YYYY-MM-DD): ");
                String fechaStr = sc.nextLine().trim();
                LocalDate fecha = LocalDate.parse(fechaStr);

                // Crear vino con constructor por defecto (color blanco, maduración joven, coste 2)
                Vino vino = new Vino(fecha, nombre);
                vinos.add(vino);
                System.out.println("✅ Vino registrado con éxito: " + vino);

                System.out.print("¿Deseas registrar otro vino? (s/n): ");
                String respuesta = sc.nextLine().trim().toLowerCase();
                if (!respuesta.equals("s")) {
                    continuar = false;
                }

            } catch (DateTimeParseException e) {
                throw new RegistroVinoException("❌ Error: la fecha introducida no tiene un formato válido.");
            } catch (IllegalArgumentException e) {
                throw new RegistroVinoException("❌ Error en los datos del vino: " + e.getMessage());
            }
        }

        return vinos;
    }
    
    public static <T> void buscarReemplazar(Collection<T> coleccion, T valorBuscado, Function<T, T> funcion) {
        if (!(coleccion instanceof List<T> lista)) {
            throw new IllegalArgumentException("La colección debe ser una lista para poder modificar sus elementos.");
        }

        ListIterator<T> it = lista.listIterator();
        while (it.hasNext()) {
            T actual = it.next();
            if (actual.equals(valorBuscado)) {
                T nuevo = funcion.apply(actual);
                it.set(nuevo);
            }
        }
    }
}
