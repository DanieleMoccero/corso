package com.betacom.sett02.universita;

public abstract class CorsoDiLaurea {
    private int codice;

    public int getCodice() {
        return codice;
    }

    public String getDenominazione() {
        return denominazione;
    }

    private String denominazione;

    protected CorsoDiLaurea(int codice, String denominazione) {
        this.codice = codice;
        this.denominazione = denominazione;
    }

    public abstract boolean isSecondoLivello();
}
