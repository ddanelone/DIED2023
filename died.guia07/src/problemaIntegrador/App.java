package problemaIntegrador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Crear objetos de prueba
        Localidad localidad1 = new Localidad("Ciudad A", new Provincia("Provincia A", new Pais("País A")));
        Localidad localidad2 = new Localidad("Ciudad B", new Provincia("Provincia B", new Pais("País B")));
        Responsable responsable1 = new Responsable("Responsable 1", localidad1, "Oficina 1");
        Responsable responsable2 = new Responsable("Responsable 2", localidad2, "Oficina 2");
        Proveedor proveedor1 = new Proveedor("Proveedor 1", localidad1);
        Proveedor proveedor2 = new Proveedor("Proveedor 2", localidad2);
        Bien bien1 = new Bien("Bien 1", "Descripción 1", 100.0, responsable1);
        Bien bien2 = new Bien("Bien 2", "Descripción 2", 200.0, responsable1);
        Bien bien3 = new Bien("Bien 3", "Descripción 3", 300.0, responsable2);
        Bien bien4 = new Bien("Bien 4", "Descripción 4", 400.0, responsable2);
        List<Bien> bienesProveedor1 = new ArrayList<>();
        bienesProveedor1.add(bien1);
        bienesProveedor1.add(bien2);
        List<Bien> bienesProveedor2 = new ArrayList<>();
        bienesProveedor2.add(bien3);
        bienesProveedor2.add(bien4);
        Date fecha1 = new Date();
        Date fecha2 = new Date();

        Factura factura1 = new Factura(500.0, bienesProveedor1, responsable1, proveedor1, fecha1);
        Factura factura2 = new Factura(600.0, bienesProveedor2, responsable2, proveedor2, fecha2);

        Empresa empresa = new Empresa();
        empresa.agregarProveedor(proveedor1);
        empresa.agregarProveedor(proveedor2);
        empresa.agregarResponsable(responsable1);
        empresa.agregarResponsable(responsable2);
        empresa.agregarBien(bien1);
        empresa.agregarBien(bien2);
        empresa.agregarBien(bien3);
        empresa.agregarBien(bien4);
        empresa.agregarFactura(factura1);
        empresa.agregarFactura(factura2);

        // Pruebas de los métodos de la clase Empresa
        System.out.println("Facturas del proveedor 1:");
        ArrayList<Factura> facturasProveedor1 = empresa.listarFacturaByProveedor(proveedor1);
        for (Factura factura : facturasProveedor1) {
            System.out.println("ID: " + factura.getId() + ", Monto Total: " + factura.getMontoTotal());
        }

        System.out.println("\nFacturas del responsable 2:");
        ArrayList<Factura> facturasResponsable2 = empresa.listarFacturaByResponsable(responsable2);
        for (Factura factura : facturasResponsable2) {
            System.out.println("ID: " + factura.getId() + ", Monto Total: " + factura.getMontoTotal());
        }

        System.out.println("\nNombres de proveedores en la localidad " + localidad1.getNombre() + ":");
        ArrayList<String> nombresProveedores = empresa.listarNombresProveedores(localidad1);
        for (String nombre : nombresProveedores) {
            System.out.println(nombre);
        }

        System.out.println("\nBienes solicitados por responsables en la localidad " + localidad2.getNombre() + ":");
        ArrayList<Bien> bienesLocalidad2 = empresa.listarBienesByLocalidad(localidad2);
        for (Bien bien : bienesLocalidad2) {
            System.out.println("ID: " + bien.getId() + ", Alias: " + bien.getAlias());
        }

        double precioMayor = 250.0;
        System.out.println("\nBienes con precio mayor a " + precioMayor + ":");
        ArrayList<Bien> bienesPrecioMayor = empresa.listarBienesByPrecioMayor(precioMayor);
        for (Bien bien : bienesPrecioMayor) {
            System.out.println("ID: " + bien.getId() + ", Alias: " + bien.getAlias() + ", Precio: " + bien.getPrecio());
        }

        double montoMayor = 550.0;
        System.out.println("\nFacturas con monto total mayor a " + montoMayor + ":");
        ArrayList<Factura> facturasMontoMayor = empresa.listarFacturasByMontoMayor(montoMayor);
        for (Factura factura : facturasMontoMayor) {
            System.out.println("ID: " + factura.getId() + ", Monto Total: " + factura.getMontoTotal());
        }

        System.out.println("\nFacturas facturadas por el proveedor 2:");
        ArrayList<String> facturasProveedor2 = empresa.listarFacturasPorProveedor(proveedor2);
        for (String descripcion : facturasProveedor2) {
            System.out.println(descripcion);
        }
    }
}