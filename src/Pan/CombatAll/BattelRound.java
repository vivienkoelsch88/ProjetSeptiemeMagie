package Pan.CombatAll;

import Cartes.Force.VolDeLange;
import Monstres.Monstres;
import Pan.Combat;
import Pan.Fenetre;
import Pan.Introduction.BoutonIntro.BoutonCarte;
import Pan.PanDialogue;
import Pan.PanelInterface;
import Personnage.Personnage;
import Personnage.AfficheStats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BattelRound extends JPanel implements Combat, MouseListener, ActionListener, PanelInterface {
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
    private JButton effet1 = new JButton("" + this.investissementEffet1);
    private JButton effet2 = new JButton("" + this.investissementEffet2);
    private int[] actionsCarte = {0, 0, 0};
    private int idCarteChoisie = 0;
    private int personnageDefense = 0;
    private int[] placementDommages = {0, 0};
    private int dommages = 0;
    private int investissement = 0;
    private int investissementEffet1 = 0;
    private int investissementEffet2 = 0;
    private JButton plus = new JButton("+");
    private JButton moins = new JButton("-");
    private JButton invest = new JButton("" + this.investissement);

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
        moins.addActionListener(this);
        plus.addActionListener(this);
        effet1.addActionListener(this);
        effet2.addActionListener(this);

        personnage.ajouterCarteAuDeck(new VolDeLange());
        personnage.ajouterCarteAuDeck(new VolDeLange());
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
    JComponent jComponent = new AfficheStats(this.personnage, this);
    this.add(jComponent);

//        ************************************** Afficher carte **********************************************

    if(afficherMain){
        for(int i = 0; i < personnage.getDeck().size(); i++) {
            JButton carte = new JButton(new BoutonCarte(this, personnage.getDeck().get(i).getName(), i));
            carte.addActionListener(this);
            carte.setBounds(50 + i * 125, this.getHeight() - 190, 120, 160);
            this.add(carte);
        }
    }

//        ********************************* Afficher la carte choisie par le joueur ***************************
    if(afficherCarte){
        Image carte = new javax.swing.ImageIcon(getClass().getResource(personnage.getDeck().get(this.idCarteChoisie).getImage())).getImage();
        g.drawImage(carte, 255, 20, this.getWidth()/2, this.getHeight() - 50, this);

        plus.setBounds(550, 550 , 45, 35);
        this.add(plus);

        moins.setBounds(370, 550 , 45, 35);
        this.add(moins);

        invest.setBounds(445, 550 , 75, 35);
        invest.setText("" + investissement);
        this.add(invest);

        effet1.setBounds(300, 430 , 45, 35);
        effet1.setText("" + investissementEffet1);
        this.add(effet1);

        effet2.setBounds(300, 500 , 45, 35);
        effet2.setText("" + investissementEffet2);
        this.add(effet2);
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
    public void afficherCarte(int id) {
        this.removeAll();
        this.idCarteChoisie = id;
        afficherMain = false;
        afficherCarte = true;
        compteur++;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getComponent());
        switch (compteur) {
            case 0:
                this.message = "Choix action";
                afficherMain = true;
                compteur++;
                break;

            case 2 :
                if(e.getX() < 254 || e.getX() > 745  || e.getY() < 19 && e.getY() > 630) {
                    this.removeAll();
                    afficherMain = true;
                    afficherCarte = false;
                    compteur = 1;
                    investissement = 0;
                    investissementEffet1 = 0;
                    investissementEffet2 = 0;
                }
                break;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == this.plus){
            this.removeAll();
            this.investissement++;
            if(investissement + investissementEffet1 + investissementEffet2 > personnage.getDeck().get(this.idCarteChoisie).getNiveau() * 10){
                this.investissement--;
            }
        }
        if(source == this.moins){
            this.removeAll();
            this.investissement--;
            if(investissement < 0){
                this.investissement = 0;
            }
        }

        if(source == this.effet1){
            this.removeAll();
            if(investissementEffet1 == 0) {
                this.investissementEffet1 = personnage.getDeck().get(idCarteChoisie).getCoutEffet1();
                if (investissement + investissementEffet1 + investissementEffet2 > personnage.getDeck().get(this.idCarteChoisie).getNiveau() * 10) {
                    this.investissement = personnage.getDeck().get(this.idCarteChoisie).getNiveau() * 10 - investissementEffet1 - investissementEffet2;
                }
            } else {
                investissementEffet1 = 0;
            }
        }

        if(source == this.effet2){
            this.removeAll();
            if(investissementEffet2 == 0) {
                this.investissementEffet2 = personnage.getDeck().get(idCarteChoisie).getCoutEffet2();
                if (investissement + investissementEffet2 + investissementEffet1 > personnage.getDeck().get(this.idCarteChoisie).getNiveau() * 10) {
                    this.investissement = personnage.getDeck().get(this.idCarteChoisie).getNiveau() * 10 - investissementEffet2 - investissementEffet1;
                }
            } else {
                investissementEffet2 = 0;
            }
        }
    }

    @Override
    public void appel() {

    }


}
