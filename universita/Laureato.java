package com.betacom.sett02.universita;

import java.util.Date;

public class Laureato extends Persona {
    private String cf;
    private Date dataNascita;

    public Laureato(String nome, String cognome, String cf, Date dataNascita) {
        super(nome, cognome);
        this.cf = cf;
        this.dataNascita = dataNascita;
    }


}
