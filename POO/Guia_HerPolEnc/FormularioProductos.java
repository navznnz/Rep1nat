import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioProductos extends JFrame {
    private JTextField txtNombre, txtPrecio, txtStock, txtExtra;
    private JComboBox<String> cmbTipo;
    private JTextArea txtResultado;

    public FormularioProductos() {
        setTitle("Formulario de Productos");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        // Campos del formulario
        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        add(txtPrecio);

        add(new JLabel("Stock:"));
        txtStock = new JTextField();
        add(txtStock);

        add(new JLabel("Tipo de Producto:"));
        cmbTipo = new JComboBox<>(new String[]{"Tecnológico", "Alimenticio", "Ropa"}); // ¡Agregado "Ropa"!
        add(cmbTipo);

        add(new JLabel("Garantía (meses) / Fecha Expiración / Talla:")); // Etiqueta genérica
        txtExtra = new JTextField();
        add(txtExtra);

        JButton btnGuardar = new JButton("Guardar");
        add(btnGuardar);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        add(txtResultado);

        // Acción del botón
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    double precio = Double.parseDouble(txtPrecio.getText());
                    int stock = Integer.parseInt(txtStock.getText());

                    Producto producto;

                    if (cmbTipo.getSelectedItem().equals("Tecnológico")) {
                        int garantia = Integer.parseInt(txtExtra.getText());
                        producto = new ProductoTecnologico(nombre, precio, stock, garantia);
                    } else if (cmbTipo.getSelectedItem().equals("Alimenticio")) {
                        String fechaExp = txtExtra.getText();
                        producto = new ProductoAlimenticio(nombre, precio, stock, fechaExp);
                    } else if (cmbTipo.getSelectedItem().equals("Ropa")) { // Nueva condición
                        String talla = txtExtra.getText();
                        producto = new ProductoRopa(nombre, precio, stock, talla);
                    } else {
                        producto = null;
                    }

                    // Mostrar info (Polimorfismo en acción)
                    if (producto != null) {
                        txtResultado.setText(producto.mostrarInfo());
                    } else {
                        txtResultado.setText("Tipo de producto no válido.");
                    }
                } catch (Exception ex) {
                    txtResultado.setText("Error: " + ex.getMessage());
                }
            }
        });

    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioProductos().setVisible(true));
    }
}