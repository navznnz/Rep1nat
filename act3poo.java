public class Actividad_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<Integer, String> estudiantes = new HashMap<>();
        
        estudiantes.put(101, "Ana");
        estudiantes.put(102, "Luis");
        estudiantes.put(103, "Carla");
    
        System.out.println("Estudiantes: " + estudiantes);
        System.out.println("Codigo 102: " + estudiantes.get(102));
        estudiantes.remove(103);
        System.out.println("Mapa final: " + estudiantes);
    
    }
    
}
