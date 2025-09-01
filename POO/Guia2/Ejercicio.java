package POO.Guia2;

public class Ejercicio {
    public static void listado(Trabajador trabajador) {
        System.out.println("=== Boleta del Trabajador ===");
        System.out.println("Código: " + trabajador.codigo);
        System.out.println("Nombre: " + trabajador.nombre);
        System.out.println("Horas Trabajadas: " + trabajador.horasTrabajadas);
        System.out.println("Tarifa por Hora: S/ " + trabajador.tarifaPorHora);
        System.out.println("Sueldo Bruto: S/ " + trabajador.sueldoBruto());
        System.out.println("Descuento: S/ " + trabajador.descuento());
        System.out.println("Sueldo Neto: S/ " + trabajador.sueldoNeto());
        System.out.println("=============================");
    }

    public static void procesar() {
        Trabajador t1 = new Trabajador();
        t1.codigo = 101;
        t1.nombre = "Juan Pérez";
        t1.horasTrabajadas = 40;
        t1.tarifaPorHora = 25.0;

        listado(t1);

        // Incrementar en 10 las horas trabajadas
        t1.horasTrabajadas += 10;

        // Mostrar boleta después del incremento
        System.out.println("\nDespués de incrementar 10 horas trabajadas:");
        listado(t1);
    }

    public static void main(String[] args) {
        procesar();
    }
}

