package fr.kira.formation.clean.competences.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.kira.formation.clean.competences.entities.Competence;
import fr.kira.formation.clean.competences.usecases.competences.CompetenceDatasource;

import java.util.List;

public class CompetenceDatasourceMongoAdapter implements CompetenceDatasource {

    private final CompetenceRepository repository;
    private final ObjectMapper mapper;

    public CompetenceDatasourceMongoAdapter(CompetenceRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<Competence> findAll() {
        List<CompetenceEntity> entities = this.repository.findAll();
        return entities.stream().map(entity->mapper.convertValue(entity, Competence.class)).toList();
    }

    @Override
    public Competence save(Competence competence) {
        CompetenceEntity entity = this.repository.save(mapper.convertValue(competence, CompetenceEntity.class));

        return mapper.convertValue(entity, Competence.class);
    }
}
