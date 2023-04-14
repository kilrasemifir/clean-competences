package fr.kira.formation.clean.competences.infra;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class CompetenceEntity {
    @Id
    private String id;
    private String nom;
}
