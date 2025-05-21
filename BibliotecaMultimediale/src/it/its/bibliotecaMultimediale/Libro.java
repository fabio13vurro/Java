package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Libro extends MaterialeBiblioteca implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String ISBN;
    private final int pagine;
    private final Autore riferimentoAutore;

    public Libro(int id, String titolo, int annoRilascio, int disponibilita, String ISBN, int pagine, Autore riferimentoAutore) {
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
                "\n id=" + super.getId() +
                "\n titolo='" + super.getTitolo() + '\'' +
                "\n annoRilascio=" + super.getAnnoRilascio() +
                "\n disponibilita=" + super.getDisponibilita() +
                "\n ISBN='" + ISBN + '\'' +
                "\n pagine=" + pagine +
                "\n riferimentoAutore=" + riferimentoAutore +
                '}';
    }
}
