package it.its.modulo.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AreaTematica {
    private final String nomeArea;
    private final String descrizione;
    private final List<Attrazione> attrazioneList;

    public AreaTematica(String nomeArea, String descrizione, List<Attrazione> attrazioneList) {
        this.nomeArea = nomeArea;
        this.descrizione = descrizione;
        this.attrazioneList = new ArrayList<>();
    }

    public String getNomeArea() {
        return nomeArea;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public List<Attrazione> getAttrazioniList() {
        return attrazioneList;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof AreaTematica that)) return false;

        return Objects.equals(nomeArea, that.nomeArea);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nomeArea);
    }

    @Override
    public String toString() {
        return "AreaTematica{" +
                "\nnomeArea='" + nomeArea + '\'' +
                "\ndescrizione='" + descrizione + '\'' +
                '}';
    }

    public void aggiungiAttrazione(Attrazione attrazione){
        attrazioneList.add(attrazione);
    }

    public void rimuoviAttrazione(Attrazione attrazione){
        attrazioneList.remove(attrazione);
    }
}
