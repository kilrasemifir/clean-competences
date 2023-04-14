package fr.kira.formation.clean.competences.usecases.competences.impl;

import fr.kira.formation.clean.competences.entities.Competence;
import fr.kira.formation.clean.competences.usecases.competences.CompetenceDatasource;
import fr.kira.formation.clean.competences.usecases.competences.CompetenceLectureService;

import java.util.List;

public class CompetenceLectureServiceImpl implements CompetenceLectureService {

    private final CompetenceDatasource datasource;

    public CompetenceLectureServiceImpl(CompetenceDatasource datasource) {
        this.datasource = datasource;
    }
    @Override
    public List<Competence> findAll() {
        return this.datasource.findAll();
    }

    @Override
    public List<Competence> findAllByNom(String nom) {
        return findAll().stream().filter(c -> c.getNom().toLowerCase().contains(nom.toLowerCase())).toList();
    }
}
