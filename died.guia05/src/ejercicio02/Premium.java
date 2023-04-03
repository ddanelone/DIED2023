package ejercicio02;

public class Premium extends Pedido {

   public Premium() {
      this.productos = new Producto[20];

   }

   @Override
   public double precio() {
      return this.calcularPrecioPedido(20);
   }

   @Override  //sobreescribo el método original porque necesito que varíe el porcentaje según la cantidad de productos
   public double calcularPrecioPedido(int porcentaje) {
      double precio = 0.0;
      for (int i = 0; i < productos.length; i++) {
         if (i == 5)
            porcentaje = 30;
         if (productos[i] != null) {
            precio += (productos[i].getCosto()) * (1 + porcentaje / 100.0);
         }
      }
      System.out.println("Total pedido: " + precio);
      return precio;
   }

   @Override
   public double comision() {
      double total = 0.0;
      if (this.fecha != null) {
         if (this.productos != null && this.productos.length < 10)
            total = this.precio() * 20.0 / 100.0;
         else if (this.productos != null && this.productos.length >= 10) {
            total = (this.precio() * 15.0 / 100.0) + 50.0;
         }
         System.out.println("Total comision: " + total);
      }
        return total;
   }
 }
