package Ejercicio3;

import java.time.LocalDateTime;

public class EnvioProgramado extends Envio {
    private double peso;
    private LocalDateTime fechaInicial;
    private int frecuencia;
    private int cantidadEnvios;

    public EnvioProgramado(String codigo, String origen, String destino, double distancia, double costoPorKilometro,
                           double peso, LocalDateTime fechaInicial, int frecuencia, int cantidadEnvios) {
        super(codigo, origen, destino, distancia, costoPorKilometro);
        this.peso = peso;
        this.fechaInicial = fechaInicial;
        this.frecuencia = frecuencia;
        this.cantidadEnvios = cantidadEnvios;
    }

    @Override
    public double calcularCosto() {
        return getDistancia() * getCostoPorKilometro() * cantidadEnvios;
    }

    // Getters y setters
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDateTime getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDateTime fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getCantidadEnvios() {
        return cantidadEnvios;
    }

    public void setCantidadEnvios(int cantidadEnvios) {
        this.cantidadEnvios = cantidadEnvios;
    }

    @Override
    public String toString() {
        return "EnvioProgramado{" +
                "peso=" + peso +
                ", fechaInicial=" + fechaInicial +
                ", frecuencia=" + frecuencia +
                ", cantidadEnvios=" + cantidadEnvios +
                ", " + super.toString() +
                '}';
    }
}
