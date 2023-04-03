package ejercicio03;

public class Producto {
   private String descripcion;
   private double costo;

   public Producto(String desc, double costo) {
      this.descripcion = desc;
      this.costo = costo;
   }

   public Producto() {
      this.descripcion = "";
      this.costo = 0.0;
   }

   public String getDescripcion() {
      return descripcion;
   }

   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }

   public double getCosto() {
      return costo;
   }

   public void setCosto(double costo) {
      this.costo = costo;
   }
   

}
