package fr.kira.formation.clean.competences.infra;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetenceRepository extends MongoRepository<CompetenceEntity, String> {
}
