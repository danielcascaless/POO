package paqueteResumen;
// ApuntesFinal.java
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Resumen de conceptos principales para el examen de Java
 */
public class ApuntesFinal {
    
    /**
     * Recordatorio de conceptos importantes de Java
     */
    public static void conceptosBasicos() {
        // Clases y objetos
        /*
         * Una clase es una plantilla para crear objetos
         * Un objeto es una instancia de una clase
         * Los atributos definen el estado del objeto
         * Los métodos definen el comportamiento
         */
        
        // Modificadores de acceso
        /*
         * public: accesible desde cualquier clase
         * protected: accesible en el mismo paquete y subclases
         * default (sin modificador): accesible solo en el mismo paquete
         * private: accesible solo dentro de la misma clase
         */
        
        // Constructores
        /*
         * Mismo nombre que la clase
         * No tienen tipo de retorno
         * Pueden estar sobrecargados (varios con diferentes parámetros)
         * Se pueden llamar entre sí con this(...)
         */
        
        // Herencia
        /*
         * extends para heredar de una clase
         * super(...) para llamar al constructor de la clase padre
         * super.metodo() para llamar a un método de la clase padre
         * @Override para sobreescribir métodos
         */
        
        // Objetos inmutables
        /*
         * Atributos final
         * No hay setters
         * No exponer referencias mutables
         * Hacer copias defensivas si es necesario
         */
        
        // Clases abstractas e interfaces
        /*
         * abstract class: puede tener métodos con y sin implementación
         * interface: todos los métodos son abstract por defecto
         * Una clase puede implementar múltiples interfaces
         * Una clase solo puede heredar de una clase abstracta
         */
    }
    
