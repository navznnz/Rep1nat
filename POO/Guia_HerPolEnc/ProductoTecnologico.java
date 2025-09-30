public class ProductoTecnologico extends Producto {
    private int garantia;

    public ProductoTecnologico(String nombre, double precio, int stock, int garantia) {
        super(nombre, precio, stock);
        this.garantia = garantia;
    }

    @Override
    public String mostrarInfo() {
        return "Producto Tecnológico: " + getNombre() + 
                " | Precio: $" + getPrecio() + 
                " | Stock: " + getStock() + 
                " | Garantía: " + garantia + " meses";
    }
}   
