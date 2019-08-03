package Personnage;

import Pan.Introduction.BoutonIntro.BoutonCarte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ArbreCompetence extends JPanel implements ActionListener {
    private int[] arbreMagieDuTemps;
    private int[] arbreMartial;
    private int[] arbreSocial;
    private String[] fondEcran;
    private int arbre = 0;
    private String[] arbres;
    private ArrayList<JButton> boutons = new ArrayList();
    private String[][] competenceName = {{}, {}, {}};
    private Personnage personnage;

//    ********************** Constructeur *************************************


    public ArbreCompetence(Personnage personnage) {
        this.fondEcran = new String[] {
                "/Images/MagieDuTemps.jpg",
                "/Images/Martial.jpg",
                "/Images/Social.png",
        };
        this.arbres = new String[]{
                "Arbre Magie",
                "Arbre Martial",
                "Arbre Social"
        };
        this.competenceName[0] = new String[]{
                "Magie 1",
                "Magie 2",
                "Magie 3"
        };
        this.competenceName[1] = new String[]{
                "Martial 1",
                "Martial 2",
                "Martial 3"
        };
        this.competenceName[2] = new String[]{
                "Social 1",
                "Social 2",
                "Social 3"
        };
        this.personnage = personnage;
    }

    //    ************************* Paint *******************************************
    public void paintComponent(Graphics g) {
        Image img = new javax.swing.ImageIcon(getClass().getResource(this.fondEcran[arbre])).getImage();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

//        ******** Choix arbre**********
        for(int i = 0; i < arbres.length; i++) {
            JButton arbre = new JButton(arbres[i]);
            arbre.addActionListener(this);
            arbre.setBounds(this.getWidth() - 120, 10 + 30 * i, 110, 25);
            this.add(arbre);
            this.boutons.add(arbre);
        }

        JButton competence1 = new BoutonCompetence(competenceName[arbre][0] , arbre, 0, this, personnage);
        competence1.addActionListener(this);
        competence1.setBounds(25, this.getHeight()/2, 100, 25);
        this.add(competence1);

        JButton competence2 = new BoutonCompetence(competenceName[arbre][1] , arbre, 1, this, personnage);
        competence2.addActionListener(this);
        competence2.setBounds(250, 270, 100, 25);
        this.add(competence2);

        JButton competence3 = new BoutonCompetence(competenceName[arbre][2] , arbre, 2, this, personnage);
        competence3.addActionListener(this);
        competence3.setBounds(250, 400 , 100, 25);
        this.add(competence3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == boutons.get(0)){
            this.arbre = 0;
        } else if(source == boutons.get(1)){
            this.arbre = 1;
        }else if(source == boutons.get(2)){
            this.arbre = 2;
        }
        removeAll();
        boutons = new ArrayList();
        repaint();
    }
}
