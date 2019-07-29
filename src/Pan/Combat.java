package Pan;

import Monstres.Monstres;
import Personnage.Personnage;

public interface Combat {
    public void attaquer(int puissance);
    public void defendre(int puissance);
    public void avancer(int nbrCase);
    public Personnage getPersonnage();
    public Monstres getMonstre();
    public void setMessage(String message);
    public void MAttaquer(int puissance);
    public void MDefendre(int puissance);
    public void MAvancer(int nbrCase);
}
