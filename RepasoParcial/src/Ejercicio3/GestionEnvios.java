package Ejercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GestionEnvios {
    private List<Planta> plantas;

    public GestionEnvios() {
        this.plantas = new ArrayList<>();
    }

    public void agregarPlanta(Planta planta) {
        plantas.add(planta);
    }

    public double calcularPesoPromedioEnviosProgramados() {
        double pesoTotal = 0;
        int cantidadEnvios = 0;

        for (Planta planta : plantas) {
            for (Envio envio : planta.getEnvios()) {
                if (envio instanceof EnvioProgramado) {
                    EnvioProgramado envioProgramado = (EnvioProgramado) envio;
                    pesoTotal += envioProgramado.getPeso();
                    cantidadEnvios++;
                }
            }
        }
        System.out.println("Peso Total: " + pesoTotal);

        if (cantidadEnvios > 0) {
            return pesoTotal / cantidadEnvios;
        }

        return 0;
    }

    public List<Planta> obtenerPlantasPorCostoSuperior(double valor) {
        List<Planta> plantasPorCostoSuperior = new ArrayList<>();

        for (Planta planta : plantas) {
        	
            List<Envio> envios = planta.getEnvios();
            for (Envio envio : envios) {
            	System.out.println("Costo de esta planta: " + envio.calcularCosto());
                if (envio.calcularCosto() > valor) {
                    plantasPorCostoSuperior.add(planta);
                    break;
                }
            }
        }

        Collections.sort(plantasPorCostoSuperior, Comparator.comparing(Planta::getNombre).reversed());
        return plantasPorCostoSuperior;
    }
    
    public List<Envio> buscarEnviosPorPlantaOrdenadosPorCostoDescendente(Planta planta) {
        List<Envio> envios = planta.getEnvios();

        // Ordenar los envíos por costo de manera descendente
        envios.sort((envio1, envio2) -> Double.compare(envio2.calcularCosto(), envio1.calcularCosto()));
        return envios;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== GESTIÓN DE ENVÍOS ===\n");
        
        for (Planta planta : plantas) {
            sb.append("\n");
            sb.append("Planta: ").append(planta.getNombre()).append("\n");
            sb.append("Envíos recibidos:\n");
            
            List<Envio> envios = buscarEnviosPorPlantaOrdenadosPorCostoDescendente(planta);
            for (Envio envio : envios) {
                sb.append(envio).append("\n");
            }
        }

        return sb.toString();
    }

    
}
