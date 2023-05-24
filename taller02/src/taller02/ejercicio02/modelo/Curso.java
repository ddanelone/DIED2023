package taller02.ejercicio02.modelo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import taller02.ejercicio02.modelo.Evaluacion.TipoEvaluacion;

public class Curso {
	
	private Integer id;
	private String nombre;
	private Docente docente;
	private List<Inscripcion> inscripcion = new ArrayList<>();	
	
	public Curso(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Docente getDocente() {
		return docente;
	}
	
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	public List<Inscripcion> getInscripcion() {
		return inscripcion;
	}
	
	public void setInscripcion(List<Inscripcion> inscripcion) {
		this.inscripcion = inscripcion;
	}

	
	/**
	 * TODO: Asginar un docente a un curso: Un docente puede ser asignado a un curso, si y solo si, todos los 
	 * cursos donde el docente este asignado tiene al menos un 25% del porcentaje de aprobación. En 
	 * el caso de que un docente no se pueda inscribir en un curso, debe lanzar una excepción para 
	 * gestionar esta situación. Estos métodos se deben implementar en las clases, CURSO y DOCENTE.
	 */
	public void asignarDocente(Docente docente) {
		// completar
	}

	public void inscribirAlumno(Alumno a) throws Exception {
		Inscripcion i = new Inscripcion();
		i.setAlumno(a);
		i.setFechaInscripcion(Instant.now());
		a.inscribir(i);
		this.inscripcion.add(i);
	}
	
	
	/**
	 * TODO: Calcular el porcentaje de aprobación de un curso: el porcentaje de aprobación de un curso es
	 * igual a la cantidad de notas de evaluaciones finales superiores al 60% sobre el total de 
	 * inscripciones. Implemente este método en la clase CURSO
	 */
	
	
	public Double porcentajeAprobacion() {
	    double resultado = inscripcion.stream()
	        .flatMap(unaInscripcion -> unaInscripcion.getEvaluaciones().stream())
	        .filter(unaEvaluacion -> unaEvaluacion.getTipo() == TipoEvaluacion.FINAL && unaEvaluacion.getNota() > 60)
	        .mapToDouble(Evaluacion::getNota)
	        .sum();
	    
	    return resultado / inscripcion.size();
	}

	
	
	/**
	 * Imprime la lista de alumnos que estan en un estado ordenada alfabeticamente
	 * @param estado
	 * @return
	 */
	public List<String> imprimirAlumnos(Inscripcion.Estado estado){
		return null;
	}
}
