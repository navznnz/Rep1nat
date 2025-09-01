package POO.Guia2;

public class Trabajador {
    public int codigo;
    public String nombre;
    public int horasTrabajadas;
    public double tarifaPorHora;

    public double sueldoBruto() {
        return horasTrabajadas * tarifaPorHora;
    }

    public double descuento() {
        return sueldoBruto() * 0.15;
    }

    public double sueldoNeto() {
        return sueldoBruto() - descuento();
    }
}