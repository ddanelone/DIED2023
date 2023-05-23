package problemaIntegrador;

import java.util.Date;
import java.util.List;

public class Factura implements Comparable<Factura> {
    private static int contadorId = 1;
    protected int id;
    protected double montoTotal;
    protected List<Bien> bienes;
    protected Responsable responsable;
    protected Proveedor proveedor;
    protected Date fecha;

    public Factura(double montoTotal, List<Bien> bienes, Responsable responsable, Proveedor proveedor, Date fecha) {
        this.id = contadorId++;
        this.montoTotal = montoTotal;
        this.bienes = bienes;
        this.responsable = responsable;
        this.proveedor = proveedor;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public List<Bien> getBienes() {
        return bienes;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public int compareTo(Factura other) {
        return other.fecha.compareTo(this.fecha);
    }
}