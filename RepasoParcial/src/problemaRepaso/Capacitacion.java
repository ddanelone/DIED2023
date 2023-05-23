package problemaRepaso;

public abstract class Capacitacion {
	public enum Tema {PROGRAMACION, REDES, INFRAESTRUCTURA, IA, GESTION}
	protected String nombre;
	protected boolean prioritaria;
	protected Tema tema;
	
	public Capacitacion(String nombre, boolean prioritaria, Tema tema) {
		super();
		this.nombre = nombre;
		this.prioritaria = prioritaria;
		this.tema = tema;
	}

	protected abstract int cantidadCreditos();
	protected abstract double calcularCosto();
	protected abstract int creditosPorDocente();
	protected abstract Docente docenteConMasCreditos();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isPrioritaria() {
		return prioritaria;
	}

	public void setPrioritaria(boolean prioritaria) {
		this.prioritaria = prioritaria;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	

}
