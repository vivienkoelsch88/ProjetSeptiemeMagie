package Pan.Introduction.BoutonIntro;

import Pan.Combat;
import Pan.Introduction.CombatIntro;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoutonCarte extends AbstractAction {
    private Combat pan;

    public BoutonCarte(Combat pan) {
        super("Carte");
        this.pan = pan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.pan.afficherCarte();
    }

}