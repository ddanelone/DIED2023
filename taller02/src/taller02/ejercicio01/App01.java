package taller02.ejercicio01;

public class App01 {

	// TODO: crear las instancias necesarias para probar los 3 items anteriores y el manejo de excepciones apropiado
	public static void main(String[] args) {
		ArbolVacio av1 = new ArbolVacio();
		ArbolVacio av2 = new ArbolVacio();
		ArbolBinarioBusqueda abb5 = new ArbolBinarioBusqueda("A5");
		ArbolBinarioBusqueda abb4 = new ArbolBinarioBusqueda("A4");
		ArbolBinarioBusqueda abb1 = new ArbolBinarioBusqueda("A1");
		ArbolBinarioBusqueda abb2 = new ArbolBinarioBusqueda("A2");
		ArbolBinarioBusqueda abb3 = new ArbolBinarioBusqueda("A3", abb5, abb4);
		ArbolBinarioBusqueda abb6 = new ArbolBinarioBusqueda("A6", abb1, abb2);
		ArbolBinarioBusqueda abbR = new ArbolBinarioBusqueda("A7", abb3, abb6);
		
		ArbolBinarioBusqueda abbZ3 = new ArbolBinarioBusqueda("Z3", abb5, abb4);
		ArbolBinarioBusqueda abbZ6 = new ArbolBinarioBusqueda("Z6", abb1, av1);
		ArbolBinarioBusqueda abbZ = new ArbolBinarioBusqueda("Z7", abbZ3, abbZ6);

		
		
		//Primer método prueba
		System.out.println("Es hoja A1? " + abb1.esHoja());
		System.out.println("Es hoja A6? " + abb6.esHoja());
		
		//Segundo método prueba
		System.out.println("Cantidad de nodos A7: " + abbR.cantidadNodos());
		System.out.println("Cantidad de nodos A5: " + abb5.cantidadNodos());
		
		//Último método prueba
		System.out.println("Es zurdo A7? " + abbR.esZurdo());
		System.out.println("Es zurdo Z7? " + abbZ.esZurdo());
	}

}
