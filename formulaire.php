<?php
  if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $login = $_POST['login'];
    $password = $_POST['password'];

    // Faire le traitement souhaité avec le login et le mot de passe
    // par exemple, vérifier les informations dans une base de données

    // Exemple de réponse :
    if ($login === 'beuguebakh' && $password === 'mouridesadikh') {

      $message = 'Connexion réussie !';

    } else {

      $message = 'Identifiants invalides. Veuillez réessayer.';
      
    }
   
    echo "<h3>$message</h3>";
  }
 
?>

