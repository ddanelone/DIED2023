package died.guia04.ejercicio01;
import java.util.*;

public class App {

	public static void main(String[] args) {
		Apuesta apuesta1 = new Apuesta("Juan", new byte[]{1, 2, 3, 4, 5, 6});
        Apuesta apuesta2 = new Apuesta("Pedro", new byte[]{7, 8, 9, 10, 11, 12});
        Apuesta apuesta3 = new Apuesta("María", new byte[]{13, 14, 15, 16, 17, 18});
        Apuesta apuesta4 = new Apuesta("Ana", new byte[]{19, 20, 21, 22, 23, 24});

	    Sorteo sorteo = new Sorteo(1, 2023);
	    sorteo.addApuesta(apuesta1);
	    sorteo.addApuesta(apuesta2);
	    sorteo.addApuesta(apuesta3);
	    sorteo.addApuesta(apuesta4);

	    byte[] numerosSorteo = sorteo.generarSorteo();
	    List<Apuesta> ganadores = sorteo.calcularGanadores(numerosSorteo);

	    System.out.println("Numersos del sorteo: ");
	    for (byte numero : numerosSorteo) {
	         System.out.print(numero + " ");
	    }
	    System.out.println();

	     if (ganadores.isEmpty()) {
	          System.out.println("No hubo ganadores");
	     } else {
	    	 System.out.println("Ganadores con " + ganadores.get(0).calcularAciertos(numerosSorteo) + " aciertos:");
	    	 for (Apuesta ganador : ganadores) {
	    	     System.out.println(ganador.getUsuario() + ": " + ganador.calcularAciertos(numerosSorteo) + " aciertos");
	    	 }
	       }
	   }
}


