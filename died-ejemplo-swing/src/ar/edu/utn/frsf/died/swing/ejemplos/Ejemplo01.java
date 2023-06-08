package ar.edu.utn.frsf.died.swing.ejemplos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ejemplo01 {

	/*
	 * PROBLEMA agrega todos los elementos en el centro.
	 * 
	 */
	public static void main(String[] args) {
		JFrame jframe = new JFrame("Ejemplo 01");
		JLabel labelEt1 = new JLabel("Etiqueta1");
		JLabel labelEt2 = new JLabel("Etiqueta2");
		JTextField txtTexto1 = new JTextField();
		JTextArea txtArea1 = new JTextArea();
		JButton boton1 = new JButton("UN BOTON ! ");
		jframe.add(labelEt1);
		jframe.add(txtTexto1);
		jframe.add(labelEt2);
		jframe.add(txtArea1);
		jframe.add(boton1);
		jframe.pack(); //SIN ESTE METODO NO se ve la ventana.
		jframe.setVisible(true);
	}
}