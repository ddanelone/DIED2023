package ejercicio03;
   import java.util.ArrayList;

   public class Cadete {
      private ArrayList<Comisionable> pedidos;

      public Cadete() {
         this.pedidos = new ArrayList<>();
      }

      public void agregarPedido(Comisionable unPedido) {
         this.pedidos.add(unPedido);
      }

      public double totalComisiones() {
         double total = 0.0;
         for (Comisionable unPedido : pedidos) {
            total += unPedido.comision();
         }
         return total;
      }

      public void marcarEntregado(Pedido unPedido) {
         unPedido.setEntregado();
      }
      
      public void marcarRealizado(Tramite unTramite) {
         unTramite.fechaRealizacion();
      }
   }
