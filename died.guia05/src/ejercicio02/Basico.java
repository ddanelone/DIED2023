package ejercicio02;

public class Basico extends Pedido {

   boolean express;

   public Basico() {
      this.productos = new Producto[5];
      this.express = false;
   }

   public void setExpress() {
      this.express = true;
   }

   @Override
   public double precio() {
      //calcular el 26% es equivalente a aplicar primero 5% y luego 20%
      if (this.express)
         System.out.println("Total pedido: " + this.calcularPrecioPedido(26));
      else 
         System.out.println("Total pedido: " + this.calcularPrecioPedido(5));
      return this.express ? super.calcularPrecioPedido(26) : super.calcularPrecioPedido(5); 
   }

   @Override
   public double comision() {
      System.out.println("Total comision: " + this.precio() * 10.0 /100.0);
      return this.precio() * 10.0 /100.0;
   }

}
