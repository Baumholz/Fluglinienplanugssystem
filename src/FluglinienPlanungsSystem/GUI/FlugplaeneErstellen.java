package FluglinienPlanungsSystem.GUI;

import FluglinienPlanungsSystem.Airline;
import FluglinienPlanungsSystem.Flughafen;
import FluglinienPlanungsSystem.Flugplan;
import FluglinienPlanungsSystem.Planungssystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.MenuSelectionManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FlugplaeneErstellen{

    JLabel labelStartZeit, labelFehler,labelVonFlughafen,labelNachFlughafen,labelPunkt;
    JComboBox cbVonFlughafen, cbNachFlughafen,cbJahr, cbMonat, cbTag, cbStunde, cbMinute;
    JMenu menuAirline, submenuFlotte;
    JButton buttonFlugPlanen ,buttonZurueck;
    String[] selectedMenuItem = new String[6];



    public FlugplaeneErstellen() {
        JFrame frame = new JFrame();
        frame.setTitle("Flugplaene erstellen");
        frame.setSize(700, 600);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);      //Fenster ist nun nicht mehr dynamisch veränderbar
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        
        String tmpFlughafen[] = new String[Planungssystem.flughafenList.size()];
        for (int i = 0; i < tmpFlughafen.length; i++) {
            tmpFlughafen[i] = Planungssystem.flughafenList.get(i).name;
        }

        cbVonFlughafen = new JComboBox(tmpFlughafen);
        cbNachFlughafen = new JComboBox(tmpFlughafen);
        cbVonFlughafen.setBounds(80, 50, 100, 30);
        cbNachFlughafen.setBounds(350, 50, 100, 30);
        cbTag = new JComboBox(getTage());
        cbMonat = new JComboBox(getMonate());
        cbStunde = new JComboBox(getStunden());
        cbMinute = new JComboBox(getMinuten());
        cbJahr = new JComboBox(getJahre());
        labelPunkt = new JLabel(":");
        labelVonFlughafen = new JLabel("Von: ");
        labelNachFlughafen = new JLabel("Nach: ");
        labelFehler = new JLabel();
        labelVonFlughafen.setBounds(50, 50, 100, 30);
        labelNachFlughafen.setBounds(315, 50, 100, 30);

        labelFehler.setBounds(175,400,350,50);

        cbTag.setBounds(80,150,100,30);
        cbMonat.setBounds(200,150,100,30);
        cbJahr.setBounds(320,150,100,30);
        cbStunde.setBounds(440,150,100,30);
        labelPunkt.setBounds(550,150,100,30);
        cbMinute.setBounds(560,150,100,30);

        labelFehler.setForeground(Color.RED);

        menuAirline = new JMenu("Airlines: ");
        JMenuBar mb=new JMenuBar();
        mb.add(menuAirline);
        //menuAirline.addActionListener(this);

        for (int i = 0; i < Planungssystem.airlineList.size(); i++) {

            String tmpAirlineName = Planungssystem.airlineList.get(i).name;
            submenuFlotte=new JMenu(tmpAirlineName);
           //submenuFlotte.addActionListener(this);

            for(int ii = 0; ii < Planungssystem.airlineList.get(i).flotte.size();ii++){
                String tempFlugzeugName = Planungssystem.airlineList.get(i).flotte.get(ii).name;
                JMenuItem tempMenuItem = new JMenuItem(tempFlugzeugName);
                //tempMenuItem.addActionListener(this);
                submenuFlotte.add(tempMenuItem);

            }
            menuAirline.add(submenuFlotte);
        }
        mb.setBounds(80, 100, 100, 30);

        labelStartZeit = new JLabel("Tag: ");

        labelStartZeit.setBounds(50,150,100,30);

        buttonFlugPlanen = new JButton("Flug planen");
        buttonFlugPlanen.setBounds(300,300,100,100);

        buttonZurueck = new JButton("Zurück");
        buttonZurueck.setBounds(150,300,100,100);


        MenuSelectionManager.defaultManager().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {

                MenuElement[] path = MenuSelectionManager.defaultManager()
                        .getSelectedPath();

                for (int i = 0; i < path.length; i++) {
                    Component c = path[i].getComponent();

                    if (c instanceof JMenuItem) {
                        JMenuItem mi = (JMenuItem) c;
                        selectedMenuItem[i] = mi.getText();
                    }
                }

            }
        });


        buttonFlugPlanen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {


                    String startFlughafenString = String.valueOf(cbVonFlughafen.getSelectedItem());
                    String zielFlughafenString = String.valueOf(cbNachFlughafen.getSelectedItem());

                    try {

                        if (startFlughafenString != zielFlughafenString) {
                            labelFehler.setText("");
                            labelFehler.setForeground(Color.RED);

                            String tag = String.valueOf(cbTag.getSelectedItem());
                            String monat = String.valueOf(cbMonat.getSelectedItem());
                            String jahr = String.valueOf(cbJahr.getSelectedItem());
                            String stunde = String.valueOf(cbStunde.getSelectedItem());
                            String minute = String.valueOf(cbMinute.getSelectedItem());

                            String datumString = tag + "/" + monat + "/" + jahr + " " + stunde + ":" + minute;
                            Date date = null;
                            try {
                                date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(datumString);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            System.out.println(date);

                            //SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy HH:mm");
                            Date currentDate = new Date(System.currentTimeMillis());

                            if (currentDate.compareTo(date) < 0) {

                                System.out.println("CurrentDate  occurs before Date 2");
                                Date datumMitCheckIn = addTime(date, -60);
                                System.out.println("Checkin: " + datumMitCheckIn);
                                if (currentDate.compareTo(datumMitCheckIn) < 0) {
                                    Flughafen tmpStartFlughafen = null;
                                    Flughafen tmpZielFlughafen = null;

                                    for (int i = 0; i < Planungssystem.flughafenList.size(); i++) {
                                        if (startFlughafenString.equals(Planungssystem.flughafenList.get(i).name)) {
                                            tmpStartFlughafen = Planungssystem.flughafenList.get(i);
                                        }
                                        if (zielFlughafenString.equals(Planungssystem.flughafenList.get(i).name)) {
                                            tmpZielFlughafen = Planungssystem.flughafenList.get(i);
                                        }
                                    }

                                    Double flugStrecke = distanz(tmpStartFlughafen.lat, tmpStartFlughafen.lon, tmpZielFlughafen.lat, tmpZielFlughafen.lon);
                                    int flugzeit = benoetigteZeitInMinuten(flugStrecke);
                                    Date datumDerLandung = addTime(date, flugzeit);
                                    datumDerLandung = addTime(datumDerLandung, 60);//Wartung

                                    String selectedMenuItemAirline = selectedMenuItem[3];
                                    String selectedMenuItemFlugzeug = selectedMenuItem[5];
                                    if (selectedMenuItemAirline != null && selectedMenuItemFlugzeug != null) {  // überprüft ob ein Flugzeug gewählt wurde
                                        Airline tmpAirline = null;
                                        for (int i = 0; i < Planungssystem.airlineList.size(); i++) {
                                            if (selectedMenuItemAirline == Planungssystem.airlineList.get(i).name) {  //falls es sich um die selbe Airline handelt wähle sie
                                                for (int ii = 0; ii < Planungssystem.airlineList.get(i).flotte.size(); ii++) {

                                                    if (selectedMenuItemFlugzeug == Planungssystem.airlineList.get(i).flotte.get(ii).name) { //falls es sich um das selbe Flugzeug handel wähle es

                                                        if (Planungssystem.airlineList.get(i).flotte.get(ii).reichweite > flugStrecke) { // prüft ob das Flugzeug die erforderte Strecke auch fleigen kann
                                                            System.out.println("Reichweite des FLugzeuges: " + Planungssystem.airlineList.get(i).flotte.get(ii).reichweite);
                                                            if (Planungssystem.airlineList.get(i).flotte.get(ii).flugHinzufügen(datumMitCheckIn, datumDerLandung)) { //Prüft ob das gewählte Datum frei ist und fügt das neue Datum des Fluges wenn möglich dazu
                                                                Planungssystem.flugPlanList.add(new Flugplan(startFlughafenString, zielFlughafenString, selectedMenuItemAirline, selectedMenuItemFlugzeug, flugStrecke, datumMitCheckIn, datumDerLandung));
                                                                labelFehler.setForeground(Color.GREEN);
                                                                labelFehler.setText("Flugplan erfolgreich erstellt.");
                                                            } else {
                                                                labelFehler.setText("Bitte wählen sie ein anderes Datum.");
                                                            }
                                                        } else {
                                                            labelFehler.setText("Bitte wählen sie ein Flugzeug mit einer höhren Reichweite.");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        labelFehler.setText("Bitte Flugzeug wählen.");
                                    }
                                    System.out.println("Distanz: " + flugStrecke);
                                    System.out.println("Benötigte Zeit: " + benoetigteZeitInMinuten(flugStrecke));
                                } else {
                                    labelFehler.setText("Bitte ein Datum wählen das in der Zukunft liegt.");
                                }
                            } else {
                                labelFehler.setText("Bitte ein Datum wählen das in der Zukunft liegt.");
                            }

                        } else {
                            labelFehler.setText("Bitte unterschiedlichen Start- und Ankunftsort wählen.");
                        }

                    }catch (Exception exception){
                        System.out.println("Error :"+exception);
                    }
            }
        });


        buttonZurueck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                Startseite startseite = new Startseite();
            }
        });

        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));

        frame.add(cbTag);
        frame.add(cbMonat);
        frame.add(cbStunde);
        frame.add(cbMinute);
        frame.add(cbJahr);
        frame.add(labelPunkt);
        frame.add(labelFehler);
        frame.add(buttonFlugPlanen);
        frame.add(buttonZurueck);
        frame.add(labelStartZeit);
        frame.add(mb);
        frame.add(labelVonFlughafen);
        frame.add(cbVonFlughafen);
        frame.add(labelNachFlughafen);
        frame.add(cbNachFlughafen);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private Date addTime(Date date, int extraZeitInMinuten){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE,extraZeitInMinuten);
        date = calendar.getTime();
        return date;
    }

    private String[] getMinuten(){
        String[] minutenStringArray = new String[4];
        minutenStringArray[0] = "00";
        minutenStringArray[1] = "15";
        minutenStringArray[2] = "30";
        minutenStringArray[3] = "45";
        return minutenStringArray;
    }

    private String[] getStunden(){
        String[] stundenStringArray = new String[24];
        for(int i = 0; i<24;i++){
            stundenStringArray[i] = String.valueOf(i);
        }
        return  stundenStringArray;
    }

    private String[] getMonate(){
        String[] monateStringArray = new String[12];
        for(int i = 1; i <= 12;i++){
            monateStringArray[i-1]=String.valueOf(i);
        }
        return monateStringArray;
    }

    private String[] getTage(){
        String[] tageStringArray = new String[30];
        for(int i = 1; i <= 30;i++){
            tageStringArray[i-1] = String.valueOf(i);
        }
        return  tageStringArray;
    }

    private String[] getJahre(){
        String[] jahreStringArray = new String[21];
        for(int i=2020;i <= 2040;i++){
            jahreStringArray[i-2020] = String.valueOf(i);
        }
        return  jahreStringArray;
    }

    private static double distanz(double lat1, double lon1, double lat2, double lon2) {
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

    private int benoetigteZeitInMinuten(double distanz){
        // 500Km/h
        double minutenDouble = distanz/(500/60);
        int minuten = (int) minutenDouble;
        return minuten;
    }

}
