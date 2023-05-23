package Ejercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Envio {
    private String codigo;
    private String origen;
    private String destino;
    private double distancia;
    private double costoPorKilometro;

    public Envio(String codigo, String origen, String destino, double distancia, double costoPorKilometro) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.costoPorKilometro = costoPorKilometro;
    }

    public abstract double calcularCosto();

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getCostoPorKilometro() {
        return costoPorKilometro;
    }

    public void setCostoPorKilometro(double costoPorKilometro) {
        this.costoPorKilometro = costoPorKilometro;
    }

    @Override
    public String toString() {
        return "Envio{" +
                "codigo='" + codigo + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", distancia=" + distancia +
                ", costoPorKilometro=" + costoPorKilometro +
                '}';
    }
}
