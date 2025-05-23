package it.its.modulo.java.gestione;

import it.its.modulo.java.model.Biglietto;
import it.its.modulo.java.model.Visitatore;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class GestioneBiglietti {
    private final Set<Biglietto> bigliettiVenduti;

    public GestioneBiglietti() {
        this.bigliettiVenduti = new HashSet<>();
    }

    public Set<Biglietto> getBigliettiVenduti() {
        return bigliettiVenduti;
    }

    public void addBigliettoVenduto(Biglietto biglietto){
        this.bigliettiVenduti.add(biglietto);
    }

    public boolean isValido(String codiceBiglietto){
        Biglietto bigliettoDaValidare = this.bigliettiVenduti
                .stream()
                .filter(biglietto -> biglietto.equals(codiceBiglietto))
                .findFirst()
                .orElse(null);
        if(bigliettoDaValidare != null){
            LocalDate dataOdierna = LocalDate.now();
            return dataOdierna.isEqual(bigliettoDaValidare.getDataValidita());
        }
        return false;
    }

    public Visitatore cercaVisitatore(String codiceBiglietto){
        Biglietto bigliettoVisitatore = this.bigliettiVenduti
                .stream()
                .filter(biglietto -> biglietto.equals(codiceBiglietto))
                .findFirst()
                .orElse(null);
        if(bigliettoVisitatore != null)
            return bigliettoVisitatore.getVisitatore();
        return null;
    }
}