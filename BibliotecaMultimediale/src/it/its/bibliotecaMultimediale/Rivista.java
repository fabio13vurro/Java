package it.its.bibliotecaMultimediale;

import java.util.Objects;

public class Rivista extends MaterialeBiblioteca{
    private final int numeroUscita;
    private enum Periodicita{
        SETTIMANALE,
        MENSILE,
        SEMESTRALE,
        ANNUALE
    }
    private final Periodicita periodicita;

    public Rivista(long id, String titolo, int annoRilascio, int disponibilita, int numeroUscita, Periodicita periodicita) {
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
