package ejercicio01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Pasaje implements Comparable<Pasaje> {
	public enum TipoServicio {PRIMERA_CLASE, BUSINESS, ECONOMY}
    private String codigoPasaje;
    private String numeroVuelo;
    private String ciudadOrigen;
    private String ciudadDestino;
    private LocalDateTime fechaHoraPartida;
    private LocalDateTime fechaHoraArribo;
    private LocalDate fechaMaximaCancelacion;
    private String asientoAsignado;
    private Pasajero pasajero;
    private double montoPagado;
    private TipoServicio tipoServicio;
    private Aerolinea aerolinea;

    public Pasaje(String codigoPasaje, String numeroVuelo, String ciudadOrigen, String ciudadDestino,
                  LocalDateTime fechaHoraPartida, LocalDateTime fechaHoraArribo, LocalDate fechaMaximaCancelacion,
                  String asientoAsignado, Pasajero pasajero, double montoPagado, TipoServicio tipoServicio,
                  Aerolinea aerolinea) {
        this.codigoPasaje = codigoPasaje;
        this.numeroVuelo = numeroVuelo;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fechaHoraPartida = fechaHoraPartida;
        this.fechaHoraArribo = fechaHoraArribo;
        this.fechaMaximaCancelacion = fechaMaximaCancelacion;
        this.asientoAsignado = asientoAsignado;
        this.pasajero = pasajero;
        this.montoPagado = montoPagado;
        this.tipoServicio = tipoServicio;
        this.aerolinea = aerolinea;
    }

    public String getCodigoPasaje() {
        return codigoPasaje;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public LocalDateTime getFechaHoraPartida() {
        return fechaHoraPartida;
    }

    public LocalDateTime getFechaHoraArribo() {
        return fechaHoraArribo;
    }

    public LocalDate getFechaMaximaCancelacion() {
        return fechaMaximaCancelacion;
    }

    public String getAsientoAsignado() {
        return asientoAsignado;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public long duracion() {
        return ChronoUnit.MINUTES.between(fechaHoraPartida, fechaHoraArribo);
    }

    @Override
    public int compareTo(Pasaje otro) {
        return this.fechaHoraPartida.compareTo(otro.fechaHoraPartida);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pasaje)) {
            return false;
        }
        Pasaje pasaje = (Pasaje) obj;
        return Objects.equals(codigoPasaje, pasaje.codigoPasaje) &&
               Objects.equals(ciudadOrigen, pasaje.ciudadOrigen) &&
               Objects.equals(ciudadDestino, pasaje.ciudadDestino);
    }
    
    //Pasaje(String codigoPasaje, String numeroVuelo, String ciudadOrigen, String ciudadDestino,
    //LocalDateTime fechaHoraPartida, LocalDateTime fechaHoraArribo, LocalDateTime fechaMaximaCancelacion,
    //String asientoAsignado, Pasajero pasajero, double montoPagado, TipoServicio tipoServicio,
    //Aerolinea aerolinea)    
    @Override
    public String toString() {
        return "Pasaje [codigo=" + codigoPasaje + ", aerolinea=" + aerolinea.getNombre() + ", origen=" + ciudadOrigen + ", destino=" + ciudadDestino
                + ", fecha arribo=" + fechaHoraArribo + ", costo=" + montoPagado + ", pasajero=" + pasajero.getNombre() + "]";
    }

}