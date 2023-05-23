package problemaRepaso;

import java.util.List;
import java.util.ArrayList;

public class Curso extends Capacitacion{
		
	private Docente docente;
	private List<Clase> listaClases;
	private int creditosRequeridos;
	
	public Curso(String nombre, boolean prioritaria, Tema tema, Docente docente, int creditos) {
		super(nombre, prioritaria, tema);
		this.docente = docente;
		this.creditosRequeridos=creditos;
		listaClases = new ArrayList<Clase>();
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public List<Clase> getListaClases() {
		return listaClases;
	}

	public void setListaClases(List<Clase> listaClases) {
		this.listaClases = listaClases;
	}

	public int getCreditosRequeridos() {
		return creditosRequeridos;
	}

	public void setCreditosRequeridos(int creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}
	
	@Override
	public int cantidadCreditos () {
		int creditos = 0;
		
		for (Clase unaClase: listaClases) {
			creditos = creditos +2;
			if (creditos >= 10 ) {
				creditos =10;
				break;
			}
		}
		
		int antiguedad = this.docente.getAntiguedad();
		if (antiguedad <= 5) creditos++;
		else if(antiguedad <= 15) creditos = creditos + 3;
		else creditos = creditos + 5;
		
		creditos = this.isPrioritaria() ? creditos++ : creditos;
			
		return creditos;		
	}
	
	@Override
	public double calcularCosto() {
		double costo = 0;

		for (Clase unaClase: listaClases) {
			costo = unaClase.getDuracion() * this.docente.getCostoHora();
			costo = (this.isPrioritaria() ?  costo * 1.10 : costo);
			
		}		
		
		return costo;
	}
	
	@Override
	public int creditosPorDocente() {
		return this.getCreditosRequeridos();
	}
	
	@Override
	public Docente docenteConMasCreditos() {
		return this.docente;
		
	}


}
