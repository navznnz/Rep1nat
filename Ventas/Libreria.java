package Ventas;
import java.util.Scanner;
public class Libreria
{
    public static Empleado ingresarEmpleado()
    {   Scanner consola = new Scanner(System.in);
        System.out.println("Ingrese NOMBRES del Empleado");
        String nombres = consola.next();
        System.out.println("Ingrese CATEGORIA del Empleado");
        System.out.println("Nombrado | Contratado | Por HOras : ");
        String categoria = consola.next();
        System.out.println("Ingrese SUELDO BASICO del Empleado : ");
        double sueldo = consola.nextDouble();
        System.out.println("Ingrese NUMERO DE HIJOS del Empleado : ");
        int nroHijos = consola.nextInt();
        Empleado objEmpleado = new Empleado(nombres, categoria, nroHijos, sueldo ); //LLAMAMOS AL 2do CONSTRUCTOR
        consola.close();
        return objEmpleado;
    }
    public static void main(String[] args) 
    {   String resp ="";
        Scanner input = new Scanner(System.in);
        do
        {
            //CREAMOS INSTANCIA DE EMPLEADO Y ASIGNAMOS DATOS
            Empleado objEmpleado = ingresarEmpleado();  //LLAMAMOS AL 1ER CONSTRUCTOR

            objEmpleado.calcularSueldoNeto();
            Empleado.sumaSueldosNetos += objEmpleado.getSueldoNeto();//SUMAMOS SUELDOS NETOS
            System.out.println(objEmpleado.toString());

            System.out.println("Desea continuar SI/NO?");
            resp = input.next();
        }
        while(resp.equalsIgnoreCase("si"));
        //MOSTRAMOS RESULTADOS ACUMULADOS
        System.out.println("SUMA SUELDOS NETOS : " 
                                + Empleado.sumaSueldosNetos);
        input.close();
    }
    
}