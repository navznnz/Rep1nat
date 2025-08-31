public class Seleccion {

    // Método que ordena un arreglo usando selección
    public static void ordenacionSeleccion(int[] array) {
        int n = array.length; // O(1)

        // Recorremos el arreglo completo
        // Este bucle externo se ejecuta n-1 veces → O(n)
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i; // O(1)

            // Buscar el menor en el resto del arreglo
            // Mejor caso y peor caso: hay que comparar siempre → O(n)
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[indiceMinimo]) {
                    indiceMinimo = j; // O(1)
                }
            }

            // Intercambiar si se encontró un valor menor
            if (indiceMinimo != i) {
                int temp = array[i];      // O(1)
                array[i] = array[indiceMinimo]; // O(1)
                array[indiceMinimo] = temp;     // O(1)
            }
        }

        // Complejidad total:
        // Comparaciones siempre: O(n²)
        // Movimientos: O(n) (a lo sumo un swap por iteración externa)
        // Espacio adicional: O(1) (es in-place)
    }

    // Método principal
    public static void main(String[] args) {
        int[] datos = {29, 10, 14, 37, 13};

        System.out.println("Arreglo original:");
        mostrarArreglo(datos);

        ordenacionSeleccion(datos);

        System.out.println("Arreglo ordenado:");
        mostrarArreglo(datos);
    }

    // Método auxiliar para imprimir el arreglo
    public static void mostrarArreglo(int[] array) {
        for (int num : array) {
            System.out.print(num + " "); // O(1) por elemento
        }
        System.out.println();
    }
}