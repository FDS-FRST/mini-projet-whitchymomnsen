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
    public static Personnage choisirParNumero(Scanner sc, Personnage[] equipe, String nomJoueur, String message) {
        Personnage choixPerso = null;

        while (choixPerso == null) {
            System.out.println("\n" + nomJoueur + ", " + message);

            for (int i = 0; i < equipe.length; i++) {
                System.out.println((i + 1) + ". ******** " +
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
            System.out.println("--- Tour "+tour+" ---");
            System.out.print(nameOfPLayer1 + " choisit ton attaquant : ");
            String attaquant = sc.nextLine();

            while(true){
                for (Personnage p : personnagesForPlayer1) {
                    if (p.getNom().equals(attaquant.trim())){
                        break;
                    }else {
                        System.out.print(nameOfPLayer1 + " choisit ton attaquant : ");
                        attaquant = sc.nextLine();
                    }
                }
            }

//           for  (Personnage p : personnagesForPlayer2) {
//                if (p.getVie() > 0 ){
//
//                }
//           }
        }

    }
}