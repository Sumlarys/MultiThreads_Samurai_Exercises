package Forja;

public class MaestroArmero extends Thread {
    private final Forja forja;

    public MaestroArmero(Forja forja) {
        this.forja = forja;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String katana = forja.recogerKatana();
                System.out.println("Maestro Armero está reparando la katana de " + katana + ".");
                Thread.sleep(6000); // Tiempo de reparación
                System.out.println("Maestro Armero terminó de reparar la katana de " + katana + ".");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

