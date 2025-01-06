package Forja;

public class Portero extends Thread {
    private final Forja forja;

    public Portero(Forja forja) {
        this.forja = forja;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); // Tiempo para recoger la katana
                if (forja.hayEspacio()) {
                    System.out.println("Portero encontró espacio en la estantería.");
                } else {
                    System.out.println("Portero está esperando un hueco.");
                }
                Thread.sleep(1000); // Tiempo de vuelta a la puerta
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

