package Ejercicio3;

import java.time.LocalDateTime;
import java.util.List;

public class App {
	public static void main(String[] args) {
		// Instanciamos las plantas
		Planta planta1 = new Planta("Planta 1");
		Planta planta2 = new Planta("Planta 2");
		Planta planta3 = new Planta("Planta 3");

		// Instanciamos los envíos
		LocalDateTime fechaHora1 = LocalDateTime.of(2022, 1, 1, 10, 0);
		LocalDateTime fechaHora2 = LocalDateTime.of(2022, 1, 2, 10, 0);
		LocalDateTime fechaHora3 = LocalDateTime.of(2022, 1, 3, 10, 0);
		LocalDateTime fechaHora4 = LocalDateTime.of(2022, 1, 4, 10, 0);

		// EnvioProgramado(String codigo, String origen, String destino, double
		// distancia, double costoPorKilometro, double peso, LocalDateTime fechaInicial,
		// int frecuencia, int cantidadEnvios)
		EnvioProgramado envioProg1 = new EnvioProgramado("1234567890123456789012", "Santa Fe", "Paraná", 35.0, 500.0,
				120.0, fechaHora1, 6, 4);
		EnvioProgramado envioProg2 = new EnvioProgramado("1234567890123456789099", "Paraná", "Recreo", 60.0, 500.0,
				320.0, fechaHora2, 4, 6);
		// EnvioEventual(String codigo, String origen, String destino, double distancia,
		// double costoPorKilometro, int cantidadBultos, boolean esUrgente,
		// LocalDateTime fechaRecogida)
		EnvioEventual envioEve1 = new EnvioEventual("1234567890123456789901", "Santa Fe", "Rafaela", 110.0, 400.0, 10,
				true, fechaHora3);
		EnvioEventual envioEve2 = new EnvioEventual("1234567890123456789999", "Santa Fe", "Tostado", 350.0, 500.0, 2,
				false, fechaHora4);

		// Instanciamos la lista de envíos y agregamos los envíos
		ListaEnvios listaEnvios = new ListaEnvios(10000000.0);
		try {
			listaEnvios.agregarEnvio(envioProg1,planta1);
			listaEnvios.agregarEnvio(envioProg2,planta2);
			listaEnvios.agregarEnvio(envioEve1,planta1);
			listaEnvios.agregarEnvio(envioEve2,planta2);
		} catch (PresupuestoInsuficienteException e) {
			System.out.println("Error: " + e.getMessage());
		}

		// Creamos una nueva GestionEnvios
		GestionEnvios gestionEnvio1 = new GestionEnvios();
		GestionEnvios gestionEnvio2 = new GestionEnvios();
		gestionEnvio1.agregarPlanta(planta1);
		gestionEnvio1.agregarPlanta(planta3);
		gestionEnvio1.agregarPlanta(planta2);
		gestionEnvio2.agregarPlanta(planta2);

		// Imprimimos la lista de envíos
		System.out.println(listaEnvios.toString());

		// probar el método calcularPago() de la ListaEnvios
		System.out.println(
				"Cantidad de dinero que hay que pagar por los envios cargados: $ " + listaEnvios.calcularPago());

		// Probar el método de GestionEnvios que calcular el promedio de los envios
		// programados.
		System.out
				.println("Peso promedio envios programados: " + gestionEnvio1.calcularPesoPromedioEnviosProgramados());

		// Probamos el método buscarEnviosPorPlanta
		System.out.println("Envíos recibidos por Planta 1:");
		List<Envio> envios = gestionEnvio1.buscarEnviosPorPlantaOrdenadosPorCostoDescendente(planta1);
		System.out.println(envios.toString());
		System.out.println("Envíos recibidos por Planta 2:");
		List<Envio> envios2 = gestionEnvio1.buscarEnviosPorPlantaOrdenadosPorCostoDescendente(planta2);
		System.out.println(envios2.toString());


		// Probamos el método buscarEnviosPorCondicion
		System.out.println("Envíos programados con costo superior a 1500:");
		 List<Planta> plantasPorCostoSuperior = gestionEnvio1.obtenerPlantasPorCostoSuperior(1500);
		 plantasPorCostoSuperior.toString();
	}
}
