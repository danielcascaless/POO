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
        
        // Crear fecha espec�fica
        LocalDate fecha = LocalDate.of(2024, Month.DECEMBER, 25);
        System.out.println("Navidad 2024: " + fecha);
        
        // Tambi�n se puede usar el n�mero del mes
        LocalDate otraFecha = LocalDate.of(2024, 7, 4);
        System.out.println("4 de julio 2024: " + otraFecha);
        
        // Obtener hora actual
        LocalTime ahora = LocalTime.now();
        System.out.println("Hora actual: " + ahora);
        
        // Crear hora espec�fica
        LocalTime hora = LocalTime.of(13, 30, 15); // 13:30:15
        System.out.println("Hora espec�fica: " + hora);
        
        // Obtener fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        System.out.println("Fecha y hora actual: " + fechaHoraActual);
        
        // Crear fecha y hora espec�fica
        LocalDateTime fechaHora = LocalDateTime.of(2024, Month.OCTOBER, 31, 20, 0);
        System.out.println("Halloween 2024: " + fechaHora);
        
        // Tambi�n puede combinarse LocalDate y LocalTime
        LocalDateTime otraFechaHora = LocalDateTime.of(fecha, hora);
        System.out.println("Combinaci�n: " + otraFechaHora);
        
        // Fecha y hora con zona horaria
        ZonedDateTime zonaHoraria = ZonedDateTime.now();
        System.out.println("Fecha y hora con zona: " + zonaHoraria);
        
        // Crear con zona espec�fica
        ZonedDateTime tokio = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Hora en Tokio: " + tokio);
        
        // Instantes (timestamp UTC)
        Instant timestamp = Instant.now();
        System.out.println("Timestamp actual: " + timestamp);
        
        // Comparaci�n de fechas
        boolean esAntes = fecha.isBefore(hoy);
        boolean esDespues = fecha.isAfter(hoy);
        boolean esIgual = fecha.isEqual(hoy);
        
        System.out.println("�Navidad es antes de hoy? " + esAntes);
        System.out.println("�Navidad es despu�s de hoy? " + esDespues);
        
        // Modificar fechas (recuerda que son inmutables, devuelven nuevas instancias)
        LocalDate ma�ana = hoy.plusDays(1);
        LocalDate ayer = hoy.minusDays(1);
        LocalDate proximoMes = hoy.plusMonths(1);
        LocalDate a�oPasado = hoy.minusYears(1);
        
        System.out.println("Ma�ana: " + ma�ana);
        System.out.println("Pr�ximo mes: " + proximoMes);
        
        // Modificar partes espec�ficas
        LocalDate primerDiaMes = hoy.withDayOfMonth(1);
        System.out.println("Primer d�a del mes: " + primerDiaMes);
        
        // C�lculos con tiempo
        Period periodo = Period.between(otraFecha, fecha);
        System.out.println("Periodo entre fechas: " + periodo);
        
        long diasEntre = ChronoUnit.DAYS.between(otraFecha, fecha);
        System.out.println("D�as entre fechas: " + diasEntre);
        
        // Duration para tiempos
        LocalTime tiempo1 = LocalTime.of(9, 0);
        LocalTime tiempo2 = LocalTime.of(17, 30);
        
        Duration duracion = Duration.between(tiempo1, tiempo2);
        System.out.println("Duraci�n entre horas: " + duracion);
        
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
        System.out.println("Fecha larga en espa�ol: " + fechaLarga);
        
        // Parsear String a fecha
        LocalDate fechaParseada = LocalDate.parse("25/12/2024", formateadorCorto);
        System.out.println("Fecha parseada: " + fechaParseada);
        
        // Obtener partes de la fecha
        int a�o = hoy.getYear();
        Month mes = hoy.getMonth();
        int dia = hoy.getDayOfMonth();
        int diaSemana = hoy.getDayOfWeek().getValue(); // 1 (Lunes) a 7 (Domingo)
        
        System.out.println("A�o: " + a�o);
        System.out.println("Mes: " + mes);
        System.out.println("D�a: " + dia);
        System.out.println("D�a de la semana: " + diaSemana);
    }
}