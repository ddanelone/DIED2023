package ar.edu.utn.frsf.died.swing.ejemplos;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class Ejemplo09Componente extends JPanel  {
    Color colorFondo = Color.RED;
    Color colorBorde = Color.GREEN;
    private boolean seleccionado = false;

    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 20;
    private int squareH = 20;
    
	public Dimension getPreferredSize() {
        return new Dimension(450,400);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        Graphics2D g2d = (Graphics2D) g.create();
        dibujarCuadrado(g2d);    	
    }
    
    private void dibujarCuadrado(Graphics2D g2d){
        g2d.drawString("Panel Personalizado!",10,20);
        g2d.setColor(colorFondo);
        g2d.fillRect(squareX,squareY,squareW,squareH);
        g2d.setColor(colorBorde);
        g2d.drawRect(squareX,squareY,squareW,squareH);
    }
    
    public Ejemplo09Componente() {

        setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
            	// si y solo si hice doble click dentro del cuadrado
            	if(event.getX()>=squareX && event.getY()>=squareY){
            		// si fue doble click
                    if (event.getClickCount() == 2) {
                  	  if(colorFondo==Color.RED) colorFondo=Color.BLUE;
                  	  else colorFondo=Color.RED;
                  	  if(colorBorde==Color.GREEN) colorBorde=Color.ORANGE;
                  	  else colorBorde=Color.GREEN;
                  	  // indicamos que se redibuje ahora con otros colores solo el cuadrado
                  	  repaint(squareX,squareY,squareW+1,squareH+1);
                    }                	
                }
            }
            
            public void mouseReleased(MouseEvent e) {
           		seleccionado=false;
            	System.out.println("Mouse soltado");
            }

            
            public void mousePressed(MouseEvent event) {
            	if(!seleccionado) {
            		seleccionado = clickDentroCuadrado(event.getX(), event.getY());
            	}
            	if(seleccionado) moveSquare(event.getX(),event.getY());
            	System.out.println("Mouse presionado");
            }
            
        });
        
        addMouseMotionListener(new MouseAdapter() {
        	public void mouseDragged(MouseEvent event) {
              	if(seleccionado)  moveSquare(event.getX(),event.getY());
           		System.out.println("Arrastrando forma");
            }
        });
            	


    }
    
    private boolean clickDentroCuadrado(int x, int y){
    	return x>=squareX && x<=squareX+squareW && y>=squareY && y<=squareY+squareH ;
    }
    
    private void moveSquare(int x, int y) {
        int OFFSET = 1;
        if ((squareX!=x) || (squareY!=y)) {
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
            squareX=x;
            squareY=y;
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
        } 
    }
}
