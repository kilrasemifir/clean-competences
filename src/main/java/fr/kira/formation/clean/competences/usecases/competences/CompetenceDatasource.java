package fr.kira.formation.clean.competences.usecases.competences;

import fr.kira.formation.clean.competences.entities.Competence;

import java.util.List;

public interface CompetenceDatasource {
    List<Competence> findAll();
    Competence save(Competence competence);
}
