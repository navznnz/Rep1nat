import java.util.Scanner;

public class BurbujaOrdenacion {

    // Método que implementa el algoritmo de ordenamiento burbuja
    public static void bubbleSort(int[] arreglo) {
        int n = arreglo.length;
        boolean intercambio;

        for (int i = 0; i < n - 1; i++) {
            intercambio = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambiar elementos
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    intercambio = true;
                }
            }

            // Si no hubo intercambio en la pasada, el arreglo ya está ordenado
            if (!intercambio) {
                break;
            }
        }
    }

    // Método para imprimir el arreglo
    public static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos: ");
        int n = scanner.nextInt();

        int[] arreglo = new int[n];

        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            arreglo[i] = scanner.nextInt();
        }

        System.out.println("\nArreglo original:");
        imprimirArreglo(arreglo);

        // Ordenar usando burbuja
        bubbleSort(arreglo);

        System.out.println("\nArreglo ordenado con burbuja:");
        imprimirArreglo(arreglo);

        scanner.close();
    }
}
