package problemaIntegrador;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Empresa {
    private List<Proveedor> proveedores;
    private List<Responsable> responsables;
    private List<Bien> bienes;
    private List<Factura> facturas;

    public Empresa() {
        proveedores = new ArrayList<>();
        responsables = new ArrayList<>();
        bienes = new ArrayList<>();
        facturas = new ArrayList<>();
    }

    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public void agregarResponsable(Responsable responsable) {
        responsables.add(responsable);
    }

    public void agregarBien(Bien bien) {
        bienes.add(bien);
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    public ArrayList<Factura> listarFacturaByProveedor(Proveedor p) {
        ArrayList<Factura> facturasProveedor = new ArrayList<>();
        for (Factura factura : facturas) {
            if (factura.getProveedor().equals(p)) {
                facturasProveedor.add(factura);
            }
        }
        return facturasProveedor;
    }

    public ArrayList<Factura> listarFacturaByResponsable(Responsable r) {
        ArrayList<Factura> facturasResponsable = new ArrayList<>();
        for (Factura factura : facturas) {
            if (factura.getResponsable().equals(r)) {
                facturasResponsable.add(factura);
            }
        }
        return facturasResponsable;
    }

    public ArrayList<String> listarNombresProveedores(Localidad localidad) {
        ArrayList<String> nombresProveedores = new ArrayList<>();
        for (Proveedor proveedor : proveedores) {
            if (proveedor.esDeLocalidad(localidad)) {
                nombresProveedores.add(proveedor.getNombre());
            }
        }
        Collections.sort(nombresProveedores);
        return nombresProveedores;
    }

    public ArrayList<Bien> listarBienesByLocalidad(Localidad localidad) {
        ArrayList<Bien> bienesResponsables = new ArrayList<>();
        for (Responsable responsable : responsables) {
            if (responsable.esDeLocalidad(localidad)) {
                for (Bien bien : bienes) {
                    if (bien.getResponsable().equals(responsable)) {
                        bienesResponsables.add(bien);
                    }
                }
            }
        }
        return bienesResponsables;
    }

    public ArrayList<Bien> listarBienesByPrecioMayor(double precioMayor) {
        ArrayList<Bien> bienesPrecioMayor = new ArrayList<>();
        for (Bien bien : bienes) {
            if (bien.getPrecio() > precioMayor) {
                bienesPrecioMayor.add(bien);
            }
        }
        return bienesPrecioMayor;
    }

    public ArrayList<Factura> listarFacturasByMontoMayor(double montoMayor) {
        ArrayList<Factura> facturasMontoMayor = new ArrayList<>();
        for (Factura factura : facturas) {
            if (factura.getMontoTotal() > montoMayor) {
                facturasMontoMayor.add(factura);
            }
        }
        return facturasMontoMayor;
    }

    public ArrayList<String> listarFacturasPorProveedor(Proveedor p) {
        ArrayList<String> facturasProveedor = new ArrayList<>();
        for (Factura factura : facturas) {
            if (factura.getProveedor().equals(p)) {
                String descripcion = "En la fecha " + factura.getFecha() + ", " + factura.getProveedor().getNombre()
                        + " facturó con un total de $" + factura.getMontoTotal() + " con " + factura.getBienes().size() + " bienes";
                facturasProveedor.add(descripcion);
            }
        }
        Collections.sort(facturasProveedor, Collections.reverseOrder());
        return facturasProveedor;
    }
}