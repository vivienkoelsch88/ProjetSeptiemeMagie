package Pan.Introduction.BoutonIntro;

import Pan.Introduction.CombatIntro;
import Pan.PanelInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoutonCarte extends AbstractAction {
    private CombatIntro pan;

    public BoutonCarte(CombatIntro pan) {
        super("Carte");
        this.pan = pan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.pan.afficherCarte();
    }

}