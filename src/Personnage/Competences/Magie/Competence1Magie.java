package Personnage.Competences.Magie;

import Cartes.Carte;
import Personnage.Competences.Competence;
import Personnage.Personnage;

public class Competence1Magie extends Competence {
    private Personnage personnage;
    private String desc;

    public Competence1Magie(Personnage personnage) {
        this.personnage = personnage;
        this.desc = "Le coût des actions secondaires  des cartes de magie sont réduient de 1";
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public void effet(Personnage personnage) {
        for (Carte carte:personnage.getDeck()) {
            if(carte.getSymbole().equals("magie")){

                carte.setCoutEffet1(carte.getCoutEffet1() - 1);
                if(carte.getCoutEffet1() < 0){
                    carte.setCoutEffet1(0);
                }

                carte.setCoutEffet2(carte.getCoutEffet2() - 1);
                if(carte.getCoutEffet2() < 0){
                    carte.setCoutEffet2(0);
                }
            }
        }
    }
}
