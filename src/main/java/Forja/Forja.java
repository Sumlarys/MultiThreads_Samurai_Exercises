package Forja;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Forja {
    private final BlockingQueue<String> estanteria;

    public Forja(int capacidad) {
        this.estanteria = new LinkedBlockingQueue<>(capacidad);
    }

    public void dejarKatana(String nombreSamurai) throws InterruptedException {
        estanteria.put(nombreSamurai);
        System.out.println(nombreSamurai + " dejó su katana en la estantería.");
    }

    public String recogerKatana() throws InterruptedException {
        String katana = estanteria.take();
        System.out.println("Maestro Armero recogió la katana de " + katana + ".");
        return katana;
    }

    public boolean hayEspacio() {
        return estanteria.remainingCapacity() > 0;
    }
}

