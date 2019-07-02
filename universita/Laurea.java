package com.betacom.sett02.universita;

/*
Una Laurea è caratterizzata dal codice fiscale del laureato,
dal codice del corso di laurea, dal voto conseguito (un
intero tra 66 e 110), da un campo booleano lode (che se vale
 true indica l’attribuzione della lode), dalla data della
 seduta, dal titolo della tesi, e dalla lista dei codici
 dei relatori della tesi (ogni tesi può avere uno o più relatori).
 */

import java.util.Date;

public class Laurea {
    private Laureato laureato;
    private CorsoDiLaurea corsoDiLaurea;

    public Laureato getLaureato() {
        return laureato;
    }

    public CorsoDiLaurea getCorsoDiLaurea() {
        return corsoDiLaurea;
    }

    public int getVoto() {
        return voto;
    }

    public boolean isLode() {
        return lode;
    }

    public Date getDataSeduta() {
        return dataSeduta;
    }

    public String getTitoloTesi() {
        return titoloTesi;
    }

    public Relatore[] getRelatori() {
        return relatori;
    }

    private int voto;
    private boolean lode;
    private Date dataSeduta;
    private String titoloTesi;
    private Relatore[] relatori;

    public Laurea(Laureato laureato, CorsoDiLaurea corsoDiLaurea, int voto, boolean lode, Date dataSeduta, String titoloTesi, Relatore[] relatori) {
        this.laureato = laureato;
        this.corsoDiLaurea = corsoDiLaurea;
        this.voto = voto;
        this.lode = lode;
        this.dataSeduta = dataSeduta;
        this.titoloTesi = titoloTesi;
        this.relatori = relatori;
    }
}
