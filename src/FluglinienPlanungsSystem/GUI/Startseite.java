/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FluglinienPlanungsSystem.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kris
 */
public class Startseite {

    public Startseite() {
        JFrame frame = new JFrame();
        frame.setTitle("Startseite");
        frame.setSize(700, 600);
        frame.setLayout(new BorderLayout());
        JPanel panelMitte = new JPanel();
        JPanel panelUnten = new JPanel();
        panelMitte.setLayout(new GridLayout(1, 2));
        panelUnten.setLayout(new GridLayout(1,1));
        // JLabel text = new JLabel("Wählen Sie bitte eine Option.");
        // frame.add(text, BorderLayout.NORTH);
        JButton buttonFlugPlanErstellen = new JButton("Flugplaene erstellen");
        buttonFlugPlanErstellen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FlugplaeneErstellen flugplaeneErstellen = new FlugplaeneErstellen();
                frame.setVisible(false);
            }
        });
        panelMitte.add(buttonFlugPlanErstellen);
        JButton button2 = new JButton("Flugplan");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FlugplanAnsicht flugplanAnsicht = new FlugplanAnsicht();
                frame.setVisible(false);
            }
        });
        panelMitte.add(button2);
        JButton button3 = new JButton("schließen");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //KundeBearbeiten kundeBearbeiten = new KundeBearbeiten();
                frame.setVisible(false);
            }
        });
        panelMitte.add(button2);
        panelUnten.add(button3);
        frame.add(panelMitte, BorderLayout.CENTER);
        frame.add(panelUnten, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
