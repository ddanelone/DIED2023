package Ejercicio3;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Se encontró el elemento
            } else if (arr[mid] < target) {
                left = mid + 1; // Buscar en la mitad derecha
            } else {
                right = mid - 1; // Buscar en la mitad izquierda
            }
        }

        return -1; // No se encontró el elemento
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
        int target = 39;

        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Elemento encontrado en el índice " + index);
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
}
