package problemaIntegrador;

public abstract class Persona implements CriterioBusqueda<Localidad> {
    private static int contadorId = 1;
    protected int id;
    protected String nombre;
    protected Localidad localidad;

    public Persona(String nombre, Localidad localidad) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    @Override
    public boolean esDeLocalidad(Localidad l) {
        return localidad.equalsTo(l);
    }
}