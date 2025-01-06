package Puente;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class PuenteJapones {
    private final Semaphore capacidad;
    private final ReentrantLock prioridadLock;
    private final AtomicInteger totalEsperando; // Contador de personas esperando
    private boolean haySamuraiEsperando;

    public PuenteJapones(int capacidadMaxima) {
        this.capacidad = new Semaphore(capacidadMaxima);
        this.prioridadLock = new ReentrantLock();
        this.totalEsperando = new AtomicInteger(0);
        this.haySamuraiEsperando = false;
    }

    public void cruzar(int id, String tipoPersona) {
        try {
            totalEsperando.incrementAndGet(); // Incrementa el contador de personas esperando
            if (tipoPersona.equals("Samurai")) {
                prioridadLock.lock();
                haySamuraiEsperando = true;
            }

            capacidad.acquire();
            totalEsperando.decrementAndGet(); // Decrementa cuando cruza
            System.out.println("Persona con ID: " + id + " Tipo: " + tipoPersona +
                    " está cruzando el puente. Total personas esperando: " + totalEsperando.get());
            Thread.sleep(2000); // Simula el cruce
            System.out.println("Persona con ID: " + id + " Tipo: " + tipoPersona + " ha cruzado el puente.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            capacidad.release();
            if (tipoPersona.equals("Samurai")) {
                haySamuraiEsperando = false;
                prioridadLock.unlock();
            }
        }
    }

    public void intentarCruzar(int id, String tipoPersona) {
        if (tipoPersona.equals("Campesino") && haySamuraiEsperando) {
            System.out.println("Persona con ID: " + id + " Tipo: " + tipoPersona +
                    " espera porque hay un samurai con prioridad. Total personas esperando: " + totalEsperando.get());
        } else {
            cruzar(id, tipoPersona);
        }
    }
}


