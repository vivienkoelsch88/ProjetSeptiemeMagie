package Personnage;

import Personnage.Competences.Competence;
import Personnage.Competences.CompetencesPath;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoutonCompetence extends JButton implements ActionListener, MouseListener {
    private ArbreCompetence arbreCompetence;
    private Competence competence;

    public BoutonCompetence(String name, int arbre, int id, ArbreCompetence arbreCompetence, Personnage personnage) {
        super(name);
        this.arbreCompetence = arbreCompetence;
        this.addMouseListener(this);
        CompetencesPath competencesPath = new CompetencesPath();
        this.competence = competencesPath.competence(arbre, id, personnage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
