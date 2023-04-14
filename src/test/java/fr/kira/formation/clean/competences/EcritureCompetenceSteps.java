package fr.kira.formation.clean.competences;

import fr.kira.formation.clean.competences.entities.Competence;
import fr.kira.formation.clean.competences.usecases.CompetenceDatasource;
import fr.kira.formation.clean.competences.usecases.CompetenceEcritureSerive;
import fr.kira.formation.clean.competences.usecases.impl.CompetenceEcritureServiceImpl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

public class EcritureCompetenceSteps {
    Competence competence;
    CompetenceEcritureSerive serive;
    CompetenceDatasource datasource;
    Competence resultat;

    @Given("L'utilisateur creer une competence avec le nom {string}")
    public void lUtilisateurCreerUneCompetenceAvecLeNom(String arg0) {
        competence = new Competence();
        competence.setNom(arg0);
        datasource = Mockito.spy(CompetenceDatasource.class);
        Mockito.when(datasource.save(competence)).thenReturn(competence);
        serive = new CompetenceEcritureServiceImpl(datasource);
    }

    @Given("La compétence {string} possède le nom {string}")
    public void laCompétencePossèdeLeNom(String id, String nom) {
        competence = new Competence();
        competence.setNom(nom);
        competence.setId(id);
        datasource = Mockito.spy(CompetenceDatasource.class);
        Mockito.when(datasource.save(Mockito.any())).thenAnswer(args->args.getArguments()[0]);
        serive = new CompetenceEcritureServiceImpl(datasource);
    }


    @When("L'utilisateur modifier la competence {string} avec le nom {string}")
    public void lUtilisateurModifierLaCompetenceAvecLeNom(String id, String nom) {
        resultat = serive.updateNom(id, nom);
    }

    @When("Il demande la sauvegarde")
    public void ilDemandeLaSauvegarde() {
        resultat = serive.create(competence);
    }

    @Then("La compétence est sauvegardée")
    public void laCompetenceEstSauvegardee() {
        Mockito.verify(datasource, Mockito.times(1)).save(Mockito.any());
    }

    @And("Le nom est sauvegardé en minuscule {string}")
    public void leNomEstSauvegardéEnMinuscule(String arg0) {
        assertEquals(arg0, resultat.getNom());
    }



    @Then("la competence possède le nom {string}")
    public void laCompetencePossèdeLeNom(String arg0) {
        assertEquals(arg0, resultat.getNom());
    }

}
