package Cartes;

import Pan.Combat;

public abstract class Carte {
    private String Attribut;
    private int niveau;
    private int cout;
    private String image;
    private String name;
    private String type;
    private int coutEffet1;
    private int coutEffet2;
    private String symbole;

    public Carte(String attribut, int niveau, int cout, String image, String name, String type, int coutEffet1, int coutEffet2, String symbole) {
        Attribut = attribut;
        this.niveau = niveau;
        this.cout = cout;
        this.image = image;
        this.name = name;
        this.type = type;
        this.coutEffet1 = coutEffet1;
        this.coutEffet2 = coutEffet2;
        this.symbole = symbole;
    }

    public abstract void utilisation(boolean effet1, boolean effet2, int invest, Combat combat);

    public String getAttribut() {
        return Attribut;
    }

    public void setAttribut(String attribut) {
        Attribut = attribut;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCoutEffet1() {
        return coutEffet1;
    }

    public void setCoutEffet1(int coutEffet1) {
        this.coutEffet1 = coutEffet1;
    }

    public int getCoutEffet2() {
        return coutEffet2;
    }

    public void setCoutEffet2(int coutEffet2) {
        this.coutEffet2 = coutEffet2;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }
}
