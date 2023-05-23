package problemaRepaso;

public class Taller extends Capacitacion{
	private int duracion;
	private double costoPorHora;
	private int cupoMaximo;
	private int cantInscriptos;
	
	public Taller(String nombre, boolean prioritaria, Tema tema, int duracion, double costoPorHora, int cupoMaximo,
			int cantInscriptos) {
		super(nombre, prioritaria, tema);
		this.duracion = duracion;
		this.costoPorHora = costoPorHora;
		this.cupoMaximo = cupoMaximo;
		this.cantInscriptos = cantInscriptos;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getCostoPorHora() {
		return costoPorHora;
	}

	public void setCostoPorHora(double costoPorHora) {
		this.costoPorHora = costoPorHora;
	}

	public int getCupoMaximo() {
		return cupoMaximo;
	}

	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	public int getCantInscriptos() {
		return cantInscriptos;
	}

	public void setCantInscriptos(int cantInscriptos) {
		this.cantInscriptos = cantInscriptos;
	}
	
	@Override
	public int cantidadCreditos() {
		int creditos;
		creditos = this.getDuracion() /6;
		creditos = creditos > 12 ? 12 : creditos;
		creditos = this.isPrioritaria() ? creditos++ : creditos;
		return creditos;
	}
	
	@Override
	public double calcularCosto() {
		double costo =0;
		costo = this.duracion * this.costoPorHora;
		return (this.isPrioritaria() ? costo *  1.20 : costo);
	}
	
	@Override
	public int creditosPorDocente(){
		return 0;
	}
	
	@Override
	public Docente docenteConMasCreditos() {
		return null;		
	}
	

}
