package it.its.modulo.java.gestione;

import it.its.modulo.java.model.AreaTematica;
import it.its.modulo.java.model.Attrazione;
import it.its.modulo.java.model.Giostra;
import it.its.modulo.java.model.Visitatore;

import java.util.*;

public class GestioneParcoDivertimenti {
    private final String nomeParco;
    private final Set<AreaTematica> listaAreaTematiche;
    private final Map<String, Attrazione> mappaAttrazioni;
    private final Map<Attrazione, Queue<Visitatore>> codaAttrazioni;

    public GestioneParcoDivertimenti(String nomeParco) {
        this.nomeParco = nomeParco;
        this.listaAreaTematiche = new HashSet<>();
        this.mappaAttrazioni = new HashMap<>();
        this.codaAttrazioni = new HashMap<>();
    }

    public String getNomeParco() {
        return nomeParco;
    }

    public Set<AreaTematica> getListaAreaTematiche() {
        return listaAreaTematiche;
    }

    public Map<String, Attrazione> getMappaAttrazioni() {
        return mappaAttrazioni;
    }

    public Map<Attrazione, Queue<Visitatore>> getCodaAttrazioni() {
        return codaAttrazioni;
    }

    public void addAreaTematica(AreaTematica areaTematica){
        this.listaAreaTematiche.add(areaTematica);
    }

    public void rimuoviAreaTematica(String nomeArea){
//        for(AreaTematica areaTematica : listaAreaTematiche){
//            if(nomeArea.equals(areaTematica.getNomeArea()))
//                listaAreaTematiche.remove(areaTematica);
//        }
        this.listaAreaTematiche
                .removeIf(areaTematica -> nomeArea.equals(areaTematica.getNomeArea()));
    }

    public void aggiungiAttrazioneAreaTematica(String nomeArea, String codiceAttrazione){
        AreaTematica areaTematica = this.listaAreaTematiche
                .stream()
                .filter(area -> nomeArea.equals(area.getNomeArea()))
                .findFirst()
                .orElse(null);
        Attrazione attrazione = this.mappaAttrazioni.get(codiceAttrazione);
        if(areaTematica != null && attrazione != null)
            areaTematica.aggiungiAttrazione(attrazione);
    }

    public void rimuoviAttrazioneAreaTematica(String nomeArea, String codiceAttrazione){
        AreaTematica areaTematica = this.listaAreaTematiche
                .stream()
                .filter(area -> nomeArea.equals(area.getNomeArea()))
                .findFirst()
                .orElse(null);
        Attrazione attrazione = this.mappaAttrazioni.get(codiceAttrazione);
        if(areaTematica != null && attrazione != null)
            areaTematica.rimuoviAttrazione(attrazione);
    }

    public void addAttrazione(Attrazione attrazione){
        this.mappaAttrazioni.put(attrazione.getCodiceAttrazione(), attrazione);
        this.codaAttrazioni.put(attrazione, new ArrayDeque<>());
    }


    public void removeAttrazione(String codiceAttrazione){
        Attrazione attrazione = this.mappaAttrazioni.get(codiceAttrazione);
        if(attrazione != null) {
            this.mappaAttrazioni.remove(codiceAttrazione);
            this.codaAttrazioni.remove(attrazione);
        }
    }

    public boolean apriChiudiAttrazione(String codiceAttrazione){
        Attrazione attrazione = this.mappaAttrazioni.get(codiceAttrazione);
        if(attrazione != null) {
            attrazione.setAperta(!attrazione.isAperta());
            return attrazione.isAperta();
        }
        throw new IllegalArgumentException("Attrazione non trovata");
    }

    public void visualizzaDettagliAttrazione(String codiceAttrazione){
        Attrazione attrazione = this.mappaAttrazioni.get(codiceAttrazione);
        if(attrazione != null) {
            System.out.println("Descrizione attrazione: " + attrazione.getDescrizioneCompleta());
            System.out.println(attrazione);
        }
    }

    //ricerca per tipo
    public List<Attrazione> ricercaAttrazione(Class<? extends Attrazione> clazz){
        return this.mappaAttrazioni
                .values()
                .stream()
                .filter(attrazione -> attrazione.getClass().equals(clazz))
                .toList();
    }

    //ricerca per area
    public List<Attrazione> ricercaAttrazione(String areaTematica){
        AreaTematica area = this.listaAreaTematiche
                .stream()
                .filter(areaVal -> areaVal.getNomeArea().equals(areaTematica))
                .findFirst()
                .orElse(null);

        if(area != null)
            return area.getAttrazioniList();
        throw new IllegalArgumentException("Non ho trovato l'area tematica richiesta");
    }

    //ricerca per stato
    public List<Attrazione> ricercaAttrazione(boolean isAperta){
        return this.mappaAttrazioni
                .values()
                .stream()
                .filter(attrazione -> attrazione.isAperta() == isAperta)
                .toList();
    }

    public int aggiungiVisitatoreCoda(String codiceAttrazione, Visitatore visitatore){
        Attrazione attrazione = this.mappaAttrazioni.get(codiceAttrazione);
        boolean puoAccedere = true;
        if(attrazione instanceof Giostra giostra)
            puoAccedere = giostra.getLimiteEta() != null ||
                    (giostra.getLimiteEta() <= visitatore.getEta() && giostra.getAltezzaMinimaCm() <= visitatore.getAltezzaCm());
        if(puoAccedere){
            Queue<Visitatore> codaAttrazione = this.codaAttrazioni.get(attrazione);
            codaAttrazione.add(visitatore);
            return codaAttrazione.size();
        }
        return 0;
    }

    public void accediAttrazione(String codiceAttrazione, Visitatore visitatore, int posizioneInCoda){
        Attrazione attrazione = this.mappaAttrazioni.get(codiceAttrazione);
        Queue<Visitatore> codaAttrazione = this.codaAttrazioni.get(attrazione);
        System.out.println("Tu sei il " + posizioneInCoda + "° visitatore in coda");
        if(codaAttrazione.contains(visitatore)){
            while(!visitatore.equals(codaAttrazione.poll())){
                System.out.println("Ingresso visitatore");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Entra nell'attrazione");
        }else{
            System.out.println("Non sei in coda per quest'attrazione");
        }
    }

    public int tempoAttesaInCoda(String codiceAttrazione){
        Attrazione attrazione = this.mappaAttrazioni.get(codiceAttrazione);
        Queue<Visitatore> codaAttrazione = this.codaAttrazioni.get(attrazione);
        return attrazione.calcolaTempoAttesaMedio(codaAttrazione.size());
    }

    public List<Attrazione> attrazioniVisitabili(Visitatore visitatore){
        return this.mappaAttrazioni
                .values()
                .stream()
                .filter(attrazione -> {
                    if(attrazione instanceof Giostra giostra)
                        return giostra.isAperta()
                                && (giostra.getLimiteEta() == null ||
                                    giostra.getLimiteEta() <= visitatore.getEta())
                                && giostra.getAltezzaMinimaCm() <= visitatore.getAltezzaCm();
                    return attrazione.isAperta();
                }).toList();
    }
}
