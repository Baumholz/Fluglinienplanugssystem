package FluglinienPlanungsSystem;


import FluglinienPlanungsSystem.GUI.Startseite;

import java.util.ArrayList;

public class Planungssystem {

    public static ArrayList<Airline> airlineList = new ArrayList<Airline>();
    public static ArrayList<Flughafen> flughafenList = new ArrayList<Flughafen>();
    public static ArrayList<Flugplan> flugPlanList = new ArrayList<Flugplan>();

    public static void main(String[] args) {
        createData();
        Startseite startseite = new Startseite();
        //System.out.println(distance(48.7758459, 9.1829321, 51.5073509, -0.1277583));


    }


    private static void createData() {
        Airline ryanair = new Airline("Ryanair", "FR");
        Airline lufthansa = new Airline("Lufthansa", "LH");
        Airline eurowings = new Airline("Eurowings", "EW");
        Airline condor = new Airline("Condor", "DE");

        Flughafen stuttgart = new Flughafen("Stuttgart", "STR", 1, 4, 500, 48.7758459, 9.1829321);
        Flughafen muenchen = new Flughafen("Muenchen", "MUC", 2, 2, 800, 48.135125, 11.581981);
        Flughafen london = new Flughafen("London", "LDN", 4, 5, 2000, 51.5073509, -0.1277583);
        Flughafen berlin = new Flughafen("Berlin", "BER", 2, 3, 900, 52.520007, 13.404954);
        Flughafen bigApple = new Flughafen("New-York", "JFK", 4, 6, 2000, 40.712784, -74.005941);
        Flughafen frankfurt = new Flughafen("Frankfurt", "FRA", 4, 5, 700, 50.1109221, 8.6821267);

        condor.flugzeugHinzufügen(new Flugzeug("Boeing", "Boeing 767", 258, 10550, false, false, "Stuttgart","Boeing 767 A"));
        condor.flugzeugHinzufügen(new Flugzeug("Boeing", "Boeing 767", 258, 10550, false, false, "London","Boeing 767 B"));
        condor.flugzeugHinzufügen(new Flugzeug("Boeing", "Boeing 767", 258, 10550, false, false, "Berlin", "Boeing 767 C"));
        condor.flugzeugHinzufügen(new Flugzeug("Boeing", "Boeing 767", 258, 10550, false, false, "Muenchen", "Boeing 767 D"));
        condor.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A320-200", 180, 4630, false, false, "Stuttgart","Airbus A320-200 A"));
        condor.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A320-200", 180, 4630, false, false, "Stuttgart","Airbus A320-200 B"));

        lufthansa.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A330", 440, 11750, false, false, "Berlin", "Airbus A330 A"));
        lufthansa.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A330", 440, 11750, false, false, "New-York","Airbus A330 B"));
        lufthansa.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A330", 440, 11750, false, false, "New-York","Airbus A330 C"));
        lufthansa.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A330", 440, 11750, false, false, "New-York", "Airbus A330 D"));
        lufthansa.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A330", 440, 11750, false, false, "New-York", "Airbus A330 E"));
        lufthansa.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A330", 440, 11750, false, false, "Stuttgart", "Airbus A330 F"));
        lufthansa.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A330", 440, 11750, false, false, "Stuttgart", "Airbus A330 G"));
        lufthansa.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A330", 440, 11750, false, false, "Stuttgart", "Airbus A330 H"));
        lufthansa.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A330", 440, 11750, false, false, "Frankfurt", "Airbus A330 I"));
        lufthansa.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A380", 509, 12000, false, false, "Frankfurt", "Airbus A380 A"));
        lufthansa.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A380", 509, 12000, false, false, "Frankfurt", "Airbus A380 B"));

        ryanair.flugzeugHinzufügen(new Flugzeug("Boeing", "Boeing 767", 258, 10550, false, false, "Stuttgart", "Boeing 767 A"));
        ryanair.flugzeugHinzufügen(new Flugzeug("Boeing", "Boeing 767", 258, 10550, false, false, "Berlin", "Boeing 767 B"));
        ryanair.flugzeugHinzufügen(new Flugzeug("Boeing", "Boeing 767", 258, 10550, false, false, "London", "Boeing 767 C"));
        ryanair.flugzeugHinzufügen(new Flugzeug("Boeing", "Boeing 767", 258, 10550, false, false, "London", "Boeing 767 D"));
        ryanair.flugzeugHinzufügen(new Flugzeug("Boeing", "Boeing 767", 258, 10550, false, false, "London", "Boeing 767 E"));

        eurowings.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A320-200", 180, 4630, false, false, "Muenchen","Airbus A320-200 A"));
        eurowings.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A320-200", 180, 4630, false, false, "Muenchen", "Airbus A320-200 B"));
        eurowings.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A320-200", 180, 4630, false, false, "London", "Airbus A320-200 C"));
        eurowings.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A320-200", 180, 4630, false, false, "Berlin", "Airbus A320-200 D"));
        eurowings.flugzeugHinzufügen(new Flugzeug("Airbus", "Airbus A320-200", 180, 4630, false, false, "Stuttgart", "Airbus A320-200 E"));

        airlineList.add(condor);
        airlineList.add(lufthansa);
        airlineList.add(ryanair);
        airlineList.add(eurowings);

        flughafenList.add(stuttgart);
        flughafenList.add(muenchen);
        flughafenList.add(london);
        flughafenList.add(berlin);
        flughafenList.add(bigApple);
        flughafenList.add(frankfurt);

    }

    private static double distance(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;

            return (dist);
        }
    }

}
