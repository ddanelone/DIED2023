package problemaIntegrador;

import java.util.List;
import java.util.ArrayList;

class Proveedor extends Persona {
    private List<Bien> bienes;

    public Proveedor(String nombre, Localidad localidad) {
        super(nombre, localidad);
        bienes = new ArrayList<>();
    }

    public void agregarBien(Bien bien) {
        bienes.add(bien);
    }

    public List<Bien> getBienes() {
        return bienes;
    }
}