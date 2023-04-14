package fr.kira.formation.clean.competences;

import fr.kira.formation.clean.competences.entities.Competence;
import fr.kira.formation.clean.competences.usecases.competences.CompetenceDatasource;
import fr.kira.formation.clean.competences.usecases.competences.CompetenceLectureService;
import fr.kira.formation.clean.competences.usecases.competences.impl.CompetenceLectureServiceImpl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LectureCompetenceSteps {
    Competence competence1;
    Competence competence2;
    Competence competence3;
    CompetenceLectureService competenceLectureService;
    CompetenceDatasource datasource = Mockito.mock(CompetenceDatasource.class);
    List<Competence> resultList;
    List<Competence> resultListFiltre;

    @Given("L'application a sauvegardé les compétences {string}, {string} et {string}")
    public void lApplicationASauvegardéLesCompétencesEt(String competence1, String competence2, String competence3) {
        this.competence1 = new Competence();
        this.competence1.setNom(competence1);
        this.competence2 = new Competence();
        this.competence2.setNom(competence2);
        this.competence3 = new Competence();
        this.competence3.setNom(competence3);
        Mockito.when(datasource.findAll()).thenReturn(List.of(this.competence1, this.competence2, this.competence3));
        competenceLectureService = new CompetenceLectureServiceImpl(datasource);

    }

    @When("L'utilisateur demande de voir la liste des compétences")
    public void lUtilisateurDemandeDeVoirLaListeDesCompétences() {
        this.resultList = this.competenceLectureService.findAll();
    }

    @Then("Il voit les compétences {string}, {string} et {string}")
    public void ilVoitLesCompétencesEt(String competence1, String competence2, String competence3) {
        assertTrue(this.resultList.stream().anyMatch(c -> c.getNom().equals(competence1)));
        assertTrue(this.resultList.stream().anyMatch(c -> c.getNom().equals(competence2)));
        assertTrue(this.resultList.stream().anyMatch(c -> c.getNom().equals(competence3)));
    }

    @When("L'utilisateur demande de voir la liste des compétences avec le filtre {string}")
    public void lUtilisateurDemandeDeVoirLaListeDesCompétencesAvecLeFiltre(String filtre) {
        this.resultListFiltre = this.competenceLectureService.findAllByNom(filtre);
    }

    @Then("Il voit les compétences {string}, {string}")
    public void ilVoitLesCompétences(String competence1, String competence2) {
        assertTrue(this.resultListFiltre.stream().anyMatch(c -> c.getNom().equals(competence1)));
        assertTrue(this.resultListFiltre.stream().anyMatch(c -> c.getNom().equals(competence2)));
    }

    @And("Il ne voit pas la compétence {string}")
    public void ilNeVoitPasLaCompétence(String competence3) {
        assertFalse(this.resultListFiltre.stream().anyMatch(c -> c.getNom().equals(competence3)));
    }
}
