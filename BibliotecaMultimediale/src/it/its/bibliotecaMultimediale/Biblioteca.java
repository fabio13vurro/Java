package it.its.bibliotecaMultimediale;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biblioteca {
    private final Set<MaterialeBiblioteca> collezioneMateriali;
    private final Set<Utente> collezioneUtente;
    private final Set<Prestito> collezionePrestito;

    public Biblioteca() {
        this.collezioneMateriali = new HashSet<>();
        this.collezioneUtente = new HashSet<>();
        this.collezionePrestito = new HashSet<>();
    }

    public void aggiungiMateriale(MaterialeBiblioteca materialeBiblioteca) {
        collezioneMateriali.add(materialeBiblioteca);
    }

    public void aggiungiUtente(Utente utente) {
        collezioneUtente.add(utente);
    }

    public void aggiungiPrestito(Prestito prestito) {
        collezionePrestito.add(prestito);
    }

    public String stampaCollezioniMateriali(){
        StringBuilder builder = new StringBuilder();
        for(MaterialeBiblioteca materialeBiblioteca : collezioneMateriali){
            builder.append(materialeBiblioteca.toString()).append("\n");
        }
        return builder.toString();
    }

    public String stampaCollezioniUtente(){
        StringBuilder builder = new StringBuilder();
        for(Utente utente : collezioneUtente){
            builder.append(utente.toString()).append("\n");
        }
        return builder.toString();
    }

    public String stampaCollezioniPrestito(){
        StringBuilder builder = new StringBuilder();
        for(Prestito prestito : collezionePrestito){
            builder.append(prestito.toString()).append("\n");
        }
        return builder.toString();
    }

    public List<MaterialeBiblioteca> ricercaElementi(String titolo){
        List<MaterialeBiblioteca> risultato = new ArrayList<>();
        for(MaterialeBiblioteca materialeBiblioteca : collezioneMateriali){
            if(materialeBiblioteca.getTitolo().equals(titolo))
                risultato.add(materialeBiblioteca);
        }
        return risultato;
    }

    public List<MaterialeBiblioteca> ricercaElementi(Autore autore){
        List<MaterialeBiblioteca> risultato = new ArrayList<>();
        for(MaterialeBiblioteca materialeBiblioteca : collezioneMateriali){
            if(materialeBiblioteca instanceof Libro){
                if(autore.equals(((Libro)materialeBiblioteca).getRiferimentoAutore()))
                    risultato.add(materialeBiblioteca);
            } else if (materialeBiblioteca instanceof DVD) {
                if(autore.equals(((DVD)materialeBiblioteca).getRegista()))
                    risultato.add(materialeBiblioteca);
            }
        }

        return risultato;
    }

    public List<MaterialeBiblioteca> ricercaElementi(Class<? extends MaterialeBiblioteca> clazz) {
        List<MaterialeBiblioteca> risultato = new ArrayList<>();
        for(MaterialeBiblioteca materialeBiblioteca : collezioneMateriali) {
            if (materialeBiblioteca.getClass().equals(clazz))
                risultato.add(materialeBiblioteca);
        }
        return risultato;
    }

}
