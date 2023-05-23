package ejercicio01;

import java.util.Objects;

public class Pasajero {
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String numeroPasaporte;

    public Pasajero(String nombre, String apellido, String correoElectronico, String numeroPasaporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.numeroPasaporte = numeroPasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pasajero)) {
            return false;
        }
        Pasajero pasajero = (Pasajero) obj;
        return Objects.equals(correoElectronico, pasajero.correoElectronico)
                && Objects.equals(numeroPasaporte, pasajero.numeroPasaporte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correoElectronico, numeroPasaporte);
    }
}
