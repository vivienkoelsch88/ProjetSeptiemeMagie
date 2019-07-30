package Pan.Lieux.Villes;

import Pan.Fenetre;
import Personnage.Personnage;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class Villes extends JPanel implements ActionListener {
    private String[] fondsEcran;
    private JButton[] boutons;
    private Fenetre fen;
    private Villes entree;
    private Personnage personnage;

    public Villes(String[] fondsEcran, JButton[] boutons, Fenetre fen, Personnage personnage) {
        this.fondsEcran = fondsEcran;
        this.boutons = boutons;
        this.fen = fen;
        this.personnage = personnage;
    }

    public void deplacerEntree(){
        this.fen.setPanel(this.entree);
        this.fen.setContentPane(this.entree);
        this.fen.getPanel().repaint();
        this.fen.getContentPane().revalidate();
        this.entree.appel();
    }

//    ***********************************************************

    public void afficherPlaces(Villes villes){
        for(int i = 0; i < boutons.length; i++){
                JButton lieu = boutons[i];
                lieu.addActionListener(villes);
                lieu.setBounds(this.getWidth() - 120, 10 + 30 * i, 110, 25);
                villes.add(lieu);
        }
    }

    public String[] getFondsEcran() {
        return fondsEcran;
    }

    public void setFondsEcran(String[] fondsEcran) {
        this.fondsEcran = fondsEcran;
    }

    public JButton[] getBoutons() {
        return boutons;
    }

    public void setBoutons(JButton[] boutons) {
        this.boutons = boutons;
    }

    public Villes getEntree() {
        return entree;
    }

    public void setEntree(Villes entree) {
        this.entree = entree;
    }

    public Fenetre getFen() {
        return fen;
    }

    public void setFen(Fenetre fen) {
        this.fen = fen;
    }

    public abstract void appel();



}
