Feature: Ecriture des Coompétences

  Scenario Outline: L'utilisateur sauvegarde une nouvelle competence.
    Given L'utilisateur creer une competence avec le nom "<nom>"
    When Il demande la sauvegarde
    Then La compétence est sauvegardée
    And Le nom est sauvegardé en minuscule "<minuscule>"
    Examples:
      | nom | minuscule |
        | Java | java |
        | C++ | c++ |
        | python | python |

  Scenario: L'utilisateur veut changer le nom d'une compétence.
    Given La compétence "java_id" possède le nom "Java"
    When L'utilisateur modifier la competence "java_id" avec le nom "Java17"
    Then la competence possède le nom "Java17"
    Then La compétence est sauvegardée
