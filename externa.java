import java.util.Arrays;

public class OrdenacionExternaSimple {
    public static void main(String[] args) {
        // Datos simulando un archivo grande
        int[] datos = {32, 80, 5, 40, 18, 93, 12, 50, 67, 1, 29, 22, 7, 24, 9, 35, 44, 55, 15, 27};

        // Dividimos en 2 bloques (mitad y mitad)
        int mid = datos.length / 2;
        int[] bloque1 = Arrays.copyOfRange(datos, 0, mid);
        int[] bloque2 = Arrays.copyOfRange(datos, mid, datos.length);

        // Ordenamos cada bloque (simula ordenar en disco)
        Arrays.sort(bloque1);
        Arrays.sort(bloque2);

        // Mezclamos los bloques en un único resultado
        int[] resultado = mezclar(bloque1, bloque2);

        // Mostramos resultado final
        System.out.println("=== Datos originales ===");
        System.out.println(Arrays.toString(datos));

        System.out.println("\n=== Bloque 1 ordenado ===");
        System.out.println(Arrays.toString(bloque1));

        System.out.println("\n=== Bloque 2 ordenado ===");
        System.out.println(Arrays.toString(bloque2));

        System.out.println("\n=== Resultado final ordenado ===");
        System.out.println(Arrays.toString(resultado));
    }

    // Método para mezclar dos bloques ya ordenados
    public static int[] mezclar(int[] a, int[] b) {
        int[] resultado = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                resultado[k++] = a[i++];
            } else {
                resultado[k++] = b[j++];
            }
        }
        while (i < a.length) resultado[k++] = a[i++];
        while (j < b.length) resultado[k++] = b[j++];

        return resultado;
    }
}
