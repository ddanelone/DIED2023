package Ejercicio3;

public class BinarySearchRecursiva {
	public static int buscar(int[] vector, int elemento) {
        return buscarRecursivo(vector, elemento, 0, vector.length - 1);
    }

    private static int buscarRecursivo(int[] vector, int elemento, int inicio, int fin) {
        if (inicio > fin) {
            // El elemento no se encuentra en el vector
            return -1;
        }

        int medio = (inicio + fin) / 2;

        if (vector[medio] == elemento) {
            // El elemento se encuentra en el índice medio
            return medio;
        } else if (vector[medio] > elemento) {
            // El elemento puede estar en la mitad izquierda del vector
            return buscarRecursivo(vector, elemento, inicio, medio - 1);
        } else {
            // El elemento puede estar en la mitad derecha del vector
            return buscarRecursivo(vector, elemento, medio + 1, fin);
        }
    }

    public static void main(String[] args) {
        int[] vector = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int elemento = 20;

        int indice = buscar(vector, elemento);

        if (indice != -1) {
            System.out.println("El elemento " + elemento + " se encuentra en el índice " + indice);
        } else {
            System.out.println("El elemento " + elemento + " no se encuentra en el vector");
        }
    }
}
