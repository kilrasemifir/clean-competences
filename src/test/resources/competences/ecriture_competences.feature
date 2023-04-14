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
