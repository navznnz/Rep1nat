import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ArchivoMasGrande {
    
    // Clase para almacenar el resultado: archivo más grande y su tamaño
    static class ResultadoBusqueda {
        File archivo;
        long tamaño;
        
        ResultadoBusqueda(File archivo, long tamaño) {
            this.archivo = archivo;
            this.tamaño = tamaño;
        }
    }
    
    // Método principal que combina Divide y Vencerás con Recursividad
    public static ResultadoBusqueda encontrarArchivoMasGrande(File directorio) {
        // CASO BASE 1: Si es un archivo, retornarlo directamente
        if (directorio.isFile()) {
            return new ResultadoBusqueda(directorio, directorio.length());
        }
        
        // CASO BASE 2: Directorio vacío o no existe
        if (!directorio.exists() || !directorio.isDirectory()) {
            return new ResultadoBusqueda(null, 0);
        }
        
        File[] archivos = directorio.listFiles();
        if (archivos == null || archivos.length == 0) {
            return new ResultadoBusqueda(null, 0);
        }
        
        // DIVIDIR: Separar en subproblemas más pequeños
        List<ResultadoBusqueda> resultadosParciales = new ArrayList<>();
        
        for (File archivo : archivos) {
            // RECURSIVIDAD: Resolver cada subproblema
            ResultadoBusqueda resultado = encontrarArchivoMasGrande(archivo);
            resultadosParciales.add(resultado);
        }
        
        // VENCER/COMBINAR: Encontrar el máximo entre todos los resultados
        return encontrarMaximo(resultadosParciales);
    }
    
    // Método auxiliar para encontrar el máximo (parte "Vencer" de Divide y Vencerás)
    private static ResultadoBusqueda encontrarMaximo(List<ResultadoBusqueda> resultados) {
        ResultadoBusqueda maximo = new ResultadoBusqueda(null, 0);
        
        for (ResultadoBusqueda resultado : resultados) {
            if (resultado.archivo != null && resultado.tamaño > maximo.tamaño) {
                maximo = resultado;
            }
        }
        
        return maximo;
    }
    
    public static void main(String[] args) {
        // Ejemplo de uso: buscar el archivo más grande en el directorio actual
        File directorioActual = new File(".");
        
        System.out.println("Buscando el archivo más grande en: " + directorioActual.getAbsolutePath());
        
        ResultadoBusqueda resultado = encontrarArchivoMasGrande(directorioActual);
        
        if (resultado.archivo != null) {
            System.out.println("Archivo más grande encontrado:");
            System.out.println("Nombre: " + resultado.archivo.getName());
            System.out.println("Tamaño: " + resultado.tamaño + " bytes");
            System.out.println("Ruta: " + resultado.archivo.getAbsolutePath());
        } else {
            System.out.println("No se encontraron archivos.");
        }
    }
}
