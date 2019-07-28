package Pan.Introduction;

import Monstres.Monstres;
import Pan.Fenetre;
import Pan.Introduction.BoutonIntro.BoutonCarte;
import Pan.PanelInterface;
import Personnage.Personnage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CombatIntro extends JPanel implements PanelInterface, KeyListener, ActionListener, MouseListener {
    private Fenetre fen;
    private Personnage personnage;
    private String fondEcran;
    private String message;
    private int placementJoueur;
    private int placementMonstre;
    private Monstres monstre;
    private int compteur = 0;
    private int[] placementTuto = {0,0};
    private String[] explicationsTuto = {""};
    private boolean afficherCarte = false;
    private boolean afficherMain = false;
    private int[] placementFleche = {0,0};
    private int fleche = 0;
    private JButton defendre = new JButton("3");
    private JButton plusInvest = new JButton("+");
    private JButton moinsInvest = new JButton("-");
    private JButton boutonInvest = new JButton("0");
    private int[] actionsCarte = {0, 0, 0};


    private Timer timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    });

//    ******************************* Constructeur **********************

    public CombatIntro(Fenetre fen, Personnage personnage, String fondEcran, Monstres monstre) {
        this.fen = fen;
        this.personnage = personnage;
        this.fondEcran = fondEcran;
        this.monstre = monstre;
        this.message = "Alors les combats, voyons comment ça marche...";
        placementJoueur = 4;
        placementMonstre = 6;
        this.addMouseListener(this);
    }

    //    ************************************** Paint ******************************************
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
        g.drawString("Attaque : " + this.personnage.getAttaque() + "  Défense : " + this.personnage.getDefense(), 15, 110);
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

//        ************************************ Placement du tuto *********************************************
        if (explicationsTuto[0].equals("")) {
        } else {
            g.setColor((Color.GRAY));
            g.fillRoundRect(placementTuto[0], placementTuto[1], this.getWidth() / 2 + 50, 20 * explicationsTuto.length, 5, 5);
            font = new Font("desc", Font.BOLD, 15);
            g.setFont(font);
            g.setColor((Color.WHITE));
            for (int i = 0; i < explicationsTuto.length; i++) {
                g.drawString(explicationsTuto[i], placementTuto[0] + 15, placementTuto[1] + 22 + i * 15);
            }
        }

        if(fleche == 1){
            Image flecheDroite = new javax.swing.ImageIcon(getClass().getResource("/Images/flecheVersDroite.png")).getImage();
            g.drawImage(flecheDroite, placementFleche[0], placementFleche[1], 120, 50, this);
        }
        if(fleche == 2){
            Image flecheGauche = new javax.swing.ImageIcon(getClass().getResource("/Images/flecheVersGauche.png")).getImage();
            g.drawImage(flecheGauche, placementFleche[0], placementFleche[1], 120, 50, this);
        }
    }
//    ******************************** Appel *******************************


    @Override
    public void appel() {

    }

