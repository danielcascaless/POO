package Subasta;

import java.util.ArrayList;

public class programa2 {
    public static void main(String[] args) {
        // Declarar dos variables de tipo String para usuarios
        String juan = "Juan";
        String enrique = "Enrique";

        // Declarar variable local limitada de tipo SubastaLimitada
        SubastaLimitada limitada = new SubastaLimitada("Disco duro multimedia", juan, 1);

        // Declarar variable local temporal de tipo SubastaTemporal
        SubastaTemporal temporal = new SubastaTemporal("Teclado", juan, 3);

        // Declarar variable local minima de tipo SubastaMinima
        SubastaMinima minima = new SubastaMinima("Impresora Láser", juan, 100);

        // Crear una colección de subastas y añadir todas las subastas anteriores
        ArrayList<Subasta> coleccionSubastas = new ArrayList<>();
        coleccionSubastas.add(limitada);
        coleccionSubastas.add(temporal);
        coleccionSubastas.add(minima);

        // Recorrer la colección de subastas
        for (Subasta subasta : coleccionSubastas) {
            // Mostrar el nombre del producto que se está subastando
            System.out.println("Producto en subasta: " + subasta.getNombre());

            // Aplicar el método pujar con usuario enrique y cantidad 10 euros
            boolean resultado1 = subasta.pujar(enrique, 10);
            System.out.println("Puja de Enrique por 10€: " + (resultado1 ? "Aceptada" : "Rechazada"));

            // De nuevo, el usuario enrique puja por 20 euros
            boolean resultado2 = subasta.pujar(enrique, 20);
            System.out.println("Puja de Enrique por 20€: " + (resultado2 ? "Aceptada" : "Rechazada"));

            // Si la subasta es limitada imprimir el número de pujas pendientes
            if (subasta instanceof SubastaLimitada) {
                SubastaLimitada subastaLimitada = (SubastaLimitada) subasta;
                int pujasPendientes = subastaLimitada.getMaximoPujas() - subasta.getLista().size();
                System.out.println("Pujas pendientes en la subasta limitada: " + pujasPendientes);
            }

            // Si la subasta está abierta, entonces se aplica el método ejecutar
            if (subasta.getAbierta()) {
                boolean ejecutada = subasta.ejecutar();
                if (!ejecutada) {
                    System.out.println("No se ha podido ejecutar la subasta: " + subasta.getNombre());
                    if (subasta instanceof SubastaTemporal) {
                        SubastaTemporal subastaTemp = (SubastaTemporal) subasta;
                        System.out.println(" Razón: No se ha alcanzado la fecha de vencimiento. Horas restantes: " + subastaTemp.getHorasRestantes());
                    } else if (subasta instanceof SubastaMinima) {
                        SubastaMinima subastaMin = (SubastaMinima) subasta;
                        System.out.println(" Razón: La puja mayor (" + subasta.getPujaMayor() + "€) es menor que el mínimo establecido (" + subastaMin.getCantidadMinimaPuja() + "€)");
                    }
                } else {
                    System.out.println("Subasta ejecutada con éxito: " + subasta.getNombre());
                }
            } else {
                System.out.println("La subasta no está abierta: " + subasta.getNombre());
            }

            System.out.println("------------------------------");
        }
    }
}