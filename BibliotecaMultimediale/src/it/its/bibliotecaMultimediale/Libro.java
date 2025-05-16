package it.its.bibliotecaMultimediale;

import java.util.Objects;

public class Libro extends MaterialeBiblioteca{
    private final String ISBN;
    private final int pagine;
    private final Autore riferimentoAutore;

    public Libro(long id, String titolo, int annoRilascio, int disponibilita, String ISBN, int pagine, Autore riferimentoAutore) {
        super(id, titolo, annoRilascio, disponibilita);
        this.ISBN = ISBN;
        this.pagine = pagine;
        this.riferimentoAutore = riferimentoAutore;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPagine() {
        return pagine;
    }

    public Autore getRiferimentoAutore() {
        return riferimentoAutore;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Libro libro)) return false;

        return pagine == libro.pagine && Objects.equals(ISBN, libro.ISBN) && Objects.equals(riferimentoAutore, libro.riferimentoAutore);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(ISBN);
        result = 31 * result + pagine;
        result = 31 * result + Objects.hashCode(riferimentoAutore);
        return result;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + super.getId() +
                ", titolo='" + super.getTitolo() + '\'' +
                ", annoRilascio=" + super.getAnnoRilascio() +
                ", disponibilita=" + super.getDisponibilita() +
                ", ISBN='" + ISBN + '\'' +
                ", pagine=" + pagine +
                ", riferimentoAutore=" + riferimentoAutore +
                '}';
    }
}
