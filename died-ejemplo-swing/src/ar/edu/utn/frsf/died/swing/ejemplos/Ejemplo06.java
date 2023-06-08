package ar.edu.utn.frsf.died.swing.ejemplos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ejemplo06 {

	/*
	 * 
	 */
	public static void main(String[] args) {
		JFrame jframe = new JFrame("Ejemplo 01");		
		JPanel jpanel = new JPanel(); // agregamos todos los elementos a un panel. Por defecto usa flow layout
		
		// NOTAR EL CAMBIO EN LA VISUALIZACION CON EL SOLO HECHO DE AGREGAR ESTA LINEA
		GridBagLayout layoutMgr = new GridBagLayout();
		jpanel.setLayout(layoutMgr);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel labelEt1 = new JLabel("Etiqueta1");
		gbc.gridx=0;
		gbc.gridy=0;
		layoutMgr.setConstraints(labelEt1, gbc);

		JTextField txtTexto1 = new JTextField();
		txtTexto1.setColumns(20);
		txtTexto1.setText("un texto");

		gbc.gridy=0;
		gbc.gridx=1;
		layoutMgr.setConstraints(txtTexto1, gbc);

		JLabel labelEt2 = new JLabel("Etiqueta2");
		gbc.gridx=0;
		gbc.gridy=1;
		layoutMgr.setConstraints(labelEt2, gbc);
		
		JTextArea txtArea1 = new JTextArea();
		txtArea1.setColumns(20);
		txtArea1.setRows(8);
		gbc.gridx=1;
		gbc.gridy=1;
		layoutMgr.setConstraints(txtArea1, gbc);
		
		JButton boton1 = new JButton("UN BOTON ! ");
		gbc.gridx=0;
		gbc.gridy=2;
		layoutMgr.setConstraints(boton1, gbc);
		
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