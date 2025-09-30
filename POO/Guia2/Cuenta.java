package POO.Guia2;
public class Cuenta {
    private String titular;
    private double cantidad;

    // Constructor
    public Cuenta(String titular) {
        this.titular = titular;
        this.cantidad = 0;
    }

    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    // Getters
    public String getTitular() {
        return titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    // Setters
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    // Métodos
    public void ingresar(double monto) {
        if (monto > 0) {
            cantidad += monto;
        }
    }

    public void retirar(double monto) {
        if (monto > 0) {
            cantidad -= monto;
            if (cantidad < 0) {
                cantidad = 0;
            }
        }
    }

    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta("Juan Perez");
        System.out.println("Titular: " + cuenta1.getTitular());
        System.out.println("Cantidad inicial: " + cuenta1.getCantidad());

        cuenta1.ingresar(500);
        System.out.println("Cantidad después de ingresar 500: " + cuenta1.getCantidad());

        cuenta1.retirar(200);
        System.out.println("Cantidad después de retirar 200: " + cuenta1.getCantidad());

        cuenta1.retirar(400);
        System.out.println("Cantidad después de intentar retirar 400: " + cuenta1.getCantidad());
    }
}
}