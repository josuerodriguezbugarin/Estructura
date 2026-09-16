package org.example;
import java.lang.Runtime;

public class InformeSistema {
    static void main(){
        System.out.println("Procesadores");
        System.out.println("================================================");
        int procesadores = Runtime.getRuntime().availableProcessors();
        System.out.println("Disponibles JVM: " + procesadores);

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
    }
}