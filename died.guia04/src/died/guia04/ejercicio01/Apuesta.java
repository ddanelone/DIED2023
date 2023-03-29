package died.guia04.ejercicio01;

public class Apuesta {
    private String nombre;
    private Byte[] arreglo;

    public Apuesta(String nombre) {
        this.nombre = nombre;
        this.arreglo = new Byte[6];
    }

    public int calcularAciertos(byte[] resultados) {
        int aciertos = 0;
        for (int i = 0; i < resultados.length; i++) {
            if (this.presente(resultados[i])) {
                aciertos++;
            }
        }
        return aciertos;
    }
    public boolean presente (byte resultado) {
        int i=0;
        boolean en = false;
        while (!en & i<=this.arreglo.length) {
            if (this.arreglo[i] == resultado) {
                en = true;
            }
            i++;
        }
        return en;
    }

}

