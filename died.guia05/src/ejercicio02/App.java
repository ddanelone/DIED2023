package ejercicio02;

import java.time.LocalDate;

public class App {

   public static void main(String[] args) {
      LocalDate fecha = LocalDate.now();

      Producto prod1 = new Producto("Bateria moto", 8700.0);
      Producto prod2 = new Producto("Bateria auto", 12000.0);
      Producto prod3 = new Producto("Bateria camion", 15000.0);
      Producto prod4 = new Producto("Bateria avion", 20000.0);
      Producto prod5 = new Producto("Bateria barco", 25000.0); 
      Pedido p1 = new Basico();
       Pedido p2 = new Premium();
       p1.agregarProducto(prod1);
       p1.agregarProducto(prod2);
       p1.agregarProducto(prod3);
       p2.agregarProducto(prod4);
       p2.agregarProducto(prod5);
       
       Cadete cad1 = new Cadete();
       cad1.agregarPedido(p1);
       cad1.agregarPedido(p2);
       cad1.marcarEntregado(p1);
       cad1.marcarEntregado(p2);

       
       System.out.println("Total Comisiones del cadete 1: " +cad1.totalComisiones());
       System.out.println(fecha);  

	}

}
