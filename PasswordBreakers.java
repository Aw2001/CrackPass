import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class PasswordBreakers {
    public static void AttackDictionMDP(){
        Scanner y = new Scanner(System.in);
        System.out.println("Entrer votre mot de passe: \n");
        //Le mot de passe saisi par l'utilisateur
        String PasswordAD = y.nextLine();
        File file = new File("dictionnaireH.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            boolean isPasswordFound = false;
            long TempsDebut = System.currentTimeMillis();
            while (scanner.hasNextLine()) {
                String MDP = scanner.nextLine();
                String[] elements = MDP.split(":");
                //Comparaison pour voir si c'est le bon mot de Passe
                if (elements.length == 2 && elements[0].equals(PasswordAD)) {
                    isPasswordFound = true;
                    System.out.println("Mot de passe trouvé !");
                    break;
                }
            }
            //Pour le temps d'éxecution
            long TempsFin = System.currentTimeMillis();
            long TempsMis = TempsFin - TempsDebut;
            if (isPasswordFound) {
                System.out.println("Bye");
            } else {
                System.out.println("Mot de passe non trouvé !");
            }
            System.out.println("Temps d'exécution : " + TempsMis + " ms");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erreur : Fichier introuvable !");
        }
    }

    public static void AttackDictionHash(){
        Scanner x = new Scanner(System.in);
        System.out.println("Entrer le Hash du mot de passe que vous voulez décrypter: \n");
        //Le Hash saisi par l'utilisateur
        String HashAD = x.nextLine();
        File file = new File("dictionnaireH.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            boolean isHashFound = false;
            long TempsDebut = System.currentTimeMillis();
            while (scanner.hasNextLine()) {
                String Hash = scanner.nextLine();
                String[] elements = Hash.split(":");
                //Comparaison pour voir si c'est le bon Hash
                if (elements.length == 2 && elements[1].equals(HashAD)) {
                    isHashFound = true;
                    String motDePasse = elements[0];
                    System.out.println("Hash trouvé !");
                    System.out.println("Mot de passe correspondant : " + motDePasse);
                    break;
                }
            }
            //Pour le temps d'éxecution
            long TempsFin = System.currentTimeMillis();
            long TempsFait = TempsFin - TempsDebut;
            if (isHashFound) {
                System.out.println("Bye.");
            } else {
                System.out.println("Hash non trouvé !");
            }
            System.out.println("Temps d'exécution : " + TempsFait + " ms");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erreur : Fichier introuvable !");
        }
    }

    public static void BruteForceMDP(){
        Scanner z = new Scanner(System.in);
        System.out.println("Entrer votre mot de passe: \n");
        String PasswordBF = z.nextLine();
    }

    public static void BruteForceHash(){
        Scanner w = new Scanner(System.in);
        System.out.println("Entrer le Hash du mot de passe que vous voulez décrypter: \n");
        String HashBF = w.nextLine();
    }
}
