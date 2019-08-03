package Pan.Introduction.BoutonIntro;

import Pan.Combat;
import Pan.Introduction.CombatIntro;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoutonCarte extends AbstractAction {
    private Combat pan;
    private int id;

    public BoutonCarte(Combat pan) {
        super("Carte");
        this.pan = pan;
    }

    public BoutonCarte(Combat pan, String name, int id) {
        super(name);
        this.pan = pan;
        this.id = id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.pan.afficherCarte(id);
    }

}