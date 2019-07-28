package Personnage;

import Cartes.Carte;
import Pan.Fenetre;

import java.util.ArrayList;

public class Personnage {
    //****************************** Attributs ***************************************
    private int life;
    private int concentration;
    private int force;
    private int adresse;
    private int charisme;

    private int attaque;
    private int defense;

    private String gif;
    private String[] icon;

    private ArrayList<Carte> deck = new ArrayList<>();

    //****************************** Constructeur ***************************************

    public Personnage() {
        this.life = 100;
        this.concentration = 30;
        this.force = 50;
        this.adresse = 50;
        this.charisme = 50;
        this.attaque = 20;
        this.defense = 10;

        this.icon = new String[]{"/Images/iconPersonnage.jpg"};
        this.gif = "/Images/PersonnageIcon.gif";

    }

//    ******************************** méthodes du deck ***********************************
    public void ajouterCarteAuDeck(Carte carte){
        this.deck.add(carte);
    }

//    *********************************** méthodes aventure *********************************
    public String afficherIcon(int vue){
        return this.icon[vue];
    }


//    ********************************** getter and setter ********************************

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getConcentration() {
        return concentration;
    }

    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getAdresse() {
        return adresse;
    }

    public void setAdresse(int adresse) {
        this.adresse = adresse;
    }

    public int getCharisme() {
        return charisme;
    }

    public void setCharisme(int charisme) {
        this.charisme = charisme;
    }

    public ArrayList<Carte> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Carte> deck) {
        this.deck = deck;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getGif() {
        return gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }
}
