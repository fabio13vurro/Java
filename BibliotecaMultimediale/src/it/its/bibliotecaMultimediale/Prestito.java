package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Prestito implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final MaterialeBiblioteca riferimentoMateriale;
    private final Utente riferimentoUtente;
    private final LocalDate dataPrestito;
    private LocalDate dataRestituzione;

    public Prestito(MaterialeBiblioteca riferimentoMateriale, Utente riferimentoUtente, LocalDate dataPrestito) {
        this.riferimentoMateriale = riferimentoMateriale;
        this.riferimentoUtente = riferimentoUtente;
        this.dataPrestito = dataPrestito;
    }

    public MaterialeBiblioteca getRiferimentoMateriale() {
        return riferimentoMateriale;
    }

    public Utente getRiferimentoUtente() {
        return riferimentoUtente;
    }

    public LocalDate getDataPrestito() {
        return dataPrestito;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Prestito prestito)) return false;

        return Objects.equals(riferimentoMateriale, prestito.riferimentoMateriale) && Objects.equals(riferimentoUtente, prestito.riferimentoUtente) && Objects.equals(dataPrestito, prestito.dataPrestito) && Objects.equals(dataRestituzione, prestito.dataRestituzione);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(riferimentoMateriale);
        result = 31 * result + Objects.hashCode(riferimentoUtente);
        result = 31 * result + Objects.hashCode(dataPrestito);
        result = 31 * result + Objects.hashCode(dataRestituzione);
        return result;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "riferimentoMateriale=" + riferimentoMateriale +
                ", riferimentoUtente=" + riferimentoUtente +
                ", dataPrestito=" + dataPrestito +
                ", dataRestituzione=" + dataRestituzione +
                '}';
    }
}