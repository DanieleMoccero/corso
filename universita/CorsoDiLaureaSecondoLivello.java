package com.betacom.sett02.universita;

public class CorsoDiLaureaSecondoLivello extends CorsoDiLaurea {

    protected CorsoDiLaureaSecondoLivello(int codice, String denominazione) {
        super(codice, denominazione);
    }

    @Override
    public boolean isSecondoLivello() {
        return true;
    }
}
