package it.its.bibliotecaMultimediale;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestioneUtenti {
    private final Set<Utente> collezioneUtente;

    public GestioneUtenti() {
        this.collezioneUtente = new HashSet<>();
    }

    public Set<Utente> getCollezioneUtente() {
        return collezioneUtente;
    }

    public void aggiungiUtente(Utente utente){
        collezioneUtente.add(utente);
    }

    public String stampaCollezioniUtente(){
        StringBuilder builder = new StringBuilder();
        for(Utente utente : collezioneUtente){
            builder.append(utente.toString()).append("\n");
        }
        return builder.toString();
    }

    public void rimuoviUtente(int id){
        collezioneUtente.removeIf(utente -> utente.getId() == id);
    }

    public Utente ricercaUtente(int id){
        for(Utente utente : collezioneUtente){
            if(utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }

    public List<Utente> ricercaUtente(String nome, String cognome){
        List<Utente> risultato = new ArrayList<>();
        for(Utente utente : collezioneUtente){
            if(nome.equals(utente.getNome()) && cognome.equals(utente.getCognome()))
                risultato.add(utente);
        }
        return risultato;
    }

    public List<Utente> ricercaUtente(String ricerca){
        List<Utente> risultato = new ArrayList<>();
        for(Utente utente : collezioneUtente){
            if(ricerca.equals(utente.getNome()) || ricerca.equals(utente.getCognome()))
                risultato.add(utente);
        }
        return risultato;
    }
}
