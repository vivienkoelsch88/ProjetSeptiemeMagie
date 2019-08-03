package Pan.CombatAll;

import Monstres.Monstres;
import Pan.Combat;
import Pan.Fenetre;
import Pan.Introduction.BoutonIntro.BoutonCarte;
import Pan.PanDialogue;
import Personnage.Personnage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BattelRound extends JPanel implements Combat, MouseListener, ActionListener {
    private Fenetre fen;
    private Personnage personnage;
    private String fondEcran;
    private String message;
    private int placementJoueur;
    private int placementMonstre;
    private Monstres monstre;
    private int compteur = 0;
    private boolean afficherCarte = false;
    private boolean afficherMain = false;
    private JButton plusInvest = new JButton("+");
    private JButton moinsInvest = new JButton("-");
    private JButton boutonInvest = new JButton("0");
    private int[] actionsCarte = {0, 0, 0};
    private int personnageDefense = 0;
    private int[] placementDommages = {0, 0};
    private int dommages = 0;

    private Timer timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            placementDommages[1]--;
            if(placementDommages[1] == -40){
                dommages = 0;
                timer.stop();
            }
            repaint();
        }
    });


//    ******************************* Constructeur **********************

    public BattelRound(Fenetre fen, Personnage personnage, String fondEcran, Monstres monstre) {
        this.fen = fen;
        this.personnage = personnage;
        this.fondEcran = fondEcran;
        this.monstre = monstre;
        this.message = monstre.getName() + " vous attaque...";
        placementJoueur = 4;
        placementMonstre = 6;
        this.addMouseListener(this);
    }

//    *************************************** Paint ****************************
public void paintComponent(Graphics g) {
    Image img = new javax.swing.ImageIcon(getClass().getResource(this.fondEcran)).getImage();
    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);


//        ******************************* Zone de combat **********************************
    int uniteX = (getWidth()) / 11;

    g.setColor(Color.black);
    Graphics2D g1 = (Graphics2D) g;
    BasicStroke line = new BasicStroke(4.0f);
    g1.setStroke(line);


    for (int i = 0; i < 10; i++) {
        g.drawLine(uniteX * (i + 1), 200, uniteX * (i + 1), 350);
    }
    g.drawLine(uniteX, 200, getWidth() - uniteX - 5, 200);
    g.drawLine(uniteX, 350, getWidth() - uniteX - 5, 350);

    g.setColor((Color.GRAY));
    g.fillRoundRect(50, 365, this.getWidth() - 100, 80, 5, 5);
    Font font = new Font("desc", Font.BOLD, 25);
    g.setFont(font);
    g.setColor((Color.WHITE));
    g.drawString(message, 80, 410);


//            ************************** Monstre et héro ********************************

    Image img2 = new javax.swing.ImageIcon(getClass().getResource(monstre.getGif())).getImage();
    g.drawImage(img2, uniteX * placementMonstre, 210, uniteX, 120, this);

    Image img3 = new javax.swing.ImageIcon(getClass().getResource(personnage.getGif())).getImage();
    g.drawImage(img3, uniteX * placementJoueur, 210, uniteX, 120, this);

//        **************************** Dommages ****************************************
    g.setColor((Color.RED));
    font = new Font("desc", Font.BOLD, 35);
    g.setFont(font);
    if(dommages > 0) {
        g.drawString("" + dommages, placementDommages[0] * uniteX + (uniteX/3), placementDommages[1] + 200);
    }
    g.setColor((Color.WHITE));
    font = new Font("desc", Font.BOLD, 25);
    g.setFont(font);

//        ******************************** fenetre du joueur ******************************************************
    g.setColor((Color.GRAY));
    g.fillRoundRect(5, 5, this.getWidth() / 4, this.getHeight() / 4, 5, 5);
    font = new Font("desc", Font.BOLD, 15);
    g.setFont(font);
    g.setColor((Color.WHITE));
    g.drawString("Concentration : " + this.personnage.getConcentration(), 15, 30);
    g.drawString("Adresse : " + this.personnage.getAdresse(), 15, 50);
    g.drawString("Charisme : " + this.personnage.getCharisme(), 15, 70);
    g.drawString("Force : " + this.personnage.getForce(), 15, 90);
    g.drawString("Attaque : " + this.personnage.getAttaque() + "  Défense : " + (this.personnage.getDefense() + this.personnageDefense), 15, 110);
    g.drawString("Portée : " + this.personnage.getPortee(), 15, 130);
    g.drawString("Vie : " + this.personnage.getLife(), 15, 150);

//        ************************************** Afficher carte **********************************************

    if(afficherMain){
        for(int i = 0; i < 3; i++) {
            JButton carte = new JButton(new BoutonCarte(this));
            carte.addActionListener(this);
            carte.setBounds(50 + i * 125, this.getHeight() - 190, 120, 160);
            this.add(carte);
        }
    }

//        ********************************* Afficher la carte choisie par le joueur ***************************
    if(afficherCarte){
        Image carte = new javax.swing.ImageIcon(getClass().getResource("/Cartes/ImageCartes/Cartedebase.png")).getImage();
        g.drawImage(carte, 255, 20, this.getWidth()/2, this.getHeight() - 50, this);
    }
}


    @Override
    public void attaquer(int puissance) {
        this.dommages = this.monstre.prendreDommage(puissance);
        this.placementDommages = new int[]{this.placementMonstre, 0};
        timer.start();
    }

    @Override
    public void defendre(int puissance) {
            this.personnageDefense = this.personnageDefense + puissance;
    }

    @Override
    public void avancer(int nbrCase) {
        this.placementJoueur++;
        if(placementJoueur >= placementMonstre){
            placementJoueur = placementMonstre - 1;
        }
    }

    @Override
    public Personnage getPersonnage() {
        return personnage;
    }

    @Override
    public Monstres getMonstre() {
        return monstre;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void MAttaquer(int puissance) {
        this.placementJoueur++;
        if(placementJoueur >= placementMonstre){
            placementJoueur = placementMonstre - 1;
        }
    }

    @Override
    public void MDefendre(int puissance) {
        this.personnageDefense = this.personnageDefense + puissance;
    }

    @Override
    public void MAvancer(int nbrCase) {
        this.placementJoueur++;
        if(placementJoueur >= placementMonstre){
            placementJoueur = placementMonstre - 1;
        }
    }

    @Override
    public void afficherCarte() {
        afficherMain = false;
        afficherCarte = true;
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
