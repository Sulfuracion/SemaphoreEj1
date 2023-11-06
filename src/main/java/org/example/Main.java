package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(20); // Semáforo con 20 permisos para coches en el puente
        int totalCoches = 0; // Contador de coches en el puente

        for (int i = 1; i <= 50; i++) { // Simulamos 50 eventos de entrada y salida de coches
            if (i % 2 == 1) {
                // Evento de entrada
                int cochesEsperando = semaphore.availablePermits();
                semaphore.acquireUninterruptibly();
                totalCoches++;
                System.out.println("Acaba de entrar un coche dirección Galdar. Hay " + totalCoches + " coche/s");
            } else {
                // Evento de salida
                if (totalCoches > 0) {
                    semaphore.release();
                    totalCoches--;
                    System.out.println("Acaba de salir un coche dirección Galdar. Hay " + totalCoches + " coche/s");
                } else {
                    System.out.println("Quiere salir un coche que no existe dirección Galdar. Hay " + totalCoches + " coche/s");
                }
            }

            // Simulamos la entrada de coches en dirección Las Palmas
            if (i % 5 == 0) {
                int cochesEsperando = semaphore.availablePermits();
                semaphore.acquireUninterruptibly();
                totalCoches++;
                System.out.println("Acaba de entrar un coche dirección Las Palmas. Hay " + totalCoches + " coche/s");
            }
        }
    }
}