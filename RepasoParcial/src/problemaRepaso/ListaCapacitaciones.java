package problemaRepaso;

import java.util.List;
import java.util.stream.Collectors;

import problemaRepaso.Capacitacion.Tema;

import java.util.ArrayList;
import java.util.Comparator;

public class ListaCapacitaciones {
	private Empleado empleado;
	List<Capacitacion> listaCapacitaciones;

	public ListaCapacitaciones(Empleado e) {
		this.empleado = e;
		this.listaCapacitaciones = new ArrayList<>();
	}

	// TENGO LAS DOS VERSIONES DE calcularCreditos();
	public int calcularCreditos() {
		int creditos = 0;
		for (Capacitacion unaCapacitacion : listaCapacitaciones) {
			creditos = unaCapacitacion.cantidadCreditos();
		}

		return creditos;
	}

	public int calcularCreditosStream() {
		return listaCapacitaciones.stream().mapToInt(Capacitacion::cantidadCreditos).sum();
	}

	// TENGO LAS DOS VERSIONES DE calcularCostos();
	public double calcularCosto() {
		double costo = 0.0;
		for (Capacitacion unaCapacitacion : listaCapacitaciones) {
			costo = unaCapacitacion.calcularCosto();
		}
		return costo;
	}

	public double calcularCostoStream() {
		return listaCapacitaciones.stream().mapToDouble(Capacitacion::calcularCosto).sum();
	}

	//// TENGO LAS DOS VERSIONES DE costoPromedio();
	public double costoPromedio() {
		double costoP = 0.0;
		for (Capacitacion unaCapacitacion : listaCapacitaciones) {
			costoP = unaCapacitacion.calcularCosto();
		}
		return costoP / listaCapacitaciones.size();
	}

	public double costoPromedioStream() {
		return listaCapacitaciones.stream()
				.mapToDouble(Capacitacion::calcularCosto)
				.average()
				.orElse(0.0);
	}

	//TENGO LAS DOS VERSIONES
	private List<Capacitacion> obtenerCapacitacionesPorTema(Tema tema) {
		List<Capacitacion> capacitacionesPorTema = new ArrayList<>();

		for (Capacitacion capacitacion : listaCapacitaciones) {
			if (capacitacion.getTema() == tema) {
				capacitacionesPorTema.add(capacitacion);
			}
		}
		capacitacionesPorTema.sort(Comparator.comparingDouble(Capacitacion::calcularCosto).reversed());

		return capacitacionesPorTema;
	}
	private List<Capacitacion> obtenerCapacitacionesPorTemaStream(Tema tema) {
		return listaCapacitaciones.stream()
		        .filter(capacitacion -> capacitacion.getTema() == tema)
		        .sorted(Comparator.comparingDouble(Capacitacion::calcularCosto).reversed())
		        .collect(Collectors.toList());
	}
	

	//DOS VERSIONES TAMBIEN TENGO, imperativa y con Stream()
	//Ojo, esta lista de capacitaciones es de 1 docente cada lista. Debería tener un registro de docentes con su lista de capacitaciones...
	public Docente docenteConMasCreditos() {
		Docente docente = new Docente();

		int mayor = 0;
		for (Capacitacion unaCapacitacion : listaCapacitaciones) {
			if (unaCapacitacion.creditosPorDocente() >= mayor) {
				docente = unaCapacitacion.docenteConMasCreditos();
				mayor = unaCapacitacion.creditosPorDocente();
			}
		}

		return docente;
	}
	public Docente docenteConMasCreditosStream() {
		  return listaCapacitaciones.stream()
			        .max(Comparator.comparingInt(Capacitacion::creditosPorDocente))
			        .map(Capacitacion::getDocente)
			        .orElse(new Docente());
	}


	private List<Capacitacion> obtenerCapacitacionesPrioritarias() {
		List<Capacitacion> capacitacionesPrioritarias = new ArrayList<>();

		for (Capacitacion capacitacion : listaCapacitaciones) {
			if (capacitacion.isPrioritaria()) {
				capacitacionesPrioritarias.add(capacitacion);
			}
		}

		return capacitacionesPrioritarias;
	}

	private List<Capacitacion> obtenerCapacitacionesPrioritariasOrdenadas() {
		List<Capacitacion> capacitacionesOrdenadas = new ArrayList<>();
		capacitacionesOrdenadas = this.obtenerCapacitacionesPrioritarias();

		capacitacionesOrdenadas.sort(Comparator.comparingDouble(Capacitacion::cantidadCreditos).reversed());

		return capacitacionesOrdenadas;
	}

}
