package ejercicio03;

import java.time.LocalDate;

public class Tramite implements Comisionable {
   private String descripcion;  //lo dejé así.
   private String domicilio;
   private LocalDate fecha;

   public Tramite(String descripcion, String domicilio) {
      this.descripcion = descripcion;
      this.domicilio = domicilio;
      this.fecha = null;
   }

   public LocalDate getFecha() {
      return fecha;
   }

   public void fechaRealizacion() {
      this.fecha = LocalDate.now();
   }

   @Override
   public double comision() {
      if (this.fecha == null)
         return 0.0;
      else 
      return 5.0;
   }

   @Override
   public double precio() {
      return 20.0;
   }
   
}
