package ejercicio02;

public abstract class Pedido {

   Producto[] productos;

   public Pedido() {
      // TODO Auto-generated constructor stub

   }
   
   public boolean agregarProducto(Producto p) {
      //tengo que iterar todo el arreglo para ver si tengo lugares vacíos y, de ser así, agregarlo en la última posición. Luego, salgo.
      for (int i = 0; i < productos.length; i++) {
         if (productos[i] == null) {
            productos[i] = p;
            return true;
         }
      }
      return false;
   }
   
   public abstract double  precio();

   public abstract double comision();
   
   public double calcularPrecioPedido(int porcentaje) {
      double precio = 0.0;
      for (int i = 0; i < productos.length; i++) {
         if (productos[i] != null) {
            precio += productos[i].getCosto();
         }
      }
      return precio * (1 + porcentaje / 100.0);
   }
 


}
