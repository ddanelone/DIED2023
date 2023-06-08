package ar.edu.utn.frsf.died.swing.ejemplos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EjemploConActions {
    public static void main(String[] args) {
        // Crear la ventana
        JFrame ventana = new JFrame("Ejemplo Java Swing");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setLayout(new FlowLayout());

        // Etiqueta
        JLabel etiqueta = new JLabel("¡Hola, soy una etiqueta!");
        ventana.add(etiqueta);

        // Campo de texto
        JTextField campoTexto = new JTextField(15);
        ventana.add(campoTexto);

        // Botón
        JButton boton = new JButton("Haz clic");
        ventana.add(boton);

        // Acción del botón
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textoIngresado = campoTexto.getText();
                etiqueta.setText("Texto ingresado: " + textoIngresado);
            }
        });

        // Cuadro de selección
        String[] opciones = {"Opción 1", "Opción 2", "Opción 3"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        ventana.add(comboBox);

        // Acción del cuadro de selección
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) comboBox.getSelectedItem();
                JOptionPane.showMessageDialog(ventana, "Seleccionaste: " + seleccion);
            }
        });

        // Casilla de verificación
        JCheckBox checkBox = new JCheckBox("Habilitar");
        ventana.add(checkBox);

        // Acción de la casilla de verificación
        checkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean habilitado = checkBox.isSelected();
                campoTexto.setEnabled(habilitado);
                comboBox.setEnabled(habilitado);
                boton.setEnabled(habilitado);
            }
        });

        // Mostrar la ventana
        ventana.setVisible(true);
    }
}
