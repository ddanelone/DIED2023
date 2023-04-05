package isi.died.taller01;

import isi.died.taller01.excepciones.CreditosInsuficienteAlumnoException;

public class Optativo extends Curso {
	//private static int CUPO_MAXIMO = 50;
	private int cupoMaximo;
	
	
	public void setCupoMaximo(int max) {
		this.cupoMaximo = max;
	}
	
	@Override
	public String tipoCurso() {
		return "OPTATIVO";
	}
	
	@Override
	public void inscribir(Alumno unAlumno) throws Exception{
		if (this.cantAlumnos() < this.cupoMaximo)  {
			this.alumnos.add(unAlumno); 
		} else {
			throw new CreditosInsuficienteAlumnoException("El cupo está lleno.");
		};
	
 }

	
	

}
