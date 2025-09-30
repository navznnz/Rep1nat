public abstract class Producto {
    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters (Encapsulamiento)
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre;}

    public double getPrecio() {  return precio;}

    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }

    // Polimorfismo: método a sobrescribir
    public abstract String mostrarInfo();
}

