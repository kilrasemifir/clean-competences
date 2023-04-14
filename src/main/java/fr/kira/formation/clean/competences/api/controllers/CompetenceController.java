package fr.kira.formation.clean.competences.api.controllers;

import fr.kira.formation.clean.competences.entities.Competence;
import fr.kira.formation.clean.competences.usecases.competences.CompetenceEcritureSerive;
import fr.kira.formation.clean.competences.usecases.competences.CompetenceLectureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competences")
public class CompetenceController {

    private final CompetenceLectureService competenceLectureService;
    private final CompetenceEcritureSerive competenceEcritureSerive;

    public CompetenceController(CompetenceLectureService competenceLectureService, CompetenceEcritureSerive competenceEcritureSerive) {
        this.competenceLectureService = competenceLectureService;
        this.competenceEcritureSerive = competenceEcritureSerive;
    }

    @GetMapping
    public List<Competence> findAll() {
        return competenceLectureService.findAll();
    }

    @GetMapping("/nom/{nom}")
    public List<Competence> findAllByNom(@PathVariable String nom) {
        return competenceLectureService.findAllByNom(nom);
    }

    @PostMapping
    public Competence create(@RequestBody Competence competence) {
        return competenceEcritureSerive.create(competence);
    }

    @PutMapping("/{id}/nom/{nom}")
    public Competence updateNom(@PathVariable String id,@PathVariable String nom) {
        return competenceEcritureSerive.updateNom(id, nom);
    }
}
