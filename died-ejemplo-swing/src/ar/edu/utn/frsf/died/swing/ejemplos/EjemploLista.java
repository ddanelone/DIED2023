package ar.edu.utn.frsf.died.swing.ejemplos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class EjemploLista {
    
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

        // JList
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> lista = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(new Dimension(150, 100));
        ventana.add(scrollPane);

        // JComboBox
        String[] peliculas = {
            "Titanic",
            "El Padrino",
            "Pulp Fiction",
            "El Señor de los Anillos",
            "Star Wars",
            "Matrix",
            "El Rey León",
            "Harry Potter",
            "Avatar",
            "Forrest Gump"
        };
        JComboBox<String> comboBox = new JComboBox<>(peliculas);
        ventana.add(comboBox);

        // Botón para agregar elementos a la lista
        JButton agregarBoton = new JButton("Agregar");
        ventana.add(agregarBoton);

        // Acción del botón de agregar
        agregarBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String elemento = (String) comboBox.getSelectedItem();
                listModel.addElement(elemento);
            }
        });

        // Mostrar la ventana
        ventana.setVisible(true);
    }
}
