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

        System.out.println();
        System.out.println(nameOfPLayer2 + ", crée ton équipe");
        Personnage[] personnagesForPlayer2 = createPersonnage();




    }
}