 package actividad_1;
import java.util.HashSet;
/**
 *
 * @author LAB-USR-AREQUIPA
 */
public class Actividad_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
HashSet <String> paises = new HashSet<>();

paises.add("Peru");    
paises.add("Chile");
paises.add("Peru");

System.out.println("Conjunto de paises: " + paises);
System.out.println("Contiene 'Chile' ? " + paises.contains("Chile"));

paises.remove("Chile");
System.out.println("Despues de eliminar: " + paises);
}
}
