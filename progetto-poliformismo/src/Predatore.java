public abstract class Predatore extends Animale {

    public Predatore(String nomeAnimale) {
        super(nomeAnimale);
    }

    void vaiACaccia() {
        System.out.println("Sto cacciando");
    }
}