package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class ListaEnvios {
    private double presupuesto;
    private List<Envio> envios;

    public ListaEnvios() {}
    
    public ListaEnvios(double presupuesto) {
        this.presupuesto = presupuesto;
        this.envios = new ArrayList<>();
    }

    public void agregarEnvio(Envio envio, Planta planta) throws PresupuestoInsuficienteException {
        double costoEnvio = envio.calcularCosto();
        if (costoEnvio <= presupuesto) {
            envios.add(envio);
            presupuesto -= costoEnvio;
            planta.agregarEnvio(envio);
        } else {
            throw new PresupuestoInsuficienteException("Presupuesto insuficiente para agregar el envío.");
        }
    }

    public double calcularPago() {
        double totalPago = 0;
        for (Envio envio : envios) {
            totalPago += envio.calcularCosto();
        }
        return totalPago;
    }

    // Getters y setters
    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Envíos:\n");

        for (Envio envio : envios) {
            sb.append("Código: ").append(envio.getCodigo()).append("\n");
            sb.append("Origen: ").append(envio.getOrigen()).append("\n");
            sb.append("Destino: ").append(envio.getDestino()).append("\n");
            sb.append("Costo: ").append(envio.calcularCosto()).append("\n");
            sb.append("--------------------------------\n");
        }

        return sb.toString();
    }

}
