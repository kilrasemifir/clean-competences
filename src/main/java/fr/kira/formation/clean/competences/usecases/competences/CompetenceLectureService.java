package fr.kira.formation.clean.competences.usecases.competences;

import fr.kira.formation.clean.competences.entities.Competence;

import java.util.List;

public interface CompetenceLectureService {
    /**
     * Retourne la liste de l'ensemble des compétences
     * @return la liste de l'ensemble des compétences
     */
    List<Competence> findAll();

    /**
     * Retourne la liste des compétences dont le nom correspond au filtre
     * @param nom le filtre
     * @return la liste des compétences dont le nom correspond au filtre
     */
    List<Competence> findAllByNom(String nom);
}
