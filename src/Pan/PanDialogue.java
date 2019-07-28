package Pan;

import Narration.ReadStory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class PanDialogue extends JPanel implements KeyListener, ActionListener, MouseListener {
    private String fondEcran;
    private String[] personnageDial;
    private PanelInterface pan;
    private String persoDroite;
    private String persoGauche;
    private String story [];
    private int SizeStory;
    private boolean personnageParlant = true;

//    ************ Afficher les dialogues **********
    private int ligneDialogue = 0;
    private boolean affichageDial = false;
    private String affichage = "";
    private int compteurDeChar = 0;
    private Timer timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            compteurDeChar++;
            repaint();
            if(compteurDeChar == story[ligneDialogue].length()) {
                timer.stop();
                ligneDialogue++;
                affichageDial = false;
            }
        }
    });
//    **********************************************

//    ******************************* Constructeur *****************************************


    public PanDialogue(String fondEcran, String[] personnageDial,String dialogue, PanelInterface pan) {
        this.pan = pan;
        this.fondEcran = fondEcran;
        this.personnageDial = personnageDial;
        this.fondEcran = fondEcran;
        this.addMouseListener(this);

        ReadStory readStory = null;
        try {
            readStory = new ReadStory(dialogue);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.story = readStory.getStory();
        this.SizeStory = readStory.getSize();

        this.startDial();
    }

//    ********************************* Start Dial ********************************************
    private void startDial(){
        this.persoDroite = this.personnageDial[1];
        this.persoGauche = this.personnageDial[0];
        this.affichage = story[this.ligneDialogue];
        this.affichageDial = true;
        this.timer.start();
    }


//    *********************************** Paint ***********************************************
    public void paintComponent(Graphics g) {
        Image img = new javax.swing.ImageIcon(getClass().getResource(this.fondEcran)).getImage();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

//        ************************* Perso de droite *************************************
        if(!this.personnageParlant) {
            Image personnage1 = new javax.swing.ImageIcon(getClass().getResource(persoDroite)).getImage();
            g.drawImage(personnage1, 500, 150, 600, 1000, this);
        }

//        *************************** Perso de gauche *************************************
        if(this.personnageParlant) {
            Image personnage2 = new javax.swing.ImageIcon(getClass().getResource(persoGauche)).getImage();
            g.drawImage(personnage2, -20, 200, 600, 1000, this);
        }

//        ***************************** Dialogues ******************************************
        g.fillRoundRect(10, this.getHeight()-195, this.getWidth() - 20 , 175, 5, 5);

        Font f = new Font("Arial", Font.BOLD, 25);
        g.setFont(f);
        g.setColor(Color.WHITE);
        g.drawString(this.affichage.substring(0, this.compteurDeChar), 20, this.getHeight()-95);
    }
    //    *******************************************************************************************
    @Override
    public void actionPerformed(ActionEvent e) {

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
        if(this.SizeStory == ligneDialogue){
            this.pan.appel();
        } else {
            if (!this.affichageDial) {
                if (story[this.ligneDialogue].equals("")) {
                    this.personnageParlant = !this.personnageParlant;
                    ligneDialogue++;
                }
                this.compteurDeChar = 0;
                this.affichage = story[this.ligneDialogue];
                this.affichageDial = true;
                this.timer.start();
            } else {
                this.timer.stop();
                this.compteurDeChar = story[this.ligneDialogue].length();
                this.affichageDial = false;
                repaint();
                this.ligneDialogue++;
            }
        }

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
