package isi.died.taller01;

import isi.died.taller01.excepciones.*;

public class Obligatorio extends Curso {
	
	@Override
	public void inscribir(Alumno unAlumno) throws Exception{
		if (unAlumno.getCreditos() >= this.getCreditos())  {
			this.alumnos.add(unAlumno); 
		} else {
			throw new CreditosInsuficienteAlumnoException("El alunmo no tiene los créditos suficientes.");
		};	 
 }
	public void agregarCurso(Alumno unAlumno) throws Exception {
		
			this.inscribir(unAlumno);
		
	}

	
	@Override
	public String tipoCurso() {
		return "OBLIGATORIO";
	}
	
	
}
