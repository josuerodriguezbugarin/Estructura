import java.lang.Runtime;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class InformeSistema {
    static void main(String[] args){
        System.out.println("Procesadores");
        System.out.println("================================================");
        int procesadores = Runtime.getRuntime().availableProcessors();
        System.out.println("Disponibles JVM: " + procesadores);
        //long: guarda numeros enteros sin decimales
        long mib = 1024 * 1024;
        Runtime memoria = Runtime.getRuntime();
        System.out.println("Memoria Antes");
        System.out.println("================================================");
        long totalAntes = memoria.totalMemory() / mib;
        long libreAntes = memoria.freeMemory() / mib;
        long usoAntes = totalAntes - libreAntes;
        long maxima = memoria.maxMemory() / mib;
        long porcentajeAntes = Math.round((double) usoAntes / totalAntes * 100);
        System.out.println("Total reservada: " + totalAntes + "Mib");
        System.out.println("Libre: " + libreAntes + "Mib");
        System.out.println("En uso: " + usoAntes + "Mib" + porcentajeAntes + "% de la total");
        System.out.println("maxima (-Xmx): " + maxima + "Mib");

        long[] reservado = new long[8 * 1024 * 1024]; // 8 M · 8 bytes = 64 MiB
        System.out.println("Memoria · despues de reservar 64 mib");
        System.out.println("================================================");
        long totalDespues = memoria.totalMemory() / mib;
        long libreDespues = memoria.freeMemory() / mib;
        long usoDespues = totalDespues - libreDespues;
        long porcentajeDespues = Math.round((double) usoDespues / totalDespues * 100);
        long incremento = usoDespues - usoAntes;
        System.out.println("Total reservada: " + totalDespues + "mib");
        System.out.println("Libre: " + libreDespues + "mib");
        System.out.println("En uso: " + usoDespues + "mib");
        System.out.println("Maxima (-Xmx): " + maxima + "mib");
        System.out.println("incremento en uso: " + incremento + "mib");
        System.out.println("(el array sigue en memoria: " + reservado[0] + ")");
        System.out.println("Sistema");
        System.out.println("=============================================0");
        String nombre = System.getProperty("os.name"); //Nombre del So
        String separator = System.getProperty("file.separator"); // pone / o \
        String home = System.getProperty("user.home"); //el home de los archivos
        Path ruta = Paths.get(home, "psp", "informe.txt");
        System.out.println("os.name " + nombre);
        System.out.println("file.separator: " + separator);
        System.out.println("ruta construida con las propiedades: ");
        System.out.println(ruta.toAbsolutePath());
        String[] prefijos = (args.length > 0) ? args: new String[]{"os.", "user.", "java.version"};
        System.out.println("Propiedades que empiezan por" + String.join(",", prefijos));
        System.out.println("================================================");
        Properties propiedades = System.getProperties();//pone datos del sistema
        List<String> claves = new ArrayList<>();
        for (String clave : propiedades.stringPropertyNames()) {
            for (String prefijo : prefijos) {
                if (clave.startsWith(prefijo)) {
                    claves.add(clave);
                    break;
                }
            }
        }
        Collections.sort(claves);
        for (String clave : claves) {
            System.out.println(clave + "=" + propiedades.getProperty(clave));
        }
        System.out.println();
        System.out.println("Proceso en espera");
        System.out.println("===================================================");
        System.out.println("buscame desde otra terminal con:");
        System.out.println("ps -ef | grep terminar");
        System.out.println("Pulsa intro para terminar");
        Scanner proceso = new Scanner(System.in);
        proceso.nextLine();
        System.out.println("fin del pregrama.");



    }
}