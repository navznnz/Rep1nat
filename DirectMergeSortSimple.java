import java.io.*;
import java.util.*;

public class DirectMergeSortSimple {
    public static void main(String[] args) throws IOException {
        String archivo = "datos.txt";
        Random rand = new Random();

        // Generar archivo con N números
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < 20; i++) {
                bw.write(rand.nextInt(100) + "");
                bw.newLine();
            }
        }

        directMergeSort(archivo);

        // Imprimir archivo ya ordenado
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null)
                System.out.print(linea + " ");
        }
    }

    // O(N log N)
    static void directMergeSort(String archivo) throws IOException {
        String f1 = "f1.txt", f2 = "f2.txt";
        int run = 1;
        while (particionar(archivo, f1, f2, run)) {
            mezclar(f1, f2, archivo, run);
            run *= 2;
        }
    }

    // O(N)
    static boolean particionar(String archivo, String f1, String f2, int run) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo));
             BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));
             BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2))) {

            String linea; int count = 0; boolean toF1 = true, masDeUnRun = false;
            while ((linea = br.readLine()) != null) {
                (toF1 ? bw1 : bw2).write(linea + "\n");
                if (++count == run) { count = 0; toF1 = !toF1; masDeUnRun = true; }
            }
            return masDeUnRun;
        }
    }

    // O(N)
    static void mezclar(String f1, String f2, String salida, int run) throws IOException {
        try (BufferedReader br1 = new BufferedReader(new FileReader(f1));
             BufferedReader br2 = new BufferedReader(new FileReader(f2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(salida))) {

            List<Integer> b1 = new ArrayList<>(), b2 = new ArrayList<>();
            while (true) {
                cargar(br1, b1, run); cargar(br2, b2, run);
                if (b1.isEmpty() && b2.isEmpty()) break;
                int i=0,j=0;
                while (i<b1.size() && j<b2.size()) 
                    bw.write((b1.get(i)<=b2.get(j)?b1.get(i++):b2.get(j++))+"\n");
                while (i<b1.size()) bw.write(b1.get(i++)+"\n");
                while (j<b2.size()) bw.write(b2.get(j++)+"\n");
            }
        }
    }

    // O(run)
    static void cargar(BufferedReader br, List<Integer> b, int run) throws IOException {
        b.clear(); String linea;
        for (int i=0; i<run && (linea=br.readLine())!=null; i++)
            b.add(Integer.parseInt(linea));
    }
}
