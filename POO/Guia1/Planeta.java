package POO.Guia1;

public class Planeta {
    // Atributos
    String nombre = "";
    int cantidadSatelites = 0;
    double masa = 0.0;          // en Kg
    double volumen = 0.0;       // en Km^3
    int diametro = 0;           // en Km
    int distanciaSol = 0;       
    enum TipoPlaneta { TERRESTRE, GASEOSO, ENANO }
    TipoPlaneta tipo;
    boolean observable = false;

    // Constructor
    public Planeta(String nombre, int cantidadSatelites, double masa, double volumen,
                   int diametro, int distanciaSol, TipoPlaneta tipo, boolean observable) {
        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distanciaSol = distanciaSol;
        this.tipo = tipo;
        this.observable = observable;
    }

    // Método para imprimir atributos
    public void imprimirDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad de satélites: " + cantidadSatelites);
        System.out.println("Masa: " + masa);
        System.out.println("Volumen: " + volumen);
        System.out.println("Diámetro: " + diametro);
        System.out.println("Distancia media al Sol: " + distanciaSol);
        System.out.println("Tipo de planeta: " + tipo);
        System.out.println("Observable: " + observable);
    }


    double calcularDensidad() { 
        return masa / volumen;
    }

    // Método para saber si es planeta exterior
    boolean esExterior() {
        float limite = (float)(149_597_870 * 3.4); // 1 UA en millones de km
        if(distanciaSol > limite) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Planeta p1 = new Planeta ("Tierra", 1, 5.9736E24, 1.08321E12, 12742, 150000000,
                TipoPlaneta.TERRESTRE, true);
        p1.imprimirDatos();
        System.out.println("Densidad del planeta: " + p1.calcularDensidad());
        System.out.println("Es planeta exterior: " + p1.esExterior());
        System.out.println();
        Planeta p2 = new Planeta("Júpiter", 79, 1899E27, 1.4313E15, 139820,
        750000000, TipoPlaneta.GASEOSO, true);
p2.imprimirDatos();
System.out.println("Densidad del planeta: " + p2.calcularDensidad());
System.out.println("Es planeta exterior: " + p2.esExterior());
}
}