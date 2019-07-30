package Pan;

import Pan.Boutons.BoutonVille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Map extends JPanel implements MouseListener, ActionListener {
    private Fenetre fen;
    private String fondEcran;
    private JButton villagePecheur = new BoutonVille("Village de pêcheurs", this, new int[]{240, 500});
    private String desc = "";
    private int[] emplacementDesc = {0, 0};

//    ************************************ Constructeur ***************************
    public Map(Fenetre fen) {
        this.fen = fen;
        this.fondEcran = "/Images/map.jpg";
        this.addMouseListener(this);
        this.fen.setMap(this);
    }

//    **************************************** Paint **********************************
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image img = new javax.swing.ImageIcon(getClass().getResource(fondEcran)).getImage();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

//        ********************* Description **************************
        if(desc.equals("")) {
        } else {
            Font font = new Font("desc", Font.BOLD, 25);
            g.setFont(font);
            g.setColor((Color.BLACK));
            g.drawString(desc, emplacementDesc[0] + 10, emplacementDesc[1] + 15 );
        }

        villagePecheur.setBounds(250, 545, 50, 40);
        this.add(villagePecheur);


    }


    @Override
    public void mousePressed(MouseEvent e) {
    }

//    *************************************************************************
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setEmplacementDesc(int[] emplacementDesc) {
        this.emplacementDesc = emplacementDesc;
    }
}
