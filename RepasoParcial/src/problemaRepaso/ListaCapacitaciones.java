package problemaRepaso;

import java.util.List;

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

	public int calcularCreditos() {
		int creditos = 0;
		for (Capacitacion unaCapacitacion : listaCapacitaciones) {
			creditos = unaCapacitacion.cantidadCreditos();
		}

		return creditos;
	}

	public double calcularCosto() {
		double costo = 0.0;
		for (Capacitacion unaCapacitacion : listaCapacitaciones) {
			costo = unaCapacitacion.calcularCosto();
		}
		return costo;
	}

	public double costoPromedio() {
		double costoP = 0.0;
		for (Capacitacion unaCapacitacion : listaCapacitaciones) {
			costoP = unaCapacitacion.calcularCosto();
		}
		return costoP / listaCapacitaciones.size();
	}

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
