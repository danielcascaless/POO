// FechasEjemplo.java
package paqueteFechas;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * Ejemplos de uso de las clases de fecha y hora (Java 8+)
 */
public class FechasEjemplo {
    
    public static void main(String[] args) {
        // Obtener fecha actual
        LocalDate hoy = LocalDate.now();
        System.out.println("Fecha actual: " + hoy);
        
        // Crear fecha específica
        LocalDate fecha = LocalDate.of(2024, Month.DECEMBER, 25);
        System.out.println("Navidad 2024: " + fecha);
        
        // También se puede usar el número del mes
        LocalDate otraFecha = LocalDate.of(2024, 7, 4);
        System.out.println("4 de julio 2024: " + otraFecha);
        
        // Obtener hora actual
        LocalTime ahora = LocalTime.now();
        System.out.println("Hora actual: " + ahora);
        
        // Crear hora específica
        LocalTime hora = LocalTime.of(13, 30, 15); // 13:30:15
        System.out.println("Hora específica: " + hora);
        
        // Obtener fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        System.out.println("Fecha y hora actual: " + fechaHoraActual);
        
        // Crear fecha y hora específica
        LocalDateTime fechaHora = LocalDateTime.of(2024, Month.OCTOBER, 31, 20, 0);
        System.out.println("Halloween 2024: " + fechaHora);
        
        // También puede combinarse LocalDate y LocalTime
        LocalDateTime otraFechaHora = LocalDateTime.of(fecha, hora);
        System.out.println("Combinación: " + otraFechaHora);
        
        // Fecha y hora con zona horaria
        ZonedDateTime zonaHoraria = ZonedDateTime.now();
        System.out.println("Fecha y hora con zona: " + zonaHoraria);
        
        // Crear con zona específica
        ZonedDateTime tokio = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Hora en Tokio: " + tokio);
        
        // Instantes (timestamp UTC)
        Instant timestamp = Instant.now();
        System.out.println("Timestamp actual: " + timestamp);
        
        // Comparación de fechas
        boolean esAntes = fecha.isBefore(hoy);
        boolean esDespues = fecha.isAfter(hoy);
        boolean esIgual = fecha.isEqual(hoy);
        
        System.out.println("¿Navidad es antes de hoy? " + esAntes);
        System.out.println("¿Navidad es después de hoy? " + esDespues);
        
        // Modificar fechas (recuerda que son inmutables, devuelven nuevas instancias)
        LocalDate mañana = hoy.plusDays(1);
        LocalDate ayer = hoy.minusDays(1);
        LocalDate proximoMes = hoy.plusMonths(1);
        LocalDate añoPasado = hoy.minusYears(1);
        
        System.out.println("Mañana: " + mañana);
        System.out.println("Próximo mes: " + proximoMes);
        
        // Modificar partes específicas
        LocalDate primerDiaMes = hoy.withDayOfMonth(1);
        System.out.println("Primer día del mes: " + primerDiaMes);
        
        // Cálculos con tiempo
        Period periodo = Period.between(otraFecha, fecha);
        System.out.println("Periodo entre fechas: " + periodo);
        
        long diasEntre = ChronoUnit.DAYS.between(otraFecha, fecha);
        System.out.println("Días entre fechas: " + diasEntre);
        
        // Duration para tiempos
        LocalTime tiempo1 = LocalTime.of(9, 0);
        LocalTime tiempo2 = LocalTime.of(17, 30);
        
        Duration duracion = Duration.between(tiempo1, tiempo2);
        System.out.println("Duración entre horas: " + duracion);
        
        long horasEntre = ChronoUnit.HOURS.between(tiempo1, tiempo2);
        System.out.println("Horas entre tiempos: " + horasEntre);
        
        // Formateo de fechas y horas
        
        // Formateadores predefinidos
        DateTimeFormatter formateadorCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formateadorLargo = DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' yyyy");
        
        // Formatear a String
        String fechaFormateada = hoy.format(formateadorCorto);
        String fechaLarga = hoy.format(formateadorLargo.withLocale(new Locale("es", "ES")));
        
        System.out.println("Fecha formateada: " + fechaFormateada);
        System.out.println("Fecha larga en español: " + fechaLarga);
        
        // Parsear String a fecha
        LocalDate fechaParseada = LocalDate.parse("25/12/2024", formateadorCorto);
        System.out.println("Fecha parseada: " + fechaParseada);
        
        // Obtener partes de la fecha
        int año = hoy.getYear();
        Month mes = hoy.getMonth();
        int dia = hoy.getDayOfMonth();
        int diaSemana = hoy.getDayOfWeek().getValue(); // 1 (Lunes) a 7 (Domingo)
        
        System.out.println("Año: " + año);
        System.out.println("Mes: " + mes);
        System.out.println("Día: " + dia);
        System.out.println("Día de la semana: " + diaSemana);
    }
}