public abstract class Animale {

    private final String nomeAnimale;

    public Animale(String nomeAnimale) {
        this.nomeAnimale = nomeAnimale;
    }

    public String getNomeAnimale() {
        return nomeAnimale;
    }

    abstract void faiVerso();
}
