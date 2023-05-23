package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Planta {
    private String nombre;
    private List<Envio> envios;

    public Planta(String nombre) {
        this.nombre = nombre;
        this.envios = new ArrayList<>();
    }

    public void agregarEnvio(Envio envio) {
        envios.add(envio);
    }

    public List<Envio> buscarEnviosPorCostoDescendente() {
        List<Envio> enviosOrdenados = new ArrayList<>(envios);
        enviosOrdenados.sort((envio1, envio2) -> Double.compare(envio2.calcularCosto(), envio1.calcularCosto()));
        System.out.println("Entré, pero no hago una mierda...");
        return enviosOrdenados;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Envio> getEnvios() {
        return envios;
    }
    
    

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }

    @Override
    public String toString() {
        return "Planta{" +
                "nombre='" + nombre + '\'' +
                ", envios=" + envios +
                '}';
    }
}
