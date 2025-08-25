package POO.Guia1;

public class Persona {
    String nombre;
    String apellidos;
    String direccion;
    int anhoNacimiento;

    // Constructor por defecto
    Persona() {
        this.nombre = "";
        this.apellidos = "";
        this.direccion = "";
        this.anhoNacimiento = 0;
    }

    // Constructor con parámetros
    Persona(String nom, String ape, String direc, int anho) {
        this.nombre = nom;
        this.apellidos = ape;
        this.direccion = direc;
        this.anhoNacimiento = anho;
    }

    // Método para imprimir los datos
    void imprimir() {
        System.out.println("Nombre = " + nombre);
        System.out.println("Apellidos = " + apellidos);
        System.out.println("Direccion = " + direccion);
        System.out.println("Año nacimiento = " + anhoNacimiento);
    }

    public static void main(String[] args) {
        Persona oper1 = new Persona();
        Persona oper2 = new Persona();
        Persona oper3 = new Persona("Pedro", "Morales", "Cayma", 2005);

        oper1.nombre = "Ana";
        oper2.nombre = "Luis";

        oper1.imprimir();
        oper2.imprimir();
        oper3.imprimir();
    }
}