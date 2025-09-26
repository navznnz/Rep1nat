import java.util.HashMap;

public class TablaHashEjemplo {
    public static void main(String[] args) {
        // Crear una tabla hash
        HashMap<String, String> tabla = new HashMap<>();

        // --- INSERCIÓN ---
        tabla.put("001", "Ana");
        tabla.put("002", "Luis");
        tabla.put("003", "Carla");

        System.out.println("Contenido inicial: " + tabla);

        // --- BÚSQUEDA ---
        String clave = "002";
        if (tabla.containsKey(clave)) {
            System.out.println("Encontrado: clave " + clave +
                               " → valor: " + tabla.get(clave));
        } else {
            System.out.println("La clave " + clave + " no existe");
        }

        // --- ELIMINACIÓN ---
        tabla.remove("003");
        System.out.println("Después de eliminar 003: " + tabla);
    }
}
