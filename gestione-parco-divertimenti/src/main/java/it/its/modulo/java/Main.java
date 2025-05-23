package it.its.modulo.java;

import com.google.gson.Gson;
import it.its.modulo.java.gestione.GestioneBiglietti;
import it.its.modulo.java.gestione.GestioneParcoDivertimenti;
import it.its.modulo.java.gestione.GestioneVisitatori;
import it.its.modulo.java.model.Attrazione;
import it.its.modulo.java.model.Biglietto;
import it.its.modulo.java.model.Visitatore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Map<String, String> percorsi = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(Main.class.getClassLoader()
                        .getResourceAsStream("percorsi.txt"))))){
            String linea;
            while((linea = reader.readLine()) != null){
                String[] strings = linea.split("=");
                percorsi.put(strings[0].trim(), strings[1].trim());
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        GestioneBiglietti gestioneBiglietti = new GestioneBiglietti();
        GestioneParcoDivertimenti gestioneParcoDivertimenti = new GestioneParcoDivertimenti("GARDALAND");
        GestioneVisitatori gestioneVisitatori = new GestioneVisitatori();
        for(Map.Entry<String, String> entry : percorsi.entrySet()){
            switch(entry.getKey()){
                case "percorso_attrazioni":
                    List<Attrazione> listaAttrazioni = Main.caricaCollezione(entry.getValue(), Attrazione.class);
                    for(Attrazione attrazione : listaAttrazioni){
                        gestioneParcoDivertimenti.addAttrazione(attrazione);
                    }
                    break;
                case "percorso_visitatori":
                    List<Visitatore> listaVisitatori = Main.caricaCollezione(entry.getValue(), Visitatore.class);
                    for(Visitatore visitatore : listaVisitatori){
                        gestioneVisitatori.addVisitatore(visitatore);
                    }
                    break;
                case "percorso_biglietti":
                    List<Biglietto> listaBiglietti = Main.caricaCollezione(entry.getValue(), Biglietto.class);
                    for(Biglietto biglietto : listaBiglietti){
                        gestioneBiglietti.addBigliettoVenduto(biglietto);
                    }
                    break;
            }
        }
    }

    private static <T> List<T> caricaCollezione(String percorso, Class<T> clazz){
        List<T> risultato = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(percorso))){
            Gson gson = new Gson();
            String line;
            while((line = reader.readLine()) != null){
                risultato.add(gson.fromJson(line, clazz));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return risultato;
    }
}