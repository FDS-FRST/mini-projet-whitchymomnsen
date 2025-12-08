import java.util.Scanner;

public class Main {

    public static Personnage[] gatherPersonnages(){
        Scanner sc = new Scanner(System.in);
        Personnage[] personnagesForPlayer = new Personnage[3];
        for(int i = 0; i < 3; i++){
            System.out.print("Nom du personnage " + (i+1) + " : ");
            String name = sc.nextLine();
            personnagesForPlayer[i] = new  Personnage(name);
//            personnagesForPlayer[i].setVie(100);
//            personnagesForPlayer[i].setAttaque(20);
        }
        return personnagesForPlayer;
    }

//    public static void displayPersonnageInfo(Personnage[] personnage){
//        for(int i = 0; i < 3; i++) {
//            System.out.println("Nom du personnage : " + personnage[i].getNom());
//            System.out.println("Vie : " + personnage[i].getVie());
//            System.out.println("Attaque : " + personnage[i].getAttaque());
//        }
//    }

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le jeu combat !\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Joueur 1, entre ton nom : ");
        String nameOfPLayer1 = sc.nextLine();
        System.out.print("Joueur 2, entre ton nom : ");
        String nameOfPLayer2 = sc.nextLine();

        System.out.println();
        System.out.println(nameOfPLayer1 + ", crée ton équipe");
        Personnage[] personnagesForPlayer1 = gatherPersonnages();


        System.out.println();
        System.out.println(nameOfPLayer2 + ", crée ton équipe");
        Personnage[] personnagesForPlayer2 = gatherPersonnages();


    }
}