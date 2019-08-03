package Pan;

import Personnage.ArbreCompetence;
import Monstres.Monstres;
import Monstres.ChevalierNoirIntro;
import Pan.CombatAll.BattelRound;
import Pan.Introduction.PresentationPersonnages;
import Pan.Lieux.Villes.VillagePecheur.VillagePecheursEntree;

import javax.swing.*;
import Personnage.Personnage;


public class Fenetre  extends JFrame{
    private JPanel panel;
    private Map map;

//    ***************************** Constructeur *************************************************
    public Fenetre(){
        this.setTitle("La 7ème magie");
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        this.setVisible(true);
    }
//************************************** Nouveau Pan *************************************************
    public void intro (){
        this.panel = new Intro(this);
        this.setContentPane(panel);
        panel.repaint();
        this.getContentPane().revalidate();
    }

//    ************************************* Pour le developement ****************************************
    public void suite(){

//        ******************** Debut ****************************************
//        this.panel = new PresentationPersonnages(this);
//        this.setContentPane(panel);
//        panel.repaint();
//        this.getContentPane().revalidate();

//        ************************** CombatAll intro **********************************************************************************
//        PresentationPersonnages presentationPersonnages = new PresentationPersonnages(this);
//        this.setContentPane(presentationPersonnages);
//        presentationPersonnages.repaint();
//        this.getContentPane().revalidate();
//        presentationPersonnages.appel();

//        ************************************* Aventure ***************************************
//        this.panel = new Map(this);
//        setContentPane(panel);
//        panel.repaint();
//        this.getContentPane().revalidate();

//        ****************************** Ville ***********************************
//        this.panel = new VillagePecheursEntree(this, new Personnage());
//        setContentPane(panel);
//        panel.repaint();
//        this.getContentPane().revalidate();

//        ******************************** Un combat *************************************
          this.panel = new BattelRound(this, new Personnage(), "/Narration/IntroPersonnage/incendie.jpg", new ChevalierNoirIntro());
          setContentPane(panel);
          panel.repaint();
          this.getContentPane().revalidate();

//        ********************************** Arbre de compétence ***************************
//        this.panel = new ArbreCompetence(new Personnage());
//        setContentPane(panel);
//        panel.repaint();
//        this.getContentPane().revalidate();
    }

//    ******************************************************************************************


    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
