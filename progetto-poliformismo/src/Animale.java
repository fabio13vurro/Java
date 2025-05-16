import java.util.Objects;

public abstract class Animale {

    private final String nomeAnimale;

    public Animale(String nomeAnimale) {
        this.nomeAnimale = nomeAnimale;
    }

    public String getNomeAnimale() {
        return nomeAnimale;
    }

    abstract void faiVerso();

    @Override
    public final boolean equals(Object o) {
      if(o == null)
          return false;
      if(o instanceof Animale animale){
          return this.nomeAnimale.equals(animale.getNomeAnimale());
      }
      return false;
    }

    @Override
    public int hashCode() {
        return this.nomeAnimale.hashCode();
    }

    @Override
    public String toString() {
        return "Animale{" +
                "nomeAnimale='" + nomeAnimale + "'}";
    }
}
