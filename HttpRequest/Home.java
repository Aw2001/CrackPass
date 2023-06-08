import java.util.Scanner;

public class Home {

    public static void main(String[] args) throws Exception {

        char[] chaine = new char[5];
        int position = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("*******************************");
        System.out.println("Bienvenue dans notre plateforme");
        System.out.println("*******************************");
        System.out.println("");
        System.out.println("Choisir le type d'attaque :\n 1°) Brute Force\n 2°) Attaque par dictionnaire");
        System.out.print("Option: ");
        int choix = scanner.nextInt();

        // Si l'utilisateur choisit la méthode brute force
        if (choix == 1) {
            long tempsDebut = System.currentTimeMillis(); // Mesure du temps de début
            try {
                String passwordTrouve = Factory.bruteForceCracker(chaine, position);
                if (passwordTrouve != null) {
                    System.out.println("Bye");
                } else {
                    System.out.println("Mot de passe non trouvé : " + passwordTrouve);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            long tempsFin = System.currentTimeMillis(); // Mesure du temps de fin
            long tempsExecution = tempsFin - tempsDebut; // Calcul du temps d'exécution en millisecondes
            System.out.println("Temps d'exécution : " + tempsExecution + " ms");
        }
        // Si l'utilisateur choisit la méthode attaque par dictionnaire
        else if (choix == 2) {
            try {
                String passwordTrouve = Factory.AttackDictionMDP();
                if (passwordTrouve != null) {
                    System.out.println("Bye");
                } else {
                    System.out.println("Mot de passe non trouvé : " + passwordTrouve);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // S'il choisit autre chose
        else {
            System.out.println("Veuillez faire un choix entre 1 et 2");
        }
    }
}
