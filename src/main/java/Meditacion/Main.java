package Meditacion;

import Meditacion.SalaMeditacion;
import Meditacion.Samurai;

public class Main {
    public static void main(String[] args) {
        SalaMeditacion sala = new SalaMeditacion(3); // Capacidad máxima 3

        // Samurai que esperan
        new Samurai(sala, "Samurai 1", true).start();
        new Samurai(sala, "Samurai 2", true).start();
        new Samurai(sala, "Samurai 3", true).start();
        new Samurai(sala, "Samurai 4", true).start(); // Espera su turno

        // Samurai que no quieren esperar
        new Samurai(sala, "Samurai 5", false).start();
        new Samurai(sala, "Samurai 6", false).start();
    }
}

