package fr.kira.formation.clean.competences.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Competence {
    @Getter
    @Setter
    private String id;

    @Getter @Setter
    private String nom;

}
