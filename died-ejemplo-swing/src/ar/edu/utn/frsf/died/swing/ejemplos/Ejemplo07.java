package ar.edu.utn.frsf.died.swing.ejemplos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ejemplo07 {

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
		gbc.insets = new Insets(2, 10, 2, 5);
		gbc.anchor=GridBagConstraints.LINE_START;
		layoutMgr.setConstraints(labelEt1, gbc);

		JTextField txtTexto1 = new JTextField();
		txtTexto1.setColumns(20);
		txtTexto1.setText("un texto");

		gbc.gridy=0;
		gbc.gridx=1;
		gbc.weightx=1.0;
//	RESETEO PROPIEDADES
		gbc.anchor=GridBagConstraints.CENTER;

		gbc.insets = new Insets(2, 10, 2, 5);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		layoutMgr.setConstraints(txtTexto1, gbc);

		JLabel labelEt2 = new JLabel("Etiqueta2");
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.weightx=0.0;
		layoutMgr.setConstraints(labelEt2, gbc);
		
		JTextArea txtArea1 = new JTextArea();
		txtArea1.setColumns(20);
		txtArea1.setRows(25);
		txtArea1.setText("otro texto texto"+System.getProperty("line.separator")+" Otra linea"+System.getProperty("line.separator")+System.getProperty("line.separator")+"y otra linea mas");

		gbc.gridx=1;
		gbc.gridy=1;
		gbc.weighty=1.0;
		gbc.weightx=1.0;
		layoutMgr.setConstraints(txtArea1, gbc);
		
		JButton boton1 = new JButton("UN BOTON ! ");
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth =2;
		gbc.weightx=0.0;
		gbc.weighty=0.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;

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
