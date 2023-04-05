package isi.died.taller01;

import java.util.*;

public class Docente {

    private Integer id;
    private String nombre;
    private Double salario;
    private List<Curso> cursosDictados;
    
    public Docente () {
    	 this.cursosDictados = new ArrayList<Curso>();
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
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public List<Curso> getCursosDictados() {
		return cursosDictados;
	}
	public void setCursosDictados(List<Curso> cursosDictados) {
		this.cursosDictados = cursosDictados;
	}    
	
	public int cantidadCursosObligatorios() {
		int cant = 0;
		if (cursosDictados != null && cursosDictados.size() > 0) {
			for (Curso unCurso: cursosDictados) {
				cant += unCurso.tipoCurso() == "OBLIGATORIO" ? 1 : 0;
			}
		}
		return cant;
	}
	
	public int cantidadCursosOptativos() {
		int cant = 0;
		if (cursosDictados != null && cursosDictados.size() > 0) {
			for (Curso unCurso: cursosDictados) {
				cant += unCurso.tipoCurso() == "OPTATIVO" ? 1 : 0;
			}
		}
		return cant;
	}
	
	public void agregarCurso(Curso unCurso) {
		this.cursosDictados.add(unCurso);
	}
	
	public int cantCursos() {
		return this.cursosDictados.size();
	}
	
}
