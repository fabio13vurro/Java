package prova;

public class PojoExample {
    public String nome;
    public String cognome;
    public String cf;

    @Override
    public String toString() {
        return "PojoExample{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", cf='" + cf + '\'' +
                '}';
    }
}