    /**
     * Resumen de uso de colecciones
     */
    public static void colecciones() {
        // ArrayList
        List<String> lista = new ArrayList<>();
        lista.add("uno");
        lista.add("dos");
        lista.size();  // tamaño
        lista.get(0);  // acceso por índice
        lista.remove(0);  // eliminar por índice
        lista.contains("uno");  // buscar
        
        // HashSet (no permite duplicados, sin orden)
        Set<String> conjunto = new HashSet<>();
        conjunto.add("uno");
        conjunto.add("uno");  // no se añade, ya existe
        conjunto.size();  // tamaño: 1
        conjunto.contains("uno");  // buscar
        conjunto.remove("uno");  // eliminar
        
        // TreeSet (ordenado, no permite duplicados)
        Set<String> conjuntoOrdenado = new TreeSet<>();
        conjuntoOrdenado.add("b");
        conjuntoOrdenado.add("a");
        conjuntoOrdenado.add("c");
        // Resultado: [a, b, c]
        
        // HashMap (pares clave-valor, sin orden)
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("uno", 1);
        mapa.put("dos", 2);
        mapa.get("uno");  // valor: 1
        mapa.containsKey("uno");  // buscar clave
        mapa.containsValue(1);  // buscar valor
        mapa.remove("uno");  // eliminar
        
        // TreeMap (pares clave-valor, ordenado por clave)
        Map<String, Integer> mapaOrdenado = new TreeMap<>();
        mapaOrdenado.put("b", 2);
        mapaOrdenado.put("a", 1);
        mapaOrdenado.put("c", 3);
        // Resultado: {a=1, b=2, c=3}
        
        // Recorrer colecciones
        for (String elemento : lista) {
            System.out.println(elemento);
        }
        
        for (String clave : mapa.keySet()) {
            System.out.println(clave + " -> " + mapa.get(clave));
        }
        
        for (Map.Entry<String, Integer> entrada : mapa.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
    }
    
    /**
     * Resumen de expresiones lambda y streams
     */
    public static void lambdaYStreams() {
        List<String> palabras = Arrays.asList("Java", "Streams", "Lambda", "Funcional");
        
        // Filtrar
        List<String> filtradas = palabras.stream()
                .filter(p -> p.length() > 5)
                .collect(Collectors.toList());
        
        // Transformar
        List<Integer> longitudes = palabras.stream()
                .map(String::length)
                .collect(Collectors.toList());
        
        // Ordenar
        List<String> ordenadas = palabras.stream()
                .sorted()
                .collect(Collectors.toList());
        
        // Ordenar con comparador personalizado
        List<String> ordenadasPorLongitud = palabras.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        
        // Agrupar
        Map<Integer, List<String>> porLongitud = palabras.stream()
                .collect(Collectors.groupingBy(String::length));
        
        // Método utilitario similar al ejercicio 11
        doIf(palabras, 
             p -> p.startsWith("J"), 
             p -> System.out.println("Palabra que empieza con J: " + p));
    }
    
    /**
     * Método genérico para aplicar una acción a elementos que cumplen una condición
     */
    public static <T> void doIf(Iterable<T> coleccion, Predicate<T> condicion, Consumer<T> accion) {
        for (T elemento : coleccion) {
            if (condicion.test(elemento)) {
                accion.accept(elemento);
            }
        }
    }
    
    /**
     * Resumen de manejo de fechas
     */
    public static void fechas() {
        // Fecha actual
        LocalDate hoy = LocalDate.now();
        
        // Fecha específica
        LocalDate fecha = LocalDate.of(2024, 12, 25);
        
        // Fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();
        
        // Comparación
        boolean esAntes = fecha.isBefore(hoy);
        boolean esDespues = fecha.isAfter(hoy);
        
        // Modificar (inmutable, devuelve nueva instancia)
        LocalDate mañana = hoy.plusDays(1);
        LocalDate proximoMes = hoy.plusMonths(1);
        
        // Diferencia entre fechas
        long diasEntre = ChronoUnit.DAYS.between(hoy, fecha);
    }
    
    /**
     * Ejemplo de clases de la práctica de apuestas (similar a la sesión 9)
     */
    public static class EjemploApuestas {
        public record Marcador(int local, int visitante) {
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                
                Marcador otro = (Marcador) obj;
                return local == otro.local && visitante == otro.visitante;
            }
            
            @Override
            public int hashCode() {
                return 31 * local + visitante;
            }
        }
        
        public static abstract class Evento {
            private final String nombre;
            private final double precio;
            private final Map<String, Marcador> apuestas;
            
            public Evento(String nombre, double precio) {
                this.nombre = nombre;
                this.precio = precio;
                this.apuestas = new HashMap<>();
            }
            
            // Método plantilla
            public boolean apostar(String usuario, Marcador marcador) {
                if (esAceptable(marcador)) {
                    apuestas.put(usuario, marcador);
                    return true;
                }
                return false;
            }
            
            // Método abstracto que implementan las subclases
            protected abstract boolean esAceptable(Marcador marcador);
            
            public int getNumeroApuestas() {
                return apuestas.size();
            }
            
            public double getRecaudacion() {
                return getNumeroApuestas() * precio;
            }
            
            // Getters
            public String getNombre() {
                return nombre;
            }
            
            public double getPrecio() {
                return precio;
            }
            
            public Map<String, Marcador> getApuestas() {
                return new HashMap<>(apuestas);  // Copia defensiva
            }
        }
        
        public static class EventoLibre extends Evento {
            public EventoLibre(String nombre, double precio) {
                super(nombre, precio);
            }
            
            @Override
            protected boolean esAceptable(Marcador marcador) {
                // Aceptar si no hay otra apuesta con ese marcador
                return !getApuestas().containsValue(marcador);
            }
        }
        
        public static class EventoRestringido extends Evento {
            private final Set<Marcador> opciones;
            
            public EventoRestringido(String nombre, double precio, Set<Marcador> opciones) {
                super(nombre, precio);
                this.opciones = new HashSet<>(opciones);
            }
            
            @Override
            protected boolean esAceptable(Marcador marcador) {
                // Aceptar si el marcador está en las opciones
                return opciones.contains(marcador);
            }
            
            public int getApuestasPorMarcador(Marcador marcador) {
                int contador = 0;
                for (Marcador m : getApuestas().values()) {
                    if (m.equals(marcador)) {
                        contador++;
                    }
                }
                return contador;
            }
            
            public Set<Marcador> getOpciones() {
                return new HashSet<>(opciones);  // Copia defensiva
            }
        }
    }
    
    /**
     * Ejemplo de clases para red social (similar a la sesión 10)
     */
    public static class EjemploRedSocial {
        public static class Mensaje {
            private final String autor;
            private final String texto;
            private final Set<String> temas;
            
            public Mensaje(String autor, String texto) {
                this.autor = autor;
                this.texto = texto;
                this.temas = extraerTemas(texto);
            }
            
            private Set<String> extraerTemas(String texto) {
                Set<String> result = new HashSet<>();
                String[] palabras = texto.split("\\s+");
                for (String palabra : palabras) {
                    if (palabra.startsWith("#")) {
                        result.add(palabra);
                    }
                }
                return result;
            }
            
            public String getAutor() {
                return autor;
            }
            
            public String getTexto() {
                return texto;
            }
            
            public Set<String> getTemas() {
                return new HashSet<>(temas);  // Copia defensiva
            }
            
            @Override
            public String toString() {
                return autor + ": " + texto;
            }
        }
        
        public static class Rastreador {
            private final List<Mensaje> mensajes;
            private final Map<String, List<Mensaje>> mapaPorAutor;
            private final Map<String, List<Mensaje>> mapaPorTema;
            
