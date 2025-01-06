package Meditacion;

import java.util.concurrent.Semaphore;

public class SalaMeditacion {
    private final Semaphore semaphore;

    public SalaMeditacion(int capacidadMaxima) {
        this.semaphore = new Semaphore(capacidadMaxima);
    }

    public void entrar(String nombreSamurai) {
        try {
            semaphore.acquire();
            System.out.println(nombreSamurai + " ha entrado a la sala de meditación y espera 5 segundos antes de salir.");
            Thread.sleep(5000); // Simula la meditación
            System.out.println(nombreSamurai + " ha terminado de meditar y se va.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }

    public void intentarEntrarSinEsperar(String nombreSamurai) {
        if (semaphore.tryAcquire()) {
            System.out.println(nombreSamurai + " ha entrado a la sala sin esperar.");
            try {
                Thread.sleep(5000); // Simula la meditación
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println(nombreSamurai + " ha terminado de meditar y se va.");
                semaphore.release();
            }
        } else {
            System.out.println(nombreSamurai + " no pudo entrar y se fue.");
        }
    }
}

