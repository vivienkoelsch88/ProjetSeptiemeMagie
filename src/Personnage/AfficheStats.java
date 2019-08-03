package Personnage;

import Pan.PanelInterface;

import javax.swing.*;
import java.awt.*;

public class AfficheStats extends JComponent {
    private Personnage personnage;
    private PanelInterface panelInterface;

    public AfficheStats(Personnage personnage, PanelInterface panelInterface) {
        this.personnage = personnage;
        this.panelInterface = panelInterface;
        this.setSize(800, 700);
    }



    public void paintComponent(Graphics g) {
        g.setColor((Color.GRAY));
        g.fillRoundRect(5, 5, this.getWidth() / 4, this.getHeight() / 4, 5, 5);
        Font font = new Font("desc", Font.BOLD, 15);
        g.setFont(font);
        g.setColor((Color.WHITE));
        g.drawString("Concentration : " + this.personnage.getConcentration(), 15, 30);
        g.drawString("Adresse : " + this.personnage.getAdresse(), 15, 50);
        g.drawString("Charisme : " + this.personnage.getCharisme(), 15, 70);
        g.drawString("Force : " + this.personnage.getForce(), 15, 90);
        g.drawString("Attaque : " + this.personnage.getAttaque() + "  Défense : " + (this.personnage.getDefense()), 15, 110);
        g.drawString("Portée : " + this.personnage.getPortee(), 15, 130);
        g.drawString("Vie : " + this.personnage.getLife(), 15, 150);
    }
}
