package ejercicio01;

import java.util.ArrayList;

public class Camino {
	private ArrayList<Coordenada> listaCoordenadas;
	
	public Camino() {
		this.listaCoordenadas = new ArrayList<>();
	}
	
	public void agregar(Coordenada x) {
		this.listaCoordenadas.add(x);
	}
	
	public void agregar(Double lat, Double lng) {
		Coordenada coord = new Coordenada(lat, lng);
		this.listaCoordenadas.add(coord);
	}
	
	public void agregar(int mtsLt, int mtsLn) {
	    listaCoordenadas.add(convertir(mtsLt,mtsLn));
	}
	
	public Coordenada convertir(int mtsLt, int mtsLn) {
		double refLat = -31.610657; // latitud de referencia Santa Fe Capital
	    double refLon = -60.697294; // longitud de referencia Santa Fe Capital

	    double lat = refLat + (mtsLt / 111000.0);
	    double lon = refLon + (mtsLn / (111000.0 * Math.cos(refLat)));
 
	    Coordenada coord = new Coordenada(lat, lon);
	    return coord;
	    
	}
	
	public ArrayList<Coordenada>  buscar(Coordenada no,Coordenada se) {
		//retorna todos los puntos del camino que se encuentran dentro del limite establecido por la coordenada no 
		//(noroeste, es decir el límite superior izquierdo) y la coordenada se (sureste, es decir el limite inferior derecho)
		ArrayList<Coordenada> coordenadasQueCumplen;
		coordenadasQueCumplen = new ArrayList<>();
		if (this.existeCamino()) {
			for (Coordenada unaCoordenada : this.listaCoordenadas) {
				
				Double latitud = unaCoordenada.getLatitud();
				Double longitud = unaCoordenada.getLongitud();
				Double latNo = no.getLatitud();
				Double longNo = no.getLongitud();
				Double latSe = se.getLatitud();
				Double longSe = se.getLongitud();
				
				if ((latitud <= latNo && latitud >= latSe) && (longitud >= longNo && longitud <= longSe)) coordenadasQueCumplen.add(unaCoordenada);		
			}
		}
		return coordenadasQueCumplen;
	}
	
	public ArrayList<Coordenada>  buscar(Coordenada coord,int metros) {
		//Sugerencia puede usar el método del punto f inciso 3 para calcular los límites NO y SE (simplemente sumar metros en latitud 
		//y restar en longitud para obtener el limite NO, y restar metros en latitdud y sumarlos en longitud para calcular el 
		//límite SE) y luego invocar al método del inciso g.
		Coordenada no = this.convertir(metros, -metros);
        Coordenada se = this.convertir(-metros, metros);
        
        return buscar(no,se);
	}
	

	public boolean existeCamino() {
		return (this.listaCoordenadas != null && this.listaCoordenadas.size() > 0);
	}
	
	public void mostrarCamino() {
		if (existeCamino() && listaCoordenadas.size() > 0) {
			int i=1;
			for (Coordenada unaCoordenada: listaCoordenadas) {
				System.out.println("Paso " + i +": " + 	unaCoordenada.toString());
				i++;
			}
		}
	}
	

}
