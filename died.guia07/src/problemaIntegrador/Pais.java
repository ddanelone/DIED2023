package problemaIntegrador;

public class Pais extends Ubicacion {
    public Pais(String nombre) {
        super(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) obj;
        return nombre.equals(other.nombre);
    }
}