package ar.edu.utn.frsf.died.swing.ejemplos;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * En este ejemplo se verá la diferencia entre ejecutar una tarea en un hilo
 * secundario o en el hilo principal que se encarga de dibujar la interface
 * 
 * @author Administrador
 *
 */
public class Ejemplo10 {
	JFrame ventana;
	JButton boton1;
	JButton boton2;
	JLabel etiqueta;
	JPanel panelDeContenido;

	public static void main(String[] args) {
		Ejemplo10 ejemplo = new Ejemplo10();
		ejemplo.armarVentanas();
	}

	public void armarVentanas() {
		ventana = new JFrame("Ejemplo Tarea Larga 1");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boton1 = new JButton("Botón Que Bloquea Todo");
		boton2 = new JButton("Botón Que NO Bloquea NADA ");
		etiqueta = new JLabel(
				"EJEMPLO.......presione uno de los botones para ver la diferencia");
		
		boton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				etiqueta.setText("Ha comenzado la tarea Que Bloquea TODO");
				ejecutaTareaLarga();
				etiqueta.setText("Ha finalizado la tarea Que bloquea TODO. Vio la interface bloqueada durante 5 segundos");
				// que se reacomode la ventana para dibujar la nueva longitud del mensaje
				ventana.pack();
			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etiqueta.setText("Ha comenzado la tarea Que NO Bloquea NADA");
				new Thread() {
					public void run() {
						ejecutaTareaLarga();
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								etiqueta.setText("Ha finalizado la tarea Que NO Bloquea NADA");
								// que se reacomode la ventana para dibujar la nueva longitud del mensaje
								ventana.pack();
							}
						});
					}
				}.start();
			
			}
		});

		panelDeContenido = new JPanel();
		// seteo el panel como panel principal
		ventana.setContentPane(panelDeContenido);
		panelDeContenido.add(boton1);
		panelDeContenido.add(etiqueta);
		panelDeContenido.add(boton2);
		ventana.setVisible(true);
		ventana.pack();
	}

	public void ejecutaTareaLarga() {
		// este codigo pasa al proceso inactivo durante 5 segundos, simulando
		// ser una tarea "larga" como una
		// conexion a una base de datos o a un nodo remoto
		try {
			System.out.println("INICIA ....");
			etiqueta.setText("INICIA ....");
			Thread.sleep(5000);
			System.out.println("Pasaron 5 segundos");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
