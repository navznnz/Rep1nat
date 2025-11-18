import java.util.*;

public class InventarioTienda {
    
    /**
     * Clase que representa un producto en el inventario
     * Complejidad espacial: O(1) por instancia
     */
    static class Producto {
        int id;
        String nombre;
        double precio;
        
        public Producto(int id, String nombre, double precio) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
        }
        
        @Override
        public String toString() {
            return String.format("ID: %d, %-12s $%.2f", id, nombre, precio);
        }
    }
    
    /**
     * Ordena un array de productos usando Quick Sort
     * Complejidad temporal: O(n log n) promedio, O(n²) peor caso
     * Complejidad espacial: O(log n) por recursividad
     */
    public static void quickSort(Producto[] productos, int low, int high, boolean porPrecio) {
        if (low < high) {
            int pivotIndex = partition(productos, low, high, porPrecio);
            quickSort(productos, low, pivotIndex - 1, porPrecio);
            quickSort(productos, pivotIndex + 1, high, porPrecio);
        }
    }
    
    private static int partition(Producto[] productos, int low, int high, boolean porPrecio) {
        Producto pivot = productos[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            boolean condicion = porPrecio ? 
                productos[j].precio <= pivot.precio : 
                productos[j].id <= pivot.id;
                
            if (condicion) {
                i++;
                swap(productos, i, j);
            }
        }
        
        swap(productos, i + 1, high);
        return i + 1;
    }
    
    private static void swap(Producto[] productos, int i, int j) {
        Producto temp = productos[i];
        productos[i] = productos[j];
        productos[j] = temp;
    }
    
    /**
     * Busca un producto usando Búsqueda Binaria
     * Complejidad temporal: O(log n)
     * Complejidad espacial: O(1)
     */
    public static int busquedaBinaria(Producto[] productos, double objetivo, boolean porPrecio) {
        int izquierda = 0, derecha = productos.length - 1;
        
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            double valorMedio = porPrecio ? productos[medio].precio : productos[medio].id;
            
            if (valorMedio == objetivo) {
                return medio;
            } else if (valorMedio < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1;
    }
    
    /**
     * Busca productos dentro de un rango de precios
     * Complejidad temporal: O(n log n) por el ordenamiento + O(k) donde k = productos en rango
     * Complejidad espacial: O(k) para la lista de resultados
     */
    public static List<Producto> buscarPorRangoPrecio(Producto[] productos, double min, double max) {
        List<Producto> resultados = new ArrayList<>();
        quickSort(productos, 0, productos.length - 1, true);
        
        for (Producto p : productos) {
            if (p.precio >= min && p.precio <= max) {
                resultados.add(p);
            } else if (p.precio > max) {
                break;
            }
        }
        return resultados;
    }
    
    /**
     * Imprime el inventario en formato legible
     * Complejidad temporal: O(n)
     * Complejidad espacial: O(1)
     */
    public static void imprimirInventario(Producto[] productos, String titulo) {
        System.out.println("\n" + titulo);
        System.out.println("----------------------------------------");
        for (int i = 0; i < productos.length; i++) {
            System.out.println((i + 1) + ". " + productos[i]);
        }
    }
    
    public static void main(String[] args) {
        Producto[] inventario = {
            new Producto(105, "Laptop", 899.99),
            new Producto(102, "Mouse", 25.50),
            new Producto(108, "Teclado", 75.00),
            new Producto(101, "Monitor", 299.99),
            new Producto(107, "Tablet", 450.00),
            new Producto(103, "Auriculares", 89.99),
            new Producto(106, "Impresora", 199.99),
            new Producto(104, "Webcam", 45.00)
        };
        
        System.out.println("SISTEMA DE INVENTARIO DE TIENDA");
        System.out.println("========================================");
        
        imprimirInventario(inventario, "INVENTARIO DESORDENADO:");
        
        quickSort(inventario, 0, inventario.length - 1, false);
        imprimirInventario(inventario, "INVENTARIO ORDENADO POR ID:");
        
        System.out.println("\nBUSQUEDAS POR ID:");
        int[] ids = {101, 105, 110, 103};
        for (int id : ids) {
            int posicion = busquedaBinaria(inventario, id, false);
            if (posicion != -1) {
                System.out.println("Encontrado ID " + id + ": " + inventario[posicion].nombre);
            } else {
                System.out.println("No encontrado ID " + id);
            }
        }
        
        quickSort(inventario, 0, inventario.length - 1, true);
        imprimirInventario(inventario, "INVENTARIO ORDENADO POR PRECIO:");
        
        System.out.println("\nBUSQUEDAS POR PRECIO:");
        double[] precios = {50.00, 100.00, 300.00, 1000.00};
        for (double precio : precios) {
            int posicion = busquedaBinaria(inventario, precio, true);
            if (posicion != -1) {
                System.out.printf("Encontrado $%.2f: %s\n", precio, inventario[posicion].nombre);
            } else {
                System.out.printf("No encontrado $%.2f\n", precio);
            }
        }
        
        System.out.println("\nPRODUCTOS ENTRE $50 Y $300:");
        List<Producto> enRango = buscarPorRangoPrecio(inventario, 50, 300);
        for (Producto producto : enRango) {
            System.out.printf("- %s: $%.2f\n", producto.nombre, producto.precio);
        }
    }
}