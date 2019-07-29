package Cartes.Force;

import Cartes.Carte;
import Pan.Combat;

public class VolDeLange extends Carte {

    public VolDeLange() {
        super("force", 3, 2, "/Cartes/ImageCartes/Cartedebase.png", "Vol de l\'ange", "attaque", 5, 3, "epee");
    }

    @Override
    public void utilisation(boolean effet1, boolean effet2, int invest, Combat combat) {
        int investTotal = invest;
        if(effet1){
            combat.avancer(1);
            investTotal = investTotal + 5;
        }
        if(effet2){
            combat.defendre(5);
            investTotal = investTotal + 3;
        }
        combat.getPersonnage().modifForce(investTotal * -1);
        combat.attaquer(invest*2);


    }
}