//    ************************************* OnClick ***********************************
    @Override
    public void mousePressed(MouseEvent e) {
        switch (compteur){
            case 0 :
                this.message = "Premièrement on voit en haut à gauche vos statistiques";
                compteur++;
                break;

            case 1 :
                placementTuto = new int[]{270, 5};
                explicationsTuto = new String[]{"La concentration", "Elle représente votre mental", "Votre capacité à tenir sous la pression, votre courage", "et votre nombre de carte en main de départ"};
                compteur++;
                break;

            case 2 :
                placementTuto = new int[]{270, 25};
                explicationsTuto = new String[]{"L'adresse", "Elle représente votre agilité physique", "Votre capacité à vous déplacer, votre rapidité", "et votre précision"};
                compteur++;
                break;

            case 3 :
                placementTuto = new int[]{270, 45};
                explicationsTuto = new String[]{"Le charisme", "Représentant vos capacités sociales", "Il influe sur la vision qu'on vous porte", "votre capacité de commandement, à intimider et à plaire"};
                compteur++;
                break;

            case 4 :
                placementTuto = new int[]{270, 65};
                explicationsTuto = new String[]{"La force", "Elle représente votre force physique et votre endurance", ""};
                compteur++;
                break;

            case 5 :
                placementTuto = new int[]{270, 85};
                explicationsTuto = new String[]{"L'attaque, la défense et la portée", "Vos statistiques de combat principales", "elles influent sur les dommages que vous infligez ", "sur ceux que vous recevez et bien sûr", "sur la portée de vos attaques"};
                compteur++;
                break;

            case 6 :
                placementTuto = new int[]{270, 125};
                explicationsTuto = new String[]{"Et enfin votre vie", "Trés simple, si votre vie tombe à 0, vous mourez", ""};
                compteur++;
                break;

            case 7 :
                placementTuto = new int[]{270, 5};
                explicationsTuto = new String[]{"Vos statistiques sont représentées par un nombre", "Ces points de statistique peuvent être utiliser pour améliorer vos actions",
                        "On appelle ça \"l'investissement\"", "", "Plus vous investissez dans une action,", "plus elle sera efficace, mais attention,", "vos points sont limités"};
                compteur++;
                break;

            case 8 :
                placementTuto = new int[]{270, 5};
                explicationsTuto = new String[]{""};
                this.message = "Maintenant voilà vos cartes, essayez de cliquer sur l'une d'elle";
                afficherMain = true;
                compteur++;
                break;

            case 10 :
                fleche = 1;
                placementFleche = new int[]{230, 80};
                placementTuto = new int[]{200, 200};
                explicationsTuto = new String[]{" ", "Alors, ici, simplement le nom de la carte", ""};
                compteur++;
                break;

            case 11 :
                placementFleche = new int[]{160, 320};
                explicationsTuto = new String[]{" ", "Ici, on trouve l'attribut lié à la care", "Ainsi que son type d'action", ""};
                compteur++;
                break;

            case 12 :
                fleche = 2;
                placementFleche = new int[]{720, 60};
                explicationsTuto = new String[]{" ", "Un symbole pour repérer plus son type d'action", "Ici le symbole d'une attaque", ""};
                compteur++;
                break;

            case 13 :
                fleche = 1;
                placementFleche = new int[]{160, 355};
                explicationsTuto = new String[]{" ", "Maintenant son effet,", "On sait que c'est une attaque,", "Ici on indique de combien l'investissement augmente l'attaque", ""};
                compteur++;
                break;

            case 14 :
                fleche = 1;
                placementFleche = new int[]{160, 425};
                explicationsTuto = new String[]{" ", "Le vol de l'ange possède aussi 2 effets supplémentaires,", "Pour 5 points de force supplémentaires, elle permet d'avancer d'une case", "Et pour 3, d'augmenter sa défense de 5", ""};
                compteur++;
                break;

            case 15 :
                explicationsTuto = new String[]{" ", "Attention", "Activer ces effets compte dans l'investissement total de la carte", ""};
                compteur++;
                break;

            case 16 :
                placementFleche = new int[]{155, 548};
                explicationsTuto = new String[]{" ", "Ici le niveau de la carte","Au maximum, vous ne pouvez investir que jusqu'à 10 fois", "le niveau d'une carte, effets supplémentaires compris", ""};
                compteur++;
                break;

            case 17 :
                fleche = 2;
                placementFleche = new int[]{720, 548};
                explicationsTuto = new String[]{" ", "Et enfin, on trouve ici son côut", "Vous ne pouvez jouer par tour qu'un nombre de carte"
                        ,"dont le coût total ne dépasse pas votre adresse /10", ""};
                compteur++;
                break;

            case 18 :
                fleche = 0;
                message = "";
                defendre.addActionListener(this);
                plusInvest.addActionListener(this);
                moinsInvest.addActionListener(this);
                boutonInvest.addActionListener(this);
                defendre.setBounds(280, 500 , 65, 35);
                this.add(defendre);
                explicationsTuto = new String[]{" ", "Bien, essayons d'utiliser cette carte,", "Votre portée est de 4, pas besoin d'avancer",
                        "Par contre se défendre est important, cochez donc la case ","du 2ème effet...", ""};
                compteur++;
                break;

            case 20 :
                explicationsTuto[0] = "";
                afficherCarte = false;
                message = "Test";
                break;
        }
    }

//    ************************************ Gestion des boutons ***************************
    public void afficherCarte(){
        this.removeAll();
        afficherMain = false;
        afficherCarte = true;
        compteur++;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        System.out.println(actionsCarte[0]);
        if(source == defendre && defendre.getText().equals("3")){
            this.removeAll();
            defendre.setText("Actif");
            actionsCarte[2] = 3;
            explicationsTuto = new String[]{" ", "Maintenant votre carte augmentera votre défense de 5",
                    "C'est une carte niveau 3, vous pouvez donc investir 30 points",
                    "moins 3 pour l'effet supplémentaire, il reste 27 points",
                    "Sélectionnez maintenant un investissement pour l'attaque",
                    "27 par exemple"};
            placementBoutons();

        } else if(source == plusInvest && actionsCarte[0] < 27){
            this.removeAll();
            actionsCarte[0]++;
            placementBoutons();

        }else if(source == moinsInvest && actionsCarte[0] > 0) {
            this.removeAll();
            actionsCarte[0]--;
            placementBoutons();
        } else if(source == boutonInvest && actionsCarte[0] == 27) {
            this.removeAll();
            explicationsTuto = new String[]{" ", "Parfait, ",
                    "Maintenant lançons l'attaque!"};
            compteur++;
        }
    }

    private void placementBoutons(){
        boutonInvest.setText("" + actionsCarte[0]);
        defendre.setBounds(280, 500 , 65, 35);
        plusInvest.setBounds(370, 550 , 45, 35);
        moinsInvest.setBounds(550, 550 , 45, 35);
        boutonInvest.setBounds(445, 550 , 75, 35);

        this.add(plusInvest);
        this.add(moinsInvest);
        this.add(boutonInvest);
        this.add(defendre);
    }

//    **************************************************************************************

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
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
