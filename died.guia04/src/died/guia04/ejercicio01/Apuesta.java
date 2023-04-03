package died.guia04.ejercicio01;
import java.util.*;


public class Apuesta {
    private String nombreUsuario;
    private byte[] numerosApostados;

    public Apuesta(String nombreUsuario, byte[] numerosApostados) {
        this.nombreUsuario = nombreUsuario;
        this.numerosApostados = numerosApostados;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getUsuario() {
    	return this.nombreUsuario;
    };

    public byte[] getNumerosApostados() {
        return numerosApostados;
    }

    public void setNumerosApostados(byte[] numerosApostados) {
        this.numerosApostados = numerosApostados;
    }

    public int calcularAciertos(byte[] numerosSorteo) {
        int aciertos = 0;
        for (byte numeroApostado : numerosApostados) {
            if (Arrays.binarySearch(numerosSorteo, numeroApostado) >= 0) {
                aciertos++;
            }
        }
        return aciertos;
    }
}

