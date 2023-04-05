package isi.died.taller01;
import java.util.ArrayList;
import java.util.List;

import isi.died.taller01.excepciones.LimiteDocenteCursoException;

public abstract class Curso {

	 private int id;
	 private String nombre;
	 private int creditos;
	 private Docente docente;
	 protected List<Alumno> alumnos;
	 protected final int CANTIDAD_MAXIMA_DOCENTES = 3;
	 
	 public Curso() {
		 this.alumnos = new ArrayList<Alumno>();
	 }
	 
	 public Curso(int id, String nombre, int creditos) {
		 this();
		 this.id = id;
		 this.nombre = nombre;
		 this.creditos = creditos;
	 }

	 public abstract String tipoCurso();
	 
	 public abstract void inscribir(Alumno a) throws Exception;

	 public final void asignar(Docente unDocente) throws Exception {	 
		 if (unDocente.cantCursos() < 3)  {
			 unDocente.agregarCurso(this);
				this.docente = unDocente; 
			} else {
				throw new LimiteDocenteCursoException("El docente no puede tener más de 3 cursos.");
			};	 
	 }
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public Docente getDocente() {
		return docente;
	}
	
	public int cantAlumnos() {
		return (this.alumnos != null && this.alumnos.size() > 0) ? this.alumnos.size() : 0;
	}
	
	

	 
}
