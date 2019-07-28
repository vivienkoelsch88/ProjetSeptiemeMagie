package Pan.Introduction;


import Monstres.ChevalierNoirIntro;
import Narration.ReadStory;
import Pan.Fenetre;
import Pan.PanDialogue;
import Pan.PanelInterface;
import Personnage.Personnage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class PresentationPersonnages extends JPanel  implements KeyListener, ActionListener, MouseListener, PanelInterface {
    private Fenetre fen;
    private Personnage personnage;
    private String story [];
    private int SizeStory;
    private int defilementStory = 1500;
    private String fondEcran;
    private int compteurTimer = 0;

    private Timer timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            defilementStory = defilementStory - 2;
            switch (compteurTimer){
                case 200 :
                    fondEcran = "/Images/fondEcranPersonnage.jpg";
                    break;

                case 400 :
                    fondEcran = "/Narration/IntroPersonnage/demon.jpg";
                    break;
            }
            repaint();
            compteurTimer++;
            }
    });

//    ************************************** Constructeur ********************************
    public PresentationPersonnages(Fenetre fen) {
        this.personnage = new Personnage();
        this.fen = fen;
        this.fondEcran = "/Narration/IntroPersonnage/creation.jpg";
        this.addMouseListener(this);

        ReadStory readStory = null;
        try {
            readStory = new ReadStory("src\\Narration\\IntroPersonnage\\IntroPerso");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.story = readStory.getStory();
        this.SizeStory = readStory.getSize();
        timer.start();
    }

//    ************************************** Paint ******************************************
public void paintComponent(Graphics g){
    Image img = new javax.swing.ImageIcon(getClass().getResource(this.fondEcran)).getImage();
    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

    Font f = new Font ("Arial", Font.BOLD, 25);
    g.setFont(f);

    for (int i = 0; i < this.SizeStory; i++) {
        g.drawString(this.story[i], 50, this.defilementStory - i * 20);
    }
}

//************************************ Appel **************************************

    @Override
    public void appel() {
        JPanel combatIntro = new CombatIntro(this.fen, this.personnage, "/Narration/IntroPersonnage/incendie.jpg", new ChevalierNoirIntro());
        this.fen.setContentPane(combatIntro);
        this.fen.repaint();
        this.fen.getContentPane().revalidate();
    }

    //    ****************************************************************************************
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
//        if(this.compteurTimer >= 750){
        this.fen.setPanel(this);
            this.timer.stop();
            PanDialogue panDialogue = new PanDialogue("/Narration/IntroPersonnage/incendie.jpg", new String[]{"/Narration/IntroPersonnage/PersonnageDial.png", "/Narration/IntroPersonnage/ChevalierNoir.png"}, "src/Narration/IntroPersonnage/IntroDial", this);
            this.fen.setContentPane(panDialogue);
            this.fen.getContentPane().repaint();
            this.fen.getContentPane().revalidate();
//        }
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
