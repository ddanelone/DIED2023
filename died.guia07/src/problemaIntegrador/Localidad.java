package problemaIntegrador;

public class Localidad extends Ubicacion {
    private Provincia provincia;

    public Localidad(String nombre, Provincia provincia) {
        super(nombre);
        this.provincia = provincia;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) obj;
        return nombre.equals(other.nombre) && provincia.equals(other.provincia);
    }

    public boolean equalsTo(Localidad localidad) {
        return nombre.equals(localidad.getNombre()) && provincia.equals(localidad.getProvincia());
    }
}