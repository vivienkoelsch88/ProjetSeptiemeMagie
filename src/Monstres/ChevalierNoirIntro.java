package Monstres;

import Pan.Combat;

public class ChevalierNoirIntro extends Monstres {
    private int tourDeCombat = 1;

    public ChevalierNoirIntro() {
        super("/Narration/IntroPersonnage/gifChevalierNoir.gif", 100, 8, 15);
    }

    @Override
    public void patern(Combat combat) {
        switch (tourDeCombat){
            case 1 :
                combat.MAttaquer(150);
                combat.setMessage("Le chevalier se jette sur vous");
                break;
        }
        tourDeCombat++;
    }
}
