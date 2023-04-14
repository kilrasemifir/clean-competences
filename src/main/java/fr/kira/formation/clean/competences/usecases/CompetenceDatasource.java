package fr.kira.formation.clean.competences.usecases;

import fr.kira.formation.clean.competences.entities.Competence;

import java.util.List;

public interface CompetenceDatasource {
    List<Competence> findAll();
}
