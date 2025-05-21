package it.its.bibliotecaMultimediale;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biblioteca {
    private final Set<MaterialeBiblioteca> collezioneMateriali;

    public Biblioteca() {
        this.collezioneMateriali = new HashSet<>();
    }

    public Set<MaterialeBiblioteca> getCollezioneMateriali() {
        return collezioneMateriali;
    }

    public void aggiungiMateriale(MaterialeBiblioteca materialeBiblioteca) {
        collezioneMateriali.add(materialeBiblioteca);
    }

    public String stampaCollezioniMateriali(){
        StringBuilder builder = new StringBuilder();
        for(MaterialeBiblioteca materialeBiblioteca : collezioneMateriali){
            builder.append(materialeBiblioteca.toString()).append("\n");
        }
        return builder.toString();
    }

    public List<MaterialeBiblioteca> ricercaElementi(String titolo) throws Exception {
        List<MaterialeBiblioteca> risultato = new ArrayList<>();
        for(MaterialeBiblioteca materialeBiblioteca : collezioneMateriali){
            if(materialeBiblioteca.getTitolo().equals(titolo))
                risultato.add(materialeBiblioteca);
        }
        if(risultato.isEmpty())
            throw new NoItemException("Errore");
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

    public void dettaglio(long id){
       for(MaterialeBiblioteca materialeBiblioteca : collezioneMateriali){
           if(materialeBiblioteca.getId() == id)
               System.out.println("Oggetto trovato: " + materialeBiblioteca);
       }
    }


}
