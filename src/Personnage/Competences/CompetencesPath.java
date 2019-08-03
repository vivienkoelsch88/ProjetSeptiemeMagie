package Personnage.Competences;

import Personnage.Competences.Magie.Competence1Magie;
import Personnage.Personnage;

 public class CompetencesPath {
    public Competence competence(int arbre, int id, Personnage personnage){
        switch (arbre){
            case 1 :
                switch (id){
                    case 1 :
                        return new Competence1Magie(personnage);
                }
                break;
        }
        return null;
    }
}
