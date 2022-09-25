package FluglinienPlanungsSystem.GUI;

import FluglinienPlanungsSystem.Planungssystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlugplanAnsicht {

    private JTable table = new JTable(); //hier sieht man die Flugzeugpläne

    public FlugplanAnsicht(){
        JFrame frame = new JFrame();
        frame.setTitle("Startseite");
        frame.setSize(700, 600);
        frame.setLayout(new BorderLayout());
        JPanel panelUnten = new JPanel();
        JPanel panelMitte = new JPanel();
        panelUnten.setLayout(new GridLayout(1, 2));

        JButton buttonZurueck = new JButton("Zurück");
        buttonZurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                Startseite startseite = new Startseite();
            }
        });

        table = erstelleTable();
        panelMitte.add(table);
        JScrollPane scroll = new JScrollPane(table);
        panelUnten.add(buttonZurueck);

        //frame.add(table,BorderLayout.CENTER);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(panelUnten, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JTable erstelleTable(){
        String[] ueberschrift = {"Von", "Nach", "Airline", "Flugzeug", "Startpunkt", "Ankunft","Strecke"};
        Object[][] eintraege = new Object[50][7];

        for(int i = 0; i < Planungssystem.flugPlanList.size();i++){
            eintraege[i][0] = Planungssystem.flugPlanList.get(i).startFlughafen;
            eintraege[i][1] = Planungssystem.flugPlanList.get(i).zielFlughafen;
            eintraege[i][2] = Planungssystem.flugPlanList.get(i).verwendeteAirline;
            eintraege[i][3] = Planungssystem.flugPlanList.get(i).verwendetesFlugzeug;
            eintraege[i][4] = Planungssystem.flugPlanList.get(i).startDatum;
            eintraege[i][5] = Planungssystem.flugPlanList.get(i).landeDatum;
            eintraege[i][6] = Planungssystem.flugPlanList.get(i).strecke;
        }

        JTable tmpJTable = new JTable(eintraege,ueberschrift);
        return tmpJTable;
    }

}
