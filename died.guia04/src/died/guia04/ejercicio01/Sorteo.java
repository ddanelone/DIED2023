package died.guia04.ejercicio01;
import java.util.*;

public class Sorteo {
    private int semana;
    private int anio;
    private List<Apuesta> apuestas;

    public Sorteo(int semana, int anio) {
        this.semana = semana;
        this.anio = anio;
        apuestas = new ArrayList<>();
    }

    public void addApuesta(Apuesta apuesta) {
        apuestas.add(apuesta);
    }

    public byte[] generarSorteo() {
        Random rand = new Random();
        byte[] numerosSorteo = new byte[6];
        for (int i = 0; i < 6; i++) {
            numerosSorteo[i] = (byte) rand.nextInt(43);
        }
        return numerosSorteo;
    }

    public List<Apuesta> calcularGanadores(byte[] numerosSorteo) {
        List<Apuesta> ganadores = new ArrayList<>();
        int maxAciertos = -1;
        for (Apuesta apuesta : apuestas) {
            int aciertos = apuesta.calcularAciertos(numerosSorteo);
            if (aciertos > maxAciertos) {
                maxAciertos = aciertos;
                ganadores.clear();
                ganadores.add(apuesta);
            } else if (aciertos == maxAciertos) {
                ganadores.add(apuesta);
            }
        }
        return ganadores;
    }
}
