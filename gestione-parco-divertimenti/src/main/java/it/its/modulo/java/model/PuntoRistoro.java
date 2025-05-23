package it.its.modulo.java.model;

import java.util.HashMap;
import java.util.Map;

public class PuntoRistoro extends Attrazione {

    private final Map<String, Double> menu;

    public enum TipoCucina {
        ITALIANA,
        GIAPPONESE,
        COREANA,
        MESSICANA,
        CINESE,
        JUNK_FOOD;

        private static final Map<String, TipoCucina> TIPO_CUCINA = new HashMap<>();
        static{
            TIPO_CUCINA.put("italiana", ITALIANA);
            TIPO_CUCINA.put("giapponese", GIAPPONESE);
            TIPO_CUCINA.put("coreana", COREANA);
            TIPO_CUCINA.put("messicana", MESSICANA);
            TIPO_CUCINA.put("cinese", CINESE);
            TIPO_CUCINA.put("junk_food", JUNK_FOOD);
        }

        public static TipoCucina lookUp(String value){
            if(value == null)
                throw new IllegalArgumentException("Tipo cucina non inserito");
            value = value.toLowerCase();
            TipoCucina tipoCucina = TIPO_CUCINA.get(value);
            if(tipoCucina == null)
                throw new IllegalArgumentException("tipo non trovato");
            return tipoCucina;
        }
    }
    private final TipoCucina tipoCucina;

    public PuntoRistoro(String nomeAttrazione, String codiceAttrazione, Tipo tipoAttrazione, int capacitaOraria, int altezzaMinimaCm, boolean aperta, AreaTematica areaTematica, Map<String, Double> menu, TipoCucina tipoCucina) {
        super(nomeAttrazione, codiceAttrazione, tipoAttrazione, capacitaOraria, altezzaMinimaCm, aperta, areaTematica);
        this.menu = menu;
        this.tipoCucina = tipoCucina;
    }

    public Map<String, Double> getMenu() {
        return menu;
    }

    public TipoCucina getTipoCucina() {
        return tipoCucina;
    }

    @Override
    public String getDescrizioneCompleta() {
        return this.getNomeAttrazione() + " " + this.getAreaTematica().getDescrizione();
    }

    @Override
    public int calcolaTempoAttesaMedio(int personeInCoda) {
        return personeInCoda / this.getCapacitaOraria();
    }

    @Override
    public String toString() {
        return "PuntoRistoro{" +
                "nomeAttrazione='" + super.getNomeAttrazione() + '\'' +
                ", codiceAttrazione='" + super.getCodiceAttrazione() + '\'' +
                ", capacitaOraria=" + super.getCapacitaOraria() +
                ", aperta=" + super.isAperta() +
                ", areaTematica=" + super.getAreaTematica() +
                ", menu=" + menu +
                ", tipoCucina=" + tipoCucina +
                '}';
    }
}
