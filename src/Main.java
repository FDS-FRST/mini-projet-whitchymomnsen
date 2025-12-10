import java.util.Scanner;

public class Main {

    public static Personnage[] createPersonnage(){
        Scanner sc = new Scanner(System.in);
        Personnage[] personnagesForPlayer = new Personnage[3];
        for(int i = 0; i < 3; i++){
            System.out.print("Nom du personnage " + (i+1) + " : ");
            String name = sc.nextLine();
            personnagesForPlayer[i] = new Personnage(name);
        }
        return personnagesForPlayer;
    }
    public static Personnage choseByNumber(Scanner sc, Personnage[] equipe, String nomJoueur, String message) {
        Personnage choixPerso = null;

        while (choixPerso == null) {
            System.out.println("\n" + nomJoueur + ", " + message);

            for (int i = 0; i < equipe.length; i++) {
                System.out.println((i + 1) + " : " + equipe[i].getNom()+
                        " (vie : " + equipe[i].getVie() + ")");
            }

            System.out.print("Numéro : ");

            if (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Entrez un numéro valide.");
                continue;
            }
            int num = sc.nextInt();
            sc.nextLine();

            if (num < 1 || num > equipe.length) {
                System.out.println("Numéro invalide.");
                continue;
            }
            if (!equipe[num - 1].estVivant()) {
                System.out.println("Ce personnage est déjà mort !");
                continue;
            }
            choixPerso = equipe[num - 1];
        }
        return choixPerso;
    }

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le jeu combat !\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Joueur 1, entre ton nom : ");
        String nameOfPLayer1 = sc.nextLine();
        System.out.print("Joueur 2, entre ton nom : ");
        String nameOfPLayer2 = sc.nextLine();

        System.out.println();
        System.out.println(nameOfPLayer1 + ", crée ton équipe");
        Personnage[] personnagesForPlayer1 = createPersonnage();
        Joueur joueur1 = new Joueur(nameOfPLayer1, personnagesForPlayer1);

        System.out.println();
        System.out.println(nameOfPLayer2 + ", crée ton équipe");
        Personnage[] personnagesForPlayer2 = createPersonnage();
        Joueur joueur2 = new Joueur(nameOfPLayer2, personnagesForPlayer2);

        int tour = 1;

        while(joueur1.aEncoreDesPersonnagesVivants() && joueur2.aEncoreDesPersonnagesVivants()){
            System.out.println();
            System.out.println("--- Tour "+tour+" ---");
            Personnage attaquant1 = choseByNumber(sc, personnagesForPlayer1, joueur1.getNom(), "choisis ton attaquant");
            Personnage target1 = choseByNumber(sc, personnagesForPlayer2, joueur1.getNom(), "choisis ta cible");

            attaquant1.attaquer(target1);
            System.out.println();
            System.out.println(joueur1.getNom() + " attaque " + target1.getNom());
            System.out.println(target1.getNom() + " perd 20 points de vie.");

            if (!joueur2.aEncoreDesPersonnagesVivants()) {
                break;
            }

            joueur1.afficherEquipe();
            System.out.println();
            joueur2.afficherEquipe();

            // Toour du joueur 2
            Personnage attaquant2 = choseByNumber(sc, personnagesForPlayer2, joueur2.getNom(), "choisis ton attaquant");
            Personnage cible2 = choseByNumber(sc, personnagesForPlayer1, joueur2.getNom(), "choisis ta cible");

            attaquant2.attaquer(cible2);
            System.out.println(joueur2.getNom() + " attaque " + cible2.getNom() + " !");
            System.out.println(cible2.getNom() + " perd 20 points de vie.");

            tour++;
        }

        System.out.println("\n==============================");
        System.out.println("          FIN DU JEU          ");
        System.out.println("==============================\n");

        if (joueur1.aEncoreDesPersonnagesVivants()) {
            System.out.println("🏆 Victoire de " + joueur1.getNom() + " !");
        } else {
            System.out.println("🏆 Victoire de " + joueur2.getNom() + " !");
        }

        sc.close();
    }
}