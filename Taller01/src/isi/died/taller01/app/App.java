package isi.died.taller01.app;

import isi.died.taller01.*;
import isi.died.taller01.excepciones.*;

public class App {

	
	// NO FALLA EL ULTIMNO PUNTO PORQUE SIN QUERER BORRAMOS LA LOGICA DEL MANEJO EN LA CLASE 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	   	PruebaA();
		} catch (Exception e) {
			System.out.println(e);
		
		};
		System.out.println("Prueba A Finalizada");
		try {
			PruebaB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		System.out.println("Prueba B Finalizada");
		
		try {
			PruebaC();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		System.out.println("Prueba C Finalizada");
		try {
			PruebaD();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		System.out.println("Prueba D Finalizada");
		try {
			PruebaE();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		System.out.println("Prueba E Finalizada");
		try {
			PruebaF();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		System.out.println("Prueba F Finalizada");
		
	}
	
	/**
	 * a.	Crear un alumno, un curso obligatorio e 
	 * inscribir a dicho alumno al curso obligatorio 
	 * (puede crear todos los objetos auxiliares que necesite) 
	 * de manera exitosa.
	 */
	private static void PruebaA() throws Exception {
		Alumno a1 = new Alumno(100, "Mateo", 1, 10);
		
		Curso c1 = new Obligatorio();
		c1.setCreditos(5);
		c1.setId(10);
		c1.setNombre("DIED");
		c1.inscribir(a1);
	}
	
	/**
	 * b.	Crear un alumno, un curso optativo e inscribir 
	 * a dicho alumno al curso optativo (puede crear todos 
	 * los objetos auxiliares que necesite).
	 */
	private static void PruebaB() throws Exception {
		Alumno a2 = new Alumno(200, "Diego", 1, 1);
		Optativo c2 = new Optativo();
		c2.setId(220);
		c2.setNombre("Quimica");
	    c2.setCupoMaximo(10);
		c2.inscribir(a2);
	}
	
	/**
	 * c.	Crear un alumno que no cumple los requisitos 
	 * para anotarse a un curso obligatorio, intentar 
	 * inscribir a dicho alumno al curso obligatorio (puede 
	 * crear todos los objetos auxiliares que necesite).
	 */
	private static void PruebaC() throws Exception {
Alumno a3 = new Alumno(166, "Pedro", 1, 1);
		
		Curso c3 = new Obligatorio();
		c3.setCreditos(10);
		c3.setId(15);
		c3.setNombre("Algebra");
		c3.inscribir(a3);
	}
	
	/**
	 * d.	Crear un alumno que no cumple los requisitos 
	 * para anotarse a un curso opcional, intentar inscribir 
	 * a dicho alumno al curso opcional (puede crear todos 
	 * los objetos auxiliares que necesite).
	 */
	private static void PruebaD() throws Exception {
		Alumno a4 = new Alumno(200, "Dario", 1, 1);
		Optativo c4 = new Optativo();
		c4.setId(320);
		c4.setNombre("Fisica");
		c4.setCupoMaximo(0);
		c4.inscribir(a4);
		c4.inscribir(a4);
	}
	
	/**
	 * e.	Crear un docente y asignar a un curso exitosamente
	 */
	private static void PruebaE() throws Exception {
		Docente d1 = new Docente();
		d1.setId(10);
		d1.setNombre("Pepito Grillo");
		d1.setSalario(150000.00);
		Optativo c5 = new Optativo();
		c5.setId(320);
		c5.setNombre("Metodología de la investigación");
		c5.setCupoMaximo(10);
		
		
	}
	
	/**
	 * f.	Crear un docente que ya este asignado a 3 cursos 
	 * y asignarlo a un cuarto curso para lanzar una excepci�n 
	 * y capturarla en el m�todo main. 
	 */
	private static void PruebaF() throws Exception {
		Docente d2 = new Docente();
		d2.setId(10);
		d2.setNombre("Pepito Grillo");
		d2.setSalario(150000.00);
		Optativo c1 = new Optativo();
		c1.setId(320);
		c1.setNombre("Metodología de la investigación");
		c1.setCupoMaximo(10);
		Optativo c2 = new Optativo();
		c2.setId(320);
		c2.setNombre("Metodología de la investigación");
		c2.setCupoMaximo(10);
		Optativo c3 = new Optativo();
		c3.setId(320);
		c3.setNombre("Metodología de la investigación");
		c3.setCupoMaximo(10);
		Optativo c4 = new Optativo();
		c4.setId(320);
		c4.setNombre("Metodología de la investigación");
		c4.setCupoMaximo(10);
		
		c1.asignar(d2);
		c2.asignar(d2);
		c3.asignar(d2);
		c4.asignar(d2);
		
		
	}

}
