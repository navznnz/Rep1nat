import java.util.*;
import java.util.stream.Collectors;

class Producto {
    private int id;
    private String nombre;
    private List<String> palabrasClave;

    public Producto(int id, String nombre, List<String> palabrasClave) {
        this.id = id;
        this.nombre = nombre;
        this.palabrasClave = new ArrayList<>(palabrasClave);
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public List<String> getPalabrasClave() { return new ArrayList<>(palabrasClave); }

    @Override
    public String toString() {
        return String.format("Producto{id=%d, nombre='%s'}", id, nombre);
    }
}

public class IndiceProductosAvanzado {

    private Map<String, Set<Integer>> indice;

    private Map<Integer, Producto> catalogo;

    public IndiceProductosAvanzado() {
        this.indice = new HashMap<>();
        this.catalogo = new HashMap<>();
    }

    public void registrarProducto(Producto producto) {
        if (producto == null) return;

        int id = producto.getId();
        catalogo.put(id, producto);

        for (String palabra : producto.getPalabrasClave()) {
            if (palabra == null) continue;
            String normalizada = palabra.trim().toLowerCase();
            if (normalizada.isEmpty()) continue;

            indice.putIfAbsent(normalizada, new HashSet<>());
            indice.get(normalizada).add(id);
        }
    }

    public List<Producto> buscar(String palabraClave) {
        if (palabraClave == null) return Collections.emptyList();
        String normalizada = palabraClave.trim().toLowerCase();
        Set<Integer> ids = indice.getOrDefault(normalizada, Collections.emptySet());
        return ids.stream()
                  .map(catalogo::get)
                  .filter(Objects::nonNull)
                  .collect(Collectors.toList());
    }

    public List<Producto> buscarTodas(List<String> palabrasClave) {
        if (palabrasClave == null || palabrasClave.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> normalizadas = palabrasClave.stream()
                .filter(Objects::nonNull)
                .map(p -> p.trim().toLowerCase())
                .filter(p -> !p.isEmpty())
                .collect(Collectors.toList());

        if (normalizadas.isEmpty()) {
            return Collections.emptyList();
        }

        Set<Integer> resultado = null;
        for (String palabra : normalizadas) {
            Set<Integer> ids = indice.getOrDefault(palabra, Collections.emptySet());
            if (resultado == null) {
                resultado = new HashSet<>(ids);
            } else {
                resultado.retainAll(ids);
            }
        }

        if (resultado == null) {
            return Collections.emptyList();
        }

        return resultado.stream()
                        .map(catalogo::get)
                        .filter(Objects::nonNull)
                        .sorted(Comparator.comparing(Producto::getId))
                        .collect(Collectors.toList());
    }

    public void mostrarIndice() {
        System.out.println("=== ÍNDICE INVERTIDO DE PRODUCTOS ===");
        List<String> palabras = new ArrayList<>(indice.keySet());
        Collections.sort(palabras);
        for (String palabra : palabras) {
            System.out.println(palabra + " -> " + indice.get(palabra));
        }
    }

    public static void main(String[] args) {
        IndiceProductosAvanzado indice = new IndiceProductosAvanzado();

        indice.registrarProducto(new Producto(101, "iPhone 15 Pro", 
            Arrays.asList("smartphone", "iOS", "cámara", "Face ID", "5G")));
        indice.registrarProducto(new Producto(102, "Samsung Galaxy S24", 
            Arrays.asList("smartphone", "Android", "cámara", "5G", "pantalla AMOLED")));
        indice.registrarProducto(new Producto(103, "MacBook Pro M3", 
            Arrays.asList("laptop", "Apple", "M3", "16GB RAM", "SSD")));
        indice.registrarProducto(new Producto(104, "iPad Air", 
            Arrays.asList("tablet", "Apple", "iOS", "pantalla líquida")));
        indice.registrarProducto(new Producto(105, "Sony WH-1000XM5", 
            Arrays.asList("auriculares", "bluetooth", "noise cancelling", "inalámbrico")));

        indice.mostrarIndice();

        System.out.println("\n--- BÚSQUEDA SIMPLE ---");
        System.out.println("Productos con 'smartphone':");
        indice.buscar("smartphone").forEach(System.out::println);

        System.out.println("\n--- BÚSQUEDA CON MÚLTIPLES PALABRAS (AND) ---");
        List<Producto> resultado1 = indice.buscarTodas(Arrays.asList("smartphone", "5G"));
        System.out.println("Productos con 'smartphone' Y '5G':");
        resultado1.forEach(System.out::println);

        List<Producto> resultado2 = indice.buscarTodas(Arrays.asList("Apple", "iOS"));
        System.out.println("\nProductos con 'Apple' Y 'iOS':");
        resultado2.forEach(System.out::println);

        List<Producto> resultado3 = indice.buscarTodas(Arrays.asList("auriculares", "bluetooth", "noise cancelling"));
        System.out.println("\nProductos con 'auriculares', 'bluetooth' y 'noise cancelling':");
        resultado3.forEach(System.out::println);
    }
}
