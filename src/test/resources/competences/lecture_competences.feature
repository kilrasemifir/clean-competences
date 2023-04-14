Feature: Lecture des compétences

  Scenario Outline: L'utilisateur peut voir la liste des l'ensemble des compétences
    Given L'application a sauvegardé les compétences "<competence1>", "<competence2>" et "<competence3>"
    When L'utilisateur demande de voir la liste des compétences
    Then Il voit les compétences "<competence1>", "<competence2>" et "<competence3>"
    Examples:
     | competence1 | competence2 | competence3 |
     | Java        | C#          | C++         |
     | JavaScript  | PHP         | Python      |

  Scenario Outline: L'utilisateur peut rechercher la liste des compétences par leurs nom
    Given L'application a sauvegardé les compétences "<competence1>", "<competence2>" et "<competence3>"
    When L'utilisateur demande de voir la liste des compétences avec le filtre "<filtre>"
    Then Il voit les compétences "<competence1>", "<competence2>"
    And Il ne voit pas la compétence "<competence3>"
    Examples:
     | competence1 | competence2 | competence3 | filtre |
     | Java        | Javascript          | C++         | Java    |
     | Typescript  | JavaScript          | Python      | Script  |

