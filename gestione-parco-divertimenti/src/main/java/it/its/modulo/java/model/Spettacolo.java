package it.its.modulo.java.model;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Spettacolo extends Attrazione {

    private final List<LocalTime> orariInizio;
    private final int durataSpettacoloInMinuti;
    private final int postiASedere;

    public Spettacolo(String nomeAttrazione, String codiceAttrazione, Tipo tipoAttrazione, int capacitaOraria, int altezzaMinimaCm, boolean aperta, AreaTematica areaTematica, List<LocalTime> orariInizio, int durataSpettacoloInMinuti, int postiASedere) {
        super(nomeAttrazione, codiceAttrazione, tipoAttrazione, capacitaOraria, altezzaMinimaCm, aperta, areaTematica);
        if(orariInizio != null) {
            orariInizio.sort(LocalTime::compareTo);
            this.orariInizio = orariInizio;
        }else{
            this.orariInizio = new ArrayList<>();
        }
        this.durataSpettacoloInMinuti = durataSpettacoloInMinuti;
        this.postiASedere = postiASedere;
    }

    public List<LocalTime> getOrariInizio() {
        return orariInizio;
    }

    public int getDurataSpettacoloInMinuti() {
        return durataSpettacoloInMinuti;
    }

    public int getPostiASedere() {
        return postiASedere;
    }

    @Override
    public String getDescrizioneCompleta() {
        LocalTime oraAttuale = LocalTime.now();
        /*
            Crea un flusso dalla lista degli orari di inizio
            Dopo di che filtra tutti quelli che hanno ora inizio successivo ad ora
            oppure è uguale a oraAttuale
            della lista che ha ottenuto facendo il filtro prende solo il primo
         */
        Optional<LocalTime> prossimoSpettacolo = this.orariInizio
                .stream()
                .filter(orarioInizio -> orarioInizio.isAfter(oraAttuale)
                        || orarioInizio.equals(oraAttuale))
                .findFirst();
        return prossimoSpettacolo
                .map(localTime -> this.getNomeAttrazione() + " Ora inizio: " + localTime)
                .orElseGet(() -> this.getNomeAttrazione() + " Ora inizio: " + (!this.orariInizio.isEmpty()
                        ? this.orariInizio.getFirst()
                        : "NON CI SONO ORARI DISPONIBILI"));
    }

    @Override
    public int calcolaTempoAttesaMedio(int personeInCoda) {
        int prossimoSpettacoloDisponibile = personeInCoda / this.postiASedere;
        LocalTime orarioAttuale = LocalTime.now();
         /*
            Crea un flusso dalla lista degli orari di inizio
            Dopo di che filtra tutti quelli che hanno ora inizio successivo ad ora
            oppure è uguale a oraAttuale
            prendiamo tutta la lista
         */
        List<LocalTime> prossimiSpettacoli = this.orariInizio
                .stream()
                .filter(orarioInizio -> orarioInizio.isAfter(orarioAttuale)
                || orarioInizio.equals(orarioAttuale))
                .toList();
        if(!prossimiSpettacoli.isEmpty()
                && prossimiSpettacoli.size() > prossimoSpettacoloDisponibile){
            LocalTime orarioProssimoSpettacolo = prossimiSpettacoli.get(prossimoSpettacoloDisponibile);
            Duration duration = Duration.between(orarioAttuale, orarioProssimoSpettacolo);
            return (int) duration.get(ChronoUnit.HOURS);
        }else return -1;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Spettacolo that)) return false;
        if (!super.equals(o)) return false;

        return durataSpettacoloInMinuti == that.durataSpettacoloInMinuti && postiASedere == that.postiASedere && Objects.equals(orariInizio, that.orariInizio);
    }

    @Override
    public String toString() {
        return "Spettacolo{" +
                "nomeAttrazione='" + super.getNomeAttrazione() + '\'' +
                ", codiceAttrazione='" + super.getCodiceAttrazione() + '\'' +
                ", tipoAttrazione=" + super.getTipoAttrazione() +
                ", capacitaOraria=" + super.getCapacitaOraria() +
                ", altezzaMinimaCm=" + super.getAltezzaMinimaCm() +
                ", aperta=" + super.isAperta() +
                ", areaTematica=" + super.getAreaTematica() +
                ", orariInizio=" + orariInizio +
                ", durataSpettacoloInMinuti=" + durataSpettacoloInMinuti +
                ", postiASedere=" + postiASedere +
                '}';
    }
}
