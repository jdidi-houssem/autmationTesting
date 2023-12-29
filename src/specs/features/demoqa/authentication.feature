@tag
Feature: Création d'un compte
  ETQ utlisateur je veux créer un compte

  Background: 
    Given Je navigue sur l'app demoqa

  @register
  Scenario: [TC001]Création d'un compte avec des coordonnées valide
    And Je clique sur New User
    When je remplis la formulaire avec ces valeurs
      | Fields    | Values    |
      | firstName | Jdidi     |
      | lastName  | Houssem   |
      | userName  | houssem   |
      | password  | $Azerty24 |
    And je clique sur captcha
    And Je clique sur Register
    Then Une popUp affiche"User Register Successfully."

  @login
  Scenario: [TC002]Login avec des coordonnées valide
    When je remplis la formulaire avec les champs
      | Fields   | Values    |
      | userName | houssem   |
      | password | $Azerty24 |
    And Je clique sur Login
    Then Je me dirige vers la page profile

  @invalidUsername
  Scenario: [TC003]Authentification avec adresse email invalide
    When je remplis la formulaire avec les champs
      | Fields   | Values    |
      | userName | houssezem |
      | password | $Azerty24 |
    And Je clique sur Login
    Then Un message d'erreur s'affiche en rouge "Invalid username or password!"
