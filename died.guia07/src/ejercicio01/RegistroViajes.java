package ejercicio01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RegistroViajes {
    private List<Pasaje> viajes;

    public RegistroViajes() {
        viajes = new ArrayList<>();
    }

    public void agregarViaje(Pasaje viaje) {
        if (!viajes.contains(viaje)) {
            viajes.add(viaje);
        }
    }

    public List<Pasaje> obtenerViajesOrdenadosPorMontoDescendente() {
        return viajes.stream()
                .sorted(Comparator.comparing(Pasaje::getMontoPagado).reversed())
                .collect(Collectors.toList());
    }

    public List<Pasaje> buscarPasajesPorOrigenODestino(String origen, String destino) {
        return viajes.stream()
                .filter(p -> p.getCiudadOrigen().equals(origen) || p.getCiudadDestino().equals(destino))
                .collect(Collectors.toList());
    }

    public Optional<Pasaje> obtenerPasajePorCodigoYPasajero(String codigo, Pasajero pasajero) {
        return viajes.stream()
                .filter(p -> p.getCodigoPasaje().equals(codigo) && p.getPasajero().equals(pasajero))
                .findFirst();
    }

    public double calcularCostoPromedioDePasajesParaPasajero(Pasajero pasajero) {
        return viajes.stream()
                .filter(p -> p.getPasajero().equals(pasajero))
                .mapToDouble(Pasaje::getMontoPagado)
                .average()
                .orElse(0);
    }
}
