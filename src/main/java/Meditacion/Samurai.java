package Meditacion;

public class Samurai extends Thread {
    private final SalaMeditacion sala;
    private final boolean esperar;

    public Samurai(SalaMeditacion sala, String nombre, boolean esperar) {
        super(nombre);
        this.sala = sala;
        this.esperar = esperar;
    }

    @Override
    public void run() {
        if (esperar) {
            sala.entrar(getName());
        } else {
            sala.intentarEntrarSinEsperar(getName());
        }
    }
}

