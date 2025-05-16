import java.util.Objects;

public class Key {
    private final String chiave;

    public Key(String chiave) {
        this.chiave = chiave;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Key key)) return false;

        return Objects.equals(chiave, key.chiave);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(chiave);
    }

    @Override
    public String toString() {
        return "Key{" +
                "chiave='" + chiave + '\'' +
                '}';
    }
}