package Ventas;
public class Empleado 
{   //ATRIBUTOS
    private String nombre, categoria;
    private int numeroHijos;
    private double sueldoBasico, sueldoNeto;
    private double bonificacionCategoria, bonificacionEscolaridad;
    //STATIC
    public static double sumaSueldosNetos = 0.00;
    //CONSTRUCTORES
    public Empleado() 
    {   this.nombre = "";
        this.categoria = "";
        this.numeroHijos = 0;
        this.sueldoBasico = 0.00;
    }
    public Empleado(String nombre, String categoria, int numeroHijos, double sueldoBasico) 
    {   this.nombre = nombre;
        this.categoria = categoria;
        this.numeroHijos = numeroHijos;
        this.sueldoBasico = sueldoBasico;
    }
    //METODOS GETTER & SETTER
    public double getSueldoNeto() {        return sueldoNeto;    }
    public double getBonificacionCategoria() {        return bonificacionCategoria;    }
    public double getBonificacionEscolaridad() {        return bonificacionEscolaridad;    }
    public String getNombre() {        return nombre;    }
    public void setNombre(String nombre) {        this.nombre = nombre;    }
    public String getCategoria() {        return categoria;    }
    public void setCategoria(String categoria) {        this.categoria = categoria;    }
    public int getNumeroHijos() {        return numeroHijos;    }
    public void setNumeroHijos(int numeroHijos) {        this.numeroHijos = numeroHijos;    }
    public double getSueldoBasico() {        return sueldoBasico;    }
    public void setSueldoBasico(double sueldoBasico) {        this.sueldoBasico = sueldoBasico;    }
    //METODOS
    private void calcularBonificacionCategoria()
    {
        switch(this.categoria.toLowerCase().trim())
        {   case "nombrado":     
                this.bonificacionCategoria = this.sueldoBasico * 0.12;   break;
            case "contratado":     
                this.bonificacionCategoria = this.sueldoBasico * 0.10;   break;
            case "por horas":     
                this.bonificacionCategoria = this.sueldoBasico * 0.08;   break;
            default:    
                this.bonificacionCategoria = this.sueldoBasico * 0.06;
        }
    }
    private void calcularBonificacionPorHijos()
    {
        if(numeroHijos < 3)
            bonificacionEscolaridad =  numeroHijos * 20;
        else
            if(numeroHijos < 6)
                bonificacionEscolaridad =  numeroHijos * 30;
            else
                bonificacionEscolaridad =  numeroHijos * 40;
    }
    public void calcularSueldoNeto()
    {   this.calcularBonificacionCategoria();
        this.calcularBonificacionPorHijos();
        this.sueldoNeto = this.sueldoBasico + 
                            this.bonificacionCategoria + 
                            this.bonificacionEscolaridad;
    }
    @Override
    public String toString()
    {   String datos="DATOS DEL EMPLEADO";
        datos = datos.concat("\n**********");
        datos = datos.concat("\nNombre : " + nombre);
        datos = datos.concat("\nCategoría : " + categoria);
        datos = datos.concat("\nSueldo Básico : " + sueldoBasico);
        datos = datos.concat("\nBonificación : " + bonificacionCategoria);
        datos = datos.concat("\nEscolaridad : " + bonificacionEscolaridad);
        datos = datos.concat("\nSueldo Neto : " + sueldoNeto);
        datos = datos.concat("\n**********");
        
        return datos;
    }
}