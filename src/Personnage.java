public class Personnage {
    private String nom;
    private int vie;
    private int attaque;

    // Constructor
    public Personnage(String nom, int vie, int attaque) {
        this.nom = nom;
        this.vie = vie;
        this.attaque = attaque;
    }

    // Getters and Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    // Methods
    public void attaquer(Personnage personnage){
        personnage.setVie(personnage.getVie() - 20);
    }

    public boolean estVivant(){
        return this.vie != 0;
    }

    public String afficherEtat(){
        return ("Nom : " + this.nom + "\nVie : " + this.vie);
    }
}
