package ar.edu.utn.frsf.died.swing.ejemplos;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ejemplo04 {

	/*
	 * PROBLEMA agrega todos los elementos en el centro.
	 * 
	 */
	public static void main(String[] args) {
		JFrame jframe = new JFrame("Ejemplo 01");
		JPanel jpanel = new JPanel(); // agregamos todos los elementos a un panel.
		
		JButton botonArriba = new JButton(" * ARRIBA * ");
		JButton botonAbajo = new JButton(" * ABAJO *  ");
		JButton botonDerecha= new JButton(" * DERECHA * ");
		JButton botonIzquierda= new JButton(" * IZQUIERDA * ");
		JButton botonCentro= new JButton(" * CENTRO * ");
		jframe.add(botonArriba,BorderLayout.NORTH); // lo agrega arriba
		jframe.add(botonIzquierda,BorderLayout.WEST); // lo agrega a izquierda
		jframe.add(botonCentro,BorderLayout.CENTER); // lo agrega al centro
		jframe.add(botonDerecha,BorderLayout.EAST); // lo agrega a derecha
		jframe.add(botonAbajo,BorderLayout.SOUTH); // lo agrega abajo
		//jframe.setContentPane(jpanel);
		jframe.pack(); //SIN ESTE METODO NO se ve la ventana.
		jframe.setSize(400, 250);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
}