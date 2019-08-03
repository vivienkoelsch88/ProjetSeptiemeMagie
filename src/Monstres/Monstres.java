package Monstres;

import Pan.Combat;

public abstract class Monstres {
    public String gif;
    public int life;
    public int defense;
    public int attaque;


//    ****************** Constructeur *************************

    public Monstres(String gif, int life, int defense, int attaque) {
        this.gif = gif;
        this.life = life;
        this.defense = defense;
        this.attaque = attaque;
    }


//    ********************* méthodes de combat **************************************

    public int prendreDommage(int puissance){
        puissance = puissance - defense;
        if(puissance < 0){
            puissance = 0;
        }
        this.life = this.life - puissance;

        return puissance;
    }

    public abstract void patern(Combat combat);

//    ***********************************************************************************

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getGif() {
        return gif;
    }

    public abstract String getName();
}
