package POO.Act;

public class Smartphone {
    // Atributos
    public String marca;
    public String modelo;
    private String imei;
    public String sistemaOperativo;

    // Constructor 1: Marca, Modelo e IMEI
    public Smartphone(String marca, String modelo, String imei) {
        this.marca = marca;
        this.modelo = modelo;
        this.imei = imei;
        this.sistemaOperativo = null;
    }

    // Constructor 2: Marca, Modelo, IMEI y Sistema Operativo
    public Smartphone(String marca, String modelo, String imei, String sistemaOperativo) {
        this.marca = marca;
        this.modelo = modelo;
        this.imei = imei;
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getImei() {
        return imei;
    }

    void setImei(String imei) {
        this.imei = imei;
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca + " | Modelo: " + modelo + " | IMEI: " + imei +
                           (sistemaOperativo != null ? " | SO: " + sistemaOperativo : ""));
    }

    public static void main(String[] args) {
        // Crear 5 smartphones con Constructor 1 (sin SO)
        Smartphone s1 = new Smartphone("Samsung", "A10", "111111111111111");
        Smartphone s2 = new Smartphone("Xiaomi", "Redmi 9", "222222222222222");
        Smartphone s3 = new Smartphone("Nokia", "3310", "333333333333333");
        Smartphone s4 = new Smartphone("Sony", "Xperia Z", "444444444444444");
        Smartphone s5 = new Smartphone("Motorola", "G8", "555555555555555");

        // Crear 5 smartphones con Constructor 2 (con SO)
        Smartphone s6 = new Smartphone("Apple", "iPhone 12", "666666666666666", "iOS");
        Smartphone s7 = new Smartphone("Samsung", "S21", "777777777777777", "Android");
        Smartphone s8 = new Smartphone("Huawei", "P30", "888888888888888", "Android");
        Smartphone s9 = new Smartphone("Google", "Pixel 5", "999999999999999", "Android");
        Smartphone s10 = new Smartphone("OnePlus", "8T", "101010101010101", "Android");


        Smartphone[] smartphones = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};

        
        System.out.println("Smartphones con Sistema Operativo:");
        for (Smartphone s : smartphones) {
            if (s.sistemaOperativo != null) {
                s.mostrarInfo();
            }
        }
    }
}
