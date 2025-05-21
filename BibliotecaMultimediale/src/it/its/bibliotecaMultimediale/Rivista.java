package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Rivista extends MaterialeBiblioteca implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final int numeroUscita;
    public enum Periodicita{
        SETTIMANALE,
        MENSILE,
        SEMESTRALE,
        ANNUALE;
        public static Map<String, Rivista.Periodicita> PERIODICITA_MAP = new HashMap<>();
        static {
            PERIODICITA_MAP.put("settimanale", SETTIMANALE);
            PERIODICITA_MAP.put("mensile", MENSILE);
            PERIODICITA_MAP.put("semestrale", SEMESTRALE);
            PERIODICITA_MAP.put("annuale", ANNUALE);
        }
        public static Rivista.Periodicita lookUp(String value){
            if(value == null)
                throw new IllegalArgumentException("Valore non valido");
            value = value.toLowerCase();
            Rivista.Periodicita periodicita = PERIODICITA_MAP.get(value);
            if(periodicita == null)
                throw new IllegalArgumentException("Periodicità non valido");
            return periodicita;
        }
    }
    private final Periodicita periodicita;

    public Rivista(int id, String titolo, int annoRilascio, int disponibilita, int numeroUscita, Periodicita periodicita) {
        super(id, titolo, annoRilascio, disponibilita);
        this.numeroUscita = numeroUscita;
        this.periodicita = periodicita;
    }

    public int getNumeroUscita() {
        return numeroUscita;
    }
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Rivista rivista)) return false;
        if (!super.equals(o)) return false;

        return numeroUscita == rivista.numeroUscita && periodicita == rivista.periodicita;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numeroUscita;
        result = 31 * result + Objects.hashCode(periodicita);
        return result;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "id=" + super.getId() +
                ", titolo='" + super.getTitolo() + '\'' +
                ", annoRilascio=" + super.getAnnoRilascio() +
                ", disponibilita=" + super.getDisponibilita() +
                ", numeroUscita=" + numeroUscita +
                ", periodicita=" + periodicita +
                '}';
    }
}
