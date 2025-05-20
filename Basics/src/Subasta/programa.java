package Subasta;

public class programa {
	public static void main(String[] args) {
        // Crear una subasta del producto "Teléfono Móvil" cuyo propietario sea "Juan"
        Subasta subasta = new Subasta("Teléfono Móvil", "Juan");
        System.out.println("Subasta creada para " + subasta.getNombre() + " por " + subasta.getPropietario());
        
        // El usuario "Pedro" puja por esa subasta 100 euros
        boolean resultadoPuja1 = subasta.pujar("Pedro", 100);
        System.out.println("Puja de Pedro por 100 euros: " + (resultadoPuja1 ? "ACEPTADA" : "RECHAZADA"));
        
        // Mostrar la puja mayor de la subasta
        System.out.println("Puja mayor actual: " + subasta.getPujaMayor() + " euros");
        
        // El usuario "Enrique" puja por esa subasta 50 euros
        boolean resultadoPuja2 = subasta.pujar("Enrique", 50);
        System.out.println("Puja de Enrique por 50 euros: " + (resultadoPuja2 ? "ACEPTADA" : "RECHAZADA"));
        
        // Mostrar la puja mayor nuevamente
        System.out.println("Puja mayor actual: " + subasta.getPujaMayor() + " euros");
        
        // Ejecutar la subasta
        boolean resultadoEjecucion = subasta.ejecutar();
        System.out.println("Ejecución de la subasta: " + (resultadoEjecucion ? "EXITOSA" : "FALLIDA"));
        
        // El usuario "Enrique" puja de nuevo por esa subasta con 200 euros
        boolean resultadoPuja3 = subasta.pujar("Enrique", 200);
        System.out.println("Puja de Enrique por 200 euros después de cerrar: " + (resultadoPuja3 ? "ACEPTADA" : "RECHAZADA"));
        
        // Mostrar información final de la subasta
        System.out.println("\nRESUMEN FINAL:");
        System.out.println("Producto: " + subasta.getNombre());
        System.out.println("Propietario: " + subasta.getPropietario());
        System.out.println("Estado de la subasta: " + (subasta.getAbierta() ? "Abierta" : "Cerrada"));
        System.out.println("Puja ganadora: " + subasta.getPujaMayor() + " euros");
    }
}
