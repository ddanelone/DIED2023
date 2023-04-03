package ejercicio01;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coordenada c1 = new Coordenada(1.0,15.0);
		Coordenada c2 = new Coordenada(3.0,15.0);
		Coordenada c3 = new Coordenada(5.0,12.0);
		Coordenada c4 = new Coordenada(8.0,10.0);
		Coordenada c5 = new Coordenada(10.0,10.0);
		Coordenada c6 = new Coordenada(15.0,5.0);
		Coordenada c7 = new Coordenada(10.0,12.0);
		Coordenada c8 = new Coordenada(8.0,8.0);
		Coordenada c9 = new Coordenada(0.0,12.0);
		Coordenada c10 = new Coordenada(15.0,15.0);
		
		Camino cam1 = new Camino();
		cam1.agregar(c1);
		cam1.agregar(c2);
		cam1.agregar(c3);
		cam1.agregar(c4);
		cam1.agregar(c5);
		cam1.agregar(15.0,15.0);
		cam1.agregar(100,1200);
		cam1.mostrarCamino();
		System.out.println(cam1.buscar(c5, c1));
		System.out.println(cam1.buscar(c5, 1200));
		
		

	}

}
