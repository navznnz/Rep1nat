package POO.Guia1;

public class Automovil {
    String marca;
    int modelo;
    int motor;

    public enum TipoCombustible { GASOLINA, BIOETANOL, DIESEL, BIODIESEL, GAS_NATURAL }
    TipoCombustible tipoCombustible;

    public enum TipoAutomovil { CIUDAD, SUBCOMPACTO, COMPACTO, FAMILIAR, EJECUTIVO, SUV }
    TipoAutomovil tipoAutomovil;

    int numeroPuertas;
    int cantidadAsientos;
    int velocidadMaxima;

    public enum TipoColor { BLANCO, NEGRO, ROJO, NARANJA, AMARILLO, VERDE, AZUL, VIOLETA }
    TipoColor color;

    int velocidadActual = 0;
    boolean esAutomatico;
    int cantidadMultas = 0;
    double totalMultas = 0;         
    static final double VALOR_MULTA = 150.0;

    public Automovil(String marca, int modelo, int motor, TipoCombustible tipoCombustible,
                     TipoAutomovil tipoAutomovil, int numeroPuertas, int cantidadAsientos,
                     int velocidadMaxima, TipoColor color, boolean esAutomatico) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomovil = tipoAutomovil;
        this.numeroPuertas = numeroPuertas;
        this.cantidadAsientos = cantidadAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.color = color;
        this.esAutomatico = esAutomatico;
    }

    // Getters
    String getMarca() { 
        return marca; 
    }
    int getModelo() { 
        return modelo; 
    }
    int getMotor() { 
        return motor; 
    }
    TipoCombustible getTipoCombustible() { 
        return tipoCombustible; 
    }
    TipoAutomovil getTipoAutomovil() { 
        return tipoAutomovil; 
    }
    int getNumeroPuertas() { 
        return numeroPuertas; 
    }
    int getCantidadAsientos() { 
        return cantidadAsientos; 
    }
    int getVelocidadMaxima() { 
        return velocidadMaxima; 
    }
    TipoColor getColor() { 
        return color; 
    }
    int getVelocidadActual() { 
        return velocidadActual; 
    }
    boolean getEsAutomatico() { 
        return esAutomatico; 
    }
    int getCantidadMultas() { 
        return cantidadMultas; 
    }
    double getTotalMultas() { 
        return totalMultas; 
    }

    // Setters
    void setMarca(String marca) { 
        this.marca = marca; 
    }
    void setModelo(int modelo) { 
        this.modelo = modelo; 
    }
    void setMotor(int motor) { 
        this.motor = motor; 
    }
    void setTipoCombustible(TipoCombustible tipoCombustible) { 
        this.tipoCombustible = tipoCombustible; 
    }
    void setTipoAutomovil(TipoAutomovil tipoAutomovil) { 
        this.tipoAutomovil = tipoAutomovil; 
    }
    void setNumeroPuertas(int numeroPuertas) { 
        this.numeroPuertas = numeroPuertas; 
    }
    void setCantidadAsientos(int cantidadAsientos) { 
        this.cantidadAsientos = cantidadAsientos; 
    }
    void setVelocidadMaxima(int velocidadMaxima) { 
        this.velocidadMaxima = velocidadMaxima; 
    }
    void setColor(TipoColor color) { 
        this.color = color; 
    }
    void setVelocidadActual(int velocidadActual) { 
        this.velocidadActual = velocidadActual; 
    }
    void setEsAutomatico(boolean esAutomatico) { 
        this.esAutomatico = esAutomatico; 
    } // NUEVO

    // Métodos de control de velocidad
    void acelerar(int incremento) {
        if (velocidadActual + incremento <= velocidadMaxima) {
            velocidadActual += incremento;
        } else {
            velocidadActual = velocidadMaxima;
            
            cantidadMultas++;
            totalMultas += VALOR_MULTA;
            System.out.println("Multa generada.");
        }
    }

    void desacelerar(int decremento) {
        if (velocidadActual - decremento >= 0) {
            velocidadActual -= decremento;
        } else {
            velocidadActual = 0;
        }
    }

    void detener() {
        velocidadActual = 0;
    }

    double calcularTiempoLlegada(double distancia) {
        if (velocidadActual > 0) {
            return distancia / velocidadActual;
        } else {
            return -1;
        }
    }

    
    boolean tieneMultas() {
        return cantidadMultas > 0;
    }

    public void imprimir() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Motor (cc): " + motor);
        System.out.println("Tipo de Combustible: " + tipoCombustible);
        System.out.println("Tipo de Automóvil: " + tipoAutomovil);
        System.out.println("Número de Puertas: " + numeroPuertas);
        System.out.println("Cantidad de Asientos: " + cantidadAsientos);
        System.out.println("Velocidad Máxima (km/h): " + velocidadMaxima);
        System.out.println("Color: " + color);
        System.out.println("Es automático: " + (esAutomatico ? "Sí" : "No"));
        System.out.println("Velocidad Actual (km/h): " + velocidadActual);
        System.out.println("Cantidad de Multas: " + cantidadMultas);
        System.out.println("Total de Multas: S/ " + totalMultas);
    }

    public static void main(String[] args) {
        Automovil auto1 = new Automovil("Toyota", 2020, 1800, TipoCombustible.GASOLINA, 
                                        TipoAutomovil.COMPACTO, 4, 5, 180, TipoColor.BLANCO, true);

        auto1.imprimir();

        auto1.setVelocidadActual(170);
        auto1.acelerar(15);
        auto1.acelerar(20);

        System.out.println("Velocidad actual: " + auto1.getVelocidadActual() + " km/h");
        System.out.println("¿Tiene multas?: " + auto1.tieneMultas());
        System.out.println("Total a pagar en multas: S/ " + auto1.getTotalMultas());
    }
}
