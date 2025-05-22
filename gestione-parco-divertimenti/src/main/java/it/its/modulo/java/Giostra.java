package it.its.modulo.java;

import java.util.Objects;

public class Giostra extends Attrazione{
    private final int durataGiroMinuti;
    private final Integer limiteEta;

    public Giostra(String nomeAttrazione, String codiceAttrazione, Tipo tipoAttrazione, int capacitaOraria, int altezzaMinimaCm, boolean aperta, AreaTematica areaTematica, int durataGiroMinuti, Integer limiteEta) {
        super(nomeAttrazione, codiceAttrazione, tipoAttrazione, capacitaOraria, altezzaMinimaCm, aperta, areaTematica);
        this.durataGiroMinuti = durataGiroMinuti;
        this.limiteEta = limiteEta;
    }

    public int getDurataGiroMinuti() {
        return durataGiroMinuti;
    }

    public Integer getLimiteEta() {
        return limiteEta;
    }

    @Override
    protected String getDescrizioneCompleta() {
        return this.getNomeAttrazione() + " " + this.getCodiceAttrazione();
    }

    @Override
    protected int calcolaTempoAttesaMedio(int personeInCoda) {
        return durataGiroMinuti * personeInCoda / this.getCapacitaOraria();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Giostra giostra)) return false;
        if (!super.equals(o)) return false;

        return durataGiroMinuti == giostra.durataGiroMinuti && Objects.equals(limiteEta, giostra.limiteEta);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + durataGiroMinuti;
        result = 31 * result + Objects.hashCode(limiteEta);
        return result;
    }

    @Override
    public String toString() {
        return "Giostra{" +
                "nomeAttrazione='" + super.getNomeAttrazione() + '\'' +
                ", codiceAttrazione='" + super.getCodiceAttrazione() + '\'' +
                ", tipoAttrazione=" + super.getTipoAttrazione() +
                ", capacitaOraria=" + super.getCapacitaOraria() +
                ", altezzaMinimaCm=" + super.getAltezzaMinimaCm() +
                ", aperta=" + super.isAperta() +
                ", areaTematica=" + super.getAreaTematica() +
                ", durataGiroMinuti=" + durataGiroMinuti +
                ", limiteEta=" + limiteEta +
                '}';
    }
}
