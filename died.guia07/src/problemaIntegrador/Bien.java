package problemaIntegrador;

public class Bien {
    private static int contadorId = 1;
    protected int id;
    protected String alias;
    protected String descripcion;
    protected double precio;
    protected Responsable responsable;

    public Bien(String alias, String descripcion, double precio, Responsable responsable) {
        this.id = contadorId++;
        this.alias = alias;
        this.descripcion = descripcion;
        this.precio = precio;
        this.responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public Responsable getResponsable() {
        return responsable;
    }
}