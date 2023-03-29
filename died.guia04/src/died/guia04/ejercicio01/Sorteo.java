package died.guia04.ejercicio01;


import java.util.ArrayList;
import java.util.Random;

public class Sorteo {
    int semana;
    int anio;
    ArrayList<Apuesta> apuestas;
    private Byte[] sorteo;
    Random generadorAleatorio = new Random();


    public void generarSorteo() {
        this.sorteo = new Byte[6];
;
        for (int i=0; i<6; i++) {
            this.sorteo[i] = (byte) generadorAleatorio.nextInt(0,42);
        }
   }

   public void calcularGanadores() {
    /* Necesito recorrer todo el ArrayList de apuestas y almacenar todos los aciertos que tiene cada apuesta
     * y luego compararlos para ver cual es el mayor, con el mayor hacer una nueva lista con toda la
     * gente que cumpla con la condición  */

   }



}

