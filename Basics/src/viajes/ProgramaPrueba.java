package viajes;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class ProgramaPrueba {
    public static void main(String[] args) {
        // Creación de los viajes
        System.out.println("CREACIÓN DE VIAJES");
        System.out.println("-----------------");
        
        // Viaje "Murcia-Cartagena" con fecha de salida 9/dic/2024 con el número de plazas por defecto
        Viaje viajeMurciaCartagena = new Viaje("José Antonio", "Seat León", 
                "Murcia-Cartagena", LocalDate.of(2025, Month.DECEMBER, 9));
        System.out.println("Viaje creado: Murcia-Cartagena, fecha: 9/dic/2024, plazas: 1");
        
        // Viaje selectivo "Murcia–Campus" con fecha de salida 11/dic/2024 y 4 plazas
        ViajeSelectivo viajeMurciaCampus = new ViajeSelectivo("José Antonio", "Seat León", 
                "Murcia-Campus", LocalDate.of(2025, Month.DECEMBER, 11), 4);
        System.out.println("Viaje selectivo creado: Murcia-Campus, fecha: 11/dic/2024, plazas: 4");
        
        // Vetar a "Beatriz" en el viaje selectivo
        boolean vetoRealizado = viajeMurciaCampus.addVeto("Beatriz");
        System.out.println("Veto a Beatriz: " + (vetoRealizado ? "Realizado" : "No realizado"));
        
        // Viaje premium "Murcia-Barcelona" con fecha de salida 15/dic/2024 y 6 plazas
        ViajePremium viajeMurciaBarcelona = new ViajePremium("José Antonio", "Seat León", 
                "Murcia-Barcelona", LocalDate.of(2025, Month.DECEMBER, 15), 6);
        System.out.println("Viaje premium creado: Murcia-Barcelona, fecha: 15/dic/2024, plazas: 6");
        
        System.out.println("\nREALIZACIÓN DE RESERVAS");
        System.out.println("----------------------");
        
        // "Alberto" hace una reserva de dos plazas en el viaje "Murcia-Cartagena"
        ArrayList<Reserva> resultadoReservaAlberto = viajeMurciaCartagena.reservar("Alberto", 2);
        System.out.println("Reserva de Alberto (2 plazas) en Murcia-Cartagena: " + 
                (resultadoReservaAlberto != null ? "Aceptada" : "Rechazada"));
        System.out.println("Motivo: El número de plazas ofertadas es 1");
        
        // "Enrique" hace una reserva de 3 plazas en el viaje selectivo "Murcia-Campus"
        ArrayList<Reserva> resultadoReservaEnrique = viajeMurciaCampus.reservar("Enrique", 3);
        System.out.println("Reserva de Enrique (3 plazas) en Murcia-Campus: " + 
                (resultadoReservaEnrique != null ? "Aceptada" : "Rechazada"));
        
        // "Beatriz" hace una reserva de 1 plaza en el viaje selectivo "Murcia-Campus"
        ArrayList<Reserva> resultadoReservaBeatriz = viajeMurciaCampus.reservar("Beatriz");
        System.out.println("Reserva de Beatriz (1 plaza) en Murcia-Campus: " + 
                (resultadoReservaBeatriz != null ? "Aceptada" : "Rechazada"));
        System.out.println("Motivo: Beatriz está vetada");
        
        // "Ana" hace una reserva de dos plazas en el viaje premium "Murcia-Barcelona"
        ArrayList<Reserva> resultadoReservaAna = viajeMurciaBarcelona.reservar("Ana", 2);
        System.out.println("Reserva de Ana (2 plazas) en Murcia-Barcelona: " + 
                (resultadoReservaAna != null ? "Aceptada" : "Rechazada"));
        
        // "Ana" cancela su reserva
        boolean cancelacionAna = viajeMurciaBarcelona.cancelarViaje("Ana");
        System.out.println("Cancelación de reserva de Ana: " + 
                (cancelacionAna ? "Realizada" : "No realizada"));
    }
}