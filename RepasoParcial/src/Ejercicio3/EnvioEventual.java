package Ejercicio3;

import java.time.LocalDateTime;

public class EnvioEventual extends Envio {
    private int cantidadBultos;
    private boolean esUrgente;
    private LocalDateTime fechaRecogida;

    public EnvioEventual(String codigo, String origen, String destino, double distancia, double costoPorKilometro,
                         int cantidadBultos, boolean esUrgente, LocalDateTime fechaRecogida) {
        super(codigo, origen, destino, distancia, costoPorKilometro);
        this.cantidadBultos = cantidadBultos;
        this.esUrgente = esUrgente;
        this.fechaRecogida = fechaRecogida;
    }

    @Override
    public double calcularCosto() {
        double costoKilometro = getCostoPorKilometro();

        if (esUrgente) {
            costoKilometro *= 1.75; // Aumenta el costo por km en un 75% si es urgente
        }

        if (cantidadBultos <= 3) {
            costoKilometro *= (1 + cantidadBultos * 0.05); // Aumenta el costo por km en un 5% por cada bulto (hasta 3 bultos)
        } else {
            costoKilometro *= (1 + 3 * 0.05 + (cantidadBultos - 3) * 0.08); // Aumenta el costo por km en un 5% por los primeros 3 bultos y un 8% extra por cada bulto adicional
        }

        return getDistancia() * costoKilometro;
    }

    // Getters y setters
    public int getCantidadBultos() {
        return cantidadBultos;
    }

    public void setCantidadBultos(int cantidadBultos) {
        this.cantidadBultos = cantidadBultos;
    }

    public boolean isEsUrgente() {
        return esUrgente;
    }

    public void setEsUrgente(boolean esUrgente) {
        this.esUrgente = esUrgente;
    }

    public LocalDateTime getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(LocalDateTime fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    @Override
    public String toString() {
        return "EnvioEventual{" +
                "cantidadBultos=" + cantidadBultos +
                ", esUrgente=" + esUrgente +
                ", fechaRecogida=" + fechaRecogida +
                ", " + super.toString() +
                '}';
    }
}
