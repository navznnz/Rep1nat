public class TablaHashSimple {
    private String[] cajones; // aquí guardamos los datos
    private int tamaño;

    public TablaHashSimple(int tamaño) {
        this.tamaño = tamaño;
        cajones = new String[tamaño];
    }

    // --- FUNCIÓN DE DISPERSIÓN ---
    // Convierte una clave (String) en un índice de 0 a tamaño-1
    private int funcionDispersion(String clave) {
        int codigo = clave.hashCode();          // Java transforma el texto en un número
        return Math.abs(codigo) % tamaño;       // resto entre el tamaño = número de cajón
    }

    // --- INSERCIÓN ---
    public void insertar(String clave) {
        int indice = funcionDispersion(clave);
        cajones[indice] = clave; // guardamos la clave en el cajón indicado
        System.out.println("Insertado \"" + clave + "\" en cajón " + indice);
    }

    // --- BÚSQUEDA ---
    public boolean buscar(String clave) {
        int indice = funcionDispersion(clave);
        // comparamos si en ese cajón está la clave
        return clave.equals(cajones[indice]);
    }

    // --- ELIMINACIÓN ---
    public void eliminar(String clave) {
        int indice = funcionDispersion(clave);
        if (clave.equals(cajones[indice])) {
            cajones[indice] = null;
            System.out.println("Eliminado \"" + clave + "\" del cajón " + indice);
        } else {
            System.out.println("No se encontró la clave \"" + clave + "\"");
        }
    }

    // --- Mostrar contenido de los cajones
    public void mostrar() {
        for (int i = 0; i < tamaño; i++) {
            System.out.println("Cajón " + i + ": " + cajones[i]);
        }
    }

    // ---- PROBAR LA TABLA ----
    public static void main(String[] args) {
        TablaHashSimple tabla = new TablaHashSimple(10); // 10 cajones

        tabla.insertar("Ana");
        tabla.insertar("Luis");
        tabla.insertar("Carla");

        System.out.println("\n¿Está Luis? " + tabla.buscar("Luis"));
        System.out.println("¿Está Pedro? " + tabla.buscar("Pedro"));

        tabla.eliminar("Carla");

        System.out.println("\nContenido final:");
        tabla.mostrar();
    }
}