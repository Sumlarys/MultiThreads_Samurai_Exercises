package Puente;

public class Persona extends Thread {
    private static int contadorID = 0;
    private final PuenteJapones puente;
    private final String tipo;
    private final int id;

    public Persona(PuenteJapones puente, String tipo) {
        this.puente = puente;
        this.tipo = tipo;
        synchronized (Persona.class) {
            this.id = ++contadorID; // Genera un ID único para cada persona
        }
    }

    @Override
    public void run() {
        puente.intentarCruzar(id, tipo);
    }
}


