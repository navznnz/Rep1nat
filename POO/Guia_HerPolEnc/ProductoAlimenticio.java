public class ProductoAlimenticio extends Producto {
    private String fechaExp;

    public ProductoAlimenticio(String nombre, double precio, int stock, String fechaExp) {
        super(nombre, precio, stock);
        this.fechaExp = fechaExp;
    }

    @Override
    public String mostrarInfo() {
        return "Producto Alimenticio: " + getNombre() + 
                " | Precio: $" + getPrecio() + 
                " | Stock: " + getStock() + 
                " | Fecha de Expiración: " + fechaExp;
    }
}
