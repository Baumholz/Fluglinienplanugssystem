package FluglinienPlanungsSystem;

import java.util.ArrayList;
import java.util.Date;

public class Flugzeug {

    String hersteller;
    String typ;
    int anzahlMaxPassagiere;
    public double reichweite; //in km
    boolean wartunng;
    boolean betrieb;
    String standort;
    public String name;
    ArrayList<Date> startZeitPunkte = new ArrayList<Date>();
    ArrayList<Date> landeZeitPunkte = new ArrayList<Date>();

    public Flugzeug(String hersteller, String typ, int anzahlMaxPassagiere, double reichweite, boolean wartunng, boolean betrieb, String standort, String name) {
        this.hersteller = hersteller;
        this.typ = typ;
        this.anzahlMaxPassagiere = anzahlMaxPassagiere;
        this.reichweite = reichweite;
        this.wartunng = wartunng;
        this.betrieb = betrieb;
        this.standort = standort;
        this.name = name;
    }

    public boolean flugHinzufügen(Date starZeitPunkt, Date landeZeitPunkt){

        if(startZeitPunkte.isEmpty()){
            startZeitPunkte.add(starZeitPunkt);
            landeZeitPunkte.add(landeZeitPunkt);
            return true;
        }else{
            for(int i = 0; i < startZeitPunkte.size();i++){
                if(starZeitPunkt.compareTo(startZeitPunkte.get(i)) > 0 && starZeitPunkt.compareTo(landeZeitPunkte.get(i)) < 0){ // Startzeitpunkt liegt zwischen einem existierendem Startzeitpunkt und einem LandeZeitpunkt
                    return false;
                }else if(landeZeitPunkt.compareTo(startZeitPunkte.get(i)) > 0 && landeZeitPunkt.compareTo(landeZeitPunkte.get(i)) < 0){ //Landezeitpunkt liegt zwischen einem existierendem Startzeitpunkt und einem LandeZeitpunkt
                    return false;
                }else if(starZeitPunkt.compareTo(startZeitPunkte.get(i)) == 0 || starZeitPunkt.compareTo(landeZeitPunkte.get(i)) == 0 || landeZeitPunkt.compareTo(startZeitPunkte.get(i)) == 0 || landeZeitPunkt.compareTo(landeZeitPunkte.get(i)) == 0){ // Der Start/Landezeitpunkt ist der selbe wie ein existierende Start/LandeZeitpunkt
                    return false;
                }else{
                    startZeitPunkte.add(starZeitPunkt);
                    landeZeitPunkte.add(landeZeitPunkt);
                    return true;
                }
            }
        }
        return false;
    }

}
