package Pan.Lieux.Villes.VillagePecheur;

import Pan.Fenetre;
import Pan.Lieux.Villes.Villes;
import Pan.PanelInterface;
import Personnage.Personnage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VillagePecheursEntree extends Villes implements PanelInterface, KeyListener, ActionListener, MouseListener {
    private VillagePecheurGrandePlace grandePlace;
    private VillagePecheurTaverne taverne;
    private VillagePecheurMagasin magasin;

    public VillagePecheursEntree(Fenetre fen, Personnage personnage) {
        super(new String[]{
                "/Pan/Lieux/Villes/VillagePecheur/fondEcran/villagePecheurEntree.jpg"
            }, new JButton[]{
                    new JButton("Grande place"), new JButton("Taverne"), new JButton("Magasin")
            }, fen
            ,personnage

        );
        super.setEntree(this);
        this.addMouseListener(this);
        this.grandePlace = new VillagePecheurGrandePlace(fen, this, personnage);
        this.taverne = new VillagePecheurTaverne(fen, this, personnage);
        this.magasin = new VillagePecheurMagasin(fen, this, personnage);
    }

    public void paintComponent(Graphics g) {
        Image img = new javax.swing.ImageIcon(getClass().getResource(super.getFondsEcran()[0])).getImage();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

        afficherPlaces(this);
    }

//    ***********************************************************************************************
    @Override
    public void appel() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == super.getBoutons()[0]){
            deplacerGrandPlace();
        } else if(source == super.getBoutons()[1]){
            deplacerTaverne();
        }else if(source == super.getBoutons()[2]){
            deplacerMagasin();
        }
    }

    public void deplacerGrandPlace(){
        super.getFen().setPanel(this.grandePlace);
        super.getFen().setContentPane(this.grandePlace);
        super.getFen().getPanel().repaint();
        super.getFen().getContentPane().revalidate();
        this.grandePlace.appel();
    }

    public void deplacerTaverne(){
        super.getFen().setPanel(this.taverne);
        super.getFen().setContentPane(this.taverne);
        super.getFen().getPanel().repaint();
        super.getFen().getContentPane().revalidate();
        this.taverne.appel();
    }

    public void deplacerMagasin(){
        super.getFen().setPanel(this.magasin);
        super.getFen().setContentPane(this.magasin);
        super.getFen().getPanel().repaint();
        super.getFen().getContentPane().revalidate();
        this.magasin.appel();
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
