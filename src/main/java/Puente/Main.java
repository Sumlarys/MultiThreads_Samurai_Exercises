package Puente;

import Puente.PuenteJapones;
import Puente.Persona;

public class Main {
    public static void main(String[] args) {
        PuenteJapones puente = new PuenteJapones(3); // Capacidad del puente: 3 personas

        // Crear hilos de samuráis y campesinos con IDs únicos
        new Persona(puente, "Samurai").start();
        new Persona(puente, "Campesino").start();
        new Persona(puente, "Samurai").start();
        new Persona(puente, "Campesino").start();
        new Persona(puente, "Campesino").start();
        new Persona(puente, "Samurai").start();
        new Persona(puente, "Campesino").start();
        new Persona(puente, "Samurai").start();
        new Persona(puente, "Campesino").start();
    }
}


