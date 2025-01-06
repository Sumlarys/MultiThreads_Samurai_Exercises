package Forja;

public class Samurai extends Thread {
    private final Forja forja;

    public Samurai(Forja forja, String nombre) {
        super(nombre);
        this.forja = forja;
    }

    @Override
    public void run() {
        try {
            forja.dejarKatana(getName());
            System.out.println(getName() + " ha dejado su katana y se retira.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
