package ejercicio03;


public class App {
   public static void main(String[] args) {
      Producto prod1 = new Producto("Bateria moto", 8700.0);
      Producto prod2 = new Producto("Bateria auto", 12000.0);
      Producto prod3 = new Producto("Bateria camion", 15000.0);
      Producto prod4 = new Producto("Bateria avion", 20000.0);
      Producto prod5 = new Producto("Bateria barco", 25000.0); 
      Pedido p1 = new Basico();
      Pedido p2 = new Premium();
      Tramite tram1 = new Tramite("Inscripcion cursado", "Lavaisse 610");
      Tramite tram2 = new Tramite("Pago cuota Club Banco Provincia", "Obispo Trejo 1000");
       p1.agregarProducto(prod1);
       p1.agregarProducto(prod2);
       p1.agregarProducto(prod3);
       p2.agregarProducto(prod4);
       p2.agregarProducto(prod5);

       
       Cadete cad1 = new Cadete();
       cad1.agregarPedido(p1);
       cad1.agregarPedido(p2);
       cad1.agregarPedido(tram1);
       cad1.agregarPedido(tram2);
       cad1.marcarEntregado(p1);
       cad1.marcarEntregado(p2);
       cad1.marcarRealizado(tram1);
       cad1.marcarRealizado(tram2);
       
       System.out.println("Total Comisiones del cadete 1: " +cad1.totalComisiones());
	}

}