            public Rastreador() {
                mensajes = new ArrayList<>();
                mapaPorAutor = new TreeMap<>();  // Ordenado alfabéticamente
                mapaPorTema = new TreeMap<>();   // Ordenado alfabéticamente
            }
            
            public void registrarMensaje(Mensaje mensaje) {
                mensajes.add(mensaje);
                
                // Añadir al mapa de autores
                mapaPorAutor.computeIfAbsent(mensaje.getAutor(), k -> new ArrayList<>())
                            .add(mensaje);
                
                // Añadir al mapa de temas
                for (String tema : mensaje.getTemas()) {
                    mapaPorTema.computeIfAbsent(tema, k -> new ArrayList<>())
                               .add(mensaje);
                }
            }
            
            public List<Mensaje> getMensajes() {
                return new ArrayList<>(mensajes);  // Copia defensiva
            }
            
            public Set<String> getAutores() {
                return mapaPorAutor.keySet();
            }
            
            public Set<String> getTemas() {
                return mapaPorTema.keySet();
            }
            
            public List<Mensaje> getMensajesPorAutor(String autor) {
                List<Mensaje> lista = mapaPorAutor.get(autor);
                return lista != null ? new ArrayList<>(lista) : new ArrayList<>();
            }
            
            public List<Mensaje> getMensajesPorTema(String tema) {
                List<Mensaje> lista = mapaPorTema.get(tema);
                return lista != null ? new ArrayList<>(lista) : new ArrayList<>();
            }
        }
    }
    
    /**
     * Ejemplo de viajes compartidos (similar a la sesión 7-8)
     */
    public static class EjemploViajes {
        public static class Reserva {
            private final String usuario;
            private final int numPlazas;
            private final LocalDate fecha;
            private final String codigoViaje;
            
            public Reserva(String usuario, int numPlazas, String codigoViaje) {
                this.usuario = usuario;
                this.numPlazas = numPlazas;
                this.fecha = LocalDate.now();
                this.codigoViaje = codigoViaje;
            }
            
            public String getUsuario() {
                return usuario;
            }
            
            public int getNumPlazas() {
                return numPlazas;
            }
            
            public LocalDate getFecha() {
                return fecha;
            }
            
            public String getCodigoViaje() {
                return codigoViaje;
            }
            
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                
                Reserva otra = (Reserva) obj;
                return numPlazas == otra.numPlazas &&
                       usuario.equals(otra.usuario) &&
                       fecha.equals(otra.fecha) &&
                       codigoViaje.equals(otra.codigoViaje);
            }
            
            @Override
            public int hashCode() {
                int result = usuario.hashCode();
                result = 31 * result + numPlazas;
                result = 31 * result + fecha.hashCode();
                result = 31 * result + codigoViaje.hashCode();
                return result;
            }
            
            @Override
            public String toString() {
                return "Reserva [usuario=" + usuario + ", numPlazas=" + numPlazas +
                       ", fecha=" + fecha + ", codigoViaje=" + codigoViaje + "]";
            }
        }
        
        public static class Viaje implements Cloneable {
            private final String codigo;
            private final String propietario;
            private final String coche;
            private final String ruta;
            private final LocalDate fechaSalida;
            private final int plazasOfrecidas;
            private final List<Reserva> reservas;
            
            public Viaje(String propietario, String coche, String ruta, LocalDate fechaSalida, int plazasOfrecidas) {
                this.codigo = UUID.randomUUID().toString();
                this.propietario = propietario;
                this.coche = coche;
                this.ruta = ruta;
                this.fechaSalida = fechaSalida;
                this.plazasOfrecidas = plazasOfrecidas;
                this.reservas = new ArrayList<>();
            }
            
            public Viaje(String propietario, String coche, String ruta, LocalDate fechaSalida) {
                this(propietario, coche, ruta, fechaSalida, 1);
            }
            
            public Reserva realizarReserva(String usuario, int numPlazas) {
                // Verificar si el usuario ya ha hecho una reserva
                if (getReservaUsuario(usuario) != null) {
                    return null;
                }
                
                // Verificar si hay plazas disponibles
                if (getPlazasDisponibles() < numPlazas) {
                    return null;
                }
                
                // Verificar si la fecha de la reserva es anterior a la fecha de salida
                if (LocalDate.now().isAfter(fechaSalida)) {
                    return null;
                }
                
                // Crear y guardar la reserva
                Reserva reserva = new Reserva(usuario, numPlazas, codigo);
                reservas.add(reserva);
                return reserva;
            }
            
            public Reserva realizarReserva(String usuario) {
                return realizarReserva(usuario, 1);
            }
            
            public Reserva getReservaUsuario(String usuario) {
                for (Reserva reserva : reservas) {
                    if (reserva.getUsuario().equals(usuario)) {
                        return reserva;
                    }
                }
                return null;
            }
            
