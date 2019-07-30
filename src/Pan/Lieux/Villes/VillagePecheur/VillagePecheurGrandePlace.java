package Pan.Lieux.Villes.VillagePecheur;

import Pan.Fenetre;
import Pan.Lieux.Villes.Villes;
import Pan.PanelInterface;
import Personnage.Personnage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VillagePecheurGrandePlace extends Villes implements PanelInterface, KeyListener, ActionListener, MouseListener {
    private VillagePecheursEntree entree;

    public VillagePecheurGrandePlace(Fenetre fen, VillagePecheursEntree entree, Personnage personnage) {
        super(new String[]{
                        "/Pan/Lieux/Villes/VillagePecheur/fondEcran/GrandePlace.jpg"
                }, new JButton[]{
                         new JButton("Taverne"), new JButton("Magasin"), new JButton("Entree")
                }, fen
                ,personnage
        );
        super.setEntree(entree);
        this.entree = entree;
    }

    public void paintComponent(Graphics g) {
        Image img = new javax.swing.ImageIcon(getClass().getResource(super.getFondsEcran()[0])).getImage();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

        afficherPlaces(this);
    }

        @Override
    public void appel() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == super.getBoutons()[2]) {
            deplacerEntree();
        } else if (source == super.getBoutons()[0]) {
            this.entree.deplacerTaverne();
        } else if (source == super.getBoutons()[1]) {
            this.entree.deplacerMagasin();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
