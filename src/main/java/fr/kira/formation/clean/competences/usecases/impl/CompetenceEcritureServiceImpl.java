package fr.kira.formation.clean.competences.usecases.impl;

import fr.kira.formation.clean.competences.entities.Competence;
import fr.kira.formation.clean.competences.usecases.CompetenceDatasource;
import fr.kira.formation.clean.competences.usecases.CompetenceEcritureSerive;

public class CompetenceEcritureServiceImpl implements CompetenceEcritureSerive {

    private final CompetenceDatasource datasource;

    public CompetenceEcritureServiceImpl(CompetenceDatasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public Competence create(Competence competence) {
        competence.setNom(competence.getNom().toLowerCase());
        return this.datasource.save(competence);
    }

    @Override
    public Competence updateNom(String id, String nom) {
        Competence competence = new Competence();
        competence.setId(id);
        competence.setNom(nom);
        return this.datasource.save(competence);
    }
}
