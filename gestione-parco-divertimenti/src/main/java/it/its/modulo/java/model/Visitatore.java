package it.its.modulo.java.model;

public class Visitatore {
    private final String codiceFiscale;
    private final String nome;
    private final int altezzaCm;
    private final int eta;

    public Visitatore(String codiceFiscale, String nome, int altezzaCm, int eta) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.altezzaCm = altezzaCm;
        this.eta = eta;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public int getAltezzaCm() {
        return altezzaCm;
    }

    public int getEta() {
        return eta;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if((obj instanceof Visitatore visitatore))
            return this.codiceFiscale.equals(visitatore.getCodiceFiscale());
        return false;
       }

    @Override
    public int hashCode() {
        return this.codiceFiscale.hashCode();
    }

    @Override
    public String toString() {
        return "Visitatore{" +
                "Codice fiscale='" + codiceFiscale + '\'' +
                ", nome='" + nome + '\'' +
                ", altezzaCm=" + altezzaCm +
                ", eta=" + eta +
                '}';
    }
}
