package Pan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Intro extends JPanel implements MouseListener {
    private int taille = 0;
    private Fenetre fen;
    private Timer timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            taille++;
            repaint();
            if(taille > 150){
                timer.stop();
            }
        }
    });

//    ******************************************* Constructeur **********************************************
    public Intro(Fenetre fen) {
        this.setBackground(Color.BLACK);
        this.fen = fen;
        addMouseListener(this);
        timer.start();
    }
//    ******************************************** Paint ****************************************************
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image img = new javax.swing.ImageIcon(getClass().getResource("/Images/logo.gif")).getImage();
        g.drawImage(img, this.getWidth()/2 - 140 - taille, this.getHeight()/2 - taille, taille * 4, taille * 2, this);
    }

//    ********************************************************************************************************
    @Override
    public void mousePressed(MouseEvent e) {
        if(taille < 150){
            taille = 150;
        } else {
            fen.suite();
        }
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
