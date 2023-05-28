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

        String loginUrl = "http://localhost/FormulairePhp/formulaire.php";

        Scanner scanner = new Scanner(System.in);

        System.out.print("LOGIN : ");
        String login = scanner.nextLine();

        System.out.print("PASSWORD : ");
        String password = scanner.nextLine();

        String postData = "login=" + login + "&password=" + password;
        byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);

         // Ignorer la vérification du certificat SSL
        // HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);


        URL url = new URL(loginUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        
        if (responseCode == HttpURLConnection.HTTP_OK) {
            Scanner responseScanner = new Scanner(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();

            while (responseScanner.hasNextLine()) {
                response.append(responseScanner.nextLine());
            }

            
            String message = response.toString();

            if (message.equals("Connexion réussie !")) {
                System.out.println("Connexion réussie !");
            } else {
                System.out.println(message);
            }

            responseScanner.close();
        }
        conn.disconnect();

    }
}