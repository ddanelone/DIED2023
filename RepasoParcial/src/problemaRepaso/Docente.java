package problemaRepaso;

public class Docente {
	private String nombre;
	private String email;
	private int antiguedad;
	private double costoHora;
	
	public Docente(String nombre, String email, int antiguedad, double costoHora) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.antiguedad = antiguedad;
		this.costoHora = costoHora;
	}	
	
	public Docente() {}


	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAntiguedad() {
		return antiguedad;
	}
	
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	public double getCostoHora() {
		return costoHora;
	}
	
	public void setCostoHora(double costoHora) {
		this.costoHora = costoHora;
	}
}
