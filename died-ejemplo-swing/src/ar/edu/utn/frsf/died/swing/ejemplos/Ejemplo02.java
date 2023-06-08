package ar.edu.utn.frsf.died.swing.ejemplos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ejemplo02 {

	/*
	 * PROBLEMA agrega todos los elementos en el centro.
	 * 
	 */
	public static void main(String[] args) {
		JFrame jframe = new JFrame("Ejemplo 01");
		JPanel jpanel = new JPanel(); // agregamos todos los elementos a un panel.
		
		JLabel labelEt1 = new JLabel("Etiqueta1");
		JLabel labelEt2 = new JLabel("Etiqueta2");
		JTextField txtTexto1 = new JTextField();
		txtTexto1.setColumns(20);
		txtTexto1.setText("un texto");
		JTextArea txtArea1 = new JTextArea();
		txtArea1.setColumns(20);
		txtArea1.setRows(8);
		txtArea1.setText("otro texto texto"+System.getProperty("line.separator")+" Otra linea"+System.getProperty("line.separator")+System.getProperty("line.separator")+"y otra linea mas");
		JButton boton1 = new JButton("UN BOTON ! ");
		boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acciones a realizar cuando se hace clic en el botón
                JOptionPane.showMessageDialog(null, "¡Haz hecho clic en el botón!");
            }
        });
		jpanel.add(labelEt1);
		jpanel.add(txtTexto1);
		jpanel.add(labelEt2);
		jpanel.add(txtArea1);
		jpanel.add(boton1);
		jframe.add(jpanel);
		//jframe.setContentPane(jpanel);
		jframe.pack(); //SIN ESTE METODO NO se ve la ventana.
		jframe.setVisible(true);
	}
}