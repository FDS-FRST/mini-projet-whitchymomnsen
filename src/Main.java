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