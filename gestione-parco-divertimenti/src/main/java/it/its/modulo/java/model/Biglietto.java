package it.its.modulo.java.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Biglietto {
    public enum TipoBiglietto{
        STANDARD,
        VIP,
        RIDOTTO,
        POMERIDIANO;

        private final static Map<String, TipoBiglietto> TIPO_BIGLIETTO = new HashMap<>();

        static{
            TIPO_BIGLIETTO.put("standard", STANDARD);
            TIPO_BIGLIETTO.put("vip", VIP);
            TIPO_BIGLIETTO.put("ridotto", RIDOTTO);
            TIPO_BIGLIETTO.put("pomeridiano", POMERIDIANO);
        }

        public static TipoBiglietto lookUp(String value){
            if(value == null)
                throw new IllegalArgumentException("valore nullo");
            value = value.toLowerCase();
            TipoBiglietto tipoBiglietto = TIPO_BIGLIETTO.get(value);
            if(tipoBiglietto == null)
                throw new IllegalArgumentException("tipo biglietto inesistente");
            return tipoBiglietto;
        }
    }

    private final String codiceBiglietto;
    private final TipoBiglietto tipoBiglietto;
    private final LocalDate dataValidita;
    private final double prezzoBiglietto;
    private final Visitatore visitatore;

    public Biglietto(String codiceBiglietto, TipoBiglietto tipoBiglietto, LocalDate dataValidita, double prezzoBiglietto, Visitatore visitatore) {
        this.codiceBiglietto = codiceBiglietto;
        this.tipoBiglietto = tipoBiglietto;
        this.dataValidita = dataValidita;
        this.prezzoBiglietto = prezzoBiglietto;
        this.visitatore = visitatore;
    }

    public String getCodiceBiglietto() {
        return codiceBiglietto;
    }

    public TipoBiglietto getTipoBiglietto() {
        return tipoBiglietto;
    }

    public LocalDate getDataValidita() {
        return dataValidita;
    }

    public double getPrezzoBiglietto() {
        return prezzoBiglietto;
    }

    public Visitatore getVisitatore() {
        return visitatore;
    }
    @Override
    public final boolean equals(Object o) {
        if (o == null)
            return false;
        if(o instanceof Biglietto biglietto)
            return biglietto.getCodiceBiglietto().equals(this.codiceBiglietto);
        return false;
    }

    @Override
    public int hashCode() {
        return this.codiceBiglietto.hashCode();
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "codiceBiglietto='" + codiceBiglietto + '\'' +
                ", tipoBiglietto=" + tipoBiglietto +
                ", dataValidita=" + dataValidita +
                ", prezzoBiglietto=" + prezzoBiglietto +
                ", visitatore=" + visitatore +
                '}';
    }
}