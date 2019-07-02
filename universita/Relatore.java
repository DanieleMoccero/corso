package com.betacom.sett02.universita;

public class Relatore extends Persona{
    private int codice;
    private Facolta facolta;

    public int getCodice() {
        return codice;
    }

    public Facolta getFacolta() {
        return facolta;
    }

    public Relatore(String nome, String cognome, int codice, Facolta facolta) {
        super(nome, cognome);
        this.codice = codice;
        this.facolta = facolta;
    }

    public boolean isEsterno() {
        return this.facolta == null;
    }
}
