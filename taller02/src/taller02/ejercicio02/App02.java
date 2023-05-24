package taller02.ejercicio02;

import java.time.Instant;
import java.util.*;
import taller02.ejercicio02.modelo.*;
import taller02.ejercicio02.modelo.Evaluacion.TipoEvaluacion;
import taller02.ejercicio02.modelo.Inscripcion.Estado;

public class App02 {
	// TODO: Crear en la clase App02 las instancias necesarias para probar los 3 items anteriores y el manejo de excepciones apropiado
	public static void main(String[] args) {
		
		Curso c1 = new Curso(111, "DIED");
		Curso c2 = new Curso(222, "Gestión de Datos");
		Curso c3 = new Curso(333, "Matemática Discreta");
		Curso c4 = new Curso(444, "AEDD");
		
		Alumno a1 = new Alumno();
		Alumno a2 = new Alumno();

		Docente d1 = new Docente();
		Docente d2 = new Docente();
		
		Evaluacion ev1 = new Evaluacion();
		Evaluacion ev2 = new Evaluacion();
		ev1.setNota(65.5);
		ev1.setTipo(TipoEvaluacion.FINAL);
		
		ev2.setNota(0.5);
		ev2.setTipo(TipoEvaluacion.FINAL);
		
		
		List<Evaluacion> listaE = new ArrayList <>();
		listaE.add(ev1);
		List<Evaluacion> listaE2 = new ArrayList <>();
		listaE2.add(ev2);
		
		Inscripcion i1 = new Inscripcion();
		Inscripcion i2 = new Inscripcion();
		i1.setEvaluaciones(listaE);
		i1.setEstado(Estado.REGULAR);
		i1.setEvaluaciones(listaE2);
		
		List<Inscripcion> lista = new ArrayList <>();
		lista.add(i1);
		
		List<Inscripcion> lista2 = new ArrayList <>();
		lista2.add(i1);
		lista2.add(i1);
		//lista2.add(i1);
	
		a1.setInscripciones(lista);
		c1.setInscripcion(lista);

		List<Curso> listaC = new ArrayList <>();
		listaC.add(c1);
		d1.setCursos(listaC);
		
		List<Curso> listaC2 = new ArrayList <>();
		listaC2.add(c2);
		d2.setCursos(listaC2);
		
		a1.setInscripciones(lista);
		a2.setInscripciones(lista2);
		
		
		System.out.println("Caso de prueba 1");
		System.out.println("Porcentaje aprobación curso 1: " + c1.porcentajeAprobacion());

		
		try {
			System.out.println("Caso de prueba 2");
			c1.asignarDocente(d1);
			System.out.println("Docente agregado exitosamente");
			
		} catch (Exception e) {
			System.out.println(e);

		}
		try {
			System.out.println("Caso de prueba 3");
		
			d2.asignarCurso(c1);
			
		} catch (Exception e) {
			System.out.println(e);

		}
		
		try {
			System.out.println("Caso de prueba 4");
			a2.inscribir(i1);
			
			
		} catch (Exception e) {
			System.out.println(e);

		}

		try {
			System.out.println("Caso de prueba 5");
			a2.inscribir(i1);
			
			
		} catch (Exception e) {
			System.out.println(e);

		}

		
		
		
		// completar ejercicios opcionales
		ejercicioOpcional1();
		ejercicioOpcional2();
	}
	
	public static void ejercicioOpcional1() {
		
	}
	
	public static void ejercicioOpcional2() {
		
	}

}
