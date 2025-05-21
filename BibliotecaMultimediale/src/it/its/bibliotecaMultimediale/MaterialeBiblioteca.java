package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public abstract class MaterialeBiblioteca implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final long id;
    private final String titolo;
    private final int annoRilascio;
    private final int disponibilita;

    public MaterialeBiblioteca(long id, String titolo, int annoRilascio, int disponibilita) {
        this.id = id;
        this.titolo = titolo;
        this.annoRilascio = annoRilascio;
        this.disponibilita = disponibilita;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoRilascio() {
        return annoRilascio;
    }

    public int getDisponibilita() {
        return disponibilita;
    }
}
