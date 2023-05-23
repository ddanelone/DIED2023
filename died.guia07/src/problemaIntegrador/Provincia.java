package problemaIntegrador;

public class Provincia extends Ubicacion {
    private Pais pais;

    public Provincia(String nombre, Pais pais) {
        super(nombre);
        this.pais = pais;
    }

    public Pais getPais() {
        return pais;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) obj;
        return nombre.equals(other.nombre) && pais.equals(other.pais);
    }
}