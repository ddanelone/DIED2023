package ar.edu.utn.frsf.died.swing.ejemplos;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ejemplo05 {

	/*
	 * 
	 */
	public static void main(String[] args) {
		JFrame jframe = new JFrame("Ejemplo 01");		
		JPanel jpanel = new JPanel(); // agregamos todos los elementos a un panel. Por defecto usa flow layout
		
		// NOTAR EL CAMBIO EN LA VISUALIZACION CON EL SOLO HECHO DE AGREGAR ESTA LINEA
		jpanel.setLayout(new GridLayout(0,2));
		
		
		JLabel labelEt1 = new JLabel("Etiqueta1");
		JLabel labelEt2 = new JLabel("Etiqueta2");
		JTextField txtTexto1 = new JTextField();
		txtTexto1.setColumns(20);
		txtTexto1.setText("un texto");
		JTextArea txtArea1 = new JTextArea();
		txtArea1.setColumns(20);
		txtArea1.setRows(8);
		JButton boton1 = new JButton("UN BOTON ! ");
		jpanel.add(labelEt1);
		jpanel.add(txtTexto1);
		jpanel.add(labelEt2);
		jpanel.add(txtArea1);
		jpanel.add(boton1);
		jframe.add(jpanel); // lo agrega en el centro
		//jframe.setContentPane(jpanel);
		jframe.pack(); //SIN ESTE METODO NO se ve la ventana.
		jframe.setSize(400, 250);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
}