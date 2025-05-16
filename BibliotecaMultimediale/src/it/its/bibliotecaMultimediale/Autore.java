package it.its.bibliotecaMultimediale;

import java.time.LocalDate;
import java.util.Objects;

public class Autore {
    private final String nome;
    private final String cognome;
    private final LocalDate dataDiNascita;

    public Autore(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Autore autore)) return false;

        return Objects.equals(nome, autore.nome) && Objects.equals(cognome, autore.cognome) && Objects.equals(dataDiNascita, autore.dataDiNascita);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nome);
        result = 31 * result + Objects.hashCode(cognome);
        result = 31 * result + Objects.hashCode(dataDiNascita);
        return result;
    }

    @Override
    public String toString() {
        return "Autore{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}