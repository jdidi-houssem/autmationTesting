@smoke
Feature: Authentication
  ETQ utlisateur je veux m'authetifier

  Background: 
    Given Je navigue sur l'app AMAZON
    #And J'accepte les cookies
    And Je clique sur compte et listes

  @connexion
  Scenario: [TC001]Authentification avec des coordonnées valide
    When Je saisis l'email "jdidihoussem278@gmail.com"
    And Je clique sur continuer
    And Je saisis le mdp "azerty"
    And Je clique sur s'identifier
    Then Je me dirige vers la page d'accueil et "Jdidi"

  @cnxinvalidmail
  Scenario: [TC002]Authentification avec adresse email invalide
    When Je saisis l'email "5amsa@gmail.com"
    And Je clique sur continuer
    Then Un message d'erreur s'affiche "There was a problem"

  @connexionMultiple
  Scenario Outline: [TC003]Authentification avec données multiple
    When Je saisis l'email "<email>"
    And Je clique sur continuer
    And Je saisis le mdp "<mdp>"
    And Je clique sur s'identifier
    Then Je me dirige vers la page d'accueil et "<name>"

    Examples: 
      | email                       | mdp        | name    |
      | jdidihoussem278@gmail.com   | azerty     | houssem |
      | lindabellil1989@gmail.com   | Linda2023  | Linda   |
      | bouchagraouihadda@gmail.com | rima1995   | Hadda   |
      | raihana.chekir@hotmail.fr   | Hello+2024 | DERBEL  |