            public int getNumeroPlazasReservadas() {
                int total = 0;
                for (Reserva reserva : reservas) {
                    total += reserva.getNumPlazas();
                }
                return total;
            }
            
            public int getPlazasDisponibles() {
                return plazasOfrecidas - getNumeroPlazasReservadas();
            }
            
            // Getters
            public String getCodigo() {
                return codigo;
            }
            
            public String getPropietario() {
                return propietario;
            }
            
            public String getCoche() {
                return coche;
            }
            
            public String getRuta() {
                return ruta;
            }
            
            public LocalDate getFechaSalida() {
                return fechaSalida;
            }
            
            public int getPlazasOfrecidas() {
                return plazasOfrecidas;
            }
            
            public List<Reserva> getReservas() {
                return new ArrayList<>(reservas);  // Copia defensiva
            }
            
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                
                Viaje viaje = (Viaje) obj;
                return codigo.equals(viaje.codigo);
            }
            
            @Override
            public int hashCode() {
                return codigo.hashCode();
            }
            
            @Override
            public String toString() {
                return "Viaje [codigo=" + codigo + ", propietario=" + propietario + 
                       ", coche=" + coche + ", ruta=" + ruta + ", fechaSalida=" + fechaSalida +
                       ", plazasOfrecidas=" + plazasOfrecidas + ", plazasDisponibles=" +
                       getPlazasDisponibles() + ", reservas=" + reservas + "]";
            }
            
            @Override
            public Viaje clone() {
                try {
                    Viaje copia = (Viaje) super.clone();
                    
                    // Copia profunda de la lista de reservas
                    List<Reserva> reservasCopia = new ArrayList<>();
                    for (Reserva reserva : this.reservas) {
                        reservasCopia.add(new Reserva(
                            reserva.getUsuario(),
                            reserva.getNumPlazas(),
                            reserva.getCodigoViaje()
                        ));
                    }
                    
                    // Usar reflection para establecer la lista (ya que es final)
                    java.lang.reflect.Field field = Viaje.class.getDeclaredField("reservas");
                    field.setAccessible(true);
                    field.set(copia, reservasCopia);
                    
                    return copia;
                } catch (Exception e) {
                    throw new RuntimeException("Error al clonar Viaje", e);
                }
            }
        }
        
        public static class ViajeSelectivo extends Viaje {
            private final Set<String> usuariosVetados;
            
            public ViajeSelectivo(String propietario, String coche, String ruta, LocalDate fechaSalida, int plazasOfrecidas) {
                super(propietario, coche, ruta, fechaSalida, plazasOfrecidas);
                this.usuariosVetados = new HashSet<>();
            }
            
            public void vetarUsuario(String usuario) {
                usuariosVetados.add(usuario);
            }
            
            public void eliminarVeto(String usuario) {
                usuariosVetados.remove(usuario);
            }
            
            @Override
            public Reserva realizarReserva(String usuario, int numPlazas) {
                // Verificar si el usuario está vetado
                if (usuariosVetados.contains(usuario)) {
                    return null;
                }
                
                return super.realizarReserva(usuario, numPlazas);
            }
            
            public Set<String> getUsuariosVetados() {
                return new HashSet<>(usuariosVetados);  // Copia defensiva
            }
            
            @Override
            public String toString() {
                return "ViajeSelectivo [" + super.toString() + ", usuariosVetados=" + usuariosVetados + "]";
            }
            
            @Override
            public ViajeSelectivo clone() {
                ViajeSelectivo copia = (ViajeSelectivo) super.clone();
                
                try {
                    // Usar reflection para establecer el conjunto (ya que es final)
                    java.lang.reflect.Field field = ViajeSelectivo.class.getDeclaredField("usuariosVetados");
                    field.setAccessible(true);
                    field.set(copia, new HashSet<>(this.usuariosVetados));
                } catch (Exception e) {
                    throw new RuntimeException("Error al clonar ViajeSelectivo", e);
                }
                
                return copia;
            }
        }
        
        public static class ViajePremium extends Viaje {
            public ViajePremium(String propietario, String coche, String ruta, LocalDate fechaSalida, int plazasOfrecidas) {
                super(propietario, coche, ruta, fechaSalida, plazasOfrecidas);
            }
            
            public boolean cancelarReserva(String usuario) {
                // Verificar si existe la reserva
                Reserva reserva = getReservaUsuario(usuario);
                if (reserva == null) {
                    return false;
                }
                
                // Verificar si estamos al menos un día antes de la salida
                if (LocalDate.now().plusDays(1).isAfter(getFechaSalida())) {
                    return false;
                }
                
                // Cancelar la reserva
                return getReservas().remove(reserva);
            }
            
            @Override
            public String toString() {
                return "ViajePremium [" + super.toString() + "]";
            }
        }
    }
}