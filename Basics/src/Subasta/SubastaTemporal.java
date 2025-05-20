package Subasta;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SubastaTemporal extends Subasta {
    private LocalDateTime fechaHoraCierre;
    private int maximoPujas;
    private int duracion;
    
    public SubastaTemporal(String producto, String propietario, int horas) {
        super(producto, propietario);
        this.duracion = horas;
        this.fechaHoraCierre = LocalDateTime.now().plusHours(horas);
        this.maximoPujas = horas * 2;
    }
    
    @Override
    public Boolean pujar(String pujador, double cantidad) {
        // Verificar si no ha vencido el plazo
        if(LocalDateTime.now().isAfter(fechaHoraCierre)) 
            return false;
        
        // Verificar si no se ha superado el número máximo de pujas
        // Corrección: la condición tenía un error
        if(lista.size() >= maximoPujas) 
            return false;
        
        return super.pujar(pujador, cantidad);
    }
    
    // Método para consultar la duración
    public int getDuracion() {
        return duracion;
    }
    
    // Método para consultar la fecha de vencimiento
    public LocalDateTime getFechaHoraCierre() {
        return fechaHoraCierre;
    }
    
    // Método para obtener las horas restantes
    public long getHorasRestantes() {
        return ChronoUnit.HOURS.between(LocalDateTime.now(), fechaHoraCierre);
    }
    
    @Override
    public Boolean ejecutar() {
        // Sólo se puede ejecutar si ha finalizado el tiempo
        if(LocalDateTime.now().isBefore(fechaHoraCierre)) {
            return false; // No se puede ejecutar aún
        }
        
        return super.ejecutar(); // Ejecutar la lógica de la clase base
    }
}