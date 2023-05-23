package ejercicio01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import ejercicio01.Pasaje.TipoServicio;

public class App {

	public static void main(String[] args) {
		// Crear objetos de pasajero
        Pasajero pasajero1 = new Pasajero("Juan", "Pérez", "juan@gmail.com", "123456");
        Pasajero pasajero2 = new Pasajero("María", "García", "maria@gmail.com", "789012");
        Pasajero pasajero3 = new Pasajero("Carlos", "Ruiz", "carlos@gmail.com", "345678");

        // Crear objetos de aerolínea
        Aerolinea aerolinea1 = new Aerolinea("LATAM","C001");
        Aerolinea aerolinea2 = new Aerolinea("American Airlines","C002");

        // Crear objetos de pasaje
       
        Pasaje pasaje1 = new Pasaje("001", "LA100", "Buenos Aires", "Madrid",
                LocalDateTime.of(2023, 6, 1, 22, 0), LocalDateTime.of(2023, 6, 2, 16, 0),
                LocalDate.of(2023, 5, 31), "A1", pasajero1, 15000.0, TipoServicio.PRIMERA_CLASE, aerolinea1);
        Pasaje pasaje2 = new Pasaje("002", "LA101", "Buenos Aires", "Nueva York",
                LocalDateTime.of(2023, 7, 10, 14, 30), LocalDateTime.of(2023, 7, 11, 20, 45),
                LocalDate.of(2023, 7, 9), "B2", pasajero2, 10000.0, TipoServicio.BUSINESS, aerolinea1);
        Pasaje pasaje3 = new Pasaje("003", "AA200", "Miami", "Madrid",
                LocalDateTime.of(2023, 8, 15, 9, 15), LocalDateTime.of(2023, 8, 16, 13, 45),
                LocalDate.of(2023, 8, 14), "C3", pasajero3, 8000.0, TipoServicio.ECONOMY, aerolinea2);
        Pasaje pasaje4 = new Pasaje("004", "AA201", "Miami", "Los Angeles",
                LocalDateTime.of(2023, 9, 20, 11, 30), LocalDateTime.of(2023, 9, 20, 14, 15),
                LocalDate.of(2023, 9, 19), "D4", pasajero1, 5000.0, TipoServicio.ECONOMY, aerolinea2);
        Pasaje pasaje5 = new Pasaje("005", "LA102", "Buenos Aires", "Miami",
                LocalDateTime.of(2023, 10, 25, 8, 0), LocalDateTime.of(2023, 10, 25, 12, 30),
                LocalDate.of(2023, 10, 24), "E5", pasajero2, 7000.0, TipoServicio.ECONOMY, aerolinea1);
        Pasaje pasaje6 = new Pasaje("006", "LA103", "Buenos Aires", "Santiago de Chile",
                LocalDateTime.of(2023, 11, 5, 16, 30), LocalDateTime.of(2023, 11, 5, 19, 30),
                LocalDate.of(2023, 11, 4), "A23", pasajero3, 9000.0, TipoServicio.PRIMERA_CLASE, aerolinea2);
        Pasaje pasaje7 = new Pasaje("007", "AR202", "Córdoba", "Buenos Aires",
                LocalDateTime.of(2023, 12, 10, 8, 0), LocalDateTime.of(2023, 12, 10, 9, 15),
                LocalDate.of(2023, 12, 9), "B14", pasajero3, 7500.0, TipoServicio.ECONOMY, aerolinea1);
        Pasaje pasaje8 = new Pasaje("008", "AR203", "Buenos Aires", "Córdoba",
                LocalDateTime.of(2023, 12, 10, 18, 30), LocalDateTime.of(2023, 12, 10, 19, 45),
                LocalDate.of(2023, 12, 9), "C7", pasajero2, 4000.0, TipoServicio.ECONOMY, aerolinea1);
        Pasaje pasaje9 = new Pasaje("009", "AA300", "Mendoza", "Buenos Aires",
                LocalDateTime.of(2023, 12, 20, 14, 0), LocalDateTime.of(2023, 12, 20, 16, 30),
                LocalDate.of(2023, 12, 19), "F8", pasajero1, 12999.99, TipoServicio.BUSINESS, aerolinea2);
        Pasaje pasaje10 = new Pasaje("010", "AA301", "Buenos Aires", "Mendoza",
                LocalDateTime.of(2023, 12, 22, 8, 30), LocalDateTime.of(2023, 12, 22, 11, 0),
                LocalDate.of(2023, 12, 21), "D16", pasajero2, 7999.0, TipoServicio.BUSINESS, aerolinea2);

//Creación del Registro de Viajes y agregado de pasajes
RegistroViajes registroViajes = new RegistroViajes();
registroViajes.agregarViaje(pasaje1);
registroViajes.agregarViaje(pasaje2);
registroViajes.agregarViaje(pasaje3);
registroViajes.agregarViaje(pasaje4);
registroViajes.agregarViaje(pasaje5);
registroViajes.agregarViaje(pasaje6);
registroViajes.agregarViaje(pasaje7);
registroViajes.agregarViaje(pasaje8);
registroViajes.agregarViaje(pasaje9);
registroViajes.agregarViaje(pasaje10);

//Listado de pasajes ordenados por monto pagado
System.out.println("Listado de pasajes ordenados por monto pagado:");
registroViajes.obtenerViajesOrdenadosPorMontoDescendente();

//Búsqueda de pasajes por origen y/o destino
System.out.println("\nBúsqueda de pasajes por origen y/o destino:");
List<Pasaje> pasajesEncontrados = registroViajes.buscarPasajesPorOrigenODestino("Buenos Aires", "Madrid");
pasajesEncontrados.forEach(System.out::println);

//Búsqueda de pasaje por código y pasajero
System.out.println("\nBúsqueda de pasaje por código y pasajero:");
Optional<Pasaje> pasajeEncontrado = registroViajes.obtenerPasajePorCodigoYPasajero("002", pasajero2);
pasajeEncontrado.ifPresent(System.out::println);

//Cálculo de costo promedio de pasajes para un pasajero
System.out.println("\nCálculo de costo promedio de pasajes para un pasajero:");
double costoPromedio = registroViajes.calcularCostoPromedioDePasajesParaPasajero(pasajero1);
System.out.println("El costo promedio de los pasajes de " + pasajero1.getNombre() + " es $" + costoPromedio);
double costoPromedio2 = registroViajes.calcularCostoPromedioDePasajesParaPasajero(pasajero2);
System.out.println("El costo promedio de los pasajes de " + pasajero2.getNombre() + " es $" + costoPromedio2);
double costoPromedio3 = registroViajes.calcularCostoPromedioDePasajesParaPasajero(pasajero3);
System.out.println("El costo promedio de los pasajes de " + pasajero3.getNombre() + " es $" + costoPromedio3);


	}
}
