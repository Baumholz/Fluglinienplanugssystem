package FluglinienPlanungsSystem;

import java.util.ArrayList;

public class Airline {

    public ArrayList<Flugzeug> flotte = new ArrayList<Flugzeug>(); //ArrayList: da dynamisch erweiterbar
    public String name;
    public String kuerzel;

    public Airline(String name, String kuerzel) {
        this.name = name;
        this.kuerzel = kuerzel;
    }

    public void flugzeugHinzufügen(Flugzeug flugzeug) {
        flotte.add(flugzeug);
    }

    public void flugzeugEntfernen(int position) {

    }

}
