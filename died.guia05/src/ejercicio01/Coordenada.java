package ejercicio01;

public class Coordenada {
	public Double latitud;
	public Double longitud;
	
	public Coordenada(Double lat, Double lng) {
		this.latitud = lat;
		this.longitud = lng;
	}
	
	public Coordenada() {
		this.latitud= 0.0;
		this.longitud=0.0;
	}
	
	@Override
	public boolean equals (Object obj) {
		if (this == obj ) return true;
		if (obj == null) return false;
		
		Coordenada otra = (Coordenada) obj;
		if(this.latitud == 0.0) {
			if (otra.latitud != 0.0) return false;
		} else if (!this.latitud.equals(otra.latitud)) return false;
		
		if(this.longitud == 0.0) {
			if (otra.longitud != 0.0) return false;
		} else if (!this.longitud.equals(otra.longitud)) return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Coordenadas[ Latitud ---> " + this.latitud + ", Longitud ---> "+ this.longitud + " ]";
	}

	public Double  getLatitud() {
		// TODO Auto-generated method stub
		return this.latitud;
	}
	
	public Double getLongitud() {
		return this.longitud;
	}
	
}
