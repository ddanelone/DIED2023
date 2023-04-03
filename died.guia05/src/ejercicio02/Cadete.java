package ejercicio02;
   import java.util.ArrayList;

   public class Cadete {
      private ArrayList<Pedido> pedidos;

      public Cadete() {
         this.pedidos = new ArrayList<>();
      }

      public void agregarPedido(Pedido unPedido) {
         this.pedidos.add(unPedido);
      }

      public double totalComisiones() {
         double total = 0.0;
         for (Pedido unPedido : pedidos) {
            total += unPedido.comision();
         }
         return total;
      }


   }
