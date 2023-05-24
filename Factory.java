import java.util.Scanner;

public class Factory {
    public static void Choice() {
        int algo;
        System.out.println("Que voulais vous faire. Choissisez selon le numéro");
        System.out.println("1. Coder un mot de passe \n2. Décoder un mot de passe");
        Scanner a = new Scanner(System.in);        
        int choix=a.nextInt();
        switch(choix){
            case 1: 
                System.out.println("Vous voulez coder un mot de passe. \nQuel algo souhaitez vous utiliser ?");
                System.out.println("1. Attaque par dictionnaire \n2. BruteForce");
                Scanner x = new Scanner(System.in); 
                algo = x.nextInt();
                switch(algo){
                    case 1: 
                    System.out.println("Vous voulez l'Attaque par dictionnaire");
                    PasswordBreakers.AttackDictionMDP();
                    break;
                    case 2:
                    System.out.println("Vous voulez BruteForce");
                    PasswordBreakers.BruteForceMDP();
                    break;
                    default:
                    System.out.println("Methode indisponible");
                    break;
                }
            break;
            case 2:
                System.out.println("Vous voulez décoder un mot de passe. \nQuel algo souhaitez vous utiliser ?");
                System.out.println("1. Attaque par dictionnaire \n2. BruteForce");
                Scanner z = new Scanner(System.in); 
                algo = z.nextInt();
                switch(algo){
                    case 1: 
                    System.out.println("Vous voulez l'Attaque par dictionnaire");
                    PasswordBreakers.AttackDictionHash();
                    break;
                    case 2:
                    System.out.println("Vous voulez BruteForce");
                    PasswordBreakers.BruteForceHash();
                    break;
                    default:
                    System.out.println("Methode indisponible");
                    break;
                }
            break;
            default:
                System.out.println("Choix indisponible");
            break;
        }
    }  
}
