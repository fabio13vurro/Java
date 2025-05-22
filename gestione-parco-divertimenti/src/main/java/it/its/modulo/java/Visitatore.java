package it.its.modulo.java;

public class Visitatore {
    private final String idBiglietto;
    private final String nome;
    private final int altezzaCm;
    private final int eta;

    public Visitatore(String idBiglietto, String nome, int altezzaCm, int eta) {
        this.idBiglietto = idBiglietto;
        this.nome = nome;
        this.altezzaCm = altezzaCm;
        this.eta = eta;
    }

    public String getIdBiglietto() {
        return idBiglietto;
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
            return this.idBiglietto.equals(visitatore.getIdBiglietto());
        return false;
       }

    @Override
    public int hashCode() {
        return this.idBiglietto.hashCode();
    }

    @Override
    public String toString() {
        return "Visitatore{" +
                "idBiglietto='" + idBiglietto + '\'' +
                ", nome='" + nome + '\'' +
                ", altezzaCm=" + altezzaCm +
                ", eta=" + eta +
                '}';
    }
}
