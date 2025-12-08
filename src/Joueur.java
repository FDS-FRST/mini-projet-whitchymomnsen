public class Joueur{

    private String nom;
    private Personnage[] equipe;

    public Joueur(String nom, Personnage[] equipe) {
        this.nom = nom;
        this.equipe = equipe;
    }

    public Personnage choisirPersonnageVivant() {
        for (int i = 0; i < 3; i++) {
            if (this.equipe[i].getVie() < 0) {
                return this.equipe[i];
            }
        }
        return null;
    }

    public boolean aEncoreDesPersonnagesVivants(){
        for (int i = 0; i < 3; i++) {
            if (this.equipe[i].getVie() < 0) {
                return true;
            }
        }
        return false;
    }

    public void afficherEquipe(){
        for (int i = 0; i < 3; i++) {
            System.out.println("Etat de l'equipe de "+this.nom+" :");
            System.out.println(this.equipe[i].getNom()+" - " +this.equipe[i].getVie()+" HP");
        }
    }
}