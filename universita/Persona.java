package com.betacom.sett02.universita;

public abstract class Persona {
    private String nome;
    private String cognome;

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    protected Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }
}
