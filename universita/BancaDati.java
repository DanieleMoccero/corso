package com.betacom.sett02.universita;

import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BancaDati {
    private LinkedList<Laureato> laureati;
    private LinkedList<Relatore> relatori;
    private LinkedList<CorsoDiLaurea> corsi;
    private LinkedList<Laurea> lauree;

    public BancaDati() {
        this.laureati = new LinkedList<>();
        this.relatori = new LinkedList<>();
        this.corsi = new LinkedList<>();
        this.lauree = new LinkedList<>();
    }

    public void addLaureato(Laureato laureato) {
        this.laureati.add(laureato);
    }

    public void addRelatore(Relatore relatore) {
        this.relatori.add(relatore);
    }

    public void addCorso(CorsoDiLaurea corsoDiLaurea) {
        this.corsi.add(corsoDiLaurea);
    }

    public void addLaurea(Laurea laurea) {
        this.lauree.add(laurea);
    }

    public int numeroLaureati(int anno, String denominazione) {
        int numLau = 0;
        for (int i = 0; i < this.lauree.size(); i++) {
            Laurea laurea = this.lauree.get(i);
            if ((laurea.getDataSeduta().getYear() == anno) && (laurea.getCorsoDiLaurea().getDenominazione() == denominazione)) {
                numLau++;
            }
        }
        return numLau;
    }

    public String[] titoliTesi(String cognome) {
        LinkedList<String> titoli = new LinkedList<>();
        for (int i = 0; i < this.lauree.size(); i++) {
            Laurea laurea = this.lauree.get(i);
            for (int j = 0; j < laurea.getRelatori().length; j++) {
                Relatore relatore = laurea.getRelatori()[i];
                if (relatore.getCognome() == cognome) {
                    titoli.add(laurea.getTitoloTesi());
                }
            }
        }
        return (String[]) titoli.toArray();
    }

    public Relatore[] correlatoriEsterni(String codiceFacolta) {
        HashSet<Relatore> correlatori = new HashSet<>();
        for (int i = 0; i < this.lauree.size(); i++) {
            Laurea laurea = this.lauree.get(i);
            for (int j = 0; j < laurea.getRelatori().length; j++) {
                Relatore relatore = laurea.getRelatori()[i];
                for (int k = 0; k < laurea.getRelatori().length; k++) {
                    Relatore correlatore = laurea.getRelatori()[k];
                    if (relatore.getFacolta().getCodice().equals(codiceFacolta) && correlatore.isEsterno()) {
                        correlatori.add(relatore);
                    }
                }
            }
        }
        return (Relatore[]) correlatori.toArray();
    }

    public Laureato[] studentiImprevedibili() {
        HashMap<Laureato, HashSet<String>> imprevedibili = new HashMap<>();
        for (int i = 0; i < this.lauree.size(); i++) {
            Laurea laurea = this.lauree.get(i);
            Laureato laureato = laurea.getLaureato();
            if (!imprevedibili.containsKey(laureato)) {
                imprevedibili.put(laureato, new HashSet<>());
            }
            imprevedibili.get(laureato).add(laurea.getCorsoDiLaurea().getDenominazione());
        }
        LinkedList<Laureato> toReturn = new LinkedList<>();
        for (Laureato laureato: imprevedibili.keySet()) {
            if (imprevedibili.get(laureato).size() > 1) {
                toReturn.add(laureato);
            }
        }
        return (Laureato[]) toReturn.toArray();
    }

    public String corsoMiglioreAnno(int anno) {
        HashMap<String, Integer> sommaVoti = new HashMap<>();
        HashMap<String, Integer> quantiVoti = new HashMap<>();
        for (int i = 0; i < this.lauree.size(); i++) {
            Laurea laurea = this.lauree.get(i);
            String corsoLaurea = laurea.getCorsoDiLaurea().getDenominazione();
            if (!sommaVoti.containsKey(corsoLaurea)) {
                sommaVoti.put(corsoLaurea, 0);
                quantiVoti.put(corsoLaurea, 0);
            }
            int voto = sommaVoti.get(corsoLaurea) + laurea.getVoto();
            if (laurea.isLode()) {
                voto += 3;
            }
            sommaVoti.put(corsoLaurea, voto);
            quantiVoti.put(corsoLaurea, quantiVoti.get(corsoLaurea)+1);
        }
        String maxCorso = "";
        double maxVoto = 0;
        for (String corsoLaurea: sommaVoti.keySet()) {
            double avgVoto = (sommaVoti.get(corsoLaurea) + 0.0) / quantiVoti.get(corsoLaurea);
            if (maxVoto < avgVoto) {
                maxVoto = avgVoto;
                maxCorso = corsoLaurea;
            }
        }
        return maxCorso;
    }
}
