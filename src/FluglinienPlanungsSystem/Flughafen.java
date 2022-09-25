package FluglinienPlanungsSystem;

public class Flughafen {

    public String name; //Stadt
    String kuerzel;
    int landebahnen;
    int terminals;
    int parkplaetze;
    public double lat;
    public double lon;

    public Flughafen(String name, String kuerzel, int landebahnen, int terminals, int parkplaetze, double lat, double lon) {
        this.name = name;
        this.kuerzel = kuerzel;
        this.landebahnen = landebahnen;
        this.terminals = terminals;
        this.parkplaetze = parkplaetze;
        this.lat = lat;
        this.lon = lon;
    }


}
