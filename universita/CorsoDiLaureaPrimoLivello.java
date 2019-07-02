package com.betacom.sett02.universita;

public class CorsoDiLaureaPrimoLivello extends CorsoDiLaurea {

    protected CorsoDiLaureaPrimoLivello(int codice, String denominazione) {
        super(codice, denominazione);
    }

    @Override
    public boolean isSecondoLivello() {
        return false;
    }
}
