package fr.kira.formation.clean.competences.usecases.competences;

import fr.kira.formation.clean.competences.entities.Competence;

public interface CompetenceEcritureSerive {

    Competence create(Competence competence);

    Competence updateNom(String id, String nom);
}
