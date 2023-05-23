package problemaIntegrador;

public abstract class Ubicacion {
    private static int contadorId = 0;
    protected int id;
    protected String nombre;

    public Ubicacion(String nombre) {
        this.id = contadorId++;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}