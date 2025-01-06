package Forja;

import Forja.*;

public class Main {
    public static void main(String[] args) {
        Forja forja = new Forja(5); // Capacidad de la estantería: 5

        // Inicializar maestros armeros
        MaestroArmero maestro1 = new MaestroArmero(forja);
        MaestroArmero maestro2 = new MaestroArmero(forja);

        // Iniciar maestros armeros
        maestro1.start();
        maestro2.start();

        // Iniciar samuráis dejando katanas
        new Samurai(forja, "Samurai 1").start();
        new Samurai(forja, "Samurai 2").start();
        new Samurai(forja, "Samurai 3").start();
        new Samurai(forja, "Samurai 4").start();
        new Samurai(forja, "Samurai 5").start();
        new Samurai(forja, "Samurai 6").start();
        new Samurai(forja, "Samurai 7").start();
        new Samurai(forja, "Samurai 8").start();
        new Samurai(forja, "Samurai 9").start();
        new Samurai(forja, "Samurai 10").start();
        new Samurai(forja, "Samurai 11").start();


        // Iniciar el portero
        Portero portero = new Portero(forja);
        portero.start();
    }
}

