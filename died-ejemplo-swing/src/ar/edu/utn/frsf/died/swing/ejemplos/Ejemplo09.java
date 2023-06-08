package ar.edu.utn.frsf.died.swing.ejemplos;


import javax.swing.JFrame;

/**
 * Ejemplo de un frame que agrega un panel cuyo dibujo es un 
 * grafico del API Graphics2D realizado por el desarrollador
 * @author DIED
 *
 */
public class Ejemplo09 {

	/*
	 * 
	 */
	public static void main(String[] args) {
		JFrame jframe = new JFrame("Ejemplo Grafico");		
		Ejemplo09Componente mc = new Ejemplo09Componente();
		jframe.add(mc); // lo agrega en el centro
		jframe.pack(); //SIN ESTE METODO NO se ve la ventana.
		jframe.setSize(500, 450);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
}
