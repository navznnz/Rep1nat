import java.util.Arrays;
import java.util.Random;

public class Carrera {
    public static void main(String[] args) {
        int competidores = 5;
        int vueltas = 3;

        // Generar tiempos aleatorios
        double[][] tiempos = generarTiempos(competidores, vueltas);

        // Tiempos originales
        System.out.println("=== Tiempos originales ===");
        for (int i = 0; i < tiempos.length; i++) {
            System.out.println("Competidor " + (i + 1) + ": " + Arrays.toString(tiempos[i]));
        }

        // Ordenar cada vuelta con un método distinto
        for (int v = 0; v < vueltas; v++) {
            if (v == 0) {
                insercion(tiempos, v);
                System.out.println("\nOrden de la vuelta " + (v + 1) + " (Inserción):");
            } else if (v == 1) {
                seleccion(tiempos, v);
                System.out.println("\nOrden de la vuelta " + (v + 1) + " (Selección):");
            } else {
                burbuja(tiempos, v);
                System.out.println("\nOrden de la vuelta " + (v + 1) + " (Burbuja):");
            }

            // Mostrar columna ordenada (directamente aquí)
            for (int i = 0; i < tiempos.length; i++) {
                System.out.println("Competidor " + (i + 1) + ": " + tiempos[i][v]);
            }
        }

        promediosFinales(tiempos);
    }

    // Tiempos aleatorios
    public static double[][] generarTiempos(int competidores, int vueltas) {
        Random random = new Random();
        double[][] matriz = new double[competidores][vueltas];
        for (int i = 0; i < competidores; i++) {
            for (int j = 0; j < vueltas; j++) {
                matriz[i][j] = 50 + random.nextDouble() * 50; // entre 50 y 100
            }
        }
        return matriz;
    }

    // Inserción (O(n^2) en el peor caso, O(n) en el mejor caso)
    public static void insercion(double[][] matriz, int vuelta) {
        for (int i = 1; i < matriz.length; i++) {
            double[] actual = matriz[i];
            double valor = actual[vuelta];
            int j = i - 1;
            while (j >= 0 && matriz[j][vuelta] > valor) {
                matriz[j + 1] = matriz[j];
                j--;
            }
            matriz[j + 1] = actual;
        }
    }

    // Selección (O(n^2) en todos los casos)
    public static void seleccion(double[][] matriz, int vuelta) {
        for (int i = 0; i < matriz.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < matriz.length; j++) {
                if (matriz[j][vuelta] < matriz[min][vuelta]) {
                    min = j;
                }
            }
            double[] temp = matriz[i];
            matriz[i] = matriz[min];
            matriz[min] = temp;
        }
    }

    // Burbuja (O(n^2) en el peor caso, O(n) en el mejor si está ordenado)
    public static void burbuja(double[][] matriz, int vuelta) {
        for (int i = 0; i < matriz.length - 1; i++) {
            for (int j = 0; j < matriz.length - i - 1; j++) {
                if (matriz[j][vuelta] > matriz[j + 1][vuelta]) {
                    double[] temp = matriz[j];
                    matriz[j] = matriz[j + 1];
                    matriz[j + 1] = temp;
                }
            }
        }
    }

    // Calcular, ordenar e imprimir promedios (usa Arrays.sort -> O(n log n))
    public static void promediosFinales(double[][] matriz) {
        double[][] promedios = new double[matriz.length][2];

        for (int i = 0; i < matriz.length; i++) {
            double suma = 0;
            for (double t : matriz[i]) suma += t;
            promedios[i][0] = i + 1; // número de competidor
            promedios[i][1] = suma / matriz[i].length; // promedio
        }

        // Ordenar por promedio ascendente (más rápido primero)
        Arrays.sort(promedios, (a, b) -> Double.compare(a[1], b[1]));

        System.out.println("\n=== Clasificación final por promedio ===");
        for (int i = 0; i < promedios.length; i++) {
            System.out.printf("Puesto %d -> Competidor %.0f con promedio %.2f\n",
                              i + 1, promedios[i][0], promedios[i][1]);
        }
    }
}
